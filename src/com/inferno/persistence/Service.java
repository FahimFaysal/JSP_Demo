package com.inferno.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class Service {

	Connection dbConnection = null;

	public TO checkUser(TO to) throws Exception {
		TO findTO = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			dbConnection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "sys as sysdba", "inferno2");

			String query = "SELECT * FROM StudentClub WHERE mail = ?";
//			ResultSet resultSet = statement.executeQuery("SELECT *  FROM StudentClub WHERE mail = 'tn@g.com'");
//			resultSet.next();
//			System.out.println("hey there !");
			
			PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
			preparedStatement.setString(1, to.getMail()); 
			ResultSet resultSet  = preparedStatement.executeQuery();
			
			
			while (resultSet.next()) {
				if(to.getPassword().equals(resultSet.getString("password"))){
					findTO = new TO();
					findTO.setFirstName(resultSet.getString(1));
					findTO.setSecondName(resultSet.getString(2));
					findTO.setMail(resultSet.getString(3));
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(resultSet.getDate(5));
					findTO.setDob(calendar);
					findTO.setGender(resultSet.getString(6));
					String skill[] = {resultSet.getString(7)};
					findTO.setSkill(skill);
//					System.out.println("don't cry i'm here......"+findTO.toString());
				}
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			dbConnection.close();
//			System.out.println("i am here ..............");
		}
		return findTO;
	}

	public void addUser(TO to) throws Exception {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			dbConnection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "sys as sysdba", "inferno2");

			

			String query = " insert into StudentClub(firstName, SecondName, mail, password, dob, gender, skill )" + " values (?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement preparedStmt = dbConnection.prepareStatement(query);
			preparedStmt.setString(1, to.getFirstName());
			preparedStmt.setString(2, to.getSecondName());
			preparedStmt.setString(3, to.getMail());
			preparedStmt.setString(4, to.getPassword());
			preparedStmt.setDate(5, new java.sql.Date(to.getDob().getTime().getTime()));
			preparedStmt.setString(6, to.getGender());
			preparedStmt.setString(7, Arrays.toString(to.getSkill()));

			boolean b = preparedStmt.execute();
//			System.out.println("the addition is: " + b);

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			dbConnection.close();
		}

	}

}
