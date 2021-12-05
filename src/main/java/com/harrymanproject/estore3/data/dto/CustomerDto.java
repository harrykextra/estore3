package com.harrymanproject.estore3.data.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class CustomerDto {

    @NotBlank(message = "First name must be provided")
    private String firstName;
    @NotBlank(message = "Last name must be provided")
    private String lastName;
    @Email(message = "Invalid Email")
    private String email;
    @NotBlank(message = "phone number must be provided")
    private String phoneNumber;
    @Size(min = 6, max = 20, message = "Invalid password")
    private  String password;
}
