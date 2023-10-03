<template>
  <header><HomeHeader /></header>
  <main>
    <el-container>
<<<<<<< HEAD
      <main style="width: 100%;">
=======
      <main>
>>>>>>> origin/L
        <Home />
      </main>
    </el-container>
  </main>
  <footer><FootBar /></footer>
</template>

<script setup>
import HomeHeader from '../components/HomeHeader.vue'
import Home from '../components/Home.vue'
import FootBar from '../components/FootBar.vue'
</script>

<style lang="scss" scoped>
.el-main {
  background-color: #f8f4da;
}
</style>
