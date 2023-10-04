<template>
  <header><SellerHeadBar /></header>
  <main>
    <el-container>
      <el-aside><SellerSideBar /></el-aside>
      <main>
        <header class="title">
          <h2 style="color: #888888; font-weight: bolder">新增/編輯服務</h2>
        </header>
        <ServiceEdit />
      </main>
    </el-container>
  </main>
  <footer><FootBar /></footer>
</template>

<script setup>
import ServiceEdit from '../components/ServiceEdit.vue'
import SellerHeadBar from '../components/SellerHeadBar.vue'
import SellerSideBar from '../components/SellerSideBar.vue'
import FootBar from '../components/FootBar.vue'
</script>

<style src="../assets/seller.css"></style>
