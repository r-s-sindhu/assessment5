package com.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connection.Util;
import com.model.User;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
	    	response.setContentType("text/html");
	    	PrintWriter out=response.getWriter();
	    	String luser=request.getParameter("luser");
	    	String lphone=request.getParameter("lphone");
	    	
	    	HttpSession session=request.getSession();
			session.setAttribute("name", luser);
			
	    	User u1=new User();
	    	u1.setName(luser);
	    	u1.setMobile(lphone);
	    	Statement stmt=Util.getConnection().createStatement();
			String sql="select name, mobile from register where name='"+u1.getName()+"'and mobile='"+u1.getMobile()+"'";
			ResultSet rs=stmt.executeQuery(sql);
			
			if(rs.next())
			{
				u1.setName(rs.getString(1));
				u1.setMobile(rs.getString(2));
				if(luser.equals(u1.getName()) && lphone.equals(u1.getMobile()))
				{
					out.println("<h1><center>Login success</center></h1>");
			    	RequestDispatcher rd=request.getRequestDispatcher("dashboard.jsp");
			    	rd.forward(request, response);
				}		
	    	}
			else
			{
				request.getRequestDispatcher("login.jsp").include(request, response);
				out.println("<center><h3>Login failed</h3></center>");
			}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
	}
}
