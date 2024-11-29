package com.schoolmanagement.controller;

import com.schoolmanagement.entity.ClassRoom;
import com.schoolmanagement.entity.Subject;
import com.schoolmanagement.service.ClassRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/classrooms")
public class ClassRoomController {

    private final ClassRoomService classroomService;


    @GetMapping("/getAll")
    public List<ClassRoom> getAll() {
        return classroomService.getAllClassRooms();
    }

    // Create a new classroom
    @PostMapping("/create")
    public ResponseEntity<ClassRoom> createClassroom(@RequestBody ClassRoom classroom) {
        ClassRoom savedClassroom = classroomService.saveClassRoom(classroom);
        return new ResponseEntity<>(savedClassroom, HttpStatus.CREATED);
    }

    // Update a classroom
    @PutMapping("/{id}")
    public ResponseEntity<ClassRoom> updateClassroom(@PathVariable Long id, @RequestBody ClassRoom classroomDetails) {
        ClassRoom existingClassroom = classroomService.getClassRoomById(id);
        existingClassroom.setClassName(classroomDetails.getClassName());
        existingClassroom.setGradeLevel(classroomDetails.getGradeLevel());
        ClassRoom updatedClassroom = classroomService.saveClassRoom(existingClassroom);
        return ResponseEntity.ok(updatedClassroom);
    }

    // Delete a classroom
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClassroom(@PathVariable Long id) {
        classroomService.deleteClassRoomById(id);
        return ResponseEntity.noContent().build();
    }
}
