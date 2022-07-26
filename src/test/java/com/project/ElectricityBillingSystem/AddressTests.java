package com.project.ElectricityBillingSystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.project.ElectricityBillingSystem.Entity.AddressEntity;
import com.project.ElectricityBillingSystem.Exceptions.AddressNotFoundException;
import com.project.ElectricityBillingSystem.Services.AddressServicesImple;

  @ExtendWith(SpringExtension.class)
      // is a repeatable annotation that is used to register extensions for the annotated test clases,
  @SpringBootTest
     // is useful when we need to bootstrap the entire container
    // it works by creating applncontext that will be utilised in our tests
   // we can use the web environment attribute of @springboottest to config our runtime environment
  @AutoConfigureMockMvc
  // it can b applied to a test class to enable and configure auto-config of mock mvc
public class AddressTests {

	@Autowired
	// used for dependency injection & auto-wire bean into another bean
	// DI injects objs into other obj/dependencies
	private AddressServicesImple addressServicesImple;

	@Test
	// it is imp,,where we write code/busines logic
	// if smthng needs to be automated,,that particular code needs to be inserted
	// into test method
	// test method then executes @Test by passing attributes
	void addAddressTest() {
		// asserts--used to validate 2values are equal
		AddressEntity addressEntity = new AddressEntity(4, "3-3", "Avenue street", "Banglore", "karnataka", 9090);
		AddressEntity result = addressServicesImple.addAddress(addressEntity);
		assertEquals(addressEntity.toString(), result.toString());
	}

	@Test
	void getAddressTest() {
		AddressEntity addressEntity = new AddressEntity(2, "29", "SSS", "SSS", "SSS", 2507);
		Optional<AddressEntity> result;
		try {
			result = addressServicesImple.getAddress(2);
			assertEquals(addressEntity.toString(), result.get().toString());
		} catch (AddressNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}

	@Test
	void updateAddressTest() {
		AddressEntity addressEntity = new AddressEntity(3, "6", "CCNB", "Alappuzha", "Kerala", 8080);
		AddressEntity result = null;
		try {
			result = addressServicesImple.updateAddress(3, addressEntity);
			if (result == null)
				throw new AddressNotFoundException("no address found");
			assertEquals(addressEntity.toString(), result.toString());
		} catch (AddressNotFoundException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	void removeAddressTest() {
		AddressEntity addressEntity = new AddressEntity(9, "20", "MMM", "MMM", "MMM", 2020);
		Optional<AddressEntity> result = null;
		try {
			result = addressServicesImple.deleteAddress(9);
			if (result == null)
				throw new AddressNotFoundException("no address found");
			assertEquals(addressEntity.toString(), result.get().toString());
		} catch (AddressNotFoundException e) {
			e.printStackTrace();
			fail();
		}
	}

}
