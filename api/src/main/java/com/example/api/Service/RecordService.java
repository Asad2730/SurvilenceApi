package com.example.api.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.Entity.RecordEntity;
import com.example.api.Repo.RecordRepo;

import java.time.LocalDate;
import java.util.List;

@Service
public class RecordService {

    @Autowired
    private RecordRepo recordRepository;

    public RecordEntity insertRecord(String name, String vidPath, LocalDate date, int lengthOfVid) {
        var record = new RecordEntity();
        
        record.setName(name);
        record.setVidPath(vidPath);
        record.setDate(date);
        record.setLengthOfVid(lengthOfVid);
        return recordRepository.save(record);
    
    }

    public List<RecordEntity> getAllRecords() {
        return recordRepository.findAll();
    }

    public List<RecordEntity> getRecordByName(String name) {
        return recordRepository.findByName(name);
    }

    public List<RecordEntity> getRecordByDate(LocalDate date) {
        return recordRepository.findByDate(date);
    }
}
