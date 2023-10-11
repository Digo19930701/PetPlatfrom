<template>
  <header><HomeHeader /></header>
  <main>
    <el-container>
      <main style="width: 2000px">
        <el-container>
          <el-main style="width: 100%;height: 930px;"><SearchMenu /></el-main>
        </el-container>
      </main>
    </el-container>
  </main>
  <footer><FootBar /></footer>
</template>

<script setup>
import HomeHeader from '../components/HomeHeader.vue'
import SearchMenu from '../components/SearchMenu.vue'
import FootBar from '../components/FootBar.vue'
</script>

<style lang="scss" scoped>
.el-main {
  background-color: #f8f4da;
}
.bodyHeight {
  height: 120vh;
}
</style>
