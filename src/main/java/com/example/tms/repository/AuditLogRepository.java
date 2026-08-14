package com.example.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tms.entity.AuditLog;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
}
