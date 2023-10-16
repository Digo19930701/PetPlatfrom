<template>
  <main style="width: 1000px; display: flex; justify-content: center">
    <el-scrollbar style="height: 850px">
      <el-form :model="form" label-width="160px">
        <div class="base hw">
          <br />
          <!-- <el-form-item label="上傳頭像" >
            <el-upload
              action=""
              list-type="picture-card"
              :on-preview="handlePictureCardPreview"
              :on-remove="handleRemove"
              :auto-upload="false"
              :limit="1"
              :on-exceed="HandleAvatar"
            >
              <el-icon><Plus /></el-icon>
            </el-upload>
  
            <el-dialog v-model="dialogVisible" style="text-align: center">
              <img :src="avatarImageUrl" alt="Preview Image" class="imgwd" />
            </el-dialog>
          </el-form-item> -->

          <el-form-item
            label="商家名稱"
            prop="name"
            :rules="[{ required: true, message: '此為必填欄位' }]"
          >
            <el-input
              v-model="form.name"
              type="text"
              placeholder="最多10字(不分中英文數字)"
              maxlength="10"
              show-word-limit
            />
          </el-form-item>

          <el-form-item label="Email(帳號)" prop="account">
            <p style="color: #888; padding-left: 10px; font-size: large">{{ form.account }}</p>
          </el-form-item>

          <!-- <el-form-item label="統一編號" prop="taxID">
            <p style="color: #888; padding-left: 10px">
              {{ props.taxID }}&emsp;
              <el-tooltip
                placement="top-start"
                effect="customized"
                content="如需更動統一編號&emsp;請與平台方聯繫"
              >
                <el-icon style="color: #888" :size="15"><WarningFilled /></el-icon>
              </el-tooltip>
            </p>
          </el-form-item>
   -->
           <el-form-item
            label="密碼"
            prop="password"
            
            :rules="[{ required: true, message: '此為必填欄位' }]"
          >
            <el-input v-model="form.password" type="password" autocomplete="off" disabled />
          </el-form-item>
          <el-form-item>
            <a href="/sellerPassword">修改密碼</a>
          </el-form-item>
          <!--
          <el-form-item label="公司證明文件">
            <el-upload ref="uploadRef" class="upload-demo" action="" :auto-upload="false">
              <el-button type="primary" class="uploadbn" plain>
                上傳文件<el-icon class="el-icon--right"><Upload /></el-icon>
              </el-button>
            </el-upload>
            <el-alert class="alertwh" type="info" show-icon :closable="false">
              <p>請上傳公司相關登記證明文件</p>
            </el-alert>
          </el-form-item> -->
          <el-form-item
            label="聯絡電話"
            prop="cell"
            :rules="[{ required: true, message: '此為必填欄位' }]"
          >
            <el-input
              v-model="form.cell"
              type="text"
              autocomplete="off"
              maxlength="10"
              show-word-limit
            />
          </el-form-item>

          <el-form-item label="商家簡述">
            <el-input
              v-model="form.desc"
              type="textarea"
              class="--el-input-width"
              autosize
              style="font-size: 1rem"
            />
          </el-form-item>

          <el-form-item
            label="商家地址"
            prop="addre"
            :rules="[{ required: true, message: '此為必填欄位' }]"
          >
            <el-input v-model="form.addre" type="text" autocomplete="off" />
          </el-form-item>

          <el-form-item label="交通/停車資訊">
            <el-input v-model="form.park" type="textarea" class="--el-input-width" />
          </el-form-item>
        </div>
        <br />
        <div class="base hw">
          <br />
          <el-form-item label="接受預約單位時間" class="serviceTime">
            <span>每&nbsp</span>
            <el-input-number
              v-model="form.acceptUnit"
              :step="30"
              :min="30"
              :max="servicePeriod"
              step-strictly
            />
            <p>分鐘為單位接受預約</p>
            <el-alert class="alertwh" type="info" show-icon :closable="false">
              <p>上限值由「服務所需時間長」決定。</p>
            </el-alert>
          </el-form-item>
        </div>
        <br />
        <el-form-item label-width="35%">
          <el-button round >編輯</el-button>
          <el-button type="primary" round @click="onSubmit">儲存</el-button>
        </el-form-item>
      </el-form>
    </el-scrollbar>
  </main>
