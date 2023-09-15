package com.myapp.userservice.service;

import com.myapp.userservice.client.TenantServiceClient;
import com.myapp.userservice.dto.Dsource;
import com.myapp.userservice.dto.TenantDto;
import com.myapp.userservice.multitenancy.MultiTenancyJpaConfiguration;
import com.myapp.userservice.multitenancy.TenantContextHolder;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Service
public class TenantServiceImpl implements TenantService {

  @Autowired
  TenantServiceClient client;

  @Autowired
  private Map<String, DataSource> dataSourcesMtApp;

  @Value("${com.database.url}")
  private String databaseUrl;

  @Value("${com.database.user}")
  private String databaseUser;

  @Value("${com.database.password}")
  private String databasePassword;

  @Value("${com.database.driver}")
  private String databaseDriver;

  @Override
  public String register(TenantDto tenantDto) {
    List<com.myapp.tenant.shared.DataSource> dataSourceList = this.client.getAllTenants();

    for (com.myapp.tenant.shared.DataSource d : dataSourceList) {
      if (d.getTenantId().equalsIgnoreCase(tenantDto.getInstanceName())) {
				return "tenant already exists!";
      }
    }

    DataSourceBuilder<?> factory = DataSourceBuilder.create(MultiTenancyJpaConfiguration.class.getClassLoader())
                                                    .url(this.databaseUrl + tenantDto.getInstanceName())
                                                    .username(this.databaseUser)
                                                    .password(this.databasePassword).driverClassName(this.databaseDriver);
    HikariDataSource ds = (HikariDataSource) factory.build();
    ds.setKeepaliveTime(40000);
    ds.setMinimumIdle(1);
    ds.setMaxLifetime(45000);
    ds.setIdleTimeout(35000);
    this.dataSourcesMtApp.put(tenantDto.getInstanceName(), ds);
    TenantContextHolder.setTenantId(tenantDto.getInstanceName());
    return "tenant registered successfully!";
  }

}
