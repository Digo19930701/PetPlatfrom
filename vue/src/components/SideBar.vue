<template>
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
            <router-link to="/notifyCenter">
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
