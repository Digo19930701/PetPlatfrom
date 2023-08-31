<template>
  <!-- Form -->
  <div class="login">
    <el-form :model="loginForm" class="loginForm">
      <el-form-item label="帳號" :label-width="formLabelWidth">
        <el-input v-model="loginForm.account" autocomplete="off" />
      </el-form-item>
      <el-form-item label="密碼" :label-width="formLabelWidth">
        <el-input v-model="loginForm.password" autocomplete="off" />
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
      <!-- <el-switch v-model="value3" inline-prompt active-text="是" inactive-text="否" />
      <el-switch v-model="value4" class="ml-2" inline-prompt
        style="--el-switch-on-color: #13ce66; --el-switch-off-color: #ff4949" active-text="Y" inactive-text="N" />
      <el-switch v-model="value6" class="ml-2" width="60" inline-prompt active-text="超出省略" inactive-text="超出省略" />
      <el-switch v-model="value5" class="ml-2" inline-prompt
        style="--el-switch-on-color: #13ce66; --el-switch-off-color: #ff4949" active-text="完整展示多个内容"
        inactive-text="多个内容" /> -->
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
const value3 = ref(true)
const value4 = ref(true)
const value5 = ref(true)
const value6 = ref(true)
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
