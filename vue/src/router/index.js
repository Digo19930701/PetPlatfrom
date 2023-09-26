import { createRouter, createWebHistory } from 'vue-router'
import SellerHome from '../views/SellerHomeView.vue'
import Preview from '../components/Preview.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: SellerHome
      // component: Preview
    },
    // proxyTable: {
    //   '/data': {                 
    //     target: 'http://localhost:3300/', 
    //     changeOrigin: true,
    //     pathRewrite: {
    //       '^/data': ''
    //     }
    //   }
    // },
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
    },
    {
      path: '/login',
      name: 'login',
      component: () => import('../components/Login.vue')
    },
    {
      //待補連結點
      path: '/preview',
      name: 'preview',
      component: () => import('../components/Preview.vue')
    },
    {
      //待補正式的連接點
      path: '/shoppingCart',
      name: 'shoppingCart',
      component: () => import('../components/ShoppingCart.vue')
    }
  ]
})

export default router
