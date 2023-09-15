package com.myapp.tenant.mapper;

import com.myapp.tenant.entity.TenantDb;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TenantEntityRowMapper implements RowMapper<TenantDb> {
	public TenantDb mapRow(ResultSet rs, int rowNum) throws SQLException {

		TenantDb tenant = new TenantDb();
		tenant.setId(rs.getInt("id"));
		tenant.setEmail(rs.getString("email"));
		tenant.setOrgName(rs.getString("orgName"));
		tenant.setFirstName(rs.getString("firstName"));
		tenant.setLastName(rs.getString("lastName"));
		tenant.setInstanceName(rs.getString("instanceName"));

		return tenant;
	}
}