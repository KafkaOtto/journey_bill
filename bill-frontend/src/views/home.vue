<template>
  <body>
  <el-container class="home-container">
    <!--顶部-->
    <el-header style="margin-right: 15px; width: 100%">
      <span class="nav-logo">😊    🧾</span>
      <span class="head-title">Hii, <i style="color: hsl(25, 94%, 52%)">{{ this.$store.state.user.firstName }}  </i>! Welcome to your bill page.</span>
      <!-- <el-avatar
        icon="el-icon-user-solid"
        style="color: #222; float: right; padding: 20px"
      >{{ this.$store.state.user.firstName }}</el-avatar> -->
    </el-header>
    
    <el-container>

      <!-- 侧边栏 -->
      <el-aside width="13%">
        <router-view name= "aside"> </router-view>
      </el-aside>


      <!-- 主体 -->
      <el-main>
        <!--路由占位符-->
        <router-view></router-view>        

      </el-main>
    </el-container>
  </el-container>
</body>
</template>

<script>

export default {
    name: "Home",
    data() {
        return {

        };
    },
};
</script>

<style >
.nav-logo {
  position: absolute;
  padding-top: -1%;
  left: 5%;
  font-size: 40px;
}

.head-title {
  position: absolute;
  padding-top: 20px;
  left: 15%;
  font-size: 20px;
  font-weight: bold;
}



</style>
