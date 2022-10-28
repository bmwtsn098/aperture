// Code generated by protoc-gen-go. DO NOT EDIT.
// versions:
// 	protoc-gen-go v1.27.1
// 	protoc        (unknown)
// source: aperture/policy/sync/v1/flux_meter.proto

package syncv1

import (
	v1 "github.com/fluxninja/aperture/api/gen/proto/go/aperture/policy/language/v1"
	protoreflect "google.golang.org/protobuf/reflect/protoreflect"
	protoimpl "google.golang.org/protobuf/runtime/protoimpl"
	reflect "reflect"
	sync "sync"
)

const (
	// Verify that this generated code is sufficiently up-to-date.
	_ = protoimpl.EnforceVersion(20 - protoimpl.MinVersion)
	// Verify that runtime/protoimpl is sufficiently up-to-date.
	_ = protoimpl.EnforceVersion(protoimpl.MaxVersion - 20)
)

type FluxMeterWrapper struct {
	state         protoimpl.MessageState
	sizeCache     protoimpl.SizeCache
	unknownFields protoimpl.UnknownFields

	// Flux Meter
	FluxMeter *v1.FluxMeter `protobuf:"bytes,1,opt,name=flux_meter,json=fluxMeter,proto3" json:"flux_meter,omitempty"`
	// Name of Flux Meter metric.
	FluxMeterName string `protobuf:"bytes,4,opt,name=flux_meter_name,json=fluxMeterName,proto3" json:"flux_meter_name,omitempty"`
}

func (x *FluxMeterWrapper) Reset() {
	*x = FluxMeterWrapper{}
	if protoimpl.UnsafeEnabled {
		mi := &file_aperture_policy_sync_v1_flux_meter_proto_msgTypes[0]
		ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
		ms.StoreMessageInfo(mi)
	}
}

func (x *FluxMeterWrapper) String() string {
	return protoimpl.X.MessageStringOf(x)
}

func (*FluxMeterWrapper) ProtoMessage() {}

func (x *FluxMeterWrapper) ProtoReflect() protoreflect.Message {
	mi := &file_aperture_policy_sync_v1_flux_meter_proto_msgTypes[0]
	if protoimpl.UnsafeEnabled && x != nil {
		ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
		if ms.LoadMessageInfo() == nil {
			ms.StoreMessageInfo(mi)
		}
		return ms
	}
	return mi.MessageOf(x)
}

// Deprecated: Use FluxMeterWrapper.ProtoReflect.Descriptor instead.
func (*FluxMeterWrapper) Descriptor() ([]byte, []int) {
	return file_aperture_policy_sync_v1_flux_meter_proto_rawDescGZIP(), []int{0}
}

func (x *FluxMeterWrapper) GetFluxMeter() *v1.FluxMeter {
	if x != nil {
		return x.FluxMeter
	}
	return nil
}

func (x *FluxMeterWrapper) GetFluxMeterName() string {
	if x != nil {
		return x.FluxMeterName
	}
	return ""
}

var File_aperture_policy_sync_v1_flux_meter_proto protoreflect.FileDescriptor

