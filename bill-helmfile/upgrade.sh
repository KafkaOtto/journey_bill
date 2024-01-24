helm upgrade bill-cert charts/bill-cert-manager
sleep 30
helm upgrade bill-issuers charts/bill-cert-issuer
helm upgrade bill-mysql charts/bill-mysql
sleep 10
helm upgrade bill-spring charts/bill-spring
helm upgrade bill-vue charts/bill-vue
helm upgrade bill-nginx charts/bill-nginx
