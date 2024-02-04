# Ways to deploy using k8s
First, you need to make sure you install your microk8s.
Try to follow the steps in microk8s io: https://microk8s.io.
You are not required to turn on all the services.
Remember to generate the intial config if have not already configured kubectl on the host as mentioned here: https://microk8s.io/docs/working-with-kubectl#heading--kubectl-macos
Then, you need to load mysql deployment.
```shell
# load secrets keys for mysql deployment and connections
kubectl apply -f secrets.yaml
# load common configuration map for mysql
kubectl apply -f mysql-configmap.yaml
# add volumn to mysql
kubectl apply -f mysql-storage.yaml
# mysql deployment
kubectl apply -f mysql-deployment.yaml
```
Next, you can load vue frontend.
```shell
# load vue frontend
kubectl apply -f bill-frontend-deployment.yaml
```
Next, you need to load spring backend.
```shell
# load vue frontend
kubectl apply -f bill-backend-deployment.yaml
```
Next, turn on ingress on microk8s.
```shell
microk8s enable ingress
```
You have already add tls here, so you need to install mkcert on your host machine and generate the keys as:
```shell
mkcert -install
mkcert bill.local
```
You need to add mapping from K8s_INTERNAL_IP to bill.local domain to your /etc/hosts.
Then deploy
```shell
kubectl create secret tls bill-tls --key bill.local-key.pem --cert bill.local.pem
kubectl apply -f ingress.yaml 
```
Now you can try to visit the https://bill.local to see the result.
# Ways to deploy rolling updates and canary updates

### Getting started
* prepare images show different backgrounds of Login page, see images in [dockerhub](https://hub.docker.com/r/ottokafka2/bill-vue) 
  * ottokafka2/bill-vue:0.0.2 
  * ottokafka2/bill-vue:0.0.3
* prepare two deployment.yaml files for frontend
  * bill-frontend-deployment.yaml with image: ottokafka2/bill-vue:0.0.2
  * bill-frontend-deployments-canary.yaml with image: ottokafka2/bill-vue:0.0.3

### Rolling Updates

```shell
# step 1 - update the image of the deployment of frontend with command line 
kubectl set image deployment/bill-vue bill-vue=ottokafka2/bill-vue:0.0.3

# step 2 - check the status of pods 
kubectl get pods

# step 3 - inspect the events of the deployment updates
kubectl describe deployment bill-vue

```
### Canary Deployments

Before updating, we have total 2 replicas of frontend pods created by bill-vue deployment.  

```shell
# step 1 - apply bill-frontend-deployments-canary.yaml
kubectl apply -f bill-frontend-deployments-canary.yaml

# step 2 - scale down the replicas of current deployment 
kubectl scale down –replicas = 1 deployment/bill-vue

# step 3 - testing the new deployment 

# step 4 - scale the replicas of new deployment up to 2
kubectl scale - -replicas=2 deployment/bill-vue-canary

# step 5 - delete the original deployment 
kubectl delete deployment bill-vue
```
After updating, we have total 2 replicas of frontend pods created by canary-bill-vue deployment.
