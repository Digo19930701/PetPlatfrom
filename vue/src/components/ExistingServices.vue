<template>
  <el-container>
    <el-main>
      <el-row>
        <div class="radius">
          <el-text class="text">美容</el-text>
        </div>
      </el-row>
      <el-row>
        <el-col v-for="(o, index) in 1" :key="o" :span="7" :offset="index > 0 ? 1 : 0">
          <el-text v-model="good_title">
            <!-- <p>{{ good_title }}</p> -->
          </el-text>
          <router-link to="/sellerPreview">
            <el-card :body-style="{ padding: '0px' }">
              <img
                src="https://media.istockphoto.com/id/1331301152/photo/photo-in-motion-running-beautiful-golden-retriever-dog-have-a-walk-outdoors-in-the-park.jpg?s=1024x1024&w=is&k=20&c=JZ6x5NMk_sTZwQAs2iR3MUr6JfEmjqszXIBrv2HAOB8="
                class="image"
              />
              <div style="padding: 14px">
                <h3>洗澡&SPA</h3>
                <span> 09:00:00~19:00:00 </span>
              </div>
            </el-card>
          </router-link>

          <el-row class="btns">
            <el-button round class="deleteBtn"> 刪除 </el-button>
            <el-button round class="editBtn"> <a href="/serviceEdit">編輯</a> </el-button>
          </el-row>
        </el-col>
      </el-row>
      <br />
      <el-row>
        <div class="radius2">
          <el-text class="text">保母/訓練</el-text>
        </div>
      </el-row>
      <el-row style="display: flex;">
        <el-col v-for="service in serviceData" :span="7" >
          <el-text v-model="good_title">
            <p></p>
          </el-text>
          <router-link to="/sellerPreview">
            <el-card :body-style="{ padding: '0px' }" style="margin: 2%;">
              <img class="image" :src="service.serviceImage1" style="max-height: 210px;"/>
              <div style="padding: 14px">
                <h3>{{ service.serviceName }}</h3>
                <span>{{ service.availTime1 }}~{{ service.availTime2 }}</span>
              </div>
            </el-card>
          </router-link>

          <el-row class="btns">
            <el-button round class="deleteBtn"> 刪除 </el-button>
            <el-button round class="editBtn"> <a href="/serviceEdit">編輯</a>  </el-button>
          </el-row>
        </el-col>

        <!-- <el-empty description="暫無項目" /> -->
      </el-row>
      <br />
      <el-row>
        <div class="radius3">
          <el-text class="text">攝影</el-text>
        </div>
      </el-row>
      <el-empty description="暫無項目" />

      <el-row>
        <div class="radius4">
          <el-text class="text">溝通</el-text>
        </div>
      </el-row>
      <el-empty description="暫無項目" />
    </el-main>
  </el-container>
</template>

<script lang="ts" setup>
import { ref, onMounted } from 'vue'
import Service from '../services/Service';
const good_title = '洗澡&SPA'


const serviceData = ref([])
onMounted(async () => {
  try {
    const response = await Service.getHome()

    serviceData.value = response.data
    console.log('response.data', response.data)
    console.log('serviceData', serviceData)
    console.log('serviceData.value', serviceData.value)
    console.log('serviceData.value[0]', serviceData.value[0])
  } catch (error) {
    console.error('获取数据时出错：', error)
  }
})
</script>

<style lang="scss" scoped>
.header {
  background-color: rgb(199, 197, 197);
  width: 100%;
  display: inline-flex;
  .hText {
    position: absolute;
    left: 55%;
  }
}
.el-main {
  background-color: #f8f4da;
  .radius {
    border-radius: 25px;
    background-color: #ffbfd6;
    width: 80px;
    .text {
      font-size: medium;
      padding-left: 25px;
    }
  }
  p {
    font-size: large;
    font-weight: 600;
    color: rgb(96, 98, 102);
  }
  .image {
    width: 100%;
    display: block;
  }
  .radius2 {
    border-radius: 25px;
    background-color: #bff3ff;
    width: 95px;

    .text {
      font-size: medium;
      padding-left: 15%;
    }
  }
  .radius3 {
    border-radius: 25px;
    background-color: #e3bfff;
    width: 80px;

    .text {
      font-size: medium;
      padding-left: 25px;
    }
  }
  .radius4 {
    border-radius: 25px;
    background-color: #bff3b3;
    width: 80px;

    .text {
      font-size: medium;
      padding-left: 25px;
    }
  }
  .btns {
    padding: 10px;
  }
}
</style>
