package com.action.admin;

/**
 * 
 */


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import opennlp.tools.cmdline.parser.ParserTool;
import opennlp.tools.parser.Parse;
import opennlp.tools.parser.Parser;
import opennlp.tools.parser.ParserFactory;
import opennlp.tools.parser.ParserModel;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.util.HashSet;
import java.util.Set;

import opennlp.tools.cmdline.parser.ParserTool;
import opennlp.tools.parser.Parse;
import opennlp.tools.parser.Parser;
import opennlp.tools.parser.ParserFactory;
import opennlp.tools.parser.ParserModel;
import sun.reflect.generics.tree.Tree;

import java.util.Iterator;

import com.dao.AdminDAO;



/**
 * @author Munna Kumar Singh
 * 15, 2013 4:57:16 PM
 *Project:-DNA
 *Package:-com.nitin.action.user
 *File:-Download.java
 */
public class Extract extends HttpServlet
{
	
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException
	{
		ResultSet rs = null; 
		String id = "";
		String proid = "";
		  int userid = 0;
		  int cloudId = 0;
		  int uploadId=0;
		  String fileName="";
		  String fileType="";
		  String uId="";
		
		  StringBuffer msgDigestsb=new StringBuffer();
		  boolean flag1=false;
		  boolean flag2=false;
		  boolean flag3=false;
		  boolean flag4=false;
		  
		  ArrayList list = null;
		  
		  String integrityStatus="";
		  
		  String downloadDir = "";
		  String downloadDir1 = "";
		  String downloadDir2 = "";
		  String downloadDir3 = "";
		  
		 // UserDAO userDAO = UserDAO.getInstance();
		  
		  RequestDispatcher rd=null;
		  
		  StringBuffer sb = null;
		  
		  HttpSession session = req.getSession();  
		  id = (String) req.getParameter("id");
		  proid = (String) req.getParameter("proid");
		 // fileType = (String) req.getParameter("ftype");
		  //uId = req.getParameter("uid");
		//  uploadId = Integer.parseInt(uId);
		  
		 // System.out.println("--------========UPLOADED ID IN DOWNLOAD SERVLET++================="+uploadId);
		 
		//  int uploaded_cloud_no=userDAO.getNoCloud(uploadId);
		  
		  //System.out.println("--------========UPLOADED NO OF CLOUD+++================="+uploaded_cloud_no);
		  
	       if ( session.getAttribute( "waitPage" ) == null ) 
	       {  
	    	   session.setAttribute( "waitPage", Boolean.TRUE );  
	    	   PrintWriter out = res.getWriter();  
	    	   out.println( "<html><head>" );  
	    	   out.println( "<title>Please Wait...</title>" );  
	       	   out.println( "<meta http-equiv=\"Refresh\" content=\"0\">" );  
	    	   out.println( "</head><body bgcolor='#CCCCFF'>" );  
	    	   out.println( "<br><br><br>" );
	    	   out.print( "<center><img src='AllFiles/Images/status_processing.gif'></img><br><br>");
	    	   out.print("<font color='red'>");
	    	   out.println( "Please Do not press Back or Refresh button.......<br>  " );
	    	   out.println("</font>");
	    	   out.println( "Your Extracting process is in progress......  " );
	    	   out.println( "Please wait....</h1></center");  
	    	   out.close();  
	       }  
	       else 
	       { 
	    	   session.removeAttribute( "waitPage" );  
			try
			{
				AdminDAO adminDAO = AdminDAO.getInstance();
				String review=adminDAO.getReview_toadmin();
				System.out.println("==============REVIEW IN EXTRACT SERVLET================"+review);
				
				/*  String filtered_data = text_filter(review);
				  System.out.println("====Filtered DATA======="+filtered_data);
			*/
				
				
		        String[] strs = review.split("~");
		        String ss=null;
		       
		        for (String sstr : strs) 
		        {
		        	StringBuffer sbb=new StringBuffer();
		        	
		        	System.out.println(sstr);
		        	 String[] strs1=sstr.split(" ");
		        	for(String sstr1 :strs1)
		        	{
		        		
		        		System.out.println(sstr1);
		        		boolean flag=AdminDAO.check(sstr1);
		        	
		        		
		        		
		        		//boolean flag7=adminDAO.checkAdj(sstr1);
		        		if(!flag)
		        		{
		        			
		        			sbb.append(sstr1);
		        			sbb.append(" ");
		        			
		        		}
		        		/*if(sstr1.equals("and"))
		        		{
		        			sbb.append("//");
		        		
		        		}
		        		if(flag7)
		        		{
		        			sbb.append("/");
		        			sbb.append(sstr1);
		        			sbb.append("/");
		        		}*/
		        	
		        	}
		        	
		        	 ss=sbb.toString();
		        	 
		        	 
		        	
		        	
		        	
		        /*	
		        	ParserTest pt=new ParserTest();
		        	pt.parserAction(ss,path);*/
		        	
		        	/* String[] strs2=ss.split("~");
		        	 for(String sstr1 :strs2)
			        	{
		        		 System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+sstr1);
			        	}*/
		        }
		        
		       
		        
		       
		        
		       /* MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
	        	System.out.println( "++++++++++++++++++++++++++++++++++++++++++++++++++++++"+memoryBean.getHeapMemoryUsage() );*/
	        
        	System.out.println("===============FILTERED====================="+ss);
        	
        	/*String path=req.getRealPath("")+"\\en-parser-chunking.bin";
        	
        	InputStream is = new FileInputStream(path);
    	    ParserModel model = new ParserModel(is);
    	    Parser parser = ParserFactory.create(model);
    	    Parse topParses[] = ParserTool.parseLine(ss, parser, 1);
    	    for (Parse p : topParses)
    	    {
    	    	//p.show();
    	    	ParserTest.getNounPhrases(p);
    	    }
    	   ParserTest.show();*/
        	
        	StringBuffer sbb1=new StringBuffer();
        	StringBuffer sbb2=new StringBuffer();
        	StringBuffer sbb3=new StringBuffer();
        	 String[] strs3=ss.split(" ");
	        	for(String sstr1 :strs3)
	        	{
	        		
	        		
	        		
	        		System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\"+sstr1);
	        		boolean flag=AdminDAO.check_noun(sstr1);
	        		boolean flag11=AdminDAO.check_adjective(sstr1);
	        		
	        		
	        		
	        		//boolean flag7=adminDAO.checkAdj(sstr1);
	        		if(flag)
	        		{
	        		 sbb1.append(sstr1);
	        		 sbb1.append(" ");	
	        		}
	        		
	        		if(flag11)
	        		{
	        		 sbb2.append(sstr1);
	        		 sbb2.append(" ");	
	        		}
	        	}
				/*String path=req.getRealPath("")+"\\en-parser-chunking.bin";
	        	ParserTest.parserAction(ss,path);*/
        	
        	
        	/*String path=req.getRealPath("")+"\\en-parser-chunking.bin";
        	 String URL="http://localhost:8080/OpenNLP/NewParser";
        	 res.sendRedirect(URL);*/
				
				/*
			
				PrintWriter out=res.getWriter();
				res.setContentType("text/html");
				
				boolean flag = false;
				
				String ftpserver = "dhsinformatics.com";
		        String ftpusername = "dhsinf17";
		        String ftppassword = "nikisujai";
		        
		        list = userDAO.getCloudIDByUploadId(uploadId);
		        sb = new StringBuffer();
		        String  uploadMsgDigest = userDAO.getUploadMsgDigest(fileName);
		        
		        cloud1Status = userDAO.getCloudStatus(CLOUD1);
				cloud2Status = userDAO.getCloudStatus(CLOUD2);
				cloud3Status = userDAO.getCloudStatus(CLOUD3);
				cloud4Status = userDAO.getCloudStatus(CLOUD4);
				
				
				String ftpserver =    Utility.getPro("server1");
		        String ftpusername1 = Utility.getPro("user1");
		        String ftppassword1 = Utility.getPro("pass1");
		        
		        
		        System.out.println("+++++++++++++++++++++++++++++++++++++USERNAME1+++++++++++++++++++========="+ftpusername1);
		        System.out.println("+++++++++++++++++++++++++++++++++++++PASSWORD1+++++++++++++++++++========="+ftppassword1);
		        
		        String ftpusername2 = Utility.getPro("user2");
		        String ftppassword2 = Utility.getPro("pass2");
		        
		        System.out.println("+++++++++++++++++++++++++++++++++++++USERNAME2+++++++++++++++++++========="+ftpusername2);
		        System.out.println("+++++++++++++++++++++++++++++++++++++PASSWORD2+++++++++++++++++++========="+ftppassword2);
		        
		        String ftpusername3 = Utility.getPro("user3");
		        String ftppassword3 = Utility.getPro("pass3");
		        
		        System.out.println("+++++++++++++++++++++++++++++++++++++USERNAME3+++++++++++++++++++========="+ftpusername3);
		        System.out.println("+++++++++++++++++++++++++++++++++++++PASSWORD3+++++++++++++++++++========="+ftppassword3);
		        
		        String ftpusername4 = Utility.getPro("user4");
		        String ftppassword4 = Utility.getPro("pass4");
		        
		        System.out.println("+++++++++++++++++++++++++++++++++++++USERNAME4+++++++++++++++++++========="+ftpusername4);
		        System.out.println("+++++++++++++++++++++++++++++++++++++PASSWORD4+++++++++++++++++++========="+ftppassword4);
				
				 getting clouds status (Starts)
				
						if(cloud1Status.equals("Inactive"))
						{
							inActiveStatus = "cloud1";
							sb.append(inActiveStatus + ",");
						}
						if(cloud2Status.equals("Inactive"))
						{
							inActiveStatus = "cloud2";
							sb.append(inActiveStatus + ",");
						}
						if(cloud3Status.equals("Inactive"))
						{
							inActiveStatus = "cloud3";
							sb.append(inActiveStatus + ",");
						}
						if(cloud4Status.equals("Inactive"))
						{
							inActiveStatus = "cloud4";
							sb.append(inActiveStatus + ",");
						}
				
				 getting clouds status (Ends)
				
				boolean chk = true;
				
				if(chk)
				{
					for(int i=0;i<list.size();i++)
					{
						//int id = Integer.parseInt(list.get(i).toString());
					
				      
						
						 if(cloud1Status.equals("Active") &&  chk == true)
			        		{
					        	 downloadDir = "cloud1";
					        	 cloudId = 1;
					        	 flag = FileDownload.download(ftpserver, ftpusername1, ftppassword1, username, downloadDir, fileName,fileType,uploadId,cloudId);
					        	 chk = false;
					        	 
					        	 System.out.println(" ^^^^^^^^ File Downloaded From Cloud1. ^^^^^^^^.");
			        		}
					        else if(cloud2Status.equals("Active")  && chk == true)
			        		{
					        	 downloadDir = "cloud2";
					        	 cloudId = 2;
					        	 flag = FileDownload.download(ftpserver, ftpusername2, ftppassword2, username, downloadDir, fileName,fileType,uploadId,cloudId);
					        	 chk = false;
					        	 System.out.println(" ^^^^^^^^ File Downloaded From Cloud2. ^^^^^^^^.");
			        		}
					        else if(cloud3Status.equals("Active")  && chk == true)
			        		{
					        	 downloadDir = "cloud3";
					        	 cloudId = 3;
					        	 flag = FileDownload.download(ftpserver, ftpusername3, ftppassword3, username, downloadDir, fileName,fileType,uploadId,cloudId);
					        	 chk = false;
					        	 System.out.println(" ^^^^^^^^ File Downloaded From Cloud3. ^^^^^^^^.");
			        		}
					        else if(cloud4Status.equals("Active")  && chk == true)
			        		{
					        	 downloadDir = "cloud4";
					        	 cloudId = 4;
					        	 flag = FileDownload.download(ftpserver, ftpusername4, ftppassword4, username, downloadDir, fileName,fileType,uploadId,cloudId);
					        	 chk = false;
					        	 System.out.println(" ^^^^^^^^ File Downloaded From Cloud4. ^^^^^^^^.");
			        		}
					       
					
						if(cloud1Status.equals("Active") && (uploaded_cloud_no==1) && chk == true)
		        		{
				        	 downloadDir = "cloud1";
				        	
				        	 cloudId = 1;
				        	 flag = FileDownload.download(ftpserver, ftpusername1, ftppassword1, username, downloadDir, fileName,fileType,uploadId,cloudId);
				        	 chk = false;
				        	 File file = new File("E:\\"+fileName);
				        	 msgDigest=(Utility.MD(file));
				        
				 		    if(uploadMsgDigest.equals( msgDigest))
				 		    {
				 		    	flag1=true;
				 		    }
				        	 file.delete();
				        	 System.out.println(" ^^^^^^^^ File Downloaded From Cloud1. ^^^^^^^^.");
		        		}
				        else if(cloud2Status.equals("Active") && (uploaded_cloud_no==2) && chk == true)
		        		{    
				        	 downloadDir = "cloud1";
				        	 downloadDir1 = "cloud2";
				        	 cloudId = 2;
				        	
				        	 flag = FileDownload.download(ftpserver, ftpusername1, ftppassword1, username, downloadDir, fileName,fileType,uploadId,cloudId);
				        	 chk = false;
				        	 File file = new File("E:\\"+fileName);
				        	 msgDigest=(Utility.MD(file));
					        	
					 		    if(uploadMsgDigest.equals( msgDigest))
					 		    {
					 		    	flag1=true;
					 		    }
				        	 file.delete();
				        	 
				        	 flag = FileDownload.download(ftpserver, ftpusername2, ftppassword2, username, downloadDir1, fileName,fileType,uploadId,cloudId);
				        	 File file1 = new File("E:\\"+fileName);
				        	 msgDigest=(Utility.MD(file1));
					        	 
					 		    if(uploadMsgDigest.equals( msgDigest))
					 		    {
					 		    	flag2=true;
					 		    }
					 		   file1.delete();
				        	 chk = false;
				        	 System.out.println(" ^^^^^^^^ File Downloaded From Cloud2. ^^^^^^^^.");
		        		}
				        else if(cloud3Status.equals("Active") && (uploaded_cloud_no==3) && chk == true)
		        		{
				        	 downloadDir = "cloud1";
				        	 downloadDir1 = "cloud2"; 
				        	downloadDir2 = "cloud3";
				        	 cloudId = 3;
				        	 
				        	 flag = FileDownload.download(ftpserver, ftpusername1, ftppassword1, username, downloadDir, fileName,fileType,uploadId,cloudId);
				        	 chk = false;
				        	 File file = new File("E:\\"+fileName);
				        	 msgDigest=(Utility.MD(file));
				        	 
					 		    if(uploadMsgDigest.equals( msgDigest))
					 		    {
					 		    	flag1=true;
					 		    }
					 		  	 file.delete();
				        	 
				        	 flag = FileDownload.download(ftpserver, ftpusername2, ftppassword2, username, downloadDir1, fileName,fileType,uploadId,cloudId);
				        	 File file1 = new File("E:\\"+fileName);
				        	  msgDigest=(Utility.MD(file1));
				        	  if(uploadMsgDigest.equals( msgDigest))
					 		    {
					 		    	flag2=true;
					 		    }
					 		  	file1.delete();
				        	 
				        	 
				        	 flag = FileDownload.download(ftpserver, ftpusername3, ftppassword3, username, downloadDir2, fileName,fileType,uploadId,cloudId);
				        	 File file2 = new File("E:\\"+fileName);
				        	
				        	 msgDigest=(Utility.MD(file2));
				        	 
				        	 if(uploadMsgDigest.equals( msgDigest))
					 		    {
					 		    	flag3=true;
					 		    }
				        	 file2.delete();
				        	 chk = false;
				        	 System.out.println(" ^^^^^^^^ File Downloaded From Cloud3. ^^^^^^^^.");
		        		}
				        else if(cloud4Status.equals("Active") && (uploaded_cloud_no==4) && chk == true)
		        		{
				        	downloadDir = "cloud1";
				        	 downloadDir1 = "cloud2"; 
				        	downloadDir2 = "cloud3"; 
				        	downloadDir3= "cloud4";
				        	 cloudId = 4;
				        	 
				        	 flag = FileDownload.download(ftpserver, ftpusername1, ftppassword1, username, downloadDir, fileName,fileType,uploadId,cloudId);
				        	 chk = false;
				        	 File file = new File("E:\\"+fileName);
				        	 msgDigest =(Utility.MD(file));
				        	 if(uploadMsgDigest.equals( msgDigest))
					 		    {
					 		    	flag1=true;
					 		    }
				        	 file.delete();
				        	 
				        	 flag = FileDownload.download(ftpserver, ftpusername2, ftppassword2, username, downloadDir1, fileName,fileType,uploadId,cloudId);
				        	 File file1 = new File("E:\\"+fileName);
				        	 msgDigest =(Utility.MD(file1));
				        	 if(uploadMsgDigest.equals( msgDigest))
					 		    {
					 		    	flag2=true;
					 		    }
				        	 file1.delete();
				        	 
				        	 
				        	 flag = FileDownload.download(ftpserver, ftpusername3, ftppassword3, username, downloadDir2, fileName,fileType,uploadId,cloudId);
				        	 File file2 = new File("E:\\"+fileName);
				        	 msgDigest =(Utility.MD(file2));
				        	 if(uploadMsgDigest.equals( msgDigest))
					 		    {
					 		    	flag3=true;
					 		    }
				        	 file2.delete();
				        	 
				        	 
				        	 
				        	 flag = FileDownload.download(ftpserver, ftpusername4, ftppassword4, username, downloadDir3, fileName,fileType,uploadId,cloudId);
				        	 File file3 = new File("E:\\"+fileName);
				        	 msgDigest =(Utility.MD(file3));
				        	 if(uploadMsgDigest.equals( msgDigest))
					 		    {
					 		    	flag4=true;
					 		    }
				        	 file3.delete();
				        	 chk = false;
				        	 System.out.println(" ^^^^^^^^ File Downloaded From Cloud4. ^^^^^^^^.");
		        		}
				       
			        
					}
					
				}
		       // downloadDir = "cloud1";
		        //cloudId = 1;
				//flag = FileDownload.download(ftpserver, ftpusername1, ftppassword1, username, downloadDir, fileName,fileType,uploadId,cloudId);
				
				 if(flag)
		            {
			            try 
			            {
		                    Adding the download Transaction details (Start)
							
							Calendar currentDate = Calendar.getInstance();
							SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy");
							SimpleDateFormat formatter1=new SimpleDateFormat("HH:mm:ss");
							String date = formatter.format(currentDate.getTime());
							String time = formatter1.format(currentDate.getTime());
							
							UserDAO userDAO = UserDAO.getInstance();
							
							userid = userDAO.getID(username);
							
							
							
							flag = userDAO.addDownloadTransaction(fileName,fileType,date,time,userid, msgDigest,uploadId,cloudId,integrityStatus);
							
			            	File file = new File("D:\\"+fileName);
			            	
			            	String msgDigest = Utility.MD(file);
			            	 uploadMsgDigest = userDAO.getUploadMsgDigest(fileName);
			            	
			            	 //String mmm=msgDigestsb.toString();
			            	
			            	System.out.println("*********** Message Digest Info ******");
			            	System.out.println("\n msg  : "  + msgDigest);
			            	
			            	userid = userDAO.getID(username);
			            	
			            	flag = userDAO.updateDownloadMessageDigest(fileName,msgDigest);
			            	//String dig=userDAO.getDownloadMsgDigest(fileName);
			            	//System.out.println(";;;;;;;;;;;;;;;;DDIGEST;;;;;;;;;;;;;;;;;;;"+dig);
			            	
							if(flag)
							{
								rd=req.getRequestDispatcher("/Resources/JSP/User/download_file.jsp?no=1&fname="+fileName+"&dfrom="+downloadDir+"&ic="+sb.toString()+"");
								rd.forward(req, res);
							}
							else
							{
								rd=req.getRequestDispatcher("/Resources/JSP/User/download_file.jsp?no=3");
								rd.forward(req, res);
							}
						}
			            catch (Exception e)
			            {
							e.printStackTrace();
						}
		            }
				    else
				    {
						rd=req.getRequestDispatcher("/Resources/JSP/User/download_file.jsp?no=3");
						rd.forward(req, res);
					}*/
	        	
		   
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
	
	       
			
	       }
	  }
	
	/*public static String text_filter(String original)
	{
		StringBuffer data = new StringBuffer();
		String[] s = original.split("#");
		
		for(int i=0;i<s.length;i++)
		{
			
			if(s[i].trim()!=null)
			{
				
				String[] word = s[i].split("~");
				
				for(int j=0;j<word.length;j++)
				{
					
					String search = word[j].trim();
					
					boolean f = AdminDAO.check(search);
					
					if(f == true)
					{
						//System.out.println("Unwanted data");
						
					}
					else
					{
						
						data.append(search);
					}
				}
				
			}
			
		}
		String data1=data.toString();
		
		return data1;
		
	}*/
	
	
	
	
	
}

