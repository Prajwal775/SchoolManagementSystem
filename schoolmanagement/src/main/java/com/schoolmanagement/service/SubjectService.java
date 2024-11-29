package com.schoolmanagement.service;

import com.schoolmanagement.entity.Subject;
import com.schoolmanagement.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    // Get all subjects for a specific school
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    // Save a new subject
    public Subject saveSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    // Get a subject by its ID
    public Subject getSubjectById(Long id) {
        return subjectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Subject not found"));
    }

    // Delete a subject by its ID
    public void deleteSubjectById(Long id) {
        subjectRepository.deleteById(id);
    }
}
