package com.vztot.entity.mapper;

import com.vztot.entity.User;
import com.vztot.entity.dto.request.UserRequestDto;
import com.vztot.entity.dto.response.UserResponseDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User buildUserFromRequestDto(UserRequestDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setMoney(dto.getMoney());
        return user;
    }

    public UserResponseDto buildResponseDtoFromUser(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setMoney(user.getMoney());
        return dto;
    }
}
