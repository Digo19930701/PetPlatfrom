<!-- avail = available -->
<template>
  <el-form
    ref="ruleFormRef"
    :model="ruleForm"
    :rules="rules"
    label-width="120px"
    class="demo-ruleForm"
    :size="formSize"
    scroll-to-error="true"
  >
    <div class="tag-cloud subtitle">基本資訊</div>
    <el-form-item label="服務封面">
      <el-upload
        v-model:file-list="ruleForm.file"
        action=""
        list-type="picture-card"
        :on-preview="handlePictureCardPreview"
        :on-remove="handleRemove"
        :auto-upload="false"
        :limit="1"
        :on-exceed="HandleCover"
      >
        <el-icon><Plus /></el-icon>
      </el-upload>
      <el-dialog v-model="dialogVisible" style="text-align: center">
        <img :src="coverImageUrl" alt="Preview Image" class="imgwd" />
      </el-dialog>
    </el-form-item>

    <el-form-item label="服務圖片">
      <el-upload
        v-model:file-list="ruleForm.fileList"
        action=""
        list-type="picture-card"
        :on-preview="handlePictureCardPreview"
        :on-remove="handleRemove"
        :auto-upload="false"
        :limit="4"
        :on-exceed="HandleService"
      >
        <el-icon><Plus /></el-icon>
      </el-upload>
      <el-dialog v-model="dialogVisible" style="text-align: center">
        <img :src="serviceImageUrl" alt="Preview Image" class="imgwd" />
      </el-dialog>
    </el-form-item>

    <el-form-item label="服務名稱" prop="name">
      <el-input
        v-model="ruleForm.name"
        maxlength="20"
        placeholder="請輸入"
        show-word-limit
        type="text"
      />
    </el-form-item>

    <el-form-item label="服務類別" prop="category">
      <el-select v-model="ruleForm.category" placeholder="請選擇">
        <el-option label="美容" value="beauty" />
        <el-option label="溝通" value="whisperer" />
        <el-option label="攝影" value="graphy" />
        <el-option label="保母/訓練" value="nannyTraining" />
      </el-select>
      <!-- 還沒寫這個邏輯(要寫編輯時disable) -->
      <!-- <el-alert class="alertInf" type="info" show-icon :closable="false">
        <p>一旦建立服務，類別將無法再透過編輯更改。</p>
      </el-alert> -->
    </el-form-item>

    <el-form-item label="服務描述" prop="desc">
      <el-input v-model="ruleForm.desc" type="textarea" placeholder="服務內容詳細描述" autosize />
    </el-form-item>

    <div class="tag-cloud subtitle">銷售資訊</div>
    <el-form-item label="服務對象與規格" required>
      <el-button color="#666666" @click="addDomain" plain round :disabled="specCounter === 4"
        >+ 規格</el-button
      >
    </el-form-item>

    <el-form-item
      v-for="(domain, index) in ruleForm.domains"
      :key="domain.key"
      :label="'規格' + (index + 1)"
    >
      <el-form-item>
        <el-col :span="5">
          <el-form-item
            :prop="'domains.' + index + '.petType'"
            :rules="{
              required: true,
              message: '請選擇對象',
              trigger: 'change'
            }"
          >
            <el-select v-model="domain.petType" placeholder="請選擇">
              <el-option label="貓" value="cat" />
              <el-option label="狗" value="dog" />
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="1"></el-col>
        <el-col class="text-center" :span="6">
          <el-form-item
            :prop="'domains.' + index + '.spec'"
            :rules="{
              required: true,
              message: '請命名此規格',
              trigger: 'blur'
            }"
          >
            <el-input v-model="domain.spec" placeholder="例:大型犬" maxlength="5" />
          </el-form-item>
        </el-col>
        <el-col :span="2" style="text-align: end">&nbspNT$</el-col>
        <el-col :span="7">
          <el-form-item
            status-icon="false"
            :prop="'domains.' + index + '.price'"
            :rules="{
              required: true,
              type: 'number',
              message: '請輸入價格'
            }"
          >
            <el-input-number style="min-width: 130px" v-model="domain.price" placeholder="價格" />
          </el-form-item>
        </el-col>
        <el-col :span="1"></el-col>
      </el-form-item>
      <el-button
        class="mt-2"
        @click.prevent="removeDomain(domain)"
        color="#666666"
        plain
        round
        :disabled="specCounter === 0"
        style="margin: 16px 0px"
      >
        刪除
      </el-button>
    </el-form-item>

    <el-form-item label="服務所需時間長" prop="servicePeriod" class="serviceTime">
      <el-input-number
        v-model="ruleForm.servicePeriod"
        :step="30"
        :min="30"
        :max="300"
        step-strictly
      />
      <p>分鐘</p>
    </el-form-item>

    <el-form-item label="同時段組數上限" prop="upperLimit">
      <el-input-number v-model="ruleForm.upperLimit" :min="1" :max="99" @change="handleChange1" />
      <el-alert class="alertInf" type="info" show-icon :closable="false">
        <p>此服務在同時段內可提供的數量。</p>
      </el-alert>
    </el-form-item>

    <div class="tag-cloud subtitle">預約資訊</div>
    <el-form-item label="可預約日" prop="availDay">
      <el-checkbox-group v-model="ruleForm.availDay">
        <el-checkbox label="星期一" name="availDay" />
        <el-checkbox label="星期二" name="availDay" />
        <el-checkbox label="星期三" name="availDay" />
        <el-checkbox label="星期四" name="availDay" />
        <el-checkbox label="星期五" name="availDay" />
        <el-checkbox label="星期六" name="availDay" />
        <el-checkbox label="星期日" name="availDay" />
      </el-checkbox-group>
    </el-form-item>

    <el-form-item label="可預約時段" required>
      <!-- required 可以檢查有沒有填但沒辦法檢查開始時間早於結束時間 -->

      <el-col :span="5" class="timeRange">
        <el-form-item prop="availTime1">
          <el-time-picker v-model="ruleForm.availTime1" placeholder="開始時間" format="HH:mm" />
          <!-- <el-time-select
            v-model="ruleForm.availTime1"
            :max-time="endTime"
            placeholder="開始時間"
            start="08:00"
            step="00:30"
            end="17:00"
          /> -->
        </el-form-item>
      </el-col>
      <el-col :span="1" style="text-align: center">
        <p>~</p>
      </el-col>
      <el-col :span="5" class="timeRange">
        <el-form-item prop="availTime2">
          <el-time-picker v-model="ruleForm.availTime2" placeholder="結束時間" format="HH:mm" />
          <!-- <el-time-select
            v-model="ruleForm.availTime2"
            :min-time="startTime"
            placeholder="結束時間"
            start="08:00"
            step="00:30"
            end="17:00"
          /> -->
        </el-form-item>
      </el-col>

    </el-form-item>
    <el-form-item label="接受預約時間" class="serviceTime" required>
      <el-form-item prop="acceptDay1">
        <span>服務開始前&nbsp</span>
        <el-input-number
          v-model="ruleForm.acceptDay1"
          :min="1"
          :max="ruleForm.acceptDay2 - 1"
          @change="handleChange1"
        />
        <span>&nbsp~&nbsp</span>
      </el-form-item>
      <el-form-item prop="acceptDay2">
        <el-input-number
          v-model="ruleForm.acceptDay2"
          :min="ruleForm.acceptDay1 + 1"
          :max="90"
          @change="handleChange2"
        />
        <p>日</p>
      </el-form-item>
      <el-alert class="alertInf" type="info" show-icon :closable="false">
        <p>接受預約時間必須至少相差1天。</p>
      </el-alert>
    </el-form-item>
    <br />
    <el-form-item>
      <div style="width: 200px"></div>
      <el-button color="#F8D479" round @click="submitForm(ruleFormRef)">新增</el-button>
      <el-button round @click="resetForm(ruleFormRef)">重置</el-button>
    </el-form-item>
  </el-form>
