package com.bridgelabz.bookstoreapp.repository;

import com.bridgelabz.bookstoreapp.model.CartData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<CartData, Integer>{
    @Query(value = "SELECT * FROM cart where user_Id = :id", nativeQuery = true)
    List<CartData> findAllCartsByUserId(int id);

}
