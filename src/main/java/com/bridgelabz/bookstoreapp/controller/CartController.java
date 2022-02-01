package com.bridgelabz.bookstoreapp.controller;

import com.bridgelabz.bookstoreapp.dto.CartDto;
import com.bridgelabz.bookstoreapp.dto.ResponseCart;
import com.bridgelabz.bookstoreapp.dto.ResponseDTO;
import com.bridgelabz.bookstoreapp.model.CartData;
import com.bridgelabz.bookstoreapp.repository.CartRepository;
import com.bridgelabz.bookstoreapp.service.ICartService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*",origins = "*")
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ICartService cartService;

    @Autowired
    CartRepository cartRepo;

    @PostMapping("/add/{bookid}")
    ResponseEntity<ResponseDTO> addToCart(@RequestHeader(name = "token") String token,@PathVariable int bookid ,@RequestBody CartDto cartDTO) {
        CartData add = cartService.addToCart(token, bookid, cartDTO);

        ResponseDTO response = new ResponseDTO("product added to cart",add);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/remove/{cartId}")
    ResponseEntity<ResponseDTO> removeFromCart(@PathVariable("cartId") int cartId) {
        cartService.deleteFromCart(cartId);
        ResponseDTO response = new ResponseDTO("Delete call success for item Removed From Cart ", "deleted id:" + cartId);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }

    @PutMapping("/update/{cartId}")
    ResponseEntity<ResponseDTO> updateCart(@RequestHeader(name = "token") String token, @PathVariable("cartId") int cartId ,@RequestBody CartDto cartdto) {
        CartData cart = cartService.updateQuantity(token, cartId, cartdto);
        ResponseDTO response = new ResponseDTO("Update call success for item Quantity updated From Cart ", cart);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }

    @GetMapping("/get")
    ResponseEntity<ResponseDTO> findAllCartsByUser(@RequestHeader(name = "token") String token) {
        List<CartData> allItemsForUser = cartService.findAllInCart(token);
        ResponseDTO response = new ResponseDTO("All Items in Cart for user ", allItemsForUser);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }

//    @GetMapping("/getAll")
//    ResponseEntity<ResponseDTO> findAllCarts() {
//        List<CartData> allItems = cartRepo.findAll();
//        ResponseDTO response = new ResponseDTO("All Items in Cart ", allItems);
//        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
//    }
}
