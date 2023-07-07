<template>
  <body>
    <head>
      <link
        rel="stylesheet"
        href="http://at.alicdn.com/t/c/font_4098090_nx9t38xfkzc.css"
      />
      <link
        rel="stylesheet"
        href="http://at.alicdn.com/t/c/font_4114555_tl0gx85xamn.css"
      />
    </head>
    <nava />
    <main>
      <div class="alert-container">
        <el-alert
          v-for="(item, index) in err_mess"
          :key="index"
          :title="item.message"
          :type="item.type"
          :show-icon="true"
          :center="center"
          :class="['alerted']"
        ></el-alert>
      </div>
      <section class="section-hero">
        <div class="hero">
          <div class="search-bar">
            <el-button
              type="success"
              style="align-self: flex-end"
              @click="addNewUser"
              >Add User</el-button
            >
            <div class="search-inner">
              <div class="searchById">
                <div class="block">
                  <span class="demonstration">Search Name</span>
                  <el-input
                    v-model="nameSearch"
                    placeholder="Search by Name"
                    class="id-search"
                  />
                </div>
              </div>
              <div class="demo-date-picker">
                <div class="block">
                  <span class="demonstration">Date Range</span>
                  <el-date-picker
                    v-model="date_value"
                    type="daterange"
                    start-placeholder="Start Date"
                    end-placeholder="End Date"
                    :default-value="[
                      new Date(),
                      new Date(),
                    ]"
                  />
                </div>
              </div>
              <el-button
                type="success"
                style="align-self: flex-end"
                @click="searchUsers"
                >Search</el-button
              >
            </div>
          </div>

          <el-table
            :data="tableData"
            style="width: 100%"
            :row-class-name="tableRowClassName"
          >
            <el-table-column label="ID" prop="id" />
            <el-table-column label="time" prop="createTime" v-slot="scope">
              <div>{{ String(scope.row.createTime).split("T")[0] }}</div>
              <div>{{ String(scope.row.createTime).split("T")[1] }}</div>

              <!-- {{
              
              String(scope.row.createTime).replace("T", "")
            }} -->
            </el-table-column>
            <el-table-column label="User Name" prop="username" />
            <el-table-column label="Is Admin" prop="permission" v-slot="scope">
              <el-tag
                :type="scope.row.permission == 4 ? 'success' : 'error'"
                disable-transitions
                >{{ scope.row.permission == 4 ? "YES" : "NO" }}
              </el-tag>
            </el-table-column>
            <el-table-column label="TOFEL" prop="toefl" width="80" />
            <el-table-column label="IELTS" prop="ielts" width="80" />
            <el-table-column label="GRE" prop="gre" />

            <el-table-column align="right">
              <template #default="scope">
                <el-button
                  type="success"
                  plain
                  @click="handleEdit(scope.$index, scope.row)"
                  >Edit</el-button
                >
                <el-button
                  type="danger"
                  plain
                  @click="handleDelete(scope.$index, scope.row)"
                  >Delete</el-button
                >
              </template>
            </el-table-column>
          </el-table>
        </div>
      </section>
    </main>
    <el-dialog v-model="dialogFormVisible" title="User Info" class="popWindow">
      <el-form :model="form">
        <el-form-item label="User Name" :label-width="formLabelWidth">
          <el-input v-model="form.usName" autocomplete="off" />
        </el-form-item>

        <el-form-item label="TOFEL Pr" :label-width="formLabelWidth">
          <el-input v-model="form.tofel" autocomplete="off" />
        </el-form-item>
        <el-form-item label="ELTS Pr" :label-width="formLabelWidth">
          <el-input v-model="form.elts" autocomplete="off" />
        </el-form-item>
        <el-form-item label="GRE Pr" :label-width="formLabelWidth">
          <el-input v-model="form.gre" autocomplete="off" />
        </el-form-item>
        <el-form-item label="is Admin" :label-width="formLabelWidth">
          <!-- <el-input v-model="form.isAdmin" autocomplete="off" /> -->
          <el-radio-group v-model="form.isAdmin" class="ml-4">
            <el-radio label="4" size="large">YES</el-radio>
            <el-radio label="0" size="large">NO</el-radio>
          </el-radio-group>
        </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="dialogFormVisible = false">Cancel</el-button>
          <el-button type="success" plain @click="editUpdate">
            Confirm
          </el-button>
        </span>
      </template>
    </el-dialog>
    <el-dialog v-model="addFormVisible" title="User Info" class="popWindow">
      <el-form :model="form">
        <el-form-item label="User Name" :label-width="formLabelWidth">
          <el-input v-model="form.usName" autocomplete="off" />
        </el-form-item>
        <el-form-item label="Password" :label-width="formLabelWidth">
          <el-input v-model="form.password" autocomplete="off" />
        </el-form-item>
        <el-form-item label="is Admin" :label-width="formLabelWidth">
          <el-radio-group v-model="form.isAdmin" class="ml-4">
            <el-radio label="4" size="large">YES</el-radio>
            <el-radio label="0" size="large">NO</el-radio>
          </el-radio-group>
        </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="addFormVisible = false">Cancel</el-button>
          <el-button type="success" plain @click="addUpdate">
            Confirm
          </el-button>
        </span>
      </template>
    </el-dialog>
  </body>
