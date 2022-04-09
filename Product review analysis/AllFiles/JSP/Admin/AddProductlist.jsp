<%@page import="com.helperclass.Utility"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.dao.AdminDAO"%>


<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


<body onload="startTimer();">
	

		

		
 <form action="<%=request.getContextPath()%>/AddProductlist" method="get">


<center>
 <h1 style="color:#ff6600" >Add Product Details</h1>
 
<table>    
             
				      
				    <tr><td> <label style="color:#34572B" class="gradientbuttons" >category :</label></td>
				       
	   					<td>  <select id="loc" name="loc" style="color:#CADBDF " >
				  <%	
							   	ResultSet parent=AdminDAO.getCategory();
								   	while(parent.next())
								   	{
								   	%>
								   		<option value="<%=parent.getString(1) %>" ><%=parent.getString(2) %></option>
							   		<%} %> 
	   						</select></td></tr>	
	   						
				<tr><td>  <label style="color:#34572B" class="gradientbuttons">Product_Name :</label></td><td > <input type="text" name="pname" style="color:#0E304A "  required="yes" ><td></td>
				   
				<tr><td>  <label style="color:#34572B" >Product_desc :</label></td><td > <input type="text" name="paddr" style="color:#0E304A "  required="yes" title="Enter Product Description...."><td></td>
				 
				 <tr><td> <label style="color:#34572B" class="gradientbuttons">Price :</label> </td><td> <input type="text" name="pcno" style="color:#0E304A " required="yes" class="gradientbuttons" title="Enter Price...."><td></td>
				 <tr><td> <label style="color:#34572B" class="gradientbuttons">Seller :</label> </td><td> <input type="text" name="pcnn" style="color:#0E304A "  required="yes" class="gradientbuttons" title="Enter Seller..."><td></td>
				
				 
				  
				  
				  
				
				  </table> 
				  </br>
				  </br>  
				 
				  
				  </br>
				  </br>
                     
				  
				   <input type="submit" class="gradientbuttons" value="POST">
				   </center>
				   </form>
</body>
</html>