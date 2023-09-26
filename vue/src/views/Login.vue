<template>
  <div class="login">
    <div class="title"><img src="../components/config/image/Login_IMG.png"></div>
    <el-form :model="loginForm" class="loginForm">
      <el-form-item label="帳號" :label-width="formLabelWidth">
        <el-input v-model="loginForm.account" autocomplete="off" style="height: 50px; width: 500px;" />
      </el-form-item>
      <el-form-item label="密碼" :label-width="formLabelWidth">
        <el-input v-model="loginForm.password" autocomplete="off" style="height: 50px; width: 500px;" />
      </el-form-item>
    </el-form>

    <div style="margin-left: 50px;">
      <el-button type="primary" @click="login" style="width: 200px; height: 50px;">登入</el-button>
      <el-link @click="verifyEmail = true" style="color: red; margin-left: 20px;">忘記密碼</el-link>
    </div>
    <div style="margin-top: 20px; ">
      <el-button @click="dialogFormVisible = true" style="width: 200px; height: 50px;">會員註冊</el-button>
      <el-button @click="sellerSignup = true" style="width: 200px; height: 50px;">商家註冊</el-button>
    </div>




    <el-dialog v-model="dialogFormVisible" title="註冊會員">
      <el-form :model="register">
        <el-form-item :label-width="formLabelWidth">
          <el-input v-model="register.mail" label-width="100px" autocomplete="off" type="register" placeholder="請輸入信箱" />
        </el-form-item>
        <el-form-item :label-width="formLabelWidth">
          <el-input v-model="register.Password" label-width="100px" autocomplete="off" type="register" placeholder="請輸入密碼"
            show-password />
        </el-form-item>
        <el-form-item :label-width="formLabelWidth">
          <el-input v-model="register.againPassword" label-width="100px" autocomplete="off" type="register"
            placeholder="密碼確認" show-password />
        </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button type="primary" @click="registerout"> 註冊</el-button>
          <el-button @click="dialogFormVisible = false">取消</el-button>
        </span>
      </template>
    </el-dialog>

    <el-dialog v-model="verifyEmail" title="輸入信箱">
      <el-form :model="verifyemail">
        <el-form-item :label-width="formLabelWidth">
          <el-input v-model="verifyemail.mail" label-width="100px" autocomplete="off" type="forgetPs"
            placeholder="請輸入信箱" />
        </el-form-item>
      </el-form>

      <template #footer>
        <span class="dialog-footer">
          <el-button type="primary" @click="forgetPassword = true"> 下一步</el-button>
          <el-button @click="verifyEmail = false">取消</el-button>
        </span>
      </template>
    </el-dialog>

    <el-dialog v-model="sellerSignup" title="註冊商家">
      <el-form :model="sellersignup">
        <el-form-item :label-width="formLabelWidth">
          <el-input v-model="sellersignup.mail" label-width="100px" autocomplete="off" type="sellersignup" placeholder="請輸入信箱" />
        </el-form-item>
        <el-form-item :label-width="formLabelWidth">
          <el-input v-model="sellersignup.Password" label-width="100px" autocomplete="off" type="sellersignup" placeholder="請輸入密碼"
            show-password />
        </el-form-item>
        <el-form-item :label-width="formLabelWidth">
          <el-input v-model="sellersignup.againPassword" label-width="100px" autocomplete="off" type="sellersignup"
            placeholder="密碼確認" show-password />
        </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button type="primary" @click="sellersignupout"> 註冊</el-button>
          <el-button @click="sellerSignup = false">取消</el-button>
        </span>
      </template>
    </el-dialog>
  </div>


</template>
  
<script lang="ts" setup>
import { dataType } from 'element-plus/es/components/table-v2/src/common';
import { reactive, ref } from 'vue'
import {useRouter} from 'vue-router'

const dialogFormVisible = ref(false)
const sellerSignup = ref(false)
const verifyEmail = ref(false)
const router = useRouter()

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
const register = reactive({
  mail: '',
  Password: '',
  againPassword: ''
})

const forgetPs = reactive({
  verifypassword: '',
  newpassword: '',

})
const verifyemail = reactive({
  mail: '',


})

const loginForm = reactive({
  account: '',
  password: ''
})

const sellersignup = reactive({
  mail: '',
  Password: '',
  againPassword: ''
})


const login = () => {
  router.push("/")
  console.log("loginForm", loginForm)
}
const registerout = () => {

  console.log("register", register)
}

const sellersignupout = () => {

console.log("sellersignup", sellersignup)
}


</script>
  
  
  
<style scoped>
.login {
  background-color: #f8d479;
  text-align: center;
  height: 100vh;
  display: block;
  /*顯示  彈性盒子佈局  */
  align-items: center;
  justify-content: center;
  background-image: url("../components/config/image/logoicon.png");
  background-size: 100% 100%;
}

.loginForm {
  display: inline-block;
  vertical-align: middle;
  text-align: center;
  margin-right: 5%;
}

.dialog-footer button:first-child {
  margin-right: 10px;

}
</style>
  