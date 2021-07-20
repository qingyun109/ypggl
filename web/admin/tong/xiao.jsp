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
	if(document.form1.stime.value==""||document.form1.etime.value=="")
	{
		alert("请输入起始和截止时间！");	
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
		List list=(List)session.getAttribute("list");
		List list2=yb.getAllSaleMedicine();
%>
<!-- 药品进货管理（如 药品名，类别，剂型，单位，进价，售价，数量，总金额，进货日期，产品批号，产地，有效期等），到期日期（用来做过期药品清单） -->
<BODY >
<style media=print>
	.Noprint{display:none;}<!--用本样式在打印时隐藏非打印项目-->
							   .PageNext{page-break-after: always;}<!--控制分页-->
</style>
<object id="WebBrowser" width=0 height=0 classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2">
</object>
<form action=<%=basePath %>admin/tong/search.jsp method=post name=form1 onSubmit="return jiancha()">
	<TABLE width="100%" border=0 align="center" cellPadding=3 cellSpacing=1 class=tablewidth>
		<TBODY>
		<TR align="center">
			<TD height=23>开始日期：
				<input type=text name=stime  onclick="SelectDate(this,'yyyy-MM-dd')" >
				截至日期：<input type=text name=etime  onclick="SelectDate(this,'yyyy-MM-dd')" >
				<input type=submit value="查询">
			</TD>
		</TR>
		</TBODY>
	</TABLE>
</form>
<TABLE width="100%" border=0 align="center" cellPadding=3 cellSpacing=1 class=tablewidth>
	<TBODY>
	<TR align="center" class=head>
		<TD height=23>序号</TD>
		<TD>药品编号</TD>
		<TD>售价</TD>
		<TD>数量</TD>
		<TD>总金额</TD>
		<TD>销售日期</TD>
		<TD>修改</TD>
		<TD>删除</TD>
	</TR>
	<%
		if(list2.size()!=0){
			for(int i = 0; i<list2.size(); i++){
				List list3 = (List)list2.get(i);
	%>
	<TR  align="center" bgColor=#ffffff>
		<TD width="30" id=map><%=i+1 %></TD>
		<TD id=map><%=list3.get(1).toString() %></TD>
		<TD id=map><%=list3.get(2).toString() %></TD>
		<TD id=map><%=list3.get(3).toString() %></TD>
		<TD id=map><%=Integer.parseInt(list3.get(2).toString().trim())*Integer.parseInt(list3.get(3).toString().trim()) %></TD>
		<TD id=map><%=list3.get(4).toString().substring(0,10) %></TD>
		<TD id=map><a href="<%=basePath %>admin/xiao/edit.jsp?method=upxiao&id=<%=list3.get(0).toString()%>">修改</a></TD>
		<TD id=map><a href="<%=basePath %>YaoServlet?method=delxiao&id=<%=list3.get(0).toString()%>">删除</a></TD>
	</TR>
	<%}}%>
	</TBODY>
</TABLE>
	 
</BODY>
<%} %>

</HTML>
