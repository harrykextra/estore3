package com.harrymanproject.estore3.auth.authService;

import com.harrymanproject.estore3.data.dto.CustomerDto;
import com.harrymanproject.estore3.data.dto.LoginDto;
import com.harrymanproject.estore3.data.model.Customer;
import com.harrymanproject.estore3.data.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.message.AuthException;

@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    CustomerRepository customerRepo;

    ModelMapper mapper = new ModelMapper();
    @Override
    public Customer register(CustomerDto customerDto) throws AuthException{
        if (validateEmail(customerDto.getEmail())){
            throw new AuthException("Email is already in use");
        }
        Customer customer = mapper.map(customerDto, Customer.class);
        return save(customer);
    }

    private boolean validateEmail(String email){return customerRepo.existsByEmail(email);}

    private Customer save (Customer customer){return customerRepo.save(customer);}

    @Override
    public boolean login(LoginDto loginDto) throws AuthException{
        boolean isLoggedIn = false;
        Customer customer = customerRepo.findByEmail(loginDto.getEmail());
        if(isValidPassword(loginDto.getPassword(), customer.getPassword()))
            isLoggedIn = true;
        return isLoggedIn;
    }

    private boolean isValidPassword(String loginPassword, String customerPassword)throws AuthException{
        if (loginPassword == null){
            throw new AuthException("Login password can not be null");
        }
        return loginPassword.equals(customerPassword);
    }
}
