<template>
  <div>
    <el-table :data="types" border>
      <el-table-column prop="name" label="名称"></el-table-column>
      <el-table-column prop="createtime" label="创建时间"></el-table-column>
      <el-table-column prop="updatetime" label="更新时间"></el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button type="primary" size="small" @click="handleEdit(scope.row)">编辑</el-button>
          <el-button type="danger" size="small" @click="handleDelete(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  data() {
    return {
      types: []
    }
  },
  methods: {
    initBookType(){
      this.$axios.post('/booktype/all').then(res => {
        if(res.data.code == 200){
          this.types = res.data.data;
        }else {
          this.$message.error(res.data.msg);
        }
      })
    }
  },
  created() {
    this.initBookType();
  }
}
</script>

