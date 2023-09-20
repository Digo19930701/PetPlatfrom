<!-- avail = available -->
<template>
  <el-form
    ref="ruleFormRef"
    :model="ruleForm"
    :rules="rules"
    label-width="120px"
    class="demo-ruleForm"
    :size="formSize"
    status-icon
  >
    <div class="tag-cloud subtitle">基本資訊</div>
    <el-form-item label="服務封面">
      <el-upload
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
    </el-form-item>

    <el-form-item label="服務描述" prop="desc">
      <el-input v-model="ruleForm.desc" type="textarea" placeholder="服務內容詳細描述" autosize />
    </el-form-item>

    <div class="tag-cloud subtitle">銷售資訊</div>
    <!-- 要處理驗證三個項目 -->
    <el-form-item label="服務對象與規格" required prop="spec">
      <div>
        <el-input v-model="ruleForm.spec" placeholder="規格 (例如:大型犬)">
          <template #prepend>
            <el-select v-model="ruleForm.petType" placeholder="請選擇" style="width: auto">
              <el-option label="貓" value="cat" />
              <el-option label="狗" value="dog" />
            </el-select>
          </template>
          <template #append>
            <!-- radius尚未處理 -->
            <el-input
              style="width: auto"
              v-model="ruleForm.price"
              placeholder="價格"
              :formatter="(value) => `NT$ ${value}`.replace(/\B(?=(\d{3})+(?!\d))/g, ',')"
              :parser="(value) => value.replace(/NT\$\s?|(,*)/g, '')"
            />
          </template>
        </el-input>
        <!-- 要處理新增規格的問題 -->
        <el-button color="#666666" plain round>+ 規格</el-button>
      </div>
    </el-form-item>

    <!-- 要檢查時間是否>0分鐘 -->
    <el-form-item label="服務所需時間長" class="serviceTime">
      <el-input-number v-model="num1" :min="0" :max="24" @change="handleChange1" />
      <p>小時</p>
      <el-input-number v-model="num2" :step="15" :min="0" :max="45" step-strictly />
      <p>分鐘</p>
    </el-form-item>

    <el-form-item label="同時段組數上限">
      <el-input-number v-model="num0" :min="1" :max="99" @change="handleChange1" />
      <el-alert class="alertInf" type="info" show-icon :closable="false">
        <p>此服務在同時段內可提供的數量。(不知道需不需要的說明，總之我先加了!)</p>
      </el-alert>
    </el-form-item>

    <div class="tag-cloud subtitle">預約資訊</div>
    <el-form-item label="可預約日" required prop="type">
      <el-checkbox-group v-model="ruleForm.type">
        <el-checkbox label="星期一" name="type" />
        <el-checkbox label="星期二" name="type" />
        <el-checkbox label="星期三" name="type" />
        <el-checkbox label="星期四" name="type" />
        <el-checkbox label="星期五" name="type" />
        <el-checkbox label="星期六" name="type" />
        <el-checkbox label="星期日" name="type" />
      </el-checkbox-group>
    </el-form-item>

    <el-form-item label="可預約時段" required>
      <!-- required 可以檢查有沒有填但沒辦法檢查時間 -->
      <el-col :span="5" class="timeRange">
        <el-form-item prop="availTime1">
          <el-time-picker v-model="ruleForm.availTime1" placeholder="開始時間" format="HH:mm" />
        </el-form-item>
      </el-col>
      <el-col :span="1" style="text-align: center">
        <p>~</p>
      </el-col>
      <el-col :span="5" class="timeRange">
        <el-form-item prop="availTime2">
          <el-time-picker v-model="ruleForm.availTime2" placeholder="結束時間" format="HH:mm" />
        </el-form-item>
      </el-col>
    </el-form-item>

    <!-- 檢查:服務開始前至少1小時前完成服務 -->
    <!-- 檢查:最晚接受預約服務時間 > 服務時間長度 -->
    <el-form-item label="最後接受預約時間" class="serviceTime">
      <span>服務開始前&nbsp</span>
      <el-input-number v-model="ruleForm.acceptDay1" :min="0" :max="30" @change="handleChange1" />
      <p>日</p>
      <el-input-number v-model="ruleForm.acceptHour1" :min="0" :max="23" @change="handleChange1" />
      <p>小時</p>
    </el-form-item>

    <!-- 檢查 最早開放預約時間 > 最晚開放預約時間 -->
    <el-form-item label="最早開放預約時間" class="serviceTime">
      <span>服務開始前&nbsp</span>
      <el-input-number v-model="ruleForm.acceptDay2" :min="1" :max="90" @change="handleChange1" />
      <p>日</p>
      <el-alert class="alertInf" type="info" show-icon :closable="false">
        <p>
          當最早開放預約時間為服務開始前1日，表12/31的服務需在12/30完成預約。(依照實際上寫的方式來做說明)
        </p>
      </el-alert>
    </el-form-item>

    <el-form-item>
      <el-button color="#F8D479" round @click="submitForm(ruleFormRef)">新增</el-button>
      <el-button round @click="resetForm(ruleFormRef)">重置</el-button>
    </el-form-item>
  </el-form>
