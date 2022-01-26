package com.bridgelabz.bookstoreapp.model;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name="orderDetails")
public class Orders implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    @Column(name="number_book_order")
    private String numberOfBooksOrdered;

    @Column(name="book_total_price")
    private String totalPrice;
//
//    @OneToOne
//    @JoinColumn(name="Id")
//    private Cart cart;
}