</template>

<script>
import { ref } from "vue";
export default {
  name: "manager",
  props: {},
  data() {
    return {
      tableData: [1, 2],
      search: "",
      nameSearch: "",
      date_value: null,
      dialogFormVisible: false,
      addFormVisible: false,
      formLabelWidth: "120px",
      form: {
        password: "",
        usName: "",
        isAdmin: "0",
        tofel: "",
        elts: "",
        gre: "",
        id: "",
      },

      err_mess: [],
    };
  },
  // setup() {
  //     const usName= ref("");
  //     return
  //   },

  beforeCreate() {
    const Vtoken = localStorage.getItem('token');
    if (Vtoken) {
        fetch("http://139.196.197.42:8085/adminInterceptor", {
              'headers': {
                  'token': Vtoken
              }
        }).then(response => response.json())
              .then(data => {
                  if (data.code == 0)
                  this.$router.push({path: "/login"})
              }).catch(error => console.log(error));
    }
    else {
      this.$router.push({path: "/login"})
    }
  },

  mounted() {

    this.getUserInfo();
  },

  methods: {
    handleEdit: function (index, row) {
      this.dialogFormVisible = !this.dialogFormVisible;
      fetch(`http://139.196.197.42:8085/admin/${row.id}`, {
        method: "Get",
        headers: {
          token: localStorage.getItem("token"),
        },
      })
        .then((response) => response.json())
        .then((data) => {
          // console.log(data.data);
          if (data.code == 1) {
            this.form.usName = data.data.username;
            this.form.isAdmin = String(data.data.permission);
            this.form.tofel = data.data.toefl;
            this.form.elts = data.data.ielts;
            this.form.gre = data.data.gre;
            this.form.id = data.data.id;

            // this.tableData.splice(index, 1);
          } else {
            this.showAlert(data.msg, "error");
          }
        })
        .catch((error) => {
          this.showAlert("Search Failed!", "error");
        });
    },
    handleDelete: function (index, row) {
      // console.log(index, row);

      fetch(`http://139.196.197.42:8085/admin/${row.id}`, {
        method: "Delete",
        headers: {
          token: localStorage.getItem("token"),
        },
      })
        .then((response) => response.json())
        .then((data) => {
          if (data.code == 1) {
            this.tableData.splice(index, 1);
          } else {
            this.showAlert(data.msg, "error");
          }
        })
        .catch((error) => {
          this.showAlert("Delete Failed!", "error");
        });
      this.showAlert("Successfully Deleted!", "success");
    },
    addNewUser: function () {
      this.addFormVisible = !this.addFormVisible;
      this.form.password = "";
      this.form.usName = "";
      this.form.isAdmin = "0";
      this.form.tofel = 0;
      this.form.elts = 0;
      this.form.gre = 0;
      this.form.id = "";
    },
    tableRowClassName: function ({ row, rowIndex }) {
      return "custom";
    },
    editUpdate: function () {
      fetch("http://139.196.197.42:8085/admin", {
        method: "Put",
        headers: {
          token: localStorage.getItem("token"),
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          id: this.form.id,
          username: this.form.usName,
          permission: this.form.isAdmin,
          toefl: this.form.tofel,
          ielts: this.form.elts,
          gre: this.form.gre,
        }),
      })
        .then((response) => response.json())
        .then((data) => {
          if (data.code == 1) {
            this.showAlert("Edit Successfully!", "success");
            this.getUserInfo();
            this.dialogFormVisible = !this.dialogFormVisible;
          } else {
            this.showAlert(data.msg, "error");
            this.dialogFormVisible = !this.dialogFormVisible;
          }
        })
        .catch((error) => {
          this.showAlert("Edit Failed!", "error");
        });
    },
    addUpdate: function () {
      fetch(`http://139.196.197.42:8085/admin`, {
        method: "Post",
        headers: {
          token: localStorage.getItem("token"),
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          username: this.form.usName,
          password: this.form.password,
          permission: this.form.isAdmin,
        }),
      })
        .then((response) => response.json())
        .then((data) => {
          // console.log(data.data);
          if (data.code == 1) {
            this.showAlert("Add User Successfully", "success");
            this.getUserInfo();
            this.addFormVisible = !this.addFormVisible;
            // this.tableData.splice(index, 1);
          } else {
            this.showAlert(data.msg, "error");
            this.addFormVisible = !this.addFormVisible;
          }
        })
        .catch((error) => {
          this.showAlert("Add User Failed!", "error");
        });
    },
    searchUsers: function () {
      // console.log(this.date_value[0]);
      if (this.date_value == null && this.nameSearch.length == 0) {
        this.showAlert("Please enter name or time range!", "error");
        // return;
      }

      let converted_time = [];
      let targetPath = `http://139.196.197.42:8085/admin?keyword=${this.nameSearch}`;

      if (this.date_value != null) {
        for (let i = 0; i < this.date_value.length; i++) {
          let d = this.date_value[i];
          converted_time.push(d.toISOString().split("T")[0]);
          if (converted_time.length == 2) {
            targetPath += `&begin=${converted_time[0]}&end=${converted_time[1]}`;
          }
        }
      }
      fetch(targetPath, {
        method: "GET",
        headers: {
          token: localStorage.getItem("token"),
        },
      })
        .then((response) => response.json())
        .then((data) => {
          console.log(data);

          this.tableData = data.data.rows;
        })
        .catch((error) => console.log(error));
    },
    getUserInfo: function () {
      fetch("http://139.196.197.42:8085/admin", {
        method: "GET",
        headers: {
          token: localStorage.getItem("token"),
        },
      })
        .then((response) => response.json())
        .then((data) => {
          // console.log(data.data.rows);
          this.tableData = data.data.rows;
        })
        .catch((error) => console.log(error));
    },
    showAlert: function (message, type, duration = 2000) {
      this.err_mess.push({
        message: message,
        type: type,
      });
      // 设置自动关闭计时器
      if (duration > 0) {
        setTimeout(() => {
          this.err_mess.shift();
        }, duration);
      }
    },
  },
};
</script>

