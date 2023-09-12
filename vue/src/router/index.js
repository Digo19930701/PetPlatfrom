import { createRouter, createWebHistory } from 'vue-router'
// import SellerHome from '../views/SellerHomeView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      // component: SellerHome
    },
    // {
    //   path: '/serviceEdit',
    //   name: 'serviceEdit',
    //   component: () => import('../views/ServiceEditView.vue')
    // },
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
    }
  ]
})

export default router
