<template>
  <div class="login">
    <div class="title">
      <img src="../images/logoiconCut.png" style="max-width: 200px; padding-top: 50px;"/>
      <a href="/"><p class="T4a2b">4A2B</p></a>
      <div>
          <button class="tag-cloud" id="chose" style="font-size: large;" @click="choiceView(1)">會員</button>
          <span>&nbsp; &nbsp;</span>
          <button class="tag-cloud" id="chose" style="font-size: large;" @click="choiceView(2)">商家</button>
      </div>
    </div>
    <br />
    <div v-if="loginView === 1">
      <el-form :model="loginForm" class="loginForm">
        <el-form-item label="帳號" :label-width="formLabelWidth">
          <el-input
            v-model="loginForm.userEmail"
            autocomplete="off"
            style="height: 50px; width: 500px"
          />
        </el-form-item>
        <el-form-item label="密碼" :label-width="formLabelWidth">
          <el-input
            v-model="loginForm.password"
            autocomplete="off"
            style="height: 50px; width: 500px"
            show-password
          />
          <el-link
            @click="verifyEmail = true"
            style="color: #cd7b00; margin-left: 15px; font-size: 1.3rem"
          >
            忘記密碼
          </el-link>
        </el-form-item>
      </el-form>

      <!-- <div style="margin: 10px; width: 98%">
        <el-button type="warning" @click="login"
          style="width: 178px; height: 60px;">
          會員登入
        </el-button>
      </div>
      <div style="margin: 10px; width: 98%">
        <el-button type="warning" @click="dialogFormVisible = true" style="width: 178px; height: 60px">
          會員註冊</el-button>
      </div>
      <div>OR</div>
      <div style="margin: 10px; width: 98%">
        <el-button @click="test" style="width: 178px; height: 60px">
          <img src="../images/googleLogin.png" />
        </el-button>
      </div>

    </div>
    <div v-if="loginView === 2">
      <el-form :model="loginForm" class="loginForm">
        <el-form-item label="帳號" :label-width="formLabelWidth">
          <el-input
            v-model="loginForm.userEmail"
            autocomplete="off"
            style="height: 50px; width: 500px"
          />
        </el-form-item>
        <el-form-item label="密碼" :label-width="formLabelWidth">
          <el-input
            v-model="loginForm.password"
            autocomplete="off"
            style="height: 50px; width: 500px"
          />
          <el-link
            @click="verifyEmail = true"
            style="color: red; margin-left: 15px; font-size: 1.3rem"
          >
            忘記密碼
          </el-link>
        </el-form-item>
      </el-form>

      <div style="margin: 10px; width: 98%">
        <el-button type="warning" plain @click="login"
         style="width: 178px; height: 60px;">
          商家登入
        </el-button>
      </div>
      <div style="margin: 10px; width: 98%">
        <el-button type="warning" plain @click="sellerSignup = true" style="width: 178px; height: 60px">
          商家註冊
        </el-button>
      </div>
    </div>

    <el-dialog v-model="dialogFormVisible" title="註冊會員">
      <el-form :model="register">
        <el-form-item :label-width="formLabelWidth">
          <el-input
            v-model="register.userMail"
            label-width="100px"
            autocomplete="off"
            type="register"
            placeholder="請輸入信箱"
          />
        </el-form-item>
        <el-form-item :label-width="formLabelWidth">
          <el-input
            v-model="register.userPassword"
            label-width="100px"
            autocomplete="off"
            type="register"
            placeholder="請輸入密碼"
            show-password
          />
        </el-form-item>
        <el-form-item :label-width="formLabelWidth">
          <el-input
            v-model="register.userPassword2"
            label-width="100px"
            autocomplete="off"
            type="register"
            placeholder="密碼確認"
            show-password
          />
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
          <el-input
            v-model="verifyemail.mail"
            label-width="100px"
            autocomplete="off"
            type="forgetPs"
            placeholder="請輸入信箱"
          />
        </el-form-item>
      </el-form>

      <template #footer>
        <span class="dialog-footer">
          <el-button type="primary" @click=""> 下一步</el-button>
          <el-button @click="verifyEmail = false">取消</el-button>
        </span>
      </template>
    </el-dialog> -->


      <div style="margin: 10px; width: 98%">
        <el-button type="warning" @click="login"
          style="width: 178px; height: 60px;">
          會員登入
        </el-button>
      </div>
      <div style="margin: 10px; width: 98%">
        <el-button type="warning" @click="dialogFormVisible = true" style="width: 178px; height: 60px">
          會員註冊</el-button>
      </div>
      <div>OR</div>
      <div style="margin: 10px; width: 98%">
        <el-button @click="test" style="width: 178px; height: 60px">
          <img src="../images/googleLogin.png" />
        </el-button>
      </div>

    </div>
    <div v-if="loginView === 2">
      <el-form :model="loginForm" class="loginForm">
        <el-form-item label="帳號" :label-width="formLabelWidth">
          <el-input
            v-model="loginForm.userEmail"
            autocomplete="off"
            style="height: 50px; width: 500px"
          />
        </el-form-item>
        <el-form-item label="密碼" :label-width="formLabelWidth">
          <el-input
            v-model="loginForm.password"
            autocomplete="off"
            style="height: 50px; width: 500px"
            show-password
          />
          <el-link
            @click="verifyEmail = true"
            style="color: red; margin-left: 15px; font-size: 1.3rem"
          >
            忘記密碼
          </el-link>
        </el-form-item>
      </el-form>

      <div style="margin: 10px; width: 98%">
        <el-button type="warning" plain @click="login"
         style="width: 178px; height: 60px;">
          商家登入
        </el-button>
      </div>
      <div style="margin: 10px; width: 98%">
        <el-button type="warning" plain @click="sellerSignup = true" style="width: 178px; height: 60px">
          商家註冊
        </el-button>
      </div>
    </div>

    <el-dialog v-model="dialogFormVisible" title="註冊會員">
      <el-form :model="register">
        <el-form-item :label-width="formLabelWidth">
          <el-input
            v-model="register.userMail"
            label-width="100px"
            autocomplete="off"
            type="register"
            placeholder="請輸入信箱"
          />
        </el-form-item>
        <el-form-item :label-width="formLabelWidth">
          <el-input
            v-model="register.userPassword"
            label-width="100px"
            autocomplete="off"
            type="register"
            placeholder="請輸入密碼"
            show-password
          />
        </el-form-item>
        <el-form-item :label-width="formLabelWidth">
          <el-input
            v-model="register.userPassword2"
            label-width="100px"
            autocomplete="off"
            type="register"
            placeholder="密碼確認"
            show-password
          />
        </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button type="primary" @click="registerout"> 註冊</el-button>
          <el-button @click="dialogFormVisible = false">取消</el-button>
        </span>
      </template>
      <div style="display: flex; justify-content: center;">
          <GoogleReCaptchaV2/>
        </div>
        <br><br>
        <el-button @click="test" style="width: 300px; height: 70px">
            <img src="../images/googleLogin.png" />
          </el-button>

    </el-dialog>

    <el-dialog v-model="verifyEmail" title="輸入信箱">
      <el-form :model="verifyemail">
        <el-form-item :label-width="formLabelWidth">
          <el-input
            v-model="verifyemail.mail"
            label-width="100px"
            autocomplete="off"
            type="forgetPs"
            placeholder="請輸入信箱"
          />
        </el-form-item>
      </el-form>

      <template #footer>
        <span class="dialog-footer">
          <el-button type="primary" @click=""> 下一步</el-button>
          <el-button @click="verifyEmail = false">取消</el-button>
        </span>
      </template>
    </el-dialog>

    <el-dialog v-model="sellerSignup" title="註冊商家">
      <el-form :model="sellersignup">
        <el-form-item :label-width="formLabelWidth">
          <el-input
            v-model="sellersignup.mail"
            label-width="100px"
            autocomplete="off"
            type="sellersignup"
            placeholder="請輸入信箱"
          />
        </el-form-item>
        <el-form-item :label-width="formLabelWidth">
          <el-input
            v-model="sellersignup.Password"
            label-width="100px"
            autocomplete="off"
            type="sellersignup"
            placeholder="請輸入密碼"
            show-password
          />
        </el-form-item>
        <el-form-item :label-width="formLabelWidth">
          <el-input
            v-model="sellersignup.againPassword"
            label-width="100px"
            autocomplete="off"
            type="sellersignup"
            placeholder="密碼確認"
            show-password
          />
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
import { reactive, ref } from 'vue'
import { useRouter } from 'vue-router'

