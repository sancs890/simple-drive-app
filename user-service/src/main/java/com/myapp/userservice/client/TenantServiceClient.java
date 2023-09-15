package com.myapp.userservice.client;

import com.myapp.tenant.shared.CreateTenantRequest;
import com.myapp.tenant.shared.DataSource;
import com.myapp.tenant.shared.GetAllTenantResponse;
import com.myapp.tenant.shared.GetAllTenants;
import com.myapp.tenant.shared.TenantResponse;
import com.myapp.tenant.shared.TenantServiceGrpc;
import com.myapp.userservice.dto.TenantDto;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenantServiceClient {
  private final ManagedChannel managedChannel =
      ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();
  private final TenantServiceGrpc.TenantServiceBlockingStub tenantServiceBlockingStub =
      TenantServiceGrpc.newBlockingStub(this.managedChannel);

  public List<DataSource> getAllTenants() {
    GetAllTenants request = GetAllTenants.newBuilder().build();
    GetAllTenantResponse tenantResponse = this.tenantServiceBlockingStub.getAllTenants(request);
    return tenantResponse.getDataSourcesList();
  }

  public String createTenant(TenantDto tenantDto) {
    CreateTenantRequest request = CreateTenantRequest.newBuilder()
                                                     .setEmail(tenantDto.getEmail())
                                                     .setFirstName(tenantDto.getFirstName())
                                                     .setLastName(tenantDto.getLastName())
                                                     .setInstanceName(tenantDto.getInstanceName())
                                                     .setOrgName(tenantDto.getOrgName())
                                                     .build();
    TenantResponse response = this.tenantServiceBlockingStub.createTenant(request);
    return response.getMessage();
  }
}
