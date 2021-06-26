<template>
  <el-main>
    <el-container style="height: 60px">
      <el-input
        v-model="input"
        placeholder="请输入您想查找的职员的名字"
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
<!---->
   <el-container style="height: 100%; flex-wrap: wrap">
      <div style="width: 100%;">
        <p style="width: 100%;font-size:30px">{{ input }}</p>
      </div>

      <div>
        <div>
          <div v-for="(movie, index) in movies1" :key="index">
            <div v-if="movie.name">
              <p style="text-align: left">导演的电影:</p>
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
                  style="
                    overflow: hidden;
                    text-align: right;
                    padding-right: 30px;
                  "
                ></p>
              </div>
            </div>
          </div>
        </div>

        <div>
          <div v-for="(movie, index) in movies2" :key="index">
            <div v-if="movie.name">
              <p style="text-align: left">出演的电影:</p>
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
                  style="
                    overflow: hidden;
                    text-align: right;
                    padding-right: 30px;
                  "
                ></p>
              </div>
            </div>
          </div>
        </div>

        <div>
          <div v-for="(movie, index) in movies3" :key="index">
            <div v-if="movie.name">
              <p style="text-align: left">旁白配音的电影:</p>
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
                  style="
                    overflow: hidden;
                    text-align: right;
                    padding-right: 30px;
                  "
                ></p>
              </div>
            </div>
          </div>
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
      msg: null,
      actor: {
        name: "",
        id: "",
      },
      input:'',
      movies1: [
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
      movies2: [
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
      movies3: [
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
        .get("http://121.5.109.66:8181/staff/selectByDirectName?name=" + _this.input)
        .then(function (resp) {
          console.log(resp.data);
          _this.$data.movies1 = resp.data;
          console.log(_this.$data.movies1);
        });

      axios
        .get("http://121.5.109.66:8181/staff/selectByActorName?name=" + _this.input)
        .then(function (resp) {
          console.log(resp.data);
          _this.$data.movies2 = resp.data;
          console.log(_this.$data.movies2);
        });

      axios
        .get("http://121.5.109.66:8181/staff/selectByAsideName?name=" + _this.input)
        .then(function (resp) {
          console.log(resp.data);
          _this.$data.movies3 = resp.data;
          console.log(_this.$data.movies3);
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
