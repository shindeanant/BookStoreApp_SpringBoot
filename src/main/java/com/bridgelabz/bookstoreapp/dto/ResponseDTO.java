package com.bridgelabz.bookstoreapp.dto;

import com.bridgelabz.bookstoreapp.model.CartData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor
public class ResponseDTO {
    private String message;
    private Object data;



    public ResponseDTO(String message,Object data) {
        this.message = message;
        this.data = data;
    }

}
