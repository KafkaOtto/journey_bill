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
                v-model="input1">
            </el-input>
            <el-input
                size="medium"
                placeholder="Location"
                v-model="input2">
            </el-input>
            <el-input
                size="small"
                placeholder="Costs"
                v-model="input3">
            </el-input>
            <span slot="footer" class="dialog-footer">
            <el-button @click="dialogVisible = false">Discard</el-button>
            <el-button type="primary" @click="dialogVisible = false">Submit</el-button>
            </span>
        </el-dialog>
    </el-container>
</template>



<script>
  export default {
    data() {
      return {
        dialogVisible: false,
        input1:'',
        input2:'',
        input3:''
      };
    },
    methods: {
      handleClose(done) {
        this.$confirm('Are you sure?')
          .then(_ => {
            done();
          })
          .catch(_ => {});
      }
    }
  };
</script>