

<!DOCTYPE html>
<html lang="en">
<head>
<link href='http://fonts.googleapis.com/css?family=Droid+Sans' rel='stylesheet' type='text/css'>
<meta charset="utf-8">
<title>Home Page</title>
<link href="<%=request.getContextPath()%>/AllFiles/CSS/home_style.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/iconic.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/AllFiles/JS/prefix-free.js"></script>

  <%
  HttpSession hs = request.getSession();
String id = session.getAttribute("admin").toString();
%>
</head>

<body background="<%=request.getContextPath()%>/AllFiles/Images/back.jpg" >
<img src="<%=request.getContextPath()%>/AllFiles/Images/3.png" width="1300" height="100"></img> 

 <div class="wrap">
 
  <nav> 
<ul class="menu"> 
	<%-- 
	<li><a href="<%=request.getContextPath()%>/Category?submit=get" target="home"><span class=""></span> Category</a></li>
	 --%>
	<li><a href="<%=request.getContextPath()%>/AllFiles/JSP/Admin/users.jsp" target="home"><span class=""></span>Add_Review</a></li>
	<li><a href="<%=request.getContextPath()%>/ReviewList?submit=get" target="home"><span class=""></span>View_Reviews</a></li>
	 <li><a href="<%=request.getContextPath() %>/ChangePass?name=<%=id%>&no=1&id=<%=id %>" target="home">Change Password</a></li><li></li>
	<%-- <li><a href="<%=request.getContextPath()%>/Extract" target="home"><span class=""></span> OT-OW Extraction</a></li> --%>
	
	<%-- <li><a href="<%=request.getContextPath()%>/AllFiles/JSP/Admin/files.jsp" target="home"><span class=""></span>OT-OW Extraction</a></li> --%>
	
	<%-- <li><a href="<%=request.getContextPath()%>/OTOWList?submit=get" target="home"><span class=""></span>View OT-OW </a></li> --%>
	
	<li><a href="<%=request.getContextPath()%>/Logout"><span class=""></span> Logout</a></li>
	</ul>
<div class="clearfix"></div>
</nav></div>

<div style="position: absolute;left: 250px;width: 750px;height: 500px;top: 150px;">

<iframe style="position: absolute;width: 750px;height: 500px;" name="home"></iframe>

</div>
</body>

</html>