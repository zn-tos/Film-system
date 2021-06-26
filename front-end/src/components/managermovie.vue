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
        <el-menu-item index="1">电影信息</el-menu-item>
      </el-menu>
      <br />
      <!-- 点击触发add方法 -->
      <el-button type="primary" @click="add">新增</el-button>
      <el-table :data="tableData" style="text-align: center; width: 100%">
          <el-table-column
          prop="name"
          label="电影名称"
          width="50"
        ></el-table-column>
        <el-table-column
          prop="id"
          label="电影编号"
          width="50"
        ></el-table-column>
        <el-table-column
          prop="birthday"
          label="时间"
          width="50"
        ></el-table-column>
        <el-table-column prop="time" label="时长" width="40"></el-table-column>
        <el-table-column prop="lang" label="语言" width="50"></el-table-column>

        <el-table-column
          prop="country"
          label="国家"
          width="50"
        ></el-table-column>
        <el-table-column
          prop="brief"
          label="简介"
          width="300"
        ></el-table-column>
        <el-table-column prop="score" label="评分" width="40"></el-table-column>
        <el-table-column prop="pic" label="图片" width="50"></el-table-column>
        <el-table-column prop="cate" label="分类" width="50"></el-table-column>
        <el-table-column
          prop="campany"
          label="出品公司"
          width="100"
        ></el-table-column>
        <el-table-column label="操作" width="80">
          <template slot-scope="scope">
            <!-- 点击编辑进入编辑页面进行编辑表格数据
            <el-button size="small" @click="handleEdit(scope.$index, scope.row)">编辑</el-button> -->
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
    <el-dialog title="新增电影信息" :visible.sync="dialogFormVisible">
      <!-- 在el-dialog中进行嵌套el-form实现弹出表格的效果 -->
      <el-form :model="form" :rules="rules" ref="form">
        <el-form-item
          label="电影编号(不允许重复)"
          prop="id"
          :label-width="formLabelWidth"
        >
          <el-input
            v-if="mark > 0"
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
          label="电影名称"
          prop="name"
          :label-width="formLabelWidth"
        >
          <el-input v-model="form.name" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item
          label="出品时间"
          prop="birthday"
          :label-width="formLabelWidth"
        >
          <el-input v-model="form.birthday" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item
          label="电影时长"
          prop="time"
          :label-width="formLabelWidth"
        >
          <el-input v-model="form.time" auto-complete="off"></el-input>
        </el-form-item>

        <el-form-item label="类别" prop="cate" :label-width="formLabelWidth">
          <el-select v-model="form.cate" placeholder="请选择">
            <el-option
              v-for="(item,index) in cate"
              :key="index"
              :label="item"
              :value="item"
            >
            </el-option>
          </el-select>
        </el-form-item>
<!--
        <el-form-item
          label="图片"
          prop="pic"
          :label-width="formLabelWidth"
        >
          <el-upload
            class="avatar-uploader"
            action="http://121.5.109.66:8181/upload"
            :show-file-list="false"
            :on-remove="handleAvatarFail"
            :on-success="handleAvatarSuccess"
            :before-upload="beforeAvatarUpload"
          >
            <img
              v-if="form.pic"
              :src="require(`../assets/${form.pic}`)"
              class="avatar"
            />
            <i class="el-icon-plus avatar-uploader-icon"></i>
          </el-upload>
        </el-form-item>
