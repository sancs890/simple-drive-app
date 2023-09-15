package com.myapp.tenant.repository;

import com.myapp.tenant.entity.DataSourceDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface DataSourceRepository extends JpaRepository<DataSourceDb, Integer> {

}
