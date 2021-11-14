package edu.miu.cs.cs544.service;



import edu.miu.cs.cs544.domain.Address;
import edu.miu.cs.cs544.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository repository;

    @Override
    public List<Address> findAllAddress() {
        return repository.findAll();
    }

    public  Address addAddress(Address address){
        return repository.save(address);
    }

    @Override
    public Address findById(Long addressId) {
        return repository.findById(addressId).get();
    }

    @Override
    public Address update(Address address) {
        Address entity = new Address();
        entity.setStreet(address.getStreet());
        entity.setCity(address.getCity());
        entity.setState(address.getState());
        entity.setZipcode(address.getZipcode());
        return repository.save(entity);
    }

    @Override
    public void deleteAddress(Long addressId) {
        repository.deleteById(addressId);
    }
}
