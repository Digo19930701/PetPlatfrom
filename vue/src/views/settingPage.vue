<template>
    <el-scrollbar class="setting" height="500px">
        <div class="">
            <el-text style="font-size: large; color: #888888; font-weight: bold">基本設定</el-text>

            <div class="background">
                <el-form :model="settingForm">
                    <h1>我的帳號</h1>
                    <el-form-item label="帳號" :label-width="formLabelWidth">
                        <el-input v-model="settingForm.account" label-width="100px" autocomplete="off" />
                    </el-form-item>
                    <el-form-item label="手機號碼" :label-width="formLabelWidth">
                        <el-input v-model="settingForm.phone" autocomplete="off" />
                    </el-form-item>

                </el-form>
            </div>
            <div class="background">
                <el-form :model="settingForm">
                    <h1>個人檔案</h1>
                    <el-form-item label="姓名" :label-width="formLabelWidth">
                        <el-input v-model="settingForm.name" label-width="100px" autocomplete="off" />
                    </el-form-item>
                    <el-form-item label="性別" :label-width="formLabelWidth">
                        <el-radio-group v-model="settingForm.gender">
                            <el-radio :label="1">男性</el-radio>
                            <el-radio :label="2">女性</el-radio>
                            <el-radio :label="3">其他/保密</el-radio>
                        </el-radio-group>
                    </el-form-item>
                    <el-form-item label="生日" :label-width="formLabelWidth">
                        <el-date-picker v-model="settingForm.birthday" type="date" placeholder="Pick a day"  />


                    </el-form-item>
                    <el-form-item label="身分證字號" :label-width="formLabelWidth">
                        <el-input v-model="settingForm.id" label-width="100px" autocomplete="off" />
                    </el-form-item>
                    <el-form-item label="聯絡地址" :label-width="formLabelWidth">
                        <el-select-v2 v-model="settingForm.address" :options="options" placeholder="Please select" />
                    </el-form-item>

                </el-form>
            </div>
            <span>
                <el-button class="button" @click="confirm()">確認</el-button>
                <el-button class="button">取消</el-button>
            </span>
        </div>
    </el-scrollbar>
</template>
  
<script lang="ts" setup>
import { reactive} from 'vue'
const formLabelWidth = '100px'


const settingForm = reactive({
    account: '',
    phone: '',
    name: '',
    gender: '',
    birthday: '',
    id: '',
    address: ''

})




const confirm = () => {
    console.log("settingForm", settingForm)
}



const initials = ['臺北市', '新北市', '桃園市', '臺中市', '臺南市', '高雄市', '宜蘭縣', '新竹縣', '苗栗縣', '彰化縣', '南投縣', '雲林縣', '嘉義縣', '屏東縣', '花蓮縣', '臺東縣', '澎湖縣', '基隆市', '新竹市', '嘉義市', '連江縣', '金門縣']


const options = Array.from({ length: 22 }).map((_, idx) => ({
  value: `Option ${idx + 1}`,
  label: `${initials[idx % 10]}`,
}))



</script>
  
<style lang="scss">
.setting {
    margin: auto;
    height: 80vh;
    width: 50%;
}

.background {
    background-color: white;
    margin: 10px;
    padding: 40px;
    border-radius: 30px;
    text-align: center;
}

.button {
    color: #FFCB46;
    border-color: #FFCB46;
    border: 1px solid #FFCB46;
    background: #FFFFFF;
}

.button:hover {
    color: white;
    background-color: #FFCB46;
    border-color: #FFCB46;
}

.button:focus {
    color: white;
    background-color: #FFCB46;
    border-color: #FFCB46;
}
</style>