<template>
  <!-- 還沒處理單獨通知點開時字體變已讀顏色 -->
  <main>
    <div style="width: 600px; text-align: right">
      <button id="read" @click="allRead()">全部設為已讀</button>
    </div>
    <div class="list">
      <el-collapse accordion>
        <el-collapse-item name="1" @click="singleRead()">
          <template #title>
            <div class="icon" style="background: #f8d479">
              <img
                width="38"
                height="38"
                src="https://img.icons8.com/sf-regular/48/document.png"
                alt="document"
              />
            </div>
            &emsp;
            <span :class="[isRead || oneRead ? 'isReadColor' : 'notReadColor']"
              >您有一筆新訂單</span
            >
          </template>
          <div class="content">
            <span class="tag-cloud whisperer">溝通</span>&emsp;
            <ins style="color: blue">訂單編號：AXXXXXX08271345</ins>
          </div>
        </el-collapse-item>
      </el-collapse>
    </div>

    <div class="list">
      <el-collapse accordion>
        <el-collapse-item name="2" @click="singleRead()">
          <template #title>
            <div class="icon" style="background: #f8d479">
              <img
                width="38"
                height="38"
                src="https://img.icons8.com/sf-regular/48/document.png"
                alt="document"
              />
            </div>
            &emsp;
            <span :class="[isRead || oneRead ? 'isReadColor' : 'notReadColor']"
              >您有一筆新訂單</span
            >
          </template>
          <div class="content">
            <span class="tag-cloud graphy">攝影</span>&emsp;
            <ins style="color: blue">訂單編號：BXXXXXX09070303</ins>
          </div>
        </el-collapse-item>
      </el-collapse>
    </div>

    <div class="list">
      <el-collapse accordion>
        <el-collapse-item name="3" @click="singleRead()">
          <template #title>
            <div class="icon" style="background: #6ccd64">
              <img
                width="38"
                height="38"
                src="https://img.icons8.com/windows/64/average-2.png"
                alt="average-2"
              />
            </div>
            &emsp;<span :class="[isRead || oneRead ? 'isReadColor' : 'notReadColor']"
              >您有一筆新帳款進帳</span
            >
          </template>
          <div class="content">
            <span class="tag-cloud beauty">美容</span>&emsp;
            <ins style="color: blue">訂單編號：BXXXXXX08217849</ins>
          </div>
        </el-collapse-item>
      </el-collapse>
    </div>

    <div class="list">
      <el-collapse accordion>
        <el-collapse-item name="4" @click="singleRead()">
          <template #title>
            <div class="icon" style="background: #d3c2aa">
              <img
                width="30"
                height="30"
                src="https://img.icons8.com/ios-glyphs/60/star--v1.png"
                alt="star--v1"
                style="margin: 3px"
              />
            </div>
            &emsp;
            <span :class="[isRead || oneRead ? 'isReadColor' : 'notReadColor']"
              >您收到一則評價</span
            >
          </template>
          <div class="content">
            <span class="tag-cloud whisperer">溝通</span>&emsp;
            <p style="color: #888888">訂單編號：AXXXXXX08271345&emsp;<button>查看詳情</button></p>
          </div>
        </el-collapse-item>
      </el-collapse>
    </div>

    <div class="list">
      <el-collapse accordion>
        <el-collapse-item name="5" @click="singleRead()">
          <template #title>
            <div class="icon" style="background: #ee5f5f">
              <img
                width="31"
                height="31"
                src="https://img.icons8.com/external-tanah-basah-basic-outline-tanah-basah/48/external-shield-security-tanah-basah-basic-outline-tanah-basah-2.png"
                alt="external-shield-security-tanah-basah-basic-outline-tanah-basah-2"
                style="margin: 3px"
              />
            </div>
            &emsp;
            <span :class="[isRead || oneRead ? 'isReadColor' : 'notReadColor']"
              >平台系統維護通知</span
            >
          </template>
          <div class="content">
            <p>
              為提供更優質的服務，本平台將於 9月2日 凌晨03:00-05:00 進行系統維護作業<br />
              影響範圍：維護期間，信用卡交易可能會有交易失敗情況發生。<br />
              造成不便之處，請多見諒，謝謝。<br />
              *如有任何問題，歡迎使用<ins style="color: #888888">平台私訊</ins>聯絡我們！
            </p>
          </div>
        </el-collapse-item>
      </el-collapse>
    </div>
  </main>
</template>

<script lang="ts" setup>
import { ref } from 'vue'
const isRead = ref(false)
const oneRead = ref(false)
const allRead = () => {
  isRead.value = true
}
const singleRead = () => {
  oneRead.value = true
}
</script>

<style lang="scss">
.icon {
  width: 40px;
  height: 40px;
  border-radius: 15px;
  align-items: center;
  padding: 1px;
}
.list {
  width: 600px;
  height: 100%;
  border-radius: 10px;
  border: 1px solid rgba(217, 217, 217, 0.65);
  background: #fff;
  box-shadow: 0px 4px 4px 0px rgba(0, 0, 0, 0.25);
  padding: 10px;
  margin: 10px;
}
.notReadColor {
  color: red;
}
.isReadColor {
  color: black;
}
.content {
  padding: 10px;
  margin-left: 30px;
  display: flex;
}

.tag-cloud {
  display: inline-block;
  color: #666666;
  /* width: 35%; */
  width: 80px;
  /* padding: 8px 20px; */
  border-radius: 25px;
  margin-top: 2px;
  text-align: center;
}
ins {
  font-size: medium;
}
span {
  font-size: medium;
}
p {
  font-size: medium;
}

:root {
  .el-collapse-item__header {
    border: 0px;
  }
  .el-collapse {
    border-top: 0px;
    border-bottom: 0px;
  }
  .el-collapse-item__wrap {
    border-bottom: 0px;
  }
  .el-collapse-item__content {
    padding-bottom: 10px;
  }
}
</style>
