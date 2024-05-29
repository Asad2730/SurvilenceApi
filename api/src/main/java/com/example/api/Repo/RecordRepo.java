package com.example.api.Repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.api.Entity.RecordEntity;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RecordRepo extends JpaRepository<RecordEntity, Long> {
    List<RecordEntity> findByName(String name);
    List<RecordEntity> findByDate(LocalDate date);
}
