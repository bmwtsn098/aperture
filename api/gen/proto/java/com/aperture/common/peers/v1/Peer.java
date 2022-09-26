// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: aperture/common/peers/v1/peers.proto

package com.aperture.common.peers.v1;

/**
 * <pre>
 * Peer holds peer info and services.
 * </pre>
 *
 * Protobuf type {@code aperture.common.peers.v1.Peer}
 */
public final class Peer extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:aperture.common.peers.v1.Peer)
    PeerOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Peer.newBuilder() to construct.
  private Peer(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Peer() {
    address_ = "";
    hostname_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new Peer();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Peer(
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
            java.lang.String s = input.readStringRequireUtf8();

            address_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            hostname_ = s;
            break;
          }
          case 26: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              services_ = com.google.protobuf.MapField.newMapField(
                  ServicesDefaultEntryHolder.defaultEntry);
              mutable_bitField0_ |= 0x00000001;
            }
            com.google.protobuf.MapEntry<java.lang.String, java.lang.String>
            services__ = input.readMessage(
                ServicesDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
            services_.getMutableMap().put(
                services__.getKey(), services__.getValue());
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
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.aperture.common.peers.v1.PeersProto.internal_static_aperture_common_peers_v1_Peer_descriptor;
  }

  @SuppressWarnings({"rawtypes"})
  @java.lang.Override
  protected com.google.protobuf.MapField internalGetMapField(
      int number) {
    switch (number) {
      case 3:
        return internalGetServices();
      default:
        throw new RuntimeException(
            "Invalid map field number: " + number);
    }
  }
  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.aperture.common.peers.v1.PeersProto.internal_static_aperture_common_peers_v1_Peer_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.aperture.common.peers.v1.Peer.class, com.aperture.common.peers.v1.Peer.Builder.class);
  }

  public static final int ADDRESS_FIELD_NUMBER = 1;
  private volatile java.lang.Object address_;
  /**
   * <code>string address = 1[json_name = "address"];</code>
   * @return The address.
   */
  @java.lang.Override
  public java.lang.String getAddress() {
    java.lang.Object ref = address_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs =
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      address_ = s;
      return s;
    }
  }
  /**
   * <code>string address = 1[json_name = "address"];</code>
   * @return The bytes for address.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getAddressBytes() {
    java.lang.Object ref = address_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      address_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int HOSTNAME_FIELD_NUMBER = 2;
  private volatile java.lang.Object hostname_;
  /**
   * <code>string hostname = 2[json_name = "hostname"];</code>
   * @return The hostname.
   */
  @java.lang.Override
  public java.lang.String getHostname() {
    java.lang.Object ref = hostname_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs =
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      hostname_ = s;
      return s;
    }
  }
  /**
   * <code>string hostname = 2[json_name = "hostname"];</code>
   * @return The bytes for hostname.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getHostnameBytes() {
    java.lang.Object ref = hostname_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      hostname_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int SERVICES_FIELD_NUMBER = 3;
  private static final class ServicesDefaultEntryHolder {
    static final com.google.protobuf.MapEntry<
        java.lang.String, java.lang.String> defaultEntry =
            com.google.protobuf.MapEntry
            .<java.lang.String, java.lang.String>newDefaultInstance(
                com.aperture.common.peers.v1.PeersProto.internal_static_aperture_common_peers_v1_Peer_ServicesEntry_descriptor,
                com.google.protobuf.WireFormat.FieldType.STRING,
                "",
                com.google.protobuf.WireFormat.FieldType.STRING,
                "");
  }
  private com.google.protobuf.MapField<
      java.lang.String, java.lang.String> services_;
  private com.google.protobuf.MapField<java.lang.String, java.lang.String>
  internalGetServices() {
    if (services_ == null) {
      return com.google.protobuf.MapField.emptyMapField(
          ServicesDefaultEntryHolder.defaultEntry);
    }
    return services_;
  }

  public int getServicesCount() {
    return internalGetServices().getMap().size();
  }
  /**
   * <code>map&lt;string, string&gt; services = 3[json_name = "services"];</code>
   */

  @java.lang.Override
  public boolean containsServices(
      java.lang.String key) {
    if (key == null) { throw new java.lang.NullPointerException(); }
    return internalGetServices().getMap().containsKey(key);
  }
  /**
   * Use {@link #getServicesMap()} instead.
   */
  @java.lang.Override
  @java.lang.Deprecated
  public java.util.Map<java.lang.String, java.lang.String> getServices() {
    return getServicesMap();
  }
  /**
   * <code>map&lt;string, string&gt; services = 3[json_name = "services"];</code>
   */
  @java.lang.Override

  public java.util.Map<java.lang.String, java.lang.String> getServicesMap() {
    return internalGetServices().getMap();
  }
  /**
   * <code>map&lt;string, string&gt; services = 3[json_name = "services"];</code>
   */
  @java.lang.Override

  public java.lang.String getServicesOrDefault(
      java.lang.String key,
      java.lang.String defaultValue) {
    if (key == null) { throw new java.lang.NullPointerException(); }
    java.util.Map<java.lang.String, java.lang.String> map =
        internalGetServices().getMap();
    return map.containsKey(key) ? map.get(key) : defaultValue;
  }
  /**
   * <code>map&lt;string, string&gt; services = 3[json_name = "services"];</code>
   */
  @java.lang.Override

  public java.lang.String getServicesOrThrow(
      java.lang.String key) {
    if (key == null) { throw new java.lang.NullPointerException(); }
    java.util.Map<java.lang.String, java.lang.String> map =
        internalGetServices().getMap();
    if (!map.containsKey(key)) {
      throw new java.lang.IllegalArgumentException();
    }
    return map.get(key);
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
    if (!getAddressBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, address_);
    }
    if (!getHostnameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, hostname_);
    }
    com.google.protobuf.GeneratedMessageV3
      .serializeStringMapTo(
        output,
        internalGetServices(),
        ServicesDefaultEntryHolder.defaultEntry,
        3);
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getAddressBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, address_);
    }
    if (!getHostnameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, hostname_);
    }
    for (java.util.Map.Entry<java.lang.String, java.lang.String> entry
         : internalGetServices().getMap().entrySet()) {
      com.google.protobuf.MapEntry<java.lang.String, java.lang.String>
      services__ = ServicesDefaultEntryHolder.defaultEntry.newBuilderForType()
          .setKey(entry.getKey())
          .setValue(entry.getValue())
          .build();
      size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(3, services__);
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
    if (!(obj instanceof com.aperture.common.peers.v1.Peer)) {
      return super.equals(obj);
    }
    com.aperture.common.peers.v1.Peer other = (com.aperture.common.peers.v1.Peer) obj;

    if (!getAddress()
        .equals(other.getAddress())) return false;
    if (!getHostname()
        .equals(other.getHostname())) return false;
    if (!internalGetServices().equals(
        other.internalGetServices())) return false;
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
    hash = (37 * hash) + ADDRESS_FIELD_NUMBER;
    hash = (53 * hash) + getAddress().hashCode();
    hash = (37 * hash) + HOSTNAME_FIELD_NUMBER;
    hash = (53 * hash) + getHostname().hashCode();
    if (!internalGetServices().getMap().isEmpty()) {
      hash = (37 * hash) + SERVICES_FIELD_NUMBER;
      hash = (53 * hash) + internalGetServices().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.aperture.common.peers.v1.Peer parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.aperture.common.peers.v1.Peer parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.aperture.common.peers.v1.Peer parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.aperture.common.peers.v1.Peer parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.aperture.common.peers.v1.Peer parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.aperture.common.peers.v1.Peer parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.aperture.common.peers.v1.Peer parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.aperture.common.peers.v1.Peer parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.aperture.common.peers.v1.Peer parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.aperture.common.peers.v1.Peer parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.aperture.common.peers.v1.Peer parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.aperture.common.peers.v1.Peer parseFrom(
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
  public static Builder newBuilder(com.aperture.common.peers.v1.Peer prototype) {
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
   * <pre>
   * Peer holds peer info and services.
   * </pre>
   *
   * Protobuf type {@code aperture.common.peers.v1.Peer}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:aperture.common.peers.v1.Peer)
      com.aperture.common.peers.v1.PeerOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.aperture.common.peers.v1.PeersProto.internal_static_aperture_common_peers_v1_Peer_descriptor;
    }

    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMapField(
        int number) {
      switch (number) {
        case 3:
          return internalGetServices();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMutableMapField(
        int number) {
      switch (number) {
        case 3:
          return internalGetMutableServices();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.aperture.common.peers.v1.PeersProto.internal_static_aperture_common_peers_v1_Peer_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.aperture.common.peers.v1.Peer.class, com.aperture.common.peers.v1.Peer.Builder.class);
    }

    // Construct using com.aperture.common.peers.v1.Peer.newBuilder()
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
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      address_ = "";

      hostname_ = "";

      internalGetMutableServices().clear();
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.aperture.common.peers.v1.PeersProto.internal_static_aperture_common_peers_v1_Peer_descriptor;
    }

    @java.lang.Override
    public com.aperture.common.peers.v1.Peer getDefaultInstanceForType() {
      return com.aperture.common.peers.v1.Peer.getDefaultInstance();
    }

    @java.lang.Override
    public com.aperture.common.peers.v1.Peer build() {
      com.aperture.common.peers.v1.Peer result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.aperture.common.peers.v1.Peer buildPartial() {
      com.aperture.common.peers.v1.Peer result = new com.aperture.common.peers.v1.Peer(this);
      int from_bitField0_ = bitField0_;
      result.address_ = address_;
      result.hostname_ = hostname_;
      result.services_ = internalGetServices();
      result.services_.makeImmutable();
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
      if (other instanceof com.aperture.common.peers.v1.Peer) {
        return mergeFrom((com.aperture.common.peers.v1.Peer)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.aperture.common.peers.v1.Peer other) {
      if (other == com.aperture.common.peers.v1.Peer.getDefaultInstance()) return this;
      if (!other.getAddress().isEmpty()) {
        address_ = other.address_;
        onChanged();
      }
      if (!other.getHostname().isEmpty()) {
        hostname_ = other.hostname_;
        onChanged();
      }
      internalGetMutableServices().mergeFrom(
          other.internalGetServices());
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
      com.aperture.common.peers.v1.Peer parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.aperture.common.peers.v1.Peer) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.lang.Object address_ = "";
    /**
     * <code>string address = 1[json_name = "address"];</code>
     * @return The address.
     */
    public java.lang.String getAddress() {
      java.lang.Object ref = address_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        address_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string address = 1[json_name = "address"];</code>
     * @return The bytes for address.
     */
    public com.google.protobuf.ByteString
        getAddressBytes() {
      java.lang.Object ref = address_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        address_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string address = 1[json_name = "address"];</code>
     * @param value The address to set.
     * @return This builder for chaining.
     */
    public Builder setAddress(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }

      address_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string address = 1[json_name = "address"];</code>
     * @return This builder for chaining.
     */
    public Builder clearAddress() {

      address_ = getDefaultInstance().getAddress();
      onChanged();
      return this;
    }
    /**
     * <code>string address = 1[json_name = "address"];</code>
     * @param value The bytes for address to set.
     * @return This builder for chaining.
     */
    public Builder setAddressBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);

      address_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object hostname_ = "";
    /**
     * <code>string hostname = 2[json_name = "hostname"];</code>
     * @return The hostname.
     */
    public java.lang.String getHostname() {
      java.lang.Object ref = hostname_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        hostname_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string hostname = 2[json_name = "hostname"];</code>
     * @return The bytes for hostname.
     */
    public com.google.protobuf.ByteString
        getHostnameBytes() {
      java.lang.Object ref = hostname_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        hostname_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string hostname = 2[json_name = "hostname"];</code>
     * @param value The hostname to set.
     * @return This builder for chaining.
     */
    public Builder setHostname(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }

      hostname_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string hostname = 2[json_name = "hostname"];</code>
     * @return This builder for chaining.
     */
    public Builder clearHostname() {

      hostname_ = getDefaultInstance().getHostname();
      onChanged();
      return this;
    }
    /**
     * <code>string hostname = 2[json_name = "hostname"];</code>
     * @param value The bytes for hostname to set.
     * @return This builder for chaining.
     */
    public Builder setHostnameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);

      hostname_ = value;
      onChanged();
      return this;
    }

    private com.google.protobuf.MapField<
        java.lang.String, java.lang.String> services_;
    private com.google.protobuf.MapField<java.lang.String, java.lang.String>
    internalGetServices() {
      if (services_ == null) {
        return com.google.protobuf.MapField.emptyMapField(
            ServicesDefaultEntryHolder.defaultEntry);
      }
      return services_;
    }
    private com.google.protobuf.MapField<java.lang.String, java.lang.String>
    internalGetMutableServices() {
      onChanged();;
      if (services_ == null) {
        services_ = com.google.protobuf.MapField.newMapField(
            ServicesDefaultEntryHolder.defaultEntry);
      }
      if (!services_.isMutable()) {
        services_ = services_.copy();
      }
      return services_;
    }

    public int getServicesCount() {
      return internalGetServices().getMap().size();
    }
    /**
     * <code>map&lt;string, string&gt; services = 3[json_name = "services"];</code>
     */

    @java.lang.Override
    public boolean containsServices(
        java.lang.String key) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      return internalGetServices().getMap().containsKey(key);
    }
    /**
     * Use {@link #getServicesMap()} instead.
     */
    @java.lang.Override
    @java.lang.Deprecated
    public java.util.Map<java.lang.String, java.lang.String> getServices() {
      return getServicesMap();
    }
    /**
     * <code>map&lt;string, string&gt; services = 3[json_name = "services"];</code>
     */
    @java.lang.Override

    public java.util.Map<java.lang.String, java.lang.String> getServicesMap() {
      return internalGetServices().getMap();
    }
    /**
     * <code>map&lt;string, string&gt; services = 3[json_name = "services"];</code>
     */
    @java.lang.Override

    public java.lang.String getServicesOrDefault(
        java.lang.String key,
        java.lang.String defaultValue) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      java.util.Map<java.lang.String, java.lang.String> map =
          internalGetServices().getMap();
      return map.containsKey(key) ? map.get(key) : defaultValue;
    }
    /**
     * <code>map&lt;string, string&gt; services = 3[json_name = "services"];</code>
     */
    @java.lang.Override

    public java.lang.String getServicesOrThrow(
        java.lang.String key) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      java.util.Map<java.lang.String, java.lang.String> map =
          internalGetServices().getMap();
      if (!map.containsKey(key)) {
        throw new java.lang.IllegalArgumentException();
      }
      return map.get(key);
    }

    public Builder clearServices() {
      internalGetMutableServices().getMutableMap()
          .clear();
      return this;
    }
    /**
     * <code>map&lt;string, string&gt; services = 3[json_name = "services"];</code>
     */

    public Builder removeServices(
        java.lang.String key) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      internalGetMutableServices().getMutableMap()
          .remove(key);
      return this;
    }
    /**
     * Use alternate mutation accessors instead.
     */
    @java.lang.Deprecated
    public java.util.Map<java.lang.String, java.lang.String>
    getMutableServices() {
      return internalGetMutableServices().getMutableMap();
    }
    /**
     * <code>map&lt;string, string&gt; services = 3[json_name = "services"];</code>
     */
    public Builder putServices(
        java.lang.String key,
        java.lang.String value) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      if (value == null) { throw new java.lang.NullPointerException(); }
      internalGetMutableServices().getMutableMap()
          .put(key, value);
      return this;
    }
    /**
     * <code>map&lt;string, string&gt; services = 3[json_name = "services"];</code>
     */

    public Builder putAllServices(
        java.util.Map<java.lang.String, java.lang.String> values) {
      internalGetMutableServices().getMutableMap()
          .putAll(values);
      return this;
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


    // @@protoc_insertion_point(builder_scope:aperture.common.peers.v1.Peer)
  }

  // @@protoc_insertion_point(class_scope:aperture.common.peers.v1.Peer)
  private static final com.aperture.common.peers.v1.Peer DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.aperture.common.peers.v1.Peer();
  }

  public static com.aperture.common.peers.v1.Peer getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Peer>
      PARSER = new com.google.protobuf.AbstractParser<Peer>() {
    @java.lang.Override
    public Peer parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Peer(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Peer> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Peer> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.aperture.common.peers.v1.Peer getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
