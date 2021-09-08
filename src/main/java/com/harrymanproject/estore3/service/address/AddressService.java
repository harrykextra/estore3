package com.harrymanproject.estore3.service.address;

import com.harrymanproject.estore3.data.exception.AddressException;
import com.harrymanproject.estore3.data.model.Address;

import java.util.List;

public interface AddressService {

    void saveAddress(Address address) throws AddressException;
    void updateAddress(Address address) throws AddressException;
    Address findAddressById(Integer id);
    List<Address> findAllAddresses();
    void deleteAddressById(Integer id);
}
