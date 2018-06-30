package com.mbmk.mappers;

import com.mbmk.dto.UserDto;
import com.mbmk.model.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserDto toDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .build();
    }

    public List<UserDto> toDtos(List<User> users) {
        return users.stream().map(this::toDto).collect(Collectors.toList());
    }

}