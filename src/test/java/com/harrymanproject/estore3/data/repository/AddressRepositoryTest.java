package com.harrymanproject.estore3.data.repository;

import com.harrymanproject.estore3.data.exception.AddressException;
import com.harrymanproject.estore3.data.model.Address;
import com.harrymanproject.estore3.data.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
@Sql(scripts = "classpath:db/insert.sql")
class AddressRepositoryTest {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    CustomerRepository customerRepository;

    Address address;
    Customer customer;

    @BeforeEach
    void setUp() {
        address = new Address();
        customer = new Customer();
    }

    @Test
    void testThatWeCanSaveAddress(){
        address.setStreet("Buluku");
        address.setCity("Ibara");
        address.setState("Ogun");
        address.setCountry("Nigeria");
        address.setZipcode("30303");

        customer = customerRepository.findById(1).orElse(null);
        address.setCustomers(customer);

        assertDoesNotThrow(() -> addressRepository.saveAddress(address));

    }

    @Test
    void testThatWeCanUpdateAddress() {
        address = addressRepository.findById(2).orElse(null);
        address.setStreet("213, Asaro street");
        addressRepository.save(address);

        assertThat(address.getStreet()).isEqualTo("213, Asaro street");
    }

    @Test
    void findByIdTest(){
        address = addressRepository.findById(1).orElse(null);
        assertThat(address.getCity()).isEqualTo("Yaba");
    }

    @Test
    void testThatWeCanFindAllAddresses(){
        List<Address> addresses = addressRepository.findAll();
        assertThat(addresses.size()).isEqualTo(2);
    }

    @Test
    void deleteAddressByIdTest(){
        address = addressRepository.findById(2).orElse(null);
        assertThat(address).isNotNull();

        addressRepository.deleteById(2);
        assertThat(addressRepository.existsById(2)).isFalse();
    }

}