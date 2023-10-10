<template>
  <header><HomeHeader /></header>
  <main>
    <el-container>
      <main style="width: 100%">
        <el-container class="bodyHeight">
          <el-main><ShoppingCartX /></el-main>
        </el-container>
      </main>
    </el-container>
  </main>
  <footer><FootBar /></footer>
</template>

<script setup>
import HomeHeader from '../components/HomeHeader.vue'
// import Home from '../components/Home.vue'
import FootBar from '../components/FootBar.vue'
import ShoppingCartX from '../components/ShoppingCartX.vue'
</script>

<style lang="scss" scoped>
.el-main {
  background-color: #f8f4da;
}
.bodyHeight {
  height: 90vh;
}
</style>
