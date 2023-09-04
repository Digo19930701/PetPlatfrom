<template>
  <!-- <header class="app-header">
      <div class="container">
        <h1 class="logo">
          <RouterLink to="/">4A2B</RouterLink>
        </h1>
        <div class="search">
          <input type="text" placeholder="搜尋" />
        </div>
        <ul class="app-header-nav">
          <li class="home">
            <RouterLink to="/">會員登入</RouterLink>
          </li>
          <li><RouterLink to="/">通知</RouterLink></li>
          <li><RouterLink to="/">訊息</RouterLink></li>
        </ul>
      </div>
    </header> -->

  <header>
    <section class="logo">
      <a href="#"><img src="../images/logoicon.png" alt="Logo" /></a>
      <a href="#"><h1>4A2B</h1></a>
    </section>
    <nav>
      <ul>
        <li>
          <div class="wrap">
            <div class="search">
              <input class="search-bar" type="text" name="search" id="search" placeholder="搜尋" />
              <button class="search-btn"><i class="fas fa-search"></i></button>
            </div>
          </div>
        </li>
        <li>
          <a href="/"> 會員登入</a>
        </li>
        <li>
          <a href="#"> 購物車</a>
        </li>
        <li>
          <a href="#"> 通知</a>
        </li>
        <li>
          <a href="#"> 訊息</a>
        </li>
      </ul>
    </nav>
  </header>
  <el-main
    ><el-button v-popover="popoverRef" v-click-outside="onClickOutside">篩選</el-button>
    <el-popover ref="popoverRef" trigger="click" title="With title" virtual-triggering persistent>
      <span> Some content </span>
    </el-popover>
    <el-divider />
    <el-space direction="vertical">
      <el-row v-for="i in 3" :key="i">
        <el-col v-for="(o, index) in 4" :key="o" :span="5" :offset="index > 0 ? 1 : 0">
          <el-card :body-style="{ padding: '0px' }">
            <img
              src="https://media.istockphoto.com/id/1331301152/photo/photo-in-motion-running-beautiful-golden-retriever-dog-have-a-walk-outdoors-in-the-park.jpg?s=1024x1024&w=is&k=20&c=JZ6x5NMk_sTZwQAs2iR3MUr6JfEmjqszXIBrv2HAOB8="
              class="image"
            />
            <div style="padding: 14px">
              <h3>各種選項</h3>
              <span
                >Cute fluffy friends a cat and a dog catch a flying butterfly in a sunny
                summer</span
              >
              <div class="bottom">
                <el-button text class="button">了解更多</el-button>
              </div>
            </div>
          </el-card>
        </el-col>
      </el-row>
    </el-space>
  </el-main>
</template>

<script setup>
import { ref } from 'vue'
import { ClickOutside as vClickOutside } from 'element-plus'
const buttonRef = ref()
const popoverRef = ref()
const onClickOutside = () => {
  unref(popoverRef).popperRef?.delayHide?.()
}
</script>

<style scoped lang="scss">
$themeColor: #f7ddba;

* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

header {
  background-color: #f9f8d0;
  display: flex; // 橫向排
  flex-wrap: wrap;
  align-items: center;
  section.logo {
    flex: 1 1 400px; //flex: 2 1 400px;
    display: flex;
    align-items: center;
    h1 {
      font-size: 2.5rem;
      color: #ff8400;
    }
    img {
      width: 6vw;
      height: 6vw;
    }
  }
  nav {
    flex: 5 1 500px;
  }
  ul {
    display: flex;
    list-style-type: none;
    justify-content: space-around;
  }
  li {
    a {
      color: #ff8400;
      text-decoration: none;
      font-size: 1.35rem;
      transition: all 0.2s ease;
      padding-bottom: 0.3rem;
      &:hover {
        color: $themeColor;
        border-bottom: 3px solid $themeColor;
      }
    }
  }
  .search-bar {
    width: 90%;
    height: 32px;
    font-size: 20px;
    border: 3px solid #ff8400;
    background-color: #f9e7d0;
  }
  .search-btn {
    width: 36px;
    height: 32px;
    background-color: #ff8400;
    color: #efe9e7;
    outline: none;
    border: 2px solid #ff8400;
    cursor: pointer;
    position: absolute;
  }
}
.bottom {
  margin-top: 13px;
  line-height: 12px;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.button {
  padding: 0;
  min-height: auto;
}

.image {
  width: 100%;
  display: block;
}
</style>
