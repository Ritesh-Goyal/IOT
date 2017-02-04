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
import com.iot.util.GetterSetter;
import com.iot.util.SecurePassword;

/**
 * Servlet implementation class login
 */
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ServiceProcess sp = new ServiceProcess();   
    //SecurePassword securePass = new SecurePassword();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
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
		boolean result = false;
		new GetterSetter();
		String userid = request.getParameter("loginName");
		String pass = request.getParameter("password");
        //System.out.println(userid+" "+pass);
        try {
		pass = SecurePassword.getPassword(pass);
	
        result = sp.authUser(userid,pass);
       
       ServletContext sc = getServletContext();
        //if(uname == null || pass == null){
       
        if(result == false){
        request.setAttribute("message","Login Failure");	
		sc.getRequestDispatcher("/login.jsp").forward(request, response);
		//userid.equalsIgnoreCase("ritesh.goyal590@gmail.com")
        }else if(userid.equalsIgnoreCase("prerna07dhar@gmail.com")){
        request.setAttribute("uname", userid);
        sc.getRequestDispatcher("/listusers.jsp").forward(request, response);
    	}
        else {
		//sc.getRequestDispatcher("/Dashboard.jsp").forward(request, response);
        request.setAttribute("uname", userid);
        sc.getRequestDispatcher("/ParkingSelection.jsp").forward(request, response);
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
