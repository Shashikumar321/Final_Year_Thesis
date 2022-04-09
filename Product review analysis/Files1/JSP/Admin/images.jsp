<%@ page import="java.util.*" %>
<html>
<head>

<%! 
public int convert(String str) 
{ 
	int conv=0; 
	if(str==null) 
	{ 
		str="0"; 
	} 
	else if((str.trim()).equals("null")) 
	{ 
		str="0"; 
	} 
	else if(str.equals("")) 
	{ 
		str="0"; 
	} 
	try
	{ 
		conv=Integer.parseInt(str); 
	} 
	catch(Exception e) 
	{ 
	} 
	return conv; 
	} 
%>
<script type="text/javascript">
function hideMessage()
{
	document.getElementById("message").style.display="none"; 
}
function startTimer() 
{
	var tim = window.setTimeout("hideMessage()", 5000);  // 5000 milliseconds = 5 seconds
}
</script>
<%
	Vector v=(Vector)request.getAttribute("v");
	Vector v1=(Vector)request.getAttribute("v1");
%>

<link href="<%=request.getContextPath() %>/Files/CSS/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/Files/CSS/button.css" type="text/css"/>
<script type="text/javascript" src="<%=request.getContextPath() %>/Files/JS/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="./fancybox/jquery.fancybox-1.3.4.pack.js"></script>
<link rel="stylesheet" type="text/css" href="./fancybox/jquery.fancybox-1.3.4.css" media="screen" />
<script type="text/javascript">
$(document).ready(function(){
	$('ul.hover_block li').hover(function(){
		$(this).find('a').animate({top:'10px'},{queue:false,duration:500});
	}, function(){
		$(this).find('a').animate({top:'-10000px'},{queue:false,duration:500});
	});
	$("a#load").fancybox({
		'overlayShow'	: true,
		'transitionIn'	: 'elastic',
		'transitionOut'	: 'elastic'
	});
});
</script>
<style type="text/css">
	ul.hover_block li{
			list-style:none;
			float:left;
			width:100px; position: relative;
			margin-right: 20px; }

		ul.hover_block li a {
			display: block;
			position: relative;
			overflow: hidden;
			height: 150px;
			width: 268px;
			padding: 16px;
			color:white;
			font: 1.0em/1.3 Helvetica, Arial, sans-serif;
		}

		ul.hover_block li a 
		{ 
		text-decoration: none;
			position: absolute;
			top: -10000px;
			left: -25px;
			border: 0; 
			}
</style>
<style type="text/css">
.nits {
	-moz-box-shadow:inset 0px 0px 0px 0px #b5ccaa;
	-webkit-box-shadow:inset 0px 0px 0px 0px #b5ccaa;
	box-shadow:inset 0px 0px 0px 0px #b5ccaa;
	background-color:#a6a4eb;
	-moz-border-radius:20px;
	-webkit-border-radius:20px;
	border-radius:20px;
	border:2px solid #f5f5f5;
	display:inline-block;
	color:#fcfcfc;
	font-family:arial;
	font-size:17px;
	font-weight:bold;
	padding:8px 11px;
	text-decoration:none;
	text-shadow:1px 0px 3px #000000;
}.nits:hover {
	background-color:#d46a84;
}.nits:active {
	position:relative;
	top:1px;
}

</style>
</head>
<%
int no=convert(request.getParameter("no"));
if(no==1)
{%>
<div class="gradientbuttons" id="message" style="position:absolute;top:10px;left:280px">
	<p>Image Updated Succeefully...!!</p>
</div>
<%}
if(no==2)
{%>
<div class="gradientbuttons" id="message" style="position:absolute;top:10px;left:280px">
	<p>OOP's Something Went Wrong ...!!</p>
</div>
<%}%>
<body onload="startTimer()">
<ul class="hover_block">
<%
	for(int i=0;i<v.size();i++)
	{
		%>	<li>
			<a href="/">
			<a id="load" href="<%=request.getContextPath() %>/Files/JSP/Admin/changeimg.jsp?name=<%=((String)v.get(i)).charAt(0) %><%=((String)v.get(i)).charAt(1) %>">
				<div class="nits">Change ?</div>
			</a>
			<img border="1" height="80" width="80" src="<%=request.getContextPath() %>/Files/Pimages/<%=v.get(i) %>">&nbsp;</a>
			</li>
		<%
	}
%>
<%
	for(int i=0;i<v1.size();i++)
	{
		%>
			<li>
			<a href="/">
			<a id="load" href="<%=request.getContextPath() %>/Files/JSP/Admin/changeimg.jsp?name=<%=((String)v1.get(i)).charAt(0) %>">
				<div class="nits">Change ?</div>
			</a>
			<img border="1" height="80" width="80" src="<%=request.getContextPath() %>/Files/Pimages/<%=v1.get(i) %>">&nbsp;
			</a>
		<%
	}
%>
</ul>
</body>
</html>
