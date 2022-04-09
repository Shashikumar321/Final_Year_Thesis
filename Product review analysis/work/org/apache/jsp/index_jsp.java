package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.SimpleDateFormat;
import java.util.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 
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

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, false, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<title>co_extracting</title>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/blue.css\">\r\n");
      out.write("\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/AllFiles/CSS/message.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/AllFiles/JS/style.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body  onload=\"startTimer()\" background=\"");
      out.print(request.getContextPath());
      out.write("/AllFiles/Images/back.jpg\">\r\n");
      out.write("<img src=\"");
      out.print(request.getContextPath());
      out.write("/AllFiles/Images/3.png\" width=\"1250\" height=\"100\"></img> \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div style=\"margin-top: 70px;margin-left: 230px;\">\r\n");
      out.write("  \r\n");
      out.write("  <div id=\"container\">\r\n");
      out.write("\t<section class=\"tabs\">\r\n");
      out.write("\t\t<input id=\"tab-1\" type=\"radio\" name=\"radio-set\" class=\"tab-selector-1\" checked=\"checked\" />\r\n");
      out.write("\t\t<span for=\"tab-1\" class=\"tab-label-1\">Admin</span>\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- <input id=\"tab-2\" type=\"radio\" name=\"radio-set\" class=\"tab-selector-2\" />\r\n");
      out.write("\t\t<span for=\"tab-2\" class=\"tab-label-2\">Data Owner</span> -->\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<input id=\"tab-2\" type=\"radio\" name=\"radio-set\" class=\"tab-selector-3\" />\r\n");
      out.write("\t\t<span for=\"tab-2\" class=\"tab-label-3\">User</span>\r\n");
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\r\n");
      out.write("\t\t<div class=\"clear-shadow\"></div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div id=\"content\">\r\n");
      out.write("\t\t\t<div class=\"content-1\">\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t<form  action=\"");
      out.print(request.getContextPath());
      out.write("/AdminLogin\"  method=\"post\">\r\n");
      out.write("\t\t\t\t  <p>\r\n");
      out.write("\t\t\t\t\t<label for=\"usernamesignup\" class=\"uname\" data-icon=\"\">Admin Id</label>\r\n");
      out.write("\t\t\t\t\t<input class=\"field\" name=\"username\" required=\"required\" type=\"text\" placeholder=\"admin id\" />\r\n");
      out.write("\t\t\t\t  </p>\r\n");
      out.write("\t\t\t\t  \r\n");
      out.write("\t\t\t\t  <p>\r\n");
      out.write("\t\t\t\t\t<label for=\"passwordsignup\" class=\"youpasswd\" data-icon=\"\">Password </label>\r\n");
      out.write("\t\t\t\t\t<input class=\"field\" name=\"password\" required=\"required\" type=\"password\" placeholder=\"password\"/>\r\n");
      out.write("\t\t\t\t  </p>\r\n");
      out.write("\t\t\t\t  \r\n");
      out.write("\t\t\t\t  <p class=\"signin button\">\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<input type=\"submit\" value=\"Login\"/>\r\n");
      out.write("\t\t\t\t  </p>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div class=\"content-3\">\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<form  action=\"");
      out.print(request.getContextPath());
      out.write("/UserLogin\" method=\"post\" autocomplete=\"on\">\r\n");
      out.write("\t\t\t\t  <p>\r\n");
      out.write("\t\t\t\t\t<label for=\"username\" class=\"uname\" data-icon=\"\" > User Id </label>\r\n");
      out.write("\t\t\t\t\t<input class=\"field\" name=\"username\" required=\"required\" type=\"text\" placeholder=\"user id\"/>\r\n");
      out.write("\t\t\t\t  </p>\r\n");
      out.write("\t\t\t\t  <p>\r\n");
      out.write("\t\t\t\t\t<label for=\"password\" class=\"youpasswd\" data-icon=\"\"> Password </label>\r\n");
      out.write("\t\t\t\t\t<input class=\"field\" name=\"password\" required=\"required\" type=\"password\" placeholder=\"password\" />\r\n");
      out.write("\t\t\t\t  </p>\r\n");
      out.write("\t\t\t\t  <p class=\"keeplogin\">\r\n");
      out.write("\t\t\t\t\t<a href=\"");
      out.print(request.getContextPath());
      out.write("/AllFiles/JSP/User/newuser.jsp\">\r\n");
      out.write("\t\t\t\t\t<font color=\"#99975C\">User Registration</font></a>\r\n");
      out.write("\t\t\t\t\t<input type=\"submit\" name=\"login\" value=\"Login\" />\r\n");
      out.write("\t\t\t\t  </p>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</section>\r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write(" \r\n");

	int no=convert(request.getParameter("no"));
	if(no==1)
	{
		    

      out.write("       \r\n");
      out.write("    \t\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:130px;left:530px\">\t\r\n");
      out.write("    \t\t\t<p> Enter Username and Password !</p>\r\n");
      out.write("    \t\t</div>\t\r\n");
      out.write("    \t \r\n");

	}
	if(no==2)
	{

      out.write("\r\n");
      out.write("\t\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:130px;left:530px\">\t\r\n");
      out.write("    \t\t\t<p> Please,Enter Your Username.!</p>\r\n");
      out.write("    \t</div>\t\r\n");

	}
	if(no==3)
	{

      out.write("\r\n");
      out.write("\t\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:130px;left:530px\">\t\r\n");
      out.write("    \t\t\t<p> Please,Enter Your Password.!</p>\r\n");
      out.write("    \t</div>\t\r\n");

	}

      out.write('\r');
      out.write('\n');

	if(no==4)
	{

      out.write("\r\n");
      out.write("\t\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:130px;left:530px\">\t\r\n");
      out.write("    \t\t\t<p> Sorry,Invalid Username/Password!</p>\r\n");
      out.write("    \t</div>\t\r\n");

	}

      out.write('\r');
      out.write('\n');

	if(no==5)
	{

      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"success\" id=\"message\" style=\"position:absolute;top:130px;left:530px\">\t\r\n");
      out.write("    \t\t\t<p id=\"message\">You have Logged out successfully...!</p>\r\n");
      out.write("    \t</div>\t\r\n");
      out.write("\t\t\r\n");

	}

      out.write('\r');
      out.write('\n');

	if(no==6)
	{

      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"success\" id=\"message\" style=\"position:absolute;top:130px;left:530px\">\t\r\n");
      out.write("    \t\t\t<p id=\"message\">Your Session Expires...!</p>\r\n");
      out.write("    \t</div>\t\r\n");
      out.write("\t\t\r\n");

	}

      out.write('\r');
      out.write('\n');

	if(no==7)
	{

      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"success\" id=\"message\" style=\"position:absolute;top:130px;left:530px\">\t\r\n");
      out.write("    \t\t\t<p id=\"message\">Your Account Created Successfully...!</p>\r\n");
      out.write("    \t</div>\t\r\n");
      out.write("\t\t\r\n");

	}

      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
