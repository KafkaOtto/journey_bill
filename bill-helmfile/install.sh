helm install bill-ingress-controller charts/bill-ingress-controller
helm install bill-cert charts/bill-cert-manager --set leaderElection.namespace=default
sleep 30
helm install bill-issuers charts/bill-cert-issuer
helm install bill-mysql charts/bill-mysql
sleep 10
helm install bill-spring charts/bill-spring
helm install bill-vue charts/bill-vue
helm install bill-nginx charts/bill-nginx
