<script lang="ts" setup>
import { ref, onMounted } from 'vue'
import SellerChartTurnover from './SellerChartTurnover.vue';
import SellerChartMultiX from './SellerChartMultiX.vue';

</script>

<template>
    <header class="title">
        <h2>數據管理</h2>
    </header>
    <main>
        <div class="chartBoard">
            <div class="chartName tag-cloud">營業額</div>
            <SellerChartMultiX 
                :name="['2016', '2015']"
                :xData="[['2016-1', '2016-2', '2016-3', '2016-4', '2016-5', '2016-6', '2016-7', '2016-8', '2016-9', '2016-10', '2016-11', '2016-12'],
                         ['2015-1', '2015-2', '2015-3', '2015-4', '2015-5', '2015-6', '2015-7', '2015-8', '2015-9', '2015-10', '2015-11', '2015-12']
                        ]"
                :yData="[[2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 171.6, 82.2, 48.7, 18.8, 6.0, 2.3],
                         [3.9, 5.9, 11.1, 18.7, 48.3, 69.2, 231.6, 104, 55.4, 18.4, 10.3, 0.7]
                        ]"  
            />
        </div>
        <br/>
        <div class="chartBoard">
            <div class="chartName tag-cloud">訂單數</div>
            <SellerChartTurnover 
            :name="['顧客1','顧客2']"
            :xData="['星期一', '星期二', '星期三', '星期四', '星期五', '星期六', '星期日']"
            :yData="[[120, 132, 101, 104, 90, 230, 210], [120, 132, 101, 134, 90, 230, 210]]"            
            />
        </div>
        <br/>
        <div class="chartBoard">
            <div class="chartName tag-cloud">瀏覽數</div>
            <SellerChartMultiX 
                :name="['2016', '2015']"
                :xData="[['2016-1', '2016-2', '2016-3', '2016-4', '2016-5', '2016-6', '2016-7', '2016-8', '2016-9', '2016-10', '2016-11', '2016-12'],
                         ['2015-1', '2015-2', '2015-3', '2015-4', '2015-5', '2015-6', '2015-7', '2015-8', '2015-9', '2015-10', '2015-11', '2015-12']
                        ]"
                :yData="[[26, 59, 29, 264, 287, 707, 171, 82, 487, 188, 6, 23],
                         [39, 59, 71, 187, 383, 692, 236, 104, 554, 184, 13, 7]
                        ]"  
                :yAxis="['數量(次)']"
            />
        </div>
    </main>

</template>



<style>
.chartName{
    border: 3px solid #F8D479;
    margin: 2%;
}
.chartBoard{
    background-color: white;
}
</style>