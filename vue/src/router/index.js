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
    },
    {
      path: '/servicesExist',
      name: 'servicesExist',
      component: () => import('../views/ServicesExistView.vue')
    },
    {
      path: '/preview',
      name: 'preview',
      component: () => import('../components/Preview.vue')
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
      path: '/notifyCenter',
      name: 'notifyCenter',
      component: () => import('../views/NotifyCenterView.vue')
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
    }
  ]
})

export default router
