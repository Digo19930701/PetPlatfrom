<template>
  <header><SellerHeadBar /></header>
  <main>
    <el-container>
      <el-aside><SellerSideBar /></el-aside>
      <main style="width: 80%">
        <header class="title">
          <h2 style="color: #888888; font-weight: bolder">評價管理</h2>
        </header>
        <SellerRateTitle
          :rateItem="['平均評價', '總評價數', '未回覆評價']"
          :rate="[4.2, 11, 2]"
          :note="['與前月評價相差', '本月增加', '筆']"
          :rateSub="[0.5, 1, 2]"
        />
        <el-row>
          <el-radio-group v-model="radio">
            <el-radio :label="0">全部</el-radio>
            <el-radio :label="1">美容</el-radio>
            <el-radio :label="2">溝通</el-radio>
            <el-radio :label="3">攝影</el-radio>
            <el-radio :label="4">保母/訓練</el-radio>
          </el-radio-group>
        </el-row>

        <SellerRate />
        <SellerRate />
        <SellerRate />
      </main>
    </el-container>
  </main>
  <footer><FootBar /></footer>
</template>

<script lang="ts" setup>
import SellerRateTitle from '../components/SellerRateTitle.vue'
import SellerRate from '../components/SellerRate.vue'
import SellerHeadBar from '../components/SellerHeadBar.vue'
import SellerSideBar from '../components/SellerSideBar.vue'
import FootBar from '../components/FootBar.vue'
import { ref } from 'vue'
const radio = ref(0)
</script>

<style src="../assets/seller.css"></style>
<style lang="scss">
.el-radio-group {
  padding: 0px 10px;
}

.el-radio__input.is-checked + .el-radio__label {
  color: #cd7b00;
}
.el-radio__input.is-checked .el-radio__inner {
  border-color: #cd8b00;
  background: #cd7b00;
}
</style>
