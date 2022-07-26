package com.project.ElectricityBillingSystem.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.ElectricityBillingSystem.Entity.AddressEntity;
import com.project.ElectricityBillingSystem.Exceptions.AddressNotFoundException;

@Service // used in service layer and annotates clases that perform service tasks
// used with class that provides some business logic
public interface AddressService {

	public List<AddressEntity> getAllAddress();

	public Optional<AddressEntity> getAddress(int id) throws AddressNotFoundException;

	public AddressEntity addAddress(AddressEntity addressEntity);

	public Optional<AddressEntity> deleteAddress(int id) throws AddressNotFoundException;

	public AddressEntity updateAddress(int id, AddressEntity addressEntity) throws AddressNotFoundException;

}
