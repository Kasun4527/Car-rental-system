package com.Kasun.car_rental_system.dto;

import com.Kasun.car_rental_system.enums.UserRole;
import lombok.Data;

@Data
public class UserDto {
    private Long id;

    private String email;

    private String password;

    private String name;

    private String lastname;

    private String phone;

    private UserRole role;
}
