<script setup>
import HeadBar from '../components/ShopcarHeadBar.vue'
import Merchant from '../components/ShopcarMerchant.vue'
import FootBar from '../components/ShopcarFootBar.vue'

</script>

<template>
  <div class="index">
    <el-container>
      <el-header><HeadBar /></el-header>
      <el-main><Merchant /></el-main>
      <el-footer><FootBar /></el-footer>
    </el-container>
      
  </div>

</template>

<style scoped>
.index {
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
}

</style>
