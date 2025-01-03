package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.entity.User;

public class UserDAO {
	
	public int regemp(User us) throws ClassNotFoundException{

		String insert_user="insert into register "+" (fullname,Email,Password) values "+" (?,?,?);";
		int result=0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		try(Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/expensetrack?useSSL=false", "root", "Pass@123");
		PreparedStatement prepstate=conn.prepareStatement(insert_user))
				{
			prepstate.setInt(1, 1);
			prepstate.setString(2,us.getName());
			prepstate.setString(3,us.getEmail());
			prepstate.setString(3, us.getPassword());

			System.out.println(prepstate);
			result=prepstate.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
