package com.example.springbootrest.mapper;

import com.example.springbootrest.dtos.UserMsDto;
import com.example.springbootrest.enitities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mappings({
            @Mapping(source = "id",target = "userId"),
            @Mapping(source = "username",target = "userName"),
            @Mapping(source = "email",target = "emailAddress"),
            @Mapping(source = "role",target = "roleName")
    })
    UserMsDto userToUserMsDto(User user);

    List<UserMsDto> usersToUserDtos(List<User> users);

}
