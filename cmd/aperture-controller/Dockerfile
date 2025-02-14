# syntax=docker/dockerfile:1
FROM golang:1.19-buster AS base

WORKDIR /src
COPY --link . .

RUN --mount=type=cache,target=/go/pkg/ \
  --mount=type=cache,target=/root/.cache/go-build/ \
  go mod download

# App build
ARG GIT_COMMIT_HASH
ENV GIT_COMMIT_HASH=${GIT_COMMIT_HASH}
ARG GIT_BRANCH
ENV GIT_BRANCH=${GIT_BRANCH}
ARG VERSION
ENV VERSION=${VERSION}
ARG RACE
ENV RACE=${RACE}

FROM base AS builder
RUN --mount=type=cache,target=/go/pkg/ \
  --mount=type=cache,target=/root/.cache/go-build/ \
  CGO_ENABLED=1 TARGET="/aperture-controller" PREFIX="aperture" SOURCE="./cmd/aperture-controller" \
  LDFLAGS="-s -w -extldflags \"-Wl,--allow-multiple-definition\"" \
  ./pkg/info/build.sh


# BUILD PLUGINS STAGE
FROM base AS plugins-builder
RUN --mount=type=cache,target=/go/pkg/ \
  --mount=type=cache,target=/root/.cache/go-build/ \
  /bin/bash -c \
  'set -euo pipefail; \
  shopt -s nullglob; \
  for plugin in ./plugins/{service,controller}/aperture-plugin-*; do\
    echo "building plugin $plugin";\
    CGO_ENABLED=1 TARGET="/plugins/$(basename $plugin).so" PREFIX="aperture" SOURCE="$plugin" \
    LDFLAGS="-s -w -extldflags \"-Wl,--allow-multiple-definition\"" \
      ./pkg/plugins/build.sh;\
  done\
  '

# Final image
FROM alpine:3.15.0
# Needed for linker to be compatible
RUN apk add --no-cache libc6-compat
RUN apk add --no-cache curl
RUN mkdir -p /etc/aperture/aperture-controller/classifiers /etc/aperture/aperture-controller/policies /opt/aperture/aperture-controller/plugins
COPY --link --from=builder /aperture-controller /aperture-controller
COPY --link --from=plugins-builder /plugins /opt/aperture/aperture-controller/plugins
CMD ["/aperture-controller"]
