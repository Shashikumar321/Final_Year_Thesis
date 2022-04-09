package org.apache.jsp.AllFiles.JSP.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class adminhome_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

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
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("<link href='http://fonts.googleapis.com/css?family=Droid+Sans' rel='stylesheet' type='text/css'>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<title>Home Page</title>\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath());
      out.write("/AllFiles/CSS/home_style.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath());
      out.write("/iconic.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath());
      out.write("/AllFiles/JS/prefix-free.js\"></script>\r\n");
      out.write("\r\n");
      out.write("  ");

  HttpSession hs = request.getSession();
String id = session.getAttribute("admin").toString();

      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body background=\"");
      out.print(request.getContextPath());
      out.write("/AllFiles/Images/back.jpg\" >\r\n");
      out.write("<img src=\"");
      out.print(request.getContextPath());
      out.write("/AllFiles/Images/3.png\" width=\"1300\" height=\"100\"></img> \r\n");
      out.write("\r\n");
      out.write(" <div class=\"wrap\">\r\n");
      out.write(" \r\n");
      out.write("  <nav> \r\n");
      out.write("<ul class=\"menu\"> \r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("\t<li><a href=\"");
      out.print(request.getContextPath());
      out.write("/AllFiles/JSP/Admin/users.jsp\" target=\"home\"><span class=\"\"></span>Add_Review</a></li>\r\n");
      out.write("\t<li><a href=\"");
      out.print(request.getContextPath());
      out.write("/ReviewList?submit=get\" target=\"home\"><span class=\"\"></span>View_Reviews</a></li>\r\n");
      out.write("\t <li><a href=\"");
      out.print(request.getContextPath() );
      out.write("/ChangePass?name=");
      out.print(id);
      out.write("&no=1&id=");
      out.print(id );
      out.write("\" target=\"home\">Change Password</a></li><li></li>\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<li><a href=\"");
      out.print(request.getContextPath());
      out.write("/Logout\"><span class=\"\"></span> Logout</a></li>\r\n");
      out.write("\t</ul>\r\n");
      out.write("<div class=\"clearfix\"></div>\r\n");
      out.write("</nav></div>\r\n");
      out.write("\r\n");
      out.write("<div style=\"position: absolute;left: 250px;width: 750px;height: 500px;top: 150px;\">\r\n");
      out.write("\r\n");
      out.write("<iframe style=\"position: absolute;width: 750px;height: 500px;\" name=\"home\"></iframe>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
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
