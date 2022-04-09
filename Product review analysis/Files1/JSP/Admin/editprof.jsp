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
	ResultSet rs=(ResultSet)request.getAttribute("rs");
	int id=0;String userid="",name="",city="",mail="",cell="",password="";
	
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
<link rel="stylesheet" href="<%=request.getContextPath() %>/Files/CSS/button.css" type="text/css"/>
</head>
<%
int no=convert(request.getParameter("no"));
if(no==1)
{%>
<div class="gradientbuttons" id="message" style="position:absolute;top:10px;left:280px">
	<p>Succeefully Updated Profile ...!!</p>
</div>
<%}
if(no==2)
{%>
<div class="gradientbuttons" id="message" style="position:absolute;top:10px;left:280px">
	<p>OOP's Something Went Wrong ...!!</p>
</div>
<%}%>
<body onload="startTimer()">
<%
	while(rs.next())
	{
		id=rs.getInt(1);
		userid=rs.getString(2);
		name=rs.getString(4);
		city=rs.getString(5);
		cell=rs.getString(6);
		mail=rs.getString(7);
	}
%>
<br></br>
<form action="<%=request.getContextPath() %>/UpdateProfile" method="post">

<input type="submit" value="Update Changes" class="gradientbuttons" ></input>

<div>
	  <p id="al">Your ID No : <%=id %></p>  
	<p id="al">Your Name : <input type="text" name="name" value="<%=name %>"></input></p>
	<p id="al">Your User ID : <%=userid %><input name="id" type="hidden" value="<%=userid %>"></p>
	<p id="al">Your Mail ID : <input type="text" name="mail" value="<%=mail %>"></input></p>
	<p id="al">Your Cell N0 : <input type="text" name="cell" value="<%=cell %>"></input></p>
	<p id="al">Your City : <input type="text" name="city" value="<%=city %>"></input></p>
</div>
</form>
</body>
</html>