package com.harrymanproject.estore3.service.address;

import com.harrymanproject.estore3.data.exception.AddressException;
import com.harrymanproject.estore3.data.model.Address;
import com.harrymanproject.estore3.data.model.Customer;
import com.harrymanproject.estore3.data.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    AddressRepository addressRepository;

    Customer customer = new Customer();

    @Override
    public void saveAddress(Address address) throws AddressException{
        addressRepository.saveAddress(address);
    }

    @Override
    public void updateAddress(Address address) throws AddressException{

        if (address.getId() == null){
            throw new AddressException("Id can not be null");
        }

        Address address1 = addressRepository.findById(address.getId()).orElse(null);

        if (address1 == null){
            throw new AddressException("this address is not in our database");
        }else{
            if (address.getStreet() != null){
                address1.setStreet(address.getStreet());
            }
            if (address.getCity() != null){
                address1.setCity(address.getCity());
            }
            if (address.getState() != null){
                address1.setState(address.getState());
            }
            if (address.getCountry() != null){
                address1.setCountry(address.getCountry());
            }
            if (address.getZipcode() != null){
                address1.setZipcode(address.getZipcode());
            }
            if (address.getCustomers() != null){
                address1.setCustomers(customer);
            }
        }
        addressRepository.save(address1);
    }

    @Override
    public Address findAddressById(Integer id){
        return addressRepository.findById(id).orElse(null);
    }

    @Override
    public List<Address> findAllAddresses(){
        return addressRepository.findAll();
    }

    @Override
    public void deleteAddressById(Integer id){
        addressRepository.deleteById(id);
    }
}
