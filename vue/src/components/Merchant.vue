<template>
    <div class="container">
        <div class="item_header">
            <div class="item_detail">商品</div>
            <div class="price">單價</div>
            <div class="count">數量</div>
            <div class="amount">總計</div>
            <div class="operate">操作</div>
        </div>
        <div class="item_container" v-for="(item, index) in itemList" :key="item.id">
            <div class="item_header item_body">
                <div class="item_detail">
                    <img v-bind:src="item.imgUrl" alt="">
                    <div class="name">{{ item.itemName }}</div>
                </div>

                <div class="price"><span>$</span>{{ item.price }}</div>
                <div class="count">
                    <button @click="handleSub(item)">-</button>
                    {{ item.count }}
                    <button @click="handlePlus(item)">+</button>
                </div>
                <div class="amount">{{ item.price * item.count }}</div>
                <div class="operate">
                    <button @click="handledelete(index)">刪除</button>
                </div>
            </div>
        </div>


    </div>
</template>

<script  setup>

// import {ref} from 'vue'

// const handleSub = ref(item)
// const handledelete = ref(index)

</script>

<style scoped>
.item_header {
    display: flex;
    width: 1000px;
    margin: 0 auto;
    height: 30px;
    background-color: #fff;
    border-radius: 3px;
    padding-left: 10px;
}

.item_header div {
    width: 200px;
    color: #888;
    line-height: 30px;
}

.item_header .item_detail {
    width: 50%;
}

.item_body {
    margin-top: 20px;
    height: 100px;
    align-items: center;
}

.item_detail img {
    width: 80px;
    height: 80px;
    border-radius: 3px;
    /* margin-top: 10px; */
    float: left;
}

.item_detail .name {
    margin-left: 100px;
    margin-top: 20px;
}
</style>
