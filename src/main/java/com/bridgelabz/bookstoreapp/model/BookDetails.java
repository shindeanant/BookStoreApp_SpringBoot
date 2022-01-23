package com.bridgelabz.bookstoreapp.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class BookDetails {
    @Id
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
    @Column (name = "bookQuantity")
    private int bookQuantity;
    @Column (name = "bookRating")
    private Float bookRating;
    @Column (name = "bookImage")
    private String bookImage;
    
}
