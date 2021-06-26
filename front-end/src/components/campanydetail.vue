<template>
  <div>
    <el-container style="height: 100%; flex-wrap: wrap">
      <el-header style="height: 200px;color: #FFFFFF">
      <el-image
        :src="require(`../assets/company/${campany.pic}`)"
        style="width: 200px; height: 200px"
      ></el-image></el-header>
      
      <div>
        <p style="text-align: left">公司名称:{{ campany.name }}</p>
        <p style="text-align: left">公司所在地:{{ campany.city }}</p>
        <p style="text-align: left">公司简介:{{ campany.brief }}</p>
        <div>
          <p style="text-align: left">出品电影如下:</p>
          <div v-for="(movie, index) in movies" :key="index">
            <router-link
              :to="{
                path: '/moviedetail',
                query: { msgKeyOne: movie.id },
              }"
            >
              <el-image
                :src="require(`../assets/${movie.pic}`)"
                style="width: 150px; height: 200px"
              ></el-image>
            </router-link>
            <div style="height: 150px; margin: 5px">
              <p>{{ movie.name }}</p>
              <p>时长:{{ movie.time }}</p>
              <p>地区:{{ movie.country }}</p>
              <p
                style="overflow: hidden; text-align: right; padding-right: 30px"
              ></p>
            </div>
          </div>
        </div>
      </div>
    </el-container>
  </div>
</template>


<script>
export default {
  name: "campanydetail",
  data() {
    return {
      msg: null,
      campany: {
        city: "",
        name: "",
        id: "",
        brief: "",
        pic: "",
      },
      movies: [
        {
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
      ],
    };
  },
  created() {
    const _this = this;
    _this.msg = this.$route.query.msgKeyOne;
    console.log(_this.msg);
    _this.getcampany(_this.msg);
    _this.getmovies(_this.msg);
  },
  methods: {
    getcampany() {
      const _this = this;
      axios
        .get("http://121.5.109.66:8181/campany/findcamByid?id=" + _this.msg)
        .then(function (resp) {
          console.log(resp.data);
          _this.$data.campany = resp.data;
          console.log(_this.$data.campany);
        });
    },
    getmovies() {
      const _this = this;
      axios
        .get("http://121.5.109.66:8181/campany/selectByid?id=" + _this.msg)
        .then(function (resp) {
          console.log(resp.data);
          _this.$data.movies = resp.data;
          console.log(_this.$data.movies);
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