var file_aperture_policy_sync_v1_flux_meter_proto_rawDesc = []byte{
	0x0a, 0x28, 0x61, 0x70, 0x65, 0x72, 0x74, 0x75, 0x72, 0x65, 0x2f, 0x70, 0x6f, 0x6c, 0x69, 0x63,
	0x79, 0x2f, 0x73, 0x79, 0x6e, 0x63, 0x2f, 0x76, 0x31, 0x2f, 0x66, 0x6c, 0x75, 0x78, 0x5f, 0x6d,
	0x65, 0x74, 0x65, 0x72, 0x2e, 0x70, 0x72, 0x6f, 0x74, 0x6f, 0x12, 0x17, 0x61, 0x70, 0x65, 0x72,
	0x74, 0x75, 0x72, 0x65, 0x2e, 0x70, 0x6f, 0x6c, 0x69, 0x63, 0x79, 0x2e, 0x73, 0x79, 0x6e, 0x63,
	0x2e, 0x76, 0x31, 0x1a, 0x2b, 0x61, 0x70, 0x65, 0x72, 0x74, 0x75, 0x72, 0x65, 0x2f, 0x70, 0x6f,
	0x6c, 0x69, 0x63, 0x79, 0x2f, 0x6c, 0x61, 0x6e, 0x67, 0x75, 0x61, 0x67, 0x65, 0x2f, 0x76, 0x31,
	0x2f, 0x66, 0x6c, 0x75, 0x78, 0x6d, 0x65, 0x74, 0x65, 0x72, 0x2e, 0x70, 0x72, 0x6f, 0x74, 0x6f,
	0x22, 0x81, 0x01, 0x0a, 0x10, 0x46, 0x6c, 0x75, 0x78, 0x4d, 0x65, 0x74, 0x65, 0x72, 0x57, 0x72,
	0x61, 0x70, 0x70, 0x65, 0x72, 0x12, 0x45, 0x0a, 0x0a, 0x66, 0x6c, 0x75, 0x78, 0x5f, 0x6d, 0x65,
	0x74, 0x65, 0x72, 0x18, 0x01, 0x20, 0x01, 0x28, 0x0b, 0x32, 0x26, 0x2e, 0x61, 0x70, 0x65, 0x72,
	0x74, 0x75, 0x72, 0x65, 0x2e, 0x70, 0x6f, 0x6c, 0x69, 0x63, 0x79, 0x2e, 0x6c, 0x61, 0x6e, 0x67,
	0x75, 0x61, 0x67, 0x65, 0x2e, 0x76, 0x31, 0x2e, 0x46, 0x6c, 0x75, 0x78, 0x4d, 0x65, 0x74, 0x65,
	0x72, 0x52, 0x09, 0x66, 0x6c, 0x75, 0x78, 0x4d, 0x65, 0x74, 0x65, 0x72, 0x12, 0x26, 0x0a, 0x0f,
	0x66, 0x6c, 0x75, 0x78, 0x5f, 0x6d, 0x65, 0x74, 0x65, 0x72, 0x5f, 0x6e, 0x61, 0x6d, 0x65, 0x18,
	0x04, 0x20, 0x01, 0x28, 0x09, 0x52, 0x0d, 0x66, 0x6c, 0x75, 0x78, 0x4d, 0x65, 0x74, 0x65, 0x72,
	0x4e, 0x61, 0x6d, 0x65, 0x42, 0x85, 0x02, 0x0a, 0x25, 0x63, 0x6f, 0x6d, 0x2e, 0x66, 0x6c, 0x75,
	0x78, 0x6e, 0x69, 0x6e, 0x6a, 0x61, 0x2e, 0x61, 0x70, 0x65, 0x72, 0x74, 0x75, 0x72, 0x65, 0x2e,
	0x70, 0x6f, 0x6c, 0x69, 0x63, 0x79, 0x2e, 0x73, 0x79, 0x6e, 0x63, 0x2e, 0x76, 0x31, 0x42, 0x0e,
	0x46, 0x6c, 0x75, 0x78, 0x4d, 0x65, 0x74, 0x65, 0x72, 0x50, 0x72, 0x6f, 0x74, 0x6f, 0x50, 0x01,
	0x5a, 0x4d, 0x67, 0x69, 0x74, 0x68, 0x75, 0x62, 0x2e, 0x63, 0x6f, 0x6d, 0x2f, 0x66, 0x6c, 0x75,
	0x78, 0x6e, 0x69, 0x6e, 0x6a, 0x61, 0x2f, 0x61, 0x70, 0x65, 0x72, 0x74, 0x75, 0x72, 0x65, 0x2f,
	0x61, 0x70, 0x69, 0x2f, 0x67, 0x65, 0x6e, 0x2f, 0x70, 0x72, 0x6f, 0x74, 0x6f, 0x2f, 0x67, 0x6f,
	0x2f, 0x61, 0x70, 0x65, 0x72, 0x74, 0x75, 0x72, 0x65, 0x2f, 0x70, 0x6f, 0x6c, 0x69, 0x63, 0x79,
	0x2f, 0x73, 0x79, 0x6e, 0x63, 0x2f, 0x76, 0x31, 0x3b, 0x73, 0x79, 0x6e, 0x63, 0x76, 0x31, 0xa2,
	0x02, 0x03, 0x41, 0x50, 0x53, 0xaa, 0x02, 0x17, 0x41, 0x70, 0x65, 0x72, 0x74, 0x75, 0x72, 0x65,
	0x2e, 0x50, 0x6f, 0x6c, 0x69, 0x63, 0x79, 0x2e, 0x53, 0x79, 0x6e, 0x63, 0x2e, 0x56, 0x31, 0xca,
	0x02, 0x17, 0x41, 0x70, 0x65, 0x72, 0x74, 0x75, 0x72, 0x65, 0x5c, 0x50, 0x6f, 0x6c, 0x69, 0x63,
	0x79, 0x5c, 0x53, 0x79, 0x6e, 0x63, 0x5c, 0x56, 0x31, 0xe2, 0x02, 0x23, 0x41, 0x70, 0x65, 0x72,
	0x74, 0x75, 0x72, 0x65, 0x5c, 0x50, 0x6f, 0x6c, 0x69, 0x63, 0x79, 0x5c, 0x53, 0x79, 0x6e, 0x63,
	0x5c, 0x56, 0x31, 0x5c, 0x47, 0x50, 0x42, 0x4d, 0x65, 0x74, 0x61, 0x64, 0x61, 0x74, 0x61, 0xea,
	0x02, 0x1a, 0x41, 0x70, 0x65, 0x72, 0x74, 0x75, 0x72, 0x65, 0x3a, 0x3a, 0x50, 0x6f, 0x6c, 0x69,
	0x63, 0x79, 0x3a, 0x3a, 0x53, 0x79, 0x6e, 0x63, 0x3a, 0x3a, 0x56, 0x31, 0x62, 0x06, 0x70, 0x72,
	0x6f, 0x74, 0x6f, 0x33,
}