</template>

<script lang="ts" setup>
import { reactive, ref } from 'vue'
import { ElMessage } from 'element-plus'
import type { FormInstance, FormRules, UploadProps, UploadUserFile } from 'element-plus'
import { Plus } from '@element-plus/icons-vue'

const coverImageUrl = ref('') //封面圖
const serviceImageUrl = ref('') //服務圖片
const dialogVisible = ref(false)

function HandleCover() {
  ElMessage({
    message: '最多只能上傳1張封面圖！',
    type: 'error',
    offset: 100
    // 偏離上面多少距離，有被其他元件擋住時可以調整顯示的位置
  })
}
function HandleService() {
  ElMessage({
    message: '最多只能上傳4張服務圖片！',
    type: 'error',
    offset: 100
  })
}

let specCounter = ref(0)
const removeDomain = (item: DomainItem) => {
  const index = ruleForm.domains.indexOf(item)
  if (index !== -1 && specCounter.value > 0) {
    ruleForm.domains.splice(index, 1)
    specCounter.value--
  }
}

const addDomain = () => {
  if (specCounter.value < 4) {
    ruleForm.domains.push({
      key: Date.now(),
      spec: '',
      petType: '',
      price: 100
    })
    specCounter.value++
  }
}

const handleRemove: UploadProps['onRemove'] = (uploadFile, uploadFiles) => {
  console.log(uploadFile, uploadFiles)
}


