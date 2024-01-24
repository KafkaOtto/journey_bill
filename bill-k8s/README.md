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
 