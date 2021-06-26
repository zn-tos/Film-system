<template >
  <div id="app">
    <div
      style="height: 30px; margin-top: 5px; margin-left: 10px; margin-buttom: 0"
    >
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">主页</el-breadcrumb-item>
        <el-breadcrumb-item>
          <i class="el-icon-upload" style="color: #66cdaa"
            ><a href="/">电影资讯网</a>
          </i>
        </el-breadcrumb-item>
        <el-breadcrumb-item>
          <router-link :to="{ path: '/Login' }" style="text-align: right">
            <i class="el-icon-upload" style="color: #66cdaa"
              ><a href="/">管理员</a>
            </i></router-link
          >
        </el-breadcrumb-item>
      </el-breadcrumb>
    </div>

    <el-header
      >
      好看电影网
      <i class="el-icon-s-promotion" style="color: #66cdaa"></i
    ></el-header>
    <el-container style="height: 100%; border: 1px solid #eee">
     
      
      <el-aside  style="width:200px;background-color: rgb(238, 241, 246)">
       <el-menu router :default-openeds="['0']">
          <el-submenu
            v-for="(item, index) in $router.options.routes"
            :index="index + ''"
            :key="index"
          >
            <template slot="title"
              >
              <i class="el-icon-message" style="color: #67c23a"></i
              >{{ item.name + "" }}
            </template>

            <el-menu-item
              v-for="(item2, index2) in item.children"
              :index="item2.path"
              :class="$route.path == item2.path ? 'is-active' : ''"
              :key="index2"
              >{{ item2.name }}</el-menu-item
            >
          </el-submenu>
        </el-menu>
      </el-aside><!---->
      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </div>
</template>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  color: #1628ce;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c502c;
  margin-top: 0px;
}
.el-header {
  background-color: #f2f6fc;
  color: #4d40ff;
  line-height: 60px;
}

.el-aside {
  color: rgb(51, 51, 51);
}
</style>