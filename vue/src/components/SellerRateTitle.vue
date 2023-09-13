<script lang="ts" setup>
import {
  CaretBottom,
  CaretTop,
//   Warning,
} from '@element-plus/icons-vue'

const props=defineProps({
    rateItem:{
        type:Array,
        // default:['平均評價', '總評價數', '未回覆評價']
        default:['','',''],
    },
    rate:{
        type:Array,
        default:[4.5, 120, 15]
    },
    note:{
        type:Array,
        // default:['與前月相差','本月增加 ','筆'], 
        default:['','',''], 
    },
    rateSub:{
        type:Array,
        // default:[1.5, 20, 30]
        default:[,,]
    },
    colors:{
        type:Array,
        default:['white', '#666666']
    }
})
</script>
<template>
    <el-row class="statistic">
        <el-col :span="8">
            <div class="statistic-card">
                <el-statistic :formatter="(value: number) => props.rate[0]" >
                    <template #title>
                        <div style="display: inline-flex; align-items: center">
                            {{props.rateItem[0]}}
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
                            {{props.rateItem[1]}}
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
                            {{props.rateItem[2]}}
                        </div>
                    </template>
                </el-statistic>
            </div>
        </el-col>
    </el-row>
</template>

<style lang="scss">
// .statistic{
//     min-width: 420px;
// }
.el-statistic {
  /* --el-statistic-content-font-size: 1rem; */
  --el-statistic-content-color: #888888;
  --el-statistic-content-color: #CD7B00;
}

.statistic-card {
  height: 100%;
  min-width: 120px;
  padding: 5px 10px;
  border-radius: 10px;
  margin: 0 1rem 0 0 ;
  background-color: white;
  box-shadow: 1px 1px 5px lightgray;
}
.el-statistic__head {
    font-size: var(--el-statistic-title-font-size);
    // font-size: 1rem;
}
.statistic-footer {
  display: flex;
  font-size: 0.5rem;
  margin-top: 10px;
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