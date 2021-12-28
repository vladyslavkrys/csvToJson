package com.exam.exam.controller;

import com.exam.exam.entity.Schedule;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@CrossOrigin
@RestController
public class UploadDataController {

    @Operation(summary = "Convert data from CSV to the JSON")
    @PostMapping(value = "/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Please select a CSV file to upload.");
        } else {
            List<Schedule> schedules = convertCsvToObject(Schedule.class, file);
            return ResponseEntity.ok(schedules);
        }
    }

    private List<Schedule> convertCsvToObject(Class type, MultipartFile file) {
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            CsvToBean<Schedule> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(type)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            return csvToBean.parse();
        } catch (Exception ex) {
            throw new RuntimeException("An error occurred while processing the CSV file.");
        }
    }
}
