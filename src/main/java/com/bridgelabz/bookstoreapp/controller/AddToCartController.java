package com.bridgelabz.bookstoreapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.bookstoreapp.dto.BookDetailsDto;
import com.bridgelabz.bookstoreapp.dto.ResponseDTO;
import com.bridgelabz.bookstoreapp.service.AddToCartService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/cart")
@Slf4j
public class AddToCartController {

    @Autowired
    AddToCartService addToCartService;

    @PostMapping(value = "/addCartDetails")
    public ResponseEntity<ResponseDTO> addToCartDetails(@RequestBody BookDetailsDto bookDTO) {
        BookDetailsDto addCartData = addToCartService.addToCart(bookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Added Cart Details", addCartData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);

    }
}
