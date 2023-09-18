<script setup>
// import { RouterLink, RouterView } from 'vue-router'
import MemberHeadBar from '../components/MemberHeadBar.vue'
import MemberMerchant from '../components/MemberMerchant.vue'
import MemberFootBar from '../components/MemberFootBar.vue'
// import Login from './views/Login.vue'
</script>

<template>
  <div class="index">
    <MemberHeadBar />
    <div style="display:flex ;">
      <MemberMerchant />
      <router-view></router-view>
    </div>
    <MemberFootBar />
  </div>
</template>

<style scoped>
.index {
  width: 100%;
  height: 100%;
  display: flex;
  background: #f8f6e9;
  flex-direction: column;
}
</style>
