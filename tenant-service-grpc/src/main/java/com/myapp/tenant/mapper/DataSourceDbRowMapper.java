package com.myapp.tenant.mapper;

import com.myapp.tenant.entity.DataSourceDb;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DataSourceDbRowMapper implements RowMapper<DataSourceDb> {
  public DataSourceDb mapRow(ResultSet rs, int rowNum) throws SQLException {

    DataSourceDb dsource = new DataSourceDb();
    dsource.setId(rs.getInt("id"));
    dsource.setTenantId(rs.getString("tenantId"));
    dsource.setUrl(rs.getString("url"));
    dsource.setUsername(rs.getString("username"));
    dsource.setPassword(rs.getString("password"));
    dsource.setDriverClassName(rs.getString("driverClassName"));

    return dsource;
  }
}