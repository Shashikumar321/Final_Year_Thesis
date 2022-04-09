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
    int id=0,proid=0;
	String catName,review;
	
	AdminDAO adminDAO = AdminDAO.getInstance();
	
%>	
<form>
<br><br><br>
<% 
 if ( session.getAttribute( "waitPage" ) == null ) 
 {
%>
 
<div>
	    	  <center><img src='AllFiles/Images/status_processing.gif'></img><br><br>
	    	   <font color='red'> Please Do not press Back or Refresh button.......<br>  </font>
	    	   </center></div> 
<%
}
%> 
	    	   </form>
<%-- <div  align="right" style="position:absolute;top:50px;left:25px;width: 600px;height: 300px;">
			
<p>

	<table border="1"  id="results"  cellpadding="5px" cellspacing="1px" width="500px">
		
		<tr>
			
			<td colspan="6" align="center">
			<font color="maroon" style="font-style: bold;font-family: monotype corsiva" size="6">Opinion Target and Opinion Word Extract </font>
			</td>
									
		</tr>
							
		
		<tr>
			<th><font color="blue" size="" style="font-family: cursive;">Review ID</font></th>
			<th><font color="blue" size="" style="font-family: cursive;">Product_Id</font></th>
			<th><font color="blue" size="" style="font-family: cursive;">Review</font></th>
			<th><font color="blue" size="" style="font-family: cursive;">Extraction</font></th>
		</tr>

<% 
	
    if(rs != null)
    {
	    while(rs.next())
		{
			id=rs.getInt(1);
			proid=rs.getInt(2);
			review=rs.getString(3);
			
%>
			<tr align="center">
						<td><%=id%></td>
						<td><%=proid%></td>
						<td><%=review%></td>
						<td><a href="<%=request.getContextPath() %>/Extract?id=<%=id%>&proid=<%=proid%>">Extract</a></td>
			</tr>
<%
		}
    
}
%>
  	 </table>
  	 </p>
   </div>
 </form>
   

<div id="pageNavPosition" style="position:absolute;top:350px;left:350px"></div>
<script type="text/javascript"><!--
        var pager = new Pager('results',6); 
        pager.init(); 
        pager.showPageNav('pager', 'pageNavPosition'); 
        pager.showPage(1);
    //--></script>
 --%>
</body>
</html>


