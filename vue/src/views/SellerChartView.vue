<template>
  <header><SellerHeadBar /></header>

  <main>
    <el-container>
      <el-aside><SellerSideBar /></el-aside>
      <main style="width: 75%">
        <br />
        <header class="title">
          <h2 style="color: #888888; font-weight: bolder">數據管理</h2>
        </header>

        <div class="board">
          <div class="subtitle tag-cloud">營業額</div>
          <SellerChartMultiX
            :name="['01-06', '07-12']"
            :xData="[
              [
                '01',
                '02',
                '03',
                '04',
                '05',
                '06'
              ],
              [
                '07',
                '08',
                '09',
                '10',
                '11',
                '12'
              ]
            ]"
            :yData="[
              [199000, 240000, 283000, 282530, 325400, 305682],
              [325000, 250800, 272000, 182530, 0, 0]
            ]"
          />
        </div>
        <br />
        <div class="board">
          <div class="subtitle tag-cloud">訂單數</div>
          <SellerChartTurnover
            :name="['顧客1', '顧客2']"
            :xData="['星期一', '星期二', '星期三', '星期四', '星期五', '星期六', '星期日']"
            :yData="[
              [120, 132, 101, 104, 90, 230, 210],
              [120, 132, 101, 134, 90, 230, 210]
            ]"
          />
        </div>
        <br />
        <div class="board">
          <div class="subtitle tag-cloud">瀏覽數</div>
          <SellerChartMultiX
            :name="['2016', '2015']"
            :xData="[
              [
                '2016-1',
                '2016-2',
                '2016-3',
                '2016-4',
                '2016-5',
                '2016-6',
                '2016-7',
                '2016-8',
                '2016-9',
                '2016-10',
                '2016-11',
                '2016-12'
              ],
              [
                '2015-1',
                '2015-2',
                '2015-3',
                '2015-4',
                '2015-5',
                '2015-6',
                '2015-7',
                '2015-8',
                '2015-9',
                '2015-10',
                '2015-11',
                '2015-12'
              ]
            ]"
            :yData="[
              [26, 59, 29, 264, 287, 707, 171, 82, 487, 188, 6, 23],
              [39, 59, 71, 187, 383, 692, 236, 104, 554, 184, 13, 7]
            ]"
            :yAxis="['數量(次)']"
          />
        </div>
        <br /><br />
      </main>
    </el-container>
  </main>
  <footer><FootBar /></footer>
</template>

<script lang="ts" setup>
import SellerChartTurnover from '../components/SellerChartTurnover.vue'
import SellerChartMultiX from '../components/SellerChartMultiX.vue'
import SellerHeadBar from '../components/SellerHeadBar.vue'
import SellerSideBar from '../components/SellerSideBar.vue'
import FootBar from '../components/FootBar.vue'
</script>

<style src="../assets/seller.css"></style>
