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
            src="https://images.pexels.com/photos/18448463/pexels-photo-18448463.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
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
                Obsession寵物溝通
                是一家專業的寵物溝通服務提供商，致力於幫助寵物主人與他們的寵物建立更深刻的情感聯繫。我們的寵物溝通師具有豐富的經驗，能夠與各種類型的寵物溝通，包括狗、貓、鳥類、兔子等。我們相信，了解寵物的需求、感受和情感可以改善他們的生活質量，並增強與主人的關係。
              </span>
            </el-card>
            <br />
            <el-card class="storeIntro">
              <h2>服務介紹</h2>
              <span class="int">
                寵物心靈溝通： <br />
                我們的寵物溝通師可以通過直觀、感知和對話，嘗試了解寵物的情感、需求和感受。這可以幫助主人更好地理解寵物的行為和狀態。<br />
                <br />行為問題解決：<br />
                如果您的寵物有行為問題，例如焦慮、攻擊、不安或其他不正常行為，我們的寵物溝通師可以試圖找出背後的原因，然後提供建議和解決方案。
                <br /><br />生活變化和過渡：
                當主人家庭狀況發生變化，如搬家、家庭成員增加或減少、其他寵物的引進等，寵物可能會感到壓力和不安。我們可以幫助寵物適應這些變化。
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
const good_title = '[Obsession]寵物溝通'

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
