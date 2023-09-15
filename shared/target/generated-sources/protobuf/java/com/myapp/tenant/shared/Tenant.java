// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: tenant.proto

package com.myapp.tenant.shared;

public final class Tenant {
  private Tenant() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_myapp_tenant_grpc_CreateTenantRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_myapp_tenant_grpc_CreateTenantRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_myapp_tenant_grpc_TenantResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_myapp_tenant_grpc_TenantResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_myapp_tenant_grpc_GetAllTenants_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_myapp_tenant_grpc_GetAllTenants_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_myapp_tenant_grpc_GetAllTenantResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_myapp_tenant_grpc_GetAllTenantResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_myapp_tenant_grpc_DataSource_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_myapp_tenant_grpc_DataSource_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\014tenant.proto\022\025com.myapp.tenant.grpc\"p\n" +
      "\023CreateTenantRequest\022\r\n\005email\030\001 \001(\t\022\017\n\007o" +
      "rgName\030\002 \001(\t\022\021\n\tfirstName\030\003 \001(\t\022\020\n\010lastN" +
      "ame\030\004 \001(\t\022\024\n\014instanceName\030\005 \001(\t\"!\n\016Tenan" +
      "tResponse\022\017\n\007message\030\001 \001(\t\"\017\n\rGetAllTena" +
      "nts\"N\n\024GetAllTenantResponse\0226\n\013dataSourc" +
      "es\030\001 \003(\0132!.com.myapp.tenant.grpc.DataSou" +
      "rce\"t\n\nDataSource\022\n\n\002id\030\001 \001(\005\022\020\n\010tenantI" +
      "d\030\002 \001(\t\022\013\n\003url\030\003 \001(\t\022\020\n\010username\030\004 \001(\t\022\020" +
      "\n\010password\030\005 \001(\t\022\027\n\017driverClassName\030\006 \001(" +
      "\t2\332\001\n\rTenantService\022c\n\014createTenant\022*.co" +
      "m.myapp.tenant.grpc.CreateTenantRequest\032" +
      "%.com.myapp.tenant.grpc.TenantResponse\"\000" +
      "\022d\n\rgetAllTenants\022$.com.myapp.tenant.grp" +
      "c.GetAllTenants\032+.com.myapp.tenant.grpc." +
      "GetAllTenantResponse\"\000B\033\n\027com.myapp.tena" +
      "nt.sharedP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_com_myapp_tenant_grpc_CreateTenantRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_myapp_tenant_grpc_CreateTenantRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_myapp_tenant_grpc_CreateTenantRequest_descriptor,
        new java.lang.String[] { "Email", "OrgName", "FirstName", "LastName", "InstanceName", });
    internal_static_com_myapp_tenant_grpc_TenantResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_myapp_tenant_grpc_TenantResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_myapp_tenant_grpc_TenantResponse_descriptor,
        new java.lang.String[] { "Message", });
    internal_static_com_myapp_tenant_grpc_GetAllTenants_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_com_myapp_tenant_grpc_GetAllTenants_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_myapp_tenant_grpc_GetAllTenants_descriptor,
        new java.lang.String[] { });
    internal_static_com_myapp_tenant_grpc_GetAllTenantResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_com_myapp_tenant_grpc_GetAllTenantResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_myapp_tenant_grpc_GetAllTenantResponse_descriptor,
        new java.lang.String[] { "DataSources", });
    internal_static_com_myapp_tenant_grpc_DataSource_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_com_myapp_tenant_grpc_DataSource_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_myapp_tenant_grpc_DataSource_descriptor,
        new java.lang.String[] { "Id", "TenantId", "Url", "Username", "Password", "DriverClassName", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}