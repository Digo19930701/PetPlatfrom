<template>
<<<<<<< HEAD
  <!-- <div style="min-height: calc(100vh - 120px);background-color: #f8f6e9;width: 20%;"> -->
  <div style="height: 100%; min-height: calc(100vh - 120px); background-color: #f8f6e9">
    <el-row>
      <el-col>
        <el-menu
          default-active="2"
          class="el-menu-vertical-demo"
          background-color="#f8f6e9"
          unique-opened="true"
          @open="handleOpen"
          @close="handleClose"
        >
          <el-sub-menu index="1" class="sub-menu">
            <template #title>
              <el-icon>
                <location />
              </el-icon>
              <span class="sub-menu">商家設定</span>
            </template>
            <el-menu-item index="1-1">
              <router-link to="/sellerSetting" class="inner">基本資料</router-link>
            </el-menu-item>
            <el-menu-item index="1-2">
              <router-link to="/notifySetting" class="inner">通知設定</router-link>
            </el-menu-item>
          </el-sub-menu>

          <el-sub-menu index="2">
            <template #title>
              <el-icon>
                <document />
              </el-icon>
              <span class="sub-menu">服務管理</span>
            </template>
            <el-menu-item index="2-1">
              <router-link to="/servicesExist" class="inner">現有服務</router-link>
            </el-menu-item>
            <el-menu-item index="2-2">
              <router-link to="/serviceEdit" class="inner">新增/編輯服務</router-link>
            </el-menu-item>
          </el-sub-menu>

          <el-sub-menu index="3">
            <template #title>
              <el-icon><DocumentCopy /></el-icon>
              <span class="sub-menu">訂單管理</span>
            </template>
            <el-menu-item index="3-1">
              <router-link to="/sellerOrder1" class="inner">待辦訂單</router-link>
            </el-menu-item>
            <el-menu-item index="3-2">
              <router-link to="/sellerOrder2" class="inner">取消訂單</router-link>
            </el-menu-item>
            <el-menu-item index="3-3">
              <router-link to="/sellerOrder3" class="inner">過去訂單</router-link>
            </el-menu-item>
          </el-sub-menu>

          <el-sub-menu index="4">
            <template #title>
              <el-icon><Histogram /></el-icon>
              <span class="sub-menu">數據中心</span>
            </template>
            <el-menu-item index="4-1">
              <router-link to="/sellerChart" class="inner">數據管理</router-link>
            </el-menu-item>
            <el-menu-item index="4-1">
              <router-link to="/sellerRate" class="inner">評價管理</router-link>
            </el-menu-item>
          </el-sub-menu>

          <el-sub-menu index="5">
            <template #title>
              <el-icon><CreditCard /></el-icon>
              <span class="sub-menu">帳務管理</span>
            </template>
            <el-menu-item index="5-1">
              <router-link to="/bankAccount" class="inner">銀行帳號</router-link>
            </el-menu-item>
            <el-menu-item index="5-1">
              <router-link to="/accountingPage" class="inner">我的進帳</router-link>
            </el-menu-item>
          </el-sub-menu>

          <el-menu-item index="6">
            <router-link to="/notifyPage">
              <el-icon><Bell /></el-icon>
              <span class="sub-menu">通知中心</span>
            </router-link>
          </el-menu-item>
        </el-menu>
      </el-col>
    </el-row>
  </div>
</template>

<script lang="ts" setup>
import { reactive, ref } from 'vue'

const dialogFormVisible = ref(false)
const formLabelWidth = '100px'

const form = reactive({
  name: '',
  region: '',
  date1: '',
  date2: '',
  delivery: false,
  type: [],
  resource: '',
  desc: ''
})

const loginForm = reactive({
  account: '',
  password: ''
})
const login = () => {}

import {
  Document,
  Menu as DocumentCopy,
  Location,
  Histogram,
  Bell,
  CreditCard
} from '@element-plus/icons-vue'
import router from '../router'
const handleOpen = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
  // console.log(typeof(key));
}
const handleClose = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}
</script>

<style lang="scss">
.el-row {
  margin-bottom: 20px;
}

.el-row:last-child {
  margin-bottom: 0;
}

.el-col {
  border-radius: 4px;
}

.grid-content {
  border-radius: 4px;
  min-height: 36px;
}

.login {
  text-align: center;
  top: 50%;
}

.loginForm {
  display: inline-block;
  vertical-align: middle;
}

.el-button--text {
  margin-right: 15px;
}

.el-select {
  width: 300px;
}
.sub-menu {
  font-size: 1.5rem;
  font-weight: 600;
}
.inner {
  font-size: 1.4rem;
}
.el-input {
  width: 300px;
}

