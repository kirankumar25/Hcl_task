<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.example.Transaction.ConnectionServlet" %>
<%@page import="java.util.*" %>
<%@page import="com.example.Transaction.LastfiveData" %>
<%@page import="com.example.model.BankCustomer" %>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%! static int value=0; %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet"
 href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
 integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
 crossorigin="anonymous">
</head>
<body>
	<h2 align="center">Transactional Database</h2>
	<div class="container my-2">
	<table border="1" class = "table table-striped table-responsive-md">
	<tr>
	<td><b>TransactionId</b></td>
	<td><b>Credit</b></td>
	<td><b>Debit</b></td>
	<td><b>Balance</b></td>
	</tr>
<%
	
	if(value!=0){
		
	try{
	ArrayList<BankCustomer> std =  
            (ArrayList<BankCustomer>)request.getAttribute("data1"); 
        for(BankCustomer s:std){%> 
        
        <%--This table only visible when the request is forwarded to 
        		servlet when clicks on button and also value sets to 1 --%>
         <%-- The value sets to 1 indicated to visible --%>
        <%-- Arranging data in tabular form 
        --%> 
            <tr> 
                <td><%=s.getTransactionId()%></td> 
                <td><%=s.getCredit()%></td> 
                <td><%=s.getDebit()%></td>
                <td><%=s.getBalance() %> 
            </tr> 
            <%}}catch(Exception e){
            	e.printStackTrace();
            }
	}
      else{%> 
<%
try{
	
	
	
	LastfiveData l=new LastfiveData();
	ArrayList<BankCustomer> std =  null;
	std=l.LastData();
        for(BankCustomer s:std){%>     
    <%-- The value sets to 0 by default indicates not to visible after funds transfer --%>
        <%-- Arranging data in tabular form --%> 
            <tr> 
                <td><%=s.getTransactionId()%></td> 
                <td><%=s.getCredit()%></td> 
                <td><%=s.getDebit()%></td>
                <td><%=s.getBalance() %> 
            </tr> 
            <%}
 
	}catch(Exception e){
            	e.printStackTrace();
           }
%>
</tr>
</table>
</div>
<%-- Button will be shown before funds transfer and depends on value --%>

 <div align="center" class="container my-2">
	<div align="center" class="col-sm-1">
		<form action="myservlet" method="post">
		<% value=1;%>
			<input  type="submit" name="button" value="Transfer">	
		</form>
		<script>
		window.onbeforeunload = function () {
		    if (someConditionThatIndicatesIShouldConfirm) {
		        return "If you reload this page, you might lost the data";
		    } else {
		     //
		    }
		}
		</script>
	</div>
</div>
<% }%>
</div>
</body></html>