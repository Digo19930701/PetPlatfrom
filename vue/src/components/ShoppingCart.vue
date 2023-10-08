<template>
  <div id="title">
    <div style="width: 50px">
      <ShoppingTrolley />
    </div>
    &nbsp;購物車
  </div>
  <header>
    <table id="customer">
      <tr>
        <td>客戶資料</td>

        <td>姓名: {{ CarService.unsr["userName"] }}</td>
        <td>電話: {{ CarService.unsr["phoneNumber"] }}</td>
      </tr>
    </table>
    <el-divider />
    <div style="width: 96%; display: flex; justify-content: center">
      <table style="width: 100%; text-align: center" id="listTitle">
        <tr>
          <th>
            <input style="transform: scale(2)" type="checkbox" v-model="selectAll" @change="toggleAll" />&nbsp;全選
          </th>
          <th>服務項目</th>
          <th>預約時間</th>
          <th>&emsp;&emsp;單價</th>
          <th>操作</th>
          <th>寵物資訊</th>
        </tr>
      </table>
    </div>
  </header>
  <main>
    <div v-for="(item, index) in cars" :key="item.id">
      <div class="item_header item_body">
        &emsp;
        <input style="transform: scale(2)" type="checkbox" v-model="item.checked" />&emsp;
        <div class="item_detail">

          <img v-bind:src="item.serviceImg" alt="" />
          <div class="name">&emsp;{{ item.serviceName }}</div>
        </div>
        <div class="block">
          <el-date-picker v-model="date" type="date" placeholder="選擇預約日期" :size="size" />
          <el-time-select v-model="startTime" :max-time="endTime" placeholder="開始" start="08:00" step="01:00" end="17:00"
            :size="size" />
          <el-time-select v-model="endTime" :min-time="startTime" placeholder="結束" start="08:00" step="01:00" end="17:00"
            :size="size" />
        </div>
        <div style="width: 45%">

          <span style="padding-left: 20%">NT$&emsp;</span>{{ item.price }}
        </div>
        <div>
          <el-button @click="handledelete(item)">刪除</el-button>
        </div>
        <div style="width: 50%; text-align: right">
          <el-select v-model="petInfo" class="m-2" placeholder="選擇寵物" :size="size">
            <el-option v-for="item in cars" :key="item.value" :label="item.variety" :value="item.variety" />
          </el-select>
        </div>
        &emsp;
      </div>
    </div>
  </main>
  <br />
  <footer>
    <div class="footer">
      <table id="checkout">
        <tr>
          <th style="width: 30%">
            <div>總計<span>$&emsp;</span>{{ totalAmount }}</div>
          </th>
          <th style="width: 40%"></th>
          <th>
            <el-button @click="sendPostRequest">結帳</el-button>
          </th>
        </tr>
      </table>
    </div>
  </footer>
</template>

<script  setup>
import CarService from '../services/CarService'
import { ref, computed, onMounted, reactive } from 'vue'
import { ShoppingTrolley } from '@element-plus/icons-vue'
import { ElImage } from 'element-plus'
// import Login from '../views'

const cars = ref([])
onMounted(async () => {
  const response = await CarService.getCars(CarService.unsr['userEmail'])
  cars.value = response.data
  console.log(cars)

})



const petInfo = ref('')



//綠界
const sendPostRequest = async () => {
  if (totalAmount.value == '0') {
    alert("請選擇商品")
  } else {
    window.location.href = `http://localhost:3300/4A2Bpet/ecpayCheckout_by_cars?price=${totalAmount.value}`
  }
}
//日期
const date = ref('')
const size = ref('large')
// const shortcuts = [
//   {
//     text: 'Today',
//     value: new Date()
//   }
// ]
// const disabledDate = (time: Date) => {
//   return time.getTime() > Date.now()
// }
//時間
const startTime = ref('')
const endTime = ref('')

//畫面
const view = ref(1)
const cview = (ind) => {
  view.value = ind
}

const selectAll = ref(false)
const allChecked = ref(false)
//全選
const toggleAll = () => {
  allChecked.value = !allChecked.value
  cars.value.forEach((item) => (item.checked = allChecked.value))
}
//總計
const totalAmount = computed(() => {
  return cars.value.reduce((total, item) => {
    // 如果商品被選中，才將其價格加入金额
    if (item.checked) {

      total += parseInt(item.price)
    }
    return total

  }, 0)
})


//刪除
const handledelete = (item) => {

  cars.value.splice(item, 1)
}
</script>

<style scoped>
#title {
  display: flex;
  font-size: 2rem;
  line-height: 1.5;
  color: #666;
  font-weight: 600;
  padding-left: 2%;
}

#customer {
  width: 50%;
  margin-left: 3%;
}

#customer tr>td:nth-child(1) {
  font-size: 1.5rem;
  width: 30%;
}

#customer tr>td:nth-child(2) {
  font-size: 1.5rem;
}

#customer tr>td:nth-child(3) {
  font-size: 1.5rem;
}

#listTitle tr>th:nth-child(1) {
  padding-left: 10px;
  width: 8.7%;
  line-height: 1;
}

#listTitle tr>th:nth-child(2) {
  width: 22%;
}

#listTitle tr>th:nth-child(3) {
  width: 25%;
}

#listTitle tr>th:nth-child(4) {
  width: 15%;
}

#listTitle tr>th:nth-child(6) {
  width: 13%;
}

div {
  font-size: 25px;
}

.footer {
  display: flex;
  text-align: center;
  justify-content: center;
}

#checkout {
  width: 80%;
  height: 70px;
}

.form {
  font-size: 30px;
  margin: 10px auto;
  width: 90%;
}

div .el-button {
  font-size: 25px;
}

.block {
  display: flex;

  min-width: 400px;
}

.fixed {
  z-index: 1;
  position: fixed;
  top: 60px;
  left: 1px;
}

.item_header {
  display: flex;
  width: 100%;
  margin: 0 auto;
  height: 33px;
  background-color: #fff;
  border-radius: 3px;
  padding-left: 10px;
}

.item_header div {
  /* width: 45%; */
  line-height: 30px;
}

.item_header .item_detail {
  width: 60%;
}

.item_body {
  margin-top: 20px;
  height: 100px;
  align-items: center;
  /* width: 100%; */
}

.item_detail img {
  width: 80px;
  height: 80px;
  border-radius: 3px;
  float: left;
}

.item_detail {
  display: flex;
}

.item_detail .name {
  /* margin-left: 100px; */
  margin-left: 50px;
  margin-top: 25px;
}
</style>
