#### Minikube
To deploy the ActiveMQ image, defined by the Dockerfile, to minikube run the commands below. Of course, make sure the image has been built and pushed to the image repository that you are using first.
```
kubectl apply -f namespace.yaml
kubectl apply -f amq-pod.yaml
kubectl apply -f amq-service.yaml
```

You can find the URL for the ```activemq-service``` in minikube by running ```minikube service --url activemq-service -n messaging```

#### Docker
If you want to just run the image in Docker you can run the command below. Again, make sure the image is built and pushed.
```
docker run -p 8161:8161 chriaass/k8s-active-mq:1.0.1
```
You should then be able to access the ActiveMQ web console on the host machine at http://localhost:8161/