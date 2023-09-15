package com.myapp.tenant.mapper;

import com.myapp.tenant.entity.TenantDb;
import com.myapp.tenant.shared.CreateTenantRequest;
import org.springframework.stereotype.Component;

@Component
public class TenantRequestToTenantMapper {
  public TenantDb convert(CreateTenantRequest request) {
    TenantDb tenant = new TenantDb();
    tenant.setEmail(request.getEmail());
    tenant.setFirstName(request.getFirstName());
    tenant.setLastName(request.getLastName());
    tenant.setOrgName(request.getOrgName());
    tenant.setInstanceName(request.getInstanceName());
    return tenant;
  }
}
