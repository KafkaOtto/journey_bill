package nl.vu.controller;


import nl.vu.dto.RecordDTO;
import nl.vu.entity.Record;
import nl.vu.result.Result;
import nl.vu.service.RecordService;
import nl.vu.vo.RecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping(value = "api/record", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
public class RecordController {

    @Autowired
    RecordService recordService;

    @GetMapping("/findByRecordId/{recordId}")
    public ResponseEntity<RecordVO> findByRecordId(@PathVariable Integer recordId){
        return recordService.findByRecordId(recordId);
    }

    @GetMapping("/recordsByUid/{userId}")
    public ResponseEntity<List<RecordVO>> findAllByUser(@PathVariable Integer userId){
        return recordService.findAllByUser(userId);
    }

    @PostMapping("/")
    public Result addRecord(@RequestBody RecordDTO recordDTO){
        try{
            System.out.println(recordDTO);
            return new Result(200, "adding a new record successfully", recordService.addRecord(recordDTO));
        }catch (Exception e) {
            System.out.println(e);
            // If an exception occurs during the updateUser operation, you might handle it here
            return new Result(500, "Error: adding a new record: " + e.getMessage(), null);
        }
    }


    @DeleteMapping("/{record_id}")
    public Result deleteRecord(@PathVariable int record_id){
        try{
            return new Result(200, "deleting a new record successfully", recordService.deleteRecord(record_id));
        }catch (Exception e) {
            // If an exception occurs during the updateUser operation, you might handle it here
            return new Result(500, "Error: deleting a new record: " + e.getMessage(), null);
        }
    }

    @GetMapping("/getTotalByUid/{userId}")
    public Result getTotal(@PathVariable int userId){
        try{
            return new Result(200, "ok", recordService.getTotal(userId));
        }catch (Exception e) {
            // If an exception occurs during the updateUser operation, you might handle it here
            return new Result(500, "Error: calculating the total amount" + e.getMessage(), null);
        }
    }

}
