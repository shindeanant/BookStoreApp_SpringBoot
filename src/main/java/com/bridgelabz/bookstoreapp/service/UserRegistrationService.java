package com.bridgelabz.bookstoreapp.service;

import com.bridgelabz.bookstoreapp.dto.UserRegistrationDto;
import com.bridgelabz.bookstoreapp.exception.UserRegistrationException;
import com.bridgelabz.bookstoreapp.model.UserRegistrationData;
import com.bridgelabz.bookstoreapp.repository.UserRegistrationRepository;
import com.bridgelabz.bookstoreapp.util.Email;
import com.bridgelabz.bookstoreapp.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
@Service
@Slf4j
public class UserRegistrationService implements  IUserRegistrationService{
    String token = null;
    @Autowired
    UserRegistrationRepository userRepo;


    @Autowired
    TokenUtil tokenUtil;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private Email email;
    @Autowired
    private MailService mailService;

    @Override
    public List<UserRegistrationData> getUserDeatils() {
        return userRepo.findAll();
    }

    @Override
    public UserRegistrationData userRegistration(UserRegistrationDto userDTO) {

        Optional<UserRegistrationData> userCheck = userRepo.findByEmailId(userDTO.getEmailId());
        if (userCheck.isPresent()) {
            log.error("Email already exists");
            throw new UserRegistrationException("email already exists");
        } else {
            UserRegistrationData userData = new UserRegistrationData();
//        String pwd = userData.getPassword();
//        String encryptpwd = passwordEncoder.encode(pwd);
//        userData.setPassword(encryptpwd);
            userData.createUser(userDTO);
            userRepo.save(userData);
            email.setTo(userData.getEmailId());
            email.setFrom("bookstoremailapi@gmail.com");
            email.setSubject(" User Verification...");
            token = tokenUtil.createToken(userData.getId());
            email.setBody(mailService.getLink("http://localhost:8080/userregistrationservice/verify/" + token));
            mailService.send(email.getTo(), email.getSubject(), email.getBody());
            return userData;
        }
    }
    @Override
    public String verifyUser(String token) {

        int id = Math.toIntExact(tokenUtil.decodeToken(token));
        Optional<UserRegistrationData> isPresent = userRepo.findById(id);

        if (isPresent.isPresent()) {
            return isPresent.toString();
        } else
            return null;
    }
    @Override
    public List<UserRegistrationData> getAllUsersData(String token) {

        Long id = tokenUtil.decodeToken(token);
        Optional<UserRegistrationData> usersData = userRepo.findById(Math.toIntExact((id)));
        if (usersData.isPresent()) {
            List<UserRegistrationData> usersList = userRepo.findAll();
            return usersList;
        }
        return null;
    }

}
