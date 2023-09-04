<script setup>
import { ref } from 'vue'
// import { Search } from '@element-plus/icons-vue'
</script>

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
              <!-- <el-button :icon="Search" /> -->
              <!-- <button class="search-btn"><i class="fas fa-search"></i></button> -->
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
  <el-container>
    <el-aside width="20%">
      <br />
      <h2>愛漂亮</h2>

      <a href="/">洗澡&SPA</a>
      <br />
      <a href="/">美容</a>
      <br />
      <a href="/">療浴</a>

      <el-divider />

      <h2>我需要保母</h2>
      <a href="/">寵物安親</a>
      <br />
      <a href="/">寵物旅館</a>
      <br />
      <a href="/">到府服務</a>
      <br />
      <a href="/">小奶貓狗照護</a>
      <el-divider />

      <h2>想知道...</h2>
      <a href="/">預約寵物溝通</a>
      <el-divider />

      <h2>記錄美好瞬間</h2>
      <a href="/">預約寵物攝影</a>
    </el-aside>
    <el-main>
      <el-carousel :interval="5000" arrow="always">
        <el-carousel-item v-for="item in 4" :key="item">
          <h3 text="2xl" justify="center">{{ item }}</h3>
        </el-carousel-item>
      </el-carousel>
      <br />
      <h2>推薦商家</h2>
      <br />
      <el-row>
        <el-col v-for="(o, index) in 3" :key="o" :span="7" :offset="index > 0 ? 1 : 0">
          <el-card :body-style="{ padding: '0px' }">
            <img
              src="https://media.istockphoto.com/id/1349349263/photo/cute-fluffy-friends-a-cat-and-a-dog-catch-a-flying-butterfly-in-a-sunny-summer.jpg?s=1024x1024&w=is&k=20&c=I3tWgnvB2pI4e7Y7TPESjfwsrhWccci8-AzbJvq0kA4="
              class="image"
            />
            <div style="padding: 14px">
              <h3>商家</h3>
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
      <br />
      <h2>貓奴看這邊</h2>
      <br />
      <el-row>
        <el-col v-for="(o, index) in 3" :key="o" :span="7" :offset="index > 0 ? 1 : 0">
          <el-card :body-style="{ padding: '0px' }">
            <img
              src="https://media.istockphoto.com/id/1270634313/photo/cute-fluffy-cat-lies-on-the-grass-in-the-garden-and-catches-the-sun-highlights.jpg?s=1024x1024&w=is&k=20&c=vRaI9nPHgGskq0ZFTmWu5Sys2hPCk6z19ZzXcxEPqJ4="
              class="image"
            />
            <div style="padding: 14px">
              <h3>給貓貓的服務</h3>
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
      <br />
      <h2>狗狗喜歡這個</h2>
      <br />
      <el-row>
        <el-col v-for="(o, index) in 3" :key="o" :span="7" :offset="index > 0 ? 1 : 0">
          <el-card :body-style="{ padding: '0px' }">
            <img
              src="https://media.istockphoto.com/id/1331301152/photo/photo-in-motion-running-beautiful-golden-retriever-dog-have-a-walk-outdoors-in-the-park.jpg?s=1024x1024&w=is&k=20&c=JZ6x5NMk_sTZwQAs2iR3MUr6JfEmjqszXIBrv2HAOB8="
              class="image"
            />
            <div style="padding: 14px">
              <h3>給狗狗的服務</h3>
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
      // .search-btn {
      //   width: 36px;
      //   height: 32px;
      //   background-color: #ff8400;
      //   color: #efe9e7;
      //   outline: none;
      //   border: 2px solid #ff8400;
      //   cursor: pointer;
      //   position: absolute;
      // }
    }
  }
}
.el-container {
  .el-aside {
    background-color: #f7f6e8;
    height: 100vh;
    .a {
      font-size: 1.35rem;
    }
  }
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
.time {
  font-size: 12px;
  color: #999;
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

h2 {
  font-weight: bold;
  color: #ff8400;
}
</style>
