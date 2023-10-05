<template>
  <header><SellerHeadBar /></header>
  <main>
    <el-container>
      <el-aside><SellerSideBar /></el-aside>
      <main>
        <header class="title">
          <h2 style="color: #888888; font-weight: bolder">新增/編輯服務</h2>
        </header>
        <ServiceEdit v-for="service in petServices"
          :service-name="service.serviceName"
          :category="service.category"
          :service-desc="service.serviceDesc"
          :upper-limit="service.upperLimit"
          :accept-day1="service.acceptDay1"
          :accept-day2="service.acceptDay2"
          :service-cover="[{key:1,
               url:service.serviceImage1
              }]"
          :service-image="[{key:1,
               url:'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSz8i72PjaXsPYw9qIxwrxxcX8pz4FGLL4eS4SPoyPyOGoQJ-Fd5mclg5hKPNdX8udmbdk&usqp=CAU'
              }]"
            
         />
         <!-- servicePeriod等時間類的、availDay因為型態差異還沒辦法寫進去 -->
         <!-- 子規格還沒塞進去(用array的方式應該可以成功) -->
      </main>
    </el-container>
  </main>
  <footer><FootBar /></footer>
</template>

<script setup>
import ServiceEdit from '../components/ServiceEdit.vue'
import SellerHeadBar from '../components/SellerHeadBar.vue'
import SellerSideBar from '../components/SellerSideBar.vue'
import FootBar from '../components/FootBar.vue'
import { onMounted, ref } from 'vue'
import Serviece from '../services/Service.js'

const petServices = ref([]);

const getServiceById = async () => {
  console.log('try to get petServices');
  try {
    const response = await Serviece.getServiceById();
    if (response.status === 200) {
      petServices.value.push(response.data);
      console.log('servicePeriod: ' + petServices.value[0].servicePeriod);
      console.log('availTime1: ' + petServices.value[0].availTime1);
      console.log('availTime2: ' + petServices.value[0].availTime2);
    }
  } catch (error) {
    console.error('Error getting petServices:', error);
  }
};

onMounted(() => {
    getServiceById();
});
</script>

<style src="../assets/seller.css"></style>
