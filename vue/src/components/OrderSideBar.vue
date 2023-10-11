<template>
  <el-aside>
    <br />
    <div style="padding: 14px">
      <p>我們有的服務</p>

      <router-link to="/search"><a>洗澡&SPA</a></router-link>

      <br />
      <router-link to="/search"><a>預約寵物溝通</a></router-link>

      <br />
      <router-link to="/search"><a>預約寵物攝影</a></router-link>

      <br />
      <router-link to="/search"><a>寵物照顧</a></router-link>
      <el-divider />
      <router-link to="/search"><a>查看所有服務</a></router-link>
      <!-- <p>我需要保母</p>
      <router-link to="/search"><a>寵物安親</a></router-link>


      <br />
      <router-link to="/search"><a>到府服務</a></router-link>

      <br />
      <router-link to="/search"><a>小奶貓狗照護</a></router-link>

      <el-divider />

      <p>想知道...</p>
      <router-link to="/search"><a></a></router-link>

      <el-divider />

      <p>記錄美好瞬間</p>
      <router-link to="/search"><a></a></router-link> -->
    </div>
  </el-aside>
</template>

<script setup></script>
<style lang="scss" scoped>
.el-aside {
  background-color: #f8f4da;
  height: 100vh;
  width: 17%;
  padding-left: 20px;
}
p {
  font-size: 1.5rem;
  font-weight: bold;
  color: #ff8400;
}
a {
  font-size: 1.3rem;
}
</style>
