<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<%@ page import="java.text.SimpleDateFormat" %>

<%@ page session="false" %>

<%@ page import="java.util.*" %>
<%! 
public int convert(String str) 
{ 
	int conv=0; 
	if(str==null) 
	{ 
		str="0"; 
	} 
	else if((str.trim()).equals("null")) 
	{ 
		str="0"; 
	} 
	else if(str.equals("")) 
	{ 
		str="0"; 
	} 
	try
	{ 
		conv=Integer.parseInt(str); 
	} 
	catch(Exception e) 
	{ 
	} 
	return conv; 
	
} 
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>co_extracting</title>

<link rel="stylesheet" type="text/css" href="CSS/blue.css">

<link href="<%=request.getContextPath() %>/AllFiles/CSS/message.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<%=request.getContextPath() %>/AllFiles/JS/style.js"></script>
</head>

<body  onload="startTimer()" background="<%=request.getContextPath()%>/AllFiles/Images/back.jpg">
<img src="<%=request.getContextPath()%>/AllFiles/Images/3.png" width="1250" height="100"></img> 


<div style="margin-top: 70px;margin-left: 230px;">
  
  <div id="container">
	<section class="tabs">
		<input id="tab-1" type="radio" name="radio-set" class="tab-selector-1" checked="checked" />
		<span for="tab-1" class="tab-label-1">Admin</span>

		<!-- <input id="tab-2" type="radio" name="radio-set" class="tab-selector-2" />
		<span for="tab-2" class="tab-label-2">Data Owner</span> -->
		
		<input id="tab-2" type="radio" name="radio-set" class="tab-selector-3" />
		<span for="tab-2" class="tab-label-3">User</span>

		
	
		<div class="clear-shadow"></div>
		
		<div id="content">
			<div class="content-1">
					
				<form  action="<%=request.getContextPath()%>/AdminLogin"  method="post">
				  <p>
					<label for="usernamesignup" class="uname" data-icon="">Admin Id</label>
					<input class="field" name="username" required="required" type="text" placeholder="admin id" />
				  </p>
				  
				  <p>
					<label for="passwordsignup" class="youpasswd" data-icon="">Password </label>
					<input class="field" name="password" required="required" type="password" placeholder="password"/>
				  </p>
				  
				  <p class="signin button">
					
					<input type="submit" value="Login"/>
				  </p>
				</form>
			</div>
		
			
			<div class="content-3">
				
				<form  action="<%=request.getContextPath()%>/UserLogin" method="post" autocomplete="on">
				  <p>
					<label for="username" class="uname" data-icon="" > User Id </label>
					<input class="field" name="username" required="required" type="text" placeholder="user id"/>
				  </p>
				  <p>
					<label for="password" class="youpasswd" data-icon=""> Password </label>
					<input class="field" name="password" required="required" type="password" placeholder="password" />
				  </p>
				  <p class="keeplogin">
					<a href="<%=request.getContextPath()%>/AllFiles/JSP/User/newuser.jsp">
					<font color="#99975C">User Registration</font></a>
					<input type="submit" name="login" value="Login" />
				  </p>
				</form>
			</div>
			
		</div>
	</section>
  </div>
</div>
 
<%
	int no=convert(request.getParameter("no"));
	if(no==1)
	{
		    
%>       
    		<div class="error" id="message" style="position:absolute;top:130px;left:530px">	
    			<p> Enter Username and Password !</p>
    		</div>	
    	 
<%
	}
	if(no==2)
	{
%>
		<div class="error" id="message" style="position:absolute;top:130px;left:530px">	
    			<p> Please,Enter Your Username.!</p>
    	</div>	
<%
	}
	if(no==3)
	{
%>
		<div class="error" id="message" style="position:absolute;top:130px;left:530px">	
    			<p> Please,Enter Your Password.!</p>
    	</div>	
<%
	}
%>
<%
	if(no==4)
	{
%>
		<div class="error" id="message" style="position:absolute;top:130px;left:530px">	
    			<p> Sorry,Invalid Username/Password!</p>
    	</div>	
<%
	}
%>
<%
	if(no==5)
	{
%>
		
		<div class="success" id="message" style="position:absolute;top:130px;left:530px">	
    			<p id="message">You have Logged out successfully...!</p>
    	</div>	
		
<%
	}
%>
<%
	if(no==6)
	{
%>
		
		<div class="success" id="message" style="position:absolute;top:130px;left:530px">	
    			<p id="message">Your Session Expires...!</p>
    	</div>	
		
<%
	}
%>
<%
	if(no==7)
	{
%>
		
		<div class="success" id="message" style="position:absolute;top:130px;left:530px">	
    			<p id="message">Your Account Created Successfully...!</p>
    	</div>	
		
<%
	}
%>

</body>
</html>
