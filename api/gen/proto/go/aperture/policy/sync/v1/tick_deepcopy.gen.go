// Code generated by protoc-gen-deepcopy. DO NOT EDIT.
package syncv1

import (
	proto "google.golang.org/protobuf/proto"
)

// DeepCopyInto supports using TickInfo within kubernetes types, where deepcopy-gen is used.
func (in *TickInfo) DeepCopyInto(out *TickInfo) {
	p := proto.Clone(in).(*TickInfo)
	*out = *p
}

// DeepCopy is an autogenerated deepcopy function, copying the receiver, creating a new TickInfo. Required by controller-gen.
func (in *TickInfo) DeepCopy() *TickInfo {
	if in == nil {
		return nil
	}
	out := new(TickInfo)
	in.DeepCopyInto(out)
	return out
}

// DeepCopyInterface is an autogenerated deepcopy function, copying the receiver, creating a new TickInfo. Required by controller-gen.
func (in *TickInfo) DeepCopyInterface() interface{} {
	return in.DeepCopy()
}
