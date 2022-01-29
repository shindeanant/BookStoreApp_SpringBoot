package com.bridgelabz.bookstoreapp.service;

import com.bridgelabz.bookstoreapp.dto.BookDetailsDto;
import com.bridgelabz.bookstoreapp.model.BookDetails;

import java.util.List;
import java.util.Optional;

public interface IBookDetailsService {

    List<BookDetails> showAllBooks();

	Optional<BookDetails> getBookByID(int id);

    BookDetails getBookByIdToken(String token, int bookId);


}
