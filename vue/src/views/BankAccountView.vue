<template>
  <header><SellerHeadBar /></header>
  <main>
    <el-container>
      <main>
        <el-container>
          <el-aside><SellerSideBar /></el-aside>
          <main style="width: 100%">
            <br />
            <BankAccount />
          </main>
        </el-container>
      </main>
    </el-container>
  </main>
  <footer><FootBar /></footer>
</template>

<script setup>
import BankAccount from '../components/BankAccount.vue'
import SellerHeadBar from '../components/SellerHeadBar.vue'
import SellerSideBar from '../components/SellerSideBar.vue'
import FootBar from '../components/FootBar.vue'
</script>
<style src="../assets/seller.css"></style>
<style src="../assets/creditCard.css"></style>
