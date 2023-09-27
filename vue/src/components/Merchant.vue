<template>
    <div v-if="view === 1">
        <div class="item_header fixed" style="z-index: 1;">
            <div class="item_detail">服務</div>
            <div>預約時間</div>
            <div>單價</div>
            <div>操作</div>
        </div>
        <div v-for="(item, index) in itemList" :key="item.id">
            <div class="item_header item_body">
                <input style="transform: scale(2);" type="checkbox" v-model="item.checked" />&nbsp&nbsp
                <div class="item_detail">
                    <img v-bind:src="cars.serviceImg" alt="">
                    <div class="name">{{cars.serviceName}}</div>
                </div>
                <div class="block">
                    <el-date-picker v-model="value2" type="date" placeholder="Pick a day" :disabled-date="disabledDate"
                        :shortcuts="shortcuts" :size="size" />
                    <el-time-select v-model="startTime" :max-time="endTime" placeholder="Start time"
                        start="08:00" step="01:00" end="17:00" :size="size" />
                    <el-time-select v-model="endTime" :min-time="startTime" placeholder="End time" start="08:00"
                        step="01:00" end="17:00" :size="size" />
                </div>
                <div><span>$</span>{{cars.payment}}</div>
                <div>
                    <el-button @click="handledelete(index)">刪除</el-button>
                </div>
            </div>
        </div>
        <br>
        <div class="item_header checkout">
            <input style="transform: scale(2);" type="checkbox" v-model="selectAll" @change="toggleSelectAll" />
            <div>&nbsp全選</div>
            <div class="checkout">總計<span>$</span>{{ totalAmount }}</div>
            <el-button class="checkout" @click="cview(2)">結帳</el-button>
        </div>
    </div>
    <div v-if="view === 2">
        <div class="item_header fixed">
            <el-button @click="cview(1)">回購物車</el-button>
        </div>
        <Checkout />
        <div class="item_header checkout">
            <div class="checkout">總計<span>$</span>{{ totalAmount }}</div>
            <el-button class="checkout" @click="sendPostRequest">付款</el-button>
        </div>

    </div>
</template>


<script lang="ts" setup>
import Checkout from './Checkout.vue';
import CarService from '../services/CarService';
import { ref, computed ,onMounted} from 'vue'

let cars:any = [];

const getCars = async () => {
  const response = await CarService.getCars();
  cars = response.data;
  console.log(cars)
};

onMounted(() => {
  getCars();
});

//綠界
const sendPostRequest = async () => {
    window.location.href = 'http://localhost:8080/ecpayCheckout';
};
//日期
const value2 = ref('')
const size = ref('large')
const shortcuts = [
    {
        text: 'Today',
        value: new Date(),
    },

]
const disabledDate = (time: Date) => {
    return time.getTime() > Date.now()
}
//時間
const startTime = ref('')
const endTime = ref('')

//畫面
const view = ref(1)
const cview = (ind) => {
    view.value = ind
}
//全選
const selectAll = ref(false);
const toggleSelectAll = () => {
    const allChecked = itemList.value.every(item => item.checked);
    itemList.value.forEach(item => (item.checked = !allChecked));
};
//總計
const totalAmount = computed(() => {
    return itemList.value.reduce((total, item) => {
        // 如果商品被選中，才將其價格加入金额
        if (item.checked) {
            total += parseInt(cars.payment);
        }
        return total;
    }, 0);
});

const itemList = ref([
    {
        id: '1',
        itemName: '洗澡',
        imgUrl: 'https://images.unsplash.com/photo-1534961880437-ce5ae2033053?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=668&q=80',
        // price: '500',
        count: '2023/09/02 12:00',
        checked: false
    },
    {
        id: '2',
        itemName: '美容',
        imgUrl: 'https://images.unsplash.com/photo-1503342217505-b0a15ec3261c?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1500&q=80',
        // price: '790',
        count: '2023/02/02 12:00',
        checked: false
    },

]);

//刪除
const handledelete = (index) => {
    console.log(this);
    itemList.value.splice(index, 1);
};
</script>

<style scoped>
div {
    font-size: 25px;
}

div .el-button {
    font-size: 25px;
}

.block {
    display: flex;
    margin-left: -30px;
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
    width: 24%;
    line-height: 30px;
}

.item_header .item_detail {
    width: 25%;
}

.item_body {
    margin-top: 20px;
    height: 100px;
    align-items: center;
    width: 100%;
}

.item_detail img {
    width: 80px;
    height: 80px;
    border-radius: 3px;
    float: left;
}

.item_detail .name {
    margin-left: 100px;
    margin-top: 25px;
}

.checkout {
    position: fixed;
    bottom: 60px;
    right: 1px;
}
</style>