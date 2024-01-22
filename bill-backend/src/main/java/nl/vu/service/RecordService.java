package nl.vu.service;

import nl.vu.entity.Record;

import java.util.List;

public interface RecordService {
    public int addRecord(Record record);
    public int deleteRecord(Integer recordId);
    public Record findByRecordId(Integer recordId);
    public List<Record> findAllByUser(Integer userId);
    public float getTotal(Integer userId);
}
