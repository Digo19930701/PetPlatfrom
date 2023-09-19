<template>
  <div class="header">
    <div><button class="title">4A2B</button></div>
    <div class="avatar"><el-avatar :size="40" :src="circleUrl" /></div>
    <div class="num-title"><router-link to="/">XXXXXXXXXX</router-link></div>
  </div>
</template>

<script lang="ts" setup>
import { reactive, toRefs } from 'vue'

const state = reactive({
  circleUrl: 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png',
  squareUrl: 'https://cube.elemecdn.com/9/c2/f0ee8a3c7c9638a54940382568c9dpng.png',
  sizeList: ['small', '', 'large'] as const
})

const { circleUrl, squareUrl, sizeList } = toRefs(state)
</script>

<style scoped>
.header {
  background-color: #f8d479;
  width: 100%;
  height: 60px;
  display: inline-flex;
}

.title {
  font-size: x-large;
  color: #000;
  font-family: 'Times New Roman', Times, serif;
  font-weight: bold;
  margin-top: 10px;
  margin-left: 20px;
  background: transparent;
  border-color: transparent;
}
.title:hover {
  color: #cd7b00;
}

.avatar {
  margin-top: 10px;
  margin-left: 65%;
  /* position: absolute; */
  /* left: 70%; */
}

.num-title {
  margin-top: 15px;
  margin-left: 10px;
  /* position: absolute; */
  /* left: 75%; */
}
</style>
