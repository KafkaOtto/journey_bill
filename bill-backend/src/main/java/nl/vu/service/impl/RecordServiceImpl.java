package nl.vu.service.impl;


import nl.vu.entity.Record;
import nl.vu.mapper.RecordMapper;
import nl.vu.service.RecordService;
import nl.vu.vo.RecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public ResponseEntity<RecordVO> findByRecordId(Integer recordId) {
        Record record = recordMapper.findByRecordId(recordId);
        RecordVO recordVO = RecordVO.builder()
                .recordId(record.getRecordId())
                .userId(record.getUserId())
                .activity(record.getActivity())
                .totalAmount(record.getTotalAmount())
                .time(record.getTime())
                .build();
        return ResponseEntity.ok(recordVO);
    }

    @Override
    public ResponseEntity<List<RecordVO>> findAllByUser(Integer userId) {
        List<Record> records = recordMapper.findAllByUser(userId);

        // Assuming RecordVO.builder() and related methods are properly implemented
        List<RecordVO> recordVOList = records.stream()
                .map(record -> RecordVO.builder()
                        .recordId(record.getRecordId())
                        .userId(record.getUserId())
                        .activity(record.getActivity())
                        .totalAmount(record.getTotalAmount())
                        .time(record.getTime())
                        .build())
                .collect(Collectors.toList());

        // Returning ResponseEntity with HTTP status OK and List<RecordVO> as the response body
        return ResponseEntity.ok(recordVOList);
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
