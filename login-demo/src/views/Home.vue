<template>
  <div class="home">
    <el-container style="height: 500px; border: 1px solid #eee">
  <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
    <!-- <el-menu :default-openeds="['1', '3']">
      <el-submenu index="1">
        <template slot="title"><i class="el-icon-message"></i>导航一</template>
        <el-menu-item-group>
          <el-menu-item index="1-1">选项1</el-menu-item>
          <el-menu-item index="1-2">选项2</el-menu-item>
        </el-menu-item-group>
      </el-submenu>
      <el-submenu index="2">
        <template slot="title"><i class="el-icon-menu"></i>导航二</template>
        <el-menu-item-group>
          <el-menu-item index="2-1">选项1</el-menu-item>
          <el-menu-item index="2-2">选项2</el-menu-item>
        </el-menu-item-group>
      </el-submenu>
    </el-menu> -->

    <!-- 这里要加router属性才能使得：index属性和路由path对应起来 -->
    <el-menu :default-openeds="['1', '3']" router> 
      <!-- 这里的index属性绑定的每一个导航栏，否则点击一个所有的都会展开 -->
      <el-submenu v-for="(item,index) in $router.options.routes" :key="index" :index = "index +''" > 
        <template slot="title"><i class="el-icon-setting"></i>{{item.name}}</template>
         <el-menu-item-group v-for="(item2,index2) in item.children" :key="index2">
          <el-menu-item :index = "item2.path" :class="item2.path == $route.path? 'is-active':'' ">{{item2.name}}</el-menu-item>
        </el-menu-item-group>
      </el-submenu>
    </el-menu>
  </el-aside>
  
  <el-container>
    <!-- <el-header style="text-align: right; font-size: 12px">
      <el-dropdown>
        <i class="el-icon-setting" style="margin-right: 15px"></i>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item>查看</el-dropdown-item>
          <el-dropdown-item>新增</el-dropdown-item>
          <el-dropdown-item>删除</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
      <span>Sera</span>
    </el-header>
     -->
    <el-main>
    <router-view></router-view>

    </el-main>
  </el-container>
</el-container>

  </div>
</template>

<style>
  .el-header {
    background-color: #B3C0D1;
    color: #333;
    line-height: 60px;
  }
  
  .el-aside {
    color: #333;
  }
</style>
<script>

export default {
  name: 'Home',
      data() {
      
      return {
      
      }
    }
}
</script>
