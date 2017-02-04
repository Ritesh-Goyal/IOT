package com.iot.mqtt;


import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import com.iot.service.EmailService;
import com.iot.service.ServiceProcess;

/**
 * Servlet implementation class MQTT
 */
public class MQTTPublish extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmailService email = new EmailService();
    ServiceProcess serviceProcess = new ServiceProcess();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MQTTPublish() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		boolean result = false;
		final String parkslot = request.getParameter("formnum");
		String startDate1 = request.getParameter("date");
		final Integer hrs = Integer.valueOf(request.getParameter("time"));
		final String userid = request.getParameter("user");
		final String vehicleNumber = request.getParameter("vnumber");
		String message = null;
		//System.out.println("Time Details "+date+" Add val "+sum);
		final String bookEndDate = serviceProcess.createBookingService(startDate1, hrs);
		final String startDate = startDate1.replace("T", " ");
		MQTTPaho paho = new MQTTPaho();
		final int payment = hrs * 10;
		if(!(serviceProcess.checkEntry(userid, parkslot, startDate, bookEndDate))){
			//result = serviceProcess.userbookingdataService(userid,startDate,bookEndDate,vehicleNumber,parkslot);	
			//if(result == true){	
			if(serviceProcess.userbookingdataService(userid,startDate,bookEndDate,vehicleNumber,parkslot,hrs,payment)){
				
				if(paho.doPublish(parkslot,userid)){
					//boolean emailstatus = email.sendEmail(userid,parkslot,"booking",startDate,bookEndDate,hrs,vehicleNumber);//email.sendEmail("ritesh.goyal590@gmail.com","booking");//
					new Thread(new Runnable() {
					    public void run() {
					    	email.sendEmail(userid,parkslot,"booking",startDate,bookEndDate,hrs,payment,vehicleNumber);//email.sendEmail("ritesh.goyal590@gmail.com","booking");
					    }
					}).start();
					//email.sendEmail(userid,parkslot,"booking",startDate,bookEndDate,hrs,payment,vehicleNumber);//email.sendEmail("ritesh.goyal590@gmail.com","booking");//
					message = "Parking slot is booked. And total amount is : "+payment+" . Kindly check your email.";
				}
				else{
					message = "Server is not reachable and might be down. Try After sometime";
				}
			}else{
				message = "Something went wrong contact Admin";
			}
		}else{
			message = "Requested Parking is Full for mentioned time. Please choose another parking or time";
		}
		ServletContext sc = getServletContext();
		request.setAttribute("uname", userid);
		request.setAttribute("status", message);
		sc.getRequestDispatcher("/publish.jsp").forward(request, response);
		//sc.getRequestDispatcher("/Parkdisplay.jsp").forward(request, response);
		
		}
   	
	public void connectionLost(Throwable arg0) {
		// TODO Auto-generated method stub
		
	}

	public void deliveryComplete(IMqttDeliveryToken arg0) {
		// TODO Auto-generated method stub
		
	}

	public void messageArrived(String arg0, MqttMessage arg1) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
