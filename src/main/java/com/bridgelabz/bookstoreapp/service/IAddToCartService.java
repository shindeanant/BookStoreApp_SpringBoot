package com.bridgelabz.bookstoreapp.service;

import java.util.List;

import com.bridgelabz.bookstoreapp.dto.BookDetailsDto;

public interface IAddToCartService {

	BookDetailsDto addToCart(BookDetailsDto bookDetailsDto);

}
