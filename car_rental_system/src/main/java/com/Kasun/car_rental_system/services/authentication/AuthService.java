package com.Kasun.car_rental_system.services.authentication;

import com.Kasun.car_rental_system.dto.SignupRequestDTO;
import com.Kasun.car_rental_system.dto.UserDto;

public interface AuthService {

    UserDto signupClient(SignupRequestDTO signupRequestDTO);

    Boolean presentByEmail(String email);

    UserDto signupCompany(SignupRequestDTO signupRequestDTO);
}
