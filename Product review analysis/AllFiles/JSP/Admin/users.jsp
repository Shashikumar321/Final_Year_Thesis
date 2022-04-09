<%@ page import="java.sql.*" %>
<html>
<head>
<%
	ResultSet rs=(ResultSet)request.getAttribute("rs");
	/* int id=0,cell=0;String userid="",name="",city="",mail="",add="",state=""; */
	int id=0; String userid="",name="",city="",mail="",add="",state="",cell="";
%>
<style>
p 
{
	font-family: monospace;
	font-style: italic;
	font-variant: normal;
	font-weight: bolder;
	font-size: medium;
	line-height: 200%;
	word-spacing: 1.5ex;
	letter-spacing: 0.1ex;
	text-transform: capitalize;
	text-indent: 0ex;
	text-align:center;
	
	
} 
div
{
	border-top-style:dotted;
	border-right-style:solid;
	border-bottom-style:dotted;
	border-left-style:solid;
}
</style>
<link rel="stylesheet" href="<%=request.getContextPath() %>/Files1/CSS/button.css" type="text/css"/>
</head>
<body>
<center>
</br>
</br>
</br>
</br>
</br>
<form method="post" action="<%=request.getContextPath()%>/Add" enctype="multipart/form-data">
Enter Product Name<input type="text" name="product" >
</br>
</br>
</br>
</br>
<input type="file" name="reviewfile" value="Choosefile">
</br>
</br>
</br>
</br>
</br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="submit"  value="ADDREVIEW">

</form>
</center>
</body>
</html>