package com.iot.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.iot.util.GetterSetter;

public class Database {

	ConnectionDB conn = new ConnectionDB();
	
	public boolean insertUserCredentials(String userid,String pass,UUID value,String mobilenum,String address){
		boolean result=false;
		String sql;
		Connection c = conn.getConnection();
		PreparedStatement st = null;
		try {
	        for(int i=0;i<3;i++){
	         if(i==0){
	           sql = "insert into users (uuid,uname)values('"+value+"','"+userid+"')";
	         }else if(i==1){
	           sql = "insert into userpass (uuid,pass)values('"+value+"','"+pass+"')";
	         }else{
	           sql = "insert into userdetail (uuid,mobile,email,address)values('"+value+"','"+mobilenum+"','"+userid+"','"+address+"')"; 
	         }
	         st = c.prepareStatement(sql);
	         st.executeUpdate();
	        }
	       c.close();
	       result = true;
		} catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	      }
		return result;
	}
	
	public boolean authUser(String userid,String pass){
		boolean result=false;
		Connection c = conn.getConnection();
		String sql;
		PreparedStatement st = null;
		try {
            sql = "select pass from userpass where uuid IN (select uuid from users where uname='" + userid+ "')";
	        st = c.prepareStatement(sql);
	        ResultSet rs = st.executeQuery();
	        while (rs.next())
	        {
	           if(rs.getString(1).equalsIgnoreCase(pass)){
	        	   result=true;
	           }
	        } 
	       rs.close();
	       c.close();
		} catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	      }
		return result;
	}
	public boolean userbookingdata(String userid,String startDate,String bookEndDate,String vehicleNumber,String parkslot,int hrs,int payment){
		
		boolean result=false;
		String sql;
		Connection c = conn.getConnection();
		PreparedStatement st = null;
		String uuid = getuuid(userid);
		try{
		sql = "insert into userbookingdata(uuid,starttime,booktime,vnum,parkslot,hours,payment)values('"+uuid+"','"+startDate+"','"+bookEndDate+"','"+vehicleNumber+"','"+parkslot+"',"+hrs+","+payment+")";
		st = c.prepareStatement(sql);
        st.executeUpdate();
	    c.close();
        result = true;
		}catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	    }
		return result;
	}
	
	public String getuuid(String userid){
		String uuid = null;
		Connection c = conn.getConnection();
		String sql;
		PreparedStatement st = null;
		try {
	        sql ="select uuid from users where uname='"+userid+"'";
	        st = c.prepareStatement(sql);
	        ResultSet rs = st.executeQuery();
	        while (rs.next())
	        {
	           uuid = rs.getString(1);
	        } 
	        rs.close();
	       c.close();
	      
		} catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	      }
		
		return uuid;
	}
	
	public boolean deleteEntry(String parkslot){
		boolean result=false;
		String sql;
		Connection c = conn.getConnection();
		PreparedStatement st = null;
		try{
		sql = "delete from userbookingdata where parkslot='"+parkslot+"'";
		st = c.prepareStatement(sql);
        st.executeUpdate();
        result = true;
		}catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	    }
		return result;
	}
	public boolean checkEntry(String userid,String parkslot,String starttime,String endTime){
		boolean result=false;
		Connection c = conn.getConnection();
		String sql;
		PreparedStatement st = null;
		try {
	        //sql = "select * from userbookingdata where (starttime <= '"+starttime+"'or booktime >='"+endTime+"' or parkslot='"+parkslot+"') and uuid IN (select uuid from users where uname='"+userid+"')";
			sql =" select * from userbookingdata where (starttime <= '"+starttime+"' and booktime >='"+endTime+"') and (parkslot='"+parkslot+"' and uuid IN (select uuid from users where uname='"+userid+"'))";
	        st = c.prepareStatement(sql);
	        ResultSet rs = st.executeQuery();
	        ResultSetMetaData rsmd = rs.getMetaData();
	        int cnt = rsmd.getColumnCount();
	        result = rs.next();
	        while (rs.next()) {
	            for (int i = 1; i <= cnt; i++) {
	                if (i > 1) System.out.print(",  ");
	                String columnValue = rs.getString(i);
	                System.out.print(columnValue + " " + rsmd.getColumnName(i));
	            }
	            System.out.println("");
	        } 
	        rs.close();
	        
	       c.close();
		}catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	    }
		return result;
	}
	
	public List<GetterSetter> getUserBookingData(){
		List<GetterSetter> arrgs = new ArrayList<GetterSetter>();
		//Map<String, GetterSetter> map = new HashMap<String, GetterSetter>();
		GetterSetter gs = new GetterSetter();
		boolean result=false;
		Connection c = conn.getConnection();
		String sql;
		PreparedStatement st = null;
		try {
	        //sql = "select * from userbookingdata where (starttime <= '"+starttime+"'or booktime >='"+endTime+"' or parkslot='"+parkslot+"') and uuid IN (select uuid from users where uname='"+userid+"')";
			sql ="select users.uname as userid,userbookingdata.vnum,userbookingdata.parkslot,userbookingdata.starttime,userbookingdata.booktime,userbookingdata.hours,userbookingdata.payment from userbookingdata join users ON userbookingdata.uuid=users.uuid order by starttime";
	        st = c.prepareStatement(sql);
	        ResultSet rs = st.executeQuery();
	        int counter = 1;        
	        while (rs.next())
	        {
	        	gs = new GetterSetter();
	        	gs.setcounter(counter++);
	        	gs.setuserid(rs.getString(1));
	        	gs.setvehiclenumber(rs.getString(2));
	        	gs.setparkslot(rs.getString(3));
	        	gs.setstarttime(rs.getString(4));
	        	gs.setendtime(rs.getString(5));
	        	gs.sethours((rs.getString(6)));
	        	gs.setpayment(rs.getString(7));
	        	arrgs.add(gs);    	
	           
	        } 
	    	for (int i = 0; i < arrgs.size(); i++) {
	    		GetterSetter gs1 = arrgs.get(i);
	    		System.out.println(gs1.getuserid()+" "+gs1.getvehiclenumber()+" "+gs1.getparkslot()+" "+gs1.getstarttime()+" "+gs1.getendtime()+" "+gs1.getpayment()+" ");
	    	}
	    	
	    	
	        
	        rs.close();
	       c.close();
		}catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	    }
		return arrgs;
	}
	
	public List<GetterSetter> getUserInfo(){
		List<GetterSetter> arrgs = new ArrayList<GetterSetter>();
		//Map<String, GetterSetter> map = new HashMap<String, GetterSetter>();
		GetterSetter gs = new GetterSetter();
		boolean result=false;
		Connection c = conn.getConnection();
		String sql;
		PreparedStatement st = null;
		try {
	        
			sql ="select users.uname,userdetail.mobile,userdetail.email,userdetail.address from userdetail join users ON userdetail.uuid=users.uuid order by email;";
	        st = c.prepareStatement(sql);
	        ResultSet rs = st.executeQuery();
	        int counter = 1;        
	        while (rs.next())
	        {
	        	gs = new GetterSetter();
	        	gs.setcounter(counter++);
	        	gs.setuserid(rs.getString(1));
	        	gs.setmobile(rs.getString(2));
	        	gs.setemail(rs.getString(3));
	        	gs.setaddress(rs.getString(4));
	        	arrgs.add(gs);    	
	           
	        }	
	        
	        rs.close();
	       c.close();
		}catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	    }
		return arrgs;
	}
}