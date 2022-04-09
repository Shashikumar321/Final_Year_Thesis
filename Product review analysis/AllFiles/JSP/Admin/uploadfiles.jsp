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
    int no=Utility.parse(request.getParameter("no"));
    ResultSet rs=(ResultSet)request.getAttribute("rs");
    int id=0;
	String fileName="",fileType="",date="";
	if(no==1)
	{
%>	

<form action="<%=request.getContextPath()%>/UploadFileList">
<div align="right" style="position:absolute;top:30px;left:550px">
	<input type="submit" name="submit" value="Delete" class="gradientbuttons"/>&nbsp;&nbsp;&nbsp;&nbsp;
</div>

<div align="right" style="position:absolute;top:50px;left:11px;width: 600px;height: 300px;">
			
<p>

	<table id="results"  cellpadding="5px" cellspacing="1px" width="600px" border="1">
		
		<tr>
			
			<td colspan="5" align="center">
			<font color="maroon" style="font-style: bold;font-family: Monotype corsiva;" size="6">Upload File Details</font>
			</td>
									
		</tr>
							
		
		<tr>
			<th><font color="blue">Select</font></th>
			<th><font color="blue">File Name</font></th>
			<th><font color="blue">File Type</font></th>
			<th><font color="blue">Date &nbsp;Time</font></th>
		</tr>

<% 
	
    if(rs != null)
    {
	    while(rs.next())
		{
			id=rs.getInt(1);
			fileName=rs.getString(2);
			fileType=rs.getString(3);
			date=rs.getString(4);
		    
%>
			<tr align="center">
				<td><input name="chk" type="checkbox" value="<%=id%>"></td>
						<td><%=fileName%></td>
						<td><%=fileType%></td>
						<td><%=date%></td>
						
			</tr>
<%
		}
    }

%>
  	 </table>
  	 </p>
   </div>
 </form>
   

<div id="pageNavPosition" style="position:absolute;top:380px;left:600px"></div>
<script type="text/javascript"><!--
        var pager = new Pager('results',5); 
        pager.init(); 
        pager.showPageNav('pager', 'pageNavPosition'); 
        pager.showPage(1);
    //--></script>

<%
	
	if(Utility.parse(request.getParameter("no1"))==1)
	{
		%>
			<div class="error" id="message" style="position:absolute;top:5px;left:50px">	
				<p>Opps,Select atleast one checkbox !</p>
			</div>
		<%
	}
	if(Utility.parse(request.getParameter("no1"))==2)
	{
		%>
			<div class="error" id="message" style="position:absolute;top:5px;left:50px">	
				<p>Opps,Select only one checkbox to edit!</p>
			</div>
		<%
	}
	if(Utility.parse(request.getParameter("no1"))==3)
	{
		%>
			<div class="success" id="message" style="position:absolute;top:5px;left:50px">	
				<p>Upload Details Deleted successfully ..!</p>
			</div>
		<%
	}
}
%>
</body>
</html>


