<template>
  <el-card>
    <el-row :gutter="20" class="header">
      <el-col :span="7">
        <el-input placeholder="请输入用户openID..." v-model="queryForm.query" clearable></el-input>
      </el-col>
      <el-button type="primary" :icon="Search" @click="initOrderList">搜索</el-button>
    </el-row>
    <el-table :data="tableData" stripe style="width: 100%">
      <el-table-column prop="id" label="房源号" width="100" fixed/>
      <el-table-column prop="value" label="是否收藏" width="100" />
      <el-table-column prop="opid" label="用户ID" width="200" />
      

      <el-table-column prop="action" label="操作" width="100" fixed="right">
        <template v-slot="scope">
        
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
</template>

<script setup>
import { Search ,Delete } from '@element-plus/icons-vue'
import { ref } from 'vue'
import axios from "@/util/axios";
import { ElMessage, ElMessageBox } from 'element-plus'

const queryForm=ref({
  query:'',
  pageNum:1,
  pageSize:10
})

const total=ref(0)

const tableData = ref([])

const initOrderList=async()=>{
  const res=await axios.post("shoucang/scforvue",queryForm.value)
  tableData.value=res.data.shoucangList;
  total.value=res.data.total;
}

initOrderList();

const handleSizeChange=(pageSize)=>{
  queryForm.value.pageNum=1;
  queryForm.value.pageSize=pageSize;
  initOrderList();
}

const handleCurrentChange=(pageNum)=>{
  queryForm.value.pageNum=pageNum;
  initOrderList();
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
        let res=await axios.get('shoufangdingdan/dindansanchu/'+id)
        if(res.data.code==0){
          ElMessage({
            type: 'success',
            message: '删除成功',
          })
          initOrderList();
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

/* const wxUserInfoNickNameFormatter=(row)=>{
  return row.wxUserInfo.nickName;
}

const statusFormatter=(row)=>{
  switch (row.status){
    case 1:
      return "待支付"
    case 2:
      return "待发货"
    case 3:
      return "退款/退货"
  }
} */



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