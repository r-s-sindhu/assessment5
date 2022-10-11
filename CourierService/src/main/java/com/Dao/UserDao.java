package com.Dao;

import java.sql.Statement;
import java.util.Random;

import com.model.User;
import com.connection.Util;

public class UserDao {
	public static int saveUser(User user)
	{
		Statement stmt=null;
		String sql=null;
		try
		{
			Random rand = new Random(); 
	        int tid = rand.nextInt(1000); 
			sql="insert into register(name,city,mobile,deliveryArea,trackingId) values('"+user.getName()+"','"+user.getCity()+"','"+user.getMobile()+"','"+user.getDeliveryArea()+"','"+tid+"')";
			stmt=Util.getConnection().createStatement();
			return stmt.executeUpdate(sql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}
	}
	public static int deliveryCharge(String deliveryArea)
	{
		int deliveryCharge = 0;
		try 
		{
			if(deliveryArea.equals("Bangalore"))
			{
				deliveryCharge=100;
			}
			else if(deliveryArea.equals("Chennai"))
			{
				deliveryCharge=400;
			}
			else if(deliveryArea.equals("Delhi"))
			{
				deliveryCharge=200;
			}
			else if(deliveryArea.equals("Mumbai"))
			{
				deliveryCharge=700;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return deliveryCharge;
	}
}
