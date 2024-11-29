package com.schoolmanagement.controller;

import com.schoolmanagement.entity.School;
import com.schoolmanagement.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/schools")
public class SchoolController {

    private final SchoolService schoolService;


    @GetMapping("/getAll")
    private List<School> getAll(){
        return schoolService.getAllSchools();
    }

    // Create a new school
    @PostMapping("/create")
    public ResponseEntity<School> createSchool(@RequestBody School school) {
        School savedSchool = schoolService.saveSchool(school);
        return new ResponseEntity<>(savedSchool, HttpStatus.CREATED);
    }

    // Update an existing school
    @PutMapping("/{id}")
    public ResponseEntity<School> updateSchool(@PathVariable Long id, @RequestBody School schoolDetails) {
        School existingSchool = schoolService.getSchoolById(id);
        existingSchool.setName(schoolDetails.getName());
        existingSchool.setAddress(schoolDetails.getAddress());
        School updatedSchool = schoolService.saveSchool(existingSchool);
        return ResponseEntity.ok(updatedSchool);
    }

    // Delete a school
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchool(@PathVariable Long id) {
        schoolService.deleteSchoolById(id);
        return ResponseEntity.noContent().build();
    }
}
