<template>
  <el-main>
    <el-container style="height: 60px">
      <el-input
        v-model="input"
        placeholder="请输入您要检索的类型"
        style="width: 400px"
      ></el-input>
      <p style="color: #d22e11;">请输入您要检索的类型：爱情/动画/动作/犯罪/剧情/惊悚/家庭/科幻/冒险/奇幻/喜剧/悬疑/音乐/灾难</p>
      <el-button
        type="primary"
        style="height: 40px; color: #3511d2"
        icon="el-icon-search"
        @click="findMovie(input)"
        >搜索</el-button
      >
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
                path: '/moviedetail' ,
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
        input:'',
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
  },
  methods: {
    findMovie() {
         const _this = this;
      axios
        .get("http://121.5.109.66:8181/cate/selectByName?name=" + _this.input)
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