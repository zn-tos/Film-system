<template>
  <div id="login" style="margin-left: auto; margin-right: auto; width: 500px">
    <p style="font-size: 20px;color: coral">管理员登录页面</p>
    <el-form
      :model="ruleForm" :rules="rules"
      ref="ruleForm" label-width="100px"  class="login-ruleForm"
    >
      <el-form-item label="用户名" prop="username" width="50">
        <el-input v-model="ruleForm.username" ></el-input>
      </el-form-item>

      <el-form-item label="密码" prop="password" width="50">
        <el-input v-model="ruleForm.password" show-password></el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">登录</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  name: "ManageLogin",
  data() {
    return {
      ruleForm: {
        username: "",
        password: "",

      },
      rules: {
        username: [
          { required: true, message: "请输入用户名", trigger: "blur" },
          { max:10, message: "输入内容不得超过10个字符", trigger: "blur"}
        ],
        password: [
          { required: true, message: "请输入密码", trigger: "blur" },
        ],

      }
    };
  },

  methods: {
    submitForm(formName) {
      const _this = this;
      this.$refs[formName].validate(valid => {
        if (valid) {
          axios
            .post("http://121.5.109.66:8181/manage/login", this.ruleForm,{
              headers: {
                'Content-Type':'application/json; charset=UTF-8'//设置传输JSON格式即可
              }
            })
            .then(resp=>  {
              let code=resp.data.code;
              if(code===200){
                let data=resp.data.data;
                let token=data.token;
                let manager=data.manager;
            //    console.log(data);
              //  console.log(token);
              //  console.log(manager);
                setTimeout(() => {
                  // 模拟登录接口，请求成功返回用户信息，存储到 vuex 中
                  let userInfo = {
                    token:token,                 
                    manager:manager,
                  }
                  _this.$message({
                    type: "success",
                    message: "登陆成功"
                  });
                 // _this.$router.push('/manager');
                  _this.$store.dispatch('setUserInfo', userInfo).then(() => {
                    console.log(userInfo.token);
                    console.log(userInfo.manager);
                    this.$router.replace('/managermovie')
                  });
                })
              }
              else {
                _this.$message({
                  type: "fail",
                  message: "登陆失败，用户名不存在或者密码错误！"
                });
              }
            })
        }
        else {
          console.log("error submit!!");
          return false;
        }
      });
    },
  }
}
</script>

<style scoped>
#login {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
