package com.neusoft.elm.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class DBUtil
{
	private static final String URL="jdbc:mysql://localhost:3306/elm_admin?characterEncoding=utf-8&useSSL=false";
	private static final String DRIVER="com.mysql.jdbc.Driver";
	private static final String USERNAME="root";
	private static final String PASSWORD="fl264065";
	
	public static Connection getConnection()
	{
		Connection con=null;
		
		try
		{
			Class.forName(DRIVER);
			con=DriverManager.getConnection(URL,USERNAME,PASSWORD);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static void Close(ResultSet rs,PreparedStatement pst,Connection con)
	{
		if(rs!=null)
		{
			try
			{
				rs.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			rs=null;
		}
		
		if(pst!=null)
		{
			try
			{
				pst.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			pst=null;
		}
		
		if(con!=null)
		{
			try
			{
				con.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			con=null;
		}
	}
}
