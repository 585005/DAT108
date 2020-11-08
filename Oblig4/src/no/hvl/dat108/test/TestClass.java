package no.hvl.dat108.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import no.hvl.dat108.Validator;

class TestClass {

	@Test
	void validateFirstnameTest() {
		assertEquals(true, Validator.validateFirstname("Emilie-Hinna"));
	}
	
	@Test
	void validateLastnameTest() {
		assertEquals(false, Validator.validateLastname("Hinna Fisketjøn"));
	}
	
	@Test
	void validatePasswordTest() {
		assertEquals(false, Validator.validatePassword("hei"));
		
	}
	
	@Test 
	void validateRepeatPasswordTest() {
		assertEquals(false, Validator.validateRepeatPassword("heisann", "heisann1"));
		
	}
	
	/*
	@Test 
	void validatePhoneTest() {
		assertEquals(true, Validator.validatePhone("12345678"));
		
	}
	*/
	
	@Test 
	void validateStringTest() {
		assertEquals(false, Validator.validateString("hei@123-f"));
		
	}
	
	@Test 
	void validateDigitTest() {
		assertEquals(true, Validator.onlyDigits("123456789"));
	}

}
