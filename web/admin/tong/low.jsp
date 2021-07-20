<%@ page language="java" import="java.util.*"  contentType="text/html;charset=gb2312"%>
<%@ page import="main.java.com.bean.*" %>
<jsp:useBean id="yb" scope="page" class="main.java.com.bean.YaoBean" />
<jsp:useBean id="sn" scope="page" class="main.java.com.bean.SystemBean" />
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String dir=sn.getDir();
%>
<HTML><HEAD><TITLE>后台操作区</TITLE>
<LINK href="<%=basePath %><%=dir %>/images/Admin_Style.css" type=text/css rel=stylesheet>
<LINK href="<%=basePath %><%=dir %>/images/style.css" type=text/css rel=stylesheet>
<SCRIPT language=JavaScript src="<%=basePath %><%=dir %>/images/Common.js"></SCRIPT>
<SCRIPT language=JavaScript src="<%=basePath %>/images/calendar.js"></SCRIPT>
<STYLE type=text/css>
BODY {
	MARGIN-LEFT: 0px; BACKGROUND-COLOR: #ffffff
}
.STYLE1 {color: #ECE9D8}
</STYLE>
</HEAD>
<script type="text/javascript">
function jiancha()
{
	if(document.form1.num.value=="")
	{
		alert("请输入最低药品保有量！");	
		return false;
	}
}
</script>
<%
String message = (String)request.getAttribute("message");
	if(message == null){
		message = "";
	}
	if (!message.trim().equals("")){
		out.println("<script language='javascript'>");
		out.println("alert('"+message+"');");
		out.println("</script>");
	}
	request.removeAttribute("message");
%>
<%
	String username=(String)session.getAttribute("user");
	if(username==null){
		response.sendRedirect(path+"/error.jsp");
	}
	else{
		int num=yb.getLow();
%>
<!-- 药品进货管理（如 药品名，类别，剂型，单位，进价，售价，数量，总金额，进货日期，产品批号，产地，有效期等），到期日期（用来做过期药品清单） -->
<BODY >

<form action=<%=basePath %>YaoServlet?method=low method=post name=form1 onsubmit="return jiancha()">
		<TABLE width="100%" border=0 align="center" cellPadding=3 cellSpacing=1 class=tablewidth>
		  <TBODY>
		  <TR align="center">
			<TD height=23>药品最低保有量：
			<input type=text name=num value=<%=num %>  onkeyup="this.value=this.value.replace(/\D/gi,'')">
			<input type=submit value="提交">
			</TD>
		  </TR>
</TBODY>
</TABLE>
</form>
</BODY>
<%} %>

</HTML>
