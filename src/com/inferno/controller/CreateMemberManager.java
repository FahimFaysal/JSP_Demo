package com.inferno.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inferno.persistence.Service;
import com.inferno.persistence.TO;

@WebServlet(description = "check new member", urlPatterns = { "/CreateMemberManagerURL" })
public class CreateMemberManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Calendar calendar = null;
		String dateStatus = null;

		try {
			Date date = null;
			String st = request.getParameter("dob");
			DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			date = (Date) formatter.parse(st);
			calendar = Calendar.getInstance();
			calendar.setTime(date);
		} catch (ParseException e) {
			dateStatus = "date is not formateed";
//			System.out.println("date is not formateed");
		}

		String skill[] = request.getParameterValues("skill");

		TO to = new TO(request.getParameter("firstName"), request.getParameter("secondName"), request.getParameter("mail"), request.getParameter("pass"), calendar, request.getParameter("gender"), skill);

		try {
			if (new Validator().existUser(to) == null) {
				try {
					new Validator().newUserValidator(to);
					new Service().addUser(to);
					request.getSession().setAttribute("session",to);
					response.sendRedirect("Home.jsp");
				} catch (Exception e) {
					String st = e.getMessage();
					if(st == null){
						st = dateStatus;
					}
					response.sendRedirect("registration.jsp?error_message=" + st);
				}
			} else {
				response.sendRedirect("registration.jsp?error_message=This Email id already used");
			}
		} catch (Exception e) {
			response.sendRedirect("registration.jsp?error_message=" + e.getMessage());
			e.printStackTrace();
		}

	}

}
