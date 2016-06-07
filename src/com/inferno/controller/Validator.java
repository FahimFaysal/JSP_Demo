package com.inferno.controller;

import java.util.Calendar;

import com.inferno.persistence.Service;
import com.inferno.persistence.TO;

public class Validator {

	public TO existUser(TO to) throws Exception {
		to = new Service().checkUser(to);
		return to;
	}

	public void newUserValidator(TO to) throws Exception {

		String errorMessage = null;

		if (!nameValidation(to.getFirstName())) {
			errorMessage = "1st name is not valid";
		} else if (!nameValidation(to.getSecondName())) {
			errorMessage = "2nd name is not valid ";
		} else if (!passWordValidation(to.getPassword())) {
			errorMessage = "password is not valid(al least 8 char, alphaNumaric and special char)";
		} else if (!ageValidation(to.getDob())) {
			errorMessage = "invalid age, must be 18 years old";
		} else if (!isValidEmailAddress(to.getMail())) {
			errorMessage = "invalid mail";
		}else if(!isValidGander(to.getGender())) {
			errorMessage = "Please Select gender";
		}

		if (errorMessage != null) {
			throw new Exception(errorMessage);
		}

	}
	
	public boolean isValidGander(String gen){
		if(gen == null){
			return false;
		}else{
			return true;
		}
	}
	

	public boolean isValidEmailAddress(String email) {
		return email.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$");
	}
	
	
	public boolean nameValidation(String name) {
		boolean isValid = true;
		name = name.trim();
		if (name.equals("")) {
			isValid = false;
		}
		return isValid;
	}

	public boolean ageValidation(Calendar age) {
		boolean isValid = true;
		Calendar age18 = (Calendar) Calendar.getInstance().clone();
		age18.add(Calendar.YEAR, -18);

		if (age.after(Calendar.getInstance()) || age18.before(age)) {
			isValid = false;
		}
		return isValid;
	}

	public boolean passWordValidation(String passWord) {
		boolean isValid = true;

		// password need to be at least 8 char
		if (passWord.length() < 8) {
			isValid = false;
		} else if (!(passWord.contains("!") || passWord.contains("@") || passWord.contains("#") || passWord.contains("$") || passWord.contains("%"))) {// Should contain special char ! @ # $ %
			isValid = false;
		} else {// should contain numeric char
			int i;
			for (i = 0; i < passWord.length(); i++) {
				if (Character.isDigit(passWord.charAt(i)))
					break;
			}
			if (i == passWord.length())
				isValid = false;
		}
		return isValid;
	}

	public String test(){
		return "i am test";
	}

}
