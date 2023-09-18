<template>
  <div class="password">
    <el-text style="font-size: large; color: #888888; font-weight: bold">修改密碼</el-text>

    <div class="background">
      <el-form :model="passwordForm">
        <el-form-item label="密碼" :label-width="formLabelWidth">
          <el-input v-model="passwordForm.password" label-width="100px" autocomplete="off" type="password" placeholder="請輸入舊密碼" show-password/>
        </el-form-item>
        <el-form-item label="新密碼" :label-width="formLabelWidth">
          <el-input v-model="passwordForm.newPassword" autocomplete="off" type="password" placeholder="請輸入新密碼" show-password/>
        </el-form-item>
        <el-form-item label="再次確認" :label-width="formLabelWidth" >
          <el-input v-model="passwordForm.againPassword" autocomplete="off" type="password" placeholder="再次確認新密碼" show-password/>
        </el-form-item>
        <span>
          <el-button class="button" @click="confirm()">確認</el-button>
          <el-button class="button">取消</el-button>
        </span>
      </el-form>
    </div>
  </div>
</template>

<script lang="ts" setup>
import { reactive, ref } from 'vue'
const formLabelWidth = '100px'

const passwordForm = reactive({
  password: '',
  newPassword: '',
  againPassword: ''
})

const confirm = () => {
  console.log("passwordForm",passwordForm)
 }
</script>

<style lang="scss">
.password {
  margin: auto;
  height: 80vh;
  width: 50%;
}
.background {
  background-color: white;
  margin: 10px;
  padding: 40px;
  border-radius: 30px;
  text-align: center;
}
.button{
  color: #FFCB46;
  border-color: #FFCB46;
  border: 1px solid #FFCB46;
  background: #FFFFFF;
}
.button:hover{
  color: white;
  background-color: #FFCB46;
  border-color: #FFCB46;
}
.button:focus{
  color: white;
  background-color: #FFCB46;
  border-color: #FFCB46;
}

</style>
