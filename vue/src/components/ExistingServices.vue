<template>
  <el-container>
    <el-header class="header">
      <el-text class="h_text">(推撥內容/畫面) </el-text>
    </el-header>
    <el-main>
      <el-row>
        <h3>現有服務</h3>
      </el-row>
      <el-row>
        <div class="radius">
          <el-text class="text">美容</el-text>
        </div>
      </el-row>
      <el-row>
        <el-col v-for="(o, index) in 3" :key="o" :span="7" :offset="index > 0 ? 1 : 0">
          <el-text v-model="good_title">
            <h3>{{ good_title }}</h3>
          </el-text>
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
            </div>
          </el-card>

          <el-row class="btns">
            <el-button round class="delete_btn"> 刪除 </el-button>
            <el-button round class="edit_btn"> 編輯 </el-button>
          </el-row>
        </el-col>
      </el-row>
    </el-main>
  </el-container>
</template>

<style lang="scss">
.header {
  background-color: rgb(199, 197, 197);
  width: 100%;
  display: inline-flex;
  .h_text {
    position: absolute;
    left: 50%;
  }
}
.el-main {
  background-color: rgb(248, 244, 218);
  .radius {
    border-radius: 25px;
    background-color: #ffbfd6;
    width: 40px;

    .text {
      font-size: small;
      padding-left: 15%;
    }
  }
  .image {
    width: 100%;
    display: block;
  }
  .btns {
    // padding: 10%;
  }
}
</style>

<script lang="ts" setup>
import { ref } from 'vue'
const good_title = '小貓小狗洗香香'
</script>
