// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: aperture/common/labelmatcher/v1/labelmatcher.proto

package com.aperture.common.labelmatcher.v1;

public final class LabelmatcherProto {
  private LabelmatcherProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_aperture_common_labelmatcher_v1_LabelMatcher_descriptor;
  static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_aperture_common_labelmatcher_v1_LabelMatcher_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_aperture_common_labelmatcher_v1_LabelMatcher_MatchLabelsEntry_descriptor;
  static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_aperture_common_labelmatcher_v1_LabelMatcher_MatchLabelsEntry_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_aperture_common_labelmatcher_v1_K8sLabelMatcherRequirement_descriptor;
  static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_aperture_common_labelmatcher_v1_K8sLabelMatcherRequirement_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_aperture_common_labelmatcher_v1_MatchExpression_descriptor;
  static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_aperture_common_labelmatcher_v1_MatchExpression_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_aperture_common_labelmatcher_v1_MatchExpression_List_descriptor;
  static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_aperture_common_labelmatcher_v1_MatchExpression_List_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_aperture_common_labelmatcher_v1_EqualsMatchExpression_descriptor;
  static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_aperture_common_labelmatcher_v1_EqualsMatchExpression_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_aperture_common_labelmatcher_v1_MatchesMatchExpression_descriptor;
  static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_aperture_common_labelmatcher_v1_MatchesMatchExpression_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n2aperture/common/labelmatcher/v1/labelm" +
      "atcher.proto\022\037aperture.common.labelmatch" +
      "er.v1\032.protoc-gen-openapiv2/options/anno" +
      "tations.proto\"\355\002\n\014LabelMatcher\022a\n\014match_" +
      "labels\030\001 \003(\0132>.aperture.common.labelmatc" +
      "her.v1.LabelMatcher.MatchLabelsEntryR\013ma" +
      "tchLabels\022h\n\021match_expressions\030\002 \003(\0132;.a" +
      "perture.common.labelmatcher.v1.K8sLabelM" +
      "atcherRequirementR\020matchExpressions\022P\n\ne" +
      "xpression\030\003 \001(\01320.aperture.common.labelm" +
      "atcher.v1.MatchExpressionR\nexpression\032>\n" +
      "\020MatchLabelsEntry\022\020\n\003key\030\001 \001(\tR\003key\022\024\n\005v" +
      "alue\030\002 \001(\tR\005value:\0028\001\"\303\001\n\032K8sLabelMatche" +
      "rRequirement\0223\n\003key\030\001 \001(\tB!\222A\036\202\003\033\n\rx-go-" +
      "validate\022\n\032\010requiredR\003key\022X\n\010operator\030\002 " +
      "\001(\tB<\222A9\202\0036\n\rx-go-validate\022%\032#oneof=In N" +
      "otIn Exists DoesNotExistsR\010operator\022\026\n\006v" +
      "alues\030\003 \003(\tR\006values\"\307\004\n\017MatchExpression\022" +
      "D\n\003not\030\001 \001(\01320.aperture.common.labelmatc" +
      "her.v1.MatchExpressionH\000R\003not\022I\n\003all\030\002 \001" +
      "(\01325.aperture.common.labelmatcher.v1.Mat" +
      "chExpression.ListH\000R\003all\022I\n\003any\030\003 \001(\01325." +
      "aperture.common.labelmatcher.v1.MatchExp" +
      "ression.ListH\000R\003any\022F\n\014label_exists\030\004 \001(" +
      "\tB!\222A\036\202\003\033\n\rx-go-validate\022\n\032\010requiredH\000R\013" +
      "labelExists\022[\n\014label_equals\030\005 \001(\01326.aper" +
      "ture.common.labelmatcher.v1.EqualsMatchE" +
      "xpressionH\000R\013labelEquals\022^\n\rlabel_matche" +
      "s\030\006 \001(\01327.aperture.common.labelmatcher.v" +
      "1.MatchesMatchExpressionH\000R\014labelMatches" +
      "\032H\n\004List\022@\n\002of\030\001 \003(\01320.aperture.common.l" +
      "abelmatcher.v1.MatchExpressionR\002ofB\t\n\007va" +
      "riant\"f\n\025EqualsMatchExpression\0227\n\005label\030" +
      "\001 \001(\tB!\222A\036\202\003\033\n\rx-go-validate\022\n\032\010required" +
      "R\005label\022\024\n\005value\030\002 \001(\tR\005value\"\212\001\n\026Matche" +
      "sMatchExpression\0227\n\005label\030\001 \001(\tB!\222A\036\202\003\033\n" +
      "\rx-go-validate\022\n\032\010requiredR\005label\0227\n\005reg" +
      "ex\030\002 \001(\tB!\222A\036\202\003\033\n\rx-go-validate\022\n\032\010requi" +
      "redR\005regexB\266\002\n#com.aperture.common.label" +
      "matcher.v1B\021LabelmatcherProtoP\001Z]github." +
      "com/fluxninja/aperture/api/gen/proto/go/" +
      "aperture/common/labelmatcher/v1;labelmat" +
      "cherv1\242\002\003ACL\252\002\037Aperture.Common.Labelmatc" +
      "her.V1\312\002\037Aperture\\Common\\Labelmatcher\\V1" +
      "\342\002+Aperture\\Common\\Labelmatcher\\V1\\GPBMe" +
      "tadata\352\002\"Aperture::Common::Labelmatcher:" +
      ":V1b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.grpc.gateway.protoc_gen_openapiv2.options.AnnotationsProto.getDescriptor(),
        });
    internal_static_aperture_common_labelmatcher_v1_LabelMatcher_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_aperture_common_labelmatcher_v1_LabelMatcher_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_aperture_common_labelmatcher_v1_LabelMatcher_descriptor,
        new java.lang.String[] { "MatchLabels", "MatchExpressions", "Expression", });
    internal_static_aperture_common_labelmatcher_v1_LabelMatcher_MatchLabelsEntry_descriptor =
      internal_static_aperture_common_labelmatcher_v1_LabelMatcher_descriptor.getNestedTypes().get(0);
    internal_static_aperture_common_labelmatcher_v1_LabelMatcher_MatchLabelsEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_aperture_common_labelmatcher_v1_LabelMatcher_MatchLabelsEntry_descriptor,
        new java.lang.String[] { "Key", "Value", });
    internal_static_aperture_common_labelmatcher_v1_K8sLabelMatcherRequirement_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_aperture_common_labelmatcher_v1_K8sLabelMatcherRequirement_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_aperture_common_labelmatcher_v1_K8sLabelMatcherRequirement_descriptor,
        new java.lang.String[] { "Key", "Operator", "Values", });
    internal_static_aperture_common_labelmatcher_v1_MatchExpression_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_aperture_common_labelmatcher_v1_MatchExpression_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_aperture_common_labelmatcher_v1_MatchExpression_descriptor,
        new java.lang.String[] { "Not", "All", "Any", "LabelExists", "LabelEquals", "LabelMatches", "Variant", });
    internal_static_aperture_common_labelmatcher_v1_MatchExpression_List_descriptor =
      internal_static_aperture_common_labelmatcher_v1_MatchExpression_descriptor.getNestedTypes().get(0);
    internal_static_aperture_common_labelmatcher_v1_MatchExpression_List_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_aperture_common_labelmatcher_v1_MatchExpression_List_descriptor,
        new java.lang.String[] { "Of", });
    internal_static_aperture_common_labelmatcher_v1_EqualsMatchExpression_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_aperture_common_labelmatcher_v1_EqualsMatchExpression_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_aperture_common_labelmatcher_v1_EqualsMatchExpression_descriptor,
        new java.lang.String[] { "Label", "Value", });
    internal_static_aperture_common_labelmatcher_v1_MatchesMatchExpression_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_aperture_common_labelmatcher_v1_MatchesMatchExpression_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_aperture_common_labelmatcher_v1_MatchesMatchExpression_descriptor,
        new java.lang.String[] { "Label", "Regex", });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.grpc.gateway.protoc_gen_openapiv2.options.AnnotationsProto.openapiv2Field);
    com.google.protobuf.Descriptors.FileDescriptor
        .internalUpdateFileDescriptor(descriptor, registry);
    com.grpc.gateway.protoc_gen_openapiv2.options.AnnotationsProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
