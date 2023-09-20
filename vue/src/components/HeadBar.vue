<template>
  <div class="header">
    <img src="../assets/logoicon.png">
    <div class="title">4A2B</div>
    <div class="avatar">
      <el-avatar :size="40" :src="circleUrl" />
      <a class="num-title">acc</a>
    </div>
  </div>
</template>

<script lang="ts" setup>
import { reactive, toRefs } from 'vue'

const state = reactive({
  circleUrl:
    'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png',
  squareUrl:
    'https://cube.elemecdn.com/9/c2/f0ee8a3c7c9638a54940382568c9dpng.png',
  sizeList: ['small', '', 'large'] as const,
})

const { circleUrl, squareUrl, sizeList } = toRefs(state)
</script>


<style scoped>

.header {
  z-index: 1;
  background-color: #f8d479;
  width: 100%;
  height: 60px;
  /* padding: 10px 0px 10px 20px; */
  display: inline-flex;
  position: fixed;
  left: 0px;
}

.title {
  font-size: 40px;
  color: #000;
  font-family: 'Times New Roman', Times, serif;
  font-weight: bold;
  margin-left: 10px;
}

.avatar {
  margin-top: -10px;
  position: fixed;
  right: 30px;
  font-size: 25px;
}

.num-title {
  font-size: 50px;
  margin-left: 10px;
  position: relative;
  top: -6px;
}
</style>
