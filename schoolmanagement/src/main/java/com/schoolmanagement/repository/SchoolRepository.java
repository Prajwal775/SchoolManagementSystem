package com.schoolmanagement.repository;

import com.schoolmanagement.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Long> {
}
