<%@page import="com.helperclass.Utility"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.dao.AdminDAO"%><html>
<head>
	<link href="<%=request.getContextPath() %>/AllFiles/CSS/style.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/AllFiles/CSS/message.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/AllFiles/CSS/button.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/AllFiles/CSS/login.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=request.getContextPath() %>/AllFiles/JS/style.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/AllFiles/JS/pagination.js"></script>

</head>
<body onload="startTimer()">
<%
    int no2=Utility.parse(request.getParameter("no"));
    ResultSet rs=(ResultSet)request.getAttribute("rs");
    int id=0,cat_code;
    float pro_price=0;
	String name="",pro_desc="",seller="";
	
	 
	
	
%>	

<form action="<%=request.getContextPath()%>//AllFiles/JSP/Admin/AddProductlist.jsp" method="get" >
 <div align="right" style="position:absolute;top:30px;left:400px">
 
	
</div> 

<body onload="startTimer();">


<center>

<h1 class="gradientbuttons" style="color:#ff6600">Product_Details</h1>
 

<table border="2">
<th>Product_name</th><th>category</th><th>pno</th><th>Prize</th><th>seller</th><th>Select</th>


<%


ResultSet rs1=AdminDAO.getProductDetails();

String catname=AdminDAO.getCategory1(rs1.getInt(3));
while( rs.next()) 
{
	System.out.println(""+ rs1.getString(2));	
%>


<tr><td><%=rs1.getString(2) %></td>


<td><%=catname %></td>
	
<td><%=rs1.getString(4) %></td></tr>




<%
}
	
%>

</table>

</center>

<input type="submit" value="ADD" class="gradientbuttons">
</form>

</body>
</html>