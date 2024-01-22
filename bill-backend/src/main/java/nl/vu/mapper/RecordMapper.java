package nl.vu.mapper;

import nl.vu.entity.Record;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecordMapper {
    public int addRecord(Record record);
    public int deleteRecord(Integer recordId);
    public Record findByRecordId(Integer recordId);
    public List<Record> findAllByUser(Integer userId);
}
