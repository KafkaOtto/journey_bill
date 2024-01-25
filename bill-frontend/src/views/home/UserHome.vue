<template>
  <div>
    <div style="margin-left: 300px; margin-top: 10px;">
    <el-input
    placeholder="enter your recordID"
    v-model="recordId_"
    clearable
    size="small"
    style="width: 200px; margin-right: 10px; margin-bottom: 10px;" ></el-input>
    <el-button type="primary" round size="small" icon="el-icon-search"  @click="searchByRecordId(recordId_)">search</el-button>
    <el-button type="primary" round size="small" @click="dialogFormVisible = true" > adding <i class="el-icon-upload el-icon--right"></i></el-button>
    <el-dialog title="please adding your new bill📒 :)" :visible.sync="dialogFormVisible" width="40%" height="50%">
        <el-form :model="form" font-family="Hiragino Sans GB">
          <el-form-item label="acitivity" :label-width="formLabelWidth">
            <el-input v-model="form.activity" autocomplete="off" style="width: 70%" ></el-input>
          </el-form-item>
          <el-form-item label="date" :label-width="formLabelWidth">
            <el-input v-model="form.time" autocomplete="off" style="width: 70%" placeholder="2000-00-00"></el-input>
          </el-form-item>
          <el-form-item label="cost" :label-width="formLabelWidth">
            <el-input v-model="form.totalAmount" autocomplete="off" style="width: 70%" placeholder="00.00 $"></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="submit()">cancel</el-button>
          <el-button type="primary" @click="addRecord()"> yes </el-button>
        </div>
      </el-dialog>
    </div>
    <div v-if="isReloadData">
    <!-- show payment record  -->
    <el-table
      :data="tableData"
      stripe
      style="width: 90%"
      :default-sort = "{prop: 'date', order: 'descending'}">
      <el-table-column
        prop="time"
        label="Date"
        width="180"
        sortable="">
      </el-table-column>
      <el-table-column
        prop="activity"
        label="activity"
        width="180">
      </el-table-column>
      <el-table-column
        prop="totalAmount"
        label="Cost"
        sortable>
      </el-table-column>
      <el-table-column
        prop="recordId"
        label="Record ID"
        width="180">
      </el-table-column>
      <el-table-column label="Operate">
      <template slot-scope="scope">
        <el-button
          size="mini"
          type="danger"
          round
          @click = "deleteTheRecord(scope.row.recordId)">Delete Bill</el-button>
      </template>
     
    </el-table-column>
    </el-table>
  </div>

  <!-- split pages -->
  <!-- <div class="block" style="margin-top: 15px;">
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="currentPage4"
      :page-sizes="[10,20,30,40]"
      :page-size="10"
      layout="total, sizes, prev, pager, next, jumper"
      :total="400">
    </el-pagination>
  </div> -->

  </div>

</template>

<script>
import { recordsByUid } from "@/api/user";
import { deleteBill } from "@/api/user";
import { addBill } from "@/api/user";
import { recordsByRid } from "@/api/user";

  export default {
    data() {
      return {
        isReloadData:true,
        //for search bar and button
        recordId_:'',
        //table data
        tableData: [],
        

        currentPage1: 5,
        currentPage2: 5,
        currentPage3: 5,
        currentPage4: 4, 

        dialogTableVisible: false,
        dialogFormVisible: false,
        form: {               //form data to be uploaded
          activity: '',
          time: '',
          totalAmount: '',
          userId:''
        },
        formLabelWidth: '80px'
      }
    },
    created(){
      this.load();
    },
    methods: {
      //load()
      load(){
      var _this = this;
      var userId = Number(_this.$store.getters.getUserId);
      recordsByUid(userId).then((resp) => {
        console.log(resp.data)
        this.tableData = resp.data;
      });},
      reloadPart(){
        this.isReloadData = false
        this.$nextTick(()=>{
          this.isReloadData = true
        })
      },
      //find by recordId
      searchByRecordId(recordId){
        if(recordId === ''){
          this.$message({
          message: 'please enter the recordID in the search bar😭',
          type: 'danger'
        });
        }else{
          recordsByRid(recordId).then((resp) => {
          if(resp.status == 200){
              console.log(resp.data)
              this.tableData = [resp.data]
              this.reloadPart()
            }
          else{
            this.$message({
            message: data.detail,
            type: 'danger'
            });
        }
        })
        }
      }
      ,
      //delete service
      deleteTheRecord(recordId){
        
        deleteBill(recordId).then((resp) => {
          console.log(resp)
        if(resp.status == 200){
          this.$message({
        message: 'delete successfully',
        type: 'success'
        });
          this.load();
        }
        else{
          this.$message({
          message: "delete fail",
          type: 'danger'
          });
          this.load();
        }
        });},
      //adding a new record
      addRecord(){

        var userId = Number(this.$store.getters.getUserId);
        this.form.userId = userId;
        this.form.totalAmount = Number(this.form.totalAmount);
        console.log("提交的信息：",this.form)
        addBill(this.form).then(res => {
        if (res.status == 200) {
        this.$message({
        message: 'add successfully',
        type: 'success'
      });
      this.dialogFormVisible = false;
      this.load();
      } else {
      this.$message({
        message: res.detail,
        type: 'danger'
      });
    }
  })
      }
      ,
      handleSizeChange(val) {
        console.log(`每页 ${val} 条`);
      },
      handleCurrentChange(val) {
        console.log(`当前 : ${val}`);
      }
    }
  }
</script>
