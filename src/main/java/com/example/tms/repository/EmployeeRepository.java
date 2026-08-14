package com.example.tms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tms.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    boolean existsByEmployeeCodeIgnoreCase(String employeeCode);

    boolean existsByEmailIgnoreCase(String email);

    List<Employee> findByEmployeeCodeContainingIgnoreCaseOrFullNameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrderByEmployeeCode(
            String employeeCode,
            String fullName,
            String email);

    List<Employee> findAllByOrderByEmployeeCode();
}
