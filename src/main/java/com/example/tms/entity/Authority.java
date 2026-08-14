package com.example.tms.entity;

import com.example.tms.entity.id.AuthorityId;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "authorities")
public class Authority {

    @EmbeddedId
    private AuthorityId id;

    @Column(name = "username", nullable = false, insertable = false, updatable = false, length = 50)
    private String username;

    @Column(name = "authority", nullable = false, insertable = false, updatable = false, length = 50)
    private String authority;

    protected Authority() {
    }

    public Authority(String username, String authority) {
        this.id = new AuthorityId(username, authority);
        this.username = username;
        this.authority = authority;
    }

    public AuthorityId getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getAuthority() {
        return authority;
    }
}
