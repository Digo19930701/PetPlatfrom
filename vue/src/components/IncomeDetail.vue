<!-- "訂單編號":"orderNum" -->
<!-- "撥款時間":"remit" -->
<!-- "付款方式":"payMethod" -->
<!-- "撥款金額":"payment" -->
<template>
  <div class="hw base">
    <header>
      <h2>進帳詳情</h2>
    </header>
    <main>
      <div class="choose">
        <span class="s">選擇日期</span>&emsp;
        <div>
          <el-date-picker
            v-model="value2"
            type="daterange"
            unlink-panels
            range-separator="-"
            start-placeholder="開始日期"
            end-placeholder="結束日期"
            :shortcuts="shortcuts"
            size="default"
          />
        </div>
      </div>
      <br />
      <div class="table" style="width: 700px">
        <el-table :data="tableData" border style="width: 700px">
          <el-table-column prop="OrderNum" label="訂單編號" width="210" />
          <el-table-column prop="Remit" label="撥款時間" width="147" />
          <el-table-column prop="AccountNumber" label="撥款帳號" width="196" />
          <el-table-column prop="Payment" label="撥款金額" width="147" />
        </el-table>
      </div>
      <br />
    </main>
  </div>
</template>

<script lang="ts" setup>
import { ref, reactive, toRefs} from 'vue'

const value2 = ref('')

const shortcuts = [
  {
    text: '本週',
    value: () => {
      const end = new Date()
      const start = new Date()
      start.setTime(start.getTime() - 3600 * 1000 * 24 * 7)
      return [start, end]
    }
  },
  {
    text: '本月',
    value: () => {
      const end = new Date()
      const start = new Date()
      start.setTime(start.getTime() - 3600 * 1000 * 24 * 30)
      return [start, end]
    }
  },
  {
    text: '過去三個月',
    value: () => {
      const end = new Date()
      const start = new Date()
      start.setTime(start.getTime() - 3600 * 1000 * 24 * 90)
      return [start, end]
    }
  }
]

const data = reactive({

  orderNum: 'AXXXX08271345',
  remit: '2023/08/14',
  accountNumber:'********1554',
  payment: 'NT$350'
})
const {orderNum, remit, accountNumber, payment} = toRefs(data)
const tableData =[
  {
    OrderNum: orderNum,
    Remit: remit,
    AccountNumber: accountNumber,
    Payment: payment
  },
  {
    OrderNum: orderNum,
    Remit: remit,
    AccountNumber: accountNumber,
    Payment: payment
  },
  {
    OrderNum: orderNum,
    Remit: remit,
    AccountNumber: accountNumber,
    Payment: payment
  },
  {
    OrderNum: orderNum,
    Remit: remit,
    AccountNumber: accountNumber,
    Payment: payment
  },
  {
    OrderNum: orderNum,
    Remit: remit,
    AccountNumber: accountNumber,
    Payment: payment
  },
  {
    OrderNum: orderNum,
    Remit: remit,
    AccountNumber: accountNumber,
    Payment: payment
  },
  {
    OrderNum: orderNum,
    Remit: remit,
    AccountNumber: accountNumber,
    Payment: payment
  },
  
]
</script>

<style lang="scss">
h2 {
  color: #888888;
  font-weight: bolder;
  padding-left: 10px;
}

.el-table {
  --el-table-border-color: #888888;
  --el-table-header-text-color: black;
  --el-table-header-bg-color: #d9d9d9;
}

.el-date-editor {
  --el-input-border: #888;
  --el-input-hover-border: #e5a426;
}
.el-range-editor.is-active {
  box-shadow: 0 0 0 1px #f8d479 inset;
}
.el-date-range-picker {
  --el-datepicker-inrange-bg-color: #ffcb46ab;
  --el-datepicker-active-color: #e5a426;
  --el-datepicker-hover-text-color: #e5a426;
}
.s {
  color: black;
  font-weight: bolder;
  font-size: large;
}
.hw {
  width: 70%;
  height: 100%;
  min-width: 600px;
}
.choose {
  display: flex;
  margin: 10px;
  justify-content: center;
}
.table {
  margin-left: auto;
  margin-right: auto;
}
</style>
