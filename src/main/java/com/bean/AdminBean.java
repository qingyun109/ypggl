package main.java.com.bean;
/**
 * 
 * 管理员登陆 修改密码 登陆记录查询 通用类文件
 * 
 */
//分页查询
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import main.java.com.util.Constant;
import main.java.com.util.DBO;

public class AdminBean {
	private List list;
	private ResultSet rs = null;
	private int EVERYPAGENUM = 2;
	private int count = -1;
	private int qq = 0;
	private String sql="select count(*) from adminlog";
	private String sql2="select * from adminlog order by id desc ";
	//声明时间变量
	String date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());

	//管理员登录 更新登录次数 写登录日志
	public int adminLogin(String username,String password){
		String sql = "select * from admin where username = '"+username+"' and isuse='1'";
		String sql2 = "insert into adminlog(username,password,logintime,ok) values('"+username+"','"+password+"','"+date+"','true')";
		String sql3 = "insert into adminlog(username,password,logintime,ok) values('"+username+"','"+password+"','"+date+"','false')";
		String sql4 = "update admin set logintimes = logintimes+1 where username = '"+username+"' ";
		DBO dbo = new DBO();
		String pwd;
		dbo.open();
		try{
			rs = dbo.executeQuery(sql);
			if(rs.next()){
				pwd = rs.getString("password");
				if(pwd.trim().equals(password)){
					dbo.executeUpdate(sql2);
					dbo.executeUpdate(sql4);
					return Constant.SUCCESS;
				}
				else{
					dbo.executeUpdate(sql3);
					return Constant.PASSWORD_ERROR;
				}
			}
			else{
				dbo.executeUpdate(sql3);
				return Constant.NAME_ERROR;
			}			
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dbo.close();
		}	
	}
	
	//查询管理员信息
	public List getAdminInfo(String username){
		String sql = "select * from admin where username='"+username+"' ";
		DBO dbo = new DBO();
		dbo.open();
		list = new ArrayList();
		try{
			rs = dbo.executeQuery(sql);
			rs.next();
			list.add(rs.getString("username"));
			list.add(rs.getInt("flag"));
			list.add(rs.getInt("logintimes"));
			list.add(date);
			list.add(rs.getString("quanxian"));
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return list;
		}finally{
			dbo.close();
		}
	}
	
	//admin edit password
	public int editPassword(String username,String oldpwd,String newpwd){
		String sql="select * from admin where username = '"+username+"' and password = '"+oldpwd+"'";
		String sql2="update admin set password = '"+newpwd+"' where username = '"+username+"'";
		DBO dbo = new DBO();
		dbo.open();
		try{
			rs = dbo.executeQuery(sql);
			if(rs.next()){
				int i = dbo.executeUpdate(sql2);
				if(i == 1){
					return Constant.SUCCESS;
				}
				else{
					return Constant.SYSTEM_ERROR;
				}
			}
			else{
				return Constant.PASSWORD_ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dbo.close();
		}
	}
	//add manager
	public int addManager(String username,String password,String type,String isuse){
		String sql = "insert into admin(username,password,creattime,flag,isuse,logintimes,quanxian) values('"+username+"','"+password+"','"+date+"','"+type+"','"+isuse+"','0','111')";
		String sql2 = "select * from admin where username = '"+username+"'";
		DBO dbo = new DBO();
		dbo.open();
		try{
			rs = dbo.executeQuery(sql2);
			if(rs.next()){
				return Constant.SAME_NAME;
			}
			else{
				int i = dbo.executeUpdate(sql);
				if(i == 1)return Constant.SUCCESS;
				else return Constant.SYSTEM_ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dbo.close();
		}
	}
	
	//update manager
	public int updateManager(String username,String password,String type,String isuse){
		String sql;
		if(password.equals("")){
			sql = "update admin set flag = '"+type+"' ,isuse = '"+isuse+"' where username = '"+username+"'";
		}
		else{
			sql = "update admin set password = '"+password+"' ,flag = '"+type+"' ,isuse = '"+isuse+"' where username = '"+username+"'";
		}
		DBO dbo = new DBO();
		dbo.open();
		try{
			int i = dbo.executeUpdate(sql);
			if(i == 1)return Constant.SUCCESS;
			else return Constant.SYSTEM_ERROR;
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dbo.close();
		}
	}
	
	//get all manager
	public List getAllManager(){
		String sql = "select * from admin where flag !='0' order by id asc";
		DBO dbo = new DBO();
		list = new ArrayList();
		dbo.open();
		try{
			rs = dbo.executeQuery(sql);
			while(rs.next()){
				List list2 = new ArrayList();
				list2.add(rs.getInt(1));
				list2.add(rs.getString(2));
				list2.add(rs.getString(4));
				list2.add(rs.getInt(5));
				list2.add(rs.getInt(6));
				list2.add(rs.getInt(7));
				list.add(list2);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return list;
		}finally{
			dbo.close();
		}
	}
	
	//删除管理员
	public int delManager(int id){
		String sql = "delete from admin where id = '"+id+"'";
		DBO dbo = new DBO();
		dbo.open();
		try{
			int i = dbo.executeUpdate(sql);
			if(i == 1)return Constant.SUCCESS;
			else return Constant.SYSTEM_ERROR;
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dbo.close();
		}
	}
} 

