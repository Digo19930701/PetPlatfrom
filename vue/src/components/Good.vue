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
            src="https://media.istockphoto.com/id/1331301152/photo/photo-in-motion-running-beautiful-golden-retriever-dog-have-a-walk-outdoors-in-the-park.jpg?s=1024x1024&w=is&k=20&c=JZ6x5NMk_sTZwQAs2iR3MUr6JfEmjqszXIBrv2HAOB8="
            class="picImg"
          />
        </div>
        <div class="store" v-for="service in petServices">
          <el-row style="width: 100%">
            <el-text class="clGoodTitle" v-model="good_title" :value="good_title">
              {{service.serviceName }}
            </el-text>
          </el-row>
          <el-space class="storeSpace" direction="vertical">
            <el-card class="storeInf">
              <h2>商家簡介</h2>
              <span class="inf">
                寵曖貓狗生活館位於民族路上，鄰近日新影城。店內同時有 4-5
                位美容師作業，會讓剛到達的毛孩們先在地上到處走走適應環境，也可以和其他個性穩定的狗狗彼此認識熟悉。雖然這家台中寵物美容沒有開放家長現場陪同與等待，但是作業區為全玻璃開放式的環境，因此所有過程皆是公開透明。
              </span>
            </el-card>
            <br />
            <el-card class="storeIntro">
              <h2>服務介紹</h2>
              <span class="int">
               {{ service.serviceDesc }} 
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
                <el-button round size="large" class="plan-bn">{{ service.hst[0].spec }}</el-button>
                <el-button round size="large" class="plan-bn">{{ service.hst[1].spec }}</el-button>
                <el-button round size="large" class="plan-bn">{{ service.hst[2].spec }}</el-button>
                <el-divider />
                <div>
                  <el-text class="price" v-model="price" style="font-size: 1.5rem"
                    >NTD:{{ service.hst[2].price }}</el-text
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
import { ref, onMounted } from 'vue'
import { ElNotification } from 'element-plus'
import Serviece from '../services/Service.js'
//import orderSideBar from '../components/orderSideBar.vue'
// import { Text, ref } from 'vue'

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
const good_title = '洗澡&SPA'

const val_day = ref('')
const value_time = ref('')

const price = '2,000'
// const size = ref('default')

const servicePeriod = ref(0);
const availDayInput = ref([]);
const petServices = ref([]);
const getServiceById = async () => {
  // console.log('try to get petServices');
  try {
    const response = await Serviece.getServiceById();
    if (response.status === 200) {
      petServices.value.push(response.data);

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
