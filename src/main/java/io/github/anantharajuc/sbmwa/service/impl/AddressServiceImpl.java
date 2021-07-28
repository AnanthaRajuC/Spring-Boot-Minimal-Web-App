package io.github.anantharajuc.sbmwa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.anantharajuc.sbmwa.domain.model.Address;
import io.github.anantharajuc.sbmwa.infra.exception.ResourceNotFoundException;
import io.github.anantharajuc.sbmwa.repository.AddressRepository;
import io.github.anantharajuc.sbmwa.service.AddressService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class AddressServiceImpl implements AddressService
{
	@Autowired
	private AddressRepository addressRepository;
	
	@Override
	public List<Address> findAllAddress() 
	{
		log.info("-----> findAllAddress service");
		
		return addressRepository.findAll();
	}

	@Override
	public Address findAddressById(Long id) 
	{
		return addressRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Address", "id", id));
	}
}
