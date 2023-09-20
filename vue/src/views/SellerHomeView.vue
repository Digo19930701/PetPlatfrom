<script lang="ts" setup>
import SellerCalender from '../components/SellerCalender.vue'
import SellerChartMultiX from '../components/SellerChartMultiX.vue'
import SellerOrderTitle from '../components/SellerOrderTitle.vue'
import SellerRateTitle from '../components/SellerRateTitle.vue'
</script>
<template>
  <!-- 排版的部分就交給宛仟了! (我覺得怎麼調都不滿意可以索性第一列直接只留月曆) -->
  <el-row>
    <el-col :span="14">
      <el-row style="">
        <SellerRateTitle
          :rateItem="['本月待辦訂單', '本月取消訂單', '本月過去訂單']"
          :rate="[13, 1, 3]"
          :note="['今日待辦數', '', '']"
          :rateSub="[3, ,]"
        />
      </el-row>
      <el-row>
        <SellerRateTitle
          :rateItem="['平均評價', '總評價數', '本月未回覆評價']"
          :rate="[4.2, 11, 2]"
          :note="['與前月相差', '本月增加', '筆']"
          :rateSub="[0.5, 1, 2]"
        />
      </el-row>
    </el-col>
    <el-col :span="10">
      <SellerCalender />
    </el-col>
  </el-row>
  <div class="title board">
    <h2>近期訂單</h2>
    <div class="comingOrder"><SellerOrderTitle /></div>
    <div class="comingOrder"><SellerOrderTitle /></div>
    <div class="comingOrder"><SellerOrderTitle /></div>
  </div>
  <div class="title board">
    <h2>數據中心</h2>
    <!-- </div> -->
    <!-- <div class=""> -->
    <button class="subtitle tag-cloud">營業額</button>
    <!-- <button class="subtitle tag-cloud">訂單數</button> -->
    <SellerChartMultiX
      :name="['2023', '2022']"
      :xData="[
        [
          '2023-1',
          '2023-2',
          '2023-3',
          '2023-4',
          '2023-5',
          '2023-6',
          '2023-7',
          '2023-8',
          '2023-9',
          '2023-10',
          '2023-11',
          '2023-12'
        ],
        [
          '2022-1',
          '2022-2',
          '2022-3',
          '2022-4',
          '2022-5',
          '2022-6',
          '2022-7',
          '2022-8',
          '2022-9',
          '2022-10',
          '2022-11',
          '2022-12'
        ]
      ]"
      :yData="[
        [2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 171.6, 82.2, 48.7, 18.8, 6.0, 2.3],
        [3.9, 5.9, 11.1, 18.7, 48.3, 69.2, 231.6, 104, 55.4, 18.4, 10.3, 0.7]
      ]"
    />
  </div>
</template>

<style src="../assets/seller.css"></style>
<style scoped>
.title h2 {
  margin-bottom: 10px;
}
.board {
  padding: 10px;
  margin-bottom: 10px;
}
.comingOrder {
  margin-bottom: 10px;
}
</style>
