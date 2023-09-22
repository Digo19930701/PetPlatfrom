import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    // {
    //   path: '/',
    //   name: 'home',
    //   component: HomeView
    // },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/AboutView.vue')
    },
    {
      path: '/',
      name: 'myHome',
      component: () => import('../views/MyHome.vue')
    },
    {
      path: '/search',
      name: 'search',
      component: () => import('../views/Search.vue')
    },
    {
      path: '/good',
      name: 'good',
      component: () => import('../views/MyGood.vue')
    },
    // 會員相關
    {
      path: '/Member',
      name: 'Member',
      component: () => import('../views/Member.vue'),
      children: [
        {
          path: 'settingPage',
          component:() => import('../views/settingPage.vue')
        },
        {
          path: 'creditcard',
          component:() => import('../views/creditcard.vue')
        },
        {
          path: 'password',
          component:() => import('../views/password.vue')
        },
        {
          path: 'petinformation',
          component:() => import('../views/petinformation.vue')
        },
        {
          path: 'order',
          component:() => import('../views/order.vue')
        },
        {
          path: 'orderhistory',
          component:() => import('../views/orderhistory.vue')
        },
      ]
    },
    // 購物車相關
    {
      path: '/Shopcar',
      name: 'Shopcar',
      component: () => import('../views/Shopcar.vue'),
      // children: [
      //   {
      //     path: 'settingPage',
      //     component:() => import('../views/settingPage.vue')
      //   },
      // ]
    },
    {
      path: '/Login',
      name: 'Login',
      component: () => import('../views/Login.vue')
    },
    
    {
      path: '/order',
      name: 'order',
      component: () => import('../views/order.vue')
    },
    {
      path: '/orderhistory',
      name: 'orderhistory',
      component: () => import('../views/orderhistory.vue')
    }
  ]
})

export default router
