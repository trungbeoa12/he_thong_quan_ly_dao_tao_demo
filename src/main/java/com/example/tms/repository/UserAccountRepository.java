package com.example.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tms.entity.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, String> {
}
