package com.myapp.fileservice.client;

import com.myapp.tenant.shared.DataSource;
import com.myapp.tenant.shared.GetAllTenantResponse;
import com.myapp.tenant.shared.GetAllTenants;
import com.myapp.tenant.shared.TenantServiceGrpc;
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

}
