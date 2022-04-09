<%@page import="com.helperclass.Utility"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.dao.AdminDAO"%><html>
<head>
	<link href="<%=request.getContextPath() %>/AllFiles/CSS/style.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/AllFiles/CSS/message.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/AllFiles/CSS/button.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/AllFiles/CSS/login.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=request.getContextPath() %>/AllFiles/JS/style.js"></script>

</head>

	<%	

    int no=Utility.parse(request.getParameter("no"));
    ResultSet rs=(ResultSet)request.getAttribute("rs");
    int id=0;
	String username="",name="",email="",add="",phone="";
	
	while(rs.next())
	{
		id=rs.getInt(1);
		name=rs.getString(2);
		username=rs.getString(4);
		email=rs.getString(7);
		add=rs.getString(5);
		phone=rs.getString(6);
	}

	if(no==1)
	{
%>
			<div class="error" id="message" style="position:absolute;top:225px;left:300px">		
				<p>Opp's,Seems something went wrong ..!</p>
			</div>
<%
	}
	else if(no==0)
	{
%>
			<br>
			<div align="right" style="position:absolute;top:40px;left:375px">
				<a class="gradientbuttons" href="<%=request.getContextPath() %>/EditProfile?username=<%=username %>&no=1">Edit Profile</a>&nbsp;&nbsp;&nbsp;&nbsp;
				<a class="gradientbuttons" href="<%=request.getContextPath() %>/ChangePass?username=<%=username %>&no=1&id=<%=id %>" >Change Password</a>
			</div>
			<br>
			<div  align="right" style="position:absolute;top:70px;left:105px">
			
				<p>
				
					<table border="1"  cellpadding="5px" cellspacing="1px" width="400px">
							<tr>
									<td colspan="3" align="center">
									<font color="maroon" style="font-style: bold;font-family: Monotype corsiva;" size="6">Admin Profile</font>
									</td>
						
									<!-- <td colspan="3" align="center" ><hr></hr></td> -->
							</tr>
							
							<!-- <tr>
									<td>&nbsp;</td>
							</tr> -->
							
							<tr>
									<td width="200px"><font color="#000000" font-style: bold">Your ID No </font></td>
									 <td width="50px">:</td> 
									<td> <font color="#000000"><%=id %></font></td>
							</tr>
							
							<!-- <tr>
									<td>&nbsp;</td>
							</tr>
							 -->
							<tr>
									<td><font color="#000000">Your Name</font></td>
									<td >:</td>
									<td><font color="#000000"> <%=name %></font></td>
							</tr>
							
							<!-- <tr>
									<td>&nbsp;</td>
							</tr>
							 -->
							<tr>
									<td><font color="#000000">Your User ID</font></td>
									<td>:</td>
									<td> <font color="#000000"><%=username %></font></td>
							</tr>
							
							<!-- <tr>
									<td>&nbsp;</td>
							</tr> -->
							
							<tr>
									<td><font color="#000000">Your Mail ID</font> </td>
									<td>:</td>
									<td><font color="#000000"> <%=email %></font></td>
							</tr>
							
							<!-- <tr>
									<td>&nbsp;</td>
							</tr> -->
							
							<tr>
									<td><font color="#000000">Your Cell N0</font>  </td>
									<td>:</td>
									<td><font color="#000000"> <%=phone %></font></td>
							</tr>
							
							
							<!-- <tr>
									<td>&nbsp;</td>
							</tr> -->
							
							<tr>
									<td><font color="#000000">Your Address </font> </td>
									<td>:</td>
									<td><font color="#000000">  <%=add %></font></td>
							</tr>
					</table>
				</p>
				
				
			</div>
		<%
		if(Utility.parse(request.getParameter("no1"))==1)
		{
			%>
				<div class="success" id="message" style="position:absolute;top:5px;left:50px">	
					<p>Your profile updated successfully ..!</p>
				</div>
			<%
		}
		
		if(Utility.parse(request.getParameter("no1"))==2)
		{
			%>
				<div class="success" id="message" style="position:absolute;top:5px;left:50px">	
					<p>Your Password updated successfully ..!</p>
				</div>
			<%
		}
	}
	else if(no==2)
	{
%>


<!-- Display Contents (Starts) -->

					<form id="login" action="<%=request.getContextPath() %>/EditProfile?no=2">
					<input type="hidden" name="admin" value="<%=username %>"></input>
					<input type="hidden" name="no" value="2"></input>
					<input type="hidden" name="id" value="<%=id %>"></input>
					<div align="right" style="position:absolute;top:30px;left:375px">
						<input type="submit" value="Save Updates" class="gradientbuttons"/>&nbsp;&nbsp;&nbsp;&nbsp;
						<a class="gradientbuttons" href="<%=request.getContextPath() %>/ChangePass?username=<%=username %>&no=1&id=<%=id %>">Change Password</a>
					</div>
					<br></br>
					<div  align="right" style="position:absolute;top:70px;left:125px">
						
						<p>
					<table>
							<tr>
									<td colspan="3" align="center">
									<font color="maroon" style="font-style: bold;font-family: monotype corsiva" size="6">Edit Admin Profile </font>
									</td>
							</tr>
							
							<tr>
									<td colspan="3" align="center"><hr></hr></td>
							</tr>
							
							<tr>
									<td>&nbsp;</td>
							</tr>
							
							<tr>
									<td width="200px">Your ID No</td>
									<td width="50px">:</td>
									<td> <%=id %></td>
							</tr>
							<tr>
									<td>&nbsp;</td>
							</tr>
							
							<tr>
									<td>Your User ID</td>
									<td>:</td>
									<td> <%=username %></td>
							</tr>
							<tr>
									<td>&nbsp;</td>
							</tr>
							
							<tr>
									<td>Your Name</td>
									<td >:</td>
									<td> 
										<input class="field" type="text" name="name" value="<%=name %>" ></input>
									</td>
							</tr>
							
							
							
							<tr>
									<td>&nbsp;</td>
							</tr>
							
							<tr>
									<td>Your Mail ID </td>
									<td>:</td>
									<td>
										<input class="field" type="email" name="email" value="<%=email %>" required="yes"></input>
									</td>
							</tr>
							
							<tr>
									<td>&nbsp;</td>
							</tr>
							
							<tr>
									<td>Your Cell No  </td>
									<td>:</td>
									<td> 
										<input class="field" type="text" name="phone" value="<%=phone %>" pattern="[0-9]{10}" required="yes"></input>
									</td>
							</tr>
							
							
							<tr>
									<td>&nbsp;</td>
							</tr>
							
							<tr>
									<td>Your Address  </td>
									<td>:</td>
									<td>
										<input class="field" type="text" name="add" value="<%=add %>"  ></input>
									</td>
							</tr>
					</table>
				</p>
						
		</div>
</form>

<!-- Display Contents (Ends) -->
<%
}
	else if(no==3)
	{
%>
      <form id="login" action="<%=request.getContextPath() %>/ChangePass?no=2">
		<input type="hidden" name="admin" value="<%=username %>"></input>
		<input type="hidden" name="id" value="<%=id %>"></input>
		<input type="hidden" name="no" value="2"></input>
		<div align="right" style="position:absolute;top:40px;left:375px">
			<a class="gradientbuttons" href="<%=request.getContextPath() %>/EditProfile?username=<%=username%>&no=1">Edit Profile</a>
			<input type="submit" value="Save Updates" class="gradientbuttons"/>&nbsp;&nbsp;&nbsp;&nbsp;
		</div>
		<br></br>
		
		<div  align="right" style="position:absolute;top:80px;left:125px">
				<p>
					<table>
							<tr>
									<td colspan="3" align="center">
									<font color="maroon" style="font-style: bold;font-family: monotype corsiva" size="6">Change Password</font>
									</td>
							</tr>
							
							<tr>
									<td colspan="3" align="center"><hr></hr></td>
							</tr>
							
							<tr>
									<td>&nbsp;</td>
							</tr>
							
							<tr>
									<td width="200px">Your ID No</td>
									<td width="50px">:</td>
									<td> <%=id %></td>
							</tr>
							
							<tr>
									<td>&nbsp;</td>
							</tr>
							
							<tr>
									<td>Current Password</td>
									<td >:</td>
									<td> 
										<input class="field" type="password" name="pass"/>
									</td>
							</tr>
							
							<tr>
									<td>&nbsp;</td>
							</tr>
							
							<tr>
									<td>New Password</td>
									<td>:</td>
									<td>
										<input class="field" type="password" name="npass" required="yes"></input>
									</td>
							</tr>
							
							<tr>
									<td>&nbsp;</td>
							</tr>
							
							<tr>
									<td>Confirm new password   </td>
									<td>:</td>
									<td> 
										<input class="field" type="password" name="cpass"></input>
									</td>
							</tr>
							
					</table>
				</p>
		</div>
	</form>

<%
	if(Utility.parse(request.getParameter("no1"))==1)
	{
		%>
			<div class="error" id="message" style="position:absolute;top:5px;left:50px">	
				<p>Opp's,your current password is wrong ..!</p>
			</div>
		<%
	}
	if(Utility.parse(request.getParameter("no1"))==2)
	{
		%>
			<div class="error" id="message" style="position:absolute;top:5px;left:50px">	
				<p>Opp's,your new password do not match with confirm password ..!</p>
			</div>
		<%
	}
	if(Utility.parse(request.getParameter("no1"))==3)
	{
		%>
			<div class="error" id="message" style="position:absolute;top:5px;left:50px">	
				<p>Opp's,Seems something went wrong....!</p>
			</div>
		<%
	}
}
%>
</body>
</html>


