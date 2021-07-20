<%@ page language="java" import="java.util.*"  contentType="text/html;charset=gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML><HEAD>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<STYLE>TD {
	FONT-SIZE: 12px; COLOR: #ffffff; FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif
}
</STYLE>

<META content="MSHTML 6.00.2900.3243" name=GENERATOR></HEAD>
<%
	String username=(String)session.getAttribute("user");
	if(username==null){
		response.sendRedirect(basePath+"error.jsp");
	}
	else{
%>
<BODY  oncontextmenu="return false;" onselectstart="return false;" leftMargin=0 topMargin=0 scroll=no marginheight="0" marginwidth="0">
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD bgColor="#73a3d4" height=34 align="center">Copyright 2021 药品管理 by ZengQY&XiaoYu,All Rights Reserved
    </TD>
  </TR>
  </TBODY>
</TABLE>
</BODY>
<%} %>
</HTML>
