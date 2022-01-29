package com.bridgelabz.bookstoreapp.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class CartDto {

    public  int userId;
    public  int bookId;
    public int quantity;
}
