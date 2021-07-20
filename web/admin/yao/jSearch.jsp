<%--
  Created by IntelliJ IDEA.
  User: 39471
  Date: 2020/12/31
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*,main.java.com.util.*"  contentType="text/html;charset=gb2312"%>
<%@ page import="main.java.com.bean.*" %>
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
<script type="text/javascript">
    function check()
    {
        if(document.form1.mname.value=="")
        {
            alert("请填写名称！");
            document.form1.mname.focus();
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
        String ypph=Common.toChineseAndTrim(request.getParameter("ypph"));

%>
<BODY oncontextmenu="return false;" onselectstart="return false;" leftMargin=0 background=<%=basePath %><%=dir %>/images/MainBg.gif topMargin=0 scroll=no marginheight="0" marginwidth="0">
<TABLE width="100%" border=0 align="center" cellPadding=3 cellSpacing=1 class=tablewidth>
    <TBODY>
    <TR align="center" class=head>
        <TD height=23>数据录入 所有项目必须填写</TD>
    </TR>
    <TR align="center" >
        <TD >
            <form name="form1" action="<%=basePath %>YaoServlet" method="post" onsubmit="return check()">
                <TABLE width="100%" border=0 align="center" cellPadding=3 cellSpacing=1 >
                    <TBODY>
                    <TR  align="center" bgColor=#ffffff>
                        <TD width=40% id=map align=right>需要搜索的药品名称：
                            <input type=hidden name=method value=<%=method %>>
                            <input type=hidden name=id value=<%=id%>></TD>
                        <TD align=left><input type=text size=30 maxlength=50 name=ypph value=<%=ypph %>> </TD>

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

