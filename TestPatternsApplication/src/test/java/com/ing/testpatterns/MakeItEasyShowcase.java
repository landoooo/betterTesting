package com.ing.testpatterns;

import static com.ing.testpatterns.builders.AddressBuilder.Address;
import static com.ing.testpatterns.builders.AddressBuilder.street;
import static com.ing.testpatterns.builders.EmployeeBuilder.Employee;
import static com.ing.testpatterns.builders.EmployeeBuilder.address;
import static com.ing.testpatterns.builders.EmployeeBuilder.*;
import static com.natpryce.makeiteasy.MakeItEasy.a;
import static com.natpryce.makeiteasy.MakeItEasy.make;
import static com.natpryce.makeiteasy.MakeItEasy.with;

import org.junit.Test;

import com.ing.testpatterns.domain.Address;
import com.ing.testpatterns.domain.Employee;

/**
 *
 * @author D-UK24FA
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
