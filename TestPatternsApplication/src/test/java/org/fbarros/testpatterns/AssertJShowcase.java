package org.fbarros.testpatterns;

import static org.fbarros.testpatterns.builders.EmployeeBuilder.DEFAULT_LASTNAME;
import static org.fbarros.testpatterns.builders.EmployeeBuilder.Employee;
import static org.fbarros.testpatterns.builders.EmployeeBuilder.*;
import static com.natpryce.makeiteasy.MakeItEasy.a;
import static com.natpryce.makeiteasy.MakeItEasy.make;
import static com.natpryce.makeiteasy.MakeItEasy.with;
import static org.assertj.core.api.Assertions.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

import org.fbarros.testpatterns.domain.Employee;

/**
 * Examples taken from assertJ site:
 * 
 * http://joel-costigliola.github.io/assertj/assertj-core-features-highlight.html
 * @author fbarros
 *
 */
public class AssertJShowcase {

	private final Employee bernard = make(a(Employee, with(firstname, "Bernard")));
	private final Employee alain = make(a(Employee, with(firstname, "Alain")));
	private final Employee tanzu = make(a(Employee, with(firstname, "Tanzu")));
	private final Employee david = make(a(Employee, with(firstname, "David")));
	private final Employee fernando = make(a(Employee, with(firstname, "Fernando")));
	private List<Employee> employees = Arrays.asList(bernard, alain, tanzu, david, fernando);

	/**
	 * Soft assertions + descriptions
	 */
	@Test
	public void softAssertionsTest(){

		SoftAssertions softly = new SoftAssertions();
		softly.assertThat(alain).isSameAs(bernard).as("Alain is Bernard");
		softly.assertThat(tanzu).isSameAs(bernard).as("Tanzu is Bernard");
		softly.assertThat(david).isSameAs(bernard).as("David is Bernard");
		softly.assertThat(fernando).isSameAs(bernard).as("Fernando is Bernard");
		softly.assertAll();
	}

	/**
	 * Filtering by field and value or Java 8 Predicate
	 */
	@Test
	public void filteringTest(){

		assertThat(employees)
		.filteredOn("firstName", "Bernard")
		.containsExactly(bernard);

		assertThat(employees)
		.filteredOn(employee -> employee.getFirstName().contains("i"))
		.containsExactly(david, alain);
	}

	/**
	 * Extraction properties
	 * 
	 * Method result alternative: extractingResultOf(methodName)
	 */
	@Test
	public void extractingTest(){

		assertThat(employees)
		.extracting("firstName")
		.contains("Bernard", "Alain", "David", "Tanzu", "Fernando");

		assertThat(employees)
		.filteredOn(employee -> employee.getFirstName().contains("i"))
		.extracting("firstName", "lastName")
		.contains(tuple("Alain", DEFAULT_LASTNAME), tuple("David", DEFAULT_LASTNAME))
		.doesNotContain(tuple("Tanzu", DEFAULT_LASTNAME));
	}


	//EXCEPTIONS

	@Test
	public void testException1() {
		assertThatThrownBy(() -> { throw new Exception("boom!"); })
			.isInstanceOf(Exception.class)
			.hasMessageContaining("boom");
	}

	@Test
	public void testException2() {
		assertThatExceptionOfType(IOException.class)
			.isThrownBy(() -> { throw new IOException("boom!"); })
			.withMessage("%s!", "boom")
			.withMessageContaining("boom")
			.withNoCause(); 
	}

	@Test
	public void testExceptionBDDStyle() {
		// given some preconditions

		// when
		Throwable thrown = catchThrowable(() -> { throw new Exception("boom!"); });

		// then
		assertThat(thrown).isInstanceOf(Exception.class)
			.hasMessageContaining("boom");
	}

}
