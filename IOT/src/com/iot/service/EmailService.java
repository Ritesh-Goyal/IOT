package com.iot.service;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

import com.iot.util.PropertiesFile;

public class EmailService {
	public static final PropertiesFile propsFileLoader = new PropertiesFile("IOT");
   public boolean sendEmail(String recepient,String pass,String type,String startDate,String bookEndDate,int hrs,int payment,String vehicleNumber) {
      // Recipient's email ID needs to be mentioned.
     
      boolean result = false;
      // Sender's email ID needs to be mentioned
    String from = "iotcarparking@gmail.com";//change accordingly
    final String username = "iotcarparking";//change accordingly
    final String password = "iotcarparkingadmin";//change accordingly
    /*  String from = "iotcarparkingsystem@gmail.com";
      final String username = "iotcarparkingsystem";//change accordingly
      final String password = "9960930111";//change accordingly
*/      
    String[] ip=propsFileLoader.getValue("PublicIP").split(":");
      String host = "smtp.gmail.com";
	  String subject = null, body = null;
      if(type.equalsIgnoreCase("register")){
          // Set Subject: header field
          subject = "Smart Car Parking System Registeration ";

          // Now set the actual message
          body ="Dear Customer,<br>You have been registered with Smart Car parking system.Your login details are as below<br><br>Login-id : "+recepient+"<br>Password : "+pass+"<br><br>For accessing the IOT application hit : http://"+ip[0]+":8080/IOT/ <br><br>For any help please contact us at : iotcarparking@gmail.com";
          }
          else if(type.equalsIgnoreCase("booking")){
          subject = "Smart Car Parking Booking System";

              // Now set the actual message
         // body = "Dear Customer,<br>Your booking for Smart Car Parking has been booked successfully. Your Booking details are :<br>Booking Date :"+startDate+"<br>Number of hours : "+hrs+"<br>End Date : "+bookEndDate+"<br><br>For any help please contact us at : iotcarparking@gmail.com";
          body = "Dear Customer,<br>Your Smart Car Parking has been booked successfully for "+hrs+" hours. And your Booking details are: <br>Booked Parking Slot :"+pass+"<br>Start Time : "+startDate+"<br>End Time : "+bookEndDate+"<br>Vehicle Number : "+vehicleNumber+"<br>Total Amount : Rs. "+payment+".00 <br><br>Please pay the total amount during parking.<br>For any help please contact us at : iotcarparking@gmail.com";
      }

      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.port", "587");

      // Get the Session object.
      Session session = Session.getInstance(props,new javax.mail.Authenticator() {
         protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
         }
      });

      try {
         // Create a default MimeMessage object.
         Message message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         message.setRecipients(Message.RecipientType.TO,
         InternetAddress.parse(recepient));
         message.setSubject(subject);
         message.setText(body);
         
         MimeBodyPart mbp = new MimeBodyPart();
		 mbp.setContent(new String(body.getBytes("UTF8"),"ISO-8859-1"), "text/html");
			
		 Multipart mp = new MimeMultipart();
		 mp.addBodyPart(mbp);
		 message.setContent(mp);
         // Send message
         Transport.send(message);
         System.out.println("Sent message successfully to user "+recepient);

      } catch (MessagingException e) {
    	  System.out.println(e);
            throw new RuntimeException(e);
      } catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    return result;
   }
   public static void main(String args[]){
	   //EmailService es = new EmailService();
	   //new EmailService().sendEmail("ritesh.goyal590@gmail.com","123456", "register", "6-July-2016 1:43 PM", "7-July-2016 1:43 PM", 4);
	   new EmailService().sendEmail("ritesh.goyal590@gmail.com","parkslot1", "booking", "6-July-2016 1:43 PM", "7-July-2016 1:43 PM", 4,250, "MH-12 EY 5097");
	   //es.sendEmail("ritesh.goyal590@gmail.com", "register", "6-July-2016 1:43 PM", "7-July-2016 1:43 PM", 4);
   } 
}