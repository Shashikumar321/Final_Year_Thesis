
<%@page import="com.dao.AdminDAO"%>
<%@page import="com.helperclass.Utility"%><html>
<head>
<title>Generate Key</title>

	<link href="<%=request.getContextPath() %>/AllFiles/CSS/style.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/AllFiles/CSS/message.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/AllFiles/CSS/button.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/AllFiles/CSS/login.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=request.getContextPath() %>/AllFiles/JS/style.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/AllFiles/JS/pagination.js"></script>
</head>

<body onload="startTimer()">

<%
	AdminDAO adminDAO = AdminDAO.getInstance();
    
%>

<div id="a3" align="right" style="position:absolute;top:50px;left:150px">
						
		 <p>
			
					
				<form action="<%=request.getContextPath()%>/AllFiles/JSP/Admin/select_file.jsp">
					
					<table id="login" align="center">
					<tr>
							<td colspan="7" align="center">
								<font color="maroon" style="font-style: bold;font-family: Monotype corsiva;" size="6">Upload File</font>
							</td>
					</tr>
					
					<tr>
							<td colspan="3" align="center"><hr></hr></td>
					</tr>
					
					<tr>
							<td>&nbsp;</td>
					</tr>
					
					<tr align="center">
							<td width="130px"><font color="blue" size="5">Subject :</font></td>
							
							<td width="200px">
								<input type="text" class="field" name="subject" required="yes">
							</td>
							
					</tr>
					
					<tr align="center">
							<td>&nbsp;</td>
					</tr>
					
					<tr align="center">
							<td colspan="7" align="center">
								<input class="button" type="submit"  value="Select File"></input>
							</td>
					</tr>
					
					</table>
			</form>
			
		</p>
						
</div>


</body>
</html>