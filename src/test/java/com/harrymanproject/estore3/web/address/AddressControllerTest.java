package com.harrymanproject.estore3.web.address;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.harrymanproject.estore3.data.model.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AddressControllerTest {
    @Autowired
    private MockMvc mockMvc;

    Address address;
    ObjectMapper objectMapper;
    @BeforeEach
    void setUp() {
        address = new Address();
        objectMapper = new ObjectMapper();
    }

    @Test
    void saveAddress() throws Exception{
        address.setStreet("5, Odogwu");
        address.setCity("Nnewi");
        address.setState("Anambra");
        address.setCountry("Nigeria");
        address.setZipcode("787878");
        this.mockMvc.perform(post("/address/create")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(address)))
                .andDo(print()).andExpect(status().isCreated()).andReturn();
    }

    @Test
    void updateAddress() throws Exception{
        address.setId(3);
        address.setStreet("10, Buluku");
        this.mockMvc.perform(post("/address/update")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(address)))
                .andDo(print()).andExpect(status().isOk()).andReturn();
    }

    @Test
    void findAddressById() throws Exception{
        this.mockMvc.perform(get("/address/2").contentType("application/json"))
                .andDo(print()).andExpect(status().isOk()).andReturn();
    }
}