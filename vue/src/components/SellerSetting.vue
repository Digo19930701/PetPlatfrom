<template>
  <main>
    <el-form :model="form" label-width="120px">
      <div class="base hw">
        <br />
        <el-form-item label="上傳頭像">
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
        </el-form-item>

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
          <p style="color: #888; padding-left: 10px">xxxxxxx@gmail.com</p>
        </el-form-item>

        <el-form-item label="統一編號" prop="taxID">
          <p style="color: #888; padding-left: 10px">
            81****78&emsp;
            <el-tooltip
              placement="top-start"
              effect="customized"
              content="如需更動統一編號&emsp;請與平台方聯繫"
            >
              <el-icon style="color: #888" :size="15"><WarningFilled /></el-icon>
            </el-tooltip>
          </p>
        </el-form-item>

        <el-form-item
          label="負責人"
          prop="incharge"
          :rules="[{ required: true, message: '此為必填欄位' }]"
        >
          <el-input v-model="form.incharge" type="text" autocomplete="off" />
          <el-upload ref="uploadRef" class="upload-demo" action="" :auto-upload="false">
            <el-button type="primary" class="uploadbn" plain>
              上傳文件<el-icon class="el-icon--right"><Upload /></el-icon>
            </el-button>
          </el-upload>
          <el-alert class="alertwh" type="info" show-icon :closable="false">
            <p>請上傳公司相關登記證明文件</p>
          </el-alert>
        </el-form-item>

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
          <el-input v-model="form.desc" type="textarea" class="--el-input-width" autosize />
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
      <el-form-item label-width="17%">
        <el-button F8D479 round>編輯</el-button>
        <el-button type="primary" round @click="onSubmit">儲存</el-button>
      </el-form-item>
    </el-form>
  </main>
</template>

<style src="../assets/seller.css"></style>
<script lang="ts" setup>
import { reactive, ref } from 'vue'
import type { UploadProps, UploadInstance } from 'element-plus'
import { Plus, Upload, WarningFilled } from '@element-plus/icons-vue'
import { ElMessage } from 'element-plus'

// test
// do not use same name with ref
const form = reactive({
  name: '',
  account: '',
  taxID: '',
  incharge: '',
  cell: '',
  desc: '',
  addre: '',
  park: ''
})

const onSubmit = () => {
  console.log('submit!')
}
const avatarImageUrl = ref('')
const dialogVisible = ref(false)

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

<style lang="scss">
.hw {
  width: 580px;
  height: 100%;
  padding: 10px;
}
.el-input {
  width: 80%;
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
  line-height: 1;
}
:root {
  .--el-input-width {
    width: 80%;
  }
}
</style>
