// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: aperture/flowcontrol/v1/flowcontrol.proto

package com.aperture.flowcontrol.v1;

/**
 * <pre>
 * CheckRequest contains fields required to perform Check call.
 * </pre>
 *
 * Protobuf type {@code aperture.flowcontrol.v1.CheckRequest}
 */
public final class CheckRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:aperture.flowcontrol.v1.CheckRequest)
    CheckRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use CheckRequest.newBuilder() to construct.
  private CheckRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private CheckRequest() {
    feature_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new CheckRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private CheckRequest(
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

            feature_ = s;
            break;
          }
          case 18: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              labels_ = com.google.protobuf.MapField.newMapField(
                  LabelsDefaultEntryHolder.defaultEntry);
              mutable_bitField0_ |= 0x00000001;
            }
            com.google.protobuf.MapEntry<java.lang.String, java.lang.String>
            labels__ = input.readMessage(
                LabelsDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
            labels_.getMutableMap().put(
                labels__.getKey(), labels__.getValue());
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
    return com.aperture.flowcontrol.v1.FlowcontrolProto.internal_static_aperture_flowcontrol_v1_CheckRequest_descriptor;
  }

  @SuppressWarnings({"rawtypes"})
  @java.lang.Override
  protected com.google.protobuf.MapField internalGetMapField(
      int number) {
    switch (number) {
      case 2:
        return internalGetLabels();
      default:
        throw new RuntimeException(
            "Invalid map field number: " + number);
    }
  }
  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.aperture.flowcontrol.v1.FlowcontrolProto.internal_static_aperture_flowcontrol_v1_CheckRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.aperture.flowcontrol.v1.CheckRequest.class, com.aperture.flowcontrol.v1.CheckRequest.Builder.class);
  }

  public static final int FEATURE_FIELD_NUMBER = 1;
  private volatile java.lang.Object feature_;
  /**
   * <code>string feature = 1[json_name = "feature"];</code>
   * @return The feature.
   */
  @java.lang.Override
  public java.lang.String getFeature() {
    java.lang.Object ref = feature_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs =
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      feature_ = s;
      return s;
    }
  }
  /**
   * <code>string feature = 1[json_name = "feature"];</code>
   * @return The bytes for feature.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getFeatureBytes() {
    java.lang.Object ref = feature_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      feature_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int LABELS_FIELD_NUMBER = 2;
  private static final class LabelsDefaultEntryHolder {
    static final com.google.protobuf.MapEntry<
        java.lang.String, java.lang.String> defaultEntry =
            com.google.protobuf.MapEntry
            .<java.lang.String, java.lang.String>newDefaultInstance(
                com.aperture.flowcontrol.v1.FlowcontrolProto.internal_static_aperture_flowcontrol_v1_CheckRequest_LabelsEntry_descriptor,
                com.google.protobuf.WireFormat.FieldType.STRING,
                "",
                com.google.protobuf.WireFormat.FieldType.STRING,
                "");
  }
  private com.google.protobuf.MapField<
      java.lang.String, java.lang.String> labels_;
  private com.google.protobuf.MapField<java.lang.String, java.lang.String>
  internalGetLabels() {
    if (labels_ == null) {
      return com.google.protobuf.MapField.emptyMapField(
          LabelsDefaultEntryHolder.defaultEntry);
    }
    return labels_;
  }

  public int getLabelsCount() {
    return internalGetLabels().getMap().size();
  }
  /**
   * <code>map&lt;string, string&gt; labels = 2[json_name = "labels"];</code>
   */

  @java.lang.Override
  public boolean containsLabels(
      java.lang.String key) {
    if (key == null) { throw new java.lang.NullPointerException(); }
    return internalGetLabels().getMap().containsKey(key);
  }
  /**
   * Use {@link #getLabelsMap()} instead.
   */
  @java.lang.Override
  @java.lang.Deprecated
  public java.util.Map<java.lang.String, java.lang.String> getLabels() {
    return getLabelsMap();
  }
  /**
   * <code>map&lt;string, string&gt; labels = 2[json_name = "labels"];</code>
   */
  @java.lang.Override

  public java.util.Map<java.lang.String, java.lang.String> getLabelsMap() {
    return internalGetLabels().getMap();
  }
  /**
   * <code>map&lt;string, string&gt; labels = 2[json_name = "labels"];</code>
   */
  @java.lang.Override

  public java.lang.String getLabelsOrDefault(
      java.lang.String key,
      java.lang.String defaultValue) {
    if (key == null) { throw new java.lang.NullPointerException(); }
    java.util.Map<java.lang.String, java.lang.String> map =
        internalGetLabels().getMap();
    return map.containsKey(key) ? map.get(key) : defaultValue;
  }
  /**
   * <code>map&lt;string, string&gt; labels = 2[json_name = "labels"];</code>
   */
  @java.lang.Override

  public java.lang.String getLabelsOrThrow(
      java.lang.String key) {
    if (key == null) { throw new java.lang.NullPointerException(); }
    java.util.Map<java.lang.String, java.lang.String> map =
        internalGetLabels().getMap();
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
    if (!getFeatureBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, feature_);
    }
    com.google.protobuf.GeneratedMessageV3
      .serializeStringMapTo(
        output,
        internalGetLabels(),
        LabelsDefaultEntryHolder.defaultEntry,
        2);
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getFeatureBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, feature_);
    }
    for (java.util.Map.Entry<java.lang.String, java.lang.String> entry
         : internalGetLabels().getMap().entrySet()) {
      com.google.protobuf.MapEntry<java.lang.String, java.lang.String>
      labels__ = LabelsDefaultEntryHolder.defaultEntry.newBuilderForType()
          .setKey(entry.getKey())
          .setValue(entry.getValue())
          .build();
      size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(2, labels__);
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
    if (!(obj instanceof com.aperture.flowcontrol.v1.CheckRequest)) {
      return super.equals(obj);
    }
    com.aperture.flowcontrol.v1.CheckRequest other = (com.aperture.flowcontrol.v1.CheckRequest) obj;

    if (!getFeature()
        .equals(other.getFeature())) return false;
    if (!internalGetLabels().equals(
        other.internalGetLabels())) return false;
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
    hash = (37 * hash) + FEATURE_FIELD_NUMBER;
    hash = (53 * hash) + getFeature().hashCode();
    if (!internalGetLabels().getMap().isEmpty()) {
      hash = (37 * hash) + LABELS_FIELD_NUMBER;
      hash = (53 * hash) + internalGetLabels().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.aperture.flowcontrol.v1.CheckRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.aperture.flowcontrol.v1.CheckRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.aperture.flowcontrol.v1.CheckRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.aperture.flowcontrol.v1.CheckRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.aperture.flowcontrol.v1.CheckRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.aperture.flowcontrol.v1.CheckRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.aperture.flowcontrol.v1.CheckRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.aperture.flowcontrol.v1.CheckRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.aperture.flowcontrol.v1.CheckRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.aperture.flowcontrol.v1.CheckRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.aperture.flowcontrol.v1.CheckRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.aperture.flowcontrol.v1.CheckRequest parseFrom(
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
  public static Builder newBuilder(com.aperture.flowcontrol.v1.CheckRequest prototype) {
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
   * CheckRequest contains fields required to perform Check call.
   * </pre>
   *
   * Protobuf type {@code aperture.flowcontrol.v1.CheckRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:aperture.flowcontrol.v1.CheckRequest)
      com.aperture.flowcontrol.v1.CheckRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.aperture.flowcontrol.v1.FlowcontrolProto.internal_static_aperture_flowcontrol_v1_CheckRequest_descriptor;
    }

    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMapField(
        int number) {
      switch (number) {
        case 2:
          return internalGetLabels();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMutableMapField(
        int number) {
      switch (number) {
        case 2:
          return internalGetMutableLabels();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.aperture.flowcontrol.v1.FlowcontrolProto.internal_static_aperture_flowcontrol_v1_CheckRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.aperture.flowcontrol.v1.CheckRequest.class, com.aperture.flowcontrol.v1.CheckRequest.Builder.class);
    }

    // Construct using com.aperture.flowcontrol.v1.CheckRequest.newBuilder()
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
      feature_ = "";

      internalGetMutableLabels().clear();
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.aperture.flowcontrol.v1.FlowcontrolProto.internal_static_aperture_flowcontrol_v1_CheckRequest_descriptor;
    }

    @java.lang.Override
    public com.aperture.flowcontrol.v1.CheckRequest getDefaultInstanceForType() {
      return com.aperture.flowcontrol.v1.CheckRequest.getDefaultInstance();
    }

    @java.lang.Override
    public com.aperture.flowcontrol.v1.CheckRequest build() {
      com.aperture.flowcontrol.v1.CheckRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.aperture.flowcontrol.v1.CheckRequest buildPartial() {
      com.aperture.flowcontrol.v1.CheckRequest result = new com.aperture.flowcontrol.v1.CheckRequest(this);
      int from_bitField0_ = bitField0_;
      result.feature_ = feature_;
      result.labels_ = internalGetLabels();
      result.labels_.makeImmutable();
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
      if (other instanceof com.aperture.flowcontrol.v1.CheckRequest) {
        return mergeFrom((com.aperture.flowcontrol.v1.CheckRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.aperture.flowcontrol.v1.CheckRequest other) {
      if (other == com.aperture.flowcontrol.v1.CheckRequest.getDefaultInstance()) return this;
      if (!other.getFeature().isEmpty()) {
        feature_ = other.feature_;
        onChanged();
      }
      internalGetMutableLabels().mergeFrom(
          other.internalGetLabels());
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
      com.aperture.flowcontrol.v1.CheckRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.aperture.flowcontrol.v1.CheckRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.lang.Object feature_ = "";
    /**
     * <code>string feature = 1[json_name = "feature"];</code>
     * @return The feature.
     */
    public java.lang.String getFeature() {
      java.lang.Object ref = feature_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        feature_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string feature = 1[json_name = "feature"];</code>
     * @return The bytes for feature.
     */
    public com.google.protobuf.ByteString
        getFeatureBytes() {
      java.lang.Object ref = feature_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        feature_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string feature = 1[json_name = "feature"];</code>
     * @param value The feature to set.
     * @return This builder for chaining.
     */
    public Builder setFeature(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }

      feature_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string feature = 1[json_name = "feature"];</code>
     * @return This builder for chaining.
     */
    public Builder clearFeature() {

      feature_ = getDefaultInstance().getFeature();
      onChanged();
      return this;
    }
    /**
     * <code>string feature = 1[json_name = "feature"];</code>
     * @param value The bytes for feature to set.
     * @return This builder for chaining.
     */
    public Builder setFeatureBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);

      feature_ = value;
      onChanged();
      return this;
    }

    private com.google.protobuf.MapField<
        java.lang.String, java.lang.String> labels_;
    private com.google.protobuf.MapField<java.lang.String, java.lang.String>
    internalGetLabels() {
      if (labels_ == null) {
        return com.google.protobuf.MapField.emptyMapField(
            LabelsDefaultEntryHolder.defaultEntry);
      }
      return labels_;
    }
    private com.google.protobuf.MapField<java.lang.String, java.lang.String>
    internalGetMutableLabels() {
      onChanged();;
      if (labels_ == null) {
        labels_ = com.google.protobuf.MapField.newMapField(
            LabelsDefaultEntryHolder.defaultEntry);
      }
      if (!labels_.isMutable()) {
        labels_ = labels_.copy();
      }
      return labels_;
    }

    public int getLabelsCount() {
      return internalGetLabels().getMap().size();
    }
    /**
     * <code>map&lt;string, string&gt; labels = 2[json_name = "labels"];</code>
     */

    @java.lang.Override
    public boolean containsLabels(
        java.lang.String key) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      return internalGetLabels().getMap().containsKey(key);
    }
    /**
     * Use {@link #getLabelsMap()} instead.
     */
    @java.lang.Override
    @java.lang.Deprecated
    public java.util.Map<java.lang.String, java.lang.String> getLabels() {
      return getLabelsMap();
    }
    /**
     * <code>map&lt;string, string&gt; labels = 2[json_name = "labels"];</code>
     */
    @java.lang.Override

    public java.util.Map<java.lang.String, java.lang.String> getLabelsMap() {
      return internalGetLabels().getMap();
    }
    /**
     * <code>map&lt;string, string&gt; labels = 2[json_name = "labels"];</code>
     */
    @java.lang.Override

    public java.lang.String getLabelsOrDefault(
        java.lang.String key,
        java.lang.String defaultValue) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      java.util.Map<java.lang.String, java.lang.String> map =
          internalGetLabels().getMap();
      return map.containsKey(key) ? map.get(key) : defaultValue;
    }
    /**
     * <code>map&lt;string, string&gt; labels = 2[json_name = "labels"];</code>
     */
    @java.lang.Override

    public java.lang.String getLabelsOrThrow(
        java.lang.String key) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      java.util.Map<java.lang.String, java.lang.String> map =
          internalGetLabels().getMap();
      if (!map.containsKey(key)) {
        throw new java.lang.IllegalArgumentException();
      }
      return map.get(key);
    }

    public Builder clearLabels() {
      internalGetMutableLabels().getMutableMap()
          .clear();
      return this;
    }
    /**
     * <code>map&lt;string, string&gt; labels = 2[json_name = "labels"];</code>
     */

    public Builder removeLabels(
        java.lang.String key) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      internalGetMutableLabels().getMutableMap()
          .remove(key);
      return this;
    }
    /**
     * Use alternate mutation accessors instead.
     */
    @java.lang.Deprecated
    public java.util.Map<java.lang.String, java.lang.String>
    getMutableLabels() {
      return internalGetMutableLabels().getMutableMap();
    }
    /**
     * <code>map&lt;string, string&gt; labels = 2[json_name = "labels"];</code>
     */
    public Builder putLabels(
        java.lang.String key,
        java.lang.String value) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      if (value == null) { throw new java.lang.NullPointerException(); }
      internalGetMutableLabels().getMutableMap()
          .put(key, value);
      return this;
    }
    /**
     * <code>map&lt;string, string&gt; labels = 2[json_name = "labels"];</code>
     */

    public Builder putAllLabels(
        java.util.Map<java.lang.String, java.lang.String> values) {
      internalGetMutableLabels().getMutableMap()
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


    // @@protoc_insertion_point(builder_scope:aperture.flowcontrol.v1.CheckRequest)
  }

  // @@protoc_insertion_point(class_scope:aperture.flowcontrol.v1.CheckRequest)
  private static final com.aperture.flowcontrol.v1.CheckRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.aperture.flowcontrol.v1.CheckRequest();
  }

  public static com.aperture.flowcontrol.v1.CheckRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<CheckRequest>
      PARSER = new com.google.protobuf.AbstractParser<CheckRequest>() {
    @java.lang.Override
    public CheckRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new CheckRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<CheckRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<CheckRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.aperture.flowcontrol.v1.CheckRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