</template>

<script lang="ts" setup>
import { reactive, ref } from 'vue'
import { ElMessage, type FormInstance, type FormRules, type UploadProps } from 'element-plus'
// import { Upload } from '@element-plus/icons-vue'
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
  name: string
  category: string
  desc: string
  spec: string
  petType: string
  price: string
  type: string[]
  availTime1: string
  availTime2: string
  acceptDay1: string
  acceptHour1: string
  acceptDay2: string
}

const formSize = ref('default')
const ruleFormRef = ref<FormInstance>()
const ruleForm = reactive<RuleForm>({
  name: '',
  category: '',
  desc: '',
  spec: '',
  petType: '',
  price: '',
  type: [],
  availTime1: '',
  availTime2: '',
  acceptDay1: '',
  acceptHour1: '',
  acceptDay2: ''
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
  spec: [
    {
      required: true,
      message: '請至少完成一個規格',
      trigger: 'change'
    }
  ],
  petType: [
    {
      required: true,
      message: '請至少完成一個規格',
      trigger: 'change'
    }
  ],
  price: [
    {
      required: true,
      message: '請至少完成一個規格',
      trigger: 'change'
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
  type: [
    {
      type: 'array',
      required: true,
      message: '請至少挑選一個預約日',
      trigger: 'change'
    }
  ]
  // acceptDay1: [
  //   {
  //     required: true,
  //     message: '請至少挑選一個預約日',
  //     trigger: 'change',
  //   },
  // ],
  // acceptHour1: [
  //   {
  //     required: true,
  //     message: '請至少挑選一個預約日',
  //     trigger: 'change',
  //   },
  // ],
  // acceptDay2: [
  //   {
  //     required: true,
  //     message: '請挑選...',
  //     trigger: 'change',
  //   },
  // ],
})

const submitForm = async (formEl: FormInstance | undefined) => {
  if (!formEl) return
  await formEl.validate((valid, fields) => {
    if (valid) {
      console.log('submit!')
    } else {
      console.log('error submit!', fields)
    }
  })
}

// 服務所需時間長
const num0 = ref(0)
const num1 = ref(1)
const num2 = ref(0)
const num3 = ref(0)
const num4 = ref(0)
const num5 = ref(1)

const handleChange1 = (value: number) => {
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
.el-input-number {
  width: 100px;
}
.serviceTime p {
  margin: 0px 10px;
}

.el-select .el-input {
  width: 150px;
}

.timeRange {
  // max-width: 20.8333333333%;
  max-width: 150px;
}
.alertInf {
  margin-top: 5px;
}
.imgwd {
  max-width: 600px;
  max-height: 800px;
}
</style>
