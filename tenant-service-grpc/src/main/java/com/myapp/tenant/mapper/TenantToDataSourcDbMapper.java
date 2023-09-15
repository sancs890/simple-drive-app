package com.myapp.tenant.mapper;

import com.myapp.tenant.entity.DataSourceDb;
import com.myapp.tenant.shared.CreateTenantRequest;
import org.springframework.stereotype.Component;

@Component
public class TenantToDataSourcDbMapper {
  public DataSourceDb convert(CreateTenantRequest request) {
    DataSourceDb dsource = new DataSourceDb();
    dsource.setTenantId(request.getInstanceName());
    dsource.setUsername("postgres");
    dsource.setPassword("password123");
    dsource.setUrl(
        "jdbc:postgresql://localhost:5432/postgres?useSSL=false&currentSchema=" + request.getInstanceName());
    dsource.setDriverClassName("org.postgresql.Driver");
    return dsource;
  }
}
