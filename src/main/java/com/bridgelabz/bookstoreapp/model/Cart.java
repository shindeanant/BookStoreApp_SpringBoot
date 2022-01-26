package com.bridgelabz.bookstoreapp.model;

import javax.persistence.*;

import com.bridgelabz.bookstoreapp.dto.BookDetailsDto;

import lombok.Data;

@Entity
@Data
public class Cart {
	
    @Id
    private int Id;
    private BookDetailsDto bookDetailsDto;

//    @OneToOne(mappedBy="cart")
//    private UserRegistrationData user;
//    
//    @OneToOne(mappedBy="cart")
//    private Orders order; 
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "bookId")
    private BookDetails bookDetails;
    

}