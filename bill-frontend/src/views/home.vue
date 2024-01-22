<template>
  <el-container class="home-container">
    <!--顶部-->
    <el-header style="margin-right: 15px; width: 100%">
      <span class="nav-logo">😀</span>
      <span class="head-title">Hi! Welcome to your bill page.</span>
      <el-avatar
        icon="el-icon-user-solid"
        style="color: #222; float: right; padding: 20px"
      >{{ this.$store.state.user.firstName }}</el-avatar>
    </el-header>
    
    <el-container>

      <!-- 侧边栏 -->
      <el-aside width="13%">
        <el-menu
          :default-active="$route.path"
          router
          text-color="black"
          active-text-color="red"
        >
          <el-menu-item
            v-for="(item, i) in navList"
            :key="i"
            :index="item.name"
          >
            <i :class="item.icon"></i>
            {{ item.title }}
          </el-menu-item>
        </el-menu>

        <div>
          <AddBillButton></AddBillButton>
        </div>

      </el-aside>
      <!-- 主体 -->
      <el-main>
        <!--路由占位符-->
        <router-view></router-view>
        <div>
          <UserTable></UserTable>
        </div>
        

    
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
import AddBillButton from './AddBillButton.vue';
import UserTable from './UserTable.vue';
//import AddBillButtonVue
export default {
    components: {
      UserTable,
      AddBillButton
    },
    name: "Home",
    data() {
        return {
            navList: [
                //{ name: "/index", title: "main", icon: "el-icon-s-home" },
                { name: "/user", title: " User", icon: "el-icon-s-custom" },
            ],
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
