package com.example.tms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tms.entity.Authority;
import com.example.tms.entity.id.AuthorityId;

public interface AuthorityRepository extends JpaRepository<Authority, AuthorityId> {

    List<Authority> findByUsernameOrderByAuthority(String username);
}
