package com.Bank.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.Bank.Dao.CustomerDao;
import com.Bank.Dao.CustomerDaoImpl;

import com.Bank.Dto.Customer;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/signup")


public class SignUp extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		PrintWriter pw=resp.getWriter();
		String name=req.getParameter("name");
		String phone=req.getParameter("phone");
		String mail=req.getParameter("mail");
		String pin=req.getParameter("pin");
		String confirm=req.getParameter("confirm");
		
		//Conversion or parsing the data
		long mobile=Long.parseLong(phone);
		int  String_pin=Integer.parseInt(pin);
		int cpin=Integer.parseInt(confirm);
		
		
		
		//JDBC 
		Customer c=new Customer();
		CustomerDao cdao=new CustomerDaoImpl();
		c.setName(name);
		c.setPhone(mobile);
		c.setMail(mail);
		if(String_pin==cpin) {
			c.setPin(String_pin);
			
				boolean res=cdao.insertCustomer(c);
				if(res) {
					c=cdao.getCustomer(mobile,mail);
//					pw.println("<h1>Hi " +name+",your account number has been created. Your account is "+c.getAccno()+"</h1>");
					req.setAttribute("Customer", c);
					req.setAttribute("success","Account has been Created Successfully ! Account Number is "+c.getAccno());
					RequestDispatcher rd=req.getRequestDispatcher("signup.jsp");
					rd.forward(req, resp);
				
				}else {
//					System.out.println("failed to create an account");
					req.setAttribute("Customer", c);
					req.setAttribute("failure","Fail to Create Account");
					RequestDispatcher rd=req.getRequestDispatcher("signup.jsp");
					rd.forward(req, resp);
			}
		}
		
	}

}
