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
<TITLE>��̨������</TITLE>
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
                  ���ã���ӭ����[<FONT color=red><%=str %></FONT>]��վ��̨����ϵͳ��������ݣ�<span
							style="color: red; "><%=Integer.parseInt(list.get(1).toString())==1?"��������Ա":"��ͨ����Ա"%></span> ��¼������<%=list.get(2).toString() %>�� ���ε�¼ʱ�䣺<%=list.get(3).toString() %>
                </TD>
              </TR>
              </TBODY>
            </TABLE>
		ҽҩ��Ϣ��̨������Աע������:</br>
		1���ϸ��ռ����ʹ�ù��������̽��в�����ϵͳ�������������������˳�򣬹ػ�ʱ�ȹ�������������衣</br>
		2������׼ȷ����ʱ�����ñ�վ���η�Χ�ڸ������ݺ���Ϣ�Ļ㼯��¼�롢�˶ԡ�ȷ�ϡ���ӡ��ִ�й�����</br>
		3���ϸ���ʵ���������ƺ����ݰ�ȫ������ʩ�����ڸ����û���¼���롣</br>
		4���Ͻ���װ��ʹ�÷�ҽԺ��Ϣ����ϵͳӦ�������ȷ��������Ҫ��װʹ��������������뾭��Ϣ���ĸ�������׼������Ϣ���̼�����Ա����װ���ԡ�</br>
		5���Ͻ�˽�Բ�ж������豸�����硢���������豸����ʩ�����ֹ��ϼ�ʱ����Ϣ���̼�����Ա��ϵ�����</br>
		6������˽�Դ����ⵥλ��Ա�ιۡ���ʾ��������ϵͳ���������ι������𼶱�����Ҹ����˺���Ϣ���ĸ������Լ�ҽ���쵼��׼��</br>
		7����ֹ�Ǳ����ҹ�����Ա����ʹ�ü��㣬�κ��˶���׼�ڼ�����Ͻ��зǹ����Բ���</br>
		8����ʵִ�������豸ά�������ƶȣ����ּ�������䳡�������������</br>
		9���ϸ�����ҽԺ�й���Ϣϵͳ�����ƶȣ�ȷ�����簲ȫ�������������С�</br>
		10���������������������⣬��ʱ����Ϣ���̼�������ϵ��</br>

</TD>
</TR>
</TBODY>
</TABLE>
</BODY>
<%} %>
</HTML>
