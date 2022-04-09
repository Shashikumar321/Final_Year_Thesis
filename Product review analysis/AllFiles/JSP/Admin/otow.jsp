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
    int id=0,proid=0,oppairvalue=0;
	String ot,ow;
	
	AdminDAO adminDAO = AdminDAO.getInstance();
	
%>	

<div  align="right" style="position:absolute;top:50px;left:25px;width: 600px;height: 300px;">
			
<p>

	<table border="1"  id="results"  cellpadding="5px" cellspacing="1px" width="500px">
		
		<tr>
			
			<td colspan="6" align="center">
			<font color="maroon" style="font-style: bold;font-family: monotype corsiva" size="6">Opinion Target and Opinion Word Details</font>
			</td>
									
		</tr>
							
		
		<tr>
			<th><font color="blue" size="" style="font-family: cursive;">ID</font></th>
			<th><font color="blue" size="" style="font-family: cursive;">OpinionTarget</font></th>
			<th><font color="blue" size="" style="font-family: cursive;">OpinionWord</font></th>
			<th><font color="blue" size="" style="font-family: cursive;">Pro_Id</font></th>
				<th><font color="blue" size="" style="font-family: cursive;">Op_Pair_Value</font></th>
		</tr>

<% 
	
    if(rs != null)
    {
	    while(rs.next())
		{
			id=rs.getInt(1);
			ot=rs.getString(2);
			ow=rs.getString(3);
			proid=rs.getInt(4);
			oppairvalue=rs.getInt(5);
			
%>
			<tr align="center">
						<td><%=id%></td>
						<td><%=ot%></td>
						<td><%=ow%></td>
						<td><%=proid%></td>
						<td><%=oppairvalue%></td>
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

</body>
</html>


