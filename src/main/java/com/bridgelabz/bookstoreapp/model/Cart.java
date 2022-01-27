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
    @Column(name = "cart_id")
    private int cartId;
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
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cartId_fk",referencedColumnName = "cart_id")
    private List<BookDetails> bookDetailsList;
    

}