<script lang="ts" setup>
import {
  CaretBottom,
  CaretTop,
//   Warning,
} from '@element-plus/icons-vue'

const props=defineProps({
    rate:{
        type:Array,
        default:[4.5, 120, 15]
    },
    note:{
        type:Array,
        // default:['與前月評價相差','本月增加 ','筆'], 
        default:['','',''], 
    },
    rateSub:{
        type:Array,
        // default:[1.5, 20, 30]
        default:[,,]
    }
})
</script>
<template>
    <el-row display="" class="statistic">
        <el-col :span="8">
            <div class="statistic-card">
                <el-statistic :formatter="(value: number) => props.rate[0]" >
                    <template #title>
                        <div style="display: inline-flex; align-items: center">
                            平均評價
                        </div>
                    </template>
                </el-statistic>
                <div class="statistic-footer">
                    <div class="footer-item">
                        <span>{{ props.note[0] }}</span>
                        <span class="green">
                            {{props.rateSub[0]}}
                            <!-- <el-icon><CaretTop /></el-icon> -->
                        </span>
                        <!-- <span class="red">
                            {{props.ratePast[0]}}%
                            <el-icon><CaretBottom /></el-icon>
                        </span> -->
                    </div>
                </div>
            </div>
        </el-col>
        <el-col :span="8">
            <div class="statistic-card">
                <el-statistic :value="props.rate[1]">
                    <template #title>
                        <div style="display: inline-flex; align-items: center">
                            總評價數
                        </div>
                    </template>
                </el-statistic>
                <div class="statistic-footer">
                    <div class="footer-item">
                        <!-- <span>本月增加&nbsp;</span> -->
                        <span>{{props.note[1] }}</span>
                        <span class="brown">
                            {{props.rateSub[1]}}
                        </span>
                        <span>{{ props.note[2] }}</span>
                    </div>
                </div>
            </div>
        </el-col>
        <el-col :span="8">
            <div class="statistic-card">
                <el-statistic :value="props.rate[2]">
                    <template #title>
                        <div style="display: inline-flex; align-items: center">
                            未回覆評價
                        </div>
                    </template>
                </el-statistic>
            </div>
        </el-col>
    </el-row>
</template>

<style >
/* .statistic{
    min-width: 410px;
} */
.el-statistic {
  --el-statistic-content-font-size: 24px;
  --el-statistic-content-color: #888888;
  --el-statistic-content-color: #CD7B00;
}

.statistic-card {
  height: 100%;
  padding: 0px 10px;
  border-radius: 4px;
}

.statistic-footer {
  display: flex;
  justify-content: space-between;
  align-items: center;
  flex-wrap: wrap;
  font-size: 12px;
  color: var(--el-text-color-regular);
  margin-top: 16px;
}

.statistic-footer .footer-item {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.statistic-footer .footer-item span:last-child {
  display: inline-flex;
  align-items: center;
  margin-left: 4px;
}

.green {
    color: var(--el-color-success);
}
.red {
    color: var(--el-color-error);
}

.brown{
    color: #CD7B00;
}
</style>