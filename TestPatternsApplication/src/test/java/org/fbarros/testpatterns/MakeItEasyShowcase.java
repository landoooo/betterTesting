package org.fbarros.testpatterns;

import static com.natpryce.makeiteasy.MakeItEasy.a;
import static com.natpryce.makeiteasy.MakeItEasy.make;
import static com.natpryce.makeiteasy.MakeItEasy.with;
import static org.fbarros.testpatterns.builders.AddressBuilder.Address;
import static org.fbarros.testpatterns.builders.AddressBuilder.street;
import static org.fbarros.testpatterns.builders.EmployeeBuilder.*;

import org.fbarros.testpatterns.domain.Address;
import org.fbarros.testpatterns.domain.Employee;
import org.junit.Test;

/**
 *
 * @author fbarros
 *
 */
public class MakeItEasyShowcase {

	
	@SuppressWarnings({ "unchecked", "unused" })
	@Test
	public void simpleTest(){
		
		Address myAddress = make(a(Address, with(street, "MyStreet")));
		
		Employee bernard = make(a(Employee, with(firstname, "Bernard"), with(address, myAddress)));

		Employee activeEmployee = make(anActiveEmployee());
		
		// ... test
		
	}
}
