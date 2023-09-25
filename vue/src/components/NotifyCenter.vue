<template>
  <!-- 還沒處理單獨通知點開時字體變已讀顏色 -->
  <main>
    <div class="alignRight">
      <button id="read" @click="allRead()">全部設為已讀</button>
    </div>
    <div class="list">
      <el-collapse accordion>
        <el-collapse-item name="1" @click="singleRead()">
          <template #title>
            <img src="../images/neworder_icon.png" alt="new order" />
            &emsp;
            <span :class="[isRead || oneRead ? 'isReadColor' : 'notReadColor']">
              {{ noticedNewOrder }}
            </span>
          </template>
          <div class="content">
            <div style="width: 80%">
              <span class="tag-cloud whisperer">溝通</span>&emsp;
              <router-link to="/sellerOrder1">
                <ins style="color: blue">{{ orderNum }}</ins>
              </router-link>
            </div>
            <div class="alignRight">
              <p>{{ timeline1 }}</p>
            </div>
          </div>
        </el-collapse-item>
      </el-collapse>
    </div>

    <div class="list">
      <el-collapse accordion>
        <el-collapse-item name="2" @click="singleRead()">
          <template #title>
            <img src="../images/cancelorder_icon.png" alt="order had been cancel" />
            &emsp;
            <span :class="[isRead || oneRead ? 'isReadColor' : 'notReadColor']">
              {{ noticedCancelOrder }}
            </span>
          </template>
          <div class="content">
            <div style="width: 80%">
              <span class="tag-cloud graphy">攝影</span>&emsp;
              <router-link to="/sellerOrder2">
                <ins style="color: blue">{{ orderNum }}</ins>
              </router-link>
            </div>
            <div class="alignRight">
              <p>{{ timeline1 }}</p>
            </div>
          </div>
        </el-collapse-item>
      </el-collapse>
    </div>

    <div class="list">
      <el-collapse accordion>
        <el-collapse-item name="3" @click="singleRead()">
          <template #title>
            <img src="../images/accounting_icon.png" alt="new income" />
            &emsp;
            <span :class="[isRead || oneRead ? 'isReadColor' : 'notReadColor']">
              {{ noticedAccounting }}
            </span>
          </template>
          <div class="content">
            <div style="width: 80%">
              <span class="tag-cloud beauty">美容</span>&emsp;
              <router-link to="/accountingPage">
                <ins style="color: blue">{{ orderNum }}</ins>
              </router-link>
            </div>
            <div class="alignRight">
              <p>{{ timeline1 }}</p>
            </div>
          </div>
        </el-collapse-item>
      </el-collapse>
    </div>

    <div class="list">
      <el-collapse accordion>
        <el-collapse-item name="4" @click="singleRead()">
          <template #title>
            <img src="../images/rate_icon.png" alt="New rate" />
            &emsp;
            <span :class="[isRead || oneRead ? 'isReadColor' : 'notReadColor']">
              {{ noticedRate }}
            </span>
          </template>
          <div class="content">
            <div style="width: 80%">
              <span class="tag-cloud whisperer">溝通</span>&emsp;
              <p style="color: #888888">
                {{ orderNum }}&emsp;
                <router-link to="/sellerRate">
                  <button>查看詳情</button>
                </router-link>
              </p>
            </div>
            <div class="alignRight">
              <p>{{ timeline1 }}</p>
            </div>
          </div>
        </el-collapse-item>
      </el-collapse>
    </div>

    <div class="list">
      <el-collapse accordion>
        <el-collapse-item name="5" @click="singleRead()">
          <template #title>
            <img src="../images/maintian_icon.png" alt=" Platfrom maintain" />
            &emsp;
            <span :class="[isRead || oneRead ? 'isReadColor' : 'notReadColor']">
              {{ noticedMaintain }}
            </span>
          </template>
          <div class="content">
            <p>
              為提供更優質的服務，本平台將於 9月2日 凌晨03:00-05:00 進行系統維護作業<br />
              影響範圍：維護期間，信用卡交易可能會有交易失敗情況發生。<br />
              造成不便之處，請多見諒，謝謝。
            </p>
          </div>
        </el-collapse-item>
      </el-collapse>
    </div>
  </main>
</template>

<script lang="ts" setup>
import { ref, reactive, toRefs } from 'vue'
const isRead = ref(false)
const oneRead = ref(false)
const allRead = () => {
  isRead.value = true
}
const singleRead = () => {
  oneRead.value = true
}
const dataState = reactive({
  noticedNewOrder: '您有一筆新訂單',
  noticedCancelOrder: '您有一筆訂單被取消',
  noticedRate: '您收到一則評價',
  noticedAccounting: '您有一筆新帳款進帳',
  noticedFunction: '平台系統功能增修通知',
  noticedMaintain: '平台系統維護通知',
  noticedAbnormal: '帳款異常通知',
  orderNum: '訂單編號：AXXXXXX08271345',
  timeline1: '2018-04-15'
})
const {
  noticedNewOrder,
  noticedCancelOrder,
  noticedRate,
  noticedAccounting,
  noticedFunction,
  noticedMaintain,
  noticedAbnormal,
  orderNum,
  timeline1
} = toRefs(dataState)
</script>
<style lang="scss">
.list {
  width: 700px;
  height: 100%;
  border-radius: 10px;
  border: 1px solid rgba(217, 217, 217, 0.65);
  background: #fff;
  box-shadow: 0px 4px 4px 0px rgba(0, 0, 0, 0.25);
  padding: 10px;
  margin: 10px;
}
.alignRight {
  width: 20%;
  text-align: right;
  padding-right: 10px;
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
