<template>
  <el-scrollbar class="pet">
    <div class="petinformation">
      <div style="margin-bottom: 20px">
        <el-button size="small" @click="addTab(editableTabsValue)"> 新增寵物 </el-button>
      </div>
      <el-tabs v-model="editableTabsValue" type="card" class="demo-tabs" closable @tab-remove="removeTab">
        <el-tab-pane v-for="item in editableTabs" :key="item.name" :label="item.title" :name="item.name">
          <el-form>
            <el-form-item>
              <el-upload class="avatar-uploader" action="https://run.mocky.io/v3/9d059bf9-4660-45f2-925d-ce80ad6c4d15"
                :show-file-list="false" :on-success="handleAvatarSuccess" :before-upload="beforeAvatarUpload">
                <img v-if="imageUrl" :src="imageUrl" class="avatar" />
                <el-icon v-else class="avatar-uploader-icon">
                  <Plus />
                </el-icon>
              </el-upload>
              上傳頭像
            </el-form-item>
            <el-form-item label="姓名">
              <el-input size="small" v-model="petform.petName"></el-input>
            </el-form-item>
            <el-form-item label="性別" >
              <el-select class="m-3" placeholder="Select" v-model="petform.petGender"  >
                <el-option v-for="item in gender" :key="item.value" :label="item.label" :value="item.value" />
              </el-select>
            </el-form-item>
            <el-form-item label="類別" >
              <el-select class="m-2" placeholder="Select" v-model="petform.petClass">
                <el-option v-for="item in Species" :key="item.value" :label="item.label" :value="item.value" />
              </el-select>
            </el-form-item>
            <el-form-item label="品種"><el-input size="small" v-model="petform.variety"></el-input></el-form-item>

            <el-form-item label="個性">
              <el-select class="m-1" placeholder="Select" v-model="petform.personAlity">
                <el-option  v-for="item in personality" :key="item.value" :label="item.label" :value="item.value"  />
              </el-select>
            </el-form-item>
            <el-form-item label="年紀"><el-input size="small" v-model="petform.petAge"></el-input></el-form-item>
            <el-form-item label="晶片號碼"><el-input size="small" v-model="petform.petId"></el-input></el-form-item>

          </el-form>
        </el-tab-pane>
      </el-tabs>
      <span>
      <el-button class="button" @click="confirm()">確認</el-button>
      <el-button class="button">取消</el-button>
    </span>
    </div>
    
  </el-scrollbar>
</template>
<script lang="ts" setup>
import { ref,watch } from 'vue'

let tabIndex = 2
const editableTabsValue = ref('1')
const editableTabs = ref([
  {
    title: '寵物 1',
    name: '1',
    content: 'Tab 1 content'
  },
  {
    title: '寵物 2',
    name: '2',
    content: 'Tab 2 content'
  }
])

const petform = ref({
  petName: '',
  variety: '',
  petId: '',
  petAge: '',
  personAlity:'',
  petClass:'',
  petGender:''
})

const confirm = () => {
  console.log("petform", petform)
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
  if(newQuestion != oldQuestion){
    petform.value.petName= '';
    petform.value.variety= '';
    petform.value.petId= '';
    petform.value.petAge= '';
    petform.value.personAlity='';
    petform.value.petClass='';
    imageUrl.value = '';
  }
})

import type { UploadProps } from 'element-plus'
import { ElMessage } from 'element-plus'
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
  },

]
</script>

<style lang="scss">
.petinformation {
  margin: 10px;
  height: 80vh;
  width: 50%;
}

.demo-tabs>.el-tabs__content {
  padding: 32px;
  color: #6b778c;
  font-size: 32px;
  font-weight: 600;
}

.avatar-uploader .avatar {
  width: 178px;
  height: 178px;
  display: block;
}

.pet {
  width: 100%;
}

.el-input{
  width: 300px;
}

</style>

<style>
.avatar-uploader .el-upload {
  border: 1px dashed var(--el-border-color);
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
  transition: var(--el-transition-duration-fast);
}

.avatar-uploader .el-upload:hover {
  border-color: var(--el-color-primary);
}

.el-icon.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  text-align: center;
}
</style>
