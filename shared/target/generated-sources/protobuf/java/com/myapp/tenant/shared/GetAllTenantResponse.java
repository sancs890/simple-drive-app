// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: tenant.proto

package com.myapp.tenant.shared;

/**
 * Protobuf type {@code com.myapp.tenant.grpc.GetAllTenantResponse}
 */
public final class GetAllTenantResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.myapp.tenant.grpc.GetAllTenantResponse)
    GetAllTenantResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GetAllTenantResponse.newBuilder() to construct.
  private GetAllTenantResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GetAllTenantResponse() {
    dataSources_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new GetAllTenantResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private GetAllTenantResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              dataSources_ = new java.util.ArrayList<com.myapp.tenant.shared.DataSource>();
              mutable_bitField0_ |= 0x00000001;
            }
            dataSources_.add(
                input.readMessage(com.myapp.tenant.shared.DataSource.parser(), extensionRegistry));
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        dataSources_ = java.util.Collections.unmodifiableList(dataSources_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.myapp.tenant.shared.Tenant.internal_static_com_myapp_tenant_grpc_GetAllTenantResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.myapp.tenant.shared.Tenant.internal_static_com_myapp_tenant_grpc_GetAllTenantResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.myapp.tenant.shared.GetAllTenantResponse.class, com.myapp.tenant.shared.GetAllTenantResponse.Builder.class);
  }

  public static final int DATASOURCES_FIELD_NUMBER = 1;
  private java.util.List<com.myapp.tenant.shared.DataSource> dataSources_;
  /**
   * <code>repeated .com.myapp.tenant.grpc.DataSource dataSources = 1;</code>
   */
  @java.lang.Override
  public java.util.List<com.myapp.tenant.shared.DataSource> getDataSourcesList() {
    return dataSources_;
  }
  /**
   * <code>repeated .com.myapp.tenant.grpc.DataSource dataSources = 1;</code>
   */
  @java.lang.Override
  public java.util.List<? extends com.myapp.tenant.shared.DataSourceOrBuilder> 
      getDataSourcesOrBuilderList() {
    return dataSources_;
  }
  /**
   * <code>repeated .com.myapp.tenant.grpc.DataSource dataSources = 1;</code>
   */
  @java.lang.Override
  public int getDataSourcesCount() {
    return dataSources_.size();
  }
  /**
   * <code>repeated .com.myapp.tenant.grpc.DataSource dataSources = 1;</code>
   */
  @java.lang.Override
  public com.myapp.tenant.shared.DataSource getDataSources(int index) {
    return dataSources_.get(index);
  }
  /**
   * <code>repeated .com.myapp.tenant.grpc.DataSource dataSources = 1;</code>
   */
  @java.lang.Override
  public com.myapp.tenant.shared.DataSourceOrBuilder getDataSourcesOrBuilder(
      int index) {
    return dataSources_.get(index);
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < dataSources_.size(); i++) {
      output.writeMessage(1, dataSources_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < dataSources_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, dataSources_.get(i));
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.myapp.tenant.shared.GetAllTenantResponse)) {
      return super.equals(obj);
    }
    com.myapp.tenant.shared.GetAllTenantResponse other = (com.myapp.tenant.shared.GetAllTenantResponse) obj;

    if (!getDataSourcesList()
        .equals(other.getDataSourcesList())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getDataSourcesCount() > 0) {
      hash = (37 * hash) + DATASOURCES_FIELD_NUMBER;
      hash = (53 * hash) + getDataSourcesList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.myapp.tenant.shared.GetAllTenantResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.myapp.tenant.shared.GetAllTenantResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.myapp.tenant.shared.GetAllTenantResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.myapp.tenant.shared.GetAllTenantResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.myapp.tenant.shared.GetAllTenantResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.myapp.tenant.shared.GetAllTenantResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.myapp.tenant.shared.GetAllTenantResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.myapp.tenant.shared.GetAllTenantResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.myapp.tenant.shared.GetAllTenantResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.myapp.tenant.shared.GetAllTenantResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.myapp.tenant.shared.GetAllTenantResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.myapp.tenant.shared.GetAllTenantResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.myapp.tenant.shared.GetAllTenantResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code com.myapp.tenant.grpc.GetAllTenantResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.myapp.tenant.grpc.GetAllTenantResponse)
      com.myapp.tenant.shared.GetAllTenantResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.myapp.tenant.shared.Tenant.internal_static_com_myapp_tenant_grpc_GetAllTenantResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.myapp.tenant.shared.Tenant.internal_static_com_myapp_tenant_grpc_GetAllTenantResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.myapp.tenant.shared.GetAllTenantResponse.class, com.myapp.tenant.shared.GetAllTenantResponse.Builder.class);
    }

    // Construct using com.myapp.tenant.shared.GetAllTenantResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getDataSourcesFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (dataSourcesBuilder_ == null) {
        dataSources_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        dataSourcesBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.myapp.tenant.shared.Tenant.internal_static_com_myapp_tenant_grpc_GetAllTenantResponse_descriptor;
    }

    @java.lang.Override
    public com.myapp.tenant.shared.GetAllTenantResponse getDefaultInstanceForType() {
      return com.myapp.tenant.shared.GetAllTenantResponse.getDefaultInstance();
    }

    @java.lang.Override
    public com.myapp.tenant.shared.GetAllTenantResponse build() {
      com.myapp.tenant.shared.GetAllTenantResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.myapp.tenant.shared.GetAllTenantResponse buildPartial() {
      com.myapp.tenant.shared.GetAllTenantResponse result = new com.myapp.tenant.shared.GetAllTenantResponse(this);
      int from_bitField0_ = bitField0_;
      if (dataSourcesBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          dataSources_ = java.util.Collections.unmodifiableList(dataSources_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.dataSources_ = dataSources_;
      } else {
        result.dataSources_ = dataSourcesBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.myapp.tenant.shared.GetAllTenantResponse) {
        return mergeFrom((com.myapp.tenant.shared.GetAllTenantResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.myapp.tenant.shared.GetAllTenantResponse other) {
      if (other == com.myapp.tenant.shared.GetAllTenantResponse.getDefaultInstance()) return this;
      if (dataSourcesBuilder_ == null) {
        if (!other.dataSources_.isEmpty()) {
          if (dataSources_.isEmpty()) {
            dataSources_ = other.dataSources_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureDataSourcesIsMutable();
            dataSources_.addAll(other.dataSources_);
          }
          onChanged();
        }
      } else {
        if (!other.dataSources_.isEmpty()) {
          if (dataSourcesBuilder_.isEmpty()) {
            dataSourcesBuilder_.dispose();
            dataSourcesBuilder_ = null;
            dataSources_ = other.dataSources_;
            bitField0_ = (bitField0_ & ~0x00000001);
            dataSourcesBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getDataSourcesFieldBuilder() : null;
          } else {
            dataSourcesBuilder_.addAllMessages(other.dataSources_);
          }
        }
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.myapp.tenant.shared.GetAllTenantResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.myapp.tenant.shared.GetAllTenantResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<com.myapp.tenant.shared.DataSource> dataSources_ =
      java.util.Collections.emptyList();
    private void ensureDataSourcesIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        dataSources_ = new java.util.ArrayList<com.myapp.tenant.shared.DataSource>(dataSources_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.myapp.tenant.shared.DataSource, com.myapp.tenant.shared.DataSource.Builder, com.myapp.tenant.shared.DataSourceOrBuilder> dataSourcesBuilder_;

    /**
     * <code>repeated .com.myapp.tenant.grpc.DataSource dataSources = 1;</code>
     */
    public java.util.List<com.myapp.tenant.shared.DataSource> getDataSourcesList() {
      if (dataSourcesBuilder_ == null) {
        return java.util.Collections.unmodifiableList(dataSources_);
      } else {
        return dataSourcesBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .com.myapp.tenant.grpc.DataSource dataSources = 1;</code>
     */
    public int getDataSourcesCount() {
      if (dataSourcesBuilder_ == null) {
        return dataSources_.size();
      } else {
        return dataSourcesBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .com.myapp.tenant.grpc.DataSource dataSources = 1;</code>
     */
    public com.myapp.tenant.shared.DataSource getDataSources(int index) {
      if (dataSourcesBuilder_ == null) {
        return dataSources_.get(index);
      } else {
        return dataSourcesBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .com.myapp.tenant.grpc.DataSource dataSources = 1;</code>
     */
    public Builder setDataSources(
        int index, com.myapp.tenant.shared.DataSource value) {
      if (dataSourcesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDataSourcesIsMutable();
        dataSources_.set(index, value);
        onChanged();
      } else {
        dataSourcesBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .com.myapp.tenant.grpc.DataSource dataSources = 1;</code>
     */
    public Builder setDataSources(
        int index, com.myapp.tenant.shared.DataSource.Builder builderForValue) {
      if (dataSourcesBuilder_ == null) {
        ensureDataSourcesIsMutable();
        dataSources_.set(index, builderForValue.build());
        onChanged();
      } else {
        dataSourcesBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.myapp.tenant.grpc.DataSource dataSources = 1;</code>
     */
    public Builder addDataSources(com.myapp.tenant.shared.DataSource value) {
      if (dataSourcesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDataSourcesIsMutable();
        dataSources_.add(value);
        onChanged();
      } else {
        dataSourcesBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .com.myapp.tenant.grpc.DataSource dataSources = 1;</code>
     */
    public Builder addDataSources(
        int index, com.myapp.tenant.shared.DataSource value) {
      if (dataSourcesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDataSourcesIsMutable();
        dataSources_.add(index, value);
        onChanged();
      } else {
        dataSourcesBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .com.myapp.tenant.grpc.DataSource dataSources = 1;</code>
     */
    public Builder addDataSources(
        com.myapp.tenant.shared.DataSource.Builder builderForValue) {
      if (dataSourcesBuilder_ == null) {
        ensureDataSourcesIsMutable();
        dataSources_.add(builderForValue.build());
        onChanged();
      } else {
        dataSourcesBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.myapp.tenant.grpc.DataSource dataSources = 1;</code>
     */
    public Builder addDataSources(
        int index, com.myapp.tenant.shared.DataSource.Builder builderForValue) {
      if (dataSourcesBuilder_ == null) {
        ensureDataSourcesIsMutable();
        dataSources_.add(index, builderForValue.build());
        onChanged();
      } else {
        dataSourcesBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.myapp.tenant.grpc.DataSource dataSources = 1;</code>
     */
    public Builder addAllDataSources(
        java.lang.Iterable<? extends com.myapp.tenant.shared.DataSource> values) {
      if (dataSourcesBuilder_ == null) {
        ensureDataSourcesIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, dataSources_);
        onChanged();
      } else {
        dataSourcesBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .com.myapp.tenant.grpc.DataSource dataSources = 1;</code>
     */
    public Builder clearDataSources() {
      if (dataSourcesBuilder_ == null) {
        dataSources_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        dataSourcesBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .com.myapp.tenant.grpc.DataSource dataSources = 1;</code>
     */
    public Builder removeDataSources(int index) {
      if (dataSourcesBuilder_ == null) {
        ensureDataSourcesIsMutable();
        dataSources_.remove(index);
        onChanged();
      } else {
        dataSourcesBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .com.myapp.tenant.grpc.DataSource dataSources = 1;</code>
     */
    public com.myapp.tenant.shared.DataSource.Builder getDataSourcesBuilder(
        int index) {
      return getDataSourcesFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .com.myapp.tenant.grpc.DataSource dataSources = 1;</code>
     */
    public com.myapp.tenant.shared.DataSourceOrBuilder getDataSourcesOrBuilder(
        int index) {
      if (dataSourcesBuilder_ == null) {
        return dataSources_.get(index);  } else {
        return dataSourcesBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .com.myapp.tenant.grpc.DataSource dataSources = 1;</code>
     */
    public java.util.List<? extends com.myapp.tenant.shared.DataSourceOrBuilder> 
         getDataSourcesOrBuilderList() {
      if (dataSourcesBuilder_ != null) {
        return dataSourcesBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(dataSources_);
      }
    }
    /**
     * <code>repeated .com.myapp.tenant.grpc.DataSource dataSources = 1;</code>
     */
    public com.myapp.tenant.shared.DataSource.Builder addDataSourcesBuilder() {
      return getDataSourcesFieldBuilder().addBuilder(
          com.myapp.tenant.shared.DataSource.getDefaultInstance());
    }
    /**
     * <code>repeated .com.myapp.tenant.grpc.DataSource dataSources = 1;</code>
     */
    public com.myapp.tenant.shared.DataSource.Builder addDataSourcesBuilder(
        int index) {
      return getDataSourcesFieldBuilder().addBuilder(
          index, com.myapp.tenant.shared.DataSource.getDefaultInstance());
    }
    /**
     * <code>repeated .com.myapp.tenant.grpc.DataSource dataSources = 1;</code>
     */
    public java.util.List<com.myapp.tenant.shared.DataSource.Builder> 
         getDataSourcesBuilderList() {
      return getDataSourcesFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.myapp.tenant.shared.DataSource, com.myapp.tenant.shared.DataSource.Builder, com.myapp.tenant.shared.DataSourceOrBuilder> 
        getDataSourcesFieldBuilder() {
      if (dataSourcesBuilder_ == null) {
        dataSourcesBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.myapp.tenant.shared.DataSource, com.myapp.tenant.shared.DataSource.Builder, com.myapp.tenant.shared.DataSourceOrBuilder>(
                dataSources_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        dataSources_ = null;
      }
      return dataSourcesBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:com.myapp.tenant.grpc.GetAllTenantResponse)
  }

  // @@protoc_insertion_point(class_scope:com.myapp.tenant.grpc.GetAllTenantResponse)
  private static final com.myapp.tenant.shared.GetAllTenantResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.myapp.tenant.shared.GetAllTenantResponse();
  }

  public static com.myapp.tenant.shared.GetAllTenantResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GetAllTenantResponse>
      PARSER = new com.google.protobuf.AbstractParser<GetAllTenantResponse>() {
    @java.lang.Override
    public GetAllTenantResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new GetAllTenantResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GetAllTenantResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GetAllTenantResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.myapp.tenant.shared.GetAllTenantResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
