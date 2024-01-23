<template>
    <el-table
      :data="tableData"
      stripe
      style="width: 100%"
      :default-sort = "{prop: 'date', order: 'descending'}">
      <el-table-column
        prop="date"
        label="Date"
        width="180"
        sortable="">
      </el-table-column>
      <el-table-column
        prop="location"
        label="Location"
        width="180">
      </el-table-column>
      <el-table-column
        prop="money"
        label="Cost"
        sortable>
      </el-table-column>
      <el-table-column label="Operate">
      <template slot-scope="scope">
        <el-button
          size="mini"
          type="danger"
          round
          @click="handleDelete(scope.$index, scope.row)">Delete Bill</el-button>
      </template>
     
    </el-table-column>
   
    
    </el-table>
  </template>

  <script>
    export default {
      data() {
        return {
          tableData: [{
            date: '2016-05-02',
            location: 'Madrid',
            money: 113
          }, {
            date: '2019-05-02',
            location: 'Amsterdam',
            money: 245
          }, {
            date: '2023-05-02',
            location: 'London',
            money: 13.77
          }, {
            date: '2020-05-02',
            location: 'Paris',
            money: 751.8888
          }]
        }
      }
    }
  </script>


// mounted() {
    //   axios.get('你的API端点')
    //     .then(response => {
    //       this.items = response.data;
    //     })
    //     .catch(error => {
    //       console.error("Error fetching data:", error);
    //     });
    // }