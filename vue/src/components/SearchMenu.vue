<template>
  <el-main>
    <el-button type="primary" style="margin-left: 16px" @click="drawer = true">
      <font-awesome-icon icon="fa-solid fa-sliders" />
    </el-button>
    <el-drawer
      v-model="drawer"
      title="I am the title"
      :with-header="false"
      :direction="direction"
      style="background-color: #fef4e7"
    >
      <span>
        <div style="padding: 14px">
          <!-- <div></div> -->
          <h2>日期 <font-awesome-icon icon="fa-solid fa-calendar-days" /></h2>
          <el-date-picker v-model="value1" type="date" placeholder="Pick a day" :size="size" />
          <el-divider />
          <h2>時間 <font-awesome-icon icon="fa-solid fa-clock" /></h2>
          <el-time-select
            v-model="value_time"
            start="08:30"
            step="00:15"
            end="18:30"
            placeholder="Select time"
          />
          <el-divider />
          <h2>價格範圍 <font-awesome-icon icon="fa-solid fa-money-check-dollar" /></h2>
          <div>NTD{{ val_price_range[0] }} ~ NTD{{ val_price_range[1] }}</div>

          <div class="slider-demo-block">
            <el-slider v-model="val_price_range" range show-stops :max="10000" />
          </div>
          <el-divider />
          <h2>分類 <font-awesome-icon icon="fa-solid fa-paw" /></h2>
          <el-button round>美容</el-button>
          <el-button round>照護</el-button>
          <el-button round>溝通</el-button>
          <el-button round>攝影</el-button>
        </div>
      </span>
    </el-drawer>
    <el-space direction="vertical">
      <el-row v-for="i in 3" :key="i">
        <el-col v-for="(o, index) in 4" :key="o" :span="5" :offset="index > 0 ? 1 : 0">
          <!-- 都先帶0 不知道為什麼跑不出來QAQ -->
          <el-card :body-style="{ padding: '0px' }">
            <!-- <img
              src="https://media.istockphoto.com/id/1331301152/photo/photo-in-motion-running-beautiful-golden-retriever-dog-have-a-walk-outdoors-in-the-park.jpg?s=1024x1024&w=is&k=20&c=JZ6x5NMk_sTZwQAs2iR3MUr6JfEmjqszXIBrv2HAOB8="
              class="image"
            /> -->
            <el-image class="sellerImg" :src="sellers[0].sellerImg"> </el-image>
            <!-- (i - 1) * 4 + o - 1 -->
            <div style="padding: 14px">
              <!-- <h3>各種選項</h3> -->
              <h3>{{ sellers[0].serviceName }}</h3>
              <span>
                {{ sellers[0].serviceDescription }}
              </span>
              <div class="bottom">
                <router-link to="/good">
                  <el-button text class="button">了解更多</el-button>
                </router-link>
              </div>
            </div>
          </el-card>
        </el-col>
        <!-- <el-col v-for="(seller, index) in 4" :key="seller" :span="5" :offset="index > 0 ? 1 : 0">
          <el-card :body-style="{ padding: '0px' }">
            <el-image class="sellerImg" :src="sellers[(i - 1) * 4 + seller - 1].sellerImg">
            </el-image>

            <div style="padding: 14px">
              <h3>{{ sellers[(i - 1) * 4 + seller - 1].serviceName }}</h3>
              <span>
                {{ sellers[0].serviceDescription }}
              </span>
              <div class="bottom">
                <router-link to="/good">
                  <el-button text class="button">了解更多</el-button>
                </router-link>
              </div>
            </div>
          </el-card>
        </el-col> -->
      </el-row>
    </el-space>
  </el-main>
</template>

<script lang="ts" setup>
import { ref } from 'vue'
const drawer = ref(false)
const direction = ref('ltr')
const value1 = ref('')
const size = ref('default')
const val_price_range = ref([500, 5000])
const value_time = ref('')

// export default {
//   data() {
//     return {
//       drawer: false
//     }
//   }
// }

const sellers = [
  {
    sellerImg:
      'https://www.shutterstock.com/shutterstock/photos/1034939470/display_1500/stock-photo-row-of-the-tops-of-heads-of-cats-and-dogs-with-paws-up-peeking-over-a-blank-white-sign-sized-for-1034939470.jpg',
    sellerName: '商家一',
    sellerDescription:
      '描述商家一的地方，Cute fluffy friends a cat and a dog catch a flying butterfly in a sunnysummer',
    serviceName: '服務名稱一',
    serviceDescription: '服務描述一'
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
      'https://images.pexels.com/photos/3196887/pexels-photo-3196887.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1',
    sellerName: '商家3',
    sellerDescription:
      '描述商家3的地方，Cute fluffy friends a cat and a dog catch a flying butterfly in a sunnysummer',
    serviceName: '服務名稱3',
    serviceDescription: '服務描述3'
  }
]
</script>

<style scoped lang="scss">
$themeColor: #f7ddba;

* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

// .left-drawer {
//   left: 0;
//   right: auto;
// }
// header {
//   background-color: #f9f8d0;
//   display: flex; // 橫向排
//   flex-wrap: wrap;
//   align-items: center;
//   section.logo {
//     flex: 1 1 400px; //flex: 2 1 400px;
//     display: flex;
//     align-items: center;
//     h1 {
//       font-size: 2.5rem;
//       color: #ff8400;
//     }
//     img {
//       width: 6vw;
//       height: 6vw;
//     }
//   }
//   nav {
//     flex: 5 1 500px;
//   }
//   ul {
//     display: flex;
//     list-style-type: none;
//     justify-content: space-around;
//   }
//   li {
//     a {
//       color: #ff8400;
//       text-decoration: none;
//       font-size: 1.35rem;
//       transition: all 0.2s ease;
//       padding-bottom: 0.3rem;
//       &:hover {
//         color: $themeColor;
//         border-bottom: 3px solid $themeColor;
//       }
//     }
//   }
//   .search-bar {
//     width: 90%;
//     height: 32px;
//     font-size: 20px;
//     border: 3px solid #ff8400;
//     background-color: #f9e7d0;
//   }
//   .search-btn {
//     width: 36px;
//     height: 32px;
//     background-color: #ff8400;
//     color: #efe9e7;
//     outline: none;
//     border: 2px solid #ff8400;
//     cursor: pointer;
//     position: absolute;
//   }
// }
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
}

.image {
  width: 100%;
  display: block;
}
// .slider-demo-block {
//   display: flex;
//   align-items: center;
//   .el-slider {
//     margin-top: 0;
//     margin-left: 12px;
//   }
// }
</style>
