<template>
  <el-dialog
    model-value="imageDialogVisible"
    title="房源图片更换"
    width="30%"
  @close="handleClose"
    center
  >

    <el-form
        ref="formRef"
        :model="form"
        label-width="100px"
        style="text-align: center"
    >

      <el-upload
          :headers="headers"
          class="avatar-uploader"
          :action="'http://localhost:8080'+'/fangyuanxinxi/uploadImage'"
          :show-file-list="false"
          :on-success="handleAvatarSuccess"
          :before-upload="beforeAvatarUpload"
      >
        <img v-if="imageUrl" :src="imageUrl" class="avatar" />
        <el-icon v-else class="avatar-uploader-icon"><Plus /></el-icon>
      </el-upload>

    </el-form>
    <template #footer>
      <span class="dialog-footer">


     <el-button type="primary" @click="handleConfirm">确认更换</el-button>
      </span>
    </template>
  </el-dialog>
</template>

<script setup>

import {defineEmits, defineProps, ref, watch} from "vue";
import axios from "@/util/axios";
import { ElMessage } from 'element-plus'
import { Plus } from '@element-plus/icons-vue'

  const tableData=ref([])



  const props=defineProps(
      {
        imageDialogValue:{
          type:Object,
          default:()=>{},
          required:true
        }
      }
  )

const headers=ref({
  token:window.sessionStorage.getItem("token")
})

const form=ref({
  id:-1,
  fangyuantupian:''
})

const formRef=ref(null)

const imageUrl=ref("")

  watch(
      ()=>props.imageDialogValue,
      ()=>{
        form.value=props.imageDialogValue;
        imageUrl.value='http://localhost:8080'+'/img/'+form.value.fangyuantupian
        console.log("这是watch")
        console.log(imageUrl.value)
      },
      {deep:true,immediate:true}
  )


  const emits=defineEmits(['update:modelValue','initProductList'])

  const handleClose=()=>{
    emits('update:modelValue',false)
  }

  const handleAvatarSuccess=(res)=>{

    imageUrl.value='http://localhost:8080/'+'/img/'+res.data.src
   
    form.value.fangyuantupian=res.data.title;
  }


const beforeAvatarUpload = (file) => {
  const isJPG = file.type === 'image/jpeg'
  const isPNG = file.type === 'image/png'
  const IMG = true
  const isLt2M = file.size / 1024 / 1024 < 2

  if (!isJPG ) {
    if(!isPNG){
      IMG = false
      ElMessage.error('图片必须是jpg/png格式')
    }
    
  }
  if (!isLt2M) {
    ElMessage.error('图片大小不能超过2M!')
  }
  return IMG && isLt2M
}

  const handleConfirm=async()=>{
         console.log("这是handleConfirm")
         
          let result=await axios.post("fangyuanxinxi/save",form.value);
          let data=result.data;
          if(data.code==0){
            ElMessage.success("执行成功！")
            formRef.value.resetFields();
            emits("initProductList")
            handleClose();
          }else{
            ElMessage.error(data.msg);
          }

  }

</script>

<style>

.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}
.avatar-uploader .el-upload:hover {
  border-color: #409eff;
}
.el-icon.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  text-align: center;
}
.avatar {
  width: 178px;
  height: 178px;
  display: block;
}

</style>