<template>
  <div>
    <el-row :gutter="20" class="board orderTitle" style="margin: 0px 0px 5px 0px">
      <table style="border-collapse: collapse">
        <tr>
          <td rowspan="2" class="date" style="width: 60px; font-size: 1.5rem">
            <p>{{ week }}</p>
            <span>{{ date }}</span>
          </td>
          <td rowspan="2" class="orderTime">
            <div>{{ timeStart }}</div>
            <div justify="center">❙</div>
            <div>{{ timeEnd }}</div>
          </td>
          <td class="orderContent">
            <span class="tag-cloud beauty">{{ productClass }}</span
            ><br />
          </td>
          <td>
            <span>{{ serviceName }}</span>
            <!-- <span>{{ serviceName }}</span> -->
          </td>
          <td style="text-align: right; width: 25%">
            <span class="orderNum" style="font-size: 18px">訂單編號: {{ orderNum }}</span>
          </td>
        </tr>
        <tr>
          <td class="orderContent">
            <span>{{ detail }}</span
            ><br />
          </td>
          <td>
            <span>單價 NT$ {{ price }} </span>
          </td>
          <td style="vertical-align: bottom; text-align: right">
            <button @click="handleCollapse" class="tag-cloud button" id="showDetail">
              訂單詳情
            </button>
          </td>
        </tr>
      </table>
    </el-row>
    <Collapse :when="isOpen" class="collapse">
      <SellerOrder
        :petName="'Oli'"
        :pet-gender="'男生'"
        :user-name="'Digo'"
        :user-email="'4A2Beeit69@gmail.com'"
        :phone-number="'0946523571'"
        :pet-class="'狗'"
        :pet-variety="'柴犬'"
        :pet-character="'熱情'"
        :pet-age="'3'"
        :timeline1="'2023-10-12'"
      />
    </Collapse>
  </div>
</template>

<script setup>
import SellerOrder from './SellerOrder.vue'
import { ref, reactive, toRefs } from 'vue'
import { Collapse } from 'vue-collapsed'
// import styles from '../assets/seller.css'

//23asd456q8w4f3
const props = defineProps({
  price: String,
  date: String,
  timeStart: String,
  timeEnd: String,
  productClass: String,
  orderNum: String,
  week: String,
  serviceName: String,
  detail: String
})

const orderInf = [
  {
    date: props.date,
    timeStart: props.timeStart,
    timeEnd: props.timeEnd,
    productClass: props.productClass,
    orderNum: props.orderNum,
    week: props.week,
    price: props.price,
    detail: props.detail,
    serviceName: props.serviceName
  }
]
const isOpen = ref(false) // Initial value

function handleCollapse() {
  isOpen.value = !isOpen.value
}
</script>

<style lang="scss" scoped>
table .collapse {
  transition: height var(--vc-auto-duration) cubic-bezier(0.3, 0, 0.3, 1);
}
table {
  font-size: 1.3rem;
  height: 100%;
  width: 100%;
}

.board {
  border-radius: 10px;
  padding: 1%;
}

.date {
  background-color: #fff3bf;
  /* height: 80%; */
  min-width: 60px;
  width: 10%;
  text-align: center;
  border-radius: 10px;
  margin: 0.5%;
  /* 想移除element.style預設的padding左右10px */
}
.date p {
  font-size: smaller;
  text-align: center;
  margin-top: 5%;
}
.date span {
  font-size: large;
  text-align: center;
  position: relative;
  top: 5%;
}

.orderTime {
  text-align: center;
  /* margin: 0px 1px; */
  margin: auto;
  width: 7%;
}

.orderContent {
  border-left: 1px solid #d9d9d9;
  border-radius: 0%;
  padding-left: 15px;
  width: 20%;
}

.el-row:last-child {
  margin-bottom: 5px;
}
</style>
<!--

<template>
  <div v-for="sellerOrder in sellerOrders">
    <el-row :gutter="20" class="board orderTitle" style="margin: 0px 0px 5px 0px">
      <table style="border-collapse: collapse">
        <tr>
          <td rowspan="2" class="date" style="width: 60px; font-size: 1.5rem">
            <p>週四</p>
            <span>10/19</span>
          </td>
          <td rowspan="2" class="orderTime">
            <div>10:00</div>
            <div justify="center">❙</div>
            <div>11:00</div>
          </td>
          <td class="orderContent"><span class="tag-cloud beauty">美容</span><br /></td>
          <td style="text-align: right">
            <span class="orderNum" style="font-size: 18px">訂單編號:{{sellerOrder.orderNum }}</span>
          </td>
        </tr>
        <tr>
          <td class="orderContent">
            <span>{貓}-{短毛}</span><br />
             <span>{洗澡+基礎美容}</span> 
          </td>
          <td style="vertical-align: bottom; text-align: right">
            <button @click="handleCollapse" class="tag-cloud button" id="showDetail">
              訂單詳情
            </button>
          </td>
        </tr>
      </table>
    </el-row>
    <Collapse :when="isOpen" class="collapse">
      <SellerOrder class="sellerOrder" 
        v-bind:userEmail="sellerOrder.userEmail"
        :userName="sellerOrder.userName"/>
    </Collapse>
  </div>
</template>
-->

<!-- 
<script>
import SellerOrder from './SellerOrder.vue'
import { ref} from 'vue'
import { Collapse } from 'vue-collapsed'
import SellerOrderService from '../services/SellerOrderService';

const orderInf = [
  {
    date: '2023-10-19',
    timeStart: '10:00',
    timeEnd: '11:00',
    productClass: '美容',
    orderNum: '23asd456q8w4f3'
  }
]
const isOpen = ref(false) // Initial value

export default {
  name: 'SellerOrderTitle',
  components: {
    SellerOrder,
    Collapse
  },
  data() {
    return {
      sellerOrders: [],
      isOpen : false
    }
  },
  methods: {
    handleCollapse() {
      // console.log('click order detail' + this.isOpen)
      this.isOpen = !this.isOpen
    },
    getSellerOrder(){
      console.log('try to get sellerOrder')
      SellerOrderService.getSellerOrder().then((response) => {
          let resData = {}
          if (response.status == 200){
              resData = response.data
              console.log("resData",response.data)
              this.sellerOrders.push(resData)
              this.sellerOrders_test = this.sellerOrders;
              console.log('sellerId: '+ this.sellerOrders[0].sellerId)
          }
          // console.log('try to get sellerOrder response:'+response["sellerId"])
          console.log('try to get sellerOrder response:'+response.data.sellerId)
      });
    },
  },
  created() {
    this.getSellerOrder();
  },
}
</script> 
-->
