package com.schoolmanagement.controller;

import com.schoolmanagement.entity.Subject;
import com.schoolmanagement.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/subjects")
public class SubjectController {

    private final SubjectService subjectService;


    @GetMapping("/getAll")
    public List<Subject> getAll() {
        return subjectService.getAllSubjects();
    }

    // Add a new subject
    @PostMapping("/createSubject")
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
