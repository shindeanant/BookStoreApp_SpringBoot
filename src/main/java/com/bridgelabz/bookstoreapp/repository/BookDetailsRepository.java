package com.bridgelabz.bookstoreapp.repository;

import com.bridgelabz.bookstoreapp.model.BookDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookDetailsRepository extends JpaRepository <BookDetails,Integer>{
    Optional<BookDetails> findByBookId(int bookId);
}
