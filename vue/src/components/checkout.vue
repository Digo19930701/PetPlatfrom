<template>
        <el-form class="form">
            <el-form-item label="姓名">
                <el-input />
            </el-form-item>
            <el-form-item label="電話">
                <el-input />
            </el-form-item>
            <el-form-item label="品種">
                <el-input />
            </el-form-item>
            <el-form-item label="個性">
                <el-input />
            </el-form-item>
            <el-form-item label="年紀">
                <el-input />
            </el-form-item>
            <el-form-item label="備註">
                <el-input />
            </el-form-item>
            <el-form-item label="支付工具">
                <el-radio-group v-model="radio1" size="large">
                    <el-radio-button label="到場現金" />
                    <el-radio-button label="信用卡/金融卡" />
                    <el-radio-button label="銀行轉帳" />
                    <el-radio-button label="Apple Pay" />
                </el-radio-group>
            </el-form-item>
            優惠
            <div>總計</div>
            <el-button>去支付</el-button>
        </el-form>
</template>

<script lang="ts" setup>
import { ref } from 'vue'
const radio1 = ref('New York')
</script>

<style scoped>
 .form{
    margin-left: 20px;
    width: 500px;
 }
</style>
