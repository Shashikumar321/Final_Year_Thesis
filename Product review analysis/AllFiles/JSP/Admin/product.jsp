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
<form action="<%=request.getContextPath()%>//AllFiles/JSP/Admin/AddProductlist.jsp" method="get" >
<body onload="startTimer()">

	
</div> 

<div  align="right" style="position:absolute;top:75px;left:10px;width: 550px;height: 300px;">
			
<p>

	<table  border="2">
		
		<tr>
			
			<td colspan="7" align="center">
			<font color="maroon" style="font-style: bold;font-family: monotype corsiva" size="6">Product Details</font>
			</td>
									
		</tr>
							
	
		<tr>
			
			<th><font color="blue">Product_name</font></th>
		
			<th><font color="blue">Category_Id</font></th>
			<th><font color="blue">Product_desc</font></th>
			<th><font color="blue">Price</font></th>
			<th><font color="blue">Seller</font></th>
			<th><font color="blue">Delete</font></th>
		</tr>
		


    	<body onload="startTimer();">


<center>

<h1 class="gradientbuttons" style="color:#ff6600">Product_Details</h1>
 




<%


ResultSet rs=AdminDAO.getProductDetails();


while( rs.next()) 
{
	String catname=AdminDAO.getCategory1(rs.getInt(3));
	System.out.println("???????????????????????????"+ rs.getString(2));	
%>


<tr><td><%=rs.getString(2) %></td>


<td><%=catname %></td>
	
<td><%=rs.getString(4) %></td>
<td><%=rs.getString(5) %></td>
<td><%=rs.getString(6) %></td>
<td><a href="<%=request.getContextPath() %>/DeleteProduct?no=<%=rs.getInt(1)%>">Delete</a>
</tr>




<%
}
	
%>
<% 
	int no=Utility.parse(request.getParameter("no"));
		if(no==2)
		{
			
		%>
		
			<div class="success" id="message">	
				<p>Product Deleted Successfully...!</p>
			</div>			
		<%}%>

</table>

</center>

<input type="submit" value="ADD" class="gradientbuttons">
</form>

</body>
  	 </table>
  	 
   </div>
 
  
  
  


</body>

</html> 


