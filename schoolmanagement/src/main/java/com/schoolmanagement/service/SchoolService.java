package com.schoolmanagement.service;

import com.schoolmanagement.entity.School;
import com.schoolmanagement.repository.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {
    private final SchoolRepository schoolRepository;

    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public List<School> getAllSchools(){
        return schoolRepository.findAll();
    }

    public School saveSchool(School school) {
        return schoolRepository.save(school);
    }

    public School getSchoolById(Long id) {
        return schoolRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("School not found"));
    }

    public void deleteSchoolById(Long id) {
        schoolRepository.deleteById(id);
    }

}
