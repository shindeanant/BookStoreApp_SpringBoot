package com.bridgelabz.bookstoreapp.service;


import com.bridgelabz.bookstoreapp.repository.BookDetailsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.bridgelabz.bookstoreapp.dto.BookDetailsDto;
import com.bridgelabz.bookstoreapp.model.Cart;
import com.bridgelabz.bookstoreapp.repository.CartRepository;
@ComponentScan({"com.bridgelabz.bookstoreapp"})
@Service
public class AddToCartService implements IAddToCartService{

	@Autowired
    BookDetailsRepository bookrepo;
	
    @Autowired
    CartRepository cartRepository;



    @Override
    public BookDetailsDto addToCart(BookDetailsDto bookDetailsDto) {
        ModelMapper modelMapper=new ModelMapper();
        Cart addDetails = modelMapper.map(bookDetailsDto, Cart.class);
        cartRepository.save(addDetails);
        return bookDetailsDto;
    }
    
}
