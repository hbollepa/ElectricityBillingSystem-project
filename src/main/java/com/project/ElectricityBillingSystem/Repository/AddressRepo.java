package com.project.ElectricityBillingSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ElectricityBillingSystem.Entity.AddressEntity;

@Repository // used to indicate the cls provides the mechanism for storage,update,delete
			// and search operation on object
public interface AddressRepo extends JpaRepository<AddressEntity, Integer> {

}
