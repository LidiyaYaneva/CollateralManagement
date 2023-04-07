package com.example.collateralmanagement.services.impl.authenticationServices;

import com.example.collateralmanagement.models.entities.authentication.UserEntity;
import com.example.collateralmanagement.models.entities.authentication.UserRoleEntity;
import com.example.collateralmanagement.repositories.UserRepository;
import com.example.collateralmanagement.services.ApplicationUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationUserDetailsServiceImpl implements ApplicationUserDetailsService, UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public ApplicationUserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository.findByUsername(username)
                .map(this::map)
                .orElseThrow(() -> new UsernameNotFoundException("User with name"+ username+ " not found!"));
    }


    private UserDetails map(UserEntity userEntity){
       return new User(
               userEntity.getUsername(),
               userEntity.getPassword(),
               extractAuthorities(userEntity));

    }

    private List<GrantedAuthority> extractAuthorities (UserEntity userEntity){
        return userEntity
                .getRoles()
                .stream()
                .map(this::mapRole)
                .toList();
    }

    private GrantedAuthority mapRole(UserRoleEntity userRoleEntity){
        return new SimpleGrantedAuthority("ROLE_"+userRoleEntity.getRole().name());
    }
}
