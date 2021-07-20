<%@ page language="java" import="java.util.*,main.java.com.util.*"  contentType="text/html;charset=gb2312"%>
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
function check()
{
	if(document.form1.ypmc.value==""||document.form1.ypsj.value==""||document.form1.ypsl.value==""||document.form1.xsrq.value=="")
	{
		alert("所有项目必须填写！");
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
	String method=request.getParameter("method").trim();
	String id=request.getParameter("id");
	String ypmc="";String ypsj="";String ypsl="";String xsrq="";
	if(method.equals("upxiao")){
		List list=yb.getOneSaleMedicine(Integer.parseInt(id));
		ypmc=list.get(1).toString();ypsj=list.get(2).toString();ypsl=list.get(3).toString();xsrq=list.get(4).toString().substring(0,10);
		
	}
		
%>
<!-- 药品进货管理（如 药品名，类别，剂型，单位，进价，售价，数量，总金额，进货日期，产品批号，产地，有效期等），到期日期（用来做过期药品清单） -->
<BODY >
	   <TABLE width="100%" border=0 align="center" cellPadding=3 cellSpacing=1 class=tablewidth>
		  <TBODY>
		  <TR align="center" class=head>
			<TD height=23>药品销售管理 所有项目必须填写</TD>
		  </TR>
		  <TR align="center" >
			<TD >
		<form name="form1" action="<%=basePath %>YaoServlet" method="post" onsubmit="return check()">
		  <TABLE width="100%" border=0 align="center" cellPadding=3 cellSpacing=1 >
		  <TBODY>	  
		  <TR  align="center" bgColor=#ffffff>
			<TD width=40% id=map align=right>药品编码：<input type=hidden name=method value=<%=method %>><input type=hidden name=id value=<%=id %>></TD>
			<TD align=left><select name=ypmc>
			<%if(method.equals("upxiao")) {%><option value="<%=ypmc %>"><%=ypmc %></option><%}else{ %>
			<option value="">---请选择---</option><%} %>
			<%List mclist=yb.getAllMc();if(!mclist.isEmpty()){for(int i=0;i<mclist.size();i++){List list2=(List)mclist.get(i); %>
			<option value="<%=list2.get(0).toString() %>"><%=list2.get(0).toString() %></option>
			<%}} %>
			</select>
			 </TD>
		  </TR>
		  
		  <TR  align="center" bgColor=#ffffff>
			<TD width=40% id=map align=right>药品售价：</TD>
			<TD align=left><input type=text size=30 maxlength=50 name=ypsj value="<%=ypsj %>"  onkeyup="this.value=this.value.replace(/\D/gi,'')"> </TD>
		  </TR>
		  <TR  align="center" bgColor=#ffffff>
			<TD width=40% id=map align=right>药品数量：</TD>
			<TD align=left><input type=text size=30 maxlength=50 name=ypsl value="<%=ypsl %>"  onkeyup="this.value=this.value.replace(/\D/gi,'')"> </TD>
		  </TR>
		   <TR  align="center" bgColor=#ffffff>
			<TD width=40% id=map align=right>销售日期：</TD>
			<TD align=left><input type=text size=30 maxlength=50 name=xsrq value="<%=xsrq %>" readonly="readonly" onclick="SelectDate(this,'yyyy-MM-dd')"  > </TD>
		  </TR>
		  <TR  align="center" bgColor=#ffffff>
			<TD colspan=2 align=center><input type=submit value="提交"></TD>
		  </TR>
		  </TBODY>
	   </TABLE>
		  </form>
		  </TD>
		  </TR>
		  </TBODY>
	   </TABLE>
</BODY>
<%} %>

</HTML>
