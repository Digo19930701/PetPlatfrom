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
          v-bind:domain="domainInput"
          v-bind:avail-time1="availTime1Input"
          v-bind:avail-time2="availTime2Input"
          v-bind:service-period="servicePeriod"
          v-bind:avail-day="availDayInput"
         />
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

const ImgInput = ref([]);
const domainInput = ref("");
const availTime1Input = ref("");
const availTime2Input = ref("");
const servicePeriod = ref(0);
const availDayInput = ref([]);

const petServices = ref([]);
const getServiceById = async () => {
  // console.log('try to get petServices');
  try {
    const response = await Serviece.getServiceById();
    if (response.status === 200) {
      petServices.value.push(response.data);
      // console.log('response.data.serviceName: ' + response.data.serviceName);
      // console.log('petServices.value[0].servicePeriod: ' + petServices.value[0].servicePeriod);

      // if(petServices.value[0].serviceImage2 != null){
      //   ImgInput.value.push(`{key: 1, url:'${petServices.value[0].serviceImage2}'}`)
      // }else if(petServices.value[0].serviceImage3 != null){
      //   ImgInput.value.push(`{key: 1, url:'${petServices.value[0].serviceImage3}'}`)
      // }else if(petServices.value[0].serviceImage4 != null){
      //   ImgInput.value.push(`{key: 1, url:'${petServices.value[0].serviceImage4}'}`)
      // }else if(petServices.value[0].serviceImage5 != null){
      //   ImgInput.value.push(`{key: 1, url:'${petServices.value[0].serviceImage5}'}`)
      // }
      // console.log("ImgInput.value", ImgInput.value)

      var petServicesDomain = "[";
      for(var i = 0; i< petServices.value[0].hst.length; i++){
        petServicesDomain += `{key: ${i+1}, spec: '${petServices.value[0].hst[i].spec}', petType: '${petServices.value[0].hst[i].petType}', price: ${petServices.value[0].hst[i].price}},`
      }
      petServicesDomain +="]"
      domainInput.value = petServicesDomain;
      // console.log("domainInput", domainInput)

      availTime1Input.value = 'Thu Oct 05 2023 '+ petServices.value[0].availTime1 +' GMT+0800 (台北標準時間)';
      availTime2Input.value = 'Thu Oct 05 2023 '+ petServices.value[0].availTime2 +' GMT+0800 (台北標準時間)';
      
      if(petServices.value[0].servicePeriod == "00:30:00"){
        servicePeriod.value = 30; 
      }else if(petServices.value[0].servicePeriod == "01:00:00"){
        servicePeriod.value = 60;
      }else if(petServices.value[0].servicePeriod == "01:30:00"){
        servicePeriod.value = 90;
      }else if(petServices.value[0].servicePeriod == "02:00:00"){
        servicePeriod.value = 120;
      }else if(petServices.value[0].servicePeriod == "02:30:00"){
        servicePeriod.value = 150;
      }else if(petServices.value[0].servicePeriod == "03:00:00"){
        servicePeriod.value = 180;
      }else{
        servicePeriod.value = 60;
      }
      // console.log("servicePeriod.value", servicePeriod.value);

      if(petServices.value[0].monday == true){ availDayInput.value.push('星期一')}
      if(petServices.value[0].tuesday == true){ availDayInput.value.push('星期二')}
      if(petServices.value[0].wednesday == true){ availDayInput.value.push('星期三')}
      if(petServices.value[0].thursday == true){ availDayInput.value.push('星期四')}
      if(petServices.value[0].friday == true){ availDayInput.value.push('星期五')}
      if(petServices.value[0].saturday == true){ availDayInput.value.push('星期六')}
      if(petServices.value[0].sunday == true) {availDayInput.value.push('星期日')}
      // console.log("availDayInput",availDayInput);
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
