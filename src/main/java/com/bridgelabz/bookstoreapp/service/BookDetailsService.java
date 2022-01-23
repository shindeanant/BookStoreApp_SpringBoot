package com.bridgelabz.bookstoreapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import com.bridgelabz.bookstoreapp.dto.BookDetailsDto;
import com.bridgelabz.bookstoreapp.exception.UserRegistrationException;
import com.bridgelabz.bookstoreapp.model.BookDetails;
import com.bridgelabz.bookstoreapp.model.UserRegistrationData;
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
            return allBooks;
        } 
   
    public BookDetails findBookById(int id) {
    	return bookRepo.findById(id)
                .orElseThrow(() -> new UserRegistrationException("Unable to find any Book detail!"));
    }
    
	@Override
	public BookDetails getBookByID(int id) {
		BookDetails bookDetails = findBookById(id);
        //BookDetailsDto bookDetailsById = modelMapper.map(bookDetails, BookDetailsDto.class);
        return bookDetails;
	}
}
