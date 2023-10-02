<template>
  <div class="hw">
    <header>
      <h2>銀行帳號</h2>
    </header>
    <br />
    <main>
      <div class="bankcard-display">
        <div class="bankcard-area">
          <div class="bankcard" @click="BankAccoutDetail = true">
            <div class="card-head">
              <span class="bankname">國泰世華商業銀行</span>
            </div>
            <div class="card-body">
              <div class="bank-num">*******1554</div>
              <div class="account-area">
                <div class="account-name">C***W***</div>
                <div class="default-pos">
                  <div class="default-mark" v-if="nowDefault">預設</div>
                </div>
              </div>
            </div>
          </div>
        </div>

        <div class="bankcard-area">
          <div class="bankcard" @click="BankAccoutDetail = true">
            <div class="card-head">
              <span class="bankname">台新國際商業銀行</span>
            </div>
            <div class="card-body">
              <div class="bank-num">*******6874</div>
              <div class="account-area">
                <div class="account-name">C***W***</div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div style="padding: 10px">
        <div class="add-bankcard" text @click="addBankAccout = true">
          <div class="addicon">
            <el-icon size="30" color="#888"><Plus /></el-icon>
          </div>
          <div class="create">新增銀行帳號</div>
        </div>
      </div>
    </main>
  </div>

  <!-- 新增銀行帳號畫面 -->
  <el-dialog v-model="addBankAccout" title="新增銀行帳號" width="35%" align-center>
    <el-form :model="form" hide-required-asterisk="false">
      <el-form-item
        label="真實姓名"
        :label-width="formLabelWidth"
        prop="name"
        :rules="[{ required: true, message: '*此欄不能為空' }]"
      >
        <el-input v-model="form.name" autocomplete="off" />
      </el-form-item>
      <el-form-item
        label="身分證字號"
        :label-width="formLabelWidth"
        prop="id"
        :rules="[{ required: true, message: '*此欄不能為空' }]"
      >
        <el-input v-model="form.id" autocomplete="off" />
      </el-form-item>
      <el-form-item
        label="銀行名稱"
        :label-width="formLabelWidth"
        prop="bank"
        :rules="[{ required: true, message: '*請選擇您的銀行', trigger: 'change' }]"
      >
        <el-select v-model="form.bank" placeholder="請選擇銀行" placement="right-start">
          <el-scrollbar>
            <el-option label="中國信託商業銀行" value="822" />
            <el-option label="中垂郵政股份有限公司" value="700" />
            <el-option label="臺灣銀行" value="004" />
            <el-option label="國泰世華商業銀行" value="013" />
            <el-option label="永豐商業銀行" value="807" />
            <el-option label="渣打國際商業銀行" value="052" />
            <el-option label="玉山商業銀行" value="808" />
            <el-option label="兆豐國際商業銀行" value="017" />
            <el-option label="匯豐（台灣）商業銀行" value="081" />
            <el-option label="台北冨邦商業銀行" value="012" />
            <el-option label="台新國際商業銀行" value="812" />
            <el-option label="合作金庫商業銀行" value="006" />
          </el-scrollbar>
        </el-select>
      </el-form-item>
      <el-form-item
        label="地區"
        :label-width="formLabelWidth"
        prop="region"
        :rules="[{ required: true, message: '*此欄不能為空' }]"
      >
        <el-input v-model="form.region" autocomplete="off" />
      </el-form-item>
      <el-form-item
        label="分行名稱"
        :label-width="formLabelWidth"
        prop="branch"
        :rules="[{ required: true, message: '*此欄不能為空' }]"
      >
        <el-input v-model="form.branch" autocomplete="off" />
      </el-form-item>
      <el-form-item
        label="銀行戶名"
        :label-width="formLabelWidth"
        prop="accountName"
        :rules="[{ required: true, message: '*此欄不能為空' }]"
      >
        <el-input v-model="form.accountName" autocomplete="off" />
      </el-form-item>
      <el-form-item
        label="銀行帳號"
        :label-width="formLabelWidth"
        prop="accountNum"
        :rules="[{ required: true, message: '*此欄不能為空' }]"
      >
        <el-input v-model="form.accountNum" autocomplete="off" />
      </el-form-item>
      <el-form-item>
        <span class="statement">
          * 提醒你，身份證字號/統一編號須與銀行帳號資訊一致，否則可能會影響日後撥款權益
        </span>
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="addBankAccout = false">取消</el-button>
        <el-button type="primary" @click="addBankAccout = false"> 新增 </el-button>
      </span>
    </template>
  </el-dialog>

  <!-- 銀行帳號詳情畫面 -->
  <el-dialog v-model="BankAccoutDetail" title="銀行帳號" :width="minWidth" align-center>
    <el-form :model="form" label-width="120px">
      <el-form-item prop="name" label="真實姓名">XXX</el-form-item>
      <el-form-item prop="id" label="身分證字號">L12345678</el-form-item>
      <el-form-item prop="bank" label="銀行名稱">國泰世華商業銀行</el-form-item>
      <el-form-item prop="region" label="地區">台中市</el-form-item>
      <el-form-item prop="branch" label="分行名稱">台中分行</el-form-item>
      <el-form-item prop="accountName" label="銀行戶名">Caee Waee</el-form-item>
      <el-form-item prop="accountNum" label="銀行帳號">******1554</el-form-item>
    </el-form>
    <template #footer>
      <el-row class="row" align="middle">
        *設為預設帳號&emsp;
        <el-switch v-model="defaultOrnot" @click="setting()" />
      </el-row>
      <span class="dialog-footer">
        <div class="left-bn">
          <el-button :disabled="enable">刪除</el-button>
        </div>
        <el-button @click="BankAccoutDetail = false">關閉</el-button>
        <el-button type="primary" @click="handleSave()">儲存</el-button>
      </span>
    </template>
  </el-dialog>
