<!-- seller 商家,賣家 -->
<!-- owner 飼主 -->
<!-- pet 飼主的寵物 -->
<!-- order 訂單 -->
<!-- Inf 資訊 -->
<template>
  <el-row :gutter="0" class="detail">
    <table id="orderDetail">
      <tr>
        <td rowspan="2" class="side petMain">
          <img src="../images/cat.JPG" />
          <p>{{ petName }}</p>
          <p>{{ petGender }}</p>
          <br />
          <button class="tag-cloud button" id="report">檢舉</button>
        </td>
        <td class="orderInf" rowspan="2">
          <p>飼主: {{ userName }}({{ userEmail }})</p>
          <p>電話: {{ phoneNumber }}</p>
          <!-- <p >使用優惠: </p> -->
          <br />
          <p>類別: {{ petClass }}</p>
          <p>品種: {{ petVariety }}</p>
          <p>個性: {{ petCharacter }}</p>
          <p>年紀: {{ petAge }}</p>
        </td>
        <td class="end orderInf">
          <div class="ownerMsg">備註欄:{{ orderMsg }}</div>
        </td>
      </tr>
      <!-- <tr>
        <td class="end">
          <br>
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
      </tr> -->
      <tr style="height: 220px">
        <table id="timeline">
          <tr class="stateColor">
            <th class="gap onState"></th>
            <th class="gap"></th>
            <th class="gap"></th>
            <th class="gap"></th>
            <th class="gap"></th>
          </tr>
          <tr>
            <td>{{ orderstate1 }}</td>
            <td>{{ orderstate2 }}</td>
            <td>{{ orderstate3 }}</td>
            <td>{{ orderstate4 }}</td>
            <td>{{ orderstate5 }}</td>
          </tr>
          <tr>
            <td>{{ timeline1 }}</td>
            <td>{{ timeline2 }}</td>
            <td>{{ timeline3 }}</td>
            <td>{{ timeline4 }}</td>
            <td>{{ timeline5 }}</td>
          </tr>
          <tr>
            <td><el-button type="primary" plain>接受</el-button></td>
            <td></td>
            <td><el-button type="primary" plain disabled>已報到</el-button></td>
            <td><el-button type="primary" plain disabled>已完成</el-button></td>
            <td></td>
          </tr>
          <tr>
            <td><el-button type="primary" plain>拒絕</el-button></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
        </table>
      </tr>
    </table>
  </el-row>
</template>

<script lang="ts" setup>
// import SellerOrderTitle from './SellerOrderTitle.vue'
import { ref, reactive, toRefs } from 'vue'

const data = reactive({
  orderstate1: '收到訂單',
  orderstate2: '接受訂單',
  orderstate3: '寵物報到',
  orderstate4: '服務完成',
  orderstate5: '撥款完成',
  timeline1: '2023-10-04', //收到
  timeline2: '', //接受
  timeline3: '', //報到
  timeline4: '', //完成
  timeline5: '', //撥款
  petName: '寵物名',
  petGender: '(性別)',
  userEmail: '',
  userName: '',
  phoneNumber: '',
  petClass: '',
  petVariety: '', //品種
  petCharacter: '',
  petAge: '',
  serviceName: '飼主下單的店家服務名稱(限20字)',
  orderMsg: '', //訂單備註
  price: '',
  petImage: ''
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
  userName,
  phoneNumber,
  petClass,
  petVariety,
  petCharacter,
  petAge,
  serviceName,
  orderMsg,
  price,
  petImage
} = toRefs(data)
/*
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
]*/
</script>

<style lang="scss" scoped>
.detail {
  width: 100%;
  border: 2px solid #f8d479;
  border-radius: 10px;
  align-items: center;
  background-color: white;
}

#orderDetail {
  width: 100%;
  height: 100%;
  p {
    font-size: 1.3rem;
  }
  th {
    text-align: left;
  }
}
.orderInf p {
  vertical-align: top;
  padding-left: 20px;
  padding-top: 10px;
}

.side {
  width: 20%;
}

.end {
  width: 45%;
  vertical-align: top;
}
table table > tr:nth-child(2) {
  font-size: large;
}
// table table > tr > td {
//   font-size: large;
// }

#timeline {
  width: 95%;
  height: 100%;
  text-align: center;
  border: 10px solid #ffffff;
}
.gap {
  border-left: 15px solid #fff;
  border-right: 15px solid #fff;
}
.onState {
  background-color: #ffcb46;
}
.stateColor {
  background-color: #d9d9d9;
  height: 7px;
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

.productTitle span {
  color: #666666;
  font-weight: bold;
  font-size: x-large;
  height: 40px;
  padding-left: 20px;
}

.productPrice {
  color: #666666;
  padding-left: 5%;
  width: 25%;
  font-weight: bold;
  font-size: large;
}

.ownerMsg {
  min-height: 130px;
  width: 90%;
  margin: 2%;
  padding: 1%;
  background-color: #fff3bf;
  border: 1px solid #f8d479;
  border-radius: 10px;
  font-size: large;
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

// .el-timeline {
//   padding-right: 5px;
//   padding-top: 10+px;
// }
</style>
