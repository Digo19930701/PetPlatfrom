<script lang="ts" setup>
import SellerRateTitle from '../components/SellerRateTitle.vue';
import SellerRate from '../components/SellerRate.vue';
import { ref } from 'vue'

const radio = ref(0)
</script>

<template>
    <header class="title">
        <h2>評價管理</h2>
    </header>

    <SellerRateTitle :rate="[4.2, 11, 2]"
                     :note="['與前月評價相差','本月增加','筆']"
                     :rateSub="[0.5, 1, 2]"/>
    <el-row>
            <el-radio-group v-model="radio">
                <el-radio :label="0">全部</el-radio>
                <el-radio :label="1">美容</el-radio>
                <el-radio :label="2">溝通</el-radio>
                <el-radio :label="3">攝影</el-radio>
                <el-radio :label="4">保母/訓練</el-radio>
            </el-radio-group>
    </el-row>

    <SellerRate />
    <SellerRate />
    <SellerRate />
</template>

<style src="../assets/seller.css"></style>
<style lang="scss">

.el-radio-group{
    padding: 0px 10px;
}

.el-radio__input.is-checked+.el-radio__label{
    color: #CD7B00;
}
.el-radio__input.is-checked .el-radio__inner {
    border-color: #CD8B00;
    background: #CD7B00;
}


</style>
