package com.example.utils;

import com.example.dtos.CreateUserRequest;
import com.example.dtos.GetUserResponse;
import com.example.models.User;

public class Util {

    //for conversion of DTO to Model.
    public static User convertUserCreateRequest(CreateUserRequest request){
        return User.builder()
                .name(request.getName())
                .phone(request.getPhone())
                .email(request.getEmail())
                .age(request.getAge())
                .build();
    }

    public static GetUserResponse convertToDto(User user){
        return GetUserResponse.builder()
                .name(user.getName())
                .phone(user.getPhone())
                .email(user.getEmail())
                .age(user.getAge())
                .updatedOn(user.getUpdatedOn())
                .createdOn(user.getCreatedOn())
                .build();
    }
}
