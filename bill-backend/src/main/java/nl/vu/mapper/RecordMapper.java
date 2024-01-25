package nl.vu.mapper;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import nl.vu.dto.RecordDTO;
import nl.vu.entity.Record;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecordMapper{
    public int addRecord(RecordDTO recordDTO);
    public int deleteRecord(Integer recordId);
    public Record findByRecordId(Integer recordId);
    public List<Record> findAllByUser(Integer userId);
}
