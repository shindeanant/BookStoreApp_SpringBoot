package com.bridgelabz.bookstoreapp.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Data
@Entity
public class BookDetails {
	
    @Id
    @Column (name = "book_id")
    private int bookId;
    @Column( name = "bookName")
    private String bookName;
    @Column  (name = "bookAuthor")
    private String bookAuthor;
    @Column (name = "bookDescription")
    private String bookDescription;
    @Column (name = "bookLogo")
    private String bookLogo;
    @Column (name = "bookPrice")
    private int bookPrice;
//    @Column (name = "bookQuantity")
//    private int bookQuantity;
//    @Column (name = "bookRating")
//    private Float bookRating;
    
//    @ManyToMany(mappedBy = "bookDetailsListuser")
//    private List<UserRegistrationData> bookDetailsListuser;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "cartId_fk")
//    private Cart cart;


   
}

