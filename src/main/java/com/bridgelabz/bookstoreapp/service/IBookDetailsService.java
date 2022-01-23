package com.bridgelabz.bookstoreapp.service;

import com.bridgelabz.bookstoreapp.dto.BookDetailsDto;
import com.bridgelabz.bookstoreapp.model.BookDetails;

import java.util.List;

public interface IBookDetailsService {

    List<BookDetails> showAllBooks();

	BookDetails getBookByID(int id);

	BookDetails findBookById(int id);

}
