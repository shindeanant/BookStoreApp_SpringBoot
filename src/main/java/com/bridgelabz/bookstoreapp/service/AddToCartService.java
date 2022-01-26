package com.bridgelabz.bookstoreapp.service;

import java.util.List;
import java.util.stream.Collectors;

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
	BookDetailsDto bookDetailsDto;
	
    @Autowired
    CartRepository cartRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BookDetailsDto addToCart(BookDetailsDto bookDetailsDto) {
        Cart addDetails = modelMapper.map(bookDetailsDto, Cart.class);
        cartRepository.save(addDetails);
        return bookDetailsDto;
    }
    
}
