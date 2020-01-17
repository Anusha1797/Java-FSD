package com.cts;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CheckNumber extends HttpServlet {
   private PrintWriter out=null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		out=resp.getWriter();
		int a=Integer.parseInt(req.getParameter("numb"));
		if(a>=0)
		out.println("<h1>number is positive</h1>");
		else
		out.println("<h1>number is negative</h1>");	
	}

}
	