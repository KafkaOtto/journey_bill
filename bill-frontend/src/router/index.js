import Vue from 'vue'
import Router from 'vue-router'
//导入登录页面组件
import Login from '@/views/login.vue'
import Home from '@/views/home.vue'
//


Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Default',
      redirect: '/home',
      component: Home
    },
        //添加登录页面路由
    {
      path:'/login',
      name: 'Login',
      component: Login
    },
    {
       // home页面并不需要被访问，只是作为其它组件的 父组件
      path: '/home',
      name: 'Home',
      component: Home,
      meta: {
        requireAuth: true
      },
      redirect: '/userhome',
      children:[
        {
          path:'/userhome',
          name:'userhome',
          component:()=> import("@/views/home/UserHome.vue"),
          meta:{
            requireAuth:true
          }
        }
      ]
    }

  ]
})
