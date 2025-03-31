package com.example.dtos;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetUserResponse {

    private String name;

    private String phone;

    private String email;

    private Integer age;

    private Date createdOn;

    private Date updatedOn;
}
