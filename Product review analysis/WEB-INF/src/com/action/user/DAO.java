/**
 * 
 */
package com.action.user;

import java.sql.Connection;

import java.sql.DriverManager;



public class DAO 
{
	
	public static DAO dao=null;
		public static DAO getInstance()
	{
		dao=new DAO();
			
		//	System.out.println("--------------------------------------------------------------get instance");
		
		return dao;
	}
	public Connection connector()
	{
		Connection con=null;
		try {

			Class.forName(Global.JDBC_DRIVER);
			//System.out.println("--------------------------------------------------------------connector ");
			//System.out.println("Driver has loaded");
			con = DriverManager.getConnection(Global.JDBC_HOST_URL_WITH_DBNAME,Global.DATABASE_USERNAME, Global.DATABASE_PASSWORD);
		//	System.out.println("Connected" + con);

		} catch (Exception e) 
		{
			e.printStackTrace();
			//System.out.println("Exception in serverconnector-->connector(): "+ e);
		}
		return con;
	}
}
