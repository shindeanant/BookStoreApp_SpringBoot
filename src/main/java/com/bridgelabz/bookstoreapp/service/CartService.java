package com.bridgelabz.bookstoreapp.service;

import com.bridgelabz.bookstoreapp.dto.CartDto;
import com.bridgelabz.bookstoreapp.model.BookDetails;
import com.bridgelabz.bookstoreapp.model.CartData;
import com.bridgelabz.bookstoreapp.model.UserRegistrationData;
import com.bridgelabz.bookstoreapp.repository.CartRepository;
import com.bridgelabz.bookstoreapp.repository.UserRegistrationRepository;
import com.bridgelabz.bookstoreapp.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService implements ICartService{
    @Autowired
    UserRegistrationService userService;

    @Autowired
    BookDetailsService bookService;

    @Autowired
    CartRepository cartRepo;

    @Autowired
    TokenUtil tokenUtil;

    @Autowired
    UserRegistrationRepository userRepo;

    @Override
    public CartData addToCart(String token , CartDto cartDTO) {
        Optional<UserRegistrationData> user = Optional.ofNullable(userService.getUserById(cartDTO.userId));
        if(user.isPresent()) {
            BookDetails book = bookService.getBookByIdToken(token,cartDTO.bookId);
            CartData cart = new CartData(user.get(), book, cartDTO.quantity);
            return cartRepo.save(cart);
        }
        return null;
    }

    @Override
    public void deleteFromCart(int cartId) {
        cartRepo.deleteById(cartId);
    }

    @Override
    public CartData updateQuantity(String token, int cartId, CartDto cartdto) {
        int id = Math.toIntExact(tokenUtil.decodeToken(token));
        Optional<UserRegistrationData> isPresent = userRepo.findById(id);
        if(isPresent.isPresent()){
            CartData cart = cartRepo.getById(cartId);
            cart.setQuantity(cartdto.quantity);
//            BookDetails book =bookService.getBookByIdToken(token,cartdto.bookId);
//            cart.setBook(book);
            return cartRepo.save(cart);
        }
        return  null;
    }

    @Override
    public List<CartData> findAllInCart(String token) {
        int id = Math.toIntExact(tokenUtil.decodeToken(token));
        Optional<UserRegistrationData> isPresent = userRepo.findById(id);
        if(isPresent.isPresent()){
            List<CartData> cartItems = cartRepo.findAllCartsByUserId(id);
            return  cartItems;
        }
        return null;
    }
}
