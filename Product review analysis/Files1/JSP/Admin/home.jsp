<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<html>
<head>
<style>
iframe 
{
	margin-top: 20px;
 	 margin-bottom: 30px;
	padding:20px;
		
	scrollbar-base-color: red;
	scrollbar-arrow-color: red;
	
	
  -moz-border-radius: 42px;
  -webkit-border-radius: 42px; 
  border-radius: 42px; 

  -moz-box-shadow: 0px 0px 104px #000; 
  -webkit-box-shadow: 0px 0px 104px #000; 
  box-shadow: 0px 0px 104px #000; 

  -moz-transform:rotate(0.1deg);
  -webkit-transform:rotate(0.1deg);
  -o-transform:rotate(0.1deg);
  -ms-transform:rotate(0.1deg);
  
}
</style>
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
<script language="JavaScript">
<!--
  javascript:window.history.forward(-1);
//-->
</script>
<script type="text/javascript">
function hideMessage()
{
	document.getElementById("message").style.display="none"; 
}
function startTimer() 
{
	var tim = window.setTimeout("hideMessage()", 5000);  // 5000 milliseconds = 5 seconds
}
</script>
<%
String id=session.getAttribute("admin").toString();
Properties pro = new Properties();
Properties pro1 = new Properties();
FileInputStream in=null;FileInputStream in1=null;
String path=request.getRealPath("");
try
{
	in = new FileInputStream(path+"\\Files\\Properties\\home.properties");
	in1 = new FileInputStream(path+"\\Files\\Properties\\lables.properties");
} 
catch(Exception ex)
{
	out.println("<center>Opp's.........lables.properties is missing...!</center>");
	System.out.println(ex);
}
pro.load(in);
pro1.load(in1);
%>
<link href="<%=request.getContextPath() %>/Files/CSS/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/Files/CSS/button.css" type="text/css"/>
</head>
<body>
<img class="banner" src="<%=request.getContextPath()%>/<%=pro.getProperty("Banner") %>"></img>
<br>

<div class="welcome">
	Welcome [<%=id %>]
</div>

<p id="effect" class="panel">
&nbsp;&nbsp;&nbsp;&nbsp;<a class="gradientbuttons" href="<%=request.getContextPath() %>/GetImages" target="afrm"><%=pro1.getProperty("Menu0_A") %><img border="0" src="<%=request.getContextPath() %>/Files/Images/ball.png" title="<%=pro1.getProperty("Menu0_Text_A") %>"/></a><br></br>
&nbsp;&nbsp;&nbsp;&nbsp;<a class="gradientbuttons" href="<%=request.getContextPath() %>/Keyprocessmanagement?submit=get" target="afrm"><%=pro1.getProperty("Menu8_U") %><img border="0" src="<%=request.getContextPath() %>/Files/Images/ball.png" title="<%=pro1.getProperty("Menu2_Text_U") %>"/></a><br></br>
&nbsp;&nbsp;&nbsp;&nbsp;<a class="gradientbuttons" href="<%=request.getContextPath() %>/GetProfile?id=<%=id %>" target="afrm"><%=pro1.getProperty("Menu1_A") %><img border="0" src="<%=request.getContextPath() %>/Files/Images/ball.png" title="<%=pro1.getProperty("Menu1_Text_A") %>"/></a><br></br>
&nbsp;&nbsp;&nbsp;&nbsp;<a class="gradientbuttons" href="<%=request.getContextPath() %>/EditProfile?id=<%=id %>" target="afrm"><%=pro1.getProperty("Menu2_A") %><img border="0" src="<%=request.getContextPath() %>/Files/Images/ball.png" title="<%=pro1.getProperty("Menu2_Text_A") %>"/></a><br></br>
&nbsp;&nbsp;&nbsp;&nbsp;<a class="gradientbuttons" href="<%=request.getContextPath() %>/ChangePassword?id=<%=id %>" target="afrm"><%=pro1.getProperty("Menu3_A") %><img border="0" src="<%=request.getContextPath() %>/Files/Images/ball.png" title="<%=pro1.getProperty("Menu3_Text_A") %>"/></a><br></br>
&nbsp;&nbsp;&nbsp;&nbsp;<a class="gradientbuttons" href="<%=request.getContextPath() %>/UserList?id=<%=id %>" target="afrm"><%=pro1.getProperty("Menu5_A") %><img border="0" src="<%=request.getContextPath() %>/Files/Images/ball.png" title="<%=pro1.getProperty("Menu5_Text_A") %>"/></a><br></br>
&nbsp;&nbsp;&nbsp;&nbsp;<a class="gradientbuttons" href="<%=request.getContextPath() %>/UserList?id=<%=id %>" target="afrm"><%=pro1.getProperty("Menu6_A") %><img border="0" src="<%=request.getContextPath() %>/Files/Images/ball.png" title="<%=pro1.getProperty("Menu6_Text_A") %>"/></a><br></br>
&nbsp;&nbsp;&nbsp;&nbsp;<a class="gradientbuttons" href="<%=request.getContextPath() %>/Files/JSP/Admin/logout.jsp"><%=pro1.getProperty("Menu4_A") %><img border="0" src="<%=request.getContextPath() %>/Files/Images/ball.png" title="<%=pro1.getProperty("Menu4_Text_A") %>"/></a><br></br>
</p>



<div style="position:absolute;top:140px;left:210px;">
<iframe frameborder="0" scrolling="auto" name="afrm" height="470" width="750"></iframe>
</div>


</body>
</html>