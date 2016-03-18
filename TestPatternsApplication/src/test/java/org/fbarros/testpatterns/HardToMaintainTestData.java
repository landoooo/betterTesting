package org.fbarros.testpatterns;

import org.fbarros.testpatterns.domain.Address;
import org.fbarros.testpatterns.domain.Employee;
import org.junit.Test;

/**
 *
 * @author fbarros
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
