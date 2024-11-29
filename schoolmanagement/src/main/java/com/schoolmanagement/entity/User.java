package com.schoolmanagement.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
public class User {
    private long id;
    private String firstName;
    private String lastName;
    private String grade;
    private String EnrollmentDate;



}
