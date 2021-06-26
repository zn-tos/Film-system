<template>
  <el-table :data="tableData">
    <el-table-column prop="name" label="姓名" width="300" align="center">
      <!--  <template slot-scope="scope">
        <router-link
          :to="{
            path: '/actordetail' ,
            query: { msgKeyOne: scope.row.name },
          }"
          >{{ scope.row.name }}</router-link
        >
      </template>-->
    </el-table-column>

    <el-table-column
      prop="id"
      label="演员编号"
      width="300"
      align="center"
    ></el-table-column>
    <el-table-column label="详细信息" width="300" align="center">
      <template slot-scope="scope">
          <router-link
          :to="{
            path: '/actordetail' ,
            query: { msgKeyOne: scope.row.name },
          }"
          >
        <el-button
          type="text"
          size="medium"
          >详情</el-button
        >
             </router-link
        >
      </template></el-table-column
    >
  </el-table>
</template>

<script>
export default {
  methods: {
  },
  created() {
    const _this = this;
    axios.get("http://121.5.109.66:8181/staff/findAllstaff").then(function (resp) {
      console.log(resp.data);
      _this.tableData = resp.data;
      console.log(_this.tableData);
    });
  },
  data() {
    return {
      tableData: [
        {
          name: "",
          id: "",
        },
      ],
    };
  },
};
</script>
