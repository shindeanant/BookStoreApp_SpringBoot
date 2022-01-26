package com.bridgelabz.bookstoreapp.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long order_id;

	private LocalDate orderDate;
	private int price;
	private int quantity;
	private String address;
	private int Id;
	private int bookId;
}