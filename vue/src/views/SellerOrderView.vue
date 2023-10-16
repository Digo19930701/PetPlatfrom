<template>
  <header><SellerHeadBar /></header>
  <main>
    <el-container>
      <el-aside><SellerSideBar /></el-aside>
      <main style="width: 75%">
        <br />
        <header class="title">
          <h2 style="color: #888888; font-weight: bolder">待辦訂單</h2>
        </header>
        <br />
        <main>
          <div v-if="view === 1">
            <SellerOrderTitle />
          </div>
          <div v-if="view === 2">
            <el-empty :image-size="200" description="無相關訂單" />
          </div>
          <br /><br />
        </main>
      </main>
    </el-container>
  </main>
  <footer><FootBar /></footer>
</template>

<script lang="ts" setup>
// import SellerOrderTitle from  './SellerOrderTitle.vue';
import SellerOrderTitle from '../components/SellerOrderTitle.vue'
import SellerHeadBar from '../components/SellerHeadBar.vue'
import SellerSideBar from '../components/SellerSideBar.vue'
import FootBar from '../components/FootBar.vue'
import { ref } from 'vue'

const view = ref(1)
</script>

<style src="../assets/seller.css"></style>
