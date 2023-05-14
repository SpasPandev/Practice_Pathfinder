package com.example.practice_pathfinder.service.impl;

import com.example.practice_pathfinder.model.entity.UserEntity;
import com.example.practice_pathfinder.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PathfinderUserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public PathfinderUserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        var userEntity = userRepository.
                findByUsername(username).
                orElseThrow(() -> new UsernameNotFoundException("User with username " + username + " was not found."));


        return map(userEntity);
    }

    private static UserDetails map(UserEntity userEntity) {

//            GrantedAuthority is the representation of a user role in the spring world.
//            SimpleGrantedAuthority is an implementation of GrantedAuthority
//            which spring provide for our convenience.
//            Our representation of role is (Role).
        Set<GrantedAuthority> grantedAuthorities =
                userEntity.
                        getRoles().
                        stream().
                        map(r -> new SimpleGrantedAuthority("ROLE_" + r.getRole().name())).
                        collect(Collectors.toUnmodifiableSet());

//        User is the spring implementation of UserDetails interface.
        return new PathfinderUser(
                userEntity.getUsername(),
                userEntity.getPassword(),
                grantedAuthorities
        )
                .setId(userEntity.getId());
    }
}
