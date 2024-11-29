package com.schoolmanagement.controller;

import com.schoolmanagement.entity.School;
import com.schoolmanagement.service.SchoolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schools")
public class SchoolController {
    public final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }
    //fetch schools

    @GetMapping
    public ResponseEntity<List<School>> getAllSchools() {
        List<School> schools = schoolService.getAllSchools();
        return ResponseEntity.ok(schools);
    }


    // Create a new school
    @PostMapping
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
