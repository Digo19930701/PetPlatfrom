<template>
  <header><SellerHeadBar /></header>
  <main style="height: 100%">
    <el-container>
      <el-aside><SellerSideBar /></el-aside>
      <el-container>
        <main style="width: 100%">
          <br />
          <IncomeDisplay />
          <br />
          <IncomeDetail />
          <br />
        </main>
      </el-container>
    </el-container>
  </main>
  <footer><FootBar /></footer>
</template>

<script setup>
import IncomeDisplay from '../components/IncomeDisplay.vue'
import IncomeDetail from '../components/IncomeDetail.vue'
import SellerHeadBar from '../components/SellerHeadBar.vue'
import SellerSideBar from '../components/SellerSideBar.vue'
import FootBar from '../components/FootBar.vue'
</script>

<style src="../assets/seller.css"></style>
<style lang="scss">
.el-scrollbar {
  height: 80%;
}
.el-scrollbar ::v-deep .el-scrollbar__wrap {
  overflow-y: scroll;
  overflow-x: hidden;
}
</style>
