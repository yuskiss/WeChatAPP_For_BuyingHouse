<template>
  <el-dialog model-value="dialogVisible" :title="dialogTitle" width="50%" @close="handleClose">
    <el-form ref="formRef" :model="form" :rules="rules" label-width="100px">
      <el-form-item label="房源ID" prop="id">
        <el-input v-model="form.id" style="width: 400px" />
      </el-form-item>

      <el-form-item label="房源名称" prop="fangyuanmingcheng">
        <el-input v-model="form.fangyuanmingcheng" style="width: 150px" />
      </el-form-item>

      <el-form-item label="房源类型" prop="fangyuanleixing">
        <el-input v-model="form.fangyuanleixing" style="width: 100px" />
      </el-form-item>

      <el-form-item label="房子户型" prop="fangzihuxing">
        <el-input v-model="form.fangzihuxing" style="width: 100px" />
      </el-form-item>

      <el-form-item label="房源区域" prop="fangyuanquyu">
        <el-input v-model="form.fangyuanquyu" style="width: 100px" />
      </el-form-item>
      <el-form-item label="房源状态" prop="zhuangtai">
        <el-input v-model="form.zhuangtai" style="width: 100px" />
      </el-form-item>
      <el-form-item label="具体位置" prop="jutiweizhi">
        <el-input v-model="form.jutiweizhi" type="textarea" :rows="3" />
      </el-form-item>
      <el-form-item label="面积" prop="mianji">
        <el-input v-model="form.mianji" style="width: 100px" />
      </el-form-item>
      <el-form-item label="每米价格" prop="meimijiage">
        <el-input v-model="form.meimijiage" style="width: 100px" />
      </el-form-item>
      <el-form-item label="总价" prop="zongjine">
        <el-input v-model="form.zongjine" style="width: 100px" />
      </el-form-item>
      <el-form-item label="经纪人账号" prop="jingjirenzhanghao">
        <el-input v-model="form.jingjirenzhanghao" style="width: 150px" />
      </el-form-item>
      <el-form-item label="经纪人姓名" prop="jingjirenxingming">
        <el-input v-model="form.jingjirenxingming" style="width: 100px" />
      </el-form-item>
      <el-form-item label="描述" prop="miaoshu">
        <el-input v-model="form.miaoshu" type="textarea" :rows="4" />
      </el-form-item>
    </el-form>

    <template #footer>
      <span class="dialog-footer">
        <el-button @click="handleClose">取消</el-button>
        <el-button type="primary" @click="handleConfirm">确认</el-button>
      </span>
    </template>
  </el-dialog>
</template>

<script setup>
import { defineEmits, defineProps, ref, watch } from 'vue'
import axios from '@/util/axios'
import { ElMessage } from 'element-plus'

const props = defineProps({
  id: {
    type: Number,
    default: -1,
    required: true,
  },
  dialogTitle: {
    type: String,
    default: '',
    required: true,
  },
  dialogVisible: {
    type: Boolean,
    default: false,
    required: true,
  },
})

const form = ref({
  id: -1,
  fangyuanmingcheng: '',
  fangyuanleixing: '',
  fangzihuxing: '',
  fangyuanquyu: '',
  zhuangtai: '',
  jutiweizhi: '',
  mianji: '',
  meimijiage: '',
  zongjine: '',
  jingjirenzhanghao: '',
  jingjirenxingming: '',
  miaoshu: '',
})

const bigTypeId = ref('')

const rules = ref({
  id: [
    {
      required: true,
      message: '请输入房源id',
    },
    {
      type: 'number',
      message: '商品价格是数值类型！',
      transform: (value) => Number(value),
    },
  ],
  fangyuanmingcheng: [
    {
      required: true,
      message: '请输入房源名称！',
    },
  ],
  fangyuanleixing: [
    {
      required: true,
      message: '请输入房源类型！',
    },
  ],
  fangzihuxing: [
    {
      required: true,
      message: '请输入房子户型！',
    },
  ],
  fangyuanquyu: [
    {
      required: true,
      message: '请输入房源区域！',
    },
  ],
  zhuangtai: [
    {
      required: true,
      message: '请输入房源状态！',
    },
  ],
  jutiweizhi: [
    {
      required: true,
      message: '请输入具体位置！',
    },
  ],
  mianji: [
    {
      required: true,
      message: '请输入面积！',
    },
  ],
  meimijiage: [{ required: true, message: '请输入每米价格!' }],
  zongjine: [{ required: true, message: '请输入总价!' }],
  jingjirenzhanghao: [
    {
      required: true,
      message: '请输入经纪人账号！',
    },
  ],
  jingjirenxingming: [
    {
      required: true,
      message: '请输入经纪人姓名！',
    },
  ],
  miaoshu: [
    {
      required: true,
      message: '请输入描述！',
    },
  ],
})
const formRef = ref(null)

const initFormData = async (id) => {
  const res = await axios.get('fangyuanxinxi/findbyid/' + id)
  console.log('zhehsiinitFormData')
  console.log(res.data)
  form.value = res.data.product
}

watch(
  () => props.dialogVisible,
  () => {
    let id = props.id
    if (id != -1) {
      initFormData(id)
    } else {
      form.value = {
        id: -1,
        fangyuanmingcheng: '',
        fangyuanleixing: '',
        fangzihuxing: '',
        fangyuanquyu: '',
        zhuangtai: '',
        jutiweizhi: '',
        mianji: '',
        meimijiage: '',
        zongjine: '',
        jingjirenzhanghao: '',
        jingjirenxingming: '',
        miaoshu: '',
      }
    }
  }
)

const emits = defineEmits(['update:modelValue', 'initProductList'])

const handleClose = () => {
  emits('update:modelValue', false)
}

const handleConfirm = () => {
  formRef.value.validate(async (valid) => {
    if (valid) {
      let result = await axios.post('fangyuanxinxi/fangyuansave', form.value)
      let data = result.data
      if (data.code == 0) {
        ElMessage.success('执行成功！')
        formRef.value.resetFields()
        emits('initProductList')
        handleClose()
      } else {
        ElMessage.error(data.msg)
      }
    } else {
      console.log('fail')
    }
  })
}
</script>

<style scoped></style>
