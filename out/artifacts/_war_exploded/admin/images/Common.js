//
function ResumeError()
 {
        return true;
    }
window.onerror = ResumeError;


//��֤���ӹ���Ա
function checkUser()
{
	if(document.form1.add.checked)
	{
		if(document.form1.username.value=="")
		{
			alert("���������Ա����");
			document.form1.username.focus();
			return false;
		}
		if(document.form1.username.value.length<6||document.form1.username.value.length>10)
		{
			alert("����Ա����6-10λ֮�䣡");
			document.form1.username.focus();
			return false;
		}
		if(document.form1.password.value=="")
		{
			alert("���������Ա��¼���룡");
			document.form1.password.focus();
			return false;
		}
		if(document.form1.password.value.length<6||document.form1.password.value.length>16)
		{
			alert("������6-16λ֮�䣡");
			document.form1.password.focus();
			return false;
		}
		if(document.form1.isuse.value=="")
		{
			alert("��ѡ���趨״̬��");
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
				alert("������6-16λ֮�䣡");
				document.form1.password.focus();
				return false;
			}
		}	
		if(document.form1.isuse.value=="")
		{
			alert("��ѡ���趨״̬��");
			document.form1.isuse.focus();
			return false;
		}
		document.form1.ra.value="update";
	}
}
//��֤�޸Ĺ���Ա����
function checkPWD()
{
	if(document.form1.oldpwd.value=="")
	{
		alert("����������룡");
		document.form1.oldpwd.focus();
		return false;
	}
	if(document.form1.newpwd.value=="")
	{
		alert("�����������룡");
		document.form1.newpwd.focus();
		return false;
	}
	if(document.form1.newpwd.value.length<6||document.form1.newpwd.value.length>16)
	{
		alert("����Ϊ6-16λ֮�䣡");
		document.form1.newpwd.focus();
		return false;
	}
	if(document.form1.repwd.value=="")
	{
		alert("��ȷ�����룡");
		document.form1.repwd.focus();
		return false;
	}
	if(document.form1.repwd.value!=document.form1.newpwd.value)
	{
		alert("�Բ���������������벻��ͬ����ȷ�����룡");
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

