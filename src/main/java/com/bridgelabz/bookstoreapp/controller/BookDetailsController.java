package com.bridgelabz.bookstoreapp.controller;

import com.bridgelabz.bookstoreapp.dto.BookDetailsDto;
import com.bridgelabz.bookstoreapp.dto.ResponseDTO;
import com.bridgelabz.bookstoreapp.model.BookDetails;
import com.bridgelabz.bookstoreapp.service.IBookDetailsService;
import com.bridgelabz.bookstoreapp.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bookservice")
@Slf4j
public class BookDetailsController {
    @Autowired
    private IBookDetailsService bookService;

    @Autowired
    private TokenUtil tokenUtil;

    @RequestMapping(value = {"", "/", "/getbooks"})
    public ResponseEntity<ResponseDTO> getAllBooks() {
        List<BookDetails> allBooks = bookService.showAllBooks();
        ResponseDTO dto = new ResponseDTO("All Books Retrieved successfully:", allBooks);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
    
    @GetMapping(value = "/getBookDetailsByID")
    public ResponseEntity<ResponseDTO> getBookDetailsByID(@RequestParam(name = "id") int id) {
        log.info("getBookDetailsByID");
        log.info(String.valueOf(id));
        BookDetails bookDTO = bookService.getBookByID(id);
        ResponseDTO responseDTO = new ResponseDTO("Fetched by ID : Book Details", bookDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
