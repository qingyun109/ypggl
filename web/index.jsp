<%@ page language="java" import="java.util.*" contentType="text/html;charset=gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML><HEAD><TITLE>医药信息管理系统</TITLE>
    <META http-equiv=Content-Type content="text/html; charset=gb2312">
    <META content="MSHTML 6.00.2900.3268" name=GENERATOR>
    <STYLE type=text/css>TD {
        FONT-SIZE: 12px;Font-color: #000000; VERTICAL-ALIGN: top; COLOR: #000000;
    }
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
<BODY bgColor=#ccdff6 leftMargin=0 topMargin=0 marginwidth="0" marginheight="0">
<form action="<%=basePath %>Admin.shtml" name=form1 method=post onSubmit="return checkform(form1)" autocomplete="off">
    <TABLE cellSpacing=0 cellPadding="0" width="100%" border=0>
        <TBODY>
        <TR>
            <TD height=600 align="center"><BR><BR><BR><BR>
                <h2 color=#770303">医药信息管理系统</h2>
                <br>

                <TABLE class=tableborder cellSpacing="0" cellPadding=0 width=427
                       align=center border=0>
                    <TBODY>
                    <TR>
                        <TD background=images/index_hz01.gif colSpan=3
                            height=64>  </TD></TR>
                    <TR>
                        <TD style="FONT-SIZE: 1px; LINE-HEIGHT: 1px" width=3
                            background=images/index_hz02.gif></TD>
                        <TD style="BORDER-TOP: #666666 1px double" vAlign=top
                            background=images/index_hz02.gif height=162><BR><BR><!--
-->
                            <TABLE id=adminlogin cellSpacing="5" cellPadding="0" width="100%"
                                   align=center border=0>
                                <TBODY>
                                <TR>
                                    <TD class=td align=right width="33%">帐    号:</TD>
                                    <TD class=td width="67%"><INPUT
                                            style="BORDER-RIGHT: #0d5c95 1px solid; BORDER-TOP: #0d5c95 1px solid; BACKGROUND: #fff; BORDER-LEFT: #0d5c95 1px solid; WIDTH: 140px; BORDER-BOTTOM: #fff 1px solid; HEIGHT: 21px"
                                            name=username> </TD></TR>
                                <TR><TD></TD> </TR>
                                <TR>
                                    <TD class=td align=right width="33%">密    码:<input type=hidden name=method value="one" /></TD>
                                    <TD class=td width="67%"><INPUT
                                            style="BORDER-RIGHT: #0d5c95 1px solid; BORDER-TOP: #0d5c95 1px solid; BACKGROUND: #fff; BORDER-LEFT: #0d5c95 1px solid; WIDTH: 140px; BORDER-BOTTOM: #0fff 1px solid; HEIGHT: 21px"
                                            type=password size=21 name=password> </TD></TR><!---->
                                <TR>
                                    <TD class=td width="33%"> </TD>
                                    <TD class=td width="67%"><INPUT type=image height=33 width=83
                                                                    src="images/index_hz04.gif" name=Submit>
                                    </TD></TR>
                                </TBODY>
                            </TABLE>
                        </TD>
                        <TD style="FONT-SIZE: 1px; LINE-HEIGHT: 1px" width=3
                            background=images/index_hz02.gif>

                        </TD>
                    </TR>
                    <TR>
                        <TD background=images/index_hz05.gif colSpan=3
                            height=65>&nbsp;
                        </TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE></FORM></BODY></HTML>
<script language=Javascript>

    form1.username.focus()

    function checkform(form)
    {
        var flag=true;
        if(form("username").value==""){alert("请输入用户名!");form("username").focus();return false};
        if(form("password").value==""){alert("请输入口令!");form("password").focus();return false};
        return flag;
    }
</script>