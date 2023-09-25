<script setup>
<<<<<<< HEAD
// import { RouterLink, RouterView } from 'vue-router'

import HeadBar from './components/HeadBar.vue'
import Merchant from './components/Merchant.vue'
import FootBar from './components/FootBar.vue'
import router from './router'
=======
import HeadBar from './components/HeadBar.vue'
import Merchant from './components/Merchant.vue'
import FootBar from './components/FootBar.vue'

>>>>>>> base
</script>

<template>
  <div class="index">
<<<<<<< HEAD
    <header><HeadBar /></header>
    <el-container>
      <el-aside width="200px"><Merchant /></el-aside>
      <el-container>
        <el-main style="background-color: #f8f6e9">
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
    <footer><FootBar /></footer>
  </div>
</template>

<style scoped>
/* header {
  line-height: 1.5;
  max-height: 100vh;
}
@media (min-width: 1024px) {
  header {
    display: flex;
    flex-direction: column;
    place-items:  center;
    padding-right: calc(var(--section-gap) / 2);
  }
} */

=======
    <el-container>
      <el-header><HeadBar /></el-header>
      <el-main><Merchant /></el-main>
      <el-footer><FootBar /></el-footer>
    </el-container>
      
  </div>

</template>

<style scoped>
>>>>>>> base
.index {
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
}

</style>
