package com.action.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class  Keyprocessmanagement extends HttpServlet 
{
	public void service(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out=response.getWriter();
		try
		{
			
			System.out.println("its came inside tokEYPROCESS MANAGEMENT>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			
			String submit=request.getParameter("submit");
			String path=request.getRealPath("");
			
			RequestDispatcher rd=null;
			
			rd=request.getRequestDispatcher("/AllFiles/JSP/Admin/users.jsp");
			rd.forward(request,response);
		}
		catch(Exception e)
		{
			System.out.println("Error in GetProfile Servlet................."+e);
			out.println("Error in GetProfile Servlet................."+e);
		}
	}
}
