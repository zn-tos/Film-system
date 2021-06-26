<template>
  <el-main>
    <el-container style="height: 60px">
      <el-tag @click="findall()">全部</el-tag>
      <div
        v-for="(item, index) in cate"
        :key="index"
        :label="item"
        :value="item"
      >
        <el-tag @click="findMovie(item)">{{ item }}</el-tag>
      </div>
      
<!--
      <el-tag @click="findMovie('动画')" type="success">动画</el-tag>
      <el-tag @click="findMovie('动作')" type="info">动作</el-tag>
      <el-tag @click="findMovie('犯罪')" type="warning">犯罪</el-tag>
      <el-tag @click="findMovie('惊悚')" type="danger">惊悚</el-tag>
      <el-tag @click="findMovie('家庭')">家庭</el-tag>
      <el-tag @click="findMovie('科幻')" type="success">科幻</el-tag>
      <el-tag @click="findMovie('冒险')" type="info">冒险</el-tag>
      <el-tag @click="findMovie('奇幻')" type="warning">奇幻</el-tag>
      <el-tag @click="findMovie('喜剧')" type="danger">喜剧</el-tag>
      <el-tag @click="findMovie('悬疑')">悬疑</el-tag>
      <el-tag @click="findMovie('音乐')" type="success">音乐</el-tag>
      <el-tag @click="findMovie('灾难')" type="info">灾难</el-tag>
      <el-tag @click="findMovie('剧情')" type="warning">剧情</el-tag>-->
    </el-container>
    <!---->
    <el-container style="height: 100%; flex-wrap: wrap">
      <div v-for="(movie, index) in movies" :key="index">
        <el-image
          :src="require(`../assets/${movie.pic}`)"
          style="width: 150px; height: 200px"
        ></el-image>

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
      input: "",
      cate: [],
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
    findall() {
      const _this = this;
      axios.get("http://121.5.109.66:8181/film/getFilms").then(function (resp) {
        console.log(resp.data);
        _this.$data.movies = resp.data;
        console.log(_this.$data.movies);
      });
    },
    findMovie(key) {
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