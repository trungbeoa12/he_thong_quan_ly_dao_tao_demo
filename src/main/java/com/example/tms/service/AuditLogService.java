package com.example.tms.service;

public interface AuditLogService {

    void log(String username, String action, String module, String objectId, String oldValue, String newValue);
}
