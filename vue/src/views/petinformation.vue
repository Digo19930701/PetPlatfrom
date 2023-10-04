<template>
  <header><UserHeadBar /></header>
  <main style="background: #f8f4da">
    <el-container>
      <el-aside>
        <UserSideBar />
      </el-aside>
      <main style="width: 100%; height: 100%">
        <br />
        <header>
          <h2 style="color: #888888; font-weight: bolder">寵物資訊</h2>
        </header>
        <div class="petinformation base">
          <div style="margin-bottom: 20px">
            <el-button size="medium" type="primary" plain @click="addTab(editableTabsValue)">
              新增寵物
            </el-button>
          </div>
          <el-tabs
            v-model="editableTabsValue"
            type="card"
            class="demo-tabs"
            closable
            @tab-remove="removeTab"
          >
            <el-tab-pane
              v-for="item in editableTabs"
              :key="item.name"
              :label="item.title"
              :name="item.name"
            >
              <el-form label-width="150px">
                <el-form-item label="上傳寵物頭像">
                  <el-upload
                    action=""
                    list-type="picture-card"
                    :on-preview="handlePictureCardPreview"
                    :on-remove="handleRemove"
                    :auto-upload="false"
                    :limit="1"
                    :on-exceed="HandlePet"
                  >
                    <el-icon><Plus /></el-icon>
                  </el-upload>

                  <el-dialog v-model="dialogVisible" style="text-align: center">
                    <img :src="petImageUrl" alt="Preview Image" class="imgwd" />
                  </el-dialog>
                </el-form-item>
                <el-form-item
                  label="寵物名"
                  prop="petName"
                  :rules="[{ required: true, message: '此為必填欄位' }]"
                >
                  <el-input size="small" v-model="petform.petName"></el-input>
                </el-form-item>
                <el-form-item
                  label="性別"
                  prop="petGender"
                  :rules="[{ required: true, message: '此為必選欄位', trigger: 'change' }]"
                >
                  <el-select class="m-3" placeholder="Select" v-model="petform.petGender">
                    <el-option
                      v-for="item in gender"
                      :key="item.value"
                      :label="item.label"
                      :value="item.value"
                    />
                  </el-select>
                </el-form-item>
                <el-form-item
                  label="類別"
                  prop="petClass"
                  :rules="[{ required: true, message: '此為必選欄位', trigger: 'change' }]"
                >
                  <el-select class="m-2" placeholder="Select" v-model="petform.petClass">
                    <el-option
                      v-for="item in Species"
                      :key="item.value"
                      :label="item.label"
                      :value="item.value"
                    />
                  </el-select>
                </el-form-item>
                <el-form-item
                  label="品種"
                  prop="variety"
                  :rules="[{ required: true, message: '此為必填欄位' }]"
                >
                  <el-input size="small" v-model="petform.variety"></el-input>
                </el-form-item>

                <el-form-item
                  label="個性"
                  prop="personAlity"
                  :rules="[{ required: true, message: '此為必選欄位', trigger: 'change' }]"
                >
                  <el-select class="m-1" placeholder="Select" v-model="petform.personAlity">
                    <el-option
                      v-for="item in personality"
                      :key="item.value"
                      :label="item.label"
                      :value="item.value"
                    />
                  </el-select>
                </el-form-item>
                <el-form-item
                  label="年紀"
                  prop="petAge"
                  :rules="[{ required: true, message: '此為必填欄位' }]"
                >
                  <el-input size="small" v-model="petform.petAge"></el-input>
                </el-form-item>
                <el-form-item
                  label="晶片號碼"
                  prop="petId"
                  :rules="[{ required: true, message: '此為必填欄位' }]"
                >
                  <el-input size="small" v-model="petform.petId"></el-input>
                </el-form-item>
              </el-form>
            </el-tab-pane>
          </el-tabs>
        </div>
        <br />
        <span style="padding-left: 25%">
          <el-button type="primary" @click="confirm()">確認</el-button>
          <el-button type="primary">取消</el-button>
        </span>
      </main>
    </el-container>
  </main>
  <br />
  <footer><FootBar /></footer>
