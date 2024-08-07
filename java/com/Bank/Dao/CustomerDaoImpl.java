package com.Bank.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.Bank.Connector.Connector;
import com.Bank.Dto.Customer;


public class CustomerDaoImpl  implements CustomerDao{

	private Connection con;
	public CustomerDaoImpl() {
	this.con=Connector.requestConnection();
	}
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	@Override
	public boolean insertCustomer(Customer c) {
		
		String query="Insert into customer(Name,Phone,Mail,Pin)values(?,?,?,?)";
		try {
		con.setAutoCommit(false);
		ps=con.prepareStatement(query);
		ps.setString(1,c.getName());
		ps.setLong(2,c.getPhone());
		ps.setString(3,c.getMail());
		ps.setInt(4,c.getPin());
		int res=ps.executeUpdate();
		if(res>0) {
			con.commit();
			return true;
		}else {
			con.rollback();
			return false;
		}
		
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		
		return false;
	}
	
	
	@Override
	public Customer getCustomer(long accno, int pin) {
		Customer c=null;
		String query="select * from customer where acc_no=? and pin=?";
		try {
			
			ps=con.prepareStatement(query);
			ps.setLong(1, accno);
			ps.setInt(2, pin);
			rs=ps.executeQuery();
			if(rs.next()) {
				c=new Customer();
				c.setAccno(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setPhone(rs.getLong(3));
				c.setMail(rs.getString(4));
				c.setBal(rs.getDouble(5));
				c.setPin(rs.getInt(6));		
					
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	@Override
	public Customer getCustomer(long phone, String mail) {
		Customer c=null;
		String query="SELECT * from customer where phone=? or mail=?";
		try {
			ps=con.prepareStatement(query);
			ps.setLong(1, phone);
			ps.setString(2, mail);
			rs=ps.executeQuery();
			if(rs.next()) {
				c=new Customer();
				c.setAccno(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setPhone(rs.getLong(3));
				c.setMail(rs.getString(4));
				c.setBal(rs.getDouble(5));
				c.setPin(rs.getInt(6));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return c;
	}
	@Override
	public Customer getCustomer(long accno) {
		Customer c=null;
		String query="SELECT * from customer where acc_no=?";
		try {
			ps=con.prepareStatement(query);
			ps.setLong(1, accno);
			
			rs=ps.executeQuery();
			if(rs.next()) {
				c=new Customer();
				c.setAccno(rs.getLong(1));
				c.setName(rs.getString(2));
				c.setPhone(rs.getLong(3));
				c.setMail(rs.getString(4));
				c.setBal(rs.getDouble(5));
				c.setPin(rs.getInt(6));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return c;
	}
	@Override
	public List getCustomer() {
		
		return null;
	}
	@Override
	public boolean updaetcustomer(Customer c) {
		
		String query="update customer set name=?,phone=?,mail=?,balance=?,pin=? where acc_no=?";
		try {
			con.setAutoCommit(false);
		ps=con.prepareStatement(query);
		ps.setString(1, c.getName());
		ps.setLong(2,c.getPhone());
		ps.setString(3, c.getMail());
		ps.setDouble(4, c.getBal());
		ps.setInt(5,c.getPin());
		ps.setLong(6, c.getAccno());
		int res=ps.executeUpdate();
		if(res>0) {
			con.commit();
			return true;
		}else {
			return false;
		}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	
		return false;
	}
	@Override
	public boolean deleteCustomer(Customer c) {
		String query="delete from  customer where acc_no=?";
		try {
		ps=con.prepareStatement(query);
		
		ps.setLong(1,c.getAccno());
		int res=ps.executeUpdate();
		if(res>0) {
			con.commit();
			return true;
		}else {
			con.rollback();
			return false;
		}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}


}
