/**
 * 
 */
package com.action.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdminDAO;



public class ProductList extends HttpServlet 
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out=response.getWriter();
		ResultSet rs = null;
		RequestDispatcher rd=null;
	String userid="";
		
		try
		{
			String submit=request.getParameter("submit").trim();
			

			String procode=request.getParameter("procode");
			String proname=request.getParameter("proname");
			String catcode=request.getParameter("catcode");
			String prodesc=request.getParameter("prodesc");
			
			String proprice=request.getParameter("proprice");
			String proseller=request.getParameter("proseller");
			
			AdminDAO adminDAO = AdminDAO.getInstance();
			rs = adminDAO.getProductDetails();
			
			if(submit.equals("get"))
			{
				request.setAttribute("rs", rs);
				rd=request.getRequestDispatcher("/AllFiles/JSP/Admin/product.jsp?no=1");
				rd.forward(request, response);
			}
			
			//boolean f = AdminDAO.checkAlreadyExist(userid);

//			if(!f)
//			{
//
//				boolean result=AdminDAO.addUser(procode, proname,catcode,prodesc,proprice,proseller);
//				if(result)
//				{
//						rd = request.getRequestDispatcher("/AllFiles/JSP/Admin/product.jsp?no=1");
//						rd.forward(request,response);
//						
//				}
//					
//			}
//			else
//			{
//				
//				//rd = request.getRequestDispatcher("/AllFiles/JSP/Admin/product.jsp?no=2");
//				//rd.forward(request,response);
//			}
//			
			
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in Admin ServerList Servlet : ");
			e.printStackTrace();
			out.println("Opps's Error is in Admin ServerList Servlet......"+e);
		}
	}
}
