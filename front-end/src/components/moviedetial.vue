<template>
  <div>
    <el-container style="height: 100%; flex-wrap: wrap">
      <!--   <div v-for="(a, index) in movie" :key="index">-->
      <el-image
        :src="require(`../assets/${movie.pic}`)"
        style="width: 350px; height: 500px"
      ></el-image>
      <div>
        <p style="text-align: left">片名:{{ movie.name }}</p>
        <p style="text-align: left">时长:{{ movie.time }}</p>
        <p style="text-align: left">地区:{{ movie.country }}</p>
        <p style="text-align: left">评分:{{ movie.score }}</p>
        <p style="text-align: left">出品时间:{{ movie.birthday }}</p>
        <p style="text-align: left">语言:{{ movie.lang }}</p>
        <p style="text-align: left">简介:{{ movie.brief }}</p>
      </div>
      <div>
        <p style="text-align: left">电影导演：</p>
        <el-table :data="tabledata1">
          <el-table-column
            prop="directname"
            label="姓名"
            width="300"
            align="center"
          >
            <template slot-scope="scope">
              <router-link
                :to="{
                  path: '/actordetail',
                  query: { msgKeyOne: scope.row.directname },
                }"
                >{{ scope.row.directname }}</router-link
              >
            </template>
          </el-table-column>
          <el-table-column
            prop="directident"
            label="职务"
            width="300"
            align="center"
          ></el-table-column>
        </el-table>
      </div>
      <div>
        <p style="text-align: left">参演演员：</p>
        <el-table :data="tabledata2">
          <el-table-column
            prop="actorname"
            label="姓名"
            width="300"
            align="center"
          >
            <template slot-scope="scope">
              <router-link
                :to="{
                  path: '/actordetail',
                  query: { msgKeyOne: scope.row.actorname },
                }"
                >{{ scope.row.actorname }}</router-link
              >
            </template>
          </el-table-column>
          <el-table-column
            prop="actorident"
            label="角色"
            width="300"
            align="center"
          ></el-table-column>
        </el-table>
      </div>
      <div>
        <p style="text-align: left">旁白配音：</p>
        <el-table :data="tabledata3">
          <el-table-column
            prop="asidename"
            label="姓名"
            width="150"
            align="center"
          >
            <template slot-scope="scope">
              <router-link
                :to="{
                  path: '/actordetail',
                  query: { msgKeyOne: scope.row.asidename },
                }"
                >{{ scope.row.asidename }}</router-link
              >
            </template>
          </el-table-column>
          <el-table-column
            prop="asidebrief"
            label="配音角色"
            width="150"
            align="center"
          ></el-table-column>
                    <el-table-column
            prop="asideident"
            label="旁白内容"
            width="300"
            align="center"
          ></el-table-column>
        </el-table>
      </div>

      <!-- </div>-->
    </el-container>
  </div>
</template>


<script>
export default {
  name: "moviedetail",
  data() {
    return {
      tabledata1: [
        {
          directname: "",
          directident: "",
        },
      ],
      tabledata2: [
        {
          actorname: "",
          actorident: "",
        },
      ],
      tabledata3: [
        {
          asidename: "",
          asidebrief: "",
          asideident: "",
        },
      ],
      movie: {
        name: "",
        id: "",
        birthday: "",
        time: "",
        lang: "",
        country: "",
        brief: "",
        score: "",
        pic: "",
      },
      msg: null,
      myIndex: "",
    };
  },
  created() {
    const _this = this;
    _this.msg = this.$route.query.msgKeyOne;
    _this.getMovie(_this.msg);
    _this.getStaff(_this.msg);
  },
  methods: {
    getMovie(msg) {
      const _this = this;
      axios
        .get("http://121.5.109.66:8181/film/findByid?id=" + msg)
        .then(function (resp) {
          console.log(resp.data);
          _this.$data.movie = resp.data;
          console.log(_this.$data.movies);
        });
    },
    getStaff(msg) {
      const _this = this;
      // console.log(_this.movie.name);
      axios
        .get("http://121.5.109.66:8181/film/selectBydirect?id=" + msg)
        .then(function (resp) {
          console.log(resp.data);
          _this.$data.tabledata1 = resp.data;
          console.log(_this.$data.tabledata1);
        });
      //console.log(_this.movie.name);
      axios
        .get("http://121.5.109.66:8181/film/selectByact?id=" + msg)
        .then(function (resp) {
          console.log(resp.data);
          _this.$data.tabledata2 = resp.data;
          console.log(_this.$data.tabledata2);
        });
      //console.log(_this.movie.name);
      axios
        .get("http://121.5.109.66:8181/film/selectByaside?id=" + msg)
        .then(function (resp) {
          console.log(resp.data);
          _this.$data.tabledata3 = resp.data;
          console.log(_this.$data.tabledata3);
        });
    },
  },
};
</script>

<style scoped>
.el-container {
  height: 100%;
}
.el-aside {
  color: #333;
}
</style>s