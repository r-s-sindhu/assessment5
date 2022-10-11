package com.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.UserDao;
import com.connection.Util;
import com.model.User;

@WebServlet("/Courier")
public class Courier extends HttpServlet {
	private static final long serialVersionUID = 1L;
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try
    	{
    		response.setContentType("text/html");
    		PrintWriter out=response.getWriter();
    		String weight=request.getParameter("weight");
    		int wt=Integer.parseInt(weight);
    		HttpSession session=request.getSession();
			session.getAttribute("name");
			String usr=(String)session.getAttribute("name");			
			User u1=new User();
	    	Statement stmt=Util.getConnection().createStatement();
			String sql="select * from register where name='"+usr+"'";
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next())
			{
				u1.setDeliveryArea(rs.getString(5));
				int total=0;
				int deliveryCharge=UserDao.deliveryCharge(u1.getDeliveryArea());
				if(wt>0 && wt<100)
				{
					int amt=100;
					total=deliveryCharge+amt;
					request.getRequestDispatcher("courier.jsp").include(request, response);
					out.println("<center><h3>Total Payable Amount : "+total+"</h3></center>");
					out.println("<center><h3>Tracking id : "+rs.getInt(6)+"</h3></center>");
				}
				else if(wt>=100 & wt<500)
				{
					int amt=200;
					total=deliveryCharge+amt;
					request.getRequestDispatcher("courier.jsp").include(request, response);
					out.println("<center><h3>Total Payable Amount : "+total+"</h3></center>");
					out.println("<center><h3>Tracking id : "+rs.getInt(6)+"</h3></center>");
				}
				else if(wt>=500 & wt<1000)
				{
					int amt=400;
					total=deliveryCharge+amt;
					request.getRequestDispatcher("courier.jsp").include(request, response);
					out.println("<center><h3>Total Payable Amount : "+total+"</h3></center>");
					out.println("<center><h3>Tracking id : "+rs.getInt(6)+"</h3></center>");
				}
				else
				{
					int amt=600;
					total=deliveryCharge+amt;
					request.getRequestDispatcher("courier.jsp").include(request, response);
					out.println("<center><h3>Total Payable Amount : "+total+"</h3></center>");
					out.println("<center><h3>Tracking id : "+rs.getInt(6)+"</h3></center>");
				}
			}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }

}
