package com.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connection.Util;
import com.model.User;

@WebServlet("/ShipmentDetails")
public class ShipmentDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			String trackingId=request.getParameter("tid");
			int tid=Integer.parseInt(trackingId);
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
				if(tid==rs.getInt(6))
				{
					if(u1.getDeliveryArea().equals("Bangalore"))
					{
						request.getRequestDispatcher("shipment.jsp").include(request, response);
						out.println("<center><h3>Name : "+usr+"</h3></center>"); 
						out.println("<center><h3>Mobile : "+rs.getString(4)+"</h3></center>"); 
						out.println("<center><h3>Delivery Area : "+rs.getString(5)+"</h3></center>"); 
						LocalDate shipmentDate =  LocalDate.now().plusDays(1); 
						out.println("<center><h3>Shipment date : "+shipmentDate+"</h3></center>");
						LocalDate deliveryDate =  LocalDate.now().plusDays(3); 
						out.println("<center><h3>Delivery date : "+deliveryDate+"</h3></center>"); 
					}
					else if(u1.getDeliveryArea().equals("Chennai"))
					{
						request.getRequestDispatcher("shipment.jsp").include(request, response);
						out.println("<center><h3>Name : "+usr+"</h3></center>"); 
						out.println("<center><h3>Mobile : "+rs.getString(4)+"</h3></center>"); 
						out.println("<center><h3>Delivery Area : "+rs.getString(5)+"</h3></center>"); 
						LocalDate shipmentDate =  LocalDate.now().plusDays(1); 
						out.println("<center><h3>Shipment date : "+shipmentDate+"</h3></center>");
						LocalDate deliveryDate =  LocalDate.now().plusDays(5); 
						out.println("<center><h3>Delivery date : "+deliveryDate+"</h3></center>"); 
					}
					else if(u1.getDeliveryArea().equals("Delhi"))
					{
						request.getRequestDispatcher("shipment.jsp").include(request, response);
						out.println("<center><h3>Name : "+usr+"</h3></center>"); 
						out.println("<center><h3>Mobile : "+rs.getString(4)+"</h3></center>"); 
						out.println("<center><h3>Delivery Area : "+rs.getString(5)+"</h3></center>"); 
						LocalDate shipmentDate =  LocalDate.now().plusDays(1); 
						out.println("<center><h3>Shipment date : "+shipmentDate+"</h3></center>");
						LocalDate deliveryDate =  LocalDate.now().plusDays(7); 
						out.println("<center><h3>Delivery date : "+deliveryDate+"</h3></center>"); 
					}
					else if(u1.getDeliveryArea().equals("Mumbai"))
					{
						request.getRequestDispatcher("shipment.jsp").include(request, response);
						out.println("<center><h3>Name : "+usr+"</h3></center>"); 
						out.println("<center><h3>Mobile : "+rs.getString(4)+"</h3></center>"); 
						out.println("<center><h3>Delivery Area : "+rs.getString(5)+"</h3></center>"); 
						LocalDate shipmentDate =  LocalDate.now().plusDays(1); 
						out.println("<center><h3>Shipment date : "+shipmentDate+"</h3></center>");
						LocalDate deliveryDate =  LocalDate.now().plusDays(9); 
						out.println("<center><h3>Delivery date : "+deliveryDate+"</h3></center>"); 
					}
				}
				else
				{
					request.getRequestDispatcher("shipment.jsp").include(request, response);
					out.println("<center><h3>Invalid tracking id</h3></center>");
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
