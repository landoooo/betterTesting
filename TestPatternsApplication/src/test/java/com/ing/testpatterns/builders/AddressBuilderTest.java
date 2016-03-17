package com.ing.testpatterns.builders;

import static com.ing.testpatterns.builders.AddressBuilder.*;
import static com.natpryce.makeiteasy.MakeItEasy.a;
import static com.natpryce.makeiteasy.MakeItEasy.make;
import static com.natpryce.makeiteasy.MakeItEasy.with;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

import com.ing.testpatterns.domain.Address;

public class AddressBuilderTest {

	private static final String CUSTOM_STREET = "custom@mail.be";
	private static final Integer CUSTOM_NUMBER = 124;
	private static final String CUSTOM_POSTCODE = "van Custom";
	private static final String CUSTOM_CITY = "MyCity";
	private static final String CUSTOM_COUNTRYCODE = "CCode";
	
	@Test
	@SuppressWarnings("unchecked")
	public void defaultCreationTest() {
		Address address = make(a(Address));
		SoftAssertions softly = new SoftAssertions();
		softly.assertThat(address.getStreet()).isEqualTo(DEFAULT_STREET);
		softly.assertThat(address.getNumber()).isEqualTo(DEFAULT_NUMBER);
		softly.assertThat(address.getPostCode()).isEqualTo(DEFAULT_POSTCODE);
		softly.assertThat(address.getCity()).isEqualTo(DEFAULT_CITY);
		softly.assertThat(address.getCountryCode()).isEqualTo(DEFAULT_COUNTRYCODE);
		softly.assertAll();
	}

	@Test
	@SuppressWarnings("unchecked")
	public void customCreationTest() {

		Address address = make(a(Address, with(street, CUSTOM_STREET),
				with(number, CUSTOM_NUMBER), with(postCode, CUSTOM_POSTCODE),
				with(city, CUSTOM_CITY), with(countryCode, CUSTOM_COUNTRYCODE)));

		SoftAssertions softly = new SoftAssertions();
		softly.assertThat(address.getStreet()).isEqualTo(CUSTOM_STREET);
		softly.assertThat(address.getNumber()).isEqualTo(CUSTOM_NUMBER);
		softly.assertThat(address.getPostCode()).isEqualTo(CUSTOM_POSTCODE);
		softly.assertThat(address.getCity()).isEqualTo(CUSTOM_CITY);
		softly.assertThat(address.getCountryCode()).isEqualTo(CUSTOM_COUNTRYCODE);
		softly.assertAll();
	}
}
