<script setup>
import SellerOrder from './SellerOrder.vue'
import { ref } from 'vue'
import { Collapse } from 'vue-collapsed'
// import styles from '../assets/seller.css'

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

function handleCollapse() {
  isOpen.value = !isOpen.value
}
</script>

<template>
  <div>
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
            <span class="orderNum" style="font-size: 18px">訂單編號:{12asd456q8w4f3}</span>
          </td>
        </tr>
        <tr>
          <td class="orderContent">
            <span>{貓}-{短毛}</span><br />
            <!-- <span>{洗澡+基礎美容}</span> -->
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
      <SellerOrder class="sellerOrder" />
    </Collapse>
  </div>
</template>

<style lang="scss">
table .collapse {
  transition: height var(--vc-auto-duration) cubic-bezier(0.3, 0, 0.3, 1);
}
table {
  font-size: 1.3rem;
}

.board {
  border-radius: 10px;
  padding: 1%;
}

.date {
  background-color: #fff3bf;
  /* height: 80%; */
  min-width: 60px;

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
}

.orderContent {
  border-left: 1px solid #d9d9d9;
  border-radius: 0%;
  padding-left: 15px;
}

.el-row:last-child {
  margin-bottom: 5px;
}
</style>