-->


        <el-form-item
          label="出品公司"
          prop="campany"
          :label-width="formLabelWidth"
        >
          <el-select
            v-model="form.campany"
            placeholder="请选择"
      
          >
            <el-option
              v-for="item in campany"
              :key="item.index"
              :label="item"
              :value="item"
            >
            </el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="语言" prop="lang" :label-width="formLabelWidth">
          <el-input v-model="form.lang" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="国家" prop="country" :label-width="formLabelWidth">
          <el-input v-model="form.country" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="简介" prop="brief" :label-width="formLabelWidth">
          <el-input v-model="form.brief" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="评分" prop="score" :label-width="formLabelWidth">
          <el-input v-model="form.score" auto-complete="off"></el-input>
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
  name: "managermovie",
  data() {
    return {
      cate: [
      //  {cate: ''}
      ],
      campany: [
      //   {campany: ''}
      ],
      // option2: [],

      loading: true,
      //   表格的数据
      tableData: [
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
          cate: [],
          campany: [],
        },
      ],
      dialogFormVisible: false,
      formLabelWidth: "180px",
      // 设置form用于进行添加的时候绑定值
      form: {
        name: "",
        id: "",
        birthday: "",
        time: "",
        lang: "",
        country: "",
        brief: "",
        score: "",
        pic: "14.jpg",
        cate: "",
        campany: "",
      },
      rules: {
        id: [{ required: true, message: "请输入", trigger: "blur" }],
        name: [{ required: true, message: "请输入", trigger: "blur" }],
        birthday: [{ required: true, message: "请输入", trigger: "blur" }],
        time: [{ required: true, message: "请输入", trigger: "blur" }],
        lang: [{ required: true, message: "请输入", trigger: "blur" }],
        // image:[
        //   { required: true, message: "请输入", trigger: "blur" },
        // ],
        country: [{ required: true, message: "请输入", trigger: "blur" }],
        brief: [{ required: true, message: "请输入", trigger: "blur" }],
        score: [{ required: true, message: "请输入", trigger: "blur" }],
        cate: [{ required: true, message: "请输入", trigger: "blur" }],
        campany: [{ required: true, message: "请输入", trigger: "blur" }],
      },
      currentIndex: "",
      mark: 0,
    };
  },
  created() {
    //   设置回调函数，进行1.5秒的loading动画显示
    setTimeout(() => {
      this.loading = false;
    }, 1500);
    this.getcate();
    this.getcampany();
    this.getTableData();
  },
  watch: {
    //2.x版本的bug 以前用1.x发现没有 假如现在是第三页，只有一条数据了。将其删除，就没有第三页了。应该跳到第二页展示出5条数据。
    //可是数据没有展示。原因是获取list的时候page参数没有改变。依然是3
    total() {
      if (this.total == (this.page - 1) * this.size && this.total != 0) {
        this.page -= 1;
      }
    },
  },
  methods: {
    getcate() {
      const _this = this;
      axios.get("http://121.5.109.66:8181/getcateName").then(function (resp) {
        console.log(resp.data);
        _this.$data.cate = resp.data;
        console.log(_this.$data.cate);
      });

    },
    getcampany() {
      const _this = this;
      axios.get("http://121.5.109.66:8181/getcampanyName").then(function (resp) {
        console.log(resp.data);
        _this.$data.campany = resp.data;
        console.log(_this.$data.campany);
       
      }); 
    },
    getTableData() {
      const _this = this;
      axios.get("http://121.5.109.66:8181/getfilm").then(function (resp) {
        console.log(resp.data);
        _this.$data.tableData = resp.data;
        console.log(_this.$data.tableData);
        //var arr = []
        //arr.push({name:resp.data.name,id:resp.data.id,birthday:resp.data.birthday,lang:resp.data.lang,country:resp.data.country,brief:resp.data.brief,score:resp.data.score,pic:resp.data.pic})
        //this.$data.movies=arr;
        //console.log(this.$data.movies);
      });
    },

    // 增加数据的方式，单独的设置一些值，用于增加功能，这些值放在对象里面进行设置，然后将这个新增的对象塞到总数据里面
    add() {
      this.form = {
        name: "",
        id: "",
        birthday: "",
        time: "",
        lang: "",
        country: "",
        brief: "",
        score: "",
        pic: "14.jpg",
        cate: "",
        campany: "",
       
      };
      this.mark = 2;
      //   设置点击按钮之后进行显示对话框
      this.dialogFormVisible = true;
    },
    update(formName) {
      const _this=this;
      if (_this.mark > 1) _this.mark = 0;
      _this.$refs[formName].validate((valid) => {
        if (valid) {
          axios
            .post("http://121.5.109.66:8181/updatefilm", _this.form)
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
      if (this.mark > 1) this.mark = 0;
      // 将数据的index传递过来用于实现数据的回显
      this.form = this.tableData[index + (this.page - 1) * this.size];
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
            .post("http://121.5.109.66:8181/deletefilm", row)
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
      if (this.mark > 1) this.mark = 0;
      // 取消的时候直接设置对话框不可见即可
      this.dialogFormVisible = false;
    },
    handleSizeChange(val) {
      this.size = val;
    },
    handleCurrentChange(val) {
      this.page = val;
    },
    handleAvatarSuccess(res, file) {
      this.$message({
        type: "success",
        message: "图片上传成功,确认后刷新可见",
      });
      // this.form.image = URL.createObjectURL(file.raw);
      // console.log(this.form.image);
    },
    beforeAvatarUpload(file) {
      // const isJPG = file.type === 'image/jpeg';
      const isLt2M = file.size / 1024 / 1024 < 2;

      // if (!isJPG) {
      //   this.$message.error('上传头像图片只能是 JPG 格式!');
      // isJPG &&}
      if (!isLt2M) {
        this.$message.error("上传头像图片大小不能超过 2MB!");
      }
      return isLt2M;
    },
    handleAvatarFail(file, fileList) {
      console.log("文件已被移动");
    },
  },
};
</script>
<style >
</style>

