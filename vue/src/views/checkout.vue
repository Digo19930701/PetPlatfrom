<template>
    <div>
        <el-form class="form" :model="form" size="large">
            <h1>預約資料</h1>
            <h3>。客戶資料</h3>
            <el-form-item label="姓名">
                <el-input v-model="form.name" />
            </el-form-item>
            <el-form-item label="電話">
                <el-input v-model="form.phone" />
            </el-form-item>
            <h3>。寵物資料</h3>
            <el-form-item label="品種">
                <el-input v-model="form.variety" />
            </el-form-item>
            <el-form-item label="個性">
                <el-input v-model="form.personality" />
            </el-form-item>
            <el-form-item label="年紀">
                <el-input v-model="form.age" />
            </el-form-item>
            <el-form-item label="備註">
                <el-input v-model="form.remark" />
            </el-form-item><br>
            <!-- <el-form-item label="支付工具">
            <el-radio-group v-model="radio1" size="large">
                <el-radio-button label="到場現金" />
                <el-radio-button label="信用卡/金融卡" />
                <el-radio-button label="銀行轉帳" />
            </el-radio-group>
        </el-form-item> -->
            <el-form-item label="優惠代碼">
                <el-input v-model="form.coupon" />
            </el-form-item>
        </el-form>
    </div>
</template>

<script lang="ts" setup>
import { ref, reactive } from 'vue'
// const radio1 = ref('New York')
const form = reactive({
    name: 'L',
    phone: '0800123456',
    variety: '英短',
    personality: '火爆',
    age: '30',
    remark: '貪吃鬼',
    coupon: '我是鏟史官-$50',
})
</script>

<style scoped>
div {
    font-size: 30px;
}

.form {
    font-size: 30px;
    margin: 10px auto;
    width: 90%;
}
</style>
