package com.vztot.controller;

import com.vztot.entity.dto.request.UserRequestDto;
import com.vztot.entity.dto.response.UserResponseDto;
import com.vztot.entity.mapper.UserMapper;
import com.vztot.service.UserService;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
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
        userService.save(userMapper.buildUserFromRequestDto(dto));
    }

    @RequestMapping(value = "/add_money/{userId}/{amount}", method = RequestMethod.PUT)
    public void addMoneyToUser(@PathVariable Long userId,@PathVariable BigDecimal amount) {
        userService.addMoney(userId, amount);
    }
}
