<template>
  <div class="header">
    <div class="logo">
      <img src="../assets/logoicon.png" width="90" />
      <button class="title">4A2B</button>
    </div>
    <div class="avatar"><el-avatar :size="40" :src="circleUrl" /></div>
    <div class="num-title"><router-link to="/">XXXXXXXXXX</router-link></div>
    <div><router-link to="/shoppingCart">購物車(暫)</router-link></div>
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
}
</style>
