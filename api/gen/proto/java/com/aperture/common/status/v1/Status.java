// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: aperture/common/status/v1/status.proto

package com.aperture.common.status.v1;

/**
 * <pre>
 * Status holds details about a status that can be reported to the registry. The
 * details can either be a message (Any) or error (ErrorDetails).
 * </pre>
 *
 * Protobuf type {@code aperture.common.status.v1.Status}
 */
public final class Status extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:aperture.common.status.v1.Status)
    StatusOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Status.newBuilder() to construct.
  private Status(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Status() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new Status();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Status(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
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
            com.google.protobuf.Any.Builder subBuilder = null;
            if (detailsCase_ == 1) {
              subBuilder = ((com.google.protobuf.Any) details_).toBuilder();
            }
            details_ =
                input.readMessage(com.google.protobuf.Any.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom((com.google.protobuf.Any) details_);
              details_ = subBuilder.buildPartial();
            }
            detailsCase_ = 1;
            break;
          }
          case 18: {
            com.aperture.common.status.v1.ErrorDetails.Builder subBuilder = null;
            if (detailsCase_ == 2) {
              subBuilder = ((com.aperture.common.status.v1.ErrorDetails) details_).toBuilder();
            }
            details_ =
                input.readMessage(com.aperture.common.status.v1.ErrorDetails.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom((com.aperture.common.status.v1.ErrorDetails) details_);
              details_ = subBuilder.buildPartial();
            }
            detailsCase_ = 2;
            break;
          }
          case 26: {
            com.google.protobuf.Timestamp.Builder subBuilder = null;
            if (timestamp_ != null) {
              subBuilder = timestamp_.toBuilder();
            }
            timestamp_ = input.readMessage(com.google.protobuf.Timestamp.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(timestamp_);
              timestamp_ = subBuilder.buildPartial();
            }

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
    return com.aperture.common.status.v1.StatusProto.internal_static_aperture_common_status_v1_Status_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.aperture.common.status.v1.StatusProto.internal_static_aperture_common_status_v1_Status_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.aperture.common.status.v1.Status.class, com.aperture.common.status.v1.Status.Builder.class);
  }

  private int detailsCase_ = 0;
  private java.lang.Object details_;
  public enum DetailsCase
      implements com.google.protobuf.Internal.EnumLite,
          com.google.protobuf.AbstractMessage.InternalOneOfEnum {
    MESSAGE(1),
    ERROR(2),
    DETAILS_NOT_SET(0);
    private final int value;
    private DetailsCase(int value) {
      this.value = value;
    }
    /**
     * @param value The number of the enum to look for.
     * @return The enum associated with the given number.
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static DetailsCase valueOf(int value) {
      return forNumber(value);
    }

    public static DetailsCase forNumber(int value) {
      switch (value) {
        case 1: return MESSAGE;
        case 2: return ERROR;
        case 0: return DETAILS_NOT_SET;
        default: return null;
      }
    }
    public int getNumber() {
      return this.value;
    }
  };

  public DetailsCase
  getDetailsCase() {
    return DetailsCase.forNumber(
        detailsCase_);
  }

  public static final int MESSAGE_FIELD_NUMBER = 1;
  /**
   * <code>.google.protobuf.Any message = 1[json_name = "message"];</code>
   * @return Whether the message field is set.
   */
  @java.lang.Override
  public boolean hasMessage() {
    return detailsCase_ == 1;
  }
  /**
   * <code>.google.protobuf.Any message = 1[json_name = "message"];</code>
   * @return The message.
   */
  @java.lang.Override
  public com.google.protobuf.Any getMessage() {
    if (detailsCase_ == 1) {
       return (com.google.protobuf.Any) details_;
    }
    return com.google.protobuf.Any.getDefaultInstance();
  }
  /**
   * <code>.google.protobuf.Any message = 1[json_name = "message"];</code>
   */
  @java.lang.Override
  public com.google.protobuf.AnyOrBuilder getMessageOrBuilder() {
    if (detailsCase_ == 1) {
       return (com.google.protobuf.Any) details_;
    }
    return com.google.protobuf.Any.getDefaultInstance();
  }

  public static final int ERROR_FIELD_NUMBER = 2;
  /**
   * <code>.aperture.common.status.v1.ErrorDetails error = 2[json_name = "error"];</code>
   * @return Whether the error field is set.
   */
  @java.lang.Override
  public boolean hasError() {
    return detailsCase_ == 2;
  }
  /**
   * <code>.aperture.common.status.v1.ErrorDetails error = 2[json_name = "error"];</code>
   * @return The error.
   */
  @java.lang.Override
  public com.aperture.common.status.v1.ErrorDetails getError() {
    if (detailsCase_ == 2) {
       return (com.aperture.common.status.v1.ErrorDetails) details_;
    }
    return com.aperture.common.status.v1.ErrorDetails.getDefaultInstance();
  }
  /**
   * <code>.aperture.common.status.v1.ErrorDetails error = 2[json_name = "error"];</code>
   */
  @java.lang.Override
  public com.aperture.common.status.v1.ErrorDetailsOrBuilder getErrorOrBuilder() {
    if (detailsCase_ == 2) {
       return (com.aperture.common.status.v1.ErrorDetails) details_;
    }
    return com.aperture.common.status.v1.ErrorDetails.getDefaultInstance();
  }

  public static final int TIMESTAMP_FIELD_NUMBER = 3;
  private com.google.protobuf.Timestamp timestamp_;
  /**
   * <code>.google.protobuf.Timestamp timestamp = 3[json_name = "timestamp"];</code>
   * @return Whether the timestamp field is set.
   */
  @java.lang.Override
  public boolean hasTimestamp() {
    return timestamp_ != null;
  }
  /**
   * <code>.google.protobuf.Timestamp timestamp = 3[json_name = "timestamp"];</code>
   * @return The timestamp.
   */
  @java.lang.Override
  public com.google.protobuf.Timestamp getTimestamp() {
    return timestamp_ == null ? com.google.protobuf.Timestamp.getDefaultInstance() : timestamp_;
  }
  /**
   * <code>.google.protobuf.Timestamp timestamp = 3[json_name = "timestamp"];</code>
   */
  @java.lang.Override
  public com.google.protobuf.TimestampOrBuilder getTimestampOrBuilder() {
    return getTimestamp();
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
    if (detailsCase_ == 1) {
      output.writeMessage(1, (com.google.protobuf.Any) details_);
    }
    if (detailsCase_ == 2) {
      output.writeMessage(2, (com.aperture.common.status.v1.ErrorDetails) details_);
    }
    if (timestamp_ != null) {
      output.writeMessage(3, getTimestamp());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (detailsCase_ == 1) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, (com.google.protobuf.Any) details_);
    }
    if (detailsCase_ == 2) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, (com.aperture.common.status.v1.ErrorDetails) details_);
    }
    if (timestamp_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, getTimestamp());
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
    if (!(obj instanceof com.aperture.common.status.v1.Status)) {
      return super.equals(obj);
    }
    com.aperture.common.status.v1.Status other = (com.aperture.common.status.v1.Status) obj;

    if (hasTimestamp() != other.hasTimestamp()) return false;
    if (hasTimestamp()) {
      if (!getTimestamp()
          .equals(other.getTimestamp())) return false;
    }
    if (!getDetailsCase().equals(other.getDetailsCase())) return false;
    switch (detailsCase_) {
      case 1:
        if (!getMessage()
            .equals(other.getMessage())) return false;
        break;
      case 2:
        if (!getError()
            .equals(other.getError())) return false;
        break;
      case 0:
      default:
    }
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
    if (hasTimestamp()) {
      hash = (37 * hash) + TIMESTAMP_FIELD_NUMBER;
      hash = (53 * hash) + getTimestamp().hashCode();
    }
    switch (detailsCase_) {
      case 1:
        hash = (37 * hash) + MESSAGE_FIELD_NUMBER;
        hash = (53 * hash) + getMessage().hashCode();
        break;
      case 2:
        hash = (37 * hash) + ERROR_FIELD_NUMBER;
        hash = (53 * hash) + getError().hashCode();
        break;
      case 0:
      default:
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.aperture.common.status.v1.Status parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.aperture.common.status.v1.Status parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.aperture.common.status.v1.Status parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.aperture.common.status.v1.Status parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.aperture.common.status.v1.Status parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.aperture.common.status.v1.Status parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.aperture.common.status.v1.Status parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.aperture.common.status.v1.Status parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.aperture.common.status.v1.Status parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.aperture.common.status.v1.Status parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.aperture.common.status.v1.Status parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.aperture.common.status.v1.Status parseFrom(
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
  public static Builder newBuilder(com.aperture.common.status.v1.Status prototype) {
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
   * Status holds details about a status that can be reported to the registry. The
   * details can either be a message (Any) or error (ErrorDetails).
   * </pre>
   *
   * Protobuf type {@code aperture.common.status.v1.Status}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:aperture.common.status.v1.Status)
      com.aperture.common.status.v1.StatusOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.aperture.common.status.v1.StatusProto.internal_static_aperture_common_status_v1_Status_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.aperture.common.status.v1.StatusProto.internal_static_aperture_common_status_v1_Status_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.aperture.common.status.v1.Status.class, com.aperture.common.status.v1.Status.Builder.class);
    }

    // Construct using com.aperture.common.status.v1.Status.newBuilder()
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
      if (timestampBuilder_ == null) {
        timestamp_ = null;
      } else {
        timestamp_ = null;
        timestampBuilder_ = null;
      }
      detailsCase_ = 0;
      details_ = null;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.aperture.common.status.v1.StatusProto.internal_static_aperture_common_status_v1_Status_descriptor;
    }

    @java.lang.Override
    public com.aperture.common.status.v1.Status getDefaultInstanceForType() {
      return com.aperture.common.status.v1.Status.getDefaultInstance();
    }

    @java.lang.Override
    public com.aperture.common.status.v1.Status build() {
      com.aperture.common.status.v1.Status result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.aperture.common.status.v1.Status buildPartial() {
      com.aperture.common.status.v1.Status result = new com.aperture.common.status.v1.Status(this);
      if (detailsCase_ == 1) {
        if (messageBuilder_ == null) {
          result.details_ = details_;
        } else {
          result.details_ = messageBuilder_.build();
        }
      }
      if (detailsCase_ == 2) {
        if (errorBuilder_ == null) {
          result.details_ = details_;
        } else {
          result.details_ = errorBuilder_.build();
        }
      }
      if (timestampBuilder_ == null) {
        result.timestamp_ = timestamp_;
      } else {
        result.timestamp_ = timestampBuilder_.build();
      }
      result.detailsCase_ = detailsCase_;
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
      if (other instanceof com.aperture.common.status.v1.Status) {
        return mergeFrom((com.aperture.common.status.v1.Status)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.aperture.common.status.v1.Status other) {
      if (other == com.aperture.common.status.v1.Status.getDefaultInstance()) return this;
      if (other.hasTimestamp()) {
        mergeTimestamp(other.getTimestamp());
      }
      switch (other.getDetailsCase()) {
        case MESSAGE: {
          mergeMessage(other.getMessage());
          break;
        }
        case ERROR: {
          mergeError(other.getError());
          break;
        }
        case DETAILS_NOT_SET: {
          break;
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
      com.aperture.common.status.v1.Status parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.aperture.common.status.v1.Status) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int detailsCase_ = 0;
    private java.lang.Object details_;
    public DetailsCase
        getDetailsCase() {
      return DetailsCase.forNumber(
          detailsCase_);
    }

    public Builder clearDetails() {
      detailsCase_ = 0;
      details_ = null;
      onChanged();
      return this;
    }


    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Any, com.google.protobuf.Any.Builder, com.google.protobuf.AnyOrBuilder> messageBuilder_;
    /**
     * <code>.google.protobuf.Any message = 1[json_name = "message"];</code>
     * @return Whether the message field is set.
     */
    @java.lang.Override
    public boolean hasMessage() {
      return detailsCase_ == 1;
    }
    /**
     * <code>.google.protobuf.Any message = 1[json_name = "message"];</code>
     * @return The message.
     */
    @java.lang.Override
    public com.google.protobuf.Any getMessage() {
      if (messageBuilder_ == null) {
        if (detailsCase_ == 1) {
          return (com.google.protobuf.Any) details_;
        }
        return com.google.protobuf.Any.getDefaultInstance();
      } else {
        if (detailsCase_ == 1) {
          return messageBuilder_.getMessage();
        }
        return com.google.protobuf.Any.getDefaultInstance();
      }
    }
    /**
     * <code>.google.protobuf.Any message = 1[json_name = "message"];</code>
     */
    public Builder setMessage(com.google.protobuf.Any value) {
      if (messageBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        details_ = value;
        onChanged();
      } else {
        messageBuilder_.setMessage(value);
      }
      detailsCase_ = 1;
      return this;
    }
    /**
     * <code>.google.protobuf.Any message = 1[json_name = "message"];</code>
     */
    public Builder setMessage(
        com.google.protobuf.Any.Builder builderForValue) {
      if (messageBuilder_ == null) {
        details_ = builderForValue.build();
        onChanged();
      } else {
        messageBuilder_.setMessage(builderForValue.build());
      }
      detailsCase_ = 1;
      return this;
    }
    /**
     * <code>.google.protobuf.Any message = 1[json_name = "message"];</code>
     */
    public Builder mergeMessage(com.google.protobuf.Any value) {
      if (messageBuilder_ == null) {
        if (detailsCase_ == 1 &&
            details_ != com.google.protobuf.Any.getDefaultInstance()) {
          details_ = com.google.protobuf.Any.newBuilder((com.google.protobuf.Any) details_)
              .mergeFrom(value).buildPartial();
        } else {
          details_ = value;
        }
        onChanged();
      } else {
        if (detailsCase_ == 1) {
          messageBuilder_.mergeFrom(value);
        }
        messageBuilder_.setMessage(value);
      }
      detailsCase_ = 1;
      return this;
    }
    /**
     * <code>.google.protobuf.Any message = 1[json_name = "message"];</code>
     */
    public Builder clearMessage() {
      if (messageBuilder_ == null) {
        if (detailsCase_ == 1) {
          detailsCase_ = 0;
          details_ = null;
          onChanged();
        }
      } else {
        if (detailsCase_ == 1) {
          detailsCase_ = 0;
          details_ = null;
        }
        messageBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>.google.protobuf.Any message = 1[json_name = "message"];</code>
     */
    public com.google.protobuf.Any.Builder getMessageBuilder() {
      return getMessageFieldBuilder().getBuilder();
    }
    /**
     * <code>.google.protobuf.Any message = 1[json_name = "message"];</code>
     */
    @java.lang.Override
    public com.google.protobuf.AnyOrBuilder getMessageOrBuilder() {
      if ((detailsCase_ == 1) && (messageBuilder_ != null)) {
        return messageBuilder_.getMessageOrBuilder();
      } else {
        if (detailsCase_ == 1) {
          return (com.google.protobuf.Any) details_;
        }
        return com.google.protobuf.Any.getDefaultInstance();
      }
    }
    /**
     * <code>.google.protobuf.Any message = 1[json_name = "message"];</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Any, com.google.protobuf.Any.Builder, com.google.protobuf.AnyOrBuilder>
        getMessageFieldBuilder() {
      if (messageBuilder_ == null) {
        if (!(detailsCase_ == 1)) {
          details_ = com.google.protobuf.Any.getDefaultInstance();
        }
        messageBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.google.protobuf.Any, com.google.protobuf.Any.Builder, com.google.protobuf.AnyOrBuilder>(
                (com.google.protobuf.Any) details_,
                getParentForChildren(),
                isClean());
        details_ = null;
      }
      detailsCase_ = 1;
      onChanged();;
      return messageBuilder_;
    }

    private com.google.protobuf.SingleFieldBuilderV3<
        com.aperture.common.status.v1.ErrorDetails, com.aperture.common.status.v1.ErrorDetails.Builder, com.aperture.common.status.v1.ErrorDetailsOrBuilder> errorBuilder_;
    /**
     * <code>.aperture.common.status.v1.ErrorDetails error = 2[json_name = "error"];</code>
     * @return Whether the error field is set.
     */
    @java.lang.Override
    public boolean hasError() {
      return detailsCase_ == 2;
    }
    /**
     * <code>.aperture.common.status.v1.ErrorDetails error = 2[json_name = "error"];</code>
     * @return The error.
     */
    @java.lang.Override
    public com.aperture.common.status.v1.ErrorDetails getError() {
      if (errorBuilder_ == null) {
        if (detailsCase_ == 2) {
          return (com.aperture.common.status.v1.ErrorDetails) details_;
        }
        return com.aperture.common.status.v1.ErrorDetails.getDefaultInstance();
      } else {
        if (detailsCase_ == 2) {
          return errorBuilder_.getMessage();
        }
        return com.aperture.common.status.v1.ErrorDetails.getDefaultInstance();
      }
    }
    /**
     * <code>.aperture.common.status.v1.ErrorDetails error = 2[json_name = "error"];</code>
     */
    public Builder setError(com.aperture.common.status.v1.ErrorDetails value) {
      if (errorBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        details_ = value;
        onChanged();
      } else {
        errorBuilder_.setMessage(value);
      }
      detailsCase_ = 2;
      return this;
    }
    /**
     * <code>.aperture.common.status.v1.ErrorDetails error = 2[json_name = "error"];</code>
     */
    public Builder setError(
        com.aperture.common.status.v1.ErrorDetails.Builder builderForValue) {
      if (errorBuilder_ == null) {
        details_ = builderForValue.build();
        onChanged();
      } else {
        errorBuilder_.setMessage(builderForValue.build());
      }
      detailsCase_ = 2;
      return this;
    }
    /**
     * <code>.aperture.common.status.v1.ErrorDetails error = 2[json_name = "error"];</code>
     */
    public Builder mergeError(com.aperture.common.status.v1.ErrorDetails value) {
      if (errorBuilder_ == null) {
        if (detailsCase_ == 2 &&
            details_ != com.aperture.common.status.v1.ErrorDetails.getDefaultInstance()) {
          details_ = com.aperture.common.status.v1.ErrorDetails.newBuilder((com.aperture.common.status.v1.ErrorDetails) details_)
              .mergeFrom(value).buildPartial();
        } else {
          details_ = value;
        }
        onChanged();
      } else {
        if (detailsCase_ == 2) {
          errorBuilder_.mergeFrom(value);
        }
        errorBuilder_.setMessage(value);
      }
      detailsCase_ = 2;
      return this;
    }
    /**
     * <code>.aperture.common.status.v1.ErrorDetails error = 2[json_name = "error"];</code>
     */
    public Builder clearError() {
      if (errorBuilder_ == null) {
        if (detailsCase_ == 2) {
          detailsCase_ = 0;
          details_ = null;
          onChanged();
        }
      } else {
        if (detailsCase_ == 2) {
          detailsCase_ = 0;
          details_ = null;
        }
        errorBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>.aperture.common.status.v1.ErrorDetails error = 2[json_name = "error"];</code>
     */
    public com.aperture.common.status.v1.ErrorDetails.Builder getErrorBuilder() {
      return getErrorFieldBuilder().getBuilder();
    }
    /**
     * <code>.aperture.common.status.v1.ErrorDetails error = 2[json_name = "error"];</code>
     */
    @java.lang.Override
    public com.aperture.common.status.v1.ErrorDetailsOrBuilder getErrorOrBuilder() {
      if ((detailsCase_ == 2) && (errorBuilder_ != null)) {
        return errorBuilder_.getMessageOrBuilder();
      } else {
        if (detailsCase_ == 2) {
          return (com.aperture.common.status.v1.ErrorDetails) details_;
        }
        return com.aperture.common.status.v1.ErrorDetails.getDefaultInstance();
      }
    }
    /**
     * <code>.aperture.common.status.v1.ErrorDetails error = 2[json_name = "error"];</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.aperture.common.status.v1.ErrorDetails, com.aperture.common.status.v1.ErrorDetails.Builder, com.aperture.common.status.v1.ErrorDetailsOrBuilder>
        getErrorFieldBuilder() {
      if (errorBuilder_ == null) {
        if (!(detailsCase_ == 2)) {
          details_ = com.aperture.common.status.v1.ErrorDetails.getDefaultInstance();
        }
        errorBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.aperture.common.status.v1.ErrorDetails, com.aperture.common.status.v1.ErrorDetails.Builder, com.aperture.common.status.v1.ErrorDetailsOrBuilder>(
                (com.aperture.common.status.v1.ErrorDetails) details_,
                getParentForChildren(),
                isClean());
        details_ = null;
      }
      detailsCase_ = 2;
      onChanged();;
      return errorBuilder_;
    }

    private com.google.protobuf.Timestamp timestamp_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder> timestampBuilder_;
    /**
     * <code>.google.protobuf.Timestamp timestamp = 3[json_name = "timestamp"];</code>
     * @return Whether the timestamp field is set.
     */
    public boolean hasTimestamp() {
      return timestampBuilder_ != null || timestamp_ != null;
    }
    /**
     * <code>.google.protobuf.Timestamp timestamp = 3[json_name = "timestamp"];</code>
     * @return The timestamp.
     */
    public com.google.protobuf.Timestamp getTimestamp() {
      if (timestampBuilder_ == null) {
        return timestamp_ == null ? com.google.protobuf.Timestamp.getDefaultInstance() : timestamp_;
      } else {
        return timestampBuilder_.getMessage();
      }
    }
    /**
     * <code>.google.protobuf.Timestamp timestamp = 3[json_name = "timestamp"];</code>
     */
    public Builder setTimestamp(com.google.protobuf.Timestamp value) {
      if (timestampBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        timestamp_ = value;
        onChanged();
      } else {
        timestampBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp timestamp = 3[json_name = "timestamp"];</code>
     */
    public Builder setTimestamp(
        com.google.protobuf.Timestamp.Builder builderForValue) {
      if (timestampBuilder_ == null) {
        timestamp_ = builderForValue.build();
        onChanged();
      } else {
        timestampBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp timestamp = 3[json_name = "timestamp"];</code>
     */
    public Builder mergeTimestamp(com.google.protobuf.Timestamp value) {
      if (timestampBuilder_ == null) {
        if (timestamp_ != null) {
          timestamp_ =
            com.google.protobuf.Timestamp.newBuilder(timestamp_).mergeFrom(value).buildPartial();
        } else {
          timestamp_ = value;
        }
        onChanged();
      } else {
        timestampBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp timestamp = 3[json_name = "timestamp"];</code>
     */
    public Builder clearTimestamp() {
      if (timestampBuilder_ == null) {
        timestamp_ = null;
        onChanged();
      } else {
        timestamp_ = null;
        timestampBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp timestamp = 3[json_name = "timestamp"];</code>
     */
    public com.google.protobuf.Timestamp.Builder getTimestampBuilder() {

      onChanged();
      return getTimestampFieldBuilder().getBuilder();
    }
    /**
     * <code>.google.protobuf.Timestamp timestamp = 3[json_name = "timestamp"];</code>
     */
    public com.google.protobuf.TimestampOrBuilder getTimestampOrBuilder() {
      if (timestampBuilder_ != null) {
        return timestampBuilder_.getMessageOrBuilder();
      } else {
        return timestamp_ == null ?
            com.google.protobuf.Timestamp.getDefaultInstance() : timestamp_;
      }
    }
    /**
     * <code>.google.protobuf.Timestamp timestamp = 3[json_name = "timestamp"];</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder>
        getTimestampFieldBuilder() {
      if (timestampBuilder_ == null) {
        timestampBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder>(
                getTimestamp(),
                getParentForChildren(),
                isClean());
        timestamp_ = null;
      }
      return timestampBuilder_;
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


    // @@protoc_insertion_point(builder_scope:aperture.common.status.v1.Status)
  }

  // @@protoc_insertion_point(class_scope:aperture.common.status.v1.Status)
  private static final com.aperture.common.status.v1.Status DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.aperture.common.status.v1.Status();
  }

  public static com.aperture.common.status.v1.Status getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Status>
      PARSER = new com.google.protobuf.AbstractParser<Status>() {
    @java.lang.Override
    public Status parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Status(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Status> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Status> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.aperture.common.status.v1.Status getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
