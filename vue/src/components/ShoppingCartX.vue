<template>
  <div id="title">
    <div style="width: 50px"><ShoppingTrolley /></div>
    &nbsp;購物車
  </div>
  <header>
    <table id="customer">
      <tr>
        <td>客戶資料</td>
        <!-- <td>姓名: {{ cars.userName }}</td>
        <td>電話: {{ cars.phoneNumber }}</td> -->
        <td>姓名:</td>
        <td>電話:</td>
      </tr>
    </table>
    <el-divider />
    <div style="width: 100%; display: flex; justify-content: center">
      <table style="width: 97%; text-align: center" id="listTitle">
        <tr>
          <th>
            <input
              style="transform: scale(2)"
              type="checkbox"
              v-model="selectAll"
              @change="toggleSelectAll"
            />&nbsp;&nbsp;全選
          </th>
          <th>服務</th>
          <th>預約時間</th>
          <th>單價</th>
          <th>操作</th>
          <th>備註欄</th>
          <th>寵物資訊</th>
        </tr>
      </table>
    </div>
  </header>
  <main>
    <div v-for="(item, index) in itemList" :key="item.id">
      <div class="item_header item_body">
        &emsp;
        <input style="transform: scale(2)" type="checkbox" v-model="item.checked" />&emsp;
        <div class="item_detail">
          <!-- <img v-bind:src="cars.serviceImg" alt="" />
          <div class="name">{{ cars.serviceName }}</div> -->
          <ElImage
            src="https://media.istockphoto.com/id/1331301152/photo/photo-in-motion-running-beautiful-golden-retriever-dog-have-a-walk-outdoors-in-the-park.jpg?s=1024x1024&w=is&k=20&c=JZ6x5NMk_sTZwQAs2iR3MUr6JfEmjqszXIBrv2HAOB8="
            alt=""
            cover
            style="width: 100px; height: 70px"
          />
          <div class="name">洗澡&SPA&emsp;狗 中型犬</div>
        </div>
        <div class="block">
          <el-date-picker v-model="date" type="date" placeholder="選擇預約日期" :size="size" />
          <el-time-select
            v-model="startTime"
            :max-time="endTime"
            placeholder="開始"
            start="08:00"
            step="01:00"
            end="17:00"
            :size="size"
          />
          <el-time-select
            v-model="endTime"
            :min-time="startTime"
            placeholder="結束"
            start="08:00"
            step="01:00"
            end="17:00"
            :size="size"
          />
        </div>
        <div style="width: 45%">
          <!-- <span style="padding-left: 20%">$&emsp;</span>{{ cars.payment }} -->
          <span style="padding-left: 40%">NT$</span>1800
        </div>
        <div style="width: 3%">
          <el-button @click="handledelete(index)">刪除</el-button>
        </div>
        <div style="width: 50%; text-align: right">
          <el-input v-model="msg" style="width: 150px; font-size: 1.1rem" size="large" />&nbsp;
          <el-select v-model="petInfo" class="m-2" placeholder="選擇寵物" :size="size" disabled>
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            />
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
            <div>總計<span>NT$</span>{{ totalAmount }}</div>
          </th>
          <th style="width: 40%"></th>
          <th>
            <el-button @click="open">結帳</el-button>
          </th>
        </tr>
      </table>
    </div>
  </footer>

  <div v-if="view === 2">
    <div class="item_header fixed">
      <el-button @click="cview(1)">回購物車</el-button>
    </div>
    <Checkout />
    <div class="item_header checkout">
      <div>總計<span>$</span>{{ totalAmount }}</div>
      <el-button>付款</el-button>
    </div>
  </div>
</template>

<script lang="ts" setup>
import CarService from '../services/CarService'
import { ref, computed, onMounted, reactive } from 'vue'
import { ShoppingTrolley } from '@element-plus/icons-vue'
import { ElImage, ElMessageBox } from 'element-plus'
import { useRouter } from 'vue-router'

const msg = ref('討厭剪指甲')
const router = useRouter()
const open = () => {
  ElMessageBox.confirm(
    '註冊成為我們的會員，就可以預約想要的服務~ 按下確認我們將為您跳轉至註冊頁面！',
    '提醒',
    {
      cancelButtonText: '取消',
      confirmButtonText: '確認',
      type: 'warning'
    }
  ).then(() => {
    router.push('/login')
  })
}

let cars: any = []

const getCars = async () => {
  const response = await CarService.getCars()
  cars = response.data
  console.log(cars)
}

onMounted(() => {
  getCars()
})

const petInfo = ref('')

const options = [
  {
    value: 'Option1',
    label: '寵物A'
  },
  {
    value: 'Option2',
    label: '寵物B'
  }
  // {
  //   value: 'Option3',
  //   label: '寵物C'
  // }
]

//綠界
const sendPostRequest = async () => {
  window.location.href = 'http://localhost:3300/4A2Bpet/ecpayCheckout'
}
//日期
const date = ref('2023-10-19')
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
const startTime = ref('10:00')
const endTime = ref('11:00')

//畫面
const view = ref(1)
const cview = (ind) => {
  view.value = ind
}
//全選
const selectAll = ref(false)
const toggleSelectAll = () => {
  const allChecked = itemList.value.every((item) => item.checked)
  itemList.value.forEach((item) => (item.checked = !allChecked))
}
//總計
const totalAmount = computed(() => {
  return itemList.value.reduce((total, item) => {
    // 如果商品被選中，才將其價格加入金额
    if (item.checked) {
      // total += parseInt(cars.payment)
      total += parseInt('1800')
    }
    return total
  }, 0)
})

const itemList = ref([
  {
    id: '1',
    itemName: '洗澡',
    imgUrl:
      'https://media.istockphoto.com/id/1331301152/photo/photo-in-motion-running-beautiful-golden-retriever-dog-have-a-walk-outdoors-in-the-park.jpg?s=1024x1024&w=is&k=20&c=JZ6x5NMk_sTZwQAs2iR3MUr6JfEmjqszXIBrv2HAOB8=',
    // price: '500',
    count: '2023/09/02 12:00',
    checked: false
    // },
    // {
    //   id: '2',
    //   itemName: '美容',
    //   imgUrl:
    //     'https://images.unsplash.com/photo-1503342217505-b0a15ec3261c?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1500&q=80',
    //   // price: '790',
    //   count: '2023/02/02 12:00',
    //   checked: false
  }
])

//刪除
const handledelete = (index) => {
  console.log(this)
  itemList.value.splice(index, 1)
}
</script>

<style>
.el-message-box__message p {
  margin: 0;
  line-height: 40px;
  font-size: 1.7rem;
}
</style>

<style lang="scss" scoped>
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
#customer tr > td:nth-child(1) {
  font-size: 1.5rem;
  width: 30%;
}
#customer tr > td:nth-child(2) {
  font-size: 1.5rem;
}
#customer tr > td:nth-child(3) {
  font-size: 1.5rem;
}

#listTitle tr > th:nth-child(1) {
  padding-left: 10px;
  width: 8.7%;
  line-height: 1;
}
#listTitle tr > th:nth-child(2) {
  width: 22%;
}
#listTitle tr > th:nth-child(3) {
  width: 25%;
}
#listTitle tr > th:nth-child(4) {
  width: 15%;
}
#listTitle tr > th:nth-child(7) {
  width: 12%;
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
  padding-left: 3%;
  /* min-width: 500px; */
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
  width: 45%;
  line-height: 30px;
}

.item_header .item_detail {
  width: 60%;
}

.item_body {
  margin-top: 20px;
  height: 100px;
  align-items: center;
  width: 95%;
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
  width: 60%;
}
</style>
