package io.github.anantharajuc.sbmwa.service;

import java.util.List;

import io.github.anantharajuc.sbmwa.domain.model.Address;

public interface AddressService 
{
	List<Address> findAllAddress();
	
	Address findAddressById(Long id);
}
