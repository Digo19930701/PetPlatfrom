<template>
  <header id="header">
    <router-link to="/">
      <section class="logo">
        <img src="../images/4a2b_icon.png" alt="Logo" width="85" />
        <p>4A2B</p>
      </section>
    </router-link>

    <nav>
      <ul>
        <li>
          <div>
            <div class="search">
              <el-row>
                <!-- <el-col> -->
                <el-input
                  class="search-bar"
                  type="search"
                  v-model="data.search"
                  name="search"
                  id="search"
                  placeholder="  搜尋"
                />
                &nbsp;
                <!-- </el-col> -->
                <!-- <el-col :span="2"> -->
                <a href="/search">
                  <el-icon size="25" style="padding-top: 5px">
                    <Search />
                  </el-icon>
                </a>
                <!-- </el-col> -->
              </el-row>

              <!-- <el-button :icon="Search" /> -->
              <!-- <button class="search-btn"><i class="fas fa-search"></i></button> -->
            </div>
          </div>
        </li>
        <!-- <li>
          <router-link to="/studentTest">
            <el-icon><UserFilled /></el-icon>&nbsp;
          </router-link>
        </li> -->
        <li>
          <a href="/shoppingCartX">
            <el-icon><ShoppingTrolley /></el-icon>&nbsp;購物車
          </a>
        </li>
        <li>
          <el-menu
            mode="horizontal"
            :default-active="activeIndex"
            class="el-menu-demo"
            :ellipsis="false"
            background-color="#F8D479"
            color="transparent"
          >
            <el-sub-menu index="1">
              <template #title>
                <a href="/login" id="loginicon">
                  <el-icon size="25" style="padding-bottom: 10px"><HomeFilled /></el-icon>登入 /
                  註冊
                </a>
              </template>
              <el-menu-item index="1-1"><a href="/userHome">會員登入</a></el-menu-item>
              <el-menu-item index="1-2"><a href="/sellerHome">商家登入</a></el-menu-item>
            </el-sub-menu>
          </el-menu>
        </li>
        <!-- <li>
          <a href="#"><font-awesome-icon icon="fa-solid fa-message" /> 訊息</a>
        </li> -->
      </ul>
    </nav>
  </header>
</template>

<script setup>
import { onUpdated, reactive, ref } from 'vue'
import { HomeFilled, Search, UserFilled, ShoppingTrolley } from '@element-plus/icons-vue'
const activeIndex = ref('1')
// import { reactive, toRefs } from 'vue'
const data = reactive({
  search: ''
})
</script>

<style lang="scss">
@import url('https://fonts.googleapis.com/css2?family=Varela+Round&display=swap');
$themeColor: #f7ddba;
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

#header {
  background-color: #f8d479;
  display: flex; // 橫向排
  flex-wrap: wrap;
  width: 100%;
  height: 80px;
  align-items: center;

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
  nav {
    flex: 5 1 auto;
    ul {
      display: flex;
      list-style-type: none;
      justify-content: space-around;

      li {
        a {
          color:black ;
          text-decoration: none;
          font-size: 1.35rem;
          transition: all 0.2s ease;
          padding-bottom: 0.3rem;
          &:hover {
            color:#cd7b00 ;
          }
        }
      }
      .search-bar {
        width: 90%;
        height: 32px;
        font-size: 20px;
        font-weight: 600;
        // border: 1px solid black;
        background-color: #fff;
        border-radius: 10px;
      }
    }
  }
}
:root {
  .el-sub-menu__title {
    height: 2;
    line-height: 1.5;
    vertical-align: middle;
  }
  .el-menu--horizontal.el-menu {
    border-bottom: 0 transparent;
  }
}
</style>
