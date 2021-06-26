<template>
  <div>
    <div>
      <el-menu
        :default-active="this.$route.path"
        class="el-menu-demo"
        mode="horizontal"
        background-color="#545c64"
        text-color="#fff"
        active-text-color="#ffd04b"
      >
        <el-menu-item index="1">公司列表</el-menu-item>
      </el-menu>
      <br />
      <!-- 点击触发add方法 -->
      <el-button type="primary" @click="add">新增</el-button>
      <el-table :data="tableData" style="text-align: center; width: 100%">
        <!--        <el-table-column prop="id" label="序号" width="180"></el-table-columntype="index">-->
        <el-table-column
          prop="city"
          label="所在城市"
          width="100"
        ></el-table-column>
        <el-table-column
          prop="name"
          label="公司名称"
          width="200"
        ></el-table-column>
                <el-table-column
          prop="id"
          label="公司编号"
          width="100"
        ></el-table-column>
        <el-table-column
          prop="brief"
          label="公司简介"
          width="400"
        ></el-table-column>
        <el-table-column label="操作" width="100">
          <template slot-scope="scope">
            <!-- 点击编辑进入编辑页面进行编辑表格数据 -->
            <el-button
              size="small"
              type="danger"
              @click="handleDelete(scope.$index, scope.row)"
              >删除</el-button
            >
          </template>
        </el-table-column>
      </el-table>
    </div>

    <!-- 下面这个用来设置点击添加按钮的弹出框，里面可以进行嵌套表格来展示弹出的表格信息,使用下面的:visible.sync来控制显示与否 -->
    <!-- 里面绑定的是我们新设置的值，填写完成后，将我们这个新值塞到页面中所有的数据当中去 -->
    <el-dialog title="类别信息" :visible.sync="dialogFormVisible">
      <!-- 在el-dialog中进行嵌套el-form实现弹出表格的效果 -->
      <el-form :model="form" :rules="rules" ref="form">
        <el-form-item
          label="公司编号(不允许重复)"
          prop="id"
          :label-width="formLabelWidth"
        >
          <el-input
            v-if="mark > 1"
            v-model="form.id"
            auto-complete="off"
          ></el-input>
          <el-input
            v-else
            v-model="form.id"
            auto-complete="off"
            disabled
          ></el-input>
        </el-form-item>
        <el-form-item
          label="公司名称"
          prop="name"
          :label-width="formLabelWidth"
        >
          <el-input v-model="form.name" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item
          label="所在城市"
          prop="city"
          :label-width="formLabelWidth"
        >
          <el-input v-model="form.city" auto-complete="off"></el-input>
        </el-form-item>        <el-form-item
          label="公司简介"
          prop="brief"
          :label-width="formLabelWidth"
        >
          <el-input v-model="form.brief" auto-complete="off"></el-input>
        </el-form-item>

        <el-form-item style="text-align: right">
          <el-button @click="cancel">取 消</el-button>
          <!-- 设置触发更新的方法 -->
          <el-button type="primary" @click="update('form')">确 定</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script type="text/ecmascript-6">
export default {
  name:'managecate',
  data() {
    return {
size:'',
page:'',
      loading: true,
      //   表格的数据
      tableData: [
        {
          id:'',
          name:'',
            city:'',
            brief:'',
        //pic:'',
        }
      ],
      dialogFormVisible: false,
      formLabelWidth: "180px",
      // 设置form用于进行添加的时候绑定值
      form: {
        id: "",
        name: "",
        city:'',
        brief:'',
        pic:'C16.jpg',
      },
      rules:{
        id: [
          { required: true, message: "请输入", trigger: "blur" },
        ],
        name: [
          { required: true, message: "请输入", trigger: "blur" },
        ],
        city: [
          { required: true, message: "请输入", trigger: "blur" },
        ],
        brief: [
          { required: true, message: "请输入", trigger: "blur" },
        ],
      },
      currentIndex: "",
      mark:0
    };
  },
  created() {
    //   设置回调函数，进行1.5秒的loading动画显示
    setTimeout(() => {
      this.loading = false;
    }, 1500);
    this.getTableData();
  },
  watch:{
    //2.x版本的bug 以前用1.x发现没有 假如现在是第三页，只有一条数据了。将其删除，就没有第三页了。应该跳到第二页展示出5条数据。
    //可是数据没有展示。原因是获取list的时候page参数没有改变。依然是3
  },
  methods: {
    getTableData(){
       const _this = this;
      axios.get("http://121.5.109.66:8181/getcampany").then(function (resp) {
        console.log(resp.data);
        _this.$data.tableData = resp.data;
        console.log(_this.$data.tableData);

      });
    },
    // 增加数据的方式，单独的设置一些值，用于增加功能，这些值放在对象里面进行设置，然后将这个新增的对象塞到总数据里面
    add() {
      this.form = {
         id: "",
        name: "",
        city:'',
        brief:'',
        pic:'C16.jpg',

      };
      this.mark=2;
      //   设置点击按钮之后进行显示对话框
      this.dialogFormVisible = true;
    },
    update(formName) {
      const _this=this;
      if (_this.mark > 1) _this.mark = 0;
      _this.$refs[formName].validate((valid) => {
        if (valid) {
          axios
            .post("http://121.5.109.66:8181/updatecampany", _this.form)
            .then((resp) => {
              let data = resp.data.data;
              _this.tableData.push(_this.form);
              _this.dialogFormVisible = false;
                window.location.reload();
            });
        }
      });
      },
    handleEdit(index, row) {
      if(this.mark>1) this.mark=0;
      // 将数据的index传递过来用于实现数据的回显
      this.form = this.tableData[index+(this.page-1)*this.size];
      // 设置对话框的可见
      this.dialogFormVisible = true;
    },
    handleDelete(index, row) {
      // 设置类似于console类型的功能
      this.$confirm("永久删除, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          const _this=this;
          axios
            .post("http://121.5.109.66:8181/deletecampany", row)
            .then((resp) => {
                              _this.dialogFormVisible = false;
              window.location.reload();
            });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除",
          });
        });
    },
    cancel() {
      if(this.mark>1) this.mark=0;
      // 取消的时候直接设置对话框不可见即可
      this.dialogFormVisible = false;
    },
    handleSizeChange(val){
      this.size = val;
    },
    handleCurrentChange(val) {
      this.page = val;
    }
  }
};
</script>
<style >
</style>

