package com.vztot.controller;

import com.vztot.entity.dto.request.UserRequestDto;
import com.vztot.entity.dto.response.UserResponseDto;
import com.vztot.entity.mapper.UserMapper;
import com.vztot.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/all")
    public List<UserResponseDto> getAll() {
        return userService.getAll()
                .stream()
                .map(userMapper::buildResponseDtoFromUser)
                .collect(Collectors.toList());
    }

    @PostMapping("/create_user")
    public void createUser(@RequestBody UserRequestDto dto) {
        userService.create(userMapper.buildUserFromRequestDto(dto));
    }

    @PostMapping("/add_money")
    public void addMoneyToUser(@RequestBody UserRequestDto dto) {
        userService.create(userMapper.buildUserFromRequestDto(dto));
    }
}
