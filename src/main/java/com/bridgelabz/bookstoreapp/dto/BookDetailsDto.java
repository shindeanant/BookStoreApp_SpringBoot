package com.bridgelabz.bookstoreapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.bridgelabz.bookstoreapp.model.Cart;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDetailsDto {
	private int bookId;
    public String bookName;
    public String bookAuthor;
    public String bookDescription;
    public String bookLogo;
    public int bookPrice;
    private List<Cart> cart  = new ArrayList<>();
    //public int bookQuantity;
    //public Float bookRating;

}
