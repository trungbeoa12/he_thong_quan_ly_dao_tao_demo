package com.example.tms.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tms.dto.UserAccountDto;
import com.example.tms.dto.UserCreateDto;
import com.example.tms.entity.Authority;
import com.example.tms.entity.UserAccount;
import com.example.tms.exception.BusinessException;
import com.example.tms.repository.AuthorityRepository;
import com.example.tms.repository.UserAccountRepository;
import com.example.tms.service.AuditLogService;
import com.example.tms.service.UserManagementService;

@Service
@Transactional(readOnly = true)
public class UserManagementServiceImpl implements UserManagementService {

    private final UserAccountRepository userAccountRepository;
    private final AuthorityRepository authorityRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuditLogService auditLogService;

    public UserManagementServiceImpl(
            UserAccountRepository userAccountRepository,
            AuthorityRepository authorityRepository,
            PasswordEncoder passwordEncoder,
            AuditLogService auditLogService) {
        this.userAccountRepository = userAccountRepository;
        this.authorityRepository = authorityRepository;
        this.passwordEncoder = passwordEncoder;
        this.auditLogService = auditLogService;
    }

    @Override
    public List<UserAccountDto> findAll() {
        Map<String, List<String>> rolesByUsername = authorityRepository.findAll().stream()
                .collect(Collectors.groupingBy(
                        Authority::getUsername,
                        Collectors.mapping(Authority::getAuthority, Collectors.toList())));

        return userAccountRepository.findAll().stream()
                .sorted((left, right) -> left.getUsername().compareToIgnoreCase(right.getUsername()))
                .map(user -> new UserAccountDto(
                        user.getUsername(),
                        user.isEnabled(),
                        rolesByUsername.getOrDefault(user.getUsername(), List.of())))
                .toList();
    }

    @Override
    @Transactional
    public UserAccountDto create(UserCreateDto dto) {
        String username = dto.getUsername().trim().toLowerCase();
        if (userAccountRepository.existsById(username)) {
            throw new BusinessException("Username đã tồn tại: " + username);
        }

        UserAccount user = new UserAccount();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setEnabled(dto.isEnabled());
        userAccountRepository.save(user);

        Authority authority = new Authority(username, dto.getRole().name());
        authorityRepository.save(authority);

        auditLogService.log("system", "CREATE", "USER", username, null, dto.getRole().name());
        return new UserAccountDto(username, dto.isEnabled(), List.of(dto.getRole().name()));
    }
}
