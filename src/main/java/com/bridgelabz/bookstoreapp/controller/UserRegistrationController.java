package com.bridgelabz.bookstoreapp.controller;

import com.bridgelabz.bookstoreapp.dto.ResponseDTO;
import com.bridgelabz.bookstoreapp.dto.UserRegistrationDto;
import com.bridgelabz.bookstoreapp.exception.UserRegistrationException;
import com.bridgelabz.bookstoreapp.model.UserRegistrationData;
import com.bridgelabz.bookstoreapp.service.IUserRegistrationService;
import com.bridgelabz.bookstoreapp.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/userregistrationservice")
@Slf4j
public class UserRegistrationController {

    @Autowired
    private IUserRegistrationService service;

    @Autowired
    private TokenUtil tokenUtil;


    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<ResponseDTO> getUserData() {
        List<UserRegistrationData> usersList = service.getUserDeatils();
        ResponseDTO response = new ResponseDTO("Get call success", usersList);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> addUserRegistrationData(@Valid @RequestBody UserRegistrationDto userDTO) {
        UserRegistrationData userDetails = service.userRegistration(userDTO);
        log.debug("User Registration input detaisl: " + userDTO.toString());
        ResponseDTO response = new ResponseDTO("successfully Registered the user, Verification mail sent", tokenUtil.createToken(userDetails.getId()));
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }

    @PostMapping("/verify/{token}")
    ResponseEntity<ResponseDTO> verifyUser(@Valid @PathVariable String token) {
        String userVerification = service.verifyUser(token);
        if (userVerification != null) {
            ResponseDTO responseDTO = new ResponseDTO("User verified :", userVerification);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        } else {
            ResponseDTO responseDTO = new ResponseDTO("User Not verified data:", userVerification);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        }
    }

    @GetMapping("/readtokendata")
    public ResponseEntity<ResponseDTO> readdata(@RequestHeader(name = "token") String token) throws UserRegistrationException {
        List<UserRegistrationData> users = null;
        users = service.getAllUsersData(token);
        if (users.size() > 0) {
            ResponseDTO responseDTO = new ResponseDTO("all user Fetched successfully", users);
            return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
        } else {
            throw new UserRegistrationException("No Data Found");
        }

    }
}
