package com.service;

import java.io.IOException;
//import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.UserDao;
import com.model.User;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			response.setContentType("text/html");
			String name=request.getParameter("user");
			String city=request.getParameter("city");
			String mobile=request.getParameter("phone");
			String deliveryArea=request.getParameter("deliveryArea");
			User u1=new User();
			u1.setName(name);
			u1.setCity(city);
			u1.setMobile(mobile);
			u1.setDeliveryArea(deliveryArea);				
			UserDao.saveUser(u1);
			request.getRequestDispatcher("login.jsp").include(request, response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
   	}
}
