<!-- "美容","salon"  -->
<!-- "溝通","comm"(Communication) -->
<!-- "攝影","photog"(photography) -->
<!-- "褓姆/訓練","nanny" -->

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
          >
            <el-icon><Plus /></el-icon>
          </el-upload>

          <el-dialog v-model="dialogVisible" style="text-align: center;">
            <img :src="dialogImageUrl" alt="Preview Image" class="imgwd" />
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

        <el-form-item
          label="服務類別"
          prop="category"
          :rules="[
            {
              type: 'array',
              required: true,
              message: '至少要勾選一個類別',
              trigger: 'change'
            }
          ]"
        >
          <el-checkbox-group v-model="form.category">
            <el-checkbox label="美容" value="salon" size="large" />
            <el-checkbox label="溝通" value="comm" size="large" />
            <el-checkbox label="攝影" value="photog" size="large" />
            <el-checkbox label="保母/訓練" value="nanny" size="large" />
          </el-checkbox-group>
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
import type { UploadProps } from 'element-plus'
import {  Plus } from '@element-plus/icons-vue'

// test
// do not use same name with ref
const form = reactive({
  name: '',
  category: [],
  cell: '',
  desc: '',
  addre: '',
  park: ''
})

const onSubmit = () => {
  console.log('submit!')
}
const dialogImageUrl = ref('')
const dialogVisible = ref(false)


const handleRemove: UploadProps['onRemove'] = (uploadFile, uploadFiles) => {
  console.log(uploadFile, uploadFiles)
}

const handlePictureCardPreview: UploadProps['onPreview'] = (uploadFile) => {
  dialogImageUrl.value = uploadFile.url!
  dialogVisible.value = true
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
.imgwd{
  max-width: 600px;
  max-height: 800px;
}
:root {
  .--el-input-width {
    width: 80%;
  }
}
</style>
