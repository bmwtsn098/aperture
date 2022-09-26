// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: aperture/policy/wrappers/v1/policy.proto

package com.aperture.policy.wrappers.v1;

public final class PolicyProto {
  private PolicyProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_aperture_policy_wrappers_v1_PolicyWrapper_descriptor;
  static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_aperture_policy_wrappers_v1_PolicyWrapper_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_aperture_policy_wrappers_v1_FluxMeterWrapper_descriptor;
  static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_aperture_policy_wrappers_v1_FluxMeterWrapper_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_aperture_policy_wrappers_v1_ClassifierWrapper_descriptor;
  static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_aperture_policy_wrappers_v1_ClassifierWrapper_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_aperture_policy_wrappers_v1_ConcurrencyLimiterWrapper_descriptor;
  static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_aperture_policy_wrappers_v1_ConcurrencyLimiterWrapper_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_aperture_policy_wrappers_v1_RateLimiterWrapper_descriptor;
  static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_aperture_policy_wrappers_v1_RateLimiterWrapper_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n(aperture/policy/wrappers/v1/policy.pro" +
      "to\022\033aperture.policy.wrappers.v1\032,apertur" +
      "e/policy/language/v1/classifier.proto\032+a" +
      "perture/policy/language/v1/fluxmeter.pro" +
      "to\032(aperture/policy/language/v1/policy.p" +
      "roto\"\216\001\n\rPolicyWrapper\022;\n\006policy\030\001 \001(\0132#" +
      ".aperture.policy.language.v1.PolicyR\006pol" +
      "icy\022\037\n\013policy_name\030\002 \001(\tR\npolicyName\022\037\n\013" +
      "policy_hash\030\003 \001(\tR\npolicyHash\"\201\001\n\020FluxMe" +
      "terWrapper\022E\n\nflux_meter\030\001 \001(\0132&.apertur" +
      "e.policy.language.v1.FluxMeterR\tfluxMete" +
      "r\022&\n\017flux_meter_name\030\004 \001(\tR\rfluxMeterNam" +
      "e\"\311\001\n\021ClassifierWrapper\022G\n\nclassifier\030\001 " +
      "\001(\0132\'.aperture.policy.language.v1.Classi" +
      "fierR\nclassifier\022\037\n\013policy_name\030\002 \001(\tR\np" +
      "olicyName\022\037\n\013policy_hash\030\003 \001(\tR\npolicyHa" +
      "sh\022)\n\020classifier_index\030\004 \001(\003R\017classifier" +
      "Index\"\350\001\n\031ConcurrencyLimiterWrapper\022`\n\023c" +
      "oncurrency_limiter\030\001 \001(\0132/.aperture.poli" +
      "cy.language.v1.ConcurrencyLimiterR\022concu" +
      "rrencyLimiter\022\'\n\017component_index\030\002 \001(\003R\016" +
      "componentIndex\022\037\n\013policy_name\030\003 \001(\tR\npol" +
      "icyName\022\037\n\013policy_hash\030\004 \001(\tR\npolicyHash" +
      "\"\314\001\n\022RateLimiterWrapper\022K\n\014rate_limiter\030" +
      "\001 \001(\0132(.aperture.policy.language.v1.Rate" +
      "LimiterR\013rateLimiter\022\'\n\017component_index\030" +
      "\002 \001(\003R\016componentIndex\022\037\n\013policy_name\030\003 \001" +
      "(\tR\npolicyName\022\037\n\013policy_hash\030\004 \001(\tR\npol" +
      "icyHashB\224\002\n\037com.aperture.policy.wrappers" +
      ".v1B\013PolicyProtoP\001ZUgithub.com/fluxninja" +
      "/aperture/api/gen/proto/go/aperture/poli" +
      "cy/wrappers/v1;wrappersv1\242\002\003APW\252\002\033Apertu" +
      "re.Policy.Wrappers.V1\312\002\033Aperture\\Policy\\" +
      "Wrappers\\V1\342\002\'Aperture\\Policy\\Wrappers\\V" +
      "1\\GPBMetadata\352\002\036Aperture::Policy::Wrappe" +
      "rs::V1b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.aperture.policy.language.v1.ClassifierProto.getDescriptor(),
          com.aperture.policy.language.v1.FluxmeterProto.getDescriptor(),
          com.aperture.policy.language.v1.PolicyProto.getDescriptor(),
        });
    internal_static_aperture_policy_wrappers_v1_PolicyWrapper_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_aperture_policy_wrappers_v1_PolicyWrapper_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_aperture_policy_wrappers_v1_PolicyWrapper_descriptor,
        new java.lang.String[] { "Policy", "PolicyName", "PolicyHash", });
    internal_static_aperture_policy_wrappers_v1_FluxMeterWrapper_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_aperture_policy_wrappers_v1_FluxMeterWrapper_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_aperture_policy_wrappers_v1_FluxMeterWrapper_descriptor,
        new java.lang.String[] { "FluxMeter", "FluxMeterName", });
    internal_static_aperture_policy_wrappers_v1_ClassifierWrapper_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_aperture_policy_wrappers_v1_ClassifierWrapper_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_aperture_policy_wrappers_v1_ClassifierWrapper_descriptor,
        new java.lang.String[] { "Classifier", "PolicyName", "PolicyHash", "ClassifierIndex", });
    internal_static_aperture_policy_wrappers_v1_ConcurrencyLimiterWrapper_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_aperture_policy_wrappers_v1_ConcurrencyLimiterWrapper_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_aperture_policy_wrappers_v1_ConcurrencyLimiterWrapper_descriptor,
        new java.lang.String[] { "ConcurrencyLimiter", "ComponentIndex", "PolicyName", "PolicyHash", });
    internal_static_aperture_policy_wrappers_v1_RateLimiterWrapper_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_aperture_policy_wrappers_v1_RateLimiterWrapper_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_aperture_policy_wrappers_v1_RateLimiterWrapper_descriptor,
        new java.lang.String[] { "RateLimiter", "ComponentIndex", "PolicyName", "PolicyHash", });
    com.aperture.policy.language.v1.ClassifierProto.getDescriptor();
    com.aperture.policy.language.v1.FluxmeterProto.getDescriptor();
    com.aperture.policy.language.v1.PolicyProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
