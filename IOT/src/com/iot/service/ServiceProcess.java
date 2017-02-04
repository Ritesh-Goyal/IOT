package com.iot.service;

import java.util.UUID;
import com.iot.database.Database;

public class ServiceProcess {
	Database db = new Database();
	public boolean insertDB(String userid,String pass,String mobilenum,String address){
		boolean result = false;
		UUID value = UUID.randomUUID();//UUID.fromString(userid);
		result = db.insertUserCredentials(userid,pass,value,mobilenum,address);
		
		return result;
	}
	public boolean authUser(String userid,String pass){
		boolean result = false;
		result = db.authUser(userid,pass);
		return result;
	}
	public boolean userbookingdataService(String userid,String startDate,String bookEndDate,String vehicleNumber,String parkslot,int hrs,int payment){
		boolean result = false;
		result = db.userbookingdata(userid,startDate,bookEndDate,vehicleNumber,parkslot,hrs,payment);
		return result;
	}
	public boolean deleteEntry(String parkslot){
		boolean result = false;
		result = db.deleteEntry(parkslot);
		
		return result;
	}
	public boolean checkEntry(String userid,String parkslot,String starttime,String endTime){
		boolean result = false;
		
		result = db.checkEntry(userid, parkslot, starttime, endTime);
		
		return result;
	}
	
	public String createBookingService(String date, int hrs){
		//Integer dte = Integer.valueOf(request.getParameter("date"));
				String actdate;
				//String flag = "AM";
				
				//String hours = request.getParameter("time");
				//Call for check
				String []time = date.split("T");
				String []time1 = time[1].split(":");
				int i = Integer.parseInt(time1[0]);
				System.out.println(i+" "+hrs);
				int y = i+hrs;
				/*if(y > 12 && y <= 24){
					y = y-12;
					flag = "PM";
					actdate = time[0]+" "+y+":"+time1[1]+":00";}
				*/
				if(y > 24){
					y = y-24;
					actdate = time[0]+" "+y+":"+time1[1]+":00";
				}else
				{
					actdate = time[0]+" "+y+":"+time1[1]+":00";
				}
			return actdate;	
	}
	
}
