// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
//引入ElementUI
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import store from './store'
var axios = require('axios')
// 全局注册，之后可在其他组件中通过 this.$axios 发送数据
Vue.prototype.$axios = axios
// 设置反向代理，前端请求默认发送到 http://localhost:8888/api
axios.defaults.baseURL = '/api'
Vue.config.productionTip = false

/* eslint-disable no-new */

Vue.use(ElementUI)

//hook function. Authentication for each route
router.beforeEach((to, from, next) => {
  if (to.meta.requireAuth) {
    //token validation
    if (store.state.token) {
      next()
    } else {
      next({
        path: 'login',
        query: { redirect: to.fullPath }
      })
    }
  } else {
    next()
  }
}
)


new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})
