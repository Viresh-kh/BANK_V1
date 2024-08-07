<%@page import="com.Bank.Dto.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        div{
        border-radius:10px;
        box-shadow:0 0 10px black;
            margin-top: 100px;
            margin-left: 500px;
            width: 600px;
            height: 500px;
            display: inline-block;
            background-color: pink;
           
        }
       
       
        h1{
        color: Oranged
        }
        
    </style>
   
    
</head>
<body bgcolor="skyblue">
     <%Customer c=(Customer)request.getAttribute("Customer"); %>
     <%String success=(String)request.getAttribute("success"); %>
     <%String failure=(String)request.getAttribute("failure"); %>
<div align="center">
   
    
    <form action="signup" method="post">
     <h1>Welcome To Bank Application</h1>
    
    <h2>Sign_Up Page</h2>
    <%if(success!=null && c!=null){%>
    <%=success%>
    <%}%>
    <%if(failure!=null ){%>
    <%=failure%>
    <%}%>
    <table>
    <tr>
    <td><h3>Enter Your name:</h3></td>
    <td> <input type="text" name="name" required></td>
    
    </tr>
    <tr>
    <td><h3>Enter Phone:</h3></td>
    <td> <input type="tel" name="phone" required></td>
    </tr>
    
    
    <tr>
    <td><h3>Enter Your Email:</h3></td>
    <td> <input type="email" name="mail" required></td>
    
    </tr>
    
    
    
    <tr>
    <td><h3>Enter Your Pin:</h3></td>
    <td> <input type="password" name="pin" required maxlength="4"></td>
    
    </tr>
    <td><h3>Enter Your Pin:</h3></td>
    <td> <input type="password" name="confirm" required maxlength="4"></td>
    
    </tr>
    
    <tr>
       
        <td><input type="submit" name="Sign Up"></td>
        <td><button><a href="login.jsp">Login</a></button></td>
    
    </tr>

    </table>
    </form>
    
    </div>
	
</body>
</html>