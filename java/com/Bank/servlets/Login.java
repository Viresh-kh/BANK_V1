package com.Bank.servlets;


import java.io.IOException;
import java.io.PrintWriter;

import com.Bank.Dao.CustomerDao;
import com.Bank.Dao.CustomerDaoImpl;
import com.Bank.Dto.Customer;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/login")

public class Login extends HttpServlet {

	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		PrintWriter pw=resp.getWriter();
		
		String accno=req.getParameter("accno");
		String pin=req.getParameter("pin");
		
		long acount=Long.parseLong(accno);
		int  int_pin=Integer.parseInt(pin);
		
		
		CustomerDao cdao=new CustomerDaoImpl();	
		Customer c=cdao.getCustomer(acount, int_pin);
		if(c!=null) {
			
//			req.setAttribute("customer", c);
			req.setAttribute("success", "Welcome "+c.getName());
			RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
//			pw.println("Login successfully "+c.getName());
			}	
	     else {
//			pw.println("Invalid credential");
//	    	 req.setAttribute("customer", c);
			 req.setAttribute("fail", "Invalid credentials");
			 RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
			 rd.forward(req, resp);
		
		}
		}	
	}
	
