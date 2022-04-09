<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<html>
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
<%
Properties pro = new Properties();
FileInputStream in=null;
String path=request.getRealPath("");
try
{
	in = new FileInputStream(path+"\\Files\\Properties\\lables.properties");
}
catch(Exception ex)
{
	out.println("<center>Opp's.........lables.properties is missing...!</center>");
	System.out.println(ex);
}
pro.load(in);
%>
<style>
#login
{
	
	background:-moz-linear-gradient(linear, 40% 20%, 50% 150%, from(#D1DDFA), to(#1B5AEF));
    background:-webkit-gradient(linear, 40% 20%, 50% 150%, from(#D1DDFA), to(#1B5AEF));
	border:50px solid #eee;
	width:350px;
	-moz-border-radius:5px;
	-webkit-border-radius:5px;
	border-radius:5px;
	-moz-box-shadow:0 0 10px #4e707c;
	-webkit-box-shadow:0 0 10px #4e707c;
	box-shadow:0 0 10px #4e707c;
	text-align:center;
	position:relative;
	}
	#login a, #login a:visited{color:#0283b2;}
	#login a:hover{color:#111;}
	#login h1{
	background:-moz-linear-gradient(linear, 40% 20%, 50% 150%, from(#D1DDFA), to(#1B5AEF));
    background:-webkit-gradient(linear, 40% 20%, 50% 150%, from(#D1DDFA), to(#1B5AEF));
	color:#5BACC4;
	text-shadow:#007dab 0 1px 0;
	font-size:14px;
	padding:18px 23px;
	margin:0 0 1.5em 0;
	border-bottom:1px solid #007dab;
	}
	#login .field{
	border:10px solid #585858;
	color:white;
	width:180px;
	font-size:12px;
	line-height:1.5em;
	padding:4px;
	-moz-box-shadow:inset 0 0 5px #ccc;
	-webkit-box-shadow:inset 0 0 5px #ccc;
	box-shadow:inset 0 0 50px #000000;
	}	
	#login div.submit label{float:none;display:inline;font-size:11px;}
	#login button{
	border:0;
	padding:0 30px;
	height:30px;
	line-height:30px;
	text-align:center;
	font-size:12px;
	color:#fff;
	text-shadow:#007dab 0 1px 0;
	background:-moz-linear-gradient(linear, 40% 20%, 50% 150%, from(#D1DDFA), to(#1B5AEF));
    background:-webkit-gradient(linear, 40% 20%, 50% 150%, from(#D1DDFA), to(#1B5AEF));
	-moz-border-radius:50px;
	-webkit-border-radius:50px;
	border-radius:50px;
	cursor:pointer;
	}
</style>
</head>
<%
int no=convert(request.getParameter("no"));
if(no==1)
{%>
	<div class="downarrowdiv" id="message">
		<p><%=pro.getProperty("Invalid") %></p>
	</div>
<%}%>
<body onload="startTimer()">
	<form name="f1" id="login" method="post" action="<%=request.getContextPath() %>/AdminLogin"> 
	    <h1><%=pro.getProperty("LoginHeader_A") %></h1>
    	<div>
    		<%=pro.getProperty("T1_A") %>
    		<input type="text" name="username" id="login_username" required="yes"  />
    	</div>			
	    <div>
    		<%=pro.getProperty("T2_A") %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    		<input type="password" name="password" id="login_password" required="yes"  />
    	</div>			
		<p class="forgot"><a href="#"><%=pro.getProperty("Forget") %></a></p>
    	<div class="submit">
        	<button type="submit"><%=pro.getProperty("Submit") %></button>   
		    <label>
        		<input type="checkbox" name="remember" id="login_remember" value="yes" />
	           <%=pro.getProperty("Remember") %>
        	</label>   
    	</div>
</form>
</body>
</html>