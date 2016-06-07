package com.inferno.persistence;

import java.util.Arrays;
import java.util.Calendar;

public class TO {
	
	private String firstName;
	private String secondName;
	private String mail;
	private String password;
	private Calendar dob;
	private String gender;
	private String skill[];	
	
	public TO(String firstName, String secondName, String mail, String password, Calendar dob, String gender, String[] skill) {
		super();
		this.firstName = firstName;
		this.secondName = secondName;
		this.mail = mail;
		this.password = password;
		this.dob = dob;
		this.gender = gender;
		this.skill = skill;
	}		
	
	public TO(String mail, String password) {
		super();
		this.mail = mail;
		this.password = password;
	}

	public TO() {
		
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Calendar getDob() {
		return dob;
	}
	public void setDob(Calendar dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String[] getSkill() {
		return skill;
	}
	public void setSkill(String[] skill) {
		this.skill = skill;
	}
	
	@Override
	public String toString() {
		return  "Details: <br>First Name: " + firstName + ",<br> Second Name: " + secondName + ",<br> Email: " + mail + ",<br> Birthday: " + dob.getTime() + ",<br> Gender: " + gender + ",<br> Skill: " + Arrays.toString(skill);
	}
			

}
