package com.example.Transaction;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.BankCustomer;

@RestController
public class ConnectionServlet extends HttpServlet {
	
	@RequestMapping("/myservlet")
	protected void FetchData(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		try {
		String driver="com.mysql.jdbc.Driver";
		String connectionUrl = "jdbc:mysql://localhost:3306/hcl_data";
		String userid = "root";
		String password = "kirankumar25";
		Class.forName(driver);
		String new_id=null,new_balance=null;
		Connection connection=null;
		Statement statement=null;
		ResultSet resultset=null;
			connection=DriverManager.getConnection(connectionUrl,userid,password);
			statement=connection.createStatement();
			String sql1="SELECT * FROM transactions ORDER BY TransactionId DESC LIMIT 1";
			ResultSet rs=statement.executeQuery(sql1);
			while(rs.next()) {
			new_id=rs.getString("TransactionId");
			new_balance=rs.getString("Balance");
			}
			int p=Integer.valueOf(new_balance)-1000;
			int k=Integer.valueOf(new_id)+1;
			String sql="INSERT INTO transactions(TransactionId,Credit,Debit,Balance)VALUES(?,?,?,?)";
			PreparedStatement st=connection.prepareStatement(sql);
			st.setString(1,String.valueOf(k));
			st.setString(2,"0");
			st.setString(3,"1000");
			st.setString(4,String.valueOf(p));
			int update=st.executeUpdate();
			//BankCustomer customer=null;
			String sql2="SELECT * FROM transactions ORDER BY TransactionId DESC limit 5";
			resultset=statement.executeQuery(sql2);
			ArrayList<BankCustomer> customer=null;
			LastfiveData l=new LastfiveData();
			customer=l.LastData();
			request.setAttribute("data1", customer);
			RequestDispatcher rd =  
		             request.getRequestDispatcher("/WEB-INF/jsp/transaction.jsp");
			rd.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
  }	
	
		@Override
	    protected void doGet(HttpServletRequest request, 
	                        HttpServletResponse response) 
	        throws ServletException, IOException 
	    { 
	        FetchData(request, response); 
	    } 
	    @Override
	    protected void doPost(HttpServletRequest request, 
	                        HttpServletResponse response) 
	        throws ServletException, IOException 
	    { 
	    	
	    	if(request.getParameter("button")!=null)
	    			FetchData(request, response); 
	    	
	    } 
		
}

