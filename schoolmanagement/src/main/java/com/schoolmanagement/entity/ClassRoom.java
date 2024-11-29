package com.schoolmanagement.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class ClassRoom {
    private Long id;

    private String className;
    private String gradeLevel;
    private String roomNumber;
}
