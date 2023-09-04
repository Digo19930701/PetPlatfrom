<script setup></script>

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
      <img src="./images/logo.png" alt="Logo" />
      <h1>寵物平台</h1>
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
          <a href="#"> 會員登入</a>
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
  <el-container>
    <el-aside width="200px">Aside</el-aside>
    <el-main>
      <el-carousel :interval="5000" arrow="always">
        <el-carousel-item v-for="item in 4" :key="item">
          <h3 text="2xl" justify="center">{{ item }}</h3>
        </el-carousel-item>
      </el-carousel>
      <br />
      <h2>推薦商家</h2>
    </el-main>
  </el-container>
</template>

<style scoped lang="scss">
// .app-header {
//   background-color: #f9f8d0;

//   .container {
//     display: flex;
//     align-items: center;
//   }

//   .logo {
//     width: 200px;
//   }

//   .app-header-nav {
//     display: flex;

//     align-items: center;
//   }
// }
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
    // border: 2px solid red;
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
  }
}

.el-aside {
  background-color: #f7f6e8;
  height: 100vh;
}
.el-main {
  background-color: #f2f2ef;
  height: 100vh;
}
.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}
.el-carousel__item h3 {
  color: #475669;
  opacity: 0.75;
  line-height: 300px;
  margin: 0;
  text-align: center;
}
</style>