<style>
.header-cell {
  background-color: #eaf7f1;
}

.searchById {
  align-self: flex-end;
  width: 50%;
  display: flex;
  gap: 10px;
}

* {
  padding: 0;
  margin: 0;
  box-sizing: border-box;
}

html {
  font-size: 10px;
}

body {
  font-family: sans-serif;
  line-height: 1;
  font-weight: 400;
  color: #555;
}

*:focus {
  outline: none;

}

.alert-container {
  position: absolute;
  top: 10%;
  left: 50%;
  transform: translateX(-50%);
  /* max-width: 350px; */
  z-index: 50;
  height: 50px;
  width: 600px;
}

.popWindow {
  border-radius: 15px;
  /* background-color: #dcffe3; */
}

.id-search {
  /* width: 30%; */
  align-self: flex-end;
}

.section-hero {
  background-color: #ebfbee;
  padding: 48px 0 96px 0;

  height: 90vh;
}

.hero {
  max-width: 1300px;
  margin: 0 auto;
  padding: 0 32px;
  /* display: grid;
  grid-template-columns: 60fr 40fr; */
  gap: 14px;
  align-items: center;

  text-align: center;

  height: 70vh;
}
.el-table {
  --el-table-tr-bg-color: #dcffe3;
  --el-table-header-bg-color: #40c057;
  --el-table-header-text-color: #fff;
  border-radius: 15px;
  box-shadow: 0 24px 48px rgba(0, 0, 0, 0.075);
}

.el-table .el-button--small {
  font-size: 12px;
}

.el-table .el-button {
  padding: 8px 15px;
}

.demo-date-picker {
  display: flex;
  /* width: 100%; */
  padding: 0;
  flex-wrap: wrap;
  gap: 10px;
}
.block {
  /* padding: 30px 0; */
  text-align: center;
  /* border-right: solid 1px var(--el-border-color); */
  flex: 1;
}
.block:last-child {
  border-right: none;
}
.demonstration {
  display: block;
  color: #40c057;
  font-size: 15px;
  font-weight: 700;
  margin-bottom: 20px;
}

.search-bar {
  display: flex;
  justify-content: space-between;
  align-items: center;
  /* justify-content: center; */
  /* gap: 40px; */
  margin-bottom: 40px;
}

.search-inner {
  display: flex;
  gap: 40px;
}
</style>
