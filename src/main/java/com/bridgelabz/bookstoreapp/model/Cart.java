package com.bridgelabz.bookstoreapp.model;

import java.util.List;
import java.util.Optional;

import javax.persistence.*;

import com.bridgelabz.bookstoreapp.dto.BookDetailsDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Cart")
@Data
 
@AllArgsConstructor
public class Cart {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private int id;

	   
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "userId")
	    private UserRegistrationData userRegistrationData;

	    
	    @OneToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "bookId")
	    private Optional<BookDetails>  bookDetails;

	    private int quantity;


	    public Cart(UserRegistrationData userRegistrationData, Optional<BookDetails>  bookDetails, int quantity) {
	        this.userRegistrationData = userRegistrationData;
	        this.bookDetails = bookDetails;
	        this.quantity = quantity;
	    }

	    public Cart() {

	    }
}