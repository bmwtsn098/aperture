// Code generated by protoc-gen-go-grpc. DO NOT EDIT.

package statusv1

import (
	context "context"
	grpc "google.golang.org/grpc"
	codes "google.golang.org/grpc/codes"
	status "google.golang.org/grpc/status"
	emptypb "google.golang.org/protobuf/types/known/emptypb"
)

// This is a compile-time assertion to ensure that this generated file
// is compatible with the grpc package it is being compiled against.
// Requires gRPC-Go v1.32.0 or later.
const _ = grpc.SupportPackageIsVersion7

// StatusServiceClient is the client API for StatusService service.
//
// For semantics around ctx use and closing/ending streaming RPCs, please refer to https://pkg.go.dev/google.golang.org/grpc/?tab=doc#ClientConn.NewStream.
type StatusServiceClient interface {
	GetGroupStatus(ctx context.Context, in *GroupStatusRequest, opts ...grpc.CallOption) (*GroupStatus, error)
	GetGroups(ctx context.Context, in *emptypb.Empty, opts ...grpc.CallOption) (*Groups, error)
}

type statusServiceClient struct {
	cc grpc.ClientConnInterface
}

func NewStatusServiceClient(cc grpc.ClientConnInterface) StatusServiceClient {
	return &statusServiceClient{cc}
}

func (c *statusServiceClient) GetGroupStatus(ctx context.Context, in *GroupStatusRequest, opts ...grpc.CallOption) (*GroupStatus, error) {
	out := new(GroupStatus)
	err := c.cc.Invoke(ctx, "/aperture.common.status.v1.StatusService/GetGroupStatus", in, out, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func (c *statusServiceClient) GetGroups(ctx context.Context, in *emptypb.Empty, opts ...grpc.CallOption) (*Groups, error) {
	out := new(Groups)
	err := c.cc.Invoke(ctx, "/aperture.common.status.v1.StatusService/GetGroups", in, out, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

// StatusServiceServer is the server API for StatusService service.
// All implementations should embed UnimplementedStatusServiceServer
// for forward compatibility
type StatusServiceServer interface {
	GetGroupStatus(context.Context, *GroupStatusRequest) (*GroupStatus, error)
	GetGroups(context.Context, *emptypb.Empty) (*Groups, error)
}

// UnimplementedStatusServiceServer should be embedded to have forward compatible implementations.
type UnimplementedStatusServiceServer struct {
}

func (UnimplementedStatusServiceServer) GetGroupStatus(context.Context, *GroupStatusRequest) (*GroupStatus, error) {
	return nil, status.Errorf(codes.Unimplemented, "method GetGroupStatus not implemented")
}
func (UnimplementedStatusServiceServer) GetGroups(context.Context, *emptypb.Empty) (*Groups, error) {
	return nil, status.Errorf(codes.Unimplemented, "method GetGroups not implemented")
}

// UnsafeStatusServiceServer may be embedded to opt out of forward compatibility for this service.
// Use of this interface is not recommended, as added methods to StatusServiceServer will
// result in compilation errors.
type UnsafeStatusServiceServer interface {
	mustEmbedUnimplementedStatusServiceServer()
}

func RegisterStatusServiceServer(s grpc.ServiceRegistrar, srv StatusServiceServer) {
	s.RegisterService(&StatusService_ServiceDesc, srv)
}

func _StatusService_GetGroupStatus_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error, interceptor grpc.UnaryServerInterceptor) (interface{}, error) {
	in := new(GroupStatusRequest)
	if err := dec(in); err != nil {
		return nil, err
	}
	if interceptor == nil {
		return srv.(StatusServiceServer).GetGroupStatus(ctx, in)
	}
	info := &grpc.UnaryServerInfo{
		Server:     srv,
		FullMethod: "/aperture.common.status.v1.StatusService/GetGroupStatus",
	}
	handler := func(ctx context.Context, req interface{}) (interface{}, error) {
		return srv.(StatusServiceServer).GetGroupStatus(ctx, req.(*GroupStatusRequest))
	}
	return interceptor(ctx, in, info, handler)
}

func _StatusService_GetGroups_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error, interceptor grpc.UnaryServerInterceptor) (interface{}, error) {
	in := new(emptypb.Empty)
	if err := dec(in); err != nil {
		return nil, err
	}
	if interceptor == nil {
		return srv.(StatusServiceServer).GetGroups(ctx, in)
	}
	info := &grpc.UnaryServerInfo{
		Server:     srv,
		FullMethod: "/aperture.common.status.v1.StatusService/GetGroups",
	}
	handler := func(ctx context.Context, req interface{}) (interface{}, error) {
		return srv.(StatusServiceServer).GetGroups(ctx, req.(*emptypb.Empty))
	}
	return interceptor(ctx, in, info, handler)
}

// StatusService_ServiceDesc is the grpc.ServiceDesc for StatusService service.
// It's only intended for direct use with grpc.RegisterService,
// and not to be introspected or modified (even as a copy)
var StatusService_ServiceDesc = grpc.ServiceDesc{
	ServiceName: "aperture.common.status.v1.StatusService",
	HandlerType: (*StatusServiceServer)(nil),
	Methods: []grpc.MethodDesc{
		{
			MethodName: "GetGroupStatus",
			Handler:    _StatusService_GetGroupStatus_Handler,
		},
		{
			MethodName: "GetGroups",
			Handler:    _StatusService_GetGroups_Handler,
		},
	},
	Streams:  []grpc.StreamDesc{},
	Metadata: "aperture/common/status/v1/status.proto",
}
