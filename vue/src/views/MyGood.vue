<template>
  <header><HomeHeader /></header>
  <main>
    <el-container>
      <main>
        <el-container>
          <OrderSideBar />
          <el-main><Good /></el-main>
        </el-container>
      </main>
    </el-container>
  </main>
  <footer><FootBar /></footer>
</template>

<script setup>
import HomeHeader from '../components/HomeHeader.vue'
import Good from '../components/Good.vue'
// import Good from '../components/goods/Good_39.vue'
import FootBar from '../components/FootBar.vue'
import OrderSideBar from '../components/OrderSideBar.vue'
</script>

<style lang="scss" scoped>
.el-main {
  background-color: #f8f4da;
}
</style>
