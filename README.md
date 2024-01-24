# Journal Bill
Start microk8s first
```
kubectl apply -f secrets.yaml
kubectl apply -f mysql-configmap.yaml
kubectl apply -f mysql-storage.yaml 
kubectl apply -f mysql-deployment.yaml
kubectl apply -f mysql-deployment.yaml
```
Then you can deploy mysql and bill-backend to kubernates.
Add proxy
```
kubectl port-forward svc/bill-spring 8088:8088
```
Then you can test the login api in your local machine by
```
curl --location 'localhost:8088/api/auth/login' \
--header 'Content-Type: application/json' \
--data-raw '{"email": "1@qq.com", "password":"123"}'
```