IMG ?= kafka-template:latest

.PHONY: create-cluster
create-cluster:
	kind create cluster --config kafka-cluster-config.yaml

.PHONY: ingress-controller
ingress-controller:
	kubectl apply -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/main/deploy/static/provider/kind/deploy.yaml

.PHONY: ingress
ingress:
	kubectl apply -f kafka-cluster-ingress.yaml

.PHONY: kafka
kafka:
	kubectl create -f 'https://strimzi.io/install/latest?namespace=default'
	kubectl apply -f kafka-cluster.yaml

.PHONY: delete-cluster
delete-cluster:
	kind delete cluster

.PHONY: docker-build
docker-build:
	mvn clean package
	docker buildx build --tag ${IMG} .

.PHONY: deploy
deploy:
	kubectl apply -f kafka-template-deployment.yaml
	kubectl apply -f kafka-template-service.yaml

.PHONY: setup
setup:
	make docker-build
	make delete-cluster
	make create-cluster
	kind load docker-image ${IMG}