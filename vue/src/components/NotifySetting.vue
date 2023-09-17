<template>
  <header>
    <h2 style="color: #888888; font-weight: bolder">通知設定</h2>
  </header>
  <br />
  <main>
    <div class="base hw" style="display: flex; padding: 10px">
      <table style="align-items: center">
        <tr>
          <td>
            <span class="title">&nbsp;通知方式</span>
          </td>
          <td>email <el-switch v-model="notifyEmail" /></td>
          <td>推播 <el-switch v-model="notifyPush" /></td>
        </tr>
      </table>
    </div>
    <br />

    <div class="base hw">
      <span class="title">&emsp;通知項目</span>

      <div style="text-align: center">
        <br />
        <table id="secand">
          <tr>
            <th class="th mid_line">商家相關</th>

            <th class="th">平台相關</th>
          </tr>
          <tr>
            <td class="mid_line">
              新訂單通知&emsp;&emsp;&emsp;
              <el-switch v-model="notifyS_1" />
            </td>

            <td>
              功能增修通知&emsp;&emsp;
              <el-switch v-model="notifyP_1" />
            </td>
          </tr>
          <tr>
            <td class="mid_line">
              訂單取消通知&emsp;&emsp;
              <el-switch v-model="notifyS_2" />
            </td>
            <td>平台系統維護通知 <el-switch v-model="notifyP_2" /></td>
          </tr>
          <tr>
            <td class="mid_line">
              評價通知&emsp;&emsp;&emsp;&emsp;
              <el-switch v-model="notifyS_3" />
            </td>
            <td>帳款異常通知 &emsp;&emsp;<el-switch v-model="notifyP_3" /></td>
          </tr>
          <tr>
            <td class="mid_line">
              進帳&退款通知 &emsp;
              <el-switch v-model="notifyS_4" />
            </td>
            <td></td>
          </tr>
        </table>
        <br />
      </div>
    </div>
  </main>
</template>

<script lang="ts" setup>
0

import { ref } from 'vue'

const notifyEmail = ref(true)
const notifyPush = ref(true)
const notifyS_1 = ref(true)
const notifyS_2 = ref(true)
const notifyS_3 = ref(true)
const notifyS_4 = ref(true)
const notifyP_1 = ref(true)
const notifyP_2 = ref(true)
const notifyP_3 = ref(true)
</script>

<style lang="scss">
.hw {
  align-content: center;
  padding: 15px;
  width: 50%;
  min-width: 500px;
}

#secand {
  width: 100%;
  border-collapse: collapse;
}

.title {
  color: #ffcb46;
  font-weight: bolder;
  font-size: x-large;
}

td {
  color: black;
  line-height: 1;
  font-size: large;

  font-weight: bolder;
  padding-left: 20px;
}
.th {
  color: #888888;
  font-weight: bolder;
  font-size: large;
  width: 50%;
  padding-bottom: 10px;
}
.mid_line {
  border-right: 2px solid #888;
  padding-right: 15px;
}

:root {
  .el-switch {
    --el-switch-on-color: var(--el-color-primary-light-3);
    --el-switch-off-color: var(--el-border-color);
  }
}
</style>
