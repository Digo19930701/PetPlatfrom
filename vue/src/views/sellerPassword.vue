<template>
  <header><SellerHeadBar /></header>

  <main>
    <el-container>
      <el-aside>
        <SellerSideBar />
      </el-aside>
      <main style="width: 75%">
        <br />
        <header>
          <h2 style="color: #888888; font-weight: bolder">修改密碼</h2>
        </header>
        <br />
        <main>
          <div class="password">
            <div class="background">
              <el-form :model="passwordForm">
                <el-form-item label="密碼" :label-width="formLabelWidth">
                  <el-input
                    v-model="passwordForm.password"
                    label-width="100px"
                    autocomplete="off"
                    type="password"
                    placeholder="請輸入舊密碼"
                    show-password
                  />
                </el-form-item>
                <el-form-item label="新密碼" :label-width="formLabelWidth">
                  <el-input
                    v-model="passwordForm.newPassword"
                    autocomplete="off"
                    type="password"
                    placeholder="請輸入新密碼"
                    show-password
                  />
                </el-form-item>
                <el-form-item label="再次確認" :label-width="formLabelWidth">
                  <el-input
                    v-model="passwordForm.againPassword"
                    autocomplete="off"
                    type="password"
                    placeholder="再次確認新密碼"
                    show-password
                  />
                </el-form-item>
                <br />
                <span>
                  <el-button type="primary" @click="confirm()">確認</el-button>
                  <el-button type="primary" plain><a href="/sellerSetting">取消</a></el-button>
                </span>
              </el-form>
            </div>
          </div>
        </main>
      </main>
    </el-container>
  </main>
  <footer><FootBar /></footer>
</template>

<script lang="ts" setup>
import { reactive, ref } from 'vue'
import SellerHeadBar from '../components/SellerHeadBar.vue'
import SellerSideBar from '../components/SellerSideBar.vue'
import FootBar from '../components/FootBar.vue'
const formLabelWidth = '100px'

const passwordForm = reactive({
  password: '',
  newPassword: '',
  againPassword: ''
})


const confirm = () => {
  console.log('passwordForm', passwordForm)
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
  box-shadow: 1px 1px 5px lightgray;
  border-color: #e3e1dc;
}
</style>
