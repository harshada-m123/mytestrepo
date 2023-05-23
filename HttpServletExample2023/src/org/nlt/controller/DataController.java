package org.nlt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DataController  extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		service(req, resp);
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		service(req, resp);
	}
	
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		HttpSession ses= req.getSession();
		String clientIp=req.getRemoteAddr();
		
		resp.setContentType("text/html");
		
		PrintWriter out= resp.getWriter();
		try 
		{
			String pageName=req.getParameter("page");
			
			if(pageName.equals("LoginPage"))
			{
				String email=req.getParameter("email");
				String password=req.getParameter("password");
				
				if(email.equals("Raju@gmail.com")&&password.equals("1234"))
				{
					RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
					rd.include(req, resp);
				}
				else
				{
					RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
					out.println("<h3>Invalid Login! Please Try Again.....</h3>");
					rd.include(req, resp);

				}
			}
		} catch (Exception e)
		{
			out.println("<h2>"+e+"</h2>");
		}
	
	}

}
