<template>
  <header><UserHeadBar /></header>
  <main>
    <el-container>
      <el-aside>
        <UserSideBar />
      </el-aside>
      <main style="width: 100%">
        <br />
        <header>
          <h2 style="color: #888888; font-weight: bolder">基本設定</h2>
        </header>
        <!-- <el-scrollbar class="setting" height="500px"> -->
        <div class="">
          <div class="background base">
            <el-form :model="settingForm">
              <p class="rowtitle">我的帳號</p>
              <br />
              <el-form-item label="帳號" :label-width="formLabelWidth">
                <p style="color: #888; padding-left: 10px">yoyo820701@gmail.com</p>
              </el-form-item>
              <el-form-item label="密碼" :label-width="formLabelWidth">
                <p style="padding-left: 10px">
                  <a href="/password"><ins>更改密碼 </ins></a>
                </p>
              </el-form-item>
              <el-form-item
                label="手機號碼"
                maxlength="10"
                prop="phone"
                show-word-limit
                :label-width="formLabelWidth"
                :rules="[{ required: true, message: '此為必填欄位' }]"
              >
                <el-input v-model="settingForm.phone" autocomplete="off" />
              </el-form-item>
            </el-form>
          </div>
          <br />

          <div class="background base">
            <el-form :model="settingForm">
              <p class="rowtitle">個人檔案</p>
              <br />
              <el-form-item
                label="姓名"
                prop="userName"
                :label-width="formLabelWidth"
                :rules="[{ required: true, message: '此為必填欄位' }]"
              >
                <el-input v-model="settingForm.userName" label-width="100px" autocomplete="off" />
              </el-form-item>
              <el-form-item
                label="性別"
                prop="gender"
                :label-width="formLabelWidth"
                :rules="[{ required: true, message: '此為必選欄位', trigger: 'change' }]"
              >
                <el-radio-group v-model="settingForm.gender">
                  <el-radio :label="1">男性</el-radio>
                  <el-radio :label="2">女性</el-radio>
                  <el-radio :label="3">其他/保密</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item
                label="生日"
                prop="birthday"
                :label-width="formLabelWidth"
                :rules="[{ required: true, message: '此為必選欄位', trigger: 'change' }]"
              >
                <el-date-picker
                  v-model="settingForm.birthday"
                  type="date"
                  placeholder="請選擇你的生日"
                />
              </el-form-item>
              <el-form-item
                label="身分證字號"
                prop="id"
                :label-width="formLabelWidth"
                :rules="[{ required: true, message: '此為必填欄位' }]"
              >
                <el-input
                  v-model="settingForm.id"
                  label-width="100px"
                  autocomplete="off"
                  maxlength="10"
                  show-word-limit
                />
              </el-form-item>
              <el-form-item
                label="聯絡地址"
                prop="addre"
                :label-width="formLabelWidth"
                :rules="[{ required: true, message: '此為必選欄位', trigger: 'change' }]"
              >
                <el-select-v2
                  v-model="settingForm.addre"
                  :options="options"
                  placeholder="Please select"
                />
              </el-form-item>
            </el-form>
          </div>
          <br />
          <el-row class="footbn">
            <span class="dialog-footer">
              <el-button type="primary" @click="confirm()">儲存</el-button>
              <el-button type="primary" plain>取消</el-button>
            </span>
          </el-row>
        </div>
        <!-- </el-scrollbar> -->
      </main>
    </el-container>
  </main>
  <br />
  <footer><FootBar /></footer>
</template>

<style src="../assets/default.css"></style>

<script lang="ts" setup>
import { reactive } from 'vue'
import UserHeadBar from '../components/UserHeadBar.vue'
import UserSideBar from '../components/UserSideBar.vue'
import FootBar from '../components/FootBar.vue'
import { onMounted,ref } from 'vue';
import axios from 'axios';
import { useRoute } from 'vue-router';
import UserSetting from '../services/UserSetting.js'

// const petServices = ref([]);

// const getServiceById = async () => {
//   console.log(response.data);
//   try {
//     const response = await UserSetting.getuserJSON();
//     if (response.status === 200) {
//       petServices.value.push(response.data);
//       console.log('servicePeriod: ' + petServices.value[0].userName);
//     }
//   } catch (error) {
//     console.error('Error getting petServices:', error);
//   }
// };

// onMounted(() => {
//     getServiceById();
// });

// const route = useRoute();
// const dataList = route.params.dataList;
// console.log('Received dataList:', route.params.dataList);
// console.log(JSON.stringify(route.params.dataList));

// const route = useRoute();

// onMounted(() => {
//   console.log("傳遞過來的 dataList:", route.params.dataList);
// });

const formLabelWidth = '100px'

const settingForm = reactive({
  account: '',
  phone: '',
  userName: '',
  gender: '',
  birthday: '',
  id: '',
  addre: ''
})

const confirm = () => {
  alert('修改完成!')
}

const initials = [
  '臺北市',
  '新北市',
  '桃園市',
  '臺中市',
  '臺南市',
  '高雄市',
  '宜蘭縣',
  '新竹縣',
  '苗栗縣',
  '彰化縣',
  '南投縣',
  '雲林縣',
  '嘉義縣',
  '屏東縣',
  '花蓮縣',
  '臺東縣',
  '澎湖縣',
  '基隆市',
  '新竹市',
  '嘉義市',
  '連江縣',
  '金門縣'
]

const options = Array.from({ length: 22 }).map((_, idx) => ({
  value: `Option ${idx + 1}`,
  label: `${initials[idx % 10]}`
}))

// onMounted(async () => {
//   try {
//     const response = await axios.get('http://localhost:3300/4A2Bpet/Login', {
//       headers: {
//         'Content-Type': 'application/json',
//       },
//     });
//     // 注意這邊你原先設定錯誤，應該用 response.data 來取得後端傳來的 JSON 數據
//     const data = response.data;
//     if (data && typeof data === 'object') {
//       // 將後端傳來的數據賦值到 settingForm
//       settingForm.account = data.userEmail;
//       settingForm.phone = data.userPhone;
//       settingForm.userName = data.userName;
//       settingForm.gender = data.userGender;
//       settingForm.birthday = data.userBirthday;
//       settingForm.id = data.userId;
//       settingForm.addre = data.userAddre;
//     }
//   } catch (error) {
//     console.error('發生錯誤:', error);
//   }
// });




</script>
<style src="../assets/default.css"></style>
<style lang="scss">
.setting {
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
  width: 55%;
  min-width: 500px;
}

.footbn {
  padding-left: 25%;
}

.el-input {
  width: 80%;
}
.rowtitle {
  font-size: large;
  font-weight: bold;
  color: #888;
  text-align: center;
}
:root {
  .--el-input-width {
    width: 80%;
  }
}
</style>
