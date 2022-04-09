<%@ page import="java.sql.*" %>
<html>
<head>
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
	//ResultSet rs=(ResultSet)request.getAttribute("rs");
/* int id=0,cell=0;String userid="",name="",city="",mail="",state=""; */
	int id=0;String userid="",name="",city="",mail="",state="",cell="";
%>
<style>
p 
{
	font-family: monospace;
	font-style: italic;
	font-variant: normal;
	font-weight: bolder;
	font-size: medium;
	line-height: 200%;
	word-spacing: 1.5ex;
	letter-spacing: 0.1ex;
	text-transform: capitalize;
	text-indent: 0ex;
	text-align:center;
	
	
} 
div
{
	border-top-style:dotted;
	border-right-style:solid;
	border-bottom-style:dotted;
	border-left-style:solid;
}
</style>
<link rel="stylesheet" href="<%=request.getContextPath() %>/Files1/CSS/button.css" type="text/css"/>
<link rel="stylesheet" href="<%=request.getContextPath() %>/Files1/CSS/style.css" type="text/css"/>
</head>
<%
int no=convert(request.getParameter("no"));
if(no==1)
{%>
<div class="gradientbuttons" id="message" style="position:absolute;top:0px;left:280px">
	<p>Review added successfully</p>
</div>
<%}
if(no==2)
{%>
<div class="gradientbuttons" id="message" style="position:absolute;top:0px;left:280px">
	<p>OOP's Something Went Wrong ...!!</p>
</div>
<%}%>
<body onload="startTimer()">


<form action="<%=request.getContextPath() %>/AddUpdateProfile" method="post">
<input class="gradientbuttons" type="submit" value="Add Reviews" class="gradientbuttons" ></input>

<div>
	
	<p id="al"> PRODUCT_ID: <input type="text" name="id"></input></p>
	
	 <p id="al">PRODUCT_REVIEW: <input type="text" name="review"></input></p> 
	
</div>
</form>
</body>
</html>