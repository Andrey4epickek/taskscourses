package com.hotel.model.dto;

import lombok.Data;

@Data
public class UserDto {
    private Integer id;
    private String login;
    private String password;
    private String role;
}
