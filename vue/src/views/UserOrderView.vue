<template>
  <header><UserHeadBar /></header>

  <main>
    <el-container>
      <el-aside>
        <UserSideBar />
      </el-aside>
      <main style="width: 75%">
        <br />
        <header>
          <h2 style="color: #888888; font-weight: bolder">現有訂單</h2>
        </header>
        <br />
        <main>
          <UserOrderTitle />
          <!-- <UserOrderTitle /> -->
          <br /><br />
        </main>
      </main>
    </el-container>
  </main>
  <footer><FootBar /></footer>
</template>

<script lang="ts" setup>
import { ref, reactive } from 'vue'
import UserHeadBar from '../components/UserHeadBar.vue'
import UserSideBar from '../components/UserSideBar.vue'
import FootBar from '../components/FootBar.vue'
import UserOrderTitle from '../components/UserOrderTitle.vue'
</script>
<style src="../assets/seller.css"></style>
<style lang="scss"></style>
