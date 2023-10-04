<template>
  <header><SellerHeadBar /></header>
  <main>
    <el-container>
      <el-aside><SellerSideBar /></el-aside>
      <main style="width: 80%">
        <br />
        <notifysetting />
      </main>
    </el-container>
  </main>
  <footer><FootBar /></footer>
</template>

<script setup>
import notifysetting from '../components/notifysetting.vue'
import SellerHeadBar from '../components/SellerHeadBar.vue'
import SellerSideBar from '../components/SellerSideBar.vue'
import FootBar from '../components/FootBar.vue'
</script>

<style src="../assets/seller.css"></style>
