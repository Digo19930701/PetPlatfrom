<template>
  <div v-for="order in orderList[0]">
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
            <span class="orderNum" style="font-size: 18px">訂單編號: {{ order.orderId }}</span>
          </td>
        </tr>
        <tr>
          <td class="orderContent">
            <span>{{ detail }}</span
            ><br />
          </td>
          <td>
            <span>單價 NT$ {{ order.price }} </span>
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
        :user-name="order.userName"
        :user-email="'4A2Beeit69@gmail.com'"
        :phone-number="'0946523571'"
        :pet-class="'狗'"
        :pet-variety="'柴犬'"
        :pet-character="'熱情'"
        :pet-age="'3'"
        :timeline1="'2023-10-12'"
        :order-msg="'討厭剪指甲'"
      />
    </Collapse>
  </div>
</template>

<script setup>
import SellerOrder from './SellerOrder.vue'
import { ref, reactive, toRefs, onMounted } from 'vue'
import { Collapse } from 'vue-collapsed'
import Serviece from '../services/Service.js'

const props = defineProps({
  price: {
    type:String,
    default:'589'
  },
  date: {
    type:String,
    default:'10/19'
  },
  timeStart: {
    type:String,
    default:'10:00'
  },
  timeEnd: {
    type:String,
    default:'11:00'
  },
  productClass: {
    type:String,
    default:'美容'
  },
  orderNum: {
    type:String,
    default:'sldkghwoeihg'
  },
  week: {
    type:String,
    default:'週四'
  },
  serviceName: {
    type:String,
    default:'寵物洗澡與基礎美容'
  },
  detail: {
    type:String,
    default:'狗 大型犬'
  }
})

// const orderInf = [
//   {
//     date: props.date,
//     timeStart: props.timeStart,
//     timeEnd: props.timeEnd,
//     productClass: props.productClass,
//     orderNum: props.orderNum,
//     week: props.week,
//     price: props.price,
//     detail: props.detail,
//     serviceName: props.serviceName
//   }
// ]
const isOpen = ref(false) // Initial value

function handleCollapse() {
  isOpen.value = !isOpen.value
}

const orderList = ref([]);
const getSellerOrder = async () => {
  // console.log('try to get orderList');
  try {
    const response = await Serviece.getSellerOrder();
    if (response.status === 200) {
      orderList.value.push(response.data);
      console.log('response.data', response.data);
      console.log('orderList.value[0]', orderList.value[0]);
      console.log('orderList.value[0].orderId', orderList.value[0][0].orderId);


      // availTime1Input.value = 'Thu Oct 05 2023 '+ orderList.value[0].availTime1 +' GMT+0800 (台北標準時間)';
      // availTime2Input.value = 'Thu Oct 05 2023 '+ orderList.value[0].availTime2 +' GMT+0800 (台北標準時間)';
      
      // if(orderList.value[0].servicePeriod == "00:30:00"){
      //   servicePeriod.value = 30; 
      // }else if(orderList.value[0].servicePeriod == "01:00:00"){
      //   servicePeriod.value = 60;
      // }else if(orderList.value[0].servicePeriod == "01:30:00"){
      //   servicePeriod.value = 90;
      // }else if(orderList.value[0].servicePeriod == "02:00:00"){
      //   servicePeriod.value = 120;
      // }else if(orderList.value[0].servicePeriod == "02:30:00"){
      //   servicePeriod.value = 150;
      // }else if(orderList.value[0].servicePeriod == "03:00:00"){
      //   servicePeriod.value = 180;
      // }else{
      //   servicePeriod.value = 60;
      // }
      // console.log("servicePeriod.value", servicePeriod.value);

      // if(orderList.value[0].monday == true){ availDayInput.value.push('星期一')}
      // if(orderList.value[0].tuesday == true){ availDayInput.value.push('星期二')}
      // if(orderList.value[0].wednesday == true){ availDayInput.value.push('星期三')}
      // if(orderList.value[0].thursday == true){ availDayInput.value.push('星期四')}
      // if(orderList.value[0].friday == true){ availDayInput.value.push('星期五')}
      // if(orderList.value[0].saturday == true){ availDayInput.value.push('星期六')}
      // if(orderList.value[0].sunday == true) {availDayInput.value.push('星期日')}
      // console.log("availDayInput",availDayInput);
    }
  } catch (error) {
    console.error('Error getting orderList:', error);
  }
};

onMounted(() => {
  getSellerOrder();
});
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