package com.example.tms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tms.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    boolean existsByDepartmentCodeIgnoreCase(String departmentCode);

    List<Department> findByDepartmentNameContainingIgnoreCaseOrDepartmentCodeContainingIgnoreCaseOrderByDepartmentCode(
            String departmentName,
            String departmentCode);

    List<Department> findAllByOrderByDepartmentCode();
}
