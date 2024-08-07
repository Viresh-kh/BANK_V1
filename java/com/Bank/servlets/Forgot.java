package com.Bank.servlets;

import java.io.IOException;

import com.Bank.Dao.CustomerDao;
import com.Bank.Dao.CustomerDaoImpl;
import com.Bank.Dto.Customer;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/forgot")

public class Forgot extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String phone=req.getParameter("phone");
		String mail=req.getParameter("mail");
		String password=req.getParameter("password");
		String confirm=req.getParameter("confirm");
		
		long Phone=Long.parseLong(phone);
		int pin=Integer.parseInt(password);
		int cpin=Integer.parseInt(confirm);
		
		CustomerDao cdao=new CustomerDaoImpl();
		Customer c=cdao.getCustomer(Phone, mail);
		if(Phone==c.getPhone()&&mail.equals(c.getMail()))
		{
			
			
			if(pin==cpin)
			{
				c.setPin(pin);
				boolean res=cdao.updaetcustomer(c);
				if(res)
				{
					req.setAttribute("customer", c);
					req.setAttribute("success", "Pin updated Successfully");
					RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
					rd.forward(req, resp);
				}
				else
				{
					req.setAttribute("customer", c);
					req.setAttribute("fail", "Invalid Credentials");
					RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
					rd.forward(req, resp);
					
				}
			}
			else
			{

				req.setAttribute("customer", c);
				req.setAttribute("fail", "Invalid Credentials");
				RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
				rd.forward(req, resp);
			}
		}
		else
		{

			req.setAttribute("customer", c);
			req.setAttribute("fail", "Invalid Credentials");
			RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
		}
	}
}

