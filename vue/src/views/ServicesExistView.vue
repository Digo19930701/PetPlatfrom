<template>
  <header><SellerHeadBar /></header>
  <main>
    <el-container>
      <el-aside><SellerSideBar /></el-aside>
      <main>
        <br />
        <header>
          <h2 style="color: #888888; font-weight: bolder">現有服務</h2>
        </header>
        <el-container>
          <main>
            <ExistingServices />
          </main>
        </el-container>
      </main>
    </el-container>
  </main>
  <footer><FootBar /></footer>
</template>

<script setup>
// import ServiceEdit from '../components/ServiceEdit.vue';
import ExistingServices from '../components/ExistingServices.vue'
import SellerHeadBar from '../components/SellerHeadBar.vue'
import SellerSideBar from '../components/SellerSideBar.vue'
import FootBar from '../components/FootBar.vue'
</script>

<style src="../assets/seller.css"></style>
