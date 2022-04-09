<%@page import="com.helperclass.Utility"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.dao.AdminDAO"%>
<%@page import="com.dao.UserDAO"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%><html>
<head>
	<link href="<%=request.getContextPath() %>/AllFiles/CSS/style.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/AllFiles/CSS/message.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/AllFiles/CSS/button.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/AllFiles/CSS/login.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=request.getContextPath() %>/AllFiles/JS/style.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/AllFiles/JS/pagination.js"></script>
</head>

<script language="javascript">
	function check()
	{
		if(document.f1.file.value.length==0)
		{
			alert("Please Select a File");
			return false
		}
		else
		{
			return true;
		}
	}
</script>

<body onload="startTimer()">
<%
	String subject = request.getParameter("subject");
    session.setAttribute("subject",subject);
    if(Utility.parse(request.getParameter("no"))==0)
	{
%>

<div id="a3" style="position:absolute;top:50px;left:150px" >
	<form name="f1" action="<%=request.getContextPath()%>/UploadFile" method="post" enctype="multipart/form-data">
	<table id="login" align="center">
	    
	    <h1 align="center"><font color="#fedcba" style="font-style: bold;font-family: Monotype corsiva;" size="6">Upload Your File To Cloud</font></h1>
	    
		<hr size="2" color="#11F260"></hr>
		
		<tr>
				<td>&nbsp;</td>
		</tr>
	    
		<tr id="label" align="center">
		    
			<td align="center" colspan="3">
				
					<input type="file" class="field2" name="file" required="required" width="150px"></input>
				
			</td>
		</tr>
		
		<tr>
				<td>&nbsp;</td>
		</tr>
		
		
		<tr>
				<td>&nbsp;</td>
		</tr>
		
		<tr align="center">
			<td align="center" colspan="3">
					<input type="submit" class="button" value="Upload File" onclick="return check();"></input>
			</td>
	    </tr>
	
	</table>
	</form>
	</div>
	
	<%
		if(Utility.parse(request.getParameter("no1"))==1)
		{
			%>
				<div class="error" id="message" style="position:absolute;top:5px;left:50px">	
					<p>Opps,Some Thing Went Wrong !</p>
				</div>
			<%
		}
	%>
<% 	
	}
	if(Utility.parse(request.getParameter("no"))==1)
	{
		String fileName = request.getParameter("file_name");
		String cloud = request.getParameter("cloud");
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat formatter1=new SimpleDateFormat("HH:mm:ss");
		String date = formatter.format(currentDate.getTime());
		String time = formatter1.format(currentDate.getTime());
		String username = ""; 
		HttpSession sesion = request.getSession();
		
	   	if(sesion != null)
		{
		  username = (String) session.getAttribute("username");
		}
		   
%>

	<div  style="position:absolute;left:50px" class="c">
	<table id="login" align="center">
	    
	    <h1 align="center"><font color="#fdebc" style="font-style: bold" size="5">File Upload Acknowledgement</font></h1>
	    
		<hr size="10" color="#5E74D8"></hr>
		
		
		<tr  bgcolor="" align="center">
		
		    <td><font color="grey" size="5px">Mr. <%= username.toUpperCase() %></font> </td>
		    
	    </tr>
		
		
		
		<tr  bgcolor="" align="center">
		
		    <td><pre><font color="red" size="5">Your File has been Uploaded Successfully......</font></pre></td>
		    
	    </tr>
	    
	    <tr  bgcolor="" align="center">
		
		    <td><pre><font color="white" size="5"><%=cloud%></font></pre></td>
		    
	    </tr>
		
		<tr  bgcolor="" align="center">
		
		   <td><font color="#fdecba" size="5">File Name  :  <%=fileName %> </td>
		    
	    </tr>
	    
	    <tr  bgcolor="" align="center">
		
		   <td><font color="white" size="4">Date  :  <%= date %>       &       Time  :  <%= time %> </td>
		    
	    </tr>
	    
	</table>

<%
} 
%>
</body>
</html>