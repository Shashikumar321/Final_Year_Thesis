package com.action.admin;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.RichTextString;

import com.action.user.DAO;








public class AdminDAO
{
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	
	private static AdminDAO daoProcess=null;
	
	public static AdminDAO getInstance()
	{
		if(daoProcess == null)
		{
			daoProcess= new AdminDAO();
		}
		return daoProcess;
	}
	

	
	public static boolean check(String wor)
	{
		boolean flg = false;
		try
		{
			
			System.out.println("--------------------------------------------------------------");
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		   String sql = "select *from m_unnes where f_word='"+wor+"'";
		
		//System.out.println(sql);
		resultSet = statement.executeQuery(sql);
		
		while(resultSet.next())
		{
			flg = true;
		}
		//System.out.println("Search status:"+flg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Execption:"+e.toString());
		}
		return flg;
	}

	public static int gettotal(String fname)
	{
		int total=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "select weightage from t_count where f_no=(select f_no from m_file where f_name='"+fname+"')";
		
		//System.out.println(sql);
		resultSet = statement.executeQuery(sql);
		
		while(resultSet.next())
		{
			total=total+resultSet.getInt(1);
		}
		System.out.println("Total:"+total);
		
				
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return total;
	}

	public static ResultSet getKeyword_Weight()
	{
		
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "select a.t_no,b.f_name,a.key_word,a.weightage,a.key_rank from t_count a,m_file b";
		
		//System.out.println(sql);
		resultSet = statement.executeQuery(sql);
		
		
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return resultSet;
	}

	public static boolean deleteProduct(int no) 
	{
		boolean flag=false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			Statement stmt = connection.createStatement();
			String sql="delete from m_product where pro_code='"+no+"'";
			int i = stmt.executeUpdate(sql);
			if(i>0)
			{
				flag=true;
			}
			System.out.println("Admin Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO.loginCHK()....."+e);
		}
		return flag;
	}
	
	public static int getFile_total(String fname)
	{
		int total=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "select total from m_file where f_name='"+fname+"'";
		
		//System.out.println(sql);
		resultSet = statement.executeQuery(sql);
		
		while(resultSet.next())
		{
			total=resultSet.getInt(1);
		}
		System.out.println("Total:"+total);
		
				
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return total;
	}
	// taking s_no of the grades
	
	public static ResultSet getUserdetails(int sno)
	{
		//ArrayList list = new ArrayList();
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select u_id,u_email,u_pass,grade from m_user where grade='"+sno+"' ";
			
			resultSet = statement.executeQuery(sql);
			System.out.println("Retrieving Process Completed......");
			
			//connection.close();
			//statement.close();
			//resultSet.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return resultSet;
	}
	
	public static ResultSet getUserdetails1()
	{
		//ArrayList list = new ArrayList();
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select u_id,u_email,u_pass,grade,status from m_user ";
			
			resultSet = statement.executeQuery(sql);
			System.out.println("Retrieving Process Completed......");
			
			//connection.close();
			//statement.close();
			//resultSet.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return resultSet;
	}
	
	
	public static int gets_no(String s_no)
	{
		int s_num=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select s_no from m_grade where hash_key='"+s_no+"' ";
		
		System.out.println(sql);
		resultSet = statement.executeQuery(sql);
		
		while(resultSet.next())
		{
			 s_num=resultSet.getInt(1);
		}
		System.out.println("s_no:"+s_no);
		
				
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return s_num;
	}
	public static boolean insertHashcode(String code,String filecode,String keyno,String rank)
	{
		boolean flag=false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			int k = statement.executeUpdate("insert into m_hashtable (key_word, fileno,key_no,rank_val) value ('"+code+"','"+filecode+"','"+keyno+"','"+rank+"')");
			if(k>0)
			{
				flag=true;
			}
			System.out.println("Hash Key Insert Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminrDAO-->insert Hashkey: "+ e);
		}
		return flag;
	}
	
	public static ResultSet keyNo(String keyword,String filecode)
	{
		int k=0;
		boolean flag=false;
		ResultSet rs=null;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
			rs = statement.executeQuery("select t_no,key_rank from t_count where f_no='"+filecode+"' and key_word='"+keyword+"'");
			
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminrDAO-->insert Hashkey: "+ e);
		}
		return rs;
	}
	
	
	
	
	
	public static ResultSet getGrade()
	{
		
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "select * from m_grade";
		
		//System.out.println(sql);
		resultSet = statement.executeQuery(sql);
		
		
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return resultSet;
	}
	
	public static int getFileno(String fname)
	{
		int total=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "select f_no from m_transaction where f_name='"+fname+"'";
		
		//System.out.println(sql);
		resultSet = statement.executeQuery(sql);
		
		while(resultSet.next())
		{
			total=resultSet.getInt(1);
		}
		System.out.println("file NO:"+total);
		
				
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return total;
	}

	
	public static int getRankValue(String word)
	{
		int total=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "select adj_mark from m_adjective where adj_word='"+word+"'";
		
		System.out.println(sql);
		resultSet = statement.executeQuery(sql);
		
		while(resultSet.next())
		{
			total=resultSet.getInt(1);
		}
		System.out.println("file NO:"+total);
		
				
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return total;
	}
	
	public static boolean updatetotal(String fname,int tot)
	{
		boolean flg = false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "update m_file set total='"+tot+"' where f_name='"+fname+"'";
		
		//System.out.println(sql);
		 statement.executeUpdate(sql);
		
		 flg=true;
		System.out.println("STatus:"+flg);
		
				
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return flg;
	}


