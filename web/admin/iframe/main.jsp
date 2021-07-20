<%@ page language="java" import="java.util.*"  contentType="text/html;charset=gb2312"%>
<jsp:useBean id="sn" scope="page" class="main.java.com.bean.SystemBean" />
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String dir=sn.getDir();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>后台操作区</TITLE>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<LINK href="<%=basePath %><%=dir %>/images/Admin_Style.css" type=text/css rel=stylesheet>
<LINK href="<%=basePath %><%=dir %>/images/style.css" type=text/css rel=stylesheet>
<SCRIPT language=JavaScript src="<%=basePath %><%=dir %>/images/Common.js"></SCRIPT>
<STYLE type=text/css>BODY {
	MARGIN-LEFT: 0px; BACKGROUND-COLOR: #ffffff
}
</STYLE>
<META content="MSHTML 6.00.2900.3243" name=GENERATOR>
</HEAD>
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
		List list2 = sn.getSiteInfo();
	    String str = list2.get(0).toString();
%>

<BODY  oncontextmenu="return false;" onselectstart="return false;" leftMargin=0 background=<%=basePath %><%=dir %>/images/MainBg.gif topMargin=0 scroll=no marginheight="0" marginwidth="0">
<TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD vAlign=top height="50%">
            <TABLE class=topdashed cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD height=25>&nbsp;&nbsp;<span style="color: red; "><%=list.get(0).toString() %></span>
                  您好，欢迎进入[<FONT color=red><%=str %></FONT>]网站后台管理系统！您的身份：<span
							style="color: red; "><%=Integer.parseInt(list.get(1).toString())==1?"超级管理员":"普通管理员"%></span> 登录次数：<%=list.get(2).toString() %>次 本次登录时间：<%=list.get(3).toString() %>
                </TD>
              </TR>
              </TBODY>
            </TABLE>
		医药信息后台管理人员注意事项:</br>
		1、严格按照计算机使用管理操作规程进行操作，系统开机按先外设后主机的顺序，关机时先关主机，后关外设。</br>
		2、认真准确、及时地做好本站责任范围内各项数据和信息的汇集、录入、核对、确认、打印及执行工作。</br>
		3、严格落实现任责任制和数据安全保护措施，定期更改用户登录密码。</br>
		4、严禁安装和使用非医院信息工程系统应用软件；确属工作需要安装使用其他软件，必须经信息中心负责人批准，由信息工程技术人员负责安装调试。</br>
		5、严禁私自拆、卸计算机设备和网络、其他网络设备和设施，出现故障及时与信息工程技术人员联系解决。</br>
		6、不得私自带领外单位人员参观、演示操作网络系统软件；必须参观者须逐级报请科室负责人和信息中心负责人以及医务处领导批准。</br>
		7、禁止非本科室工作人员操作使用计算，任何人都不准在计算机上进行非工作性操作</br>
		8、切实执行网络设备维护保养制度，保持计算机及其场所的清洁卫生。</br>
		9、严格遵守医院有关信息系统规章制度，确保网络安全、正常有序运行。</br>
		10、工作中遇到技术性问题，及时与信息工程技术组联系。</br>

</TD>
</TR>
</TBODY>
</TABLE>
</BODY>
<%} %>
</HTML>
