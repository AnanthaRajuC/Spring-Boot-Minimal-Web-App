package io.github.anantharajuc.sbmwa.api.address;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.anantharajuc.sbmwa.domain.model.Address;
import io.github.anantharajuc.sbmwa.service.impl.AddressServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="AddressQueryController", description = "Set of public APIs, for querying Address.")
@RestController
@RequestMapping(value="/api")
public class AddressQueryController 
{
	@Autowired
	AddressServiceImpl addressServiceImpl;
	
	@GetMapping(value = "/address", produces = "application/json")
	public List<Address> getAllAddress()
	{
		return addressServiceImpl.findAllAddress();
	}
}
