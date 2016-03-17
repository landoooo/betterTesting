package com.ing.testpatterns;

import org.junit.Test;

import com.ing.testpatterns.domain.Address;
import com.ing.testpatterns.domain.Employee;

/**
 *
 * @author D-UK24FA
 *
 */
public class HardToMaintainTestData {
	
	@SuppressWarnings("unchecked")
	@Test
	public void simpleTest(){
		
		Address address = new Address();
		address.setCity("Anycity");
		address.setCountryCode("CD");
		address.setStreet("myStreet");
		address.setNumber(45);
		address.setPostCode("1000");
		
		Employee employee = new Employee();
		employee.setActive(true);
		employee.setPhone("+333 222 111");
		employee.setAddress(address);
		employee.setEmail("email@whatever.com");
		employee.setFirstName("Paco");
		employee.setFirstName("Gonzalez");

		// ... test
		
	}
}