</template>

<script lang="ts" setup>
import { Plus } from '@element-plus/icons-vue'
import { reactive, ref } from 'vue'

const addBankAccout = ref(false) //新增帳號的畫面
const BankAccoutDetail = ref(false) //預設的畫面
const defaultOrnot = ref(true) //更改為預設帳號的值
const enable = ref(true) //決定儲存按鈕是否被按
const formLabelWidth = '140px'
const minWidth = '400px'
const nowDefault = ref(true) //顯示預設標誌

const form = reactive({
  name: '',
  id: '',
  bank: '',
  region: '',
  branch: '',
  accountName: '',
  accountNum: ''
})

//是否設為預設帳號要執行的動作
const setting = () => {
  if (defaultOrnot.value == true) {
    enable.value = true
  } else {
    enable.value = false
  }
}

//按下儲存按鈕要執行的動作
function handleSave() {
  if (defaultOrnot.value == true) {
    nowDefault.value = true
  } else {
    nowDefault.value = false
  }
  BankAccoutDetail.value = false
}
</script>

<style lang="scss" scoped>
h2 {
  color: #888888;
  font-weight: bolder;
  padding-left: 10px;
}

.hw {
  height: 80%;
  min-width: 660px;
  min-height: 300px;
}
.bankcard-display {
  display: flex;
}
.create {
  text-align: center;
  line-height: 1;
  height: 24px;
}
.addicon {
  text-align: center;
  padding-top: 40px;
}

.statement {
  width: 80%;
  font-size: small;
  font-weight: 600;
  color: #888888;
  line-height: 20px;
  padding-left: 75px;
}
.footer {
  margin: 20px;
}
.left-bn {
  float: left;
}

.el-select {
  width: 80%;
}
.el-input {
  width: 80%;
}
.el-scrollbar {
  height: 300px;
}
.el-scrollbar ::v-deep .el-scrollbar__wrap {
  overflow-y: scroll;
  overflow-x: hidden;
}

.row {
  font-size: medium;
  color: #666;
  font-weight: 600;

  padding-left: 15px;
}
</style>
