<template>
  <el-container>
    <OrderSideBar />
    <el-main>
      <el-carousel :interval="5000" arrow="always" style="width: 1700px">
        <router-link to="/good">
          <el-carousel-item v-for="item in 4" :key="item">
            <el-image class="adImg" :src="adUrl[item - 1]" fit="cover"> </el-image>
          </el-carousel-item>

          <!-- <h3 text="2xl" justify="center"></h3> -->
          <!-- </el-carousel-item> -->
        </router-link>
      </el-carousel>
      <br />
      <h2>推薦商家&服務</h2>
      <!-- {{ serviceData[0].serviceName }} -->
      <br />
      <el-row style="width: 100%; min-width: 1024px">
        <el-col v-for="(seller, index) in 3" :key="seller" :span="7" :offset="index > 0 ? 1 : 0">
          <el-card :body-style="{ padding: '0px' }">
            <!-- <el-image class="sellerImg" :src="sellers[seller - 1].sellerImg" fit="cover"> -->
            <el-image class="sellerImg" :src="serviceData[seller - 1].serviceImage1" fit="cover">
            </el-image>
            <!-- <img
              src="https://media.istockphoto.com/id/1349349263/photo/cute-fluffy-friends-a-cat-and-a-dog-catch-a-flying-butterfly-in-a-sunny-summer.jpg?s=1024x1024&w=is&k=20&c=I3tWgnvB2pI4e7Y7TPESjfwsrhWccci8-AzbJvq0kA4="
              class="image"
            /> -->
            <div style="padding: 14px">
              <!-- <h3>商家</h3> -->
              <h3>{{ serviceData[seller - 1].serviceName }}</h3>
              <span>
                <!-- Cute fluffy friends a cat and a dog catch a flying butterfly in a sunny summer -->
                {{ serviceData[seller - 1].serviceDesc }}
              </span>
              <div class="bottom">
                <router-link to="/good">
                  <el-button text class="button">了解更多</el-button>
                </router-link>
              </div>
            </div>
          </el-card>
        </el-col>
      </el-row>
      <br />
      <h2>貓奴看這邊</h2>
      <br />
      <el-row>
        <el-col v-for="(seller, index) in 3" :key="seller" :span="7" :offset="index > 0 ? 1 : 0">
          <el-card :body-style="{ padding: '0px' }">
            <el-image class="sellerImg" :src="sellers[seller - 1].sellerImg" fit="cover">
            </el-image>
            <!-- <img
              src="https://media.istockphoto.com/id/1349349263/photo/cute-fluffy-friends-a-cat-and-a-dog-catch-a-flying-butterfly-in-a-sunny-summer.jpg?s=1024x1024&w=is&k=20&c=I3tWgnvB2pI4e7Y7TPESjfwsrhWccci8-AzbJvq0kA4="
              class="image"
            /> -->
            <div style="padding: 14px">
              <!-- <h3>商家</h3> -->
              <h3>{{ sellers[seller - 1].serviceName }}</h3>
              <span>
                <!-- Cute fluffy friends a cat and a dog catch a flying butterfly in a sunny summer -->
                {{ sellers[seller - 1].serviceDescription }}
              </span>
              <div class="bottom">
                <router-link to="/good">
                  <el-button text class="button">了解更多</el-button>
                </router-link>
              </div>
            </div>
          </el-card>
        </el-col>
      </el-row>
      <br />
      <h2>狗狗喜歡這個</h2>
      <br />
      <el-row>
        <el-col v-for="(seller, index) in 3" :key="seller" :span="7" :offset="index > 0 ? 1 : 0">
          <el-card :body-style="{ padding: '0px' }">
            <el-image class="sellerImg" :src="sellers[seller - 1].sellerImg" fit="cover">
            </el-image>
            <!-- <img
              src="https://media.istockphoto.com/id/1349349263/photo/cute-fluffy-friends-a-cat-and-a-dog-catch-a-flying-butterfly-in-a-sunny-summer.jpg?s=1024x1024&w=is&k=20&c=I3tWgnvB2pI4e7Y7TPESjfwsrhWccci8-AzbJvq0kA4="
              class="image"
            /> -->
            <div style="padding: 14px">
              <!-- <h3>商家</h3> -->
              <h3>{{ sellers[seller - 1].serviceName }}</h3>
              <span>
                <!-- Cute fluffy friends a cat and a dog catch a flying butterfly in a sunny summer -->
                {{ sellers[seller - 1].serviceDescription }}
              </span>
              <div class="bottom">
                <router-link to="/good">
                  <el-button text class="button">了解更多</el-button>
                </router-link>
              </div>
            </div>
          </el-card>
        </el-col>
      </el-row>
    </el-main>
  </el-container>
