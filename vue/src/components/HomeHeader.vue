<script setup>
import { ref } from 'vue'
// import { Search } from '@element-plus/icons-vue'
</script>

<template>
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
              <div class="search_btn">
                <input
                  class="search-bar"
                  type="text"
                  name="search"
                  id="search"
                  placeholder="搜尋"
                />
                <!-- <el-button :icon="Search" /> -->
                <!-- <button class="search-btn"><i class="fas fa-search"></i></button> -->

                <el-button style="width: 10px">
                  <el-icon :size="size" :color="color"> <Search /> </el-icon>
                </el-button>
              </div>
            </div>
          </div>
        </li>
        <li>
          <a href="/"><font-awesome-icon icon="fa-solid fa-circle-user" /> 會員登入</a>
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
</template>

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
    ul {
      display: flex;
      list-style-type: none;
      justify-content: space-around;

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
        .search_btn {
          display: flex;
        }
      }
      .search-bar {
        width: 90%;
        height: 32px;
        font-size: 20px;
        border: 3px solid #ff8400;
        background-color: #f9e7d0;
      }
    }
  }
}
</style>
