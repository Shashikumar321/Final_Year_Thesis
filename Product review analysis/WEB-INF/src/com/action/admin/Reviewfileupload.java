package com.action.admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;











public class Reviewfileupload extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
			{
		String filename2="";
		String fileName =" ";
		String[] name = new String[50];
		int m=0;
		
		File uploadedFile = null;
		ArrayList<String> list = new ArrayList<String>();
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart)
		{
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			try 
			{
				List items = upload.parseRequest(request);
				Iterator iterator = items.iterator();
				while (iterator.hasNext())
				{
					FileItem item = (FileItem) iterator.next();
					if (item.isFormField())
					{
						name[m] = item.getString();
						list.add(name[m]);
						System.out.println("========name======================"+name[m]);
						m++;
						
					} 
					else 
					{
						
						
					     fileName ="E:/shalini_2015workspace/Co_Extracting_manu/Files/Upload/"+item.getName();
					    System.out.println("((((((((((((((((())))))))))))))))))))))))))))))))))"+fileName);
					    
					    File file=new File(fileName);
					  filename2=file.getName();
						System.out.println("fileName========================:"+filename2);

						OutputStream outputStream = new FileOutputStream(fileName);
						InputStream inputStream = item.getInputStream();

						int readBytes = 0;
						byte[] buffer = new byte[10000];
						while ((readBytes = inputStream.read(buffer, 0, 10000)) != -1)
						{
							outputStream.write(buffer, 0, readBytes);
						}
						outputStream.close();
						inputStream.close();

						
						
						
						
						
						
						
						
						
						
						
					}
					    
				}    
				
				
				String data1 = ReadFile.readfile(fileName);
				System.out.println("@@@@ Readed data :====>"+data1);
				
				String data3=data1.toLowerCase();
				System.out.println("**Lower case Covert File :***\n"+data3);
				
				FileWriter fooWriter = new FileWriter(fileName, false); // true to append  & false to overwrite.					                                                
				fooWriter.write(data3);
				fooWriter.close();		
				String data2=Program.filterwords(data3);
				
				System.out.println("**Remove Covert File :***\n"+data2);
				FileWriter foWriter = new FileWriter(fileName, false); // true to append
			    // false to overwrite.
			     foWriter.write(data2);
			     foWriter.close();
				
			    int id= AdminDAO.insertFile(filename2);
			    System.out.println("+++++++++++++++++++++++++++++++ID+++++++++++++++++++"+id);
			  
			  
			  
					String dat = TextSearch.text_Search(fileName);
					
					 System.out.println("List Of words :"+dat);
					 
					 ArrayList key_data = TextSearch.text_filter(dat);
					   
					   System.out.println("filtered_data :"+key_data);

					   for(int i=0;i<key_data.size();i++)
					   {
						   
						   boolean f1=AdminDAO.checkNoun(key_data.get(i).toString());
						   boolean f2=AdminDAO.checkAdjective(key_data.get(i).toString());
						   boolean f3=AdminDAO.checkSpecial(key_data.get(i).toString());
						   if(f1==true)
						   {
							   
							   System.out.println("In Noun>>"+key_data.get(i).toString());
							   AdminDAO.insertNoun(id,key_data.get(i).toString());
							    
						   }
						   else if(f2==true)
						   {
							   System.out.println("In Adjective>>"+key_data.get(i).toString());
							   AdminDAO.insertAdject(id,key_data.get(i).toString());
							   
						   }
						   else if(f3=true)
						   {
							   System.out.println("In Special>>"+key_data.get(i).toString());
							   AdminDAO.insertSpecial(id,key_data.get(i).toString());
						   }
						 
					   }
				
				
				
					   int k=AdminDAO.getFileno(filename2);
					   ArrayList<String> wordslist = new ArrayList<String>();
					   ArrayList<String> typelist = new ArrayList<String>();
					   ResultSet rs=AdminDAO.getworddiscription(k);
					   while(rs.next())
					   {
						   wordslist.add(rs.getString(3));
						  // System.out.println("wordlist is "+wordslist);
						   typelist.add(rs.getString(4));
						  // System.out.println("wordlist is "+typelist);
					   }
					   
					   System.out.println(" word list :"+wordslist+" type list :"+typelist);
					   
					   System.out.println("==========================================");
					   for(int i=0;i<wordslist.size();i++)
					   {
						  
						
							
					 
							//System.out.println("condition value :"+i+1+" "+wordslist.size());
						   if(i+1<wordslist.size())
						   {
							 if(typelist.get(i).equals("noun")&&typelist.get(i+1).equals("adjective"))
							 {
								 System.out.println(" noun adjective "+wordslist.get(i)+" "+wordslist.get(i+1));
								 System.out.println("========================");
								
								 int rankval=AdminDAO.getRankValue(wordslist.get(i+1));
								 System.out.println("rank value :"+rankval);
								 boolean flag=AdminDAO.insertWordVal(wordslist.get(i), rankval, wordslist.get(i+1));
								 
								 if(i+1<wordslist.size())
								{
									 i=i+1; 
								}
								
							 }
							 else if(typelist.get(i).equals("adjective")&&typelist.get(i+1).equals("noun"))
							 {
								 int rankval=AdminDAO.getRankValue(wordslist.get(i));
								 System.out.println("rank value :"+rankval);
								 boolean flag=AdminDAO.insertWordVal(wordslist.get(i), rankval, wordslist.get(i+1));
								 
								 System.out.println(" adjective noun "+wordslist.get(i)+" "+wordslist.get(i+1));
								 System.out.println("========================");
								 if(i+1<wordslist.size())
									{
										 i=i+1; 
									}
							 }
							 else if(typelist.get(i).equals("noun")&&typelist.get(i+1).equals("noun"))
							 {
								 System.out.println(" noun noun "+wordslist.get(i)+" "+wordslist.get(i+1));
							 }
							 else if(typelist.get(i).equals("adjective")&&typelist.get(i+1).equals("adjective"))
							 {
								 System.out.println(" adjective adjective "+wordslist.get(i)+" "+wordslist.get(i+1));
							 }
							 else if(typelist.get(i).equals("special"))
							 {
								 System.out.println("========================");
								 System.out.println(" Special "+wordslist.get(i));
								 
										// i=i+1; 
								 
								 boolean flag=AdminDAO.insertSpecial(wordslist.get(i));
									
							 }
							
							 
						   }else if(i+1==wordslist.size())
						   {
							  // System.out.println("its came to else block");
							   if(typelist.get(i).equals("noun"))
								 {
									 System.out.println(" noun  "+wordslist.get(i));
									
								 }
								 else if(typelist.get(i).equals("adjective"))
								 {
									 System.out.println(" adjective "+wordslist.get(i));
									
								 }
								 else if(typelist.get(i).equals("special"))
								 {
									 System.out.println(" Special "+wordslist.get(i));
									 boolean flag=AdminDAO.insertSpecial(wordslist.get(i));
									
								 }
							   
						   }
						   
							 
							 
						
					
					   		   
						   }
							   
				
			
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
					    
			}	    
					    
		
				 catch(Exception e)
					{
						e.printStackTrace();
					}
			
			
			
		
			}



			}
}
