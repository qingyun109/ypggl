<%@ page language="java" import="java.util.*"  contentType="text/html;charset=gb2312"%>
<%@ page import="main.java.com.bean.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <STYLE type=text/css>
        BODY {
            MARGIN-LEFT: 0px; BACKGROUND-COLOR: #ffffff
        }
        .STYLE1 {color: #ECE9D8}
    </STYLE>
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
%>
<BODY oncontextmenu="return false;" onselectstart="return false;" leftMargin=0 background=<%=basePath %><%=dir %>/images/MainBg.gif topMargin=0 scroll=no marginheight="0" marginwidth="0">
<c:choose>
    <c:when test="${not empty requestScope.mlist}">
        <TABLE width="100%" border=0 align="center" cellPadding="3" cellSpacing="1" class=tablewidth>
            <TBODY>
            <TR align="center" class=head>
                <TD height=23>序号</TD>
                <TD>代码</TD>
                <TD>药品名称</TD>
                <TD>药品产地</TD>
                <TD>药品功效</TD>
            </TR>
            <c:forEach items="${requestScope.mlist}" var="medicine">
                <tr>
                    <td>${medicine.id}</td>
                    <td>${medicine.ypmc}</td>
                    <td>${medicine.ypph}</td>
                    <td>${medicine.ypcd}</td>
                    <td>${medicine.ypjx}</td>
                </tr>
            </c:forEach>
            </TBODY>
        </TABLE>
    </c:when>
    <c:otherwise>
        <TABLE width="100%" border=0 align="center" cellPadding="3" cellSpacing="1" class=tablewidth>
            <TBODY>
            <TR align="center" >
                <TD align="center"><h1>本药店暂无您所查找的药品</h1></TD>
            </TR>
            </TBODY>
        </TABLE>
    </c:otherwise>
</c:choose>
</BODY>
<%} %>
</HTML>

