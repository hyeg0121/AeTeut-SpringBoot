package com.appjam.aeteut.controller;


import com.appjam.aeteut.dto.user.UserRequestDto;
import com.appjam.aeteut.dto.user.UserResponseDto;
import com.appjam.aeteut.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserResponseDto> findAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserResponseDto findAllUsers(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public UserResponseDto createUser(@RequestBody UserRequestDto userRequestDto) {
        return userService.loginUser(userRequestDto);
    }

}
