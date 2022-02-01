package com.bridgelabz.bookstoreapp.service;

import com.bridgelabz.bookstoreapp.dto.CartDto;
import com.bridgelabz.bookstoreapp.model.CartData;

import java.util.List;

public interface ICartService {
    CartData addToCart(String token,int bookid,CartDto cartDTO);

    void deleteFromCart(int cartId);

    CartData updateQuantity(String token, int cartId, CartDto cartdto);

    List<CartData> findAllInCart(String token);
}
