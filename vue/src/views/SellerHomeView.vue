<template>
  <!-- 排版的部分就交給宛仟了! (我覺得怎麼調都不滿意可以索性第一列直接只留月曆) -->
  <header><SellerHeadBar /></header>
  <main>
    <el-container>
      <el-aside><SellerSideBar /></el-aside>
      <main style="width: 75%">
        <br />
        <el-row style="justify-content: center">
          <SellerRateTitle
            :rateItem="['本月待辦訂單', '本月取消訂單', '本月過去訂單']"
            :rate="[2, 0, 3]"
            :note="['今日待辦數', '', '']"
            :rateSub="[0, ,]"
          />

          <!-- <SellerRateTitle
            :rateItem="['平均評價', '總評價數', '本月未回覆評價']"
            :rate="[4.2, 11, 2]"
            :note="['與前月相差', '本月增加', '筆']"
            :rateSub="[0.5, 1, 2]"
          /> -->
        </el-row>
        <br />
        <el-row class="calenderBoard board">
          <SellerCalender />
        </el-row>
        <!-- <br />
        <div class="title board">
          <h2 style="color: #888888; font-weight: bolder">近期訂單</h2>
          <div class="comingOrder"><SellerOrderTitle /></div>
        </div> -->
        <br />
        <div class="title board">
          <h2 style="color: #888888; font-weight: bolder">數據中心</h2>
          <!-- </div> -->
          <!-- <div class=""> -->
          <button class="subtitle tag-cloud">營業額</button>
          <!-- <button class="subtitle tag-cloud">訂單數</button> -->
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
              [285000, 250800, 272000, 222530],
              [199000, 240000, 283000, 282530, 325400, 305682],
            ]"
          />
        </div>
        <br /><br />
      </main>
    </el-container>
  </main>
  <footer><FootBar /></footer>
</template>

<script lang="ts" setup>
import SellerCalender from '../components/SellerCalender.vue'
import SellerChartMultiX from '../components/SellerChartMultiX.vue'
import SellerOrderTitle from '../components/SellerOrderTitle.vue'
import SellerRateTitle from '../components/SellerRateTitle.vue'
import SellerHeadBar from '../components/SellerHeadBar.vue'
import SellerSideBar from '../components/SellerSideBar.vue'
import FootBar from '../components/FootBar.vue'
</script>

<style src="../assets/seller.css"></style>
<style scoped>
.title h2 {
  margin-bottom: 10px;
}
.calenderBoard {
  height: 35rem;
}
.board {
  padding: 10px;
  margin-bottom: 10px;
}
.comingOrder {
  margin-bottom: 10px;
}
</style>
