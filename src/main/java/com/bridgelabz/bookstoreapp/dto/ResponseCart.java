package com.bridgelabz.bookstoreapp.dto;

import com.bridgelabz.bookstoreapp.model.BookDetails;
import com.bridgelabz.bookstoreapp.model.CartData;
import com.bridgelabz.bookstoreapp.model.UserRegistrationData;
import lombok.Data;

@Data
public class ResponseCart extends ResponseDTO{
    private int id;
    private UserRegistrationData user;
    private BookDetails book;
    private int quantity;


}
