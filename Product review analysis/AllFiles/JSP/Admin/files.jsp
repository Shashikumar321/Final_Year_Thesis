<%@ page import="java.sql.*" %>
<%@ page import="com.util.*" %>
<%@ page import="com.dao.*" %>
<html>
<%
	ResultSet rs=(ResultSet)Utility.parse2(request.getAttribute("rs"));
    ResultSet rs1=AdminDAO.getfiles();
	String name=Utility.parse1(request.getParameter("name"));
	int count=1;
%>
<head>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/Files/CSS/message.css" type="text/css"/>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/Files/CSS/trans.css" type="text/css"/>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/Files/CSS/login.css" type="text/css"/>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/Files/CSS/button.css" type="text/css"/>
	<script type="text/javascript" src="<%=request.getContextPath() %>/Files/JS/pagination.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/Files/JS/style.js"></script>
</head>
<body onload="startTimer()">
<form action="<%=request.getContextPath() %>/Uploadfile1">
<input type="hidden" name="name" value="<%=name %>"/>
<input type="submit"  name="submit" value="Upload" class="button_example" id="a1"/>&nbsp;&nbsp;&nbsp;&nbsp;
<input type="submit" name="submit" value="Delete" class="button_example" id="a1"/>&nbsp;&nbsp;&nbsp;&nbsp;

	<table id="results" class="tab" style="top: 1000 ; right:100; width: 800 ; color: black";>
	<tr>
		<th>Select</th>
		<th>FileId</th>
		<th>FileName</th>
		
	</tr>
	<%
	if(rs1!=null)
		while(rs1.next())
		{%>
			<tr>
				<td><%=count++ %>&nbsp;&nbsp;&nbsp;
					<input name="chk" type="checkbox" value="<%=rs1.getInt(1) %>"></td>
				<td><%=rs1.getInt(1) %></td>
				
				<td><%=rs1.getString(2) %></td>
				
				</tr>
		<%}
	%>
</table>
</form>
<div id="pageNavPosition" style="cursor:hand"></div>
<script type="text/javascript"><!--
        var pager = new Pager('results', 5); 
        pager.init(); 
        pager.showPageNav('pager', 'pageNavPosition'); 
        pager.showPage(1);
    //--></script>
<%
	if(Utility.parse(request.getParameter("no"))==2)
    {%>
    	<div class="success" id="message">	
    		<p>File Uploaded Successfully.....!</p>
    	</div>			
    <%}
	if(Utility.parse(request.getParameter("no"))==1)
	{%>
		<div class="tab1" style="position:absolute;top:250px;left:410px">	
			<form id="login" action="<%=request.getContextPath() %>/Reviewfileupload?name=<%=name %>" enctype="multipart/form-data" method="post">
				
				<input type="file" name="file" class="field" required="true"></input><br></br>
				<input type="submit" name="Upload File" class="button"></input>
				
			</form>
		</div>			
	<%}
	if(Utility.parse(request.getParameter("no"))==3)
    {%>
    	<div class="error" id="message" style="height: 50;width: 250;">	
    		<p>Opp's select atleast one to delete.....!</p>
    	</div>			
    <%}
	if(Utility.parse(request.getParameter("no"))==4)
    {%>
    	<div class="success" id="message" style="height: 50;width: 250;">	
    		<p>File Deleted Successfully.....!</p>
    	</div>			
    <%}
	
	if(Utility.parse(request.getParameter("no"))==5)
    {%>
    	<div class="error" id="message" style="height: 50;width: 250;">	
    		<p>Network problem.....!</p>
    	</div>			
    <%}
	
	if(Utility.parse(request.getParameter("no"))==6)
    {%>
    	<div class="error" id="message" style="height: 50;width: 250;">	
    		<p>Downloaded Successfully</p>
    	</div>			
    <%}
	if(Utility.parse(request.getParameter("no"))==7)
    {%>
    	<div class="error" id="message" style="height: 80;width: 250;">	
    		<p>Some blocks of file are already exists in the cloud</p>
    	</div>			
    <%}
	
%>		
</body>
</html>