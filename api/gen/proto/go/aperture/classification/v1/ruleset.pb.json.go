// Code generated by protoc-gen-go-json. DO NOT EDIT.
// source: aperture/classification/v1/ruleset.proto

package classificationv1

import (
	"google.golang.org/protobuf/encoding/protojson"
)

// MarshalJSON implements json.Marshaler
func (msg *AllRulesResponse) MarshalJSON() ([]byte, error) {
	return protojson.MarshalOptions{
		UseEnumNumbers:  false,
		EmitUnpopulated: true,
		UseProtoNames:   true,
	}.Marshal(msg)
}

// UnmarshalJSON implements json.Unmarshaler
func (msg *AllRulesResponse) UnmarshalJSON(b []byte) error {
	return protojson.UnmarshalOptions{
		DiscardUnknown: false,
	}.Unmarshal(b, msg)
}

// MarshalJSON implements json.Marshaler
func (msg *AllRules) MarshalJSON() ([]byte, error) {
	return protojson.MarshalOptions{
		UseEnumNumbers:  false,
		EmitUnpopulated: true,
		UseProtoNames:   true,
	}.Marshal(msg)
}

// UnmarshalJSON implements json.Unmarshaler
func (msg *AllRules) UnmarshalJSON(b []byte) error {
	return protojson.UnmarshalOptions{
		DiscardUnknown: false,
	}.Unmarshal(b, msg)
}

// MarshalJSON implements json.Marshaler
func (msg *Classifier) MarshalJSON() ([]byte, error) {
	return protojson.MarshalOptions{
		UseEnumNumbers:  false,
		EmitUnpopulated: true,
		UseProtoNames:   true,
	}.Marshal(msg)
}

// UnmarshalJSON implements json.Unmarshaler
func (msg *Classifier) UnmarshalJSON(b []byte) error {
	return protojson.UnmarshalOptions{
		DiscardUnknown: false,
	}.Unmarshal(b, msg)
}

// MarshalJSON implements json.Marshaler
func (msg *Rule) MarshalJSON() ([]byte, error) {
	return protojson.MarshalOptions{
		UseEnumNumbers:  false,
		EmitUnpopulated: true,
		UseProtoNames:   true,
	}.Marshal(msg)
}

// UnmarshalJSON implements json.Unmarshaler
func (msg *Rule) UnmarshalJSON(b []byte) error {
	return protojson.UnmarshalOptions{
		DiscardUnknown: false,
	}.Unmarshal(b, msg)
}

// MarshalJSON implements json.Marshaler
func (msg *Rule_Rego) MarshalJSON() ([]byte, error) {
	return protojson.MarshalOptions{
		UseEnumNumbers:  false,
		EmitUnpopulated: true,
		UseProtoNames:   true,
	}.Marshal(msg)
}

// UnmarshalJSON implements json.Unmarshaler
func (msg *Rule_Rego) UnmarshalJSON(b []byte) error {
	return protojson.UnmarshalOptions{
		DiscardUnknown: false,
	}.Unmarshal(b, msg)
}
