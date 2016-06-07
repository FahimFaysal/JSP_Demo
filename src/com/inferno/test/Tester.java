package com.inferno.test;

import static org.junit.Assert.*;
//import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.junit.Test;

import com.inferno.controller.Validator;
import com.inferno.persistence.TO;

public class Tester {

	Validator validator = new Validator();
	TO to;// = new TO();

	@Test
	public void EmptyName() {
		assertTrue(validator.nameValidation("fahim"));
	}

	@Test
	public void validName() {
		assertFalse(validator.nameValidation(""));
	}

	@Test
	public void inValidAge() {
		String st[] = { "java", "c#" };
		to = new TO("fahim", "faysal", "fahim@faysal.com", "aAasdf121@", Calendar.getInstance(), "Male", st);
		try {
			validator.newUserValidator(to);
		} catch (Exception e) {
			e.printStackTrace();
			assertEquals("invalid age, must be 18 years old", e.getMessage());
		}
	}

}