</template>

<script setup>
import OrderSideBar from '../components/OrderSideBar.vue'
import HomeService from '../services/HomeService'

import { ref, onMounted } from 'vue'
// getHome()
const serviceData = ref([])
// const a = 'SERVICE2'

onMounted(async () => {
  try {
    // 调用 HomeService 的 getHome 方法来获取数据
    // const response = await HomeService.getHome('SERVICE1')
    const response = await HomeService.getHome()

    // 将获取到的数据赋值给 tableData
    serviceData.value = response.data
  } catch (error) {
    console.error('获取数据时出错：', error)
  }
})
const adUrl = [
  'https://images.pexels.com/photos/384555/pexels-photo-384555.jpeg?auto=compress&cs=tinysrgb&w=1600',
  'https://images.pexels.com/photos/1741235/pexels-photo-1741235.jpeg?auto=compress&cs=tinysrgb&w=1600',
  'https://images.pexels.com/photos/2607544/pexels-photo-2607544.jpeg?auto=compress&cs=tinysrgb&w=1600',
  'https://images.pexels.com/photos/96428/pexels-photo-96428.jpeg?auto=compress&cs=tinysrgb&w=1600'
]
const sellers = [
  {
    sellerImg:
      'https://images.pexels.com/photos/1108099/pexels-photo-1108099.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1',
    sellerName: '洗澡&SPA',
    sellerDescription: 'NT$2000 ',
    serviceName: '服務名稱1',
    serviceDescription: '服務描述1'
  },
  {
    // Second seller's data here
    sellerImg:
      'https://images.pexels.com/photos/2248516/pexels-photo-2248516.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1',
    sellerName: '商家2',
    sellerDescription:
      '描述商家二的地方，Cute fluffy friends a cat and a dog catch a flying butterfly in a sunnysummer',
    serviceName: '服務名稱2',
    serviceDescription: '服務描述2'
  },
  {
    // Third seller's data here
    sellerImg:
      'https://images.pexels.com/photos/1560424/pexels-photo-1560424.jpeg?auto=compress&cs=tinysrgb&w=1600',
    sellerName: '商家3',
    sellerDescription:
      '描述商家3的地方，Cute fluffy friends a cat and a dog catch a flying butterfly in a sunnysummer',
    serviceName: '服務名稱3',
    serviceDescription: '服務描述3'
  }
]

// import { Search } from '@element-plus/icons-vue'
</script>

<style scoped lang="scss">
$themeColor: #f7ddba;
.el-main {
  background-color: #f8f4da;
}
.el-carousel__item:nth-child(n) {
  background-color: transparent;
  .adImg {
    width: 100%;
    height: 100%;
  }
}
.el-card {
  width: 480px;
  height: 400px;
}

.sellerImg {
  width: 100%;
  height: 250px;
}
div > h3 {
  font-size: 1.5rem;
  font-weight: 600;
}
div > span {
  font-size: 1.5rem;
}

// .el-carousel__item:nth-child(2n + 1) {
//   background-color: #d3dce6;
// }
// .el-carousel__item h3 {
//   color: #475669;
//   opacity: 0.75;
//   line-height: 300px;
//   margin: 0;
//   text-align: center;
// }
.time {
  font-size: 12px;
  color: #999;
}

.bottom {
  margin-top: 13px;
  line-height: 12px;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.button {
  padding: 0;
  min-height: auto;
  color: #666;
  font-size: 1.2rem;
}

h2 {
  font-weight: bold;
  color: #ff8400;
}
</style>
