package com.example.controllers;


import com.example.dtos.CreateUserRequest;
import com.example.dtos.GetUserResponse;
import com.example.models.User;
import com.example.service.UserService;
import com.example.utils.Util;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    public void createUser(@RequestBody @Valid CreateUserRequest request) throws JsonProcessingException {
        userService.create(Util.convertUserCreateRequest(request));
    }

    @GetMapping("userId/{id}")
    public GetUserResponse getUser(@PathVariable Integer id) throws Exception {
        User user = userService.getUser(id);
        return Util.convertToDto(user);

    }

    @GetMapping("/user/phone/{phone}")
    public GetUserResponse getUserByPhone(@PathVariable("phone") String phone) throws Exception {
        User user = userService.getByPhone(phone);
        return Util.convertToDto(user);
    }
}

