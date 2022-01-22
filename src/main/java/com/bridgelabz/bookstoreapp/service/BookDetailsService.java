package com.bridgelabz.bookstoreapp.service;

import com.bridgelabz.bookstoreapp.model.BookDetails;
import com.bridgelabz.bookstoreapp.model.UserRegistrationData;
import com.bridgelabz.bookstoreapp.repository.BookDetailsRepository;
import com.bridgelabz.bookstoreapp.repository.UserRegistrationRepository;
import com.bridgelabz.bookstoreapp.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class BookDetailsService implements IBookDetailsService{

    @Autowired
    BookDetailsRepository bookRepo;

    @Autowired
    UserRegistrationRepository userRepo;

    @Autowired
    UserRegistrationService service;

    @Autowired
    TokenUtil tokenUtil;

    @Override
    public List<BookDetails> showAllBooks(String token) {
        int id = Math.toIntExact(tokenUtil.decodeToken(token));
        Optional<UserRegistrationData> isPresent = userRepo.findById(id);
        if (isPresent.isPresent()) {
            List<BookDetails> allBooks = bookRepo.findAll();
            return allBooks;
        } else return null;
    }
}
