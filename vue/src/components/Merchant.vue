<template>
  <div style="min-height: calc(100vh - 120px);background-color: #f8f6e9;width: 20%;">
    
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
          <el-sub-menu index="1">
            <template #title>
              <el-icon>
                <location />
              </el-icon>
              <span>我的帳戶</span>
            </template>
              <el-menu-item index="1-1"><router-link to="/setting">基本設定</router-link></el-menu-item>
              <el-menu-item index="1-2"><router-link to="/creditcard">信用卡</router-link></el-menu-item>
              <el-menu-item index="1-3"><router-link to="/password">修改密碼</router-link></el-menu-item>
              <el-menu-item index="1-4"><router-link to="/petinformation">寵物資訊</router-link></el-menu-item>
          </el-sub-menu>

          <el-sub-menu index="2">
            <template #title>
              <el-icon>
                <IconMenu />
              </el-icon>
              <span>訂單紀錄</span>
            </template>
              <el-menu-item index="2-1">現有訂單</el-menu-item>
              <el-menu-item index="2-2">過去訂單</el-menu-item>
          </el-sub-menu>
        


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

import { Document, Menu as IconMenu, Location, Setting, Bell } from '@element-plus/icons-vue'
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

.el-input {
  width: 300px;
}

.dialog-footer button:first-child {
  margin-right: 10px;
}

</style>
