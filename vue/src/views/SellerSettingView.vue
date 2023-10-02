<template>
  <header><SellerHeadBar /></header>
  <main>
    <el-container>
      <el-aside><SellerSideBar /></el-aside>
      <main style="width: 80%">
        <br />
        <header>
          <h2 style="color: #888888; font-weight: bolder">商家基本資料</h2>
        </header>
        <br />
        <SellerSetting />
      </main>
    </el-container>
  </main>
  <footer><FootBar /></footer>
</template>

<script setup>
import SellerSetting from '../components/SellerSetting.vue'
import SellerHeadBar from '../components/SellerHeadBar.vue'
import SellerSideBar from '../components/SellerSideBar.vue'
import FootBar from '../components/FootBar.vue'
</script>

<style src="../assets/seller.css"></style>
