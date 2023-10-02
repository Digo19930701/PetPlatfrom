<script setup>
import HeadBar from './components/HeadBar.vue'
import FootBar from './components/FootBar.vue'
import ShoppingCart from './components/shoppingCart.vue';

</script>

<template>
  <div class="index">
    <el-container>
      <el-header><HeadBar /></el-header>
      <el-main><ShoppingCart /></el-main>
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
