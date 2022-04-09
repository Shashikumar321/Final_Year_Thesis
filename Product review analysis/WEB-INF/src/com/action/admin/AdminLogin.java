
package com.action.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AdminDAO;





public class AdminLogin extends HttpServlet
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)
	{
		
		try
		{
			String admin=request.getParameter("username");
			
			System.out.println("username is >>>>>>>>>>>"+admin);
			
			String pass=request.getParameter("password");
			System.out.println("password is >>>>>>>>>>>"+pass);
			
			System.out.println(admin+"---"+pass);
			
		
			AdminDAO adminDAO=AdminDAO.getInstance();
			
			boolean result=adminDAO.checkAdmin(admin, pass);
			System.out.println("status :"+result);
			if(result)
			{
				HttpSession session=request.getSession(true);
				boolean newSession=session.isNew();
				System.out.println("In admin Login session is new-->"+newSession);
				session.setAttribute("username",admin);
				
				RequestDispatcher rd=null;
				
				session.setAttribute("admin", admin);
				
				rd=request.getRequestDispatcher("/AllFiles/JSP/Admin/adminhome.jsp");
				rd.forward(request,response);
			}
			else
			{
				response.sendRedirect("index.jsp?no=4");
			}
		}
		catch(Exception e)
		{
			System.out.println("********* Exception In AdminLogin Servlet ********\n");
			e.printStackTrace();
		}
	}
}
