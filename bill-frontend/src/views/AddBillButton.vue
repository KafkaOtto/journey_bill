<template>
    <el-container>
        <el-button
            type="primary"
            round
            @click="dialogVisible=true">Add a bill
        </el-button>

        <el-dialog
            title="Enter the info of new bill"
            :visible.sync="dialogVisible"
            width="30%"
            :before-close="handleClose">
            <el-input
                placeholder="Date"
                v-model="submitForm.date">
            </el-input>
            <el-input
                size="medium"
                placeholder="Location"
                v-model="submitForm.location">
            </el-input>
            <el-input
                size="small"
                placeholder="Costs"
                v-model="submitForm.money">
            </el-input>
            <span slot="footer" class="dialog-footer">
            <el-button @click="dialogVisible = false">Discard</el-button>
            <el-button type="primary" @click="submitBill(submitForm)">Submit</el-button>
            </span>
        </el-dialog>
    </el-container>
</template>



<script>
  import { addBill } from '../api/user';
  import { getBills } from '../api/user';
  export default {
    data() {
      return {
        dialogVisible: false,
        // input1:'',
        // input2:'',
        // input3:'',
        submitForm: {
          date: "",
          location: "",
          money: ""
        }
      };
    },
    methods: {
      handleClose(done) {
        this.$confirm('Are you sure?')
          .then(_ => {
            done();
          })
          .catch(_ => {});
      },
      submitBill(submitForm) {
        this.dialogVisible = false
        addBill(submitForm)
        getBills(1) // 此处应为email或者userID
      }
    }
  };
</script>