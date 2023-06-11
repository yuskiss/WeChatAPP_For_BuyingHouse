<template>
  <div class="login-container">
    <el-form ref="formRef" :model="form" :rules="rules" class="login-form">
      <div class="title-container">
        <h3 class="title">还不快购房管理员</h3>
      </div>
      <el-form-item prop="userName">
        <el-icon :size="20" class="svg-container">
          <edit />
        </el-icon>
        <!-- <svg-icon icon="user" class="svg-container"></svg-icon> -->
        <el-input v-model="form.username" placeholder="请输入用户名..." />
      </el-form-item>
      <el-form-item prop="password">
        <el-icon :size="20" class="svg-container">
          <edit />
        </el-icon>
        <!-- <svg-icon icon="password" class="svg-container"></svg-icon> -->
        <el-input v-model="form.password" type="password" placeholder="请输入密码.." />
      </el-form-item>
      <el-form-item>
        <el-button type="success" class="login-button" @click="handleLogin">登录</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { Edit } from '@element-plus/icons-vue'
import axios from 'axios'
import { ElMessage } from 'element-plus'
import axiosUtil from '/src/util/axios'
import router from '@/router'


const form = ref({
  username: '',
  password: ''
})
const rules = ref({
  username: [
    {
      required: true,
      message: '请输入用户名',
      trigger: 'blur',
    },
  ],
  password: [
    {
      required: true,
      message: '请输入密码',
      trigger: 'blur',
    },
  ],
})
const formRef = ref(null)
const handleLogin = () => {
  formRef.value.validate(async (valid) => {
    if (valid) {
      console.log('验证成功')
      /* axios
        .post('http://localhost:8080/users/adminLogin', form.value)
        .then(response => {
          console.log(response.data)
        }) */
        let result=await axiosUtil.post("users/adminLogin",form.value)
        //console.log(result.data)
        let data = result.data
        if(data.code==0){
          ElMessage.success("登录成功")
          window.sessionStorage.setItem("token",data.token);
          window.sessionStorage.setItem("userInfo",JSON.stringify(form.value));
          router.replace("/")
        }else{
          ElMessage.error("登录失败")
        }
        
    } else {
      console.log('验证失败')
    }
  })
}
</script>

<style lang="scss" scoped>
$bg: #235112;
$dark_gray: #219e13;
$light_gray: #eee;
$cursor: #171616;

.login-container {
  min-height: 100%;
  width: 100%;
  background-color: $bg;
  overflow: hidden;

  .login-form {
    position: relative;
    width: 520px;
    max-width: 100%;
    padding: 160px 35px 0;
    margin: 0 auto;
    overflow: hidden;

    ::v-deep .el-form-item {
      border: 1px solid rgba(157, 165, 165, 0.1);
      background: rgba(100, 113, 106, 0.1);
      border-radius: 5px;
      color: #9eaba4;
    }

    ::v-deep .el-form-item__content {
      color: #b3b6b3;
      background: rgba(215, 231, 219, 0.1);
    }

    ::v-deep .el-input__wrapper {
      display: block;
      color: #0c3f0c;
      background: rgb(222, 240, 215);
      box-shadow: none;
    }

    ::v-deep .el-input {
      display: inline-block;
      background: rgb(180, 207, 185);
      height: 47px;
      width: 85%;

      input {
        background: transparent;
        border: 0px;
        -webkit-appearance: none;
        border-radius: 0px;
        padding: 12px 5px 12px 15px;
        color: $cursor;
        height: 47px;
        caret-color: $cursor;
      }
    }
    .login-button {
      width: 100%;
      box-sizing: border-box;
    }
  }

  .tips {
    font-size: 16px;
    line-height: 28px;
    color: #1b1919;
    margin-bottom: 10px;

    span {
      &:first-of-type {
        margin-right: 16px;
      }
    }
  }

  .svg-container {
    padding: 6px 5px 6px 15px;
    color: $dark_gray;
    vertical-align: middle;
    display: inline-block;
  }

  .title-container {
    position: relative;

    .title {
      font-size: 26px;
      color: $light_gray;
      margin: 0px auto 40px auto;
      text-align: center;
      font-weight: bold;
    }

    ::v-deep .lang-select {
      position: absolute;
      top: 4px;
      right: 0;
      background-color: rgb(248, 245, 245);
      font-size: 22px;
      padding: 4px;
      border-radius: 4px;
      cursor: pointer;
    }
  }

  .show-pwd {
    // position: absolute;
    // right: 10px;
    // top: 7px;
    font-size: 16px;
    color: $dark_gray;
    cursor: pointer;
    user-select: none;
  }
}
</style>
