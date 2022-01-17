package com.bridgelabz.bookstoreapp.service;

import com.bridgelabz.bookstoreapp.dto.LoginDto;
import com.bridgelabz.bookstoreapp.dto.UserRegistrationDto;
import com.bridgelabz.bookstoreapp.model.UserRegistrationData;

import java.util.List;
import java.util.Optional;

public interface IUserRegistrationService {
    List<UserRegistrationData> getUserDeatils();

    UserRegistrationData userRegistration(UserRegistrationDto userDTO);

    String verifyUser(String token);
    List<UserRegistrationData> getAllUsersData(String token);
    Optional<UserRegistrationData> UserLogin(LoginDto logindto);
}
