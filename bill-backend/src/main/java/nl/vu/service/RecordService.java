package nl.vu.service;

import nl.vu.dto.RecordDTO;
import nl.vu.entity.Record;
import nl.vu.vo.RecordVO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RecordService {
    public int addRecord(RecordDTO recordDTO);
    public int deleteRecord(Integer recordId);
    public ResponseEntity<RecordVO> findByRecordId(Integer recordId);
    public ResponseEntity<List<RecordVO>> findAllByUser(Integer userId);
    public float getTotal(Integer userId);
}