</template>

<script lang="ts" setup>
import { reactive, ref, onMounted } from 'vue'
import type { UploadProps, UploadInstance } from 'element-plus'
import { Plus, Upload, WarningFilled } from '@element-plus/icons-vue'
import { ElMessage } from 'element-plus'
import axios from 'axios'
import SellerService from '../services/Service'
import { useSSRContext } from 'vue'

// const emit = defineEmits(['child-click'])
// const ctx = useSSRContext()
const props = defineProps({
  sellerImg: {
    type: URL,
    default: ''
  },
  sellerId: {
    type: String,
    default: ''
  },
  sellerName: {
    type: String,
    default: ''
  },
  sellerPhone: {
    type: String,
    default: ''
  },
  sellerDesc: {
    type: String,
    default: ''
  },
  sellerAdd: {
    type: String,
    default: ''
  },
  sellerPark: {
    type: String,
    default: ''
  },
  unitTime: {
    type: String,
    default: '30'
  },
  taxID: {
    type: String,
    default: '8181778'
  }
})

const form = reactive({
  name: '',
  account: '',
  taxID: '',
  password: '',
  cell: '',
  desc: '',
  addre: '',
  park: '',
  acceptUnit: '',
  img:''
})

const sellerData = ref(null)
var seller = 'SELLER1'


const print =()=>{
  console.log(SellerService.getSellerInfo(seller))
}
const getSeller = async () => {

  try {
    const response = await SellerService.getSellerInfo(seller)
    
    const responseData = response.data

    form.name = responseData.sellerName
    form.account = responseData.sellerId
    form.cell = responseData.sellerPhone
    form.addre = responseData.sellerAdd
    form.park = responseData.sellerPark
    form.acceptUnit = responseData.unitTime
    form.desc = responseData.sellerDesc
    form.password = responseData.sellerPassword
    sellerData.value = responseData
    console.log('賣家的帳號:'+`${responseData.sellerId}`)
  } catch (error) {
    console.error('錯誤訊息：', error)
  }
}

onMounted(() => {
  getSeller()
})

const onSubmit = async () => {
  const data = {
    sellerName: form.name,
    sellerId:form.account,
    sellerPhone:form.cell,
    sellerAdd:form.addre,
    sellerPark:form.park,
    unitTime:form.acceptUnit,
    sellerDesc:form.desc,
    sellerPassword:form.password
  }
  
  console.log(data)
    try{
       await axios.put('http://localhost:3300/4A2Bpet/sellers/SEllER1',data,{
        headers: {
        'Content-Type': 'application/json'
          }
       })
       alert('儲存成功!') 
    }
    catch(error) {
      alert(error)
      console.log(error)
    }
}
const avatarImageUrl = ref('')
const dialogVisible = ref(false)
const servicePeriod = ref(60)

const handleRemove: UploadProps['onRemove'] = (uploadFile, uploadFiles) => {
  console.log(uploadFile, uploadFiles)
}

const handlePictureCardPreview: UploadProps['onPreview'] = (uploadFile) => {
  avatarImageUrl.value = uploadFile.url!
  dialogVisible.value = true
}

const uploadRef = ref<UploadInstance>()

function HandleAvatar() {
  ElMessage({
    message: '僅能上傳1張頭像！',
    type: 'error',
    offset: 100
    // 偏離上面多少距離，有被其他元件擋住時可以調整顯示的位置
  })
}
</script>
<style src="../assets/seller.css"></style>
<style lang="scss" scoped>
.hw {
  width: 580px;
  height: 100%;
  padding: 10px;
}
.el-button {
  font-size: 1.5rem;
}

.el-form-item__label {
  font-size: 1.1rem;
}
p {
  font-size: 0.9rem;
}

.el-input {
  width: 80%;
  font-size: 1rem;
}
.imgwd {
  max-width: 600px;
  max-height: 800px;
}
.uploadbn {
  margin-top: 10px;
}
.alertwh {
  margin-top: 10px;
  width: 80%;
  line-height: 1.5;
}
:root {
  .--el-input-width {
    width: 80%;
  }
}
</style>
