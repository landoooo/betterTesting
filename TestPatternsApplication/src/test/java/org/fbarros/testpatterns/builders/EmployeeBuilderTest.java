package org.fbarros.testpatterns.builders;
import static com.natpryce.makeiteasy.MakeItEasy.a;
import static com.natpryce.makeiteasy.MakeItEasy.make;
import static com.natpryce.makeiteasy.MakeItEasy.with;

import static org.assertj.core.api.Assertions.*;
import static org.fbarros.testpatterns.builders.AddressBuilder.Address;
import static org.fbarros.testpatterns.builders.AddressBuilder.number;
import static org.fbarros.testpatterns.builders.AddressBuilder.street;
import static org.fbarros.testpatterns.builders.EmployeeBuilder.DEFAULT_ACTIVE;
import static org.fbarros.testpatterns.builders.EmployeeBuilder.DEFAULT_ADDRESS;
import static org.fbarros.testpatterns.builders.EmployeeBuilder.DEFAULT_EMAIL;
import static org.fbarros.testpatterns.builders.EmployeeBuilder.DEFAULT_FIRSTNAME;
import static org.fbarros.testpatterns.builders.EmployeeBuilder.DEFAULT_LASTNAME;
import static org.fbarros.testpatterns.builders.EmployeeBuilder.DEFAULT_PHONE;
import static org.fbarros.testpatterns.builders.EmployeeBuilder.Employee;
import static org.fbarros.testpatterns.builders.EmployeeBuilder.active;
import static org.fbarros.testpatterns.builders.EmployeeBuilder.address;
import static org.fbarros.testpatterns.builders.EmployeeBuilder.email;
import static org.fbarros.testpatterns.builders.EmployeeBuilder.firstname;
import static org.fbarros.testpatterns.builders.EmployeeBuilder.lastname;
import static org.fbarros.testpatterns.builders.EmployeeBuilder.phone;

import org.assertj.core.api.SoftAssertions;
import org.fbarros.testpatterns.domain.Address;
import org.fbarros.testpatterns.domain.Employee;
import org.junit.Test;


public class EmployeeBuilderTest {

	private static final String CUSTOM_EMAIL = "custom@mail.be";
	private static final String CUSTOM_FIRSTNAME = "CustomName";
	private static final String CUSTOM_LASTNAME = "van Custom";
	private static final Boolean CUSTOM_ACTIVE = false;
	private static final String CUSTOM_PHONE = "customWorkphone";
	private static final Address CUSTOM_ADDRESS = make(a(Address, with(street, "Custom street"), with(number, 69)));

	@Test
	@SuppressWarnings("unchecked")
	public void defaultCreationTest() {
		Employee employee = make(a(Employee));
		SoftAssertions softly = new SoftAssertions();
		softly.assertThat(employee.getFirstName()).isEqualTo(DEFAULT_FIRSTNAME);
		softly.assertThat(employee.getLastName()).isEqualTo(DEFAULT_LASTNAME);
		softly.assertThat(employee.getEmail()).isEqualTo(DEFAULT_EMAIL);
		softly.assertThat(employee.getPhone()).isEqualTo(DEFAULT_PHONE);
		softly.assertThat(employee.isActive()).isEqualTo(DEFAULT_ACTIVE);
		softly.assertThat(employee.getAddress()).isEqualTo(DEFAULT_ADDRESS);
		softly.assertAll();
	}

	@Test
	@SuppressWarnings("unchecked")
	public void customCreationTest() {

		Employee employee = make(a(Employee, with(firstname, CUSTOM_FIRSTNAME),
				with(lastname, CUSTOM_LASTNAME), with(email, CUSTOM_EMAIL),
				with(phone, CUSTOM_PHONE), with(active, CUSTOM_ACTIVE), 
				with(address, CUSTOM_ADDRESS)));

		SoftAssertions softly = new SoftAssertions();
		softly.assertThat(employee.getFirstName()).isEqualTo(CUSTOM_FIRSTNAME);
		softly.assertThat(employee.getLastName()).isEqualTo(CUSTOM_LASTNAME);
		softly.assertThat(employee.getEmail()).isEqualTo(CUSTOM_EMAIL);
		softly.assertThat(employee.getPhone()).isEqualTo(CUSTOM_PHONE);
		softly.assertThat(employee.isActive()).isEqualTo(CUSTOM_ACTIVE);
		softly.assertThat(employee.getAddress()).isEqualTo(CUSTOM_ADDRESS);
		softly.assertAll();
	}

}