const dialogFormVisible = ref(false)
const sellerSignup = ref(false)
const verifyEmail = ref(false)
const router = useRouter()

const loginView = ref(1)
const choiceView = (ind) => {
  loginView.value = ind
}

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
  userMail: '',
  userPassword: '',
  userPassword2: ''
})

const forgetPs = reactive({
  verifypassword: '',
  newpassword: ''
})
const verifyemail = reactive({
  mail: ''
})

const loginForm = reactive({
  userEmail: '',
  password: ''
})

const sellersignup = reactive({
  mail: '',
  Password: '',
  againPassword: ''
})

import firebaseConfig from '../firebaseConfig'
// import { API_URL } from '@/config'
import { getAuth, signInWithPopup, GoogleAuthProvider } from 'firebase/auth'
import axios from 'axios'
import GoogleReCaptchaV2 from '../components/GoogleReCaptchaV2.vue'

firebaseConfig

// getAuth()：用於獲取 Firebase 的 auth 服務的實例，處理身份驗證的主要介面
const auth = getAuth()
// GoogleAuthProvider：用於提供 Google 登入的驗證提供者物件，設定相關的登入選項和參數。
const googleProvider = new GoogleAuthProvider()

const userUid = ref()
const nickname = ref()
const accountTypeID = ref(1)
async function test() {
  try {
    // signInWithPopup(auth, googleProvider) 函式：用於彈出 Google 登入視窗，並返回一個結果物件
    const result = await signInWithPopup(auth, googleProvider)
    // uid：使用者的唯一識別碼
    userUid.value = result.user.email
    // displayName：使用者的顯示名稱
    nickname.value = result.user.displayName

    console.log(result)

    // 根據需求，可以在登入後的處理中進行相應的操作，例如驗證用戶資訊、儲存登入狀態等。
    axios
    .post(`http://localhost:3300/4A2Bpet/Register`, {
      userEmail: userUid.value,
      userPassword: nickname.value,
      userPassword2: nickname.value,
        // accountTypeID: accountTypeID.value
    });

    // if (response.data.message === '登入成功') {
    // // alert(response.data.message);
    // } else {
    //     alert(response.data.message);
    // }

    // 使用 localStorage.setItem 方法將回應中的 id 值存儲到 token 鍵中。
    // localStorage.setItem("token", response.data.id);
    localStorage.setItem('token', 'memberToken')

    //使用 window.location.reload() 重新載入頁面。
    // window.location.reload();
    alert('登入成功')
    // router.push('/')
  } catch (error) {
    console.log(error.response)
    alert('發生了一些錯誤，請聯絡管理員!')
    window.location.reload()
  }
}

