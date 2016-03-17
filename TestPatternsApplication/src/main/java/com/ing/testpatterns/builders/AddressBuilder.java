package com.ing.testpatterns.builders;

import com.ing.testpatterns.domain.Address;
import com.natpryce.makeiteasy.Instantiator;
import com.natpryce.makeiteasy.Property;
import com.natpryce.makeiteasy.PropertyLookup;

public class AddressBuilder {
	
	///////////////////////////////////////// DEFAULT / SAFE VALUES //////////////////////////////////////////

	public static final String DEFAULT_STREET = "Any safe street";
	public static final Integer DEFAULT_NUMBER = null;
	public static final String DEFAULT_POSTCODE = "1000";
	public static final String DEFAULT_CITY = "Brussels";
	public static final String DEFAULT_COUNTRYCODE = "BE";

	///////////////////////////////////////// PROPERTIES //////////////////////////////////////////

	public static final Property<Address,String> street = new Property<Address, String>();
	public static final Property<Address,Integer> number = new Property<Address, Integer>();
	public static final Property<Address,String> postCode = new Property<Address, String>();
	public static final Property<Address,String> city = new Property<Address, String>();
	public static final Property<Address,String> countryCode = new Property<Address, String>();

	///////////////////////////////////////// INSTANTIATOR //////////////////////////////////////////

	public static final Instantiator<Address> Address = new Instantiator<Address>() {
		public Address instantiate(PropertyLookup<Address> lookup) {
			Address address = new Address();
			address.setStreet(lookup.valueOf(street, DEFAULT_STREET));
			address.setNumber(lookup.valueOf(number, DEFAULT_NUMBER));
			address.setPostCode(lookup.valueOf(postCode, DEFAULT_POSTCODE));
			address.setCity(lookup.valueOf(city, DEFAULT_CITY));
			address.setCountryCode(lookup.valueOf(countryCode, DEFAULT_COUNTRYCODE));
			return address;
		}
	};
	
}
