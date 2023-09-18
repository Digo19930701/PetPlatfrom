<template>
	<div style="display: block; width: 100%;">
			<div style="background-color: white; display: flex; ">
			<el-form class="form" :model="form">
				<el-form-item label="商家名稱"/>
				<el-input v-model="form.name" />
			</el-form>
			<el-form class="form" :model="form">
				<el-form-item label="服務項目"/>
				<el-input v-model="form.ministry" />
			</el-form>
			<el-form class="form" :model="form">
				<el-form-item label="日期"/>
				<el-input v-model="form.date" />
			</el-form>
			<el-form class="form" :model="form">
				<el-form-item label="金額"/>
				<el-input v-model="form.money" />
			</el-form>
			<el-form class="form" :model="form">
				<el-form-item label="地址"/>
				<el-input v-model="form.adders" />
			</el-form>
			<el-form class="form" :model="form">
				<el-form-item label="狀態"/>
				<el-input v-model="form.state" />
			</el-form>
			<el-button @click="dialogFormVisible = false" style="margin-top: 7.5%;margin-left:35%; background-color: #f8d479; ">取消訂單</el-button>
			
		</div>

	</div>
	
</template>

<script lang="ts" setup>
import { ref, reactive } from 'vue'
const radio1 = ref('New York')
const form = reactive({
    name: 'XXX',
	ministry:'美容',
	date:'20230913',
	money:'5000',
	adders:'台北市文山區木新路17段85號',
	state:'處理中',
    
})
const dialogFormVisible = ref(false)
</script>

<style scoped>
.form {
    font-size: 30px;
    
    
}
</style>