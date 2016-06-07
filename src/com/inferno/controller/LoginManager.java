package com.inferno.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.inferno.persistence.TO;

@WebServlet(description = "manage login request", urlPatterns = { "/LoginManagerURL" })
public class LoginManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TO to = new TO(request.getParameter("userId"), request.getParameter("passWord"));

		logger = Logger.getLogger(LoginManager.class);
		
		logger.debug("Start................");
		logger.debug("Test Log**********");
		logger.info("Test Log----------------");
		logger.warn("Test Log++++++++++++++");
		logger.error("Test Log111111111111111111111111");

		try {
			to = new Validator().existUser(to);
		} catch (Exception e) {
			e.printStackTrace();

			logger.error("this is a sample log message.");
			System.out.println("*****************");
		}
		if (to != null) {
			request.getSession().setAttribute("session", to);
			response.sendRedirect("Home.jsp");
		} else {

			logger.error("this is a sample log message.");
			response.sendRedirect("login.jsp?error_message=Incorrect E-mail/ password");
			System.out.println("-----------?---------------");
			

		}
	}

}
