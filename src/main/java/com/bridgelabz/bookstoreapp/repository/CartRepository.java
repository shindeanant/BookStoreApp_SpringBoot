package com.bridgelabz.bookstoreapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.bookstoreapp.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{

}
