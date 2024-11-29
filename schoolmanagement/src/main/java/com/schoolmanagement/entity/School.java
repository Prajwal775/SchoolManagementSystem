package com.schoolmanagement.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String address;


    @OneToMany(mappedBy = "school", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<ClassRoom> classRoomList = new ArrayList<>();


}
