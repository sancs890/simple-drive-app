package com.myapp.userservice.multitenancy;

import com.myapp.userservice.client.TenantServiceClient;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.Environment;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.hibernate.engine.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.myapp.userservice")
@Lazy
public class MultiTenancyJpaConfiguration {

  @Autowired
  private JpaProperties jpaProperties;

  @Autowired
  private RestTemplate rs;

  @Autowired
  private TenantServiceClient client;

  @Value("${tenant.service.api.get}")
  private String tenantGetApi;

  @Primary
  @Bean(name = "dataSourcesMtApp")
  public Map<String, DataSource> dataSourcesMtApp() {

    List<com.myapp.tenant.shared.DataSource> dataSourceList = this.client.getAllTenants();

    Map<String, DataSource> result = new HashMap<>();
    for (com.myapp.tenant.shared.DataSource source : dataSourceList) {
      DataSourceBuilder<?> factory = DataSourceBuilder.create().url(source.getUrl())
                                                      .username(source.getUsername()).password(source.getPassword())
                                                      .driverClassName(source.getDriverClassName());

      HikariDataSource ds = (HikariDataSource) factory.build();
      ds.setKeepaliveTime(40000);
      ds.setMinimumIdle(1);
      ds.setMaxLifetime(45000);
      ds.setIdleTimeout(35000);
      result.put(source.getTenantId(), ds);
    }

    return result;
  }

  @Bean
  public MultiTenantConnectionProvider multiTenantConnectionProvider() {
    return new DataSourceBasedMultiTenantConnectionProviderImpl();
  }

  @Bean
  public CurrentTenantIdentifierResolver currentTenantIdentifierResolver() {
    return new CurrentTenantIdentifierResolverImpl();
  }

  @Bean(name = "entityManagerFactoryBean")
  public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(
      AbstractDataSourceBasedMultiTenantConnectionProviderImpl multiTenantConnectionProvider,
      CurrentTenantIdentifierResolver currentTenantIdentifierResolver) {

    Map<String, Object> hibernateProps = new LinkedHashMap<>();
    hibernateProps.putAll(this.jpaProperties.getProperties());
    hibernateProps.put(Environment.MULTI_TENANT_CONNECTION_PROVIDER, multiTenantConnectionProvider);
    hibernateProps.put(Environment.MULTI_TENANT_IDENTIFIER_RESOLVER, currentTenantIdentifierResolver);
    hibernateProps.put("hibernate.hbm2ddl.auto", "update");
    hibernateProps.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
    LocalContainerEntityManagerFactoryBean result = new LocalContainerEntityManagerFactoryBean();
    result.setPackagesToScan("com.myapp.userservice");
    result.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
    result.setJpaPropertyMap(hibernateProps);

    return result;
  }

  @Bean
  @Primary
  public EntityManagerFactory entityManagerFactory(LocalContainerEntityManagerFactoryBean entityManagerFactoryBean) {
    return entityManagerFactoryBean.getObject();
  }

  @Bean
  public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
    return new JpaTransactionManager(entityManagerFactory);
  }
}