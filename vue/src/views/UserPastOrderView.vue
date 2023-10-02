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
          <h2 style="color: #888888; font-weight: bolder">過去訂單</h2>
        </header>
        <br />
        <main>
          <div v-if="view === 1">
            <UserOrderTitle />
            <UserOrderTitle />
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
import { ref, reactive } from 'vue'
import UserHeadBar from '../components/UserHeadBar.vue'
import UserSideBar from '../components/UserSideBar.vue'
import UserOrderTitle from '../components/UserOrderTitle.vue'
import FootBar from '../components/FootBar.vue'

const view = ref(2)
</script>

<style scoped></style>
