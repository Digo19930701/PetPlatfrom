<template>
  <header><SellerHeadBar /></header>
  <main>
    <el-container>
      <el-aside><SellerSideBar /></el-aside>
      <el-main>
        <el-row>
          <el-col>
            <el-row>
              <div class="radiusPre">
                <el-text class="text">預覽模式</el-text>
              </div>
            </el-row>
            <br />
            <el-row>
              <el-button round class="deleteBtn"> 刪除 </el-button>
              <el-button round class="editBtn"> <a href="/serviceEdit">編輯</a> </el-button>&emsp;
              <router-link to="/servicesExist">
                <el-button type="primary" :icon="Close" link>退出預覽模式</el-button>
              </router-link>
            </el-row>
            <div style="width: 100%">
              <p>{{ goodTitle }}</p>
            </div>
          </el-col>
        </el-row>
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
              src="https://media.istockphoto.com/id/1331301152/photo/photo-in-motion-running-beautiful-golden-retriever-dog-have-a-walk-outdoors-in-the-park.jpg?s=1024x1024&w=is&k=20&c=JZ6x5NMk_sTZwQAs2iR3MUr6JfEmjqszXIBrv2HAOB8="
              class="pic_img"
            />
          </div>
          <div class="store">
            <el-row style="width: 100%">
              <el-text class="cl_goodTitle" v-model="goodTitle" :value="goodTitle">
                {{ goodTitle }}
              </el-text>
            </el-row>
            <el-space class="store_space" direction="vertical">
              <el-card class="store_inf">
                <h2>商家簡介</h2>
                <span class="inf">
                  寵曖貓狗生活館位於民族路上，鄰近日新影城。店內同時有 4-5
                  位美容師作業，會讓剛到達的毛孩們先在地上到處走走適應環境，也可以和其他個性穩定的狗狗彼此認識熟悉。雖然這家台中寵物美容沒有開放家長現場陪同與等待，但是作業區為全玻璃開放式的環境，因此所有過程皆是公開透明。
                </span>
              </el-card>
              <!-- <el-divider style="width: 95%" /> -->
              <el-card class="store_intro">
                <h2>服務介紹</h2>
                <span class="int">
                  寵曖貓狗生活館位於民族路上，鄰近日新影城。店內同時有 4-5
                  位美容師作業，會讓剛到達的毛孩們先在地上到處走走適應環境，也可以和其他個性穩定的狗狗彼此認識熟悉。雖然這家台中寵物美容沒有開放家長現場陪同與等待，但是作業區為全玻璃開放式的環境，因此所有過程皆是公開透明。
                </span>
              </el-card>
              <!-- <el-card class="store_c">
            <h2>選擇方案</h2>
          </el-card> -->
            </el-space>
            <el-card class="store_c">
              <h2>選擇方案</h2>
              <span class="ccc">
                <div>
                  <h2>日期</h2>
                  <el-date-picker v-model="valDay" type="date" placeholder="Pick a day" />
                  <el-divider />
                  <h2>時間</h2>
                  <el-time-select
                    v-model="value_time"
                    start="08:30"
                    step="00:30"
                    end="18:30"
                    placeholder="Select time"
                  />
                  <el-divider />

                  <h2>規格</h2>
                  <el-button round size="large" class="plan-bn">大型犬</el-button>
                  <el-button round size="large" class="plan-bn">中型犬</el-button>
                  <el-button round size="large" class="plan-bn">小型犬</el-button>
                  <el-divider />
                  <div>
                    <el-text class="price" v-model="price" style="font-size: 1.5rem">
                      NTD:{{ price }}
                    </el-text>
                  </div>
                </div>
              </span>
            </el-card>
            <el-divider style="width: 95%" />
            <div class="buttons">
              <el-button plain @click="open" class="cartBtn"> 加入購物車 </el-button>
              <el-button plain @click="open" class="buyBtn"> 立即下單 </el-button>
            </div>
          </div>
        </div>
      </el-main>
    </el-container>
  </main>
  <footer><FootBar /></footer>
</template>

<script lang="ts">
import SellerHeadBar from '../components/SellerHeadBar.vue'
import SellerSideBar from '../components/SellerSideBar.vue'
import FootBar from '../components/FootBar.vue'
</script>

<style lang="scss" scoped>
.header {
  background-color: #f8d479;
  width: 100%;
  display: inline-flex;
  .hText {
    position: absolute;
    left: 55%;
  }
}
.el-main {
  background-color: #f8f4da;
  p {
    font-size: 2rem;
    font-weight: 600;
    color: rgb(96, 98, 102);
    text-align: center;
  }
  .radiusPre {
    border-radius: 25px;
    background-color: #ffbc88;
    width: 100px;
    .text {
      font-size: large;
      font-weight: 600;
      padding-left: 15%;
    }
  }
}
.goodRadius {
  height: auto;
  width: 70%;
  border: 3px solid var(--el-border-color);
  border-radius: 0;
  margin-top: 20px;
  // align-items: center;
  margin: 25px auto; // div至中

  .goodPic {
    width: 90%;
    margin: 5px auto;
    .pic_img {
      width: 100%;
      margin: 5px auto;
    }
  }
  .cl_goodTitle {
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

    .store_space {
      width: 95%;
    }

    .store_inf {
      // width: 95%;
      width: 90%;
      background-color: bisque;
      font-size: 1.3rem;
    }
    .store_intro {
      width: 95%;
      background-color: bisque;
      font-size: 1.3rem;
    }
    .store_c {
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
</style>

<script lang="ts" setup>
// import { ref } from 'vue'
import { h, ref } from 'vue'
import { ElMessageBox, ElSwitch } from 'element-plus'
import { Close } from '@element-plus/icons-vue'

// import { Text, ref } from 'vue'

const radiusGroup = ref([
  {
    name: 'Large Radius',
    type: 'base'
  }
])
const goodTitle = '洗澡&SPA'
const valDay = ref('')
const value_time = ref('')
const price = '2,000'

const open = () => {
  ElMessageBox({
    title: 'Message',
    message: h('p', null, [
      h('span', null, '此為預覽模式 無法執行動作')
      // h('i', { style: 'color: teal' }, 'VNode')
    ])
  })
}
</script>
