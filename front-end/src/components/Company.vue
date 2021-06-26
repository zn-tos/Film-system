<template>
  <div>
    <el-container style="height: 100%; flex-wrap: wrap">
      <div
        v-for="(campany, index) in campanys"
        :key="index"
        style="border: solid #eee; width: 150px"
      >
        <router-link
          :to="{
            path: '/campanydetail' /*,name: 'moviedetail'*/,
            query: { msgKeyOne: campany.id },
          }"
        >
          <el-image
            :src="require(`../assets/company/${campany.pic}`)"
            style="width: 150px; height: 150px"
          ></el-image>
        </router-link>
        <div style="height: 150px; margin: 5px">
          <p>名称:{{ campany.name }}</p>
          <p>城市:{{ campany.city }}</p>
          <p
            style="overflow: hidden; text-align: right; padding-right: 30px"
          ></p>
        </div>
        <!-- </div>-->
      </div>
    </el-container>
  </div>
</template>

<script>
export default {
  name: "电影公司总览",
  data() {
    return {
      campanys: [
        {
          city: "",
          name: "",
          id: "",
          brief: "",
          pic: "",
        },
      ],
    };
  },
  created() {
    const _this = this;
    axios.get("http://121.5.109.66:8181/campany/getall").then(function (resp) {
      console.log(resp.data);
      _this.$data.campanys = resp.data;
      //console.log(_this.$data.movies);
    });
  },
  methods: {},
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
