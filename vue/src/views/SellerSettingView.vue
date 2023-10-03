<template>
  <header><SellerHeadBar /></header>
  <main>
    <el-container>
      <el-aside><SellerSideBar /></el-aside>
      <main style="width: 80%">
        <br />
        <header>
          <h2 style="color: #888888; font-weight: bolder">商家基本資料</h2>
        </header>
        <br />
<<<<<<< HEAD
        <SellerSetting
        :seller-id="'ahfdjfl@gmail.com'"
        :seller-name="'狗狗的旅宿'"
        :seller-desc="'寵曖貓狗生活館位於民族路上，鄰近日新影城。店內同時有 4-5 位美容師作業，會讓剛到達的毛孩們先在地上到處走走適應環境，也可以和其他個性穩定的狗狗彼此認識熟悉。雖然這家台中寵物美容沒有開放家長現場陪同與等待，但是作業區為全玻璃開放式的環境，因此所有過程皆是公開透明。'"
        :seller-add="'台中市中區民族路223號'"
        :seller-phone="'0915876824'"
        :unit-time="60" />
=======
        <SellerSetting />
>>>>>>> origin/L
      </main>
    </el-container>
  </main>
  <footer><FootBar /></footer>
</template>

<script setup>
import SellerSetting from '../components/SellerSetting.vue'
import SellerHeadBar from '../components/SellerHeadBar.vue'
import SellerSideBar from '../components/SellerSideBar.vue'
import FootBar from '../components/FootBar.vue'
</script>

<style src="../assets/seller.css"></style>
