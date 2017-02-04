package com.iot.util;

public class GetterSetter {

	private String JDBCDriver;
	private String DBConnectionString;
	private String DBUsername;
	private String DBPassword;
	private String PublicIP;
	
	private String userid;
	private String vehiclenumber;
	private String parkslot;
	private String starttime;
	private String endtime;
	private String payment;
	private String hours;
	private int counter;
	
	private String mobile;
	private String email;
	private String address;
	
	public static final PropertiesFile propsFileLoader = new PropertiesFile("IOT");
	
	public String getJDBCDriver(){
		return this.JDBCDriver;
	}
	public void setJDBCDriver(){
		this.JDBCDriver = propsFileLoader.getValue("JDBCDriver");
	}
	
	public String getDBConnectionString(){
		return this.DBConnectionString;
	}
	public void setDBConnectionString(){
		this.DBConnectionString = propsFileLoader.getValue("DBConnectionString");		
	}
	
	public String getDBUsername() {
		return this.DBUsername;
	}
	public void setDBUsername(){
		this.DBUsername = propsFileLoader.getValue("DBUsername");
	}
	
	public String getDBPassword(){
		return this.DBPassword;
	}
	public void setDBPassword(){
		this.DBPassword = propsFileLoader.getValue("DBPassword");
	}
	
	public String getPublicIP(){
		return this.PublicIP;
	}
	public void setPublicIP(){
		this.PublicIP = propsFileLoader.getValue("PublicIP");
	}
	
	// Used for Getting and setting user data
	public String getuserid() {
		return this.userid;
	}

	public void setuserid(String userid) {
		this.userid = userid;
	}

	public String getvehiclenumber() {
		return this.vehiclenumber;
	}

	public void setvehiclenumber(String vehiclenumber) {
		this.vehiclenumber = vehiclenumber;
	}

	public String getparkslot() {
		return this.parkslot;
	}

	public void setparkslot(String parkslot) {
		this.parkslot = parkslot;
	}

	public String getstarttime() {
		return this.starttime;
	}

	public void setstarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getendtime() {
		return this.endtime;
	}

	public void setendtime(String endtime) {
		this.endtime = endtime;
	}

	public String getpayment() {
		return this.payment;
	}

	public void setpayment(String payment) {
		this.payment = payment;
	}

	public String gethours() {
		return this.hours;
	}

	public void sethours(String hours) {
		this.hours = hours;
	}
	
	public int getcounter() {
		return this.counter;
	}

	public void setcounter(int counter) {
		this.counter = counter;
	}
	
	public String getmobile() {
		return this.mobile;
	}

	public void setmobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getemail() {
		return this.email;
	}

	public void setemail(String email) {
		this.email = email;
	}
	
	public String getaddress() {
		return this.address;
	}

	public void setaddress(String address) {
		this.address = address;
	}
}
