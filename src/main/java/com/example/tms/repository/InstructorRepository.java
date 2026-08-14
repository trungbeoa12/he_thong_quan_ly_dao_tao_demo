package com.example.tms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tms.entity.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {

    boolean existsByInstructorCodeIgnoreCase(String instructorCode);

    boolean existsByEmailIgnoreCase(String email);

    List<Instructor> findByInstructorCodeContainingIgnoreCaseOrInstructorNameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrderByInstructorCode(
            String instructorCode,
            String instructorName,
            String email);

    List<Instructor> findAllByOrderByInstructorCode();
}
