<template>
    <!-- Form -->
    <div class="login">
      <el-form :model="loginForm" class="loginForm">
        <el-form-item label="帳號" :label-width="formLabelWidth">
          <el-input 
            v-model="loginForm.account" 
            type="password"
            autocomplete="off"
          />
        </el-form-item>
        <el-form-item label="密碼" :label-width="formLabelWidth">
          <el-input
            v-model="loginForm.password"
            type="password"
            autocomplete="off"
          />
        </el-form-item>
        <span class="loginForm">
          <el-button type="primary" @click="login">登入</el-button>
          <el-button @click="dialogFormVisible = true">註冊</el-button>
        </span>
      </el-form>
      
      <el-form>
        <el-switch v-model="value1" class="mb-2" active-text="記住帳號" />
        <br />
        <el-switch v-model="value2" class="mb-2" style="--el-switch-on-color: #13ce66; --el-switch-off-color: #ff4949"
          active-text="記住密碼"  />
        <br />
      </el-form>
  
      <el-dialog v-model="dialogFormVisible" title="註冊會員">
        <el-form :model="form">
          <el-form-item label="姓名" :label-width="formLabelWidth">
            <el-input v-model="form.name" autocomplete="off" />
          </el-form-item>
          <el-form-item label="性別" :label-width="formLabelWidth">
            <el-select v-model="form.region" placeholder="請選擇性別">
              <el-option label="男性" value="male" />
              <el-option label="女性" value="female" />
              <el-option label="暫不提供" value="no" />
            </el-select>
          </el-form-item>
        </el-form>
        <template #footer>
          <span class="dialog-footer">
            <el-button @click="dialogFormVisible = false">Cancel</el-button>
            <el-button type="primary" @click="dialogFormVisible = false"> Confirm </el-button>
          </span>
        </template>
      </el-dialog>
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
  const login = () => { }
  
  const value1 = ref(true)
  const value2 = ref(true)

  </script>
  
  
  
  <style scoped>
  .login {
    text-align: center;
    top: 50%;
  }
  
  .loginForm {
    display: inline-block;
    vertical-align: middle;
  }
  

  .dialog-footer button:first-child {
    margin-right: 10px;
  }
  </style>
  