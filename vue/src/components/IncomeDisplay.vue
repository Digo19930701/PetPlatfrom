<template>
  <div class="base hw">
    <header>
      <h2>進帳總覽</h2>
    </header>
    <main>
      <div style="display: flex">
        <div class="month">
          <p class="p-month">本月</p>
          <br />
          <p class="p-money">
            <span style="font-size: x-large; font-weight: 600">NT$</span>
            {{ monthIncome }}
          </p>
        </div>
        <div class="all">
          <p class="p-all">
            全部
            <el-tooltip
              placement="top-start"
              effect="customized"
              content="基於個人資料保護法，已撥款進帳僅計算過去 5 年內的訂單進帳總和"
            >
              <el-icon style="color: #888"><QuestionFilled /></el-icon>
            </el-tooltip>
          </p>
          <p class="p-all-m">NT${{totalIncome}}</p>
        </div>
      </div>
      <div class="bank">
        <p class="p-bank">我的銀行帳號 {{accountNumber}}</p>
        <span class="change"
          ><router-link to="/bankAccount" class="router">更改預設</router-link></span
        >
      </div>
    </main>
  </div>
</template>

<script lang="ts" setup>
import { QuestionFilled } from '@element-plus/icons-vue'
import {reactive, toRefs} from 'vue'

const data = reactive({
  monthIncome:'1350',//月進帳
  totalIncome:'3050',//總進帳
  accountNumber:'********1554'
})

const {monthIncome, totalIncome, accountNumber} = toRefs(data)
</script>

<style lang="scss" scoped>
h2 {
  color: #888888;
  font-weight: bolder;
  padding-left: 10px;
}

.hw {
  width: 70%;
  height: 300px;
  min-width: 600px;
}
.month {
  width: 40%;
  height: 150px;
  border-radius: 20px;
  border: 1px solid #d9d9d9;
  background: #fff;
  margin: 10px;
  padding: 10px;
  padding-left: 40px;
  padding-top: 20px;
  min-width: 300px;
}
.all {
  width: 35%;
  height: 150px;
  // border: 1px solid #d9d9d9;
  background: #fff;
  margin: 10px;
  padding: 10px;
  padding-left: 40px;
  padding-top: 8%;
  min-width: 240px;
}
.bank {
  width: 97%;
  height: 20%;
  border-radius: 20px;
  background: rgba(217, 217, 217, 0.35);
  margin: 10px;
  padding: 10px;
  padding-right: 10px;
  display: flex;
  min-width: 480px;
}
.p-month {
  color: #888;
  font-size: x-large;
  font-weight: 600;
}
.p-money {
  color: black;
  font-size: xx-large;
  font-weight: 600;
  padding-left: 10%;
}
.p-bank {
  color: black;
  font-weight: 600;
  padding-left: 5%;
}
.change {
  padding-left: 50%;
}
.router {
  color: #1f8ede;
  font-weight: 600;
}
.router:hover {
  color: var(--el-color-primary);
  background: transparent;
}
.p-all {
  color: #888;
  font-size: large;
  font-weight: 600;
}
.p-all-m {
  color: black;
  font-size: x-large;
  font-weight: 600;
  padding-left: 10%;
}
</style>
