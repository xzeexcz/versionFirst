package com.example.demo.mapper;

import com.example.demo.dto.PermissionDTO;
import com.example.demo.entities.impls.Permission;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class, PermissionMapper.class})
public interface PermissionMapper {
    PermissionMapper INSTANCE = Mappers.getMapper(PermissionMapper.class);
    PermissionDTO toPermissionDto(Permission permission);
    Permission toPermissionEntity(PermissionDTO permissionDTO);

    List<PermissionDTO> toPermissionDtoList(List<Permission> permissionsList);
    List<Permission> toPermissionEntityList(List<PermissionDTO> permissionDTOList);
}
