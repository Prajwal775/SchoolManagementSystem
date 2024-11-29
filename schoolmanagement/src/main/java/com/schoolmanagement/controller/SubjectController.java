package com.schoolmanagement.controller;

import com.schoolmanagement.entity.Subject;
import com.schoolmanagement.service.SubjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    // Fetch all subjects taught in a specific school
    @GetMapping("/school/{schoolId}")
    public ResponseEntity<List<Subject>> getAllSubjectsBySchool(@PathVariable Long schoolId) {
        List<Subject> subjects = subjectService.getAllSubjects();
        return ResponseEntity.ok(subjects);
    }

    // Add a new subject
    @PostMapping
    public ResponseEntity<Subject> createSubject(@RequestBody Subject subject) {
        Subject savedSubject = subjectService.saveSubject(subject);
        return new ResponseEntity<>(savedSubject, HttpStatus.CREATED);
    }

    // Update a subject
    @PutMapping("/{id}")
    public ResponseEntity<Subject> updateSubject(@PathVariable Long id, @RequestBody Subject subjectDetails) {
        Subject existingSubject = subjectService.getSubjectById(id);
        existingSubject.setName(subjectDetails.getName());
        existingSubject.setCredits(subjectDetails.getCredits());
        Subject updatedSubject = subjectService.saveSubject(existingSubject);
        return ResponseEntity.ok(updatedSubject);
    }

    // Delete a subject
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubject(@PathVariable Long id) {
        subjectService.deleteSubjectById(id);
        return ResponseEntity.noContent().build();
    }
}
