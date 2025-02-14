package status

import (
	"go.uber.org/fx"

	statusv1 "github.com/fluxninja/aperture/api/gen/proto/go/aperture/status/v1"
	"github.com/fluxninja/aperture/pkg/log"
	"github.com/fluxninja/aperture/pkg/net/grpcgateway"
)

// Module is a fx module that provides a status Registry and registers status service handlers as grpc-gateway handlers.
func Module() fx.Option {
	return fx.Options(
		fx.Provide(provideRegistry),
		grpcgateway.RegisterHandler{Handler: statusv1.RegisterStatusServiceHandlerFromEndpoint}.Annotate(),
		fx.Invoke(RegisterStatusService),
	)
}

func provideRegistry(logger *log.Logger) Registry {
	return NewRegistry(logger)
}
