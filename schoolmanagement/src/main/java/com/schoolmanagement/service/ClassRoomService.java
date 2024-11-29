package com.schoolmanagement.service;

import com.schoolmanagement.entity.ClassRoom;
import com.schoolmanagement.repository.ClassRoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassRoomService {
    private final ClassRoomRepository classRoomRepository;


    public ClassRoomService(ClassRoomRepository classRoomRepository) {
        this.classRoomRepository = classRoomRepository;
    }

    public List<ClassRoom> getAllClassRooms() {
        return classRoomRepository.findAll();
    }

    public ClassRoom saveClassRoom(ClassRoom classRoom) {
        return classRoomRepository.save(classRoom);
    }
    public ClassRoom getClassRoomById(Long id){
        return classRoomRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("School not found"));
    }
    public void deleteClassRoomById(Long id){
        classRoomRepository.deleteById(id);
    }

}
