package com.myapp.tenant.service;

import com.myapp.tenant.entity.DataSourceDb;
import com.myapp.tenant.entity.TenantDb;
import com.myapp.tenant.mapper.DataSourcDbToDataSourceMapper;
import com.myapp.tenant.mapper.TenantRequestToTenantMapper;
import com.myapp.tenant.mapper.TenantToDataSourcDbMapper;
import com.myapp.tenant.repository.DataSourceRepository;
import com.myapp.tenant.repository.TenantRepository;
import com.myapp.tenant.shared.CreateTenantRequest;
import com.myapp.tenant.shared.DataSource;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TenantService {
	@Autowired
	private TenantRequestToTenantMapper tenantMapper;

	@Autowired
	private TenantToDataSourcDbMapper dataSourceMapper;

	@Autowired
	private DataSourcDbToDataSourceMapper sourcDbToDataSourceMapper;

	@Autowired
	private DataSourceRepository dsourceRepository;

	@Autowired
	private TenantRepository tenantRepository;

	@Autowired
	private Flyway flyway;

	@Transactional
	public void createTenant(CreateTenantRequest request) {
		DataSourceDb dsource = this.dataSourceMapper.convert(request);
		this.dsourceRepository.save(dsource);

		TenantDb tenant = this.tenantMapper.convert(request);
		this.tenantRepository.save(tenant);

		Flyway fly = Flyway.configure()
				.configuration(this.flyway.getConfiguration())
				.schemas(request.getInstanceName())
				.defaultSchema(request.getInstanceName())
				.load();

		fly.migrate();
	}

	public List<DataSource> getAllDataSources() {
		List<DataSource> dataSourceList = new ArrayList<>();
		for(DataSourceDb dataSourceDb: this.dsourceRepository.findAll()) {
			dataSourceList.add(this.sourcDbToDataSourceMapper.convert(dataSourceDb));
		}
		return dataSourceList;
	}
}
