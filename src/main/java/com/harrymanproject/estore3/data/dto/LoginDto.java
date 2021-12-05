package com.harrymanproject.estore3.data.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
public class LoginDto {
    @Email(message = "Invalid email")
    private String email;
    @Size(min = 6, max = 20, message = "Invalid password")
    private String password;
}
