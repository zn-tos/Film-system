<template>
  <el-main>
    <el-container style="height: 60px">
      <el-input
        v-model="input"
        placeholder="请输入您想查询的电影名称"
        style="width: 400px"
      ></el-input>
      <el-button
        type="primary"
        style="height: 40px; color: #3511d2"
        icon="el-icon-search"
        @click="findMovie(input)"
        >搜索</el-button
      >
    </el-container>
    <el-container style="height: 60px">
            <el-tag @click="findall()">全部</el-tag>
      <div
        v-for="(item, index) in cate"
        :key="index"
        :label="item"
        :value="item"
      >
        <el-tag @click="findMovie2(item)" type="success">{{ item }}</el-tag>
      </div>
 
    </el-container>
    <!---->
    <el-container style="height: 100%; flex-wrap: wrap">
      <div v-for="(movie, index) in movies" :key="index" >
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
          <p style="overflow: hidden; text-align: right; padding-right: 30px">
            <router-link
              :to="{
                path: '/moviedetail',
                query: { msgKeyOne: movie.id },
              }"
            >
              <i class="el-icon-more" style="font-size: 20px"></i>
            </router-link>
          </p>
        </div>
      </div>
    </el-container>
  </el-main>
</template>

<script>
export default {
  name: "Findcompany",
  data() {
    return {
      cate:[],
      input: "",
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
    axios.get("http://121.5.109.66:8181/film/getFilms").then(function (resp) {
      console.log(resp.data);
      _this.$data.movies = resp.data;
      console.log(_this.$data.movies);
    });
        axios.get("http://121.5.109.66:8181/getcateName").then(function (resp) {
      console.log(resp.data);
      _this.$data.cate = resp.data;
      console.log(_this.$data.cate);
    });
  },
  methods: {
    findMovie() {
      const _this = this;
      axios
        .get("http://121.5.109.66:8181/film/selectByName?name=" + _this.input)
        .then(function (resp) {
          console.log(resp.data);
          _this.$data.movies = resp.data;
          console.log(_this.$data.movies);
          //var arr = []
          //arr.push({name:resp.data.name,id:resp.data.id,birthday:resp.data.birthday,lang:resp.data.lang,country:resp.data.country,brief:resp.data.brief,score:resp.data.score,pic:resp.data.pic})
          //this.$data.movies=arr;
          //console.log(this.$data.movies);
        });
    },
    findall() {
      const _this = this;
      axios.get("http://121.5.109.66:8181/film/getFilms").then(function (resp) {
        console.log(resp.data);
        _this.$data.movies = resp.data;
        console.log(_this.$data.movies);
      });
    },
    findMovie2(key) {
      const _this = this;
      axios
        .get("http://121.5.109.66:8181/cate/selectByName?name=" + key)
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
</style>