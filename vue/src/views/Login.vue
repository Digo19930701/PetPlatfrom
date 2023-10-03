<template>
  <div class="login">
    <div class="title"><img src="../components/config/image/Login_IMG.png" /></div>
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
      </el-form-item>
    </el-form>
      <!-- <h1>{{hhhh}}</h1> {{}}是EL-->  
      
    <div style="margin-left: 50px">
      <el-button type="primary" @click="login" style="width: 200px; height: 50px">登入</el-button>
      <el-link @click="verifyEmail = true" style="color: red; margin-left: 20px">忘記密碼</el-link>
    </div>
    <div style="margin-top: 20px">
      <el-button @click="dialogFormVisible = true" style="width: 200px; height: 50px"
        >會員註冊</el-button
      >
      <el-button @click="sellerSignup = true" style="width: 200px; height: 50px"
        >商家註冊</el-button
      >
      <el-button @click="test" style="width: 200px; height: 50px">三方登入</el-button>
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
          <el-button type="primary" @click="forgetPs = true"> 下一步</el-button>
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
import { API_URL } from '@/config'
import { getAuth, signInWithPopup, GoogleAuthProvider } from 'firebase/auth'
import axios from 'axios'

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
    userUid.value = result.user.uid
    // displayName：使用者的顯示名稱
    nickname.value = result.user.displayName

    console.log(result)

    // 根據需求，可以在登入後的處理中進行相應的操作，例如驗證用戶資訊、儲存登入狀態等。
    // const response = await axios.post(`${API_URL}googleLogin.php`, {
    //     userUid: userUid.value,
    //     nickname: nickname.value,
    //     accountTypeID: accountTypeID.value
    // });

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
    router.push('/')
  } catch (error) {
    console.log(error.response)
    alert('發生了一些錯誤，請聯絡管理員!')
    window.location.reload()
  }
}

const login = () => {
  const userEmail = loginForm.userEmail
  const password = loginForm.password

  console.log(`account=${userEmail}`,`password=${password}`,1,2,3)
 
  const user = {
    userEmail: userEmail,
    password: password
  }
  axios
    .post('http://localhost:8080/4A2Bpet/Login', user, {
      headers: {
    	 'Content-Type': 'application/json'
		}
    })
    .then((response) => {
		alert(response.data);
    

  // export default {
  //   data() {
  //   return {
  //     data: "" // 这里初始化为一个空字符串
  //   };
  // },
  // mounted() {
  //   // 这里可以使用axios或其他方法从后端获取数据并更新data属性
  //   this.getDataFromBackend();
  // },     
  //   methods: {
  //   getDataFromBackend() {
  //     // 使用axios或其他HTTP库从后端获取数据
  //     axios.get("http://localhost:5173/Member")
  //       .then(response => {
  //         hhhh = response.data;
  //       })
  //       .catch(error => {
  //         console.error(error);
  //       });
  //     }
  //   }

  // }
  
    window.location.href= response.data; // 替换Spring Boot端口号和路由
   
      console.log(response.data)
      console.log(response.data.yyy)
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
  


  console.log(`Email=${Email}`,`userPassword=${userPassword}`,`userPassword=${userPassword2}`)
  
  const user1 = {
    userEmail:Email,
    password:userPassword,
    password2:userPassword2
    // useragainPasswordPassword:useragainPassword
  }
  axios
    .post('http://localhost:8080/4A2Bpet/Register', user1, {
      headers: {
    	 'Content-Type': 'application/json'
		}
    })
    .then((response) => {
		alert(response.data);
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

<style scoped>
.login {
  background-color: #f8d479;
  text-align: center;
  height: 100vh;
  display: block;
  /*顯示  彈性盒子佈局  */
  align-items: center;
  justify-content: center;
  background-image: url('../components/config/image/logoicon.png');
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
