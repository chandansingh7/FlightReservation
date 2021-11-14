package edu.miu.cs.cs544.controller;


import edu.miu.cs.cs544.domain.Address;
import edu.miu.cs.cs544.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping
    public List<Address> getAllAddresses(){
        return addressService.findAllAddress();
    }

    @PostMapping
    public ResponseEntity<Address> addAddress(@RequestBody Address address){
        return ResponseEntity.ok(addressService.addAddress(address));
    }


    @GetMapping("/{addressId}")
    public Address getAddressById(@PathVariable("addressId") Long addressId){
        return  addressService.findById(addressId);
    }

    @PutMapping("/{addressId}")
    public ResponseEntity<?> update(@PathVariable("addressId") Long addressId, @RequestBody Address address) {
        if (addressId.equals(address.getId())) {
            return ResponseEntity.ok(addressService.update(address));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{addressId}")
    public void deleteFlight(@PathVariable Long addressId){
        addressService.deleteAddress(addressId);
    }
}
