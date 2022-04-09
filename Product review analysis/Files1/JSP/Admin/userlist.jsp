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
<style>#pageNavPosition{cursor:hand}</style>
<script type="text/javascript" src="<%=request.getContextPath() %>/Files/JS/pagination.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/Files/CSS/button.css" type="text/css"/>
<link rel="stylesheet" href="<%=request.getContextPath() %>/Files/CSS/inbox.css" type="text/css"/>
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
int no=convert(request.getParameter("no"));
if(no==1)
{%>
<div class="gradientbuttons" id="message" style="position:absolute;top:10px;left:200px">
	<p>OOP's Select Atleast One...!!</p>
</div>
<%}
if(no==2)
{%>
<div class="gradientbuttons" id="message" style="position:absolute;top:0px;left:200px">
	<p>User Deleted Successfully ...!!</p>
</div>
<%}%>
</head>
<body onload="startTimer()">
<%
	String id=session.getAttribute("admin").toString();
	ResultSet rs=(ResultSet)request.getAttribute("rs");
%>

<form action="<%=request.getContextPath() %>/DeleteUser">
<input type="submit" value="Delete" class="gradientbuttons"></input>
<input type="hidden" name="id" value="<%=id %>"></input>
<input type="hidden" name="task" value="delete"></input>

<table id="results">
	<tr>
		<th>Select</th>
		<th>User ID</th>
		<th>Name</th>
		<th>Add</th>
		<th>City</th>
		<th>State</th>
		<th>Contact No</th>
		<th>Mail ID</th>
		
	</tr>
		<%
			while(rs.next())
			{
				%>
					<tr id="color">
						<td><input name="chk" type="checkbox" value="<%=rs.getInt(1) %>"></td>
						<td><%=rs.getString(2) %></td>
						<td><%=rs.getString(4) %></td>
						<td><%=rs.getString(5) %></td>
						<td><%=rs.getString(6) %></td>
						<td><%=rs.getString(7) %></td>
						<td><%=rs.getDouble(8) %></td>
						<td><%=rs.getString(9) %></td>
					</tr>
				<%
			}
		%>
	</table>
</form>
<div id="pageNavPosition"></div>
<script type="text/javascript"><!--
        var pager = new Pager('results', 5); 
        pager.init(); 
        pager.showPageNav('pager', 'pageNavPosition'); 
        pager.showPage(1);
    //--></script>		
		
</body>
</html>