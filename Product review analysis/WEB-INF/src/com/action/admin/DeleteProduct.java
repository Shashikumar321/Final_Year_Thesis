package com.action.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class DeleteProduct extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
			{
		
		
		String no=req.getParameter("no");
		int no1=Integer.parseInt(no);
		boolean flag=AdminDAO.deleteProduct(no1);
		RequestDispatcher rd=null;
		
		if(flag)
		{
			rd=req.getRequestDispatcher("/AllFiles/JSP/Admin/product.jsp?no=2");
			rd.forward(req, resp);
		}
	
	
	
}
}
