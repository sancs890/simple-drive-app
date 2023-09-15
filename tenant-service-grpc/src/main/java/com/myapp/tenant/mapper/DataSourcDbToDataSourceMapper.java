package com.myapp.tenant.mapper;

import com.myapp.tenant.entity.DataSourceDb;
import com.myapp.tenant.shared.DataSource;
import org.springframework.stereotype.Component;

@Component
public class DataSourcDbToDataSourceMapper {
  public DataSource convert(DataSourceDb dataSourceDb) {
    DataSource dsource = DataSource.newBuilder()
                                   .setDriverClassName(dataSourceDb.getDriverClassName())
                                   .setTenantId(dataSourceDb.getTenantId())
                                   .setUsername(dataSourceDb.getUsername())
                                   .setPassword(dataSourceDb.getPassword())
                                   .setUrl(dataSourceDb.getUrl())
                                   .build();
    return dsource;
  }
}
