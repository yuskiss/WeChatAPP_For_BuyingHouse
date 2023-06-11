<template>
  <el-card>
    <el-row :gutter="20" class="header">
      <el-col :span="7">
        <el-input placeholder="请输入房源名称..." v-model="queryForm.query" clearable></el-input>
      </el-col>
      <el-button type="primary" :icon="Search" @click="initProductList">搜索</el-button>
      <el-button type="primary" :icon="DocumentAdd" @click="handleDialogValue()">添加房源</el-button>
    </el-row>
    <el-table :data="tableData" stripe style="width: 100%">
      <el-table-column prop="id" label="房源ID" width="100" fixed/>
      <el-table-column prop="fangyuantupian" label="房源图片" width="150" align="center">
        <template v-slot="scope">
            <img :src="'http://localhost:8080/'+'/img/'+scope.row.fangyuantupian" width="50" height="50">
          </template>

      </el-table-column>
      <el-table-column prop="fangyuanmingcheng" label="房源名称" width="150" />
      <el-table-column prop="fangyuanleixing" label="房源类型" width="100" />
      <el-table-column prop="fangzihuxing" label="房子户型" width="100" :formatter="typeNameFormatter"/>
      <el-table-column prop="fangyuanquyu" label="房源区域" width="100" align="center">
      </el-table-column>
      <el-table-column prop="zhuangtai" label="房源状态" width="100" align="center">
        
      </el-table-column>
      <el-table-column prop="jutiweizhi" label="具体位置" width="100" />
      
      <el-table-column prop="mianji" label="面积" width="100" align="center"/>
      <el-table-column prop="meimijiage" label="每米价格" width="100" align="center"/>
      <el-table-column prop="zongjine" label="总价" width="100" align="center"/>
      <el-table-column prop="jingjirenzhanghao" label="经纪人账号" width="150" align="center"/>
      <el-table-column prop="jingjirenxingming" label="经纪人姓名" width="150" align="center"/>
      <el-table-column prop="fabushijian" label="发布时间" width="150" align="center"/>

      
      <el-table-column prop="miaoshu" label="描述" width="400"/>

      <el-table-column prop="action" label="操作" width="300" fixed="right">
        <template v-slot="scope">
          <el-button type="success"  @click="handleImageDialogValue(scope.row)">更换图片</el-button>
          <el-button type="primary" :icon="Edit" @click="handleDialogValue(scope.row.id)"/>
          <el-button type="danger" :icon="Delete" @click="handleDelete(scope.row.id)"/>
          
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
        v-model:currentPage="queryForm.pageNum"
        v-model:page-size="queryForm.pageSize"
        :page-sizes="[10, 20, 30, 40,50]"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total"
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
    />
  </el-card>
  <imageDialog v-model="imageDialogVisible" :imageDialogValue="imageDialogValue" @initProductList="initProductList"></imageDialog>
  <Dialog v-model="dialogVisible" :dialogVisible="dialogVisible" :id="id" :dialogTitle="dialogTitle" @initProductList="initProductList"></Dialog>

</template>


<script setup>
import { Search ,Delete,DocumentAdd ,Edit} from '@element-plus/icons-vue'
import { ref } from 'vue'
import axios from "@/util/axios";
import { ElMessage, ElMessageBox } from 'element-plus'
import ImageDialog from './components/imageDialog'
import Dialog from './components/dialog'

const queryForm=ref({
  query:'',
  pageNum:1,
  pageSize:5
})

const total=ref(0)

const tableData = ref([])

const imageDialogVisible=ref(false)

const imageDialogValue=ref({})

const dialogVisible=ref(false)

const dialogTitle=ref('')



const id=ref(-1)

const initProductList=async()=>{
  const res=await axios.post("fangyuanxinxi/fyxxforvue",queryForm.value)
  tableData.value=res.data.fangyuanList;
  total.value=res.data.total;
}

initProductList();

const handleSizeChange=(pageSize)=>{
  queryForm.value.pageNum=1;
  queryForm.value.pageSize=pageSize;
  initProductList();
}

const handleCurrentChange=(pageNum)=>{
  queryForm.value.pageNum=pageNum;
  initProductList();
}

const handleImageDialogValue=(row)=>{
  imageDialogVisible.value=true
  imageDialogValue.value=JSON.parse(JSON.stringify(row))
 
}

const handleDialogValue=(productId)=>{
  if(productId){
    id.value=productId;
    dialogTitle.value="房源编辑"
  }else{
    id.value=-1;
    dialogTitle.value="房源添加"
  }
  dialogVisible.value=true
}

const handleDelete=(id,status)=>{
  ElMessageBox.confirm(
      '您确定要删除这条记录吗?',
      '系统提示',
      {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning',
      }
  )
      .then(async() => {
        let res=await axios.get('fangyuanxinxi/fysanchu/'+id)
        if(res.data.code==0){
          ElMessage({
            type: 'success',
            message: '删除成功',
          })
          initProductList();
        }else{
          ElMessage({
            type: 'error',
            message: res.data.msg,
          })
        }

      })
      .catch(() => {

      })
}

</script>

<style lang="scss" scoped>

.header{
  padding-bottom: 16px;
  box-sizing: border-box;
}

.el-pagination{
  padding-top: 15px;
  box-sizing: border-box;
}


</style>