<%@ page import="java.sql.*" %>
<html>
<head>
<%
	ResultSet rs=(ResultSet)request.getAttribute("rsadmin");
	/* int id=0,cell=0;String userid="",name="",city="",mail=""; */
	int id=0;String userid="",name="",city="",mail="",cell="";
	
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
<body>
<%
	while(rs.next())
	{
		id=rs.getInt(1);
		System.out.println("id is>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+id);
		userid=rs.getString(2);
		System.out.println("userid is>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+userid);
		name=rs.getString(4);
		System.out.println("name is>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+name);
		cell=rs.getString(6);
		System.out.println("cell is>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+cell);
		city=rs.getString(5);
		System.out.println("city is>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+city);
		mail=rs.getString(7);
		System.out.println("mail is>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+mail);
	}
%>

<br></br>


<a class="gradientbuttons" href="<%=request.getContextPath() %>/EditProfile?id=<%=userid %>">Edit Profile</a>
<a class="gradientbuttons" href="<%=request.getContextPath() %>/ChangePassword?id=<%=userid %>">Change Password</a>

<div>
<p id="al">Your ID No : <%=id %></p>
<p id="al">Your Name : <%=name %></p>
<p id="al">Your User ID : <%=userid %></p>
<p id="al">Your Mail ID : <%=mail %></p>
<p id="al">Your Cell N0 : <%=cell %></p>
<p id="al">Your City : <%=city %></p>

</div>
</body>
</html>