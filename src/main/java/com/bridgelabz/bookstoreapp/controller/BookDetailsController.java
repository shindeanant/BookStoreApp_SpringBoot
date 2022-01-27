package com.bridgelabz.bookstoreapp.controller;

import com.bridgelabz.bookstoreapp.dto.ResponseDTO;
import com.bridgelabz.bookstoreapp.model.BookDetails;
import com.bridgelabz.bookstoreapp.service.IBookDetailsService;
import com.bridgelabz.bookstoreapp.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookservice")
@Slf4j
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class BookDetailsController {
    @Autowired
    private IBookDetailsService bookService;

    @Autowired
    private TokenUtil tokenUtil;

    @GetMapping(value = {"", "/", "/getBooks"})
    public ResponseEntity<ResponseDTO> getAllBooks() {
        List<BookDetails> allBooks = bookService.showAllBooks();
        ResponseDTO dto = new ResponseDTO("All Books Retrieved successfully:", allBooks);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
    
    @GetMapping(value = "/Book/{id}")
    public ResponseEntity<ResponseDTO> getBookDetailsByID(@PathVariable(name = "id") int id) {
        log.info("getBookDetailsByID");
        log.info(String.valueOf(id));
        Optional<BookDetails> bookDTO = bookService.getBookByID(id);
        ResponseDTO responseDTO = new ResponseDTO("getting book by id", bookDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
