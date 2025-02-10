package com.pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/rey")
public class rey extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public rey() {
        super();
       
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
   	{
       	String N1=request.getParameter("t1");
       	String N2=request.getParameter("t2");
       
       	
       	
   		PrintWriter out = response.getWriter();
   		out.println("This is Service Method ");
   		out.println("N1 : "+N1);
   		out.println("N2 : "+N2);
   		
   		
   		
   		
   		
   		
   	
   	}
}
