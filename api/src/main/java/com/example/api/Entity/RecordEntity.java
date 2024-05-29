package com.example.api.Entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "record")
public class RecordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

    @Column(unique = true)
    private String name;

     String vidPath;
     private LocalDate date;
     private int lengthOfVid;
   
    
    public Long getId() {
        return id;
    }
  
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getVidPath() {
        return vidPath;
    }
    public void setVidPath(String vidPath) {
        this.vidPath = vidPath;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public int getLengthOfVid() {
        return lengthOfVid;
    }
    public void setLengthOfVid(int lengthOfVid) {
        this.lengthOfVid = lengthOfVid;
    }
  

}

