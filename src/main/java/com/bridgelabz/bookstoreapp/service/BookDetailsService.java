package com.bridgelabz.bookstoreapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bridgelabz.bookstoreapp.exception.UserRegistrationException;
import com.bridgelabz.bookstoreapp.model.BookDetails;
import com.bridgelabz.bookstoreapp.repository.BookDetailsRepository;
import com.bridgelabz.bookstoreapp.repository.UserRegistrationRepository;
import com.bridgelabz.bookstoreapp.util.TokenUtil;

import lombok.extern.slf4j.Slf4j;

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
    public List<BookDetails> showAllBooks() {
        List<BookDetails> allBooks = bookRepo.findAll();
        if(allBooks!= null) {
        	return allBooks;
		}
		else {
			throw new UserRegistrationException("Unable to find any Book detail!");
		}
            
    } 
    
	@Override
	public Optional<BookDetails> getBookByID(int id) {
		Optional<BookDetails> bookDetails = bookRepo.findById(id);
		if(bookDetails!= null) {
			return bookDetails;
		}
		else {
			throw new UserRegistrationException("Unable to find any Book detail!");
		}
		
	}
}
