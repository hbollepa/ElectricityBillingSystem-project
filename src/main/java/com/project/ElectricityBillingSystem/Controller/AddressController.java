package com.project.ElectricityBillingSystem.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.ElectricityBillingSystem.Entity.AddressEntity;
import com.project.ElectricityBillingSystem.Exceptions.AddressNotFoundException;
import com.project.ElectricityBillingSystem.Services.AddressService;

@RestController
//it allows to handle all REST APIs such as GET,POST,PUT,DELETE requests

public class AddressController {

	@Autowired
	// used for dependency injection & auto-wire bean into another bean
	// DI injects objs into other obj/dependencies

	
	private AddressService addressServices;

	@GetMapping("/address") // To read the data
	public List<AddressEntity> getAllAddress() {
		return addressServices.getAllAddress();
	}

	@GetMapping("address/{id}") // read
	public Optional<AddressEntity> getAddressById(@PathVariable int id) throws AddressNotFoundException {

		return addressServices.getAddress(id);
	}

	@PostMapping("address") // create
	public AddressEntity addAddress(@Valid @RequestBody AddressEntity addressEntity) {
		return addressServices.addAddress(addressEntity);
	}
	// @requestbody- it applicable to handle methods of spring controller
		// used to bind the http req/res body wit obj in method return type
   // @Valid- ensures that validation of the whole obj
  // @pathVariable-used to extract value of variable & assign thier value to method variable
		// it is most suitable for restful web services

	@PutMapping("address/{id}") // update
	public AddressEntity updateAddress(@PathVariable int id, @Valid @RequestBody AddressEntity addressEntity)
			throws AddressNotFoundException {
		return addressServices.updateAddress(id, addressEntity);
	}

	@DeleteMapping("address/{id}") // remove
	public Optional<AddressEntity> deleteAddress(@PathVariable int id) throws AddressNotFoundException {
		return addressServices.deleteAddress(id);
	}

}