const handlePictureCardPreview: UploadProps['onPreview'] = (uploadFile) => {
  coverImageUrl.value = uploadFile.url!
  serviceImageUrl.value = uploadFile.url!
  dialogVisible.value = true
  console.log('onPreview')
}

interface RuleForm {
  file: FileList[]
  fileList: FileList[]
  name: string
  category: string
  desc: string
  domains: DomainItem[]
  servicePeriod: number
  upperLimit: number
  availDay: string[]
  availTime1: string
  availTime2: string
  acceptUnit: number
  acceptDay1: number
  acceptDay2: number
}

interface DomainItem {
  key: number
  spec: string
  petType: string
  price: number
}
interface FileList {
  key: number
  url: string
}
const props = defineProps({
  serviceName: {
    type:String,
    default: ''
  },
  serviceId: String,
  sellerId: String,
  category:{
    type:String,
    default: ''
  },
  serviceDesc: {
    type:String,
    default: ''
  },
  servicePeriod: {
    type: Number,
    default: 60
  },
  upperLimit: {
    type: Number,
    default: 1
  },
  availTime1: {
    type: String,
    default: 'Thu Oct 05 2023 09:00:00 GMT+0800 (台北標準時間)'
  },
  availTime2: {
    type: String,
    default: 'Thu Oct 05 2023 20:00:00 GMT+0800 (台北標準時間)'
  },
  acceptDay1: {
    type: Number,
    default: 1
  },
  acceptDay2: {
    type: Number,
    default: 30
  },
  serviceCover: {
    type: Array<FileList>,
    default: []
  },
  serviceImage: {
    type: Array<FileList>,
    default: []
  }
})
// const startTime = ref('')
// const endTime = ref('')
const formSize = ref('default')
const ruleFormRef = ref<FormInstance>()
const ruleForm = reactive<RuleForm>({
  file: props.serviceCover,
  // {key:1, url:'https://media.istockphoto.com/id/1331301152/photo/photo-in-motion-running-beautiful-golden-retriever-dog-have-a-walk-outdoors-in-the-park.jpg?s=1024x1024&w=is&k=20&c=JZ6x5NMk_sTZwQAs2iR3MUr6JfEmjqszXIBrv2HAOB8='}
  fileList: props.serviceImage,
  name: props.serviceName,
  category: props.category,
  desc: props.serviceDesc,
  servicePeriod: props.servicePeriod,
  upperLimit: props.upperLimit,
  domains: [{ key: 1, spec: '', petType: '', price: 100 }],
  availDay: [],
  availTime1: props.availTime1,
  availTime2: props.availTime2,
  acceptUnit: 30,
  acceptDay1: props.acceptDay1,
  acceptDay2: props.acceptDay2
})


