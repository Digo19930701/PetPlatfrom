<template>
  <el-container>
    <el-main>
      <div
        class="goodRadius"
        v-for="(goodRadius, i) in radiusGroup"
        :key="i"
        :span="6"
        :xs="{ span: 12 }"
        :style="{
          borderRadius: goodRadius.type ? `var(--el-border-radius-${goodRadius.type})` : ''
        }"
      >
        <br />
        <div class="goodPic">
          <img
            src="https://images.pexels.com/photos/127027/pexels-photo-127027.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
            class="picImg"
          />
        </div>
        <div class="store">
          <el-row style="width: 100%">
            <el-text class="clGoodTitle" v-model="good_title" :value="good_title">
              {{ good_title }}
            </el-text>
          </el-row>
          <el-space class="storeSpace" direction="vertical">
            <el-card class="storeInf">
              <h2>商家簡介</h2>
              <span class="inf">
                Zutto 寵物溝通溝通過程的形式，又可分為問答式溝通、會談式溝通兩種。
                問答式溝通屬於解答性質的溝通方式，問答式動物溝通師的身分為物種間的翻譯員，也可以說是毛孩子們的日記，其功能在於協助飼主理解動物的各種想法、感受、情緒等等，問答式動物溝通師多數以問題數量作為收費的考量。
              </span>
            </el-card>
            <br />
            <el-card class="storeIntro">
              <h2>服務介紹</h2>
              <span class="int">
                會談式溝通屬於心理會談性質的溝通方式，溝通師身分類似家庭關係的輔導工作者，多數以協助並促進飼主與動物間關係為主要考量，過程中較少的主觀位置，為融合心靈會談和動物溝通的會談方式，其多數以小時(時間)作為收費基準。
              </span>
            </el-card>
          </el-space>
          <br />
          <el-card class="storeC">
            <h3>選擇方案</h3>
            <span>
              <div>
                <h2>日期</h2>
                <el-date-picker
                  v-model="val_day"
                  type="date"
                  placeholder="Pick a day"
                  size="large"
                />
                <el-divider />
                <h2>時間</h2>
                <el-time-select
                  v-model="value_time"
                  start="08:30"
                  step="00:30"
                  end="18:30"
                  placeholder="Select time"
                  size="large"
                />
                <el-divider />

                <h2>規格</h2>
                <el-button round size="large" class="plan-bn" @click="money(1500)">1小時</el-button>
                <el-button round size="large" class="plan-bn" @click="money(2200)">2小時</el-button>
                <el-button round size="large" class="plan-bn" @click="money(2800)">3小時</el-button>
                <el-divider />
                <div>
                  <el-text class="price" v-model="price" style="font-size: 1.7rem"
                    >NTD:{{ price }}</el-text
                  >
                </div>
              </div>
            </span>
          </el-card>
          <el-divider style="width: 95%" />
          <div class="buttons">
            <el-button class="cartBtn" size="large" @click="addToCart"> 加入購物車 </el-button>
            <el-button class="buyBtn" size="large">
              <a href="/shoppingCart">立即下單</a>
            </el-button>
          </div>
          <br />
        </div>
      </div>
    </el-main>
  </el-container>
</template>
<script lang="ts" setup>
import { ref } from 'vue'
import { ElNotification } from 'element-plus'
//import orderSideBar from '../components/orderSideBar.vue'
// import { Text, ref } from 'vue'
const def = ref(2000)
const money = (ind) => {
  def.value = ind
}

const addToCart = () => {
  ElNotification({
    title: 'Success',
    message: '成功加入購物車！',
    type: 'success',
    duration: 3000,
    offset: 100
  })
}

const radiusGroup = ref([
  {
    name: 'Large Radius',
    type: 'base'
  }
])
const getValue = (type: string) => {
  const getCssVarValue = (prefix, type) =>
    getComputedStyle(document.documentElement).getPropertyValue(`--el-${prefix}-${type}`)
  return getCssVarValue('border-radius', type)
}
const good_title = '[Zutto]寵物溝通'

const val_day = ref('')
const value_time = ref('')

const price = def
// const size = ref('default')
</script>
<style lang="scss">
.goodRadius {
  height: auto;
  width: 90%;
  // background-color: #fff;
  border: 3px solid var(--el-border-color);
  border-radius: 10px;
  margin-top: 20px;
  // align-items: center;
  margin: 25px auto; // div至中

  .goodPic {
    width: 90%;
    margin: 5px auto;
    .picImg {
      width: 100%;
      margin: 5px auto;
    }
  }
  .clGoodTitle {
    font-size: xx-large;
    font-weight: 600;
    color: rgb(148, 96, 0);
  }
  .plan-bn {
    font-size: 1.2rem;
    margin-top: 10px;
  }
  .store {
    padding-left: 5%;
    padding-bottom: 5px;

    .storeSpace {
      width: 95%;
    }

    .storeInf {
      // width: 95%;
      width: 90%;
      background-color: bisque;
      font-size: 1.3rem;
    }
    .storeIntro {
      width: 95%;
      background-color: bisque;
      font-size: 1.3rem;
    }
    .storeC {
      // padding-left: 50%;
      width: 95%;
      background-color: bisque;
      font-size: 1.2rem;
    }
    .buttons {
      width: 95%;
      display: flex;
      .cartBtn {
        width: 50%;
        font-size: x-large;
      }
      .buyBtn {
        width: 50%;
        font-size: x-large;
      }
    }
  }
}
:root {
  .el-tabs__item {
    font-size: large;
    font-weight: 600;
  }
  .el-tabs__header {
    padding-right: 30px;
  }
}
</style>
