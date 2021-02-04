<template>
  <div>
    <el-card class="box-card" style="width: 600px">
      <el-form
        :model="addBookForm"
        :rules="rules"
        ref="ruleForm"
        label-width="100px"
        class="demo-ruleForm"
      >
        <el-form-item label="图书名称" prop="name">
          <el-input v-model="addBookForm.name"></el-input>
        </el-form-item>
        <el-form-item label="作者" prop="author">
          <el-input v-model="addBookForm.author"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm('ruleForm')"
            >立即添加</el-button
          >
          <el-button @click="resetForm('addBookForm')">重置</el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>
<script>
export default {
  data() {
    return {
      addBookForm: {
        name: "",
        author: "",
      },
      rules: {
        name: [{ required: true, message: "请输入图书名称", trigger: "blur" }],
        author: [
          { required: true, message: "请输入图书作者", trigger: "blur" },
        ],
      },
    };
  },
  methods: {
    submitForm(formName) {
      var that = this;
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.$http
            .post("http://localhost:8181/book/save/", this.addBookForm)
            .then((res) => {
              if (res.status == 200) {
                this.$alert(`《${that.addBookForm.name}》添加成功！`, "消息", {
                  confirmButtonText: "确定",
                  callback: (action) => {
                    this.$router.push("/searchBook");
                  },
                });
              }
            });
        } else {
          console.log("提交出错!!");
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
  },
};
</script>
