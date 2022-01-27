package com.bridgelabz.bookstoreapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.bookstoreapp.model.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {

}
