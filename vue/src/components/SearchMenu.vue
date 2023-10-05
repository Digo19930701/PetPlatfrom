<template>
  <el-main style="display: flex">
    <el-aside>
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
            :size="size"
          />
          <el-divider />
          <h2>價格範圍 <font-awesome-icon icon="fa-solid fa-money-check-dollar" /></h2>
          <div style="font-size: 20px">
            NTD{{ val_price_range[0] }} ~ NTD{{ val_price_range[1] }}
          </div>

          <div class="slider-demo-block">
            <el-slider v-model="val_price_range" range show-stops :max="10000" />
          </div>
          <el-divider />
          <h2>分類 <font-awesome-icon icon="fa-solid fa-paw" /></h2>
          <br />
          <el-button round size="large" class="bn">美容</el-button>
          <el-button round size="large" class="bn">照護</el-button>
          <el-button round size="large" class="bn">溝通</el-button>
          <el-button round size="large" class="bn">攝影</el-button>
        </div>
      </span>
      <template #footer>
        <div style="flex: auto">
          <el-button @click="cancelClick" size="large" class="bn">取消</el-button>
          <el-button type="primary" @click="confirmClick" size="large" class="bn">確定</el-button>
        </div>
      </template>
    </el-aside>
    <el-space direction="vertical" class="demo">
      <br />
      <el-row v-for="i in 3" :key="i">
        <el-col v-for="(o, index) in 4" :key="o" :span="5" :offset="index > 0 ? 1 : 0">
          <!-- 都先帶0 不知道為什麼跑不出來QAQ -->
          <el-card :body-style="{ padding: '0px' }">
            <!-- <img
                src="https://media.istockphoto.com/id/1331301152/photo/photo-in-motion-running-beautiful-golden-retriever-dog-have-a-walk-outdoors-in-the-park.jpg?s=1024x1024&w=is&k=20&c=JZ6x5NMk_sTZwQAs2iR3MUr6JfEmjqszXIBrv2HAOB8="
                class="image"
              /> -->
            <el-image class="sellerImg" :src="sellers[0].sellerImg" fit="cover"> </el-image>
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
const size = ref('large')
const val_price_range = ref([500, 5000])
const value_time = ref('')
const date = new Date(value1.value)
const dayOfWeek = date.getDay()
console.log(dayOfWeek)

function cancelClick() {
  drawer.value = false
}
function confirmClick() {
  drawer.value = false
}
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
      'https://images.pexels.com/photos/1560424/pexels-photo-1560424.jpeg?auto=compress&cs=tinysrgb&w=1600',
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

<style lang="scss" scoped>
$themeColor: #f7ddba;

.bn {
  font-size: large;
}
.bn:hover {
  background-color: #fff;
}
.bn:focus {
  background-color: #fff;
}
.demo {
  padding-left: 50px;
}

.bottom {
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
.el-aside {
  overflow: auto;
  box-sizing: border-box;
  flex-shrink: 0;
  width: 26%;
}
.el-row:last-child {
  margin-bottom: 30px;
}
</style>
