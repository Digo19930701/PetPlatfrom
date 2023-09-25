import { createRouter, createWebHistory } from 'vue-router'
<<<<<<< HEAD
import SellerHome from '../views/SellerHomeView.vue'
import Preview from '../components/Preview.vue'
=======
import Login from '../components/Login.vue'
>>>>>>> base

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
<<<<<<< HEAD
      // component: SellerHome
      component: Preview
    },
    {
      path: '/servicesExist',
      name: 'servicesExist',
      component: () => import('../views/ServicesExistView.vue')
    },
    {
      path: '/serviceEdit',
      name: 'serviceEdit',
      component: () => import('../views/ServiceEditView.vue')
    },
    {
      path: '/sellerOrder1',
      name: 'sellerOrder1',
      component: () => import('../views/SellerOrderView.vue')
    },
    {
      path: '/sellerOrder2',
      name: 'sellerOrder2',
      component: () => import('../views/SellerOrderView.vue')
    },
    {
      path: '/sellerOrder3',
      name: 'sellerOrder3',
      component: () => import('../views/SellerOrderView.vue')
    },
    {
      path: '/sellerChart',
      name: 'sellerChart',
      component: () => import('../views/SellerChartView.vue')
    },
    {
      path: '/sellerRate',
      name: 'sellerRate',
      component: () => import('../views/SellerRateView.vue')
    },
    {
      path: '/sellerSetting',
      name: 'sellerSetting',
      component: () => import('../views/SellerSettingView.vue')
    },
    {
      path: '/notifySetting',
      name: 'notifySetting',
      component: () => import('../views/NotifySettingView.vue')
    },
    {
      path: '/notifyPage',
      name: 'notifyPage',
      component: () => import('../views/NotifyPageView.vue')
    },
    {
      path: '/accountingPage',
      name: 'accountingPage',
      component: () => import('../views/AccountingPageView.vue')
    },
    {
      path: '/bankAccount',
      name: 'bankAccount',
      component: () => import('../views/BankAccountView.vue')
=======
      component: Login
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../components/Login.vue')
>>>>>>> base
    }
  ]
})

export default router