const login = () => {
  const userEmail = loginForm.userEmail
  const password = loginForm.password

  console.log(`account=${userEmail}`, `password=${password}`, 1, 2, 3)

  const user = {
    userEmail: userEmail,
    userPassword: password
  }
  axios
    .post('http://localhost:3300/4A2Bpet/Login', user, {
      headers: {
        'Content-Type': 'application/json'
      }
    })

    .then((response) => {
      alert('登入成功')

      window.location.href = response.data.userEmail // 替换Spring Boot端口号和路由
      
    })
    .catch((error) => {
      alert(error)
      console.error(error)
    })
}

const registerout = () => {
  const Email = register.userMail
  const userPassword = register.userPassword
  const userPassword2 = register.userPassword2

  console.log(`Email=${Email}`, `userPassword=${userPassword}`, `userPassword=${userPassword2}`)

  const user = {
    userEmail: Email,
    userPassword: userPassword,
    userPassword2: userPassword2
  }

  axios
    .post('http://localhost:3300/4A2Bpet/Register', user, {
      headers: {
        'Content-Type': 'application/json'
      }
    })
    .then((response) => {
      alert(response.data)
      console.log(response.data)
    })
    .catch((error) => {
      alert(error)
      console.error(error)
    })
}

const sellersignupout = () => {
  console.log('sellersignup', sellersignup)
}
</script>

<!-- <style src="../assets/seller.css"></style> -->
<style lang="scss">
@import url('https://fonts.googleapis.com/css2?family=Varela+Round&display=swap');
#chose:hover {
  background: #cd7b00;
  color: white;
}
#chose:focus {
  background: #cd7b00;
  color: white;
}
#chose2{
  background: #cd7b00;
  color: white;
}
.login {
  background-color: #f8d479;
  text-align: center;
  height: 100vh;
  display: block;
  /*顯示  彈性盒子佈局  */
  align-items: center;
  justify-content: center;
  // background-image: url('../images/4a2b_icon.png');
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-position: center;
  background-size: contain;
}

.loginForm {
  display: inline-block;
  vertical-align: middle;
  text-align: center;
  margin-right: 5%;
  padding-left: 4%;
}

.dialog-footer button:first-child {
  margin-right: 10px;
}

.el-button {
  font-size: 1.5rem;
  font-weight: bold;
}
.el-form-item__label {
  display: inline-flex;
  justify-content: flex-end;
  align-items: flex-start;
  flex: 0 0 auto;
  font-size: 1.5rem;
  color: var(--el-text-color-regular);
  height: 32px;
  line-height: 32px;
  padding: 0 12px 0 0;
  box-sizing: border-box;
}
.T4a2b:hover {
  color: #cd7b00;
}
.T4a2b{
  font-family: 'Varela Round', sans-serif;
  font-weight: bold;
  font-size: 4rem; 
  color: black;
}
.tag-cloud {
  display: inline-block;
  color: #666666;
  width: 80px;
  border-radius: 25px;
  margin-top: 2px;
  text-align: center;
  font-size: medium;
}
</style>
