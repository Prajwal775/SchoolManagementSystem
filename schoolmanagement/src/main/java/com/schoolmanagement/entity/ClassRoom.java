package com.schoolmanagement.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class ClassRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String className;
    private String gradeLevel;
    private String roomNumber;

//    @Column(name = "school_id", nullable = false, columnDefinition = "INT DEFAULT 1")
//    private Integer schoolId;

   @ManyToOne
            @JoinColumn(name = "school_id", nullable = false)
    private School school;
}
