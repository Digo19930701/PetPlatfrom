<script setup>
import IncomeDisplay from '../components/IncomeDisplay.vue';
import IncomeDetail from '../components/IncomeDetail.vue';
</script>
<style src="../assets/seller.css"></style>
<template>
  <main>
    <el-scrollbar>
      <IncomeDisplay />
      <br>
      <IncomeDetail/>
    </el-scrollbar>
  </main>
</template>
<style lang="scss">
.el-scrollbar {
  height: 60%;
}
.el-scrollbar ::v-deep .el-scrollbar__wrap {
  overflow-y: scroll;
  overflow-x: hidden;
}
</style>