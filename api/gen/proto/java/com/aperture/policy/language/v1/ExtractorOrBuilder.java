// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: aperture/policy/language/v1/classifier.proto

package com.aperture.policy.language.v1;

public interface ExtractorOrBuilder extends
    // @@protoc_insertion_point(interface_extends:aperture.policy.language.v1.Extractor)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Use an attribute with no conversion
   * Attribute path is a dot-separated path to attribute.
   * Should be either:
   * * one of the fields of [Attribute Context][attribute-context], or
   * * a special "request.http.bearer" pseudo-attribute.
   * Eg. "request.http.method" or "request.http.header.user-agent"
   * Note: The same attribute path syntax is shared by other extractor variants,
   * wherever attribute path is needed in their "from" syntax.
   * Example:
   * ```yaml
   * from: request.http.headers.user-agent
   * ```
   * [attribute-context]: https://www.envoyproxy.io/docs/envoy/latest/api-v3/service/auth/v3/attribute_context.proto"
   * </pre>
   *
   * <code>string from = 1[json_name = "from"];</code>
   * @return The from.
   */
  java.lang.String getFrom();
  /**
   * <pre>
   * Use an attribute with no conversion
   * Attribute path is a dot-separated path to attribute.
   * Should be either:
   * * one of the fields of [Attribute Context][attribute-context], or
   * * a special "request.http.bearer" pseudo-attribute.
   * Eg. "request.http.method" or "request.http.header.user-agent"
   * Note: The same attribute path syntax is shared by other extractor variants,
   * wherever attribute path is needed in their "from" syntax.
   * Example:
   * ```yaml
   * from: request.http.headers.user-agent
   * ```
   * [attribute-context]: https://www.envoyproxy.io/docs/envoy/latest/api-v3/service/auth/v3/attribute_context.proto"
   * </pre>
   *
   * <code>string from = 1[json_name = "from"];</code>
   * @return The bytes for from.
   */
  com.google.protobuf.ByteString
      getFromBytes();

  /**
   * <pre>
   * Deserialize a json, and extract one of the fields.
   * </pre>
   *
   * <code>.aperture.policy.language.v1.JSONExtractor json = 2[json_name = "json"];</code>
   * @return Whether the json field is set.
   */
  boolean hasJson();
  /**
   * <pre>
   * Deserialize a json, and extract one of the fields.
   * </pre>
   *
   * <code>.aperture.policy.language.v1.JSONExtractor json = 2[json_name = "json"];</code>
   * @return The json.
   */
  com.aperture.policy.language.v1.JSONExtractor getJson();
  /**
   * <pre>
   * Deserialize a json, and extract one of the fields.
   * </pre>
   *
   * <code>.aperture.policy.language.v1.JSONExtractor json = 2[json_name = "json"];</code>
   */
  com.aperture.policy.language.v1.JSONExtractorOrBuilder getJsonOrBuilder();

  /**
   * <pre>
   * Display an address as a single string - `&lt;ip&gt;:&lt;port&gt;`.
   * </pre>
   *
   * <code>.aperture.policy.language.v1.AddressExtractor address = 3[json_name = "address"];</code>
   * @return Whether the address field is set.
   */
  boolean hasAddress();
  /**
   * <pre>
   * Display an address as a single string - `&lt;ip&gt;:&lt;port&gt;`.
   * </pre>
   *
   * <code>.aperture.policy.language.v1.AddressExtractor address = 3[json_name = "address"];</code>
   * @return The address.
   */
  com.aperture.policy.language.v1.AddressExtractor getAddress();
  /**
   * <pre>
   * Display an address as a single string - `&lt;ip&gt;:&lt;port&gt;`.
   * </pre>
   *
   * <code>.aperture.policy.language.v1.AddressExtractor address = 3[json_name = "address"];</code>
   */
  com.aperture.policy.language.v1.AddressExtractorOrBuilder getAddressOrBuilder();

  /**
   * <pre>
   * Parse the attribute as JWT and read the payload.
   * </pre>
   *
   * <code>.aperture.policy.language.v1.JWTExtractor jwt = 4[json_name = "jwt"];</code>
   * @return Whether the jwt field is set.
   */
  boolean hasJwt();
  /**
   * <pre>
   * Parse the attribute as JWT and read the payload.
   * </pre>
   *
   * <code>.aperture.policy.language.v1.JWTExtractor jwt = 4[json_name = "jwt"];</code>
   * @return The jwt.
   */
  com.aperture.policy.language.v1.JWTExtractor getJwt();
  /**
   * <pre>
   * Parse the attribute as JWT and read the payload.
   * </pre>
   *
   * <code>.aperture.policy.language.v1.JWTExtractor jwt = 4[json_name = "jwt"];</code>
   */
  com.aperture.policy.language.v1.JWTExtractorOrBuilder getJwtOrBuilder();

  /**
   * <pre>
   * Match HTTP Path to given path templates.
   * </pre>
   *
   * <code>.aperture.policy.language.v1.PathTemplateMatcher path_templates = 5[json_name = "pathTemplates"];</code>
   * @return Whether the pathTemplates field is set.
   */
  boolean hasPathTemplates();
  /**
   * <pre>
   * Match HTTP Path to given path templates.
   * </pre>
   *
   * <code>.aperture.policy.language.v1.PathTemplateMatcher path_templates = 5[json_name = "pathTemplates"];</code>
   * @return The pathTemplates.
   */
  com.aperture.policy.language.v1.PathTemplateMatcher getPathTemplates();
  /**
   * <pre>
   * Match HTTP Path to given path templates.
   * </pre>
   *
   * <code>.aperture.policy.language.v1.PathTemplateMatcher path_templates = 5[json_name = "pathTemplates"];</code>
   */
  com.aperture.policy.language.v1.PathTemplateMatcherOrBuilder getPathTemplatesOrBuilder();

  public com.aperture.policy.language.v1.Extractor.VariantCase getVariantCase();
}
