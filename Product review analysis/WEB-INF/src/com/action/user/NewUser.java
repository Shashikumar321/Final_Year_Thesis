
package com.action.user;

import javax.servlet.RequestDispatcher;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.dao.UserDAO;



public class NewUser extends HttpServlet
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)
	{
		try
		{
			
			
			String userid=request.getParameter("userid");
			String pass=request.getParameter("password");
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			String phoneno=request.getParameter("phoneno");
			
			String Message="Your UserId:"+userid+"and Password:"+pass;
			String identy_tocken="";
			String fnm="";
			System.out.println("userid:"+userid+"pass:"+pass+"name:"+name+"email:"+email+"phoneno"+phoneno);
			boolean checkNewUser=UserDAO.checkUserID(userid);
			if(checkNewUser)
			{
				response.sendRedirect(request.getContextPath()+"/AllFiles/JSP/User/newuser.jsp?no=6");
			}
			else
			{
			
			/*DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy ");
			   //get current date time with Date()
			   Date date = new Date();
			   
			   String doj=dateFormat.format(date);
			   System.out.println(dateFormat.format(date));
			   
			   String value=userid;
			   
			   System.out.println("Input :"+value);
			   
			//   HashingTechnique g1 = new HashingTechnique();
				
			  // identy_tocken = g1.MD5(value);
			   
			   String MDKeyFilePath = request.getRealPath("")+"\\Files\\Keys\\MDKey.txt";
			   
			  
			   System.out.println("File Path :"+MDKeyFilePath);
			   FileWriter fstream = new FileWriter(MDKeyFilePath);
				
				BufferedWriter out = new BufferedWriter(fstream);

		        out.write(identy_tocken);
		        out.close();
		        
		        File f = new File(MDKeyFilePath);
		        
		        String fnm = f.getName();*/
				String att=null;
				String fn=null;
		        
		       // boolean sendMailflag=CL_SendMail.sendPersonalizedMail(email, "send.user.details@gmail.com", "dhsinformatics", "User Registration Details",Message,att, "smtp.gmail.com", "465",fn);
			  
		    //    System.out.println("=========MailStatus=========="+sendMailflag);
				//System.out.println("Identity Tocken :"+identy_tocken);
			
						RequestDispatcher rd = null;
						String path = null;
						UserDAO userDao=UserDAO.getInstance();
						
						boolean result=userDao.addUser(userid, pass,name,email,phoneno);
						if(result)
						{
							 String msg="Dear "+name.toUpperCase()+"...... \n\n " +
										"        Your Profile is made Successfully\n\n\n\n" +
												"Your USER ID   :"+userid+"\n"+
												"Your PASSWORD:"+pass+
												"\n\n\n\n\n\n\n\nThank You\n\ninfo@Co_Extract.com\n\n\n";
										CL_SendMail.sendPersonalizedMail(email,"From Co_Extraction", msg,"no");
								rd = request.getRequestDispatcher("index.jsp?no=7");
								rd.forward(request,response);
								
						}
						else
						{
							response.sendRedirect("index.jsp?no=4");
						}
						}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
