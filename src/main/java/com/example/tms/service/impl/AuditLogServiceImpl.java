package com.example.tms.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.tms.service.AuditLogService;

@Service
public class AuditLogServiceImpl implements AuditLogService {

    private static final Logger log = LoggerFactory.getLogger(AuditLogServiceImpl.class);

    @Override
    public void log(String username, String action, String module, String objectId, String oldValue, String newValue) {
        log.info("AUDIT username={} action={} module={} objectId={}", username, action, module, objectId);
    }
}
