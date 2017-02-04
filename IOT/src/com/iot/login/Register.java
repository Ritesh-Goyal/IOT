package com.iot.login;



import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iot.service.ServiceProcess;
import com.iot.util.SecurePassword;
import com.iot.service.EmailService;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServiceProcess sp = new ServiceProcess();  
	EmailService email = new EmailService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
		String uname = request.getParameter("loginName");
		String pass = request.getParameter("password");
		String mobilenum = request.getParameter("mobile");
		String address = request.getParameter("address");
		
		try {
		String passHash = SecurePassword.getPassword(pass);
		
        boolean result = false;
		//System.out.println(uname+" "+pass);
        result = sp.insertDB(uname,passHash,mobilenum,address);
        if(result == true){
        //boolean emailstatus = email.sendEmail(uname,"register");
        	//boolean emailstatus = email.sendEmail(uname,pass,"register",null,null,0,null);//email.sendEmail("ritesh.goyal590@gmail.com","booking");//	
        	email.sendEmail(uname,pass,"register",null,null,0,0,null);//email.sendEmail("ritesh.goyal590@gmail.com","booking");//
        }
        String message = "Successfull Registered";
        ServletContext sc = getServletContext();
        if(uname == null || pass == null){
		sc.getRequestDispatcher("/register.html").forward(request, response);
		
        }else{
        	request.setAttribute("message", message);
            sc.getRequestDispatcher("/login.jsp").forward(request, response);
        }
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
