var bsDate;
var bsWeek;   
var arrLen=8;	//���鳤�� 
var sValue=0;	//��������� 
var dayiy=0;	//����ڼ��� 
var miy=0;	//�·ݵ��±� 
var iyear=0;	//��ݱ�� 
var dayim=0;	//���µڼ��� 
var spd=86400;	//ÿ������� 
var year1999="30;29;29;30;29;29;30;29;30;30;30;29";	//354 
var year2000="30;30;29;29;30;29;29;30;29;30;30;29";	//354 
var year2001="30;30;29;30;29;30;29;29;30;29;30;29;30";	//384 
var year2002="30;30;29;30;29;30;29;29;30;29;30;29";	//354 
var year2003="30;30;29;30;30;29;30;29;29;30;29;30";	//355 
var year2004="29;30;29;30;30;29;30;29;30;29;30;29;30";	//384 
var year2005="29;30;29;30;29;30;30;29;30;29;30;29";	//354 
var year2006="30;29;30;29;30;30;29;29;30;30;29;29;30";

var Ys=new Array(arrLen); 
Ys[0]=919094400;Ys[1]=949680000;Ys[2]=980265600;Ys[3]=1013443200;Ys[4]=1044028800;Ys[5]=1074700800;Ys[6]=1107878400;Ys[7]=1138464000;
var D=new Date(); 
var yy=D.getFullYear();
var mm=D.getMonth()+1; 
var dd=D.getDate(); 
var ww=D.getDay(); 
if (ww==0) ww="������"; 
if (ww==1) ww="����һ";  
if (ww==2) ww="���ڶ�"; 
if (ww==3) ww="������"; 
if (ww==4) ww="������"; 
if (ww==5) ww="������"; 
if (ww==6) ww="������"; 
ww=ww; 
var ss=parseInt(D.getTime() / 1000);
if(yy<100)yy="19"+yy;
for(i=0;i<arrLen;i++) 
  if(ss>=Ys[i]) { 
    iyear=i; 
    sValue=ss-Ys[i];    //��������� 
  } 
dayiy=parseInt(sValue/spd)+1;    //��������� 
var dpm=year1999; 
if (iyear==1) dpm=year2000; 
if (iyear==2) dpm=year2001; 
if (iyear==3) dpm=year2002; 
if (iyear==4) dpm=year2003; 
if (iyear==5) dpm=year2004; 
if (iyear==6) dpm=year2005; 
if (iyear==7) dpm=year2006; 
dpm=dpm.split(";");
dayim=dayiy; 
var total=new Array(13); 
total[0]=parseInt(dpm[0]); 
for(i=1;i<dpm.length-1;i++)total[i]=parseInt(dpm[i])+total[i-1];
for(i=dpm.length-1;i>0;i--) 
  if(dayim>total[i-1]) {
    dayim=dayim-total[i-1]; 
    miy=i; 
  } 
bsWeek=ww; 
bsDate=yy+"��"+mm+"��"; 
bsDate2=dd;
document.write(bsDate+bsDate2+"�� ");
document.write(bsWeek+"  ");
