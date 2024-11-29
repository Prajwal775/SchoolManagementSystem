package com.schoolmanagement.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity

public class Role {
    private long id;
    private String name;
    private String description;
}
