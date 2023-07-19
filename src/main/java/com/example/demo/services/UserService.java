package com.example.demo.services;

import com.example.demo.dto.UserDTO;
import com.example.demo.entities.impls.Permission;
import com.example.demo.entities.impls.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.respository.PermissionsRepository;
import com.example.demo.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;


public class UserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Autowired
    PermissionsRepository permissionsRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if(user !=null) {
            return org.springframework.security.core.userdetails.User
                    .withUsername(user.getUsername())
                    .password(user.getPassword())
                    .authorities(user.getAuthorities())
                    .accountExpired(false)
                    .accountLocked(false)
                    .credentialsExpired(false)
                    .disabled(false)
                    .build();
        } else {
            throw new UsernameNotFoundException("User not found!");
        }
    }

    public User addUser(String email, String password, String firstName, String lastName) {
        if (email == null ||  firstName == null || lastName == null) {
            return null;
        } else {
            User user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setPassword(passwordEncoder.encode(password));
            User checkUser = userRepository.findByEmail(user.getEmail());
            if(checkUser == null) {
                Permission permission = new Permission();
                permission.setRole("ROLE_USER");
                List<Permission> permissions = new ArrayList<>();
                permissions.add(permission);
                user.setPermissions(permissions);
                permissionsRepository.save(permission);
                return userRepository.save(user);
            } else {
                return null;
            }
        }
    }

    public User updatePassword(String newPassword, String oldPassword) {
        User currentUser = getCurrentSessionUser();
        if(passwordEncoder.matches(oldPassword, currentUser.getPassword())) {
            currentUser.setPassword(passwordEncoder.encode(newPassword));
            return userRepository.save(currentUser);
        } else {
            return null;
        }
    }
    public User getCurrentSessionUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(!(authentication instanceof AnonymousAuthenticationToken)) {
            User user =(User) authentication.getPrincipal();
            if(user!=null) {
                return user;
            }
        }
        return null;
    }

    public List<UserDTO> getAllUsers() {
        return userMapper.toUsersDtoList(userRepository.findAll());
    }

    public UserDTO oneUser(String email) {
        User user = userRepository.findByEmail(email);
        if(user!=null) {
            return userMapper.toUserDto(user);
        } else {
            return null;
        }
    }

    public ResponseEntity<String> updateUser(String email, List<String> roles) {
        User user = userRepository.findByEmail(email);
        if(user!=null) {
            List<Permission> permissions = new ArrayList<>();
            for(String role : roles) {
                Permission permission = new Permission();
                permission.setRole(role);
                permissionsRepository.save(permission);
                permissions.add(permission);
            }
            user.getPermissions().clear();
            user.getPermissions().addAll(permissions);
            userRepository.save(user);
            return ResponseEntity.ok("Success");
        } else {
            return ResponseEntity.ok("Fail!");
        }
    }

    public ResponseEntity<String> deleteUser(String email) {
        User user = userRepository.findByEmail(email);

        if(user!=null) {
            userRepository.delete(user);
            return ResponseEntity.ok("Success");
        } else {
            return ResponseEntity.ok("Fail");
        }
    }

}
