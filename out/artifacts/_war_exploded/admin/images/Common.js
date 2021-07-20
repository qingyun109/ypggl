//
function ResumeError()
 {
        return true;
    }
window.onerror = ResumeError;


//验证增加管理员
function checkUser()
{
	if(document.form1.add.checked)
	{
		if(document.form1.username.value=="")
		{
			alert("请输入管理员名！");
			document.form1.username.focus();
			return false;
		}
		if(document.form1.username.value.length<6||document.form1.username.value.length>10)
		{
			alert("管理员名在6-10位之间！");
			document.form1.username.focus();
			return false;
		}
		if(document.form1.password.value=="")
		{
			alert("请输入管理员登录密码！");
			document.form1.password.focus();
			return false;
		}
		if(document.form1.password.value.length<6||document.form1.password.value.length>16)
		{
			alert("密码在6-16位之间！");
			document.form1.password.focus();
			return false;
		}
		if(document.form1.isuse.value=="")
		{
			alert("请选择设定状态！");
			document.form1.isuse.focus();
			return false;
		}
		document.form1.ra.value="add";
	}
	if(document.form1.update.checked)
	{
		if(document.form1.password.value!="")
		{
			if(document.form1.password.value.length<6||document.form1.password.value.length>16)
			{
				alert("密码在6-16位之间！");
				document.form1.password.focus();
				return false;
			}
		}	
		if(document.form1.isuse.value=="")
		{
			alert("请选择设定状态！");
			document.form1.isuse.focus();
			return false;
		}
		document.form1.ra.value="update";
	}
}
//验证修改管理员密码
function checkPWD()
{
	if(document.form1.oldpwd.value=="")
	{
		alert("请输入旧密码！");
		document.form1.oldpwd.focus();
		return false;
	}
	if(document.form1.newpwd.value=="")
	{
		alert("请输入新密码！");
		document.form1.newpwd.focus();
		return false;
	}
	if(document.form1.newpwd.value.length<6||document.form1.newpwd.value.length>16)
	{
		alert("密码为6-16位之间！");
		document.form1.newpwd.focus();
		return false;
	}
	if(document.form1.repwd.value=="")
	{
		alert("请确认密码！");
		document.form1.repwd.focus();
		return false;
	}
	if(document.form1.repwd.value!=document.form1.newpwd.value)
	{
		alert("对不起，两次输入的密码不相同，请确认密码！");
		document.form1.repwd.focus();
		return false;
	}
}


function OnclikeTable(tr){

	var frm = document.form1[0];
	var vlu = new Array();
	for( i = 0 ; i < 6 ; i++ ){
		vlu[i] = tr.childNodes[i].childNodes[0].nodeValue;
		if(vlu[i]==null){
			vlu[i] = "";
		}
	}
	form1.username.value = vlu[1];
	form1.username.readonly=true;
	//alert(vlu[3]);
	form1.isuse.value = vlu[3];
	form1.add.checked=false;
	form1.add.disabled=true;
	form1.update.checked=true;
	form1.update.disabled=false;
}

function CheckErrorStr(CharAsciiCode)
{
	var TempArray=new Array(34,47,92,42,58,60,62,63,124);
	for (var i=0;i<TempArray.length;i++)
	{
		if (CharAsciiCode==TempArray[i]) return false;
	}
	return true;
}

