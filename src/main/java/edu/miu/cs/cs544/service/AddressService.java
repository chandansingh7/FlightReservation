package edu.miu.cs.cs544.service;


import edu.miu.cs.cs544.domain.Address;

import java.util.List;

public interface AddressService {

    List<Address> findAllAddress();

    Address addAddress(Address address);

    Address findById(Long actorId);

    Address update(Address actor);

    void deleteAddress(Long addressId);
}
