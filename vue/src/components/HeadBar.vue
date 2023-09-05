<template>
  <div class="header">
    <div class="title"><img src="../assets/logoicon.png" width="20">4A2B</div>
      <div class="avatar"><el-avatar :size="40" :src="circleUrl" /></div>
      <div class="num-title">XXXXXXXXXX</div>
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
  background-color: #f8d479;
  /* width: auto; */
  height: 60px;
  /* padding: 10px 0px 10px 20px; */
  display: inline-flex;

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
  margin-left: 50%;
}

.num-title {
  margin-top: 20px;
  margin-left: 10px;
}
</style>
