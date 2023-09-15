<template>
  <el-container>
    <el-aside width="20%">
      <br />
      <div style="padding: 14px">
        <h2>愛漂亮</h2>
        <router-link to="/search"><a>洗澡&SPA</a></router-link>

        <br />
        <router-link to="/search"><a>美容</a></router-link>

        <br />
        <router-link to="/search"><a>療浴</a></router-link>

        <el-divider />

        <h2>我需要保母</h2>
        <router-link to="/search"><a>寵物安親</a></router-link>

        <br />
        <router-link to="/search"><a>寵物旅館</a></router-link>

        <br />
        <router-link to="/search"><a>到府服務</a></router-link>

        <br />
        <router-link to="/search"><a>小奶貓狗照護</a></router-link>

        <el-divider />

        <h2>想知道...</h2>
        <router-link to="/search"><a>預約寵物溝通</a></router-link>

        <el-divider />

        <h2>記錄美好瞬間</h2>
        <router-link to="/search"><a>預約寵物攝影</a></router-link>
      </div>
    </el-aside>
    <el-main>
      <el-carousel :interval="5000" arrow="always">
        <router-link to="/good">
          <el-carousel-item v-for="item in 4" :key="item">
            <el-image class="adImg" :src="adUrl[item - 1]"> </el-image>
          </el-carousel-item>

          <!-- <h3 text="2xl" justify="center"></h3> -->
          <!-- </el-carousel-item> -->
        </router-link>
      </el-carousel>
      <br />
      <h2>推薦商家&服務</h2>
      <br />
      <el-row>
        <el-col v-for="(seller, index) in 3" :key="seller" :span="7" :offset="index > 0 ? 1 : 0">
          <el-card :body-style="{ padding: '0px' }">
            <el-image class="sellerImg" :src="sellers[seller - 1].sellerImg"> </el-image>
            <!-- <img
              src="https://media.istockphoto.com/id/1349349263/photo/cute-fluffy-friends-a-cat-and-a-dog-catch-a-flying-butterfly-in-a-sunny-summer.jpg?s=1024x1024&w=is&k=20&c=I3tWgnvB2pI4e7Y7TPESjfwsrhWccci8-AzbJvq0kA4="
              class="image"
            /> -->
            <div style="padding: 14px">
              <!-- <h3>商家</h3> -->
              <h3>{{ sellers[seller - 1].sellerName }}</h3>
              <span>
                <!-- Cute fluffy friends a cat and a dog catch a flying butterfly in a sunny summer -->
                {{ sellers[seller - 1].sellerDescription }}
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
            <el-image class="sellerImg" :src="sellers[seller - 1].sellerImg"> </el-image>
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
            <el-image class="sellerImg" :src="sellers[seller - 1].sellerImg"> </el-image>
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
import { ref } from 'vue'
const adUrl = [
  'https://www.shutterstock.com/shutterstock/photos/1034939470/display_1500/stock-photo-row-of-the-tops-of-heads-of-cats-and-dogs-with-paws-up-peeking-over-a-blank-white-sign-sized-for-1034939470.jpg',
  'https://images.pexels.com/photos/1254140/pexels-photo-1254140.jpeg',
  'https://fuss10.elemecdn.com/0/6f/e35ff375812e6b0020b6b4e8f9583jpeg.jpeg',
  'https://fuss10.elemecdn.com/9/bb/e27858e973f5d7d3904835f46abbdjpeg.jpeg'
]
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

// import { Search } from '@element-plus/icons-vue'
</script>

<style scoped lang="scss">
$themeColor: #f7ddba;

.el-container {
  .el-aside {
    background-color: #f7f6e8;
    height: 100vh;
    .a {
      font-size: 1.35rem;
    }
  }
}

.el-main {
  background-color: #f2f2ef;
  height: 100vh;
}
.el-carousel__item:nth-child(n) {
  background-color: #99a9bf;
  .adImg {
    width: 100%;
    height: 100%;
  }
}
.sellerImg {
  width: 100%;
  height: 250px;
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
}

.image {
  width: 100%;
  display: block;
}

h2 {
  font-weight: bold;
  color: #ff8400;
}
</style>
