<template>
  <div class="header">
    <a href="/">
      <section class="logo">
        <img src="../images/4a2b_icon.png" width="90" />
        <p>4A2B</p>
      </section>
    </a>
    <div style="width: 50%"></div>
    <div class="num-title">
      <router-link to="/sellerHome">
        <el-icon :size="20"><UserFilled /></el-icon>&nbsp;4a2bSeller賣家&nbsp;你好~
      </router-link>
    </div>
    <div class="logout">
      <router-link to="/">
        <el-icon :size="20"><TurnOff /></el-icon>&nbsp;登出
      </router-link>
    </div>
  </div>
</template>

<script lang="ts" setup>
import { reactive, toRefs } from 'vue'
import { UserFilled, TurnOff } from '@element-plus/icons-vue'
const state = reactive({
  circleUrl: 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png',
  squareUrl: 'https://cube.elemecdn.com/9/c2/f0ee8a3c7c9638a54940382568c9dpng.png',
  sizeList: ['small', '', 'large'] as const
})

const { circleUrl, squareUrl, sizeList } = toRefs(state)
</script>

<style lang="scss" scoped>
@import url('https://fonts.googleapis.com/css2?family=Varela+Round&display=swap');
.header {
  background-color: #f8d479;
  width: 100%;
  height: 80px;
  display: flex;
}

section.logo {
  display: flex;
  align-items: center;
  padding-left: 20px;

  p {
    font-size: 2.5rem;
    color: black;
    font-family: 'Varela Round', sans-serif;
    font-weight: bold;
    &:hover {
      color: #cd7b00;
    }
  }
}

.num-title {
  margin-top: 25px;
  margin-left: 10px;
  padding-right: 70px;
  color: #cd7b00;
  font-size: 1.35rem;

  /* position: absolute; */
  /* left: 75%; */
}
.logout {
  margin-top: 25px;
  margin-left: 10px;
  padding-right: 5%;
  color: #cd7b00;
  font-size: 1.35rem;
}
.logo {
  display: flex;
  align-items: center;
  padding-left: 20px;
}
</style>
