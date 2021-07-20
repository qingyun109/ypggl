package main.java.com.bean;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import main.java.com.util.Constant;
import main.java.com.util.DBO;

public class YaoBean {

	private List list;
	private ResultSet rs;
	private String date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
	private String mname;

	////////////////////////////////////////////////////////药名
	//增加
	public int addMc(String mname){
		String sql = "insert into mname (mname,addtime) values('"+mname+"','"+date+"')";
		DBO dbo = new DBO();
		dbo.open();
		try{
			int i = dbo.executeUpdate(sql);
			if(i == 1)
				return Constant.SUCCESS;
			else
				return Constant.SYSTEM_ERROR;
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dbo.close();
		}
	}
	// 修改
	public int upMc(int id,String mname){
		String sql = "update mname set mname='"+mname+"' where id='"+id+"'";
		DBO dbo = new DBO();
		dbo.open();
		try{
			int i = dbo.executeUpdate(sql);
			if(i == 1)
				return Constant.SUCCESS;
			else
				return Constant.SYSTEM_ERROR;
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dbo.close();
		}
	}
	// 删除
	public int delMc(int id){
		String sql = "delete from mname where id='"+id+"'";
		DBO dbo = new DBO();
		dbo.open();
		try{
			int i = dbo.executeUpdate(sql);
			if(i == 1)
				return Constant.SUCCESS;
			else
				return Constant.SYSTEM_ERROR;
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dbo.close();
		}
	}
	//模糊查询

	public List<Medicine> mSearchMc(String mname) {
		String sql = "select * from medicine where ypjx like '%"+mname+"%'";
		DBO dbo = new DBO();
		List<Medicine> mlist = new ArrayList<>();
		List<Medicine> mlist2 = new ArrayList<>();
		dbo.open();
		try {
			rs = dbo.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt(1);
				String ypmc = rs.getString(2);
				String yplb = rs.getString(3);
				String ypjx = rs.getString(4);
				String ypdw = rs.getString(5);
				String ypjj = rs.getString(6);
				String ypsl = rs.getString(7);
				String jhrq = rs.getString(8);
				String ypph = rs.getString(9);
				String ypcd = rs.getString(10);
				String yxq = rs.getString(11);
				mlist.add(new Medicine(id,ypmc,yplb,ypjx,ypdw,ypjj,ypsl,jhrq,ypph,ypcd,yxq));
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			dbo.close();
		}
		return mlist;
	}


	//精确查询
	public List<Medicine> jSearchMc(String mname) {
		String sql="select * from medicine where ypph='"+mname+"'";
		DBO dbo = new DBO();
		List<Medicine> mlist = new ArrayList<>();
		List<Medicine> mlist2 = new ArrayList<>();
		dbo.open();
		try {
			rs = dbo.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt(1);
				String ypmc = rs.getString(2);
				String yplb = rs.getString(3);
				String ypjx = rs.getString(4);
				String ypdw = rs.getString(5);
				String ypjj = rs.getString(6);
				String ypsl = rs.getString(7);
				String jhrq = rs.getString(8);
				String ypph = rs.getString(9);
				String ypcd = rs.getString(10);
				String yxq = rs.getString(11);
				mlist.add(new Medicine(id,ypmc,yplb,ypjx,ypdw,ypjj,ypsl,jhrq,ypph,ypcd,yxq));
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			dbo.close();
		}
		return mlist;
	}

