<template>
  <header>
    <h2 style="color: #888888; font-weight: bolder">通知設定</h2>
  </header>
  <br />
  <main>
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
              <el-switch v-model="notifyNewOrder" />
            </td>

            <td>
              功能增修通知&emsp;&emsp;
              <el-switch v-model="notifyFunction" />
            </td>
          </tr>
          <tr>
            <td class="mid_line">
              訂單取消通知&emsp;&emsp;
              <el-switch v-model="notifyCancelOrder" />
            </td>
            <td>平台系統維護通知 <el-switch v-model="notifyMaintain" /></td>
          </tr>
          <tr>
            <td class="mid_line">
              評價通知&emsp;&emsp;&emsp;&emsp;
              <el-switch v-model="notifyRate" />
            </td>
            <td>帳款異常通知 &emsp;&emsp;<el-switch v-model="notifyAbnormal" /></td>
          </tr>
          <tr>
            <td class="mid_line">
              進帳&退款通知 &emsp;
              <el-switch v-model="notifyAccounting" />
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
import { ref } from 'vue'

const notifyNewOrder = ref(true)
const notifyCancelOrder = ref(true)
const notifyRate = ref(true)
const notifyAccounting = ref(true)
const notifyFunction = ref(true)
const notifyMaintain = ref(true)
const notifyAbnormal = ref(true)
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
  text-align: center;
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
