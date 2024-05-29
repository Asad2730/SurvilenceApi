package com.example.api.Controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.api.Service.RecordService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/records")
public class RecordController {

    
    private String uploadDir = "src/main/resources/static/uploads";

    private final RecordService recordService;

    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    @PostMapping("/")
    public ResponseEntity<?> uploadVideo(@RequestParam("name") String name,
                                              @RequestParam("file") MultipartFile file,
                                              @RequestParam("date") String date,
                                              @RequestParam("lengthOfVid") int lengthOfVid) {
        try {
            @SuppressWarnings("null")
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            Path targetLocation = Paths.get(uploadDir).resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation);
            var record = recordService.insertRecord(name, targetLocation.toString(), LocalDate.parse(date), lengthOfVid);
            return ResponseEntity.ok(record);
        } catch (IOException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/")
    public List<?> getAllRecords() {
        return recordService.getAllRecords();
    }

    @GetMapping("/name/{name}")
    public List<?> getRecordByName(@PathVariable String name) {
        return recordService.getRecordByName(name);
    }

    @GetMapping("/date/{date}")
    public List<?> getRecordByDate(@PathVariable String date) {
        return recordService.getRecordByDate(LocalDate.parse(date));
    }
}
