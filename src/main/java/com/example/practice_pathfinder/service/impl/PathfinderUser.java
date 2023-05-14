package com.example.practice_pathfinder.service.impl;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class PathfinderUser extends User {

    private Long id;

    public PathfinderUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public PathfinderUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    /*  some own methods below  */

    public Long getId() {
        return id;
    }

    public PathfinderUser setId(Long id) {
        this.id = id;
        return this;
    }
}
