# syntax=docker/dockerfile:1
FROM golang:1.19-buster AS builder

WORKDIR /src

COPY --link . .

# App build
RUN --mount=type=cache,target=/go/pkg/ \
    --mount=type=cache,target=/root/.cache/go-build/ <<-EOF
    go mod download
    CGO_ENABLED=0 go build -ldflags="-w -s" -o /graphql_demo_app .
EOF

# Final image
FROM alpine:3.15.0
COPY --link --from=builder /graphql_demo_app /graphql_demo_app
ENTRYPOINT ["/graphql_demo_app"]
