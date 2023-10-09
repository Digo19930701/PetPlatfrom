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
            src="https://images.pexels.com/photos/2607544/pexels-photo-2607544.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
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
                2
                KIDS工作室是一家專業的寵物攝影商家，我們致力於捕捉您寶貴寵物的美麗瞬間，並將它們永遠保存在精美的照片中。我們的團隊擁有豐富的攝影經驗，對寵物的熱愛，以及創造美麗的影像的才華。我們相信每個寵物都有獨特的故事和魅力，我們的目標是通過攝影將這些特質展現給世界。
              </span>
            </el-card>
            <br />
            <el-card class="storeIntro">
              <h2>服務介紹</h2>
              <span class="int">
                寵物攝影： <br />
                我們提供專業的寵物攝影服務，包括在室內和室外的攝影場地。<br />
                我們將捕捉您寵物的各種情感和動作，從快樂、驚奇到溫馨和自然的瞬間。<br /><br />寵物家庭攝影：<br />
                如果您希望與您的寵物一起拍攝家庭照片，我們可以安排家庭攝影服務，捕捉您和您的寵物共度的特別時刻。<br /><br />
                活動攝影：<br />
                我們可以為各種寵物活動和特殊場合提供攝影服務，包括寵物生日派對、競賽、散步等。
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
                <el-button round size="large" class="plan-bn" @click="money(4980)"
                  >寵物攝影</el-button
                >
                <el-button round size="large" class="plan-bn" @click="money(5999)"
                  >寵物家庭攝影</el-button
                >
                <el-button round size="large" class="plan-bn" @click="money(6990)"
                  >活動攝影</el-button
                >
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
const def = ref(4980)
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
const good_title = '[2 KIDS]寵物攝影'

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
