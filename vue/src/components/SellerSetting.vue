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
          <!-- ⚠ 要處理上傳的問題 ⚠ -->
          <el-upload
            class="avatar-uploader"
            action=""
            :show-file-list="false"
            :on-success="handleAvatarSuccess"
            :before-upload="beforeAvatarUpload"
          >
            <img v-if="imageUrl" :src="imageUrl" class="avatar" />
            <el-icon v-else class="avatar-uploader-icon">
              <Plus />
            </el-icon>

            <template #tip>
              <div class="el-upload__tip">jpg files with a size less than 2MB.</div>
            </template>
          </el-upload>
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
import { Plus } from '@element-plus/icons-vue'
import { ElMessage } from 'element-plus'
import type { UploadProps } from 'element-plus'

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
const imageUrl = ref('')

const handleAvatarSuccess: UploadProps['onSuccess'] = (response, uploadFile) => {
  imageUrl.value = URL.createObjectURL(uploadFile.raw!)
}

const beforeAvatarUpload: UploadProps['beforeUpload'] = (rawFile) => {
  if (rawFile.type !== 'image/jpeg') {
    ElMessage.error('Avatar picture must be JPG format!')
    return false
  } else if (rawFile.size / 1024 / 1024 > 2) {
    ElMessage.error('Avatar picture size can not exceed 2MB!')
    return false
  }
  return true
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
.avatar-uploader .avatar {
  width: 100px;
  height: 100px;
  display: block;
}
.avatar-uploader .el-upload {
  border: 1px dashed #666;
  border-radius: 100px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
  transition: var(--el-transition-duration-fast);
}

.avatar-uploader .el-upload:hover {
  border-color: var(--el-color-primary);
}

.el-icon.avatar-uploader-icon {
  font-size: 30px;
  color: #8c939d;
  width: 150px;
  height: 150px;
  text-align: center;
}
:root {
  .--el-input-width {
    width: 80%;
  }
}
</style>
