package com.bridgelabz.bookstoreapp.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.bridgelabz.bookstoreapp.dto.BookDetailsDto;
import com.bridgelabz.bookstoreapp.dto.CartDto;
import com.bridgelabz.bookstoreapp.model.BookDetails;
import com.bridgelabz.bookstoreapp.model.Cart;
import com.bridgelabz.bookstoreapp.model.UserRegistrationData;
import com.bridgelabz.bookstoreapp.repository.CartRepository;
import com.bridgelabz.bookstoreapp.repository.UserRegistrationRepository;
@ComponentScan({"com.bridgelabz.bookstoreapp"})
@Service
public class AddToCartService implements IAddToCartService{

	 @Autowired
	    BookDetailsService  bookDetailsService;

	    @Autowired
	    CartRepository cartRepo;

	    @Autowired
	    UserRegistrationRepository userRegistrationRepo;

	    @Override
	    public Cart addToCart(CartDto cartDTO){
			return null;
	        
	    }
    
}
