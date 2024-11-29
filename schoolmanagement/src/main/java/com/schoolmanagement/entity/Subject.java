package com.schoolmanagement.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Subject {
    private Long id;
    private String name;
    private String credits;

}
