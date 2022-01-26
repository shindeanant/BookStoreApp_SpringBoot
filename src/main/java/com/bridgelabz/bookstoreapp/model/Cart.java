package com.bridgelabz.bookstoreapp.model;

import java.util.List;

import javax.persistence.*;

import com.bridgelabz.bookstoreapp.dto.BookDetailsDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
	
    @Id
    private int Id;
    public String bookName;
    public String bookAuthor;
    public String bookDescription;
    public String bookLogo;
    public int bookPrice;
    
//    private BookDetailsDto bookDetailsDto;

//    @OneToOne(mappedBy="cart")
//    private UserRegistrationData user;
//    
//    @OneToOne(mappedBy="cart")
//    private Orders order; 
    
    @ManyToOne
    @JoinColumn(name = "bookId")
    private BookDetails bookDetails;
    

}