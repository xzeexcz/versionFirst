package com.example.demo.mapper;

import com.example.demo.dto.UserDTO;
import com.example.demo.entities.impls.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PermissionMapper.class, UserMapper.class})
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDTO toUserDto(User user);
    User toUserEntity(UserDTO userDTO);

    List<UserDTO> toUsersDtoList(List<User> userList);
    List<User> toUsersEntityList(List<UserDTO> userDTOList);
}