var (
	file_aperture_policy_sync_v1_flux_meter_proto_rawDescOnce sync.Once
	file_aperture_policy_sync_v1_flux_meter_proto_rawDescData = file_aperture_policy_sync_v1_flux_meter_proto_rawDesc
)

func file_aperture_policy_sync_v1_flux_meter_proto_rawDescGZIP() []byte {
	file_aperture_policy_sync_v1_flux_meter_proto_rawDescOnce.Do(func() {
		file_aperture_policy_sync_v1_flux_meter_proto_rawDescData = protoimpl.X.CompressGZIP(file_aperture_policy_sync_v1_flux_meter_proto_rawDescData)
	})
	return file_aperture_policy_sync_v1_flux_meter_proto_rawDescData
}

var file_aperture_policy_sync_v1_flux_meter_proto_msgTypes = make([]protoimpl.MessageInfo, 1)
var file_aperture_policy_sync_v1_flux_meter_proto_goTypes = []interface{}{
	(*FluxMeterWrapper)(nil), // 0: aperture.policy.sync.v1.FluxMeterWrapper
	(*v1.FluxMeter)(nil),     // 1: aperture.policy.language.v1.FluxMeter
}
var file_aperture_policy_sync_v1_flux_meter_proto_depIdxs = []int32{
	1, // 0: aperture.policy.sync.v1.FluxMeterWrapper.flux_meter:type_name -> aperture.policy.language.v1.FluxMeter
	1, // [1:1] is the sub-list for method output_type
	1, // [1:1] is the sub-list for method input_type
	1, // [1:1] is the sub-list for extension type_name
	1, // [1:1] is the sub-list for extension extendee
	0, // [0:1] is the sub-list for field type_name
}

func init() { file_aperture_policy_sync_v1_flux_meter_proto_init() }
func file_aperture_policy_sync_v1_flux_meter_proto_init() {
	if File_aperture_policy_sync_v1_flux_meter_proto != nil {
		return
	}
	if !protoimpl.UnsafeEnabled {
		file_aperture_policy_sync_v1_flux_meter_proto_msgTypes[0].Exporter = func(v interface{}, i int) interface{} {
			switch v := v.(*FluxMeterWrapper); i {
			case 0:
				return &v.state
			case 1:
				return &v.sizeCache
			case 2:
				return &v.unknownFields
			default:
				return nil
			}
		}
	}
	type x struct{}
	out := protoimpl.TypeBuilder{
		File: protoimpl.DescBuilder{
			GoPackagePath: reflect.TypeOf(x{}).PkgPath(),
			RawDescriptor: file_aperture_policy_sync_v1_flux_meter_proto_rawDesc,
			NumEnums:      0,
			NumMessages:   1,
			NumExtensions: 0,
			NumServices:   0,
		},
		GoTypes:           file_aperture_policy_sync_v1_flux_meter_proto_goTypes,
		DependencyIndexes: file_aperture_policy_sync_v1_flux_meter_proto_depIdxs,
		MessageInfos:      file_aperture_policy_sync_v1_flux_meter_proto_msgTypes,
	}.Build()
	File_aperture_policy_sync_v1_flux_meter_proto = out.File
	file_aperture_policy_sync_v1_flux_meter_proto_rawDesc = nil
	file_aperture_policy_sync_v1_flux_meter_proto_goTypes = nil
	file_aperture_policy_sync_v1_flux_meter_proto_depIdxs = nil
}
