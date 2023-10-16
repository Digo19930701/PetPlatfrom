<template>
  <div class="header">
    <div class="trademark">
      <img src="../images/4a2b_icon.png" width="50" object-fit="cover" />
      &copy;4A2B
    </div>
    <div id="bn-area">
      <el-button text id="bn"> 關於4A2B </el-button>
      <el-button text id="bn"> 聯絡我們 </el-button>
      <el-button text id="bn"> 隱私權政策 </el-button>
    </div>
  </div>
</template>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Varela+Round&display=swap');
.header {
  background-color: #f8d479;
  width: 100%;
  height: 65px;
  padding: 15px 0px 15px 20px;
  display: inline-flex;
}

.trademark {
  border-radius: 10px;
  height: 40px;
  width: 150px;
  background-color: #fff3bf;
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: large;
  font-weight: 600;
  font-family: 'Varela Round', sans-serif;
}
#bn-area {
  height: 40px;
  display: flex;
  align-items: center;
}
#bn {
  font-size: large;
  font-family: 'Varela Round', sans-serif;
}
#bn:hover {
  background: transparent;
  color: #cd7b00;
}
#bn:focus {
  background: transparent;
  color: #cd7b00;
}
</style>
