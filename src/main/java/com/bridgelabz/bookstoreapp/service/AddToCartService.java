package com.bridgelabz.bookstoreapp.service;

<<<<<<< HEAD
=======
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
>>>>>>> ce5ccf8cb39e65a81392ca004ac123201efe1ae8

import com.bridgelabz.bookstoreapp.repository.BookDetailsRepository;
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
    BookDetailsRepository bookrepo;
	
    @Autowired
    CartRepository cartRepository;

	@Autowired
	BookDetailsService  bookDetailsService;




	@Autowired
	UserRegistrationRepository userRegistrationRepo;




//    @Override
//    public BookDetailsDto addToCart(BookDetailsDto bookDetailsDto) {
//        ModelMapper modelMapper=new ModelMapper();
//        Cart addDetails = modelMapper.map(bookDetailsDto, Cart.class);
//        cartRepository.save(addDetails);
//        return bookDetailsDto;
//    }


	@Override
	public Cart addToCart(CartDto cartDTO) {
		return null;
	}
}