public static boolean count_word(String wor,int count,String fname)
{
	boolean flg = false;
	try
	{
		DAO dao=DAO.getInstance();
		connection=dao.connector();
		statement = connection.createStatement();
	String sql = "insert into t_count(f_no,key_word,weightage) values((select f_no from m_file where f_name='"+fname+"'),'"+wor+"','"+count+"')";
	
	//System.out.println(sql);
	statement.executeUpdate(sql);
	flg=true;
	System.out.println("Search status:"+flg);
	}
	catch(Exception e)
	{
		
		System.out.println("Execption:"+e.toString());
	}
	return flg;
}

public static ArrayList getkey_word(String fname)
{
	ArrayList list = new ArrayList();
	try
	{
		DAO dao=DAO.getInstance();
		connection=dao.connector();
		statement = connection.createStatement();
	String sql = "select *from t_count where f_no=(select f_no from m_file where f_name='"+fname+"')";
	
	
	resultSet = statement.executeQuery(sql);
	
	while(resultSet.next())
	{
		
		list.add(resultSet.getString(3)+"@"+resultSet.getString(4));
		
	}
	
	}
	catch(Exception e)
	{
		
		System.out.println("Execption:"+e.toString());
	}
	return list;
}

public static boolean update_rank(String keyword,String fname,String rank)
{
	boolean flg =false;
	
	try
	{
		DAO dao=DAO.getInstance();
		connection=dao.connector();
		statement = connection.createStatement();
	String sql = "update t_count set key_rank='"+rank+"' where f_no=(select f_no from m_file where f_name='"+fname+"') and key_word='"+keyword+"'";
	
	
	int i=statement.executeUpdate(sql);
	
	if(i!=0)
	{
		flg=true;
	}
	
	}
	catch(Exception e)
	{
		
		System.out.println("Execption:"+e.toString());
	}
	return flg;
}

	public static boolean checkAdmin(String name,String pwd)
	{
		boolean flg = false;
		try
		{
			DAO dao=DAO.getInstance();
			
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select *from m_admin where admin_id = '"+name+"' and admin_password = '"+pwd+"' ";
			
			resultSet = statement.executeQuery(sql);
			 while(resultSet.next())
			 {
				 flg=true; 
			 }
			connection.close();
			statement.close();
			resultSet.close();
		}
		catch(Exception e)
		{
			//System.out.println("Exception in --> "+ e);
		}
		return flg;
	}
	
	public static boolean upload1(String filename, String keyword) 
	{
		boolean flag=false;
		try
		{
			DAO database=DAO.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			statement.executeUpdate("insert into m_file (f_name,key_word) values('"+filename+"','"+keyword+"')");
			
			flag=true;
			
			System.out.println("File Insertion Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-uploadS()....."+e);
		}
		return flag;
	}
	
	
	public static ResultSet selectCloud() 
	{
		try
		{
			DAO database=DAO.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_cloud");
			//resultSet = statement.executeQuery("select a.gm_code,b.g_name,a.gm_loginid,a.gm_pwd,a.gm_name from m_groupmanager a join m_group b on a.g_code=b.g_code");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-getUsers()....."+e);
		}
		return resultSet;
	}
	
	
	public static boolean updateCloud(int code,String url,String name,String pass) 
	{
		boolean flag=false;
		try
		{
			DAO database=DAO.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			int i=statement.executeUpdate("update m_cloud set c_url='"+url+"',c_uname='"+name+"',c_pwd='"+pass+"' where c_code='"+code+"'");
			
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin User Edit Profile Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-editUser()....."+e);
		}
		return flag;
	}
	
	
	
	public static ResultSet getProfile(String name)
	{
		try
		{
			DAO database=DAO.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			String sql = "select * from m_admin where admin_id='"+name+"'";
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-getProfile()....."+e);
		}
		return resultSet;
	}
	public static boolean editProfile(String [] s) 
	{
		boolean flag=false;
		try
		{
			DAO database=DAO.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			int i=statement.executeUpdate("update m_admin set name='"+s[1]+"',admin_id='"+s[2]+"',email='"+s[3]+"',phone='"+s[4]+"' where id='"+s[0]+"'");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin Edit Profile Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-editProfile()....."+e);
		}
		return flag;
	}
	public static ResultSet getGroup()
	{
		ArrayList list = new ArrayList();
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select g_code,g_name from m_group ";
			
			resultSet = statement.executeQuery(sql);
			
			
			 
			System.out.println("Retrieving Process Completed......");
			
			//connection.close();
			//statement.close();
			//resultSet.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return resultSet;
	}
	
	public static ResultSet viewGroup_manager()
	{
		
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			//String sql = "select gm_code,g_code,gm_loginid,gm_pwd,gm_name from m_groupmanager ";
			
			String sql = "select a.gm_code,b.g_name,a.gm_loginid,a.gm_pwd,a.gm_name from m_groupmanager a join m_group b on a.g_code=b.g_code";
			
			resultSet = statement.executeQuery(sql);
			
			System.out.println("Retrieving Process Completed......");
			
			//connection.close();
			//statement.close();
			//resultSet.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return resultSet;
	}
	
	public static ResultSet selectGroupCode()
	{
		ArrayList list = new ArrayList();
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select g_code,g_name from m_group where g_code not in (select g_code from m_groupmanager)";
			
			resultSet = statement.executeQuery(sql);
			
			
			 
			System.out.println("Retrieving Process Completed......");
			
			//connection.close();
			//statement.close();
			//resultSet.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return resultSet;
	}
	public static ResultSet selectGroupCode1()
	{
		ArrayList list = new ArrayList();
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select g_code,g_name from m_group";
			
			resultSet = statement.executeQuery(sql);
			
			
			 
			System.out.println("Retrieving Process Completed......");
			
			//connection.close();
			//statement.close();
			//resultSet.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return resultSet;
	}
	
	public static boolean insertgroup_mnger(String gcode,String gmlogin,String pwd,String gmname)
	{
		boolean flag=false;
	try
	{
		
		DAO dao=DAO.getInstance();
		connection=dao.connector();
		statement = connection.createStatement();
		String sqlquery="insert into m_groupmanager(g_code,gm_loginid,gm_pwd,gm_name) values('"+gcode+"','"+gmlogin+"','"+pwd+"','"+gmname+"')" ;
		System.out.println(sqlquery);
		statement.executeUpdate(sqlquery);	
		flag = true;
	}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return flag;
	}
	
	public static ResultSet getCloud()
	{
		
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select c_code,c_url,c_uname,c_pwd from m_cloud ";
			
			resultSet = statement.executeQuery(sql);
			
			 
			System.out.println("Retrieving Process Completed......");
			
			//connection.close();
			//statement.close();
			//resultSet.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return resultSet;
	}
	
	
	public static boolean loginCHK1(String name, String pass) 
	{
		boolean flag=false;
		try
		{
			DAO database=DAO.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_admin where adminid='"+name+"' and password='"+pass+"'");
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("Admin Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO.loginCHK()....."+e);
		}
		return flag;
	}
	public static boolean ChangePass1(String name,String pwd)
	{
		
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "update m_admin set password = '"+pwd+"' where adminid = '"+name+"' ";
			
		 statement.executeUpdate(sql);
			
			
			 
			System.out.println("Password Updated Successfully......");
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return true;
		
	}
	
	public static boolean loginCHK(String name, String pass) 
	{
		boolean flag=false;
		try
		{
			DAO database=DAO.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_admin where admin_id='"+name+"' and admin_password='"+pass+"'");
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("Admin Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO.loginCHK()....."+e);
		}
		return flag;
	}
	
	public static boolean ChangePass(String name,String pwd)
	{
		
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "update m_admin set admin_password = '"+pwd+"' where admin_id = '"+name+"' ";
			
		 statement.executeUpdate(sql);
			
			
			 
			System.out.println("Password Updated Successfully......");
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return true;
		
	}
	
	public static ResultSet getprofile(String name)
	{
		
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select *from m_admin where adminid = '"+name+"' ";
			
		resultSet =  statement.executeQuery(sql);
			
			
			 
			System.out.println("Password Updated Successfully......");
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return resultSet;
		
	}
	
	public static ResultSet getUserDetails()
	{
		
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select userid,uname,email,phone,city,state,country from digreform1 ";
			
		resultSet =  statement.executeQuery(sql);
			
			
			 
			System.out.println("Password Updated Successfully......");
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return resultSet;
		
	}
	
	public boolean editUserDetails(String [] s) 
	{
		boolean flag=false;
		String sql = "";
		String url = "";
		try
		{   
			
			
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "update digreform1 set uname='"+s[1]+"',email='"+s[2]+"',phone='"+s[3]+"',city='"+s[4]+"',state='"+s[5]+"',country='"+s[6]+"' where userid='"+s[0]+"'";
			System.out.println("******* Edit User Details Info *********\n");
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin Edit User Details Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-editUserDetails(String [] s)  :");
			e.printStackTrace();
		}
		return flag;
	}
	
	public static ResultSet getSpecificUserDetails(int userId)
	{
		String sql="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql="select * from digreform1 where userid='"+userId+"'";
			System.out.println("******* Get Specific User Info *********\n");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
		}
		catch(Exception e)
		{
			System.out.println("UserDAO-getServerSpecificDetails(int userId): ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public boolean deleteUserDetails(int userId) 
	{
		boolean flag=false;
		String sql = "";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "delete from digreform1 where userid='"+userId+"'";
			System.out.println("******* Delete User Details Info *********\n");
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Delete User Details Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("deleteUserDetails(int serverId) :" );
			e.printStackTrace();
		}
		return flag;
	}



	public static ResultSet getUserdetail() {
		
		
		
		
				try
				{
					DAO dao=DAO.getInstance();
					connection=dao.connector();
					statement = connection.createStatement();
					String sql = "select u_id from m_user ";
					
					resultSet = statement.executeQuery(sql);
					System.out.println("Retrieving Process Completed......");
					
					
				}
				catch(Exception e)
				{
					System.out.println("Exception in --> "+ e);
				}
				return resultSet;


		


	}



	public static boolean checkNoun(String keyword)
	
	{
      boolean flag=false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select * from m_noun where noun_word='"+keyword+"'";
			
			resultSet = statement.executeQuery(sql);
			//System.out.println("Retrieving Process Completed......");
			
			while(resultSet.next())
			{
				flag=true;
				
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return flag;
	}

	public static boolean insertNoun(int id,String noun)
	{
		boolean flag=false;
	try
	{
		String desc="noun";
		DAO dao=DAO.getInstance();
		connection=dao.connector();
		statement = connection.createStatement();
		String sqlquery="insert into m_desc(file_id,filtered_words,desc_words) values('"+id+"','"+noun+"','"+desc+"')" ;
		System.out.println(sqlquery);
		statement.executeUpdate(sqlquery);	
		flag = true;
	}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return flag;
	}
	
	
	public static boolean insertWordVal(String pairone,int weight,String pairtwo)
	{
		boolean flg = false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "insert into m_pairs (pair_one,pair_two,mark)values('"+pairone+"','"+pairtwo+"',"+weight+")";
		
		//System.out.println(sql);
		statement.executeUpdate(sql);
		flg=true;
		System.out.println("Search status:"+flg);
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return flg;
	}

	public static boolean insertSpecial(String pairone)
	{
		boolean flg = false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "insert into m_pairs (pair_special)value('"+pairone+"')";
		
		//System.out.println(sql);
		statement.executeUpdate(sql);
		flg=true;
		System.out.println("Search status:"+flg);
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return flg;
	}

	
	public static int insertFile(String filename)
	{
		int i=0;
	try
	{
		
		DAO dao=DAO.getInstance();
		connection=dao.connector();
		statement = connection.createStatement();
		String sqlquery="insert into m_transaction(f_name) values('"+filename+"')" ;
		System.out.println(sqlquery);
		statement.executeUpdate(sqlquery);	
		boolean flag = true;
		String sql = "select f_no from m_transaction where f_name ='"+filename+"'";
		
		resultSet = statement.executeQuery(sql);
	
		
		while(resultSet.next())
		{
			i=resultSet.getInt(1);
		}
		
	}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return i ;
	}
	public static boolean insertAdject(int id,String adj)
	{
		boolean flag=false;
	try
	{
		String desc="adjective";
		DAO dao=DAO.getInstance();
		connection=dao.connector();
		statement = connection.createStatement();
		String sqlquery="insert into m_desc(file_id,filtered_words,desc_words) values('"+id+"','"+adj+"','"+desc+"')" ;
		System.out.println(sqlquery);
		statement.executeUpdate(sqlquery);	
		flag = true;
	}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return flag;
	}
	
	public static boolean insertSpecial(int id,String special)
	{
		boolean flag=false;
	try
	{
		String desc="special";
		DAO dao=DAO.getInstance();
		connection=dao.connector();
		statement = connection.createStatement();
		String sqlquery="insert into m_desc(file_id,filtered_words,desc_words) values('"+id+"','"+special+"','"+desc+"')" ;
		System.out.println(sqlquery);
		statement.executeUpdate(sqlquery);	
		flag = true;
	}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return flag;
	}
	public static boolean checkAdjective(String keyword)
	{
		
		boolean flag=false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select * from m_adjective where adj_word='"+keyword+"'";
			
			resultSet = statement.executeQuery(sql);
		//	System.out.println("Retrieving Process Completed......");
			
			while(resultSet.next())
			{
				flag=true;
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return flag;
	}



	public static boolean checkSpecial(String keyword)
	{

		boolean flag=false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select * from m_special where spe_name='"+keyword+"'";
			
			resultSet = statement.executeQuery(sql);
		//	System.out.println("Retrieving Process Completed......");
			
			while(resultSet.next())
			{
				flag=true;
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return flag;
	}
	public static ResultSet getdescwords() {
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select u_id from m_user ";
			
			resultSet = statement.executeQuery(sql);
			System.out.println("Retrieving Process Completed......");
			
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return resultSet;





}
	
	
	

	public static ResultSet getworddiscription(int fno) {
		try
				{
					DAO dao=DAO.getInstance();
					connection=dao.connector();
					statement = connection.createStatement();
					String sql = "select * from m_desc where file_id="+fno+"";
					
					resultSet = statement.executeQuery(sql);
					System.out.println("Retrieving Process Completed......");
					
					
				}
				catch(Exception e)
				{
					System.out.println("Exception in --> "+ e);
				}
				return resultSet;

	}


	public static int getFileNo(String fname)
	{
		int fl=0;
		try
		{
			
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		   String sql ="select f_no from m_transaction where f_name='"+fname+"'";
		
		System.out.println(sql);
		
		while(resultSet.next())
		{
			fl=resultSet.getInt(1);
		}
		System.out.println("Weight:++++++++++++++++++++++++++++++++++++++++++"+fl);
		
				
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return fl;
	}



	
	
	public static int Filelength1(int id)
	{
		int fl=0;
		try
		{
			
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		   String sql ="select count(file_id) from m_desc where file_id='"+id+"'";
		
		System.out.println(sql);
		
		while(resultSet.next())
		{
			fl=resultSet.getInt(1);
		}
		System.out.println("Weight:++++++++++++++++++++++++++++++++++++++++++"+fl);
		
				
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return fl;
	}



	public static int getnumofFiles()
	{
		int no_of_files=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select count(*) from m_transaction";
			
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				no_of_files=resultSet.getInt(1);
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
	
		return no_of_files;
	}


	public static ResultSet getDesc() 
	{
		int id=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select pair_one,sum(mark) from m_pairs group by pair_one;");
			
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO-->getDataOwnerId(String username): ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
	

}
