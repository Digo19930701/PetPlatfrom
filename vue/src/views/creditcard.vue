<template>
    <div class="base hw">
      <header>
        <h2>銀行帳號</h2>
      </header>
      <br />
      <main>
        <div class="bankcard-display">
          <div class="bankcard-area">
            <div class="bankcard">
              <div class="card-head">
                <span class="bankname">國泰世華商業銀行</span>
              </div>
              <div class="card-body">
                <div class="bank-num">*******1554</div>
                <div class="account-area">
                  <div class="account-name">C***W***</div>
                  <div class="default-pos">
                    <div class="default-mark">預設</div>
                  </div>
                </div>
              </div>
            </div>
          </div>
  
          <div class="bankcard-area">
            <div class="bankcard">
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
          <div class="add-bankcard">
            <div class="button">
              <el-button text @click="addBankAccout = true">
                <el-icon size="30" color="#888"><Plus /></el-icon>
              </el-button>
            </div>
            <div class="create">新增銀行帳號</div>
          </div>
        </div>
      </main>
    </div>
  
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
        <el-form-item label="銀行名稱" :label-width="formLabelWidth">
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
          <el-button type="warning" @click="addBankAccout = false"> 新增 </el-button>
        </span>
      </template>
    </el-dialog>
  </template>
  
  <script lang="ts" setup>
  import { Plus } from '@element-plus/icons-vue'
  import { reactive, ref } from 'vue'
  
  const addBankAccout = ref(false)
  const formLabelWidth = '140px'
  
  const form = reactive({
    name: '',
    id: '',
    bank: '',
    region: '',
    branch: '',
    accountName: '',
    accountNum: ''
  })
  </script>
  
  <style lang="scss" scoped>
  h2 {
    color: #888888;
    font-weight: bolder;
    padding-left: 10px;
  }
  
  .hw {
    width: 60%;
    height: 100%;
    min-width: 600px;
    min-height: 300px;
  }
  .bankcard-display {
    display: flex;
  }
  .create {
    text-align: center;
    color: #8c8c8c;
    line-height: 1;
    height: 24px;
  }
  .button {
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


  .bankcard-area {
  justify-content: center;
  padding: 10px;
}
.bankcard {
  width: 300px;
  height: 150px;
  border-radius: 20px;
  border: 1px solid #888;
  background: rgba(217, 217, 217, 0.35);
  box-shadow: 1px 1px 5px lightgray;
  cursor: pointer;
}
.add-bankcard {
  width: 300px;
  height: 150px;
  border-radius: 20px;
  border: 2px dashed #888;
  background: #fff;
  padding: 10px;
  cursor: pointer;
}
.card-head {
  border-radius: 20px 20px 0px 0px;
  background: #f8d479;
  position: relative;
  padding: 10px;
  height: 50px;
}
.bankname {
  color: #888;
  font-size: large;
  font-weight: 600;
  padding-left: 25px;
}
.card-body {
  width: 300;
  height: 100px;
}
.bank-num {
  height: 50%;
  color: black;
  font-size: x-large;
  font-weight: 600;
  padding-top: 10px;
  padding-left: 50px;
}
.account-area {
  height: 50%;
  display: flex;
  padding-left: 50px;
  padding-top: 10px;
}
.account-name {
  width: 150px;
  color: #666;
  font-size: large;
  font-weight: 500;
  margin-left: 20px;
}
.default-pos {
  text-align: right;
  width: 120px;
  padding: 5px;
  padding-left: 20px;
}
.default-mark {
  width: 55px;
  border-radius: 20px;
  border: 1px solid #888;
  background: #fff;
  text-align: center;
  color: #5f5c5c;
  font-size: smaller;
}
  </style>