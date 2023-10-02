<template>
  <header><SellerHeadBar /></header>
  <main>
    <el-container>
      <el-aside><SellerSideBar /></el-aside>
      <main>
        <br />
        <header>
          <h2 style="color: #888888; font-weight: bolder">所有通知</h2>
        </header>
        <main>
          <NotifyCenter />
        </main>
      </main>
    </el-container>
  </main>
  <footer><FootBar /></footer>
</template>

<script setup>
import NotifyCenter from '../components/NotifyCenter.vue'
import SellerHeadBar from '../components/SellerHeadBar.vue'
import SellerSideBar from '../components/SellerSideBar.vue'
import FootBar from '../components/FootBar.vue'
</script>
