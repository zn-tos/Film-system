<template >

  <div id="app">
    <el-container >
     
        <el-main>
            <router-view></router-view>
        </el-main>
    </el-container>
  </div>
</template>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  color:#1628ce;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c502c;
  margin-top: 0px;
}
.el-header {
  background-color:	#F2F6FC;
  color: 	#4d40ff;
  line-height: 60px;
}

.el-aside {
  color: rgb(51, 51, 51);
}
</style>