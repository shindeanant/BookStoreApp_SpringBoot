//package com.bridgelabz.bookstoreapp.model;
//
//import com.bridgelabz.bookstoreapp.dto.OrderDTO;
//import com.fasterxml.jackson.annotation.JsonFormat;
//import org.springframework.data.domain.jaxb.SpringDataJaxb;
//
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import java.time.LocalDate;
//
//public class OrderData {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private int orderId;
//    @JsonFormat(pattern = "dd-MM-yyyy")
//    private LocalDate orderDate;
//    private int price;
//    private int quantity;
//    private String address;
//    private int userId;
//    private int bookId;
//    private boolean cancel= false;
//
//    public void crateOrder(OrderDTO orderDto) {
//        this.orderDate = LocalDate.now();
//        this.price = orderDto.getPrice();
//        this.quantity = orderDto.getQuantity();
//        this.address = orderDto.getAddress();
//        this.userId = orderDto.getUserId();
//        this.bookId = orderDto.getBookId();
//        this.cancel = false;
//
//    }
//}
