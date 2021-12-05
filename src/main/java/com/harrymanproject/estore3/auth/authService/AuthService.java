package com.harrymanproject.estore3.auth.authService;

import com.harrymanproject.estore3.data.dto.CustomerDto;
import com.harrymanproject.estore3.data.dto.LoginDto;
import com.harrymanproject.estore3.data.model.Customer;

import javax.security.auth.message.AuthException;

public interface AuthService {
    Customer register(CustomerDto customerDto) throws AuthException;
    boolean login(LoginDto loginDto) throws AuthException;
}
