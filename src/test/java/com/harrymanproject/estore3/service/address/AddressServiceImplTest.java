package com.harrymanproject.estore3.service.address;

import com.harrymanproject.estore3.data.exception.AddressException;
import com.harrymanproject.estore3.data.model.Address;
import com.harrymanproject.estore3.data.repository.AddressRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AddressServiceImplTest {

    @Mock
    AddressRepository addressRepository;

    @InjectMocks
    AddressService addressService = new AddressServiceImpl();

    Address address;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        address = new Address();
    }

    @Test
    void saveAddress() throws AddressException {
        addressService.saveAddress(address);
        verify(addressRepository, times(1)).saveAddress(address);
    }

    @Test
    void updateAddress() throws AddressException {
        address.setId(1);
        address.setState("Ogun");
        when(addressRepository.findById(1)).thenReturn(Optional.of(address));
        addressService.updateAddress(address);
        verify(addressRepository, times(1)).save(address);
    }

    @Test
    void findAddressById(){
        when(addressRepository.findById(2)).thenReturn(Optional.of(address));
        addressService.findAddressById(2);
        verify(addressRepository, times(1)).findById(2);
    }

    @Test
    void findAllAddresses(){
        when(addressRepository.findAll()).thenReturn(List.of(address));
        addressService.findAllAddresses();
        verify(addressRepository, times(1)).findAll();
    }

    @Test
    void deleteAddressById(){
        addressService.deleteAddressById(2);
        verify(addressRepository, times(1)).deleteById(2);
    }
}