<template>
    <div>
 <el-table 
    :data="booklist"
    stripe
    style="width: 100 %">
    <el-table-column
     type="index"
      prop="id"
      label="编号"
      width="180">
    </el-table-column>
    <el-table-column
      prop="name"
      label="书名"
      width="180">
    </el-table-column>
    <el-table-column
      prop="author"
      label="作者">
    </el-table-column>
     <el-table-column
      fixed="right"
      label="操作"
      width="100">
      <template slot-scope="scope">
        <!-- <el-button @click="handleClick(scope.row)" type="text" size="small">编辑</el-button> -->
        <el-button @click="handleClick(scope.row)" type="text" size="small">编辑</el-button>
        <el-button @click ="deleteById(scope.row.id)" type="text" size="small" >删除</el-button>
      </template>
    </el-table-column>
  </el-table>
  <el-dialog
  title="提示"
  :visible.sync="dialogVisible"
  width="30%"
  :before-close="handleClose">
   <el-form :model="addBookForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
     <el-form-item label="图书名称" prop="name">
    <el-input v-model="addBookForm.name"></el-input>
  </el-form-item>
       <el-form-item label="作者" prop="author">
    <el-input v-model="addBookForm.author"></el-input>
  </el-form-item>
      </el-form>
  <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary"  @click="submitForm('ruleForm')">确 定</el-button>
  </span>
</el-dialog>
<el-pagination
    background
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="currentPage"
      :page-sizes="[5,10,15]"
      :page-size="20"
      layout="total, sizes, prev, pager, next, jumper"
      :total="total">
    </el-pagination>
    </div>
</template>

<script>
export default {
    data(){
    return{
        total:null,
        currentPage:1,
        pageSize:5,
        booklist:[], 
        editId : null,
        dialogVisible:false,   
         addBookForm: {
          name: '',
          author: '',
        },
        rules: {
          name: [
            { required: true, message: '请输入图书名称', trigger: 'blur' },
          ],
          author: [
            { required: true, message: '请输入图书作者', trigger: 'blur' },
          ],
        }
    }
    
    },
    created(){
        // alert("hello");
        this.getBookList();
    },
    methods: {
        getBookList(){
            console.log(this.pageSize);
        this.$http.get(`http://localhost:8181/book/findAll/${this.currentPage}/${this.pageSize}`).then((res)=>{
            console.log(res.data)
            this.booklist = res.data.content;
            this.total = res.data.totalElements
        })
        },
      handleSizeChange(val) {
        console.log(`每页 ${val} 条`);
        this.pageSize = val;
        this.getBookList();

      },
      handleCurrentChange(val) {
        console.log(`当前页: ${val}`);
        this.currentPage = val;
         this.getBookList();

      },
      handleClick(data){
        this.dialogVisible = true;
        this.addBookForm.name = data.name;
        this.addBookForm.author =data.author;   
        this.editId = data.id;
        },
     submitForm(formName) {
          var that = this;
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$http.put("http://localhost:8181/book/update/"+this.editId,this.addBookForm).then(res=>{
                if(res.status == 200){
            this.$message({
          message: '修改成功！',
          type: 'success'
        });
          }
        });
          this.dialogVisible = false;
          this.getBookList();
          } else {
            console.log('提交出错!!');
            return false;
          }
        });
      },
    handleClose(done) {
        this.$confirm('确认关闭？')
          .then(_ => {
            done();
          })
          .catch(_ => {});
      },
     async  deleteById(id){
      //  这里一定要使用异步方式
      const confirmRes= await this.$confirm('此操作将永久删除该书籍, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).catch(err=>err);
         if(confirmRes!=='confirm'){
            console.log(confirmRes);
           return this.$message.info('已取消删除！')        
         }
          this.$http.delete("http://localhost:8181/book/deleteBook/"+ id).then(res=>{
            console.log(res);
          if (res.status !== 200) {
         return this.$message.error('删除书籍失败！')
      }
      this.$message.success('删除书籍成功！');
      this.getBookList();     
        })
      },
    
}
}
</script>
