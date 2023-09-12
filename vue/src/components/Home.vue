<script setup>
import { ref } from 'vue'
const ad_url = [
  'https://www.shutterstock.com/shutterstock/photos/1034939470/display_1500/stock-photo-row-of-the-tops-of-heads-of-cats-and-dogs-with-paws-up-peeking-over-a-blank-white-sign-sized-for-1034939470.jpg',
  'https://fuss10.elemecdn.com/1/34/19aa98b1fcb2781c4fba33d850549jpeg.jpeg',
  'https://fuss10.elemecdn.com/0/6f/e35ff375812e6b0020b6b4e8f9583jpeg.jpeg',
  'https://fuss10.elemecdn.com/9/bb/e27858e973f5d7d3904835f46abbdjpeg.jpeg'
]
// import { Search } from '@element-plus/icons-vue'
</script>

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
            <el-image class="ad_img" :src="ad_url[item - 1]"> </el-image>
          </el-carousel-item>

          <!-- <h3 text="2xl" justify="center"></h3> -->
          <!-- </el-carousel-item> -->
        </router-link>
      </el-carousel>
      <br />
      <h2>推薦商家</h2>
      <br />
      <el-row>
        <el-col v-for="(o, index) in 3" :key="o" :span="7" :offset="index > 0 ? 1 : 0">
          <el-card :body-style="{ padding: '0px' }">
            <!-- <el-image class="image" :src="store[o - 1].img"> </el-image> -->
            <img
              src="https://media.istockphoto.com/id/1349349263/photo/cute-fluffy-friends-a-cat-and-a-dog-catch-a-flying-butterfly-in-a-sunny-summer.jpg?s=1024x1024&w=is&k=20&c=I3tWgnvB2pI4e7Y7TPESjfwsrhWccci8-AzbJvq0kA4="
              class="image"
            />
            <div style="padding: 14px">
              <h3>商家</h3>
              <span
                >Cute fluffy friends a cat and a dog catch a flying butterfly in a sunny
                summer</span
              >
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
        <el-col v-for="(o, index) in 3" :key="o" :span="7" :offset="index > 0 ? 1 : 0">
          <el-card :body-style="{ padding: '0px' }">
            <img
              src="https://media.istockphoto.com/id/1270634313/photo/cute-fluffy-cat-lies-on-the-grass-in-the-garden-and-catches-the-sun-highlights.jpg?s=1024x1024&w=is&k=20&c=vRaI9nPHgGskq0ZFTmWu5Sys2hPCk6z19ZzXcxEPqJ4="
              class="image"
            />
            <div style="padding: 14px">
              <h3>給貓貓的服務</h3>
              <span
                >Cute fluffy friends a cat and a dog catch a flying butterfly in a sunny
                summer</span
              >
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
        <el-col v-for="(o, index) in 3" :key="o" :span="7" :offset="index > 0 ? 1 : 0">
          <el-card :body-style="{ padding: '0px' }">
            <img
              src="https://media.istockphoto.com/id/1331301152/photo/photo-in-motion-running-beautiful-golden-retriever-dog-have-a-walk-outdoors-in-the-park.jpg?s=1024x1024&w=is&k=20&c=JZ6x5NMk_sTZwQAs2iR3MUr6JfEmjqszXIBrv2HAOB8="
              class="image"
            />
            <div style="padding: 14px">
              <h3>給狗狗的服務</h3>
              <span
                >Cute fluffy friends a cat and a dog catch a flying butterfly in a sunny
                summer</span
              >
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
  .ad_img {
    width: 100%;
    height: 100%;
  }
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