const rules = reactive<FormRules<RuleForm>>({
  name: [
    { required: true, message: '請輸入服務名稱', trigger: 'blur' },
    { min: 3, max: 20, message: '限輸入3~20字', trigger: 'blur' }
  ],
  category: [
    {
      required: true,
      message: '請選擇服務類別',
      trigger: 'change'
    }
  ],
  desc: [{ required: true, message: '請輸入服務描述', trigger: 'blur' }],
  servicePeriod: [
    {
      required: true,
      type: 'number',
      message: '必填項目'
    }
  ],
  upperLimit: [
    {
      required: true,
      type: 'number',
      message: '必填項目'
    }
  ],
  availTime1: [
    {
      type: 'date',
      required: true,
      message: '請挑選時間',
      trigger: 'change'
    }
  ],
  availTime2: [
    {
      type: 'date',
      required: true,
      message: '請挑選時間',
      trigger: 'change'
    }
  ],
  availDay: [
    {
      type: 'array',
      required: true,
      message: '請至少挑選一個預約日',
      trigger: 'change'
    }
  ],
  acceptDay1: [
    {
      required: true,
      type: 'number',
      message: '必填項目'
    }
  ],
  acceptDay2: [
    {
      required: true,
      type: 'number',
      message: '必填項目'
    }
  ]
})

const submitForm = async (formEl: FormInstance | undefined) => {
  if (!formEl) return
  await formEl.validate((valid, fields) => {
    if (valid) {
      console.log('submit!')
      console.log(`ruleForm.domains.length= ${ruleForm.domains.length}`)
      console.log(`
        serviceName= ${ruleForm.name},
        category= ${ruleForm.category},
        serviceDesc= ${ruleForm.desc},
        servicePeriod= ${ruleForm.servicePeriod},
        upperLimit= ${ruleForm.upperLimit},
        availDay= ${ruleForm.availDay},
        availTime1= ${ruleForm.availTime1},
        availTime2= ${ruleForm.availTime2},
        acceptUnit= ${ruleForm.acceptUnit},
        acceptDay1= ${ruleForm.acceptDay1},
        acceptDay2= ${ruleForm.acceptDay2},
        serviceCover.key= ${ruleForm.file[0].key},
        serviceCover.url= ${ruleForm.file[0].url}
        `)
      for(var i = 0; i< ruleForm.domains.length; i++){
        console.log(`
          domains.petType= ${ruleForm.domains[i].petType},
          domains.spec= ${ruleForm.domains[i].spec},
          domains.price= ${ruleForm.domains[i].price},
        `)
      }
      for(var i = 0; i< ruleForm.fileList.length; i++){
        console.log(`
          serviceImage.key= ${ruleForm.fileList[i].key},
          serviceImage.url= ${ruleForm.fileList[i].url}
        `)
          
      }
    } else {
      console.log('error submit!', fields)
    }
  })
}

// 服務所需時間長
const upperLimit = ref(0)
const servicePeriod = ref(60)

const handleChange1 = (value: number) => {
  console.log(value)
}
const handleChange2 = (value: number) => {
  console.log(value)
}

const resetForm = (formEl: FormInstance | undefined) => {
  if (!formEl) return
  formEl.resetFields()
}

const options = Array.from({ length: 10000 }).map((_, idx) => ({
  value: `${idx + 1}`,
  label: `${idx + 1}`
}))
</script>

<style lang="scss">
.el-form {
  width: 90%;
}
.el-form-item__label {
  width: 130px !important;
}
.el-input-group__append {
  padding: 0;
}
.serviceTime p {
  margin: 0px 10px;
}

.el-select .el-input {
  min-width: 90px;
}

.timeRange {
  max-width: 150px;
}
.alertInf {
  margin-top: 15px;
  padding: 0px 16px;
}
.imgwd {
  max-width: 600px;
  max-height: 800px;
}
</style>