</template>
<style src="../assets/default.css"></style>
<script lang="ts" setup>
import { ref, watch } from 'vue'
import UserHeadBar from '../components/UserHeadBar.vue'
import UserSideBar from '../components/UserSideBar.vue'
import FootBar from '../components/FootBar.vue'
import { ElNotification } from 'element-plus'

let tabIndex = 2
const editableTabsValue = ref('1')
const editableTabs = ref([
  {
    title: '寵物 A',
    name: '1',
    content: 'Tab 1 content'
  },
  {
    title: '寵物 B',
    name: '2',
    content: 'Tab 2 content'
  }
])

const petform = ref({
  petName: '',
  variety: '',
  petId: '',
  petAge: '',
  personAlity: '',
  petClass: '',
  petGender: ''
})

const confirm = () => {
  console.log('petform', petform)
  ElNotification({
    title: 'Success',
    message: '儲存成功',
    type: 'success',
    duration: 3000,
    offset: 100
  })
}

const addTab = (targetName: string) => {
  const newTabName = `${++tabIndex}`
  editableTabs.value.push({
    title: 'New Tab',
    name: newTabName,
    content: 'New Tab content'
  })
  editableTabsValue.value = newTabName
}
const removeTab = (targetName: string) => {
  const tabs = editableTabs.value
  let activeName = editableTabsValue.value
  if (activeName === targetName) {
    tabs.forEach((tab, index) => {
      if (tab.name === targetName) {
        const nextTab = tabs[index + 1] || tabs[index - 1]
        if (nextTab) {
          activeName = nextTab.name
        }
      }
    })
  }

  editableTabsValue.value = activeName
  editableTabs.value = tabs.filter((tab) => tab.name !== targetName)
}

watch(editableTabsValue, async (newQuestion, oldQuestion) => {
  if (newQuestion != oldQuestion) {
    petform.value.petName = ''
    petform.value.variety = ''
    petform.value.petId = ''
    petform.value.petAge = ''
    petform.value.personAlity = ''
    petform.value.petClass = ''
    petImageUrl.value = ''
  }
})

import type { UploadProps } from 'element-plus'
import { ElMessage } from 'element-plus'
import { Plus } from '@element-plus/icons-vue'
const petImageUrl = ref('')
const dialogVisible = ref(false)

const handleRemove: UploadProps['onRemove'] = (uploadFile, uploadFiles) => {
  console.log(uploadFile, uploadFiles)
}

const handlePictureCardPreview: UploadProps['onPreview'] = (uploadFile) => {
  petImageUrl.value = uploadFile.url!
  dialogVisible.value = true
}
function HandlePet() {
  ElMessage({
    message: '僅能上傳1張寵物頭像！',
    type: 'error',
    offset: 100
  })
}

const gender = [
  {
    value: '男生',
    label: '男生'
  },
  {
    value: '女生',
    label: '女生'
  }
]

const personality = [
  {
    value: '熱情',
    label: '熱情'
  },
  {
    value: '暴躁',
    label: '暴躁'
  },
  {
    value: '溫順',
    label: '溫順'
  },
  {
    value: '內向',
    label: '內向'
  },
  {
    value: '敏感',
    label: '敏感'
  }
]
const Species = [
  {
    value: '貓',
    label: '貓'
  },
  {
    value: '狗',
    label: '狗'
  }
]
</script>
<style src="../assets/default.css"></style>
<style lang="scss">
.petinformation {
  margin: 10px;
  height: 90%;
  width: 55%;
  min-width: 660px;
}

.demo-tabs > .el-tabs__content {
  padding: 32px;
  color: #6b778c;
  font-size: 32px;
  font-weight: 600;
  height: 100%;
}

.el-input {
  width: 80%;
}
</style>
