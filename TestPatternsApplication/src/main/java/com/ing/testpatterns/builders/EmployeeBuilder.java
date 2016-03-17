package com.ing.testpatterns.builders;

import static com.natpryce.makeiteasy.MakeItEasy.a;
import static com.natpryce.makeiteasy.MakeItEasy.make;
import static com.natpryce.makeiteasy.MakeItEasy.with;

import com.ing.testpatterns.domain.Address;
import com.ing.testpatterns.domain.Employee;
import com.natpryce.makeiteasy.Instantiator;
import com.natpryce.makeiteasy.Maker;
import com.natpryce.makeiteasy.Property;
import com.natpryce.makeiteasy.PropertyLookup;

public class EmployeeBuilder {
   
	///////////////////////////////////////// DEFAULT / SAFE VALUES //////////////////////////////////////////
	
	public static final String DEFAULT_EMAIL = "employee@mail.com";
	public static final String DEFAULT_FIRSTNAME = "Firstname";
	public static final String DEFAULT_LASTNAME = "Lastname";
	public static final Boolean DEFAULT_ACTIVE = true;
	public static final Address DEFAULT_ADDRESS = null;
	public static final String DEFAULT_PHONE = "+555 11 22 33";
	
	///////////////////////////////////////// PROPERTIES //////////////////////////////////////////

    public static final Property<Employee,String> email = new Property<Employee, String>();
    public static final Property<Employee,String> firstname = new Property<Employee, String>();
    public static final Property<Employee,String> lastname = new Property<Employee, String>();
    public static final Property<Employee,Boolean> active = new Property<Employee, Boolean>();
    public static final Property<Employee,Address> address = new Property<Employee, Address>();
    public static final Property<Employee,String> phone = new Property<Employee, String>();
    
	///////////////////////////////////////// INSTANTIATOR //////////////////////////////////////////

    public static final Instantiator<Employee> Employee = new Instantiator<Employee>() {
        public Employee instantiate(PropertyLookup<Employee> lookup) {
        	Employee employee = new Employee();
        	employee.setFirstName(lookup.valueOf(firstname, DEFAULT_FIRSTNAME));
        	employee.setEmail(lookup.valueOf(email, DEFAULT_EMAIL));
        	employee.setLastName(lookup.valueOf(lastname, DEFAULT_LASTNAME));
        	employee.setActive(lookup.valueOf(active, DEFAULT_ACTIVE));
        	employee.setAddress(lookup.valueOf(address, DEFAULT_ADDRESS));
        	employee.setPhone(lookup.valueOf(phone, DEFAULT_PHONE));
        	return employee;
        }
    };

	///////////////////////////////////////// PREDEFINED OBJECTS //////////////////////////////////////////

	@SuppressWarnings("unchecked")
	public static final Maker<Employee> anActiveEmployee(){
    	return a(Employee, with(active, false));
    }
    
    @SuppressWarnings("unchecked")
	public static final Maker<Employee> anInactiveEmployee(){
    	return a(Employee, with(active, true));
    }

}