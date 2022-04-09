<html>
<%
	String admin=request.getAttribute("admin").toString();
%>
<script language="JavaScript">
javascript:window.history.forward(-1);
</script>

<head>
	<link href="<%=request.getContextPath() %>/CSS1/style.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="<%=request.getContextPath() %>/Files/CSS/button.css" type="text/css"/>
	<link href="<%=request.getContextPath()%>/CSS1/style.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath()%>/CSS1/style.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath()%>/CSS1/style.css" rel="stylesheet" type="text/css" />
	<script src="<%=request.getContextPath()%>/JS1/jquery-1.6.4.min.js" type="text/javascript"></script>
</head>
<body>
	 
	<img src="<%=request.getContextPath()%>/AllFiles/Images/2.png" width="1300" height="100"></img> 

<div style="position:absolute;top:140px;left:10px;">
	<font style="font-family: Monotype Corsiva; font-size: 30px; color:;">Welcome <%=admin %></font>
	<br><br>	
	<a class="button_example" href="<%=request.getContextPath() %>/AdminProfile?name=<%=admin %>" target="afrm">Show Profile&nbsp;&nbsp;</a><br></br>
	
	 
	  <a class="button_example" href="<%=request.getContextPath() %>/UserList?submit=get" target="afrm">User Details&nbsp;&nbsp;</a><br></br>
	  <%--
 	<a class="button_example" href="<%=request.getContextPath() %>/CloudList?submit=get" target="afrm">Cloud Details</a><br></br> 
    <a class="button_example" href="<%=request.getContextPath() %>/HashDetails?submit=get" target="afrm">Hash Details&nbsp;&nbsp;</a><br></br>
	<a class="button_example" href="<%=request.getContextPath() %>/Trans1?submit=get" target="afrm">Transactions&nbsp;</a><br></br>
	--%>
	
	<a class="button_example" href="<%=request.getContextPath() %>/index.jsp">&nbsp;&nbsp;Sign Out&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
</div>		
	<div style="position:absolute;top:140px;left:150px;">
		<iframe frameborder="0" scrolling="auto" name="afrm" height="470" width="800" style;>
		</iframe>
	</div>
</body>
</html>