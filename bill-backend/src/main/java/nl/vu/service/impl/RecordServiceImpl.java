package nl.vu.service.impl;


import nl.vu.entity.Record;
import nl.vu.mapper.RecordMapper;
import nl.vu.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    RecordMapper recordMapper;

    @Override
    public int addRecord(Record record) {
        int record_id = recordMapper.addRecord(record);
        return record_id;
    }

    @Override
    public int deleteRecord(Integer recordId) {
        int row_num = recordMapper.deleteRecord(recordId);
        return row_num;
    }

    @Override
    public Record findByRecordId(Integer recordId) {
        Record record = recordMapper.findByRecordId(recordId);
        return record;
    }

    @Override
    public List<Record> findAllByUser(Integer userId) {
        List<Record> list = recordMapper.findAllByUser(userId);
        return list;
    }

    @Override
    public float getTotal(Integer userId) {
        List<Record> record_list = recordMapper.findAllByUser(userId);
        float total = 0.0F;
        for (Record record : record_list) {
            float amount = record.getTotalAmount();
            total += amount;
        }
        return total;
    }
}
