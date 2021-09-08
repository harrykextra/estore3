package com.harrymanproject.estore3.web.address;

import com.harrymanproject.estore3.data.exception.AddressException;
import com.harrymanproject.estore3.data.model.Address;
import com.harrymanproject.estore3.service.address.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    AddressService addressService;

    @PostMapping("/create")
    public ResponseEntity<?> saveAddress(@RequestBody Address address) throws AddressException {
        addressService.saveAddress(address);
        return new ResponseEntity<>(address, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateAddress(@RequestBody Address address) throws AddressException {
        addressService.updateAddress(address);
        return new ResponseEntity<>(address, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findAddressById(@PathVariable Integer id){
        Address address = addressService.findAddressById(id);
        return new ResponseEntity<>(address, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllAddresses(){
        List<Address> addresses = addressService.findAllAddresses();
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAddressById(@PathVariable Integer id){
        addressService.deleteAddressById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