.dialog-footer button:first-child {
  margin-right: 10px;
}
:root {
  .el-menu {
    border-right: transparent;
  }
}
</style>
=======
    <div class="container" v-if="view === 1">
        <div class="item_header fixed" style="z-index: 1;">
            <div class="item_detail">服務</div>
            <div>預約時間</div>
            <div class="price">單價</div>
            <div class="operate">操作</div>
        </div>
        <div class="item_container" v-for="(item, index) in itemList" :key="item.id">
            <div class="item_header item_body">
                <div class="item_detail">
                    <img v-bind:src="item.imgUrl" alt="">
                    <div class="name">{{ item.itemName }}</div>
                </div>
                <div class="block">
                    <el-date-picker v-model="value2" type="datetime" placeholder="Pick a Date" format="YYYY/MM/DD hh:00"
                        value-format="YYYY-MM-DD h:m a" />
                </div>
                <div class="price"><span>$</span>{{ item.price }}</div>
                <!-- <div class="count">
                    <button @click="handleSub(item)">-</button>
                    {{ item.count }}
                    <button @click="handlePlus(item)">+</button>
                </div>
                <div class="amount">{{ item.price * item.count }}</div> -->
                <div class="operate">
                    <el-button @click="handledelete(index)">刪除</el-button>
                </div>
            </div>
        </div>
        <br>
        <div class="item_header checkout">

            <div class="checkout">總計</div>
            <el-button class="checkout" @click="cview(2)">結帳</el-button>
        </div>
    </div>
    <div v-if="view === 2">
        <div class="item_header fixed">
            <el-button @click="cview(1)">回購物車</el-button>
        </div>
        <Checkout />
        <div class="item_header checkout">
            <el-button class="checkout" @click="sendPostRequest">付款</el-button>
        </div>

    </div>
    
</template>


<script setup>
import Checkout from './Checkout.vue';
import { ref } from 'vue'

// const postData = ref({
//     // 在这里添加你要发送的数据字段
// });

const sendPostRequest = async () => {
    window.location.href = 'http://localhost:8080/ecpayCheckout';
    // axios.post('http://localhost:8080/ecpayCheckout', {})
    //     .then(response => {
    //         responseHTML.value = response.data
    //         document.getElementById('ECpayt').innerHTML = responseHTML.value;
    //         console.log(responseHTML.value)
    //     })
    //     .catch(error => {
    //         console.log(error)
    //     })

};


const value2 = ref('')
const view = ref(1)
const cview = (ind) => {
    view.value = ind
}

const itemList = ref([
    {
        id: '1',
        itemName: '洗澡',
        imgUrl: 'https://images.unsplash.com/photo-1534961880437-ce5ae2033053?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=668&q=80',
        price: '500',
        count: '2023/09/02 12:00'
    },
    {
        id: '2',
        itemName: '美容',
        imgUrl: 'https://images.unsplash.com/photo-1503342217505-b0a15ec3261c?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1500&q=80',
        price: '790',
        count: '2023/02/02 12:00'
    },
    {
        id: '3',
        itemName: '洗澡',
        imgUrl: 'https://images.unsplash.com/photo-1529391409740-59f2cea08bc6?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1124&q=80',
        price: '1200',
        count: '2023/09/15 12:00'
    },
    {
        id: '4',
        itemName: '美容',
        imgUrl: 'https://images.unsplash.com/photo-1491998664548-0063bef7856c?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1500&q=80',
        price: '1300',
        count: '2023/09/02 15:00'
    },
    {
        id: '5',
        itemName: '梳毛',
        imgUrl: 'https://images.unsplash.com/photo-1529391409740-59f2cea08bc6?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1124&q=80',
        price: '2000',
        count: '2023/10/02 12:00'
    },
]);

// const handlePlus = (item) => {
//     item.count++;
// };

// const handleSub = (item) => {
//     if (item.count > 1) {
//         item.count--;
//     }
// };

const handledelete = (index) => {
    console.log(this);
    itemList.value.splice(index, 1);
};
</script>

<style scoped>
.block {
    display: flex;
}

.fixed {
    z-index: 1;
    position: fixed;
    top: 60px;
    left: 1px;
}

.item_header {
    display: flex;
    width: 100%;
    margin: 0 auto;
    height: 33px;
    background-color: #fff;
    border-radius: 3px;
    padding-left: 10px;

}

.item_header div {
    width: 21%;
    line-height: 30px;
}

.item_header .item_detail {
    width: 35%;
}

.item_body {
    margin-top: 20px;
    height: 100px;
    align-items: center;
    width: 100%;
}

.item_detail img {
    width: 80px;
    height: 80px;
    border-radius: 3px;
    float: left;
}

.item_detail .name {
    margin-left: 100px;
    margin-top: 20px;
}

.checkout {
    position: fixed;
    bottom: 60px;
    right: 1px;
}
</style>
>>>>>>> base
