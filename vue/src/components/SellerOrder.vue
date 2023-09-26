<!-- seller 商家,賣家 -->
<!-- owner 飼主 -->
<!-- pet 飼主的寵物 -->
<!-- order 訂單 -->
<!-- Inf 資訊 -->

<script lang="ts" setup>
// import SellerOrderTitle from './SellerOrderTitle.vue'
import { ref, reactive, toRefs } from 'vue'

const data = reactive({
  orderstate1: '收到訂單',
  orderstate2: '接受訂單',
  orderstate3: '寵物報到',
  orderstate4: '服務完成',
  orderstate5: '撥款完成',
  timeline1: '2018-04-11', //收到
  timeline2: '2018-04-11', //接受
  timeline3: '2018-04-13', //報到
  timeline4: '2018-04-15', //完成
  timeline5: '2018-04-18', //撥款
  petName: '寵物名',
  petGender: '(性別)',
  userEmail: '',
  phoneNumber: '',
  petClass: '',
  variety: '', //品種
  personAlity: '',
  petAge: '',
  serviceName: '飼主下單的店家服務名稱(限20字)',
  OrderMsg: '', //訂單備註
  price: ''
})

const {
  orderstate1,
  orderstate2,
  orderstate3,
  orderstate4,
  orderstate5,
  timeline1,
  timeline2,
  timeline3,
  timeline4,
  timeline5,
  petName,
  petGender,
  userEmail,
  phoneNumber,
  petClass,
  variety,
  personAlity,
  petAge,
  serviceName,
  OrderMsg,
  price
} = toRefs(data)

const activeNames = ref(['1'])
const handleChange = (val: string[]) => {
  console.log(val)
}
const taskColor = '#F8D479'
const activities = [
  {
    content: orderstate1,
    timestamp: timeline1,
    color: taskColor
  },
  {
    ccontent: orderstate2,
    timestamp: timeline2
  },
  {
    content: orderstate3,
    timestamp: timeline3
  },
  {
    content: orderstate4,
    timestamp: timeline4
  },
  {
    content: orderstate5,
    timestamp: timeline5
  }
]
</script>

<template>
  <el-row :gutter="0" class="detail">
    <table>
      <tr>
        <td rowspan="2" class="side petMain">
          <img src="public\cat.JPG" />
          <p>{{ petName }}</p>
          <p>{{ petGender }}</p>
          <br />
          <button class="tag-cloud button" id="report">檢舉</button>
        </td>
        <th colspan="2" class="productTitle">
          <h3>{{ serviceName }}</h3>
        </th>
        <th colspan="1" class="productPrice">
          <span>單價 NT${{ price }} </span>
        </th>
      </tr>
      <tr>
        <td class="orderInf">
          <p>飼主: {{ userEmail }}</p>
          <p>電話: {{ phoneNumber }}</p>
          <!-- <p >使用優惠: </p> -->
          <br />
          <p>類別: {{ petClass }}</p>
          <p>品種: {{ variety }}</p>
          <p>個性: {{ personAlity }}</p>
          <p>年紀: {{ petAge }}</p>
        </td>
        <td class="end orderInf">
          <div class="ownerMsg">備註欄:{{ OrderMsg }}</div>
          <!-- <table class="orderTask">
              <tr>
                <td>收到訂單</td>
                <td>接受訂單</td>
                <td>寵物報到</td>
                <td>服務完成</td>
              </tr>
            </table> -->
        </td>
        <td class="end">
          <el-timeline>
            <el-timeline-item
              v-for="(activity, index) in activities"
              :key="index"
              :timestamp="activity.timestamp"
              :color="activity.color"
            >
              {{ activity.content }}
            </el-timeline-item>
          </el-timeline>
        </td>
      </tr>
    </table>
  </el-row>
</template>

<style>
.detail {
  width: 100%;
  border: 2px solid #f8d479;
  border-radius: 10px;
  align-items: center;
  background-color: white;
}

table {
  width: 100%;
}
th {
  text-align: left;
}
.orderInf {
  vertical-align: top;
}

.side {
  width: 20%;
}

.end {
  width: 25%;
  vertical-align: top;
}

.petMain {
  text-align: center;
}
.petMain img {
  width: 80%;
  margin-top: 5%;
}

#report {
  margin-bottom: 5%;
}

.productTitle h3 {
  color: #666666;
  font-weight: bold;
}

.productPrice {
  color: #666666;
  padding-left: 5%;
}

.ownerMsg {
  min-height: 60px;
  margin: 2%;
  padding: 1%;
  background-color: #fff3bf;
  border: 1px solid #f8d479;
  border-radius: 10px;
}

.orderTask {
  width: 95%;
  margin: 2%;
  text-align: center;
}

.orderTask td {
  width: 5px;
  border-top: 4px solid #ffcb46;
  padding-left: 2px;
}

.el-timeline {
  padding: 0px;
}
</style>
