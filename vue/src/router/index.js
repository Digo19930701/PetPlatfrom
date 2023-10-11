import { createRouter, createWebHistory } from 'vue-router'
import UserSetting from '@/views/UserSetting.vue'; 
//import SellerHome from '../views/SellerHomeView.vue'
// import VueRouter from 'vue-router';
// import Vue from 'vue-router';

// VueRouter.use(VueRouter);

// const routes2 = [
//   { path: '/login', name: 'Login', component: Login },
//   { path: '/success', name: 'Success', component: Success, props: true }
// ];

// const router3 = new VueRouter({
//   routes
// });

// export default router;


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    //主頁相關
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
    {
      path: '/shoppingCart',
      name: 'shoppingCart',
      component: () => import('../views/MyShoppingCart.vue')
    },

    //商家頁面
    {
      path: '/sellerHome',
      name: 'sellerHome',
      component: () => import('../views/SellerHomeView.vue')
    },
    {
      path: '/servicesExist',
      name: 'servicesExist',
      component: () => import('../views/ServicesExistView.vue')
    },
    {
      path: '/sellerPreview',
      name: 'sellerPreview',
      component: () => import('../components/SellerPreview.vue')
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
    },

    //會員頁面
    {
      path: '/userHome',
      name: 'userHome',
      component: () => import('../views/UserOrderView.vue')
    },
    {
      // path: '/userSetting/:dataList',
      path: '/userSetting',
      name: 'userSetting',
      component: () => import('../views/UserSetting.vue')
    },
    {
      path: '/login',
      name: 'login',
      component: () => import('../views/login.vue')
    },
    {
      path: '/password',
      name: 'password',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/Password.vue')
    },
    {
      path: '/petinformation',
      name: 'petinformation',
      component: () => import('../views/Petinformation.vue')
    },

    {
      path: '/userOrder',
      name: 'userOrder',
      component: () => import('../views/UserOrderView.vue')
    },
    {
      path: '/userCancelOrder',
      name: 'userCancelOrder',
      component: () => import('../views/UserCancelOrderView.vue')
    },
    {
      path: '/userPastOrder',
      name: 'userPastOrder',
      component: () => import('../views/UserPastOrderView.vue')
    },
    
    //測試用連結
    {
      path: '/studentTest',
      name: 'studentTest',
      component: () => import('../views/Student.vue')
    },
    
  ]
})

export default router
