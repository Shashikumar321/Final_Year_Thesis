/**
 * 
 */
package com.action.admin;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdminDAO;


/**
 * @author Nitin Gudle
 *Feb 21, 2012 2:49:35 PM
 *Project:-SessionPwd
 *Package:-com.nitin.action.user
 *File:-UpdateProfile.java
 */
public class AddUpdateProfile extends HttpServlet 
{
	public void service(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		RequestDispatcher rd=null;
		PrintWriter out=response.getWriter();
		try
		{
			String path=request.getRealPath("");
			
			String productid=request.getParameter("id");
			String review=request.getParameter("review");
			AdminDAO adminDAO = AdminDAO.getInstance();
			boolean result = adminDAO.AddReview(productid,review);
			
			
			
			
			if(result)
			{
				rd=request.getRequestDispatcher("/AllFiles/JSP/Admin/add.jsp?no=1");
				rd.forward(request,response);
			}
			else
			{
				rd=request.getRequestDispatcher("/AllFiles/JSP/Admin/add.jsp?no=2");
				rd.forward(request,response);
			}
		}
		catch(Exception e)
		{
			System.out.println("Error in UpdateProfile Servlet................."+e);
			out.println("Error in UpdateProfile Servlet................."+e);
		}
	}
}
