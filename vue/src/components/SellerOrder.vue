<!-- seller 商家,賣家 -->
<!-- owner 飼主 -->
<!-- pet 飼主的寵物 -->
<!-- order 訂單 -->
<!-- Inf 資訊 -->

<script lang="ts" setup>
// import SellerOrderTitle from './SellerOrderTitle.vue'
import { ref, reactive, toRefs} from 'vue'
const activeNames = ref(['1'])
const handleChange = (val: string[]) => {
  console.log(val)
}
const taskColor = '#F8D479'
const activities = [
  {
    content: '收到訂單',
    timestamp: '2018-04-15',
    color: taskColor,
  },
  {
    content: '接受訂單',
    timestamp: '2018-04-13',
  },
  {
    content: '寵物報到',
    timestamp: '2018-04-11',
  },
  {
    content: '服務完成',
    timestamp: '2018-04-11',
  },
  {
    content: '撥款完成',
    timestamp: '2018-04-11',
  }
]

const data = reactive({
  orderstate1:"收到訂單",
  orderstate2:"接受訂單",
  orderstate3:"寵物報到",
  orderstate4:"服務完成",
  orderstate5:"撥款完成",
  timeline1: '2018-04-11',//收到
  timeline2: '2018-04-11',//接受
  timeline3: '2018-04-13',//報到
  timeline4: '2018-04-15',//完成
  timeline5: '2018-04-18',//撥款
  petName:'',
  petGender:'',
  userEmail:'',
  phoneNumber:'',
  petClass:'',
  variety:'',//品種
  personAlity:'',
  petAge:'',
  serviceName:'',
  OrderMsg:'' //訂單備註
})

const {

} = toRefs(data)
</script>


<template>
  <el-row :gutter="0" class="detail">

    <table>
      <tr>
        <td rowspan="2" class="side petMain">
          <img src="public\cat.JPG">
          <p>寵物名</p>
          <p>(性別)</p>
          <br>
          <button class="tag-cloud button" id="report">檢舉</button>
        </td>
        <th colspan="2" class="productTitle">
          <h3>飼主下單的店家服務名稱飼主下單的店家服務名稱(限20字)</h3>
        </th>
        <th colspan="1" class="productPrice">
          <span>單價: </span>
        </th>
      </tr>
      <tr>
        <td class="orderInf">
          <p >飼主: </p>
          <p >電話: </p>
          <!-- <p >使用優惠: </p> -->
          <br>
          <p >類別: </p>
          <p >品種: </p>
          <p >個性: </p>
          <p >年紀: </p>
        </td>
        <td class="end orderInf">
          <div class="ownerMsg">備註欄:</div>
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
  border: 2px solid #F8D479;
  border-radius: 10px;
  align-items: center;
  background-color: white;
}

table{
  width: 100%;
}
th{
  text-align: left;
}
.orderInf{
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
  background-color: #FFF3BF;
  border: 1px solid #F8D479;
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