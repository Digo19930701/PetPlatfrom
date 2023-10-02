<template>
  <div>
    <el-form class="form" :model="form" size="large">
      <h1>預約資料</h1>
      <h3>。客戶資料</h3>
      <el-form-item label="姓名">
        <!-- <el-input v-model="form.name" /> -->
        <div>{{cars.userName}}</div>
      </el-form-item>
      <el-form-item label="電話">
        <!-- <el-input v-model="form.phone" /> -->
        <div>{{cars.phoneNumber}}</div>
      </el-form-item>
      <h3>。寵物資料</h3>
      <div class="pet-cards">
        <el-card class="pet-card" v-for="(pet, index) in pets" :key="index">
          <div slot="header">寵物 {{ index + 1 }}</div>
          <el-form-item label="品種">
            <el-input v-model="pet.variety" />
          </el-form-item>
          <el-form-item label="個性">
            <el-input v-model="pet.personality" />
          </el-form-item>
          <el-form-item label="年紀">
            <el-input v-model="pet.age" />
          </el-form-item>
          <el-form-item label="備註">
            <el-input v-model="pet.remark" />
          </el-form-item>
        </el-card>
      </div>
    </el-form>
  </div>
</template>

<script lang="ts" setup>
import { ref, reactive, onMounted} from 'vue'
import CarService from '../services/CarService';
let cars:any = [];

const getCars = async () => {
  const response = await CarService.getCars();
  cars = response.data;
  console.log(cars)
};

onMounted(() => {
  getCars();
});

const form = reactive({
  name: 'L',
  phone: '0800123456',
})
const pets = [
  { variety: '英短', personality: '火爆', age: '30', remark: '貪吃鬼' },
  { variety: '柯基', personality: '友善', age: '5', remark: '愛散步' },
  { variety: '柯基', personality: '友善', age: '5', remark: '愛散步' },
  { variety: '柯基', personality: '友善', age: '5', remark: '愛散步' },
  { variety: '柯基', personality: '友善', age: '5', remark: '愛散步' },
  { variety: '柯基', personality: '友善', age: '5', remark: '愛散步' },
  { variety: '柯基', personality: '友善', age: '5', remark: '愛散步' },
  { variety: '柯基', personality: '友善', age: '5', remark: '愛散步' },
]
</script>

<style scoped>
div {
  font-size: 30px;
}

.form {
  font-size: 30px;
  margin: 10px auto;
  width: 90%;
}

.pet-cards {
  display: flex;
  flex-wrap: wrap;
  /* 如果有多個寵物，卡片將自動換行 */
  gap: 20px;
  /* 卡片之間的間距 */
}

.pet-card {
  flex: 1;
  /* 卡片平均分配寬度 */
  max-width: 400px;
  /* 單個卡片的最大寬度 */
  min-width: 400px;
}</style>
