package com.bridgelabz.bookstoreapp.dto;


import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;


@Data
@ToString
public class UserRegistrationDto {
    @Pattern(regexp = "^[A-Z]{1,}[a-zA-z\\s.]{2,}$", message = "FullName is invalid")
    @NotEmpty(message = "Name can not be NULL")
    public String fullName;
    public String emailId;
    public String password;
    public String mobileNo;
    public LocalDate updatedDate;
    public   LocalDate registerDate;
    public String status;

}
