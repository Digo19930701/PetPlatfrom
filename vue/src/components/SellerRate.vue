<script lang="ts" setup>
import { ref } from 'vue'

const value = ref(3.7)  //帶入飼主評價
</script>

<template>
    <el-row :gutter="20" class="board">
        <el-col :span="5" class="rate">
            <el-rate  
                v-model="value"
                disabled
                show-score
                text-color="#ff9900"
                size="small"
            />
            <p >{評論者名稱}{account}</p>
        </el-col>
        <el-col :span="19" class="orderContent">
            <el-row :gutter="20">
                <el-col :span="11" class="orderHead">
                    <span class="tag-cloud beauty">美容</span><br/>
                    <span>{xxxxxxxxxxxxxxxxxx評價內容}</span>
                </el-col>
                <el-col :span="12" class="orderEnd">
                    <div>
                        <span class="orderNum">訂單編號:{12asd456q8w4f3}</span>
                    </div>
                    <div>
                        <button class="tag-cloud button" id="showDetail">已回覆</button><br/>
                    </div>
                </el-col>
            </el-row>
        </el-col>
    </el-row>
</template>

<style>
    .rate{
        margin: auto
    }
</style>
