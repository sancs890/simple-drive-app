package com.myapp.tenant.service;


import com.myapp.tenant.shared.CreateTenantRequest;
import com.myapp.tenant.shared.GetAllTenantResponse;
import com.myapp.tenant.shared.GetAllTenants;
import com.myapp.tenant.shared.TenantResponse;
import com.myapp.tenant.shared.TenantServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class TenantServiceImpl extends TenantServiceGrpc.TenantServiceImplBase {

  @Autowired
  TenantService tenantService;

  @Override
  public void createTenant(CreateTenantRequest request, StreamObserver<TenantResponse> responseObserver) {
    this.tenantService.createTenant(request);
    TenantResponse tenantResponse = TenantResponse.newBuilder()
                                                  .setMessage("Tenant registered successfully!")
                                                  .build();
    responseObserver.onNext(tenantResponse);
    responseObserver.onCompleted();

  }

  @Override
  public void getAllTenants(GetAllTenants request, StreamObserver<GetAllTenantResponse> responseObserver) {
    GetAllTenantResponse response = GetAllTenantResponse.newBuilder()
                                                        .addAllDataSources(this.tenantService.getAllDataSources())
                                                        .build();
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

}