	// 所有
	public List getAllMc(){ 
		String sql = "select * from mname order by id desc ";
		DBO dbo=new DBO();
		list = new ArrayList();
		dbo.open();
		try{
			rs = dbo.executeQuery(sql);
			while(rs.next()){
				List list2=new ArrayList();
				list2.add(rs.getString(1));
				list2.add(rs.getString(2));
				list2.add(rs.getString(3));
				list.add(list2);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			dbo.close();
		}
	}

////////////////////////////////////////////////////////药品类别
	//增加
	public int addClass(String yplb){
		String sql = "insert into classname (yplb,addtime) values('"+yplb+"','"+date+"')";
		DBO dbo = new DBO();
		dbo.open();
		try{
			int i = dbo.executeUpdate(sql);
			if(i == 1)
				return Constant.SUCCESS;
			else
				return Constant.SYSTEM_ERROR;
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dbo.close();
		}
	}
	// 修改
	public int upClass(int id,String yplb){
		String sql = "update classname set yplb='"+yplb+"' where id='"+id+"'";
		DBO dbo = new DBO();
		dbo.open();
		try{
			int i = dbo.executeUpdate(sql);
			if(i == 1)
				return Constant.SUCCESS;
			else
				return Constant.SYSTEM_ERROR;
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dbo.close();
		}
	}
	// 删除
	public int delClass(int id){
		String sql = "delete from classname where id='"+id+"'";
		DBO dbo = new DBO();
		dbo.open();
		try{
			int i = dbo.executeUpdate(sql);
			if(i == 1)
				return Constant.SUCCESS;
			else
				return Constant.SYSTEM_ERROR;
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dbo.close();
		}
	}

	// 所有
	public List getAllClass(){ 
		String sql = "select * from classname order by id desc ";
		DBO dbo=new DBO();
		list = new ArrayList();
		dbo.open();
		try{
			rs = dbo.executeQuery(sql);
			while(rs.next()){
				List list2=new ArrayList();
				list2.add(rs.getString(1));
				list2.add(rs.getString(2));
				list2.add(rs.getString(3));
				list.add(list2);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			dbo.close();
		}
	}
////////////////////////////////////////////////////////药品剂型
	//增加
	public int addJx(String ypjx){
		String sql = "insert into ypjx (ypjx,addtime) values('"+ypjx+"','"+date+"')";
		DBO dbo = new DBO();
		dbo.open();
		try{
			int i = dbo.executeUpdate(sql);
			if(i == 1)
				return Constant.SUCCESS;
			else
				return Constant.SYSTEM_ERROR;
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dbo.close();
		}
	}
	// 修改
	public int upJx(int id,String ypjx){
		String sql = "update ypjx set ypjx='"+ypjx+"' where id='"+id+"'";
		DBO dbo = new DBO();
		dbo.open();
		try{
			int i = dbo.executeUpdate(sql);
			if(i == 1)
				return Constant.SUCCESS;
			else
				return Constant.SYSTEM_ERROR;
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dbo.close();
		}
	}
	// 删除
	public int delJx(int id){
		String sql = "delete from ypjx where id='"+id+"'";
		DBO dbo = new DBO();
		dbo.open();
		try{
			int i = dbo.executeUpdate(sql);
			if(i == 1)
				return Constant.SUCCESS;
			else
				return Constant.SYSTEM_ERROR;
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dbo.close();
		}
	}
	// 所有
	public List getAllJx(){ 
		String sql = "select * from ypjx order by id desc ";
		DBO dbo=new DBO();
		list = new ArrayList();
		dbo.open();
		try{
			rs = dbo.executeQuery(sql);
			while(rs.next()){
				List list2=new ArrayList();
				list2.add(rs.getString(1));
				list2.add(rs.getString(2));
				list2.add(rs.getString(3));
				list.add(list2);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			dbo.close();
		}
	}
////////////////////////////////////////////////////////药品单位
	//增加
	public int addDw(String dwmc){
		String sql = "insert into dwmc (dwmc,addtime) values('"+dwmc+"','"+date+"')";
		DBO dbo = new DBO();
		dbo.open();
		try{
			int i = dbo.executeUpdate(sql);
			if(i == 1)
				return Constant.SUCCESS;
			else
				return Constant.SYSTEM_ERROR;
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dbo.close();
		}
	}
	// 修改
	public int upDw(int id,String dwmc){
		String sql = "update dwmc set dwmc='"+dwmc+"' where id='"+id+"'";
		DBO dbo = new DBO();
		dbo.open();
		try{
			int i = dbo.executeUpdate(sql);
			if(i == 1)
				return Constant.SUCCESS;
			else
				return Constant.SYSTEM_ERROR;
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dbo.close();
		}
	}
	// 删除
	public int delDw(int id){
		String sql = "delete from dwmc where id='"+id+"'";
		DBO dbo = new DBO();
		dbo.open();
		try{
			int i = dbo.executeUpdate(sql);
			if(i == 1)
				return Constant.SUCCESS;
			else
				return Constant.SYSTEM_ERROR;
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dbo.close();
		}
	}
	// 所有
	public List getAllDw(){ 
		String sql = "select * from dwmc order by id desc ";
		DBO dbo=new DBO();
		list = new ArrayList();
		dbo.open();
		try{
			rs = dbo.executeQuery(sql);
			while(rs.next()){
				List list2=new ArrayList();
				list2.add(rs.getString(1));
				list2.add(rs.getString(2));
				list2.add(rs.getString(3));
				list.add(list2);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			dbo.close();
		}
	}
	///////////////////////////////////////////////////进货
	public int addMedicine(String ypmc,String yplb,String ypjx,String ypdw,String ypjj,
			String ypsl,String jhrq,String ypph,String ypcd,String yxq, String dqrq){
		String sql ="insert into medicine (ypmc,yplb,ypjx,ypdw,ypjj,ypsl,jhrq,ypph,ypcd,yxq,dqrq)  " +
				"values('"+ypmc+"','"+yplb+"','"+ypjx+"','"+ypdw+"','"+ypjj+"','"+ypsl+"'," +
						"'"+jhrq+"','"+ypph+"','"+ypcd+"','"+yxq+"','"+dqrq+"') ";
		DBO dbo = new DBO();
		dbo.open();
		try{
			int i = dbo.executeUpdate(sql);
			if(i == 1)
				return Constant.SUCCESS;
			else
				return Constant.SYSTEM_ERROR;
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dbo.close();
		}
	}
	public int upMedicine(int id,String ypmc,String yplb,String ypjx,String ypdw,String ypjj,
			String ypsl,String jhrq,String ypph,String ypcd,String yxq, String dqrq){
		String sql ="update medicine  set ypmc='"+ypmc+"',yplb='"+yplb+"',ypjx='"+ypjx+"',ypdw='"+ypdw+"'," +
				"ypjj='"+ypjj+"',ypsl='"+ypsl+"',jhrq='"+jhrq+"',ypph='"+ypph+"'," +
						"ypcd='"+ypcd+"',yxq='"+yxq+"',dqrq='"+dqrq+"' where id='"+id+"' ";
		DBO dbo = new DBO();
		dbo.open();
		try{
			int i = dbo.executeUpdate(sql);
			if(i == 1)
				return Constant.SUCCESS;
			else
				return Constant.SYSTEM_ERROR;
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dbo.close();
		}
	}
	public int delMedicine(int id){
		String sql ="delete from medicine where id='"+id+"' ";
		DBO dbo = new DBO();
		dbo.open();
		try{
			int i = dbo.executeUpdate(sql);
			if(i == 1)
				return Constant.SUCCESS;
			else
				return Constant.SYSTEM_ERROR;
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dbo.close();
		}
	}
	public List getAllMedicine(){
		String sql = "select * from medicine order by id desc ";
		DBO dbo=new DBO();
		list = new ArrayList();
		dbo.open();
		try{
			rs = dbo.executeQuery(sql);
			while(rs.next()){
				List list2=new ArrayList();
				list2.add(rs.getString(1));
				list2.add(rs.getString(2));
				list2.add(rs.getString(3));
				list2.add(rs.getString(4));
				list2.add(rs.getString(5));
				list2.add(rs.getString(6));
				list2.add(rs.getString(7));
				list2.add(rs.getString(8));
				list2.add(rs.getString(9));
				list2.add(rs.getString(10));
				list2.add(rs.getString(11));
				list2.add(rs.getString(12));
				list.add(list2);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			dbo.close();
		}
	}
	///////////////////////////////////////////////////////////////过期药品
	public List getAllOldMedicine(){
		String sql = "select * from medicine where dqrq<'"+date+"' order by id desc ";
		DBO dbo=new DBO();
		list = new ArrayList();
		dbo.open();
		try{
			rs = dbo.executeQuery(sql);
			while(rs.next()){
				List list2=new ArrayList();
				list2.add(rs.getString(1));
				list2.add(rs.getString(2));
				list2.add(rs.getString(3));
				list2.add(rs.getString(4));
				list2.add(rs.getString(5));
				list2.add(rs.getString(6));
				list2.add(rs.getString(7));
				list2.add(rs.getString(8));
				list2.add(rs.getString(9));
				list2.add(rs.getString(10));
				list2.add(rs.getString(11));
				list2.add(rs.getString(12));
				list.add(list2);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			dbo.close();
		}
	}
	public List getOneMedicine(int id){
		String sql = "select * from medicine where id='"+id+"' ";
		DBO dbo=new DBO();
		list = new ArrayList();
		dbo.open();
		try{
			rs = dbo.executeQuery(sql);
			while(rs.next()){
				list.add(rs.getString(1));
				list.add(rs.getString(2));
				list.add(rs.getString(3));
				list.add(rs.getString(4));
				list.add(rs.getString(5));
				list.add(rs.getString(6));
				list.add(rs.getString(7));
				list.add(rs.getString(8));
				list.add(rs.getString(9));
				list.add(rs.getString(10));
				list.add(rs.getString(11));
				list.add(rs.getString(12));
				
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			dbo.close();
		}
	}
	///////////////////////////////////////////////////////////销售
	///销售判断 判断库存是否够
	public int getIf(String ypbm){
		String sql="select ypsl from medicine where ypmc='"+ypbm+"'";
		DBO dbo = new DBO();
		dbo.open();
		try{
			rs=dbo.executeQuery(sql);
			if(rs.next())
				return rs.getInt(1);
			else
				return 0;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			dbo.close();
		}
	}public int getSale(String ypbm){
		DBO dbo = new DBO();
		dbo.open();
		try{
			rs=dbo.executeQuery("select sum(ypsl) from sale where ypmc='"+ypbm+"'");
			if(rs.next())
				return rs.getInt(1);
			else
				return 0;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			dbo.close();
		}
	}
	public int saleMedicine(String ypmc,String ypsj,String ypsl,String xsrq){
		String sql ="insert into sale(ypmc,ypsj,ypsl,xsrq)  " +
				"values('"+ypmc+"','"+ypsj+"','"+ypsl+"','"+xsrq+"') ";
		DBO dbo = new DBO();
		dbo.open();
		try{
			int i = dbo.executeUpdate(sql);
			if(i == 1)
				return Constant.SUCCESS;
			else
				return Constant.SYSTEM_ERROR;
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dbo.close();
		}
	}
	public int upSaleMedicine(int id,String ypmc,String ypsj,String ypsl,String xsrq){
		String sql ="update sale  set ypmc='"+ypmc+"',ypsj='"+ypsj+"',ypsl='"+ypsl+"',xsrq='"+xsrq+"' where id='"+id+"'";
		DBO dbo = new DBO();
		dbo.open();
		try{
			int i = dbo.executeUpdate(sql);
			if(i == 1)
				return Constant.SUCCESS;
			else
				return Constant.SYSTEM_ERROR;
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dbo.close();
		}
	}
	public int delSaleMedicine(int id){
		String sql ="delete from sale where id='"+id+"' ";
		DBO dbo = new DBO();
		dbo.open();
		try{
			int i = dbo.executeUpdate(sql);
			if(i == 1)
				return Constant.SUCCESS;
			else
				return Constant.SYSTEM_ERROR;
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dbo.close();
		}
	}

	public List getAllSaleMedicine(){
		String sql = "select * from sale order by id desc ";
		DBO dbo=new DBO();
		list = new ArrayList();
		dbo.open();
		try{
			rs = dbo.executeQuery(sql);
			while(rs.next()){
				List list2=new ArrayList();
				list2.add(rs.getString(1));
				list2.add(rs.getString(2));
				list2.add(rs.getString(3));
				list2.add(rs.getString(4));
				list2.add(rs.getString(5));

				list.add(list2);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			dbo.close();
		}
	}
	public List getSearchSaleMedicine(String stime,String etime){
		String sql = "select * from sale where xsrq between '"+stime+"' and '"+etime+"' order by id desc ";
		DBO dbo=new DBO();
		list = new ArrayList();
		dbo.open();
		try{
			rs = dbo.executeQuery(sql);
			while(rs.next()){
				List list2=new ArrayList();
				list2.add(rs.getString(1));
				list2.add(rs.getString(2));
				list2.add(rs.getString(3));
				list2.add(rs.getString(4));
				list2.add(rs.getString(5));
				
				list.add(list2);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			dbo.close();
		}
	}
	public List getOneSaleMedicine(int id){
		String sql = "select * from sale where id='"+id+"' ";
		DBO dbo=new DBO();
		list = new ArrayList();
		dbo.open();
		try{
			rs = dbo.executeQuery(sql);
			while(rs.next()){
				list.add(rs.getString(1));
				list.add(rs.getString(2));
				list.add(rs.getString(3));
				list.add(rs.getString(4));
				list.add(rs.getString(5));		
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			dbo.close();
		}
	}
	public int getLow(){
		String sql ="select flag from flag";
		DBO dbo=new DBO();
		dbo.open();
		try{
			rs = dbo.executeQuery(sql);
			rs.next();
			return rs.getInt(1);
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			dbo.close();
		}
	}
	public int setLow(int flag){
		String sql ="update flag set flag='"+flag+"' ";
		DBO dbo = new DBO();
		dbo.open();
		try{
			int i = dbo.executeUpdate(sql);
			if(i == 1)
				return Constant.SUCCESS;
			else
				return Constant.SYSTEM_ERROR;
		}catch(Exception e){
			e.printStackTrace();
			return Constant.SYSTEM_ERROR;
		}finally{
			dbo.close();
		}
	}
	public List getLowMedicine(){
		int num=this.getLow();
		String sql = "select * from medicine where ypsl<='"+num+"' order by id desc ";
		System.out.println(sql);
		DBO dbo=new DBO();
		list = new ArrayList();
		dbo.open();
		try{
			rs = dbo.executeQuery(sql);
			while(rs.next()){
				List list2=new ArrayList();
				list2.add(rs.getString(1));
				list2.add(rs.getString(2));
				list2.add(rs.getString(3));
				list2.add(rs.getString(4));
				list2.add(rs.getString(5));
				list2.add(rs.getString(6));
				list2.add(rs.getString(7));
				list2.add(rs.getString(8));
				list2.add(rs.getString(9));
				list2.add(rs.getString(10));
				list2.add(rs.getString(11));
				list2.add(rs.getString(12));
				list.add(list2);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			dbo.close();
		}
	}
}
