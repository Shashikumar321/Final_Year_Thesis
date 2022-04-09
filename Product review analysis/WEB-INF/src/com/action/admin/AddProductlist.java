package com.action.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdminDAO;

public class AddProductlist extends HttpServlet 
 {
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		String loc=request.getParameter("loc");
       int code=Integer.parseInt(loc); 
		String pname=request.getParameter("pname");
		String paddr=request.getParameter("paddr");
		String pcno=request.getParameter("pcno");
		String no1=request.getParameter("pcnn");
		System.out.println(code);
		System.out.println(pname);
		System.out.println(paddr);
		System.out.println(pcno);
		System.out.println(no1);
		String pname1="";
		String paddr1="";
		String loc1="";
		String pcno1="";
   boolean flag=AdminDAO.addProductDetails( pname, code, paddr, pcno,no1);
   if( flag==true)
   {
	   try {
	   RequestDispatcher rd = request.getRequestDispatcher("/AllFiles/JSP/Admin/product.jsp");
		
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   }
		
	}

}
