<template>
  <body id="login-page">
    <el-form class="login-container" label-position="left" label-width="0px">
      <h3 class="login_title">Login</h3>
      <el-form-item>
        <el-input
          type="text"
          v-model="loginForm.email"
          auto-complete="off"
          placeholder="email"
        ></el-input>
      </el-form-item>
      <el-form-item>
        <el-input
          type="password"
          v-model="loginForm.password"
          auto-complete="off"
          placeholder="password"
        ></el-input>
      </el-form-item>
      <el-form-item style="width: 100%">
        <el-button
          type="primary"
          style="width: 100%; border: none"
          @click="login"
          >Login</el-button
        >
      </el-form-item>
    </el-form>
  </body>
</template>

<script>
import { userLogin } from "@/api/user";
export default {
  name: "Login",
  data() {
    return {
      loginForm: {
        email: "",
        password: "",
      },
      responseResult: [],
    };
  },
  methods: {
    login() {
      var _this = this;
      userLogin({
        email: this.loginForm.email,
        password: this.loginForm.password,
      }).then((resp) => {
        let token = resp.data.token
        let id = resp.data.id
        let user = resp.data.user;
        _this.$store.commit('SET_TOKEN', token);
        _this.$store.commit('SET_USER', user);
        var path = this.$route.query.redirect
        console.log(token);
        console.log(path);
        this.$router.replace({path: path === '/' || path === undefined ? '/' : path})
      });
    },
  },
};
</script>

<style scoped>
#login-page {
  background: url("../assets/img/bg.jpg") no-repeat;
  background-position: center;
  height: 100%;
  width: 100%;
  background-size: cover;
  position: fixed;
}
body {
  margin: 0px;
}
.login-container {
  border-radius: 15px;
  background-clip: padding-box;
  margin: 90px auto;
  width: 350px;
  padding: 35px 35px 15px 35px;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
}

.login_title {
  margin: 0px auto 40px auto;
  text-align: center;
  color: #505458;
}
</style>

