package com.example.Transaction;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.BankCustomer;

public class LastfiveData extends HttpServlet{

	
	public ArrayList<BankCustomer> LastData(){
		
		ArrayList<BankCustomer> customer=new ArrayList<BankCustomer>();
	try {
		String driver="com.mysql.jdbc.Driver";
		String connectionUrl = "jdbc:mysql://localhost:3306/hcl_data";
		String userid = "root";
		String password = "kirankumar25";
		Class.forName(driver);
		Connection connection=null;
		Statement statement=null;
		ResultSet resultset=null;
		connection=DriverManager.getConnection(connectionUrl,userid,password);
		statement=connection.createStatement();
		String sql2="SELECT * FROM transactions ORDER BY TransactionId DESC limit 5";
		resultset=statement.executeQuery(sql2);
		while(resultset.next() && resultset!=null){
			customer.add(new BankCustomer(resultset.getString("TransactionId"),
					resultset.getString("Credit"),
					resultset.getString("Debit"),
					resultset.getString("Balance")
					));
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
	return customer;	
 }

	
}

