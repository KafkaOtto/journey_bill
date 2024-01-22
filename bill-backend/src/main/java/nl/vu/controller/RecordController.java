package nl.vu.controller;


import nl.vu.entity.Record;
import nl.vu.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "record", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
public class RecordController {

    @Autowired
    RecordService recordService;

    @GetMapping("/findByRecordId/{recordId}")
    public Record findByRecordId(@PathVariable Integer recordId){
        Record record = recordService.findByRecordId(recordId);
        return record;
    }

    @GetMapping("/recordsByUid/{userId}")
    public List<Record> findAllByUser(@PathVariable Integer userId){
        List<Record> record_list = recordService.findAllByUser(userId);
        return record_list;
    }

    @PostMapping("/")
    public String addRecord(@RequestBody Record record){
        int row  = recordService.addRecord(record);
        return "adding a new record successfully";
    }

    @DeleteMapping("/{record_id}")
    public String deleteRecord(@PathVariable int record_id){
        int row = recordService.deleteRecord(record_id);
        return "deleting record successfully";
    }

    @GetMapping("/getTotalByUid/{userId}")
    public float getTotal(@PathVariable int userId){
        return recordService.getTotal(userId);
    }

}
