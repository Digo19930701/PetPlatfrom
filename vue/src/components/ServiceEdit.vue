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
      <el-alert class="alertInf" type="info" show-icon :closable="false">
        <!-- 還沒寫這個邏輯 -->
        <p>一旦建立服務，類別將無法再透過編輯更改。(要寫編輯時disable)</p>
        </el-alert>
    </el-form-item>

    <el-form-item label="服務描述" prop="desc">
      <el-input v-model="ruleForm.desc"
                type="textarea"
                placeholder="服務內容詳細描述"
                autosize
       />
    </el-form-item>

    <div class="tag-cloud subtitle">銷售資訊</div>
    <!-- 要處理驗證三個項目, 重置不會重置petType -->
    <!-- 各規格值如果要各自獨立,驗證就會失靈 (我很頭痛直接不驗) -->
    <!-- "+ 規格"的按鍵到上限值要disable(但我無法達成),目前控制數量的部分由specCounter決定 -->
    <el-form-item label="服務對象與規格" required>
              <el-button
                color="#666666"
                @click="addDomain"
                plain round 
                :disabled="specCounter===4">+ 規格</el-button>
    </el-form-item>

    <el-form-item
      v-for="(domain, index) in dynamicValidateForm.domains"
      :key="domain.key"
      :label="'規格' + (index+1)"
      :prop="'domains.' + index + '.petType'"
    >
      <el-form-item >
        <el-col :span="8">
          <el-form-item >
            <el-select 
              v-model="domain.petType"
              placeholder="請選擇"
              style="width: auto"
            >
              <el-option label="貓" value="cat" />
              <el-option label="狗" value="dog" />
            </el-select>
          </el-form-item>
        </el-col>
        <el-col class="text-center" :span="7">
          <el-form-item>
            <el-input v-model="domain.spec" 
              placeholder="規格名(例如:大型犬)"
              maxlength="5"
            />
          </el-form-item>
        </el-col>
        <el-col :span="1">&nbsp</el-col>
        <el-col :span="6">
          <el-form-item >
            <el-input style="width: auto"
              v-model="domain.price"
              placeholder="價格"
              :formatter="(value) => `NT$ ${value}`.replace(/\B(?=(\d{3})+(?!\d))/g, ',')"
              :parser="(value) => value.replace(/NT\$\s?|(,*)/g, '')"
            />
          </el-form-item>
        </el-col>
      </el-form-item>
      <el-button
        class="mt-2" 
        @click.prevent="removeDomain(domain)"
        color="#666666" 
        plain round
        style="margin: 16px 0px;"
      >
        刪除
      </el-button>
    </el-form-item>

    <el-form-item label="服務所需時間長" class="serviceTime">
      <el-input-number v-model="servicePeriod" :step="30" :min="30" :max="300" step-strictly />
      <p>分鐘</p>
    </el-form-item>

    <el-form-item label="同時段組數上限">
      <el-input-number v-model="upperLimit" :min="1" :max="99" @change="handleChange1" />
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
      <!-- required 可以檢查有沒有填但沒辦法檢查開始時間早於結束時間 -->
      <el-col :span="5" class="timeRange">
        <el-form-item prop="availTime1">
          <el-time-picker
            v-model="ruleForm.availTime1"
            placeholder="開始時間"
            format="HH:mm"
          />
        </el-form-item>
      </el-col>
      <el-col :span="1" style="text-align: center;">
        <p>~</p>
      </el-col>
      <el-col :span="5" class="timeRange">
        <el-form-item prop="availTime2">
          <el-time-picker 
            v-model="ruleForm.availTime2" 
            placeholder="結束時間"
            format="HH:mm"
          />
        </el-form-item>
      </el-col>
    </el-form-item>

    <el-form-item label="接受預約單位時間" class="serviceTime">
      <span>每&nbsp</span>
      <el-input-number v-model="ruleForm.acceptUnit" :step="30" :min="30" :max="servicePeriod" step-strictly />
      <p>分鐘為單位接受預約</p>
      <el-alert class="alertInf" type="info" show-icon :closable="false">
        <p>
          上限值由「服務所需時間長」決定。(感覺這邊有一個Q&A解釋會更好)
        </p>
      </el-alert>
    </el-form-item>

    <el-form-item label="最後接受預約時間" class="serviceTime">
      <span>服務開始前&nbsp</span>
      <el-input-number v-model="ruleForm.acceptDay1" :min="1" :max="ruleForm.acceptDay2-1" @change="handleChange1" />
      <p>日</p>
    </el-form-item>

    <el-form-item label="最早開放預約時間" class="serviceTime">
      <span>服務開始前&nbsp</span>
      <el-input-number v-model="ruleForm.acceptDay2" :min="ruleForm.acceptDay1+1" :max="90" @change="handleChange2" />
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
// (code很亂我很抱歉)
const dynamicValidateForm = reactive<{
  domains: DomainItem[]
}>({
  domains: [
    {
      key: 1,
      spec: '',
      petType: '',
      price: '',
    },
  ],
})

interface DomainItem {
  key: number
  spec: string
  petType: string
  price: string
}
const domainsRules = reactive<FormRules<DomainItem>>({
  spec: [
    {
      required: true,
      message: '請選擇一個項目',
      trigger: 'change',
    },
  ],
  petType: [
    {
      required: true,
      message: '請填寫規格',
      trigger: 'change',
    },
  ],
  price: [
    {
      required: true,
      message: '請填寫價格',
      trigger: 'change',
    },
  ],
})

let specCounter = ref(0);
const removeDomain = (item: DomainItem) => {
  const index = dynamicValidateForm.domains.indexOf(item)
  if (index !== -1) {
    dynamicValidateForm.domains.splice(index, 1)
  }
  specCounter.value--;
  console.log(specCounter.value)
}


const addDomain = () => {
  if (specCounter.value <4) {
    dynamicValidateForm.domains.push({
      key: Date.now(),
      spec: '',
      petType: '',
      price: '',
    })
    specCounter.value++;
    console.log(specCounter.value)
  } else{
    
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
  name: string
  category: string
  desc: string
  spec: string
  petType: string
  price: string
  type: string[]
  availTime1: string
  availTime2: string
  acceptUnit: number
  acceptDay1: number
  acceptDay2: number
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
  acceptUnit: 30,
  acceptDay1:  1,
  acceptDay2:  7,
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
  desc: [
    { required: true,
       message: '請輸入服務描述',
     trigger: 'blur' 
    }
  ],
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
.el-input-number {
  width: 120px;
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
