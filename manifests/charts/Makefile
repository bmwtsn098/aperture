SHELL := /bin/bash

generate-helm-readme:
	@{ \
		dirs=$$(find ./ -name 'values.yaml' -exec dirname {} \;); \
		for dir in $${dirs}; do \
			chart=$$(basename $${dir}); \
			echo "Generating README for $${chart}"; \
			npx @bitnami/readme-generator-for-helm -v $$dir/values.yaml -r $$dir/README.md; \
		done; \
		\
	}

helm-lint:
	@{ \
		dirs=$$(find ./ -name 'values.yaml' -exec dirname {} \;); \
		for dir in $${dirs}; do \
			chart=$$(basename $${dir}); \
			echo "Linting for $${chart}"; \
			helm lint $${chart};\
		done; \
		\
	}

.PHONY: generate-helm-readme helm-lint
