package com.myapp.tenant.repository;

import com.myapp.tenant.entity.TenantDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface TenantRepository extends JpaRepository<TenantDb, Integer> {
	TenantDb findByInstanceName(String instanceName);
}
