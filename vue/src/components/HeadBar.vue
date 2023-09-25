<template>
  <div class="header">
<<<<<<< HEAD
    <div class="logo">
      <img src="../assets/logoicon.png" width="90" />
      <button class="title">4A2B</button>
    </div>
    <div class="avatar"><el-avatar :size="40" :src="circleUrl" /></div>
    <div class="num-title"><router-link to="/">XXXXXXXXXX</router-link></div>
=======
    <div class="title"><img src="../assets/logoicon.png" width="20">4A2B</div>
    <div class="avatar">
      <el-avatar :size="40" :src="circleUrl" />
      <a class="num-title">acc</a>
    </div>
>>>>>>> base
  </div>
</template>

<script lang="ts" setup>
import { reactive, toRefs } from 'vue'

const state = reactive({
<<<<<<< HEAD
  circleUrl: 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png',
  squareUrl: 'https://cube.elemecdn.com/9/c2/f0ee8a3c7c9638a54940382568c9dpng.png',
  sizeList: ['small', '', 'large'] as const
=======
  circleUrl:
    'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png',
  squareUrl:
    'https://cube.elemecdn.com/9/c2/f0ee8a3c7c9638a54940382568c9dpng.png',
  sizeList: ['small', '', 'large'] as const,
>>>>>>> base
})

const { circleUrl, squareUrl, sizeList } = toRefs(state)
</script>

<<<<<<< HEAD
<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Varela+Round&display=swap');
.header {
  background-color: #f8d479;
  width: 100%;
  height: 80px;
  display: flex;
}

.title {
  font-size: 2.5rem;
  color: #000;
  font-family: 'Varela Round', sans-serif;
  background: transparent;
  border-color: transparent;
  font-weight: 600;
  margin-top: 7px;
}
.title:hover {
  color: #cd7b00;
}

.avatar {
  margin-top: 20px;
  margin-left: 65%;
  /* position: absolute; */
  /* left: 70%; */
}

.num-title {
  margin-top: 25px;
  margin-left: 10px;
  /* position: absolute; */
  /* left: 75%; */
}
.logo {
  display: flex;
  align-items: center;
  padding-left: 20px;
=======

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
  font-size: x-large;
  color: #000;
  font-family: 'Times New Roman', Times, serif;
  font-weight: bold;
  margin-top: 10px;
  margin-left: 25px;
}

.avatar {
  margin-top: 10px;
  position: fixed;
  right: 30px;
  font-size: 25px;
}

.num-title{
  margin-left: 10px;
  position: relative;
  top: -10px;
>>>>>>> base
}
</style>
