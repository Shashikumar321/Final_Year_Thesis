package org.apache.jsp.AllFiles.JSP.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class users_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\r\n");
      out.write("<head>\r\n");

	ResultSet rs=(ResultSet)request.getAttribute("rs");
	/* int id=0,cell=0;String userid="",name="",city="",mail="",add="",state=""; */
	int id=0; String userid="",name="",city="",mail="",add="",state="",cell="";

      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("p \r\n");
      out.write("{\r\n");
      out.write("\tfont-family: monospace;\r\n");
      out.write("\tfont-style: italic;\r\n");
      out.write("\tfont-variant: normal;\r\n");
      out.write("\tfont-weight: bolder;\r\n");
      out.write("\tfont-size: medium;\r\n");
      out.write("\tline-height: 200%;\r\n");
      out.write("\tword-spacing: 1.5ex;\r\n");
      out.write("\tletter-spacing: 0.1ex;\r\n");
      out.write("\ttext-transform: capitalize;\r\n");
      out.write("\ttext-indent: 0ex;\r\n");
      out.write("\ttext-align:center;\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("} \r\n");
      out.write("div\r\n");
      out.write("{\r\n");
      out.write("\tborder-top-style:dotted;\r\n");
      out.write("\tborder-right-style:solid;\r\n");
      out.write("\tborder-bottom-style:dotted;\r\n");
      out.write("\tborder-left-style:solid;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/Files1/CSS/button.css\" type=\"text/css\"/>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<center>\r\n");
      out.write("</br>\r\n");
      out.write("</br>\r\n");
      out.write("</br>\r\n");
      out.write("</br>\r\n");
      out.write("</br>\r\n");
      out.write("<form method=\"post\" action=\"");
      out.print(request.getContextPath());
      out.write("/Add\" enctype=\"multipart/form-data\">\r\n");
      out.write("Enter Product Name<input type=\"text\" name=\"product\" >\r\n");
      out.write("</br>\r\n");
      out.write("</br>\r\n");
      out.write("</br>\r\n");
      out.write("</br>\r\n");
      out.write("<input type=\"file\" name=\"reviewfile\" value=\"Choosefile\">\r\n");
      out.write("</br>\r\n");
      out.write("</br>\r\n");
      out.write("</br>\r\n");
      out.write("</br>\r\n");
      out.write("</br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("<input type=\"submit\"  value=\"ADDREVIEW\">\r\n");
      out.write("\r\n");
      out.write("</form>\r\n");
      out.write("</center>\r\n");
      out.write("</body>\r\n");
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
