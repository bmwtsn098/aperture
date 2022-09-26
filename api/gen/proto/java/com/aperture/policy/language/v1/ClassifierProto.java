// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: aperture/policy/language/v1/classifier.proto

package com.aperture.policy.language.v1;

public final class ClassifierProto {
  private ClassifierProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_aperture_policy_language_v1_Classifier_descriptor;
  static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_aperture_policy_language_v1_Classifier_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_aperture_policy_language_v1_Classifier_RulesEntry_descriptor;
  static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_aperture_policy_language_v1_Classifier_RulesEntry_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_aperture_policy_language_v1_Rule_descriptor;
  static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_aperture_policy_language_v1_Rule_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_aperture_policy_language_v1_Rule_Rego_descriptor;
  static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_aperture_policy_language_v1_Rule_Rego_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_aperture_policy_language_v1_Extractor_descriptor;
  static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_aperture_policy_language_v1_Extractor_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_aperture_policy_language_v1_JSONExtractor_descriptor;
  static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_aperture_policy_language_v1_JSONExtractor_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_aperture_policy_language_v1_AddressExtractor_descriptor;
  static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_aperture_policy_language_v1_AddressExtractor_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_aperture_policy_language_v1_JWTExtractor_descriptor;
  static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_aperture_policy_language_v1_JWTExtractor_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_aperture_policy_language_v1_PathTemplateMatcher_descriptor;
  static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_aperture_policy_language_v1_PathTemplateMatcher_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_aperture_policy_language_v1_PathTemplateMatcher_TemplateValuesEntry_descriptor;
  static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_aperture_policy_language_v1_PathTemplateMatcher_TemplateValuesEntry_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n,aperture/policy/language/v1/classifier" +
      ".proto\022\033aperture.policy.language.v1\032*ape" +
      "rture/common/selector/v1/selector.proto\032" +
      ".protoc-gen-openapiv2/options/annotation" +
      "s.proto\"\346\002\n\nClassifier\022d\n\010selector\030\001 \001(\013" +
      "2%.aperture.common.selector.v1.SelectorB" +
      "!\222A\036\202\003\033\n\rx-go-validate\022\n\032\010requiredR\010sele" +
      "ctor\022\224\001\n\005rules\030\002 \003(\01322.aperture.policy.l" +
      "anguage.v1.Classifier.RulesEntryBJ\222AG\202\003D" +
      "\n\rx-go-validate\0223\0321required,gt=0,dive,ke" +
      "ys,required,endkeys,requiredR\005rules\032[\n\nR" +
      "ulesEntry\022\020\n\003key\030\001 \001(\tR\003key\0227\n\005value\030\002 \001" +
      "(\0132!.aperture.policy.language.v1.RuleR\005v" +
      "alue:\0028\001\"\323\002\n\004Rule\022F\n\textractor\030\001 \001(\0132&.a" +
      "perture.policy.language.v1.ExtractorH\000R\t" +
      "extractor\022<\n\004rego\030\002 \001(\0132&.aperture.polic" +
      "y.language.v1.Rule.RegoH\000R\004rego\022?\n\ttelem" +
      "etry\030\003 \001(\010B!\222A\036\202\003\033\n\rx-go-validate\022\n\032\010req" +
      "uiredR\ttelemetry\032z\n\004Rego\0229\n\006source\030\001 \001(\t" +
      "B!\222A\036\202\003\033\n\rx-go-validate\022\n\032\010requiredR\006sou" +
      "rce\0227\n\005query\030\002 \001(\tB!\222A\036\202\003\033\n\rx-go-validat" +
      "e\022\n\032\010requiredR\005queryB\010\n\006source\"\323\002\n\tExtra" +
      "ctor\022\024\n\004from\030\001 \001(\tH\000R\004from\022@\n\004json\030\002 \001(\013" +
      "2*.aperture.policy.language.v1.JSONExtra" +
      "ctorH\000R\004json\022I\n\007address\030\003 \001(\0132-.aperture" +
      ".policy.language.v1.AddressExtractorH\000R\007" +
      "address\022=\n\003jwt\030\004 \001(\0132).aperture.policy.l" +
      "anguage.v1.JWTExtractorH\000R\003jwt\022Y\n\016path_t" +
      "emplates\030\005 \001(\01320.aperture.policy.languag" +
      "e.v1.PathTemplateMatcherH\000R\rpathTemplate" +
      "sB\t\n\007variant\"`\n\rJSONExtractor\0225\n\004from\030\001 " +
      "\001(\tB!\222A\036\202\003\033\n\rx-go-validate\022\n\032\010requiredR\004" +
      "from\022\030\n\007pointer\030\002 \001(\tR\007pointer\"I\n\020Addres" +
      "sExtractor\0225\n\004from\030\001 \001(\tB!\222A\036\202\003\033\n\rx-go-v" +
      "alidate\022\n\032\010requiredR\004from\"h\n\014JWTExtracto" +
      "r\0225\n\004from\030\001 \001(\tB!\222A\036\202\003\033\n\rx-go-validate\022\n" +
      "\032\010requiredR\004from\022!\n\014json_pointer\030\002 \001(\tR\013" +
      "jsonPointer\"\353\001\n\023PathTemplateMatcher\022\220\001\n\017" +
      "template_values\030\001 \003(\0132D.aperture.policy." +
      "language.v1.PathTemplateMatcher.Template" +
      "ValuesEntryB!\222A\036\202\003\033\n\rx-go-validate\022\n\032\010re" +
      "quiredR\016templateValues\032A\n\023TemplateValues" +
      "Entry\022\020\n\003key\030\001 \001(\tR\003key\022\024\n\005value\030\002 \001(\tR\005" +
      "value:\0028\001B\230\002\n\037com.aperture.policy.langua" +
      "ge.v1B\017ClassifierProtoP\001ZUgithub.com/flu" +
      "xninja/aperture/api/gen/proto/go/apertur" +
      "e/policy/language/v1;languagev1\242\002\003APL\252\002\033" +
      "Aperture.Policy.Language.V1\312\002\033Aperture\\P" +
      "olicy\\Language\\V1\342\002\'Aperture\\Policy\\Lang" +
      "uage\\V1\\GPBMetadata\352\002\036Aperture::Policy::" +
      "Language::V1b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.aperture.common.selector.v1.SelectorProto.getDescriptor(),
          com.grpc.gateway.protoc_gen_openapiv2.options.AnnotationsProto.getDescriptor(),
        });
    internal_static_aperture_policy_language_v1_Classifier_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_aperture_policy_language_v1_Classifier_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_aperture_policy_language_v1_Classifier_descriptor,
        new java.lang.String[] { "Selector", "Rules", });
    internal_static_aperture_policy_language_v1_Classifier_RulesEntry_descriptor =
      internal_static_aperture_policy_language_v1_Classifier_descriptor.getNestedTypes().get(0);
    internal_static_aperture_policy_language_v1_Classifier_RulesEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_aperture_policy_language_v1_Classifier_RulesEntry_descriptor,
        new java.lang.String[] { "Key", "Value", });
    internal_static_aperture_policy_language_v1_Rule_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_aperture_policy_language_v1_Rule_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_aperture_policy_language_v1_Rule_descriptor,
        new java.lang.String[] { "Extractor", "Rego", "Telemetry", "Source", });
    internal_static_aperture_policy_language_v1_Rule_Rego_descriptor =
      internal_static_aperture_policy_language_v1_Rule_descriptor.getNestedTypes().get(0);
    internal_static_aperture_policy_language_v1_Rule_Rego_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_aperture_policy_language_v1_Rule_Rego_descriptor,
        new java.lang.String[] { "Source", "Query", });
    internal_static_aperture_policy_language_v1_Extractor_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_aperture_policy_language_v1_Extractor_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_aperture_policy_language_v1_Extractor_descriptor,
        new java.lang.String[] { "From", "Json", "Address", "Jwt", "PathTemplates", "Variant", });
    internal_static_aperture_policy_language_v1_JSONExtractor_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_aperture_policy_language_v1_JSONExtractor_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_aperture_policy_language_v1_JSONExtractor_descriptor,
        new java.lang.String[] { "From", "Pointer", });
    internal_static_aperture_policy_language_v1_AddressExtractor_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_aperture_policy_language_v1_AddressExtractor_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_aperture_policy_language_v1_AddressExtractor_descriptor,
        new java.lang.String[] { "From", });
    internal_static_aperture_policy_language_v1_JWTExtractor_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_aperture_policy_language_v1_JWTExtractor_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_aperture_policy_language_v1_JWTExtractor_descriptor,
        new java.lang.String[] { "From", "JsonPointer", });
    internal_static_aperture_policy_language_v1_PathTemplateMatcher_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_aperture_policy_language_v1_PathTemplateMatcher_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_aperture_policy_language_v1_PathTemplateMatcher_descriptor,
        new java.lang.String[] { "TemplateValues", });
    internal_static_aperture_policy_language_v1_PathTemplateMatcher_TemplateValuesEntry_descriptor =
      internal_static_aperture_policy_language_v1_PathTemplateMatcher_descriptor.getNestedTypes().get(0);
    internal_static_aperture_policy_language_v1_PathTemplateMatcher_TemplateValuesEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_aperture_policy_language_v1_PathTemplateMatcher_TemplateValuesEntry_descriptor,
        new java.lang.String[] { "Key", "Value", });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.grpc.gateway.protoc_gen_openapiv2.options.AnnotationsProto.openapiv2Field);
    com.google.protobuf.Descriptors.FileDescriptor
        .internalUpdateFileDescriptor(descriptor, registry);
    com.aperture.common.selector.v1.SelectorProto.getDescriptor();
    com.grpc.gateway.protoc_gen_openapiv2.options.AnnotationsProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
