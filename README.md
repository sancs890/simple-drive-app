# simple-drive-app
tenant-service

Tenant Service provides APIs to create tenants and also an API to get all the tenants with data sources for the tenants.

Before starting the Tenant Service we need start the postgres at port 5432 with username - postgres and password - password123. If you're using docker

docker run -itd -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=password123 -p 5432:5432 -v /data:/var/lib/postgresql/data --name postgresql postgres

Then you can start the `tenant-service.

You can create the tenants as shown below.

<b>Request</b>

<code>
grpcurl --plaintext -d '{
    "email":"tenante@test.com",
    "orgName":"tenante",
    "firstName":"fire",
    "lastName":"client",
    "instanceName":"tenante"
}' localhost:9090 com.myapp.tenant.grpc.TenantService/createTenant

<code>

<b>Response</b>
<code> 
{
  "message": "Tenant registered successfully!"
}
</code>

Get All Tenant Connections Data
<b>Request</b>
<code> grpcurl --plaintext -d '{}' localhost:9090 com.myapp.tenant.grpc.TenantService/getAllTenants </code>

<b>Response </b>
<code>
{
  "dataSources": [
    {
      "tenantId": "tenantb",
      "url": "jdbc:postgresql://localhost:5432/postgres?useSSL=false\u0026currentSchema=tenantb",
      "username": "postgres",
      "password": "password123",
      "driverClassName": "org.postgresql.Driver"
    },
    {
      "tenantId": "tenanta",
      "url": "jdbc:postgresql://localhost:5432/postgres?useSSL=false\u0026currentSchema=tenanta",
      "username": "postgres",
      "password": "password123",
      "driverClassName": "org.postgresql.Driver"
    },
    {
      "tenantId": "tenantc",
      "url": "jdbc:postgresql://localhost:5432/postgres?useSSL=false\u0026currentSchema=tenantc",
      "username": "postgres",
      "password": "password123",
      "driverClassName": "org.postgresql.Driver"
    },
    {
      "tenantId": "tenantd",
      "url": "jdbc:postgresql://localhost:5432/postgres?useSSL=false\u0026currentSchema=tenantd",
      "username": "postgres",
      "password": "password123",
      "driverClassName": "org.postgresql.Driver"
    }
  ]
}
</code>

