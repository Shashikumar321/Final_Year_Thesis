package com.action.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDAO;

public class LoginCheck extends HttpServlet {

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try
		{
			RequestDispatcher rd=null;
			String userid = req.getParameter("username");
			String pass = req.getParameter("password");
			UserDAO userDao=UserDAO.getInstance();
			boolean result=userDao.checkUser(userid, pass);
			if(result)
			{
				HttpSession session=req.getSession(true);
				boolean newSession=session.isNew();
				System.out.println("user login session-->"+newSession);
			
				session.setAttribute("username", userid);
				session.setAttribute("password", pass);
				rd=req.getRequestDispatcher("/AllFiles/JSP/User/select_identytocken.jsp");
				rd.forward(req,resp);
			
			}
			
			else
			{
				resp.sendRedirect(req.getContextPath()+"/index.jsp?no=4");
			}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
}
