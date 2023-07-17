package com.example.demo.dto;

import com.example.demo.entities.impls.Permission;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDTO {
    private String email;
    private String firstName;
    private String LastName;
    private List<PermissionDTO> permissions;
}
