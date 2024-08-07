<%@page import="com.Bank.Dto.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        body{
            display: flex;
            justify-content: center;
            align-items: center;
            height: 80vh;
        }
        form{
            width: 500px;
            height: 350px;
            background-color: aliceblue;
            padding: 30px;
            box-shadow: 0 0 10px black;
            border: none;
            border-radius: 10px;
            

        }
        input{
            width: 85%;
            padding: 10px;
            margin: 10px;
            border-radius: 8px;
            border:1px solid black;

        }
        #one{
            width: 80px;
            height: 40px;
           
            border-radius: 8px;
        }
        button{
         width: 80px;
            height: 40px;
             
            border-radius: 8px;
        }
        a{
        text-decoration: none;
        font-size: 14px;}
        
    </style>
</head>
<body>
    <%Customer c=(Customer)request.getAttribute("customer"); %>
	<%String s=(String)request.getAttribute("success"); %>
	<%String f=(String)request.getAttribute("fail"); %>
	
    <form action="forgot" method="post">
    <h1><% if(s!=null){ %>
	<%=s %>
	<%} %>
	</h1>
	<h1><% if(f!=null){ %>
	<%=f %>
	<%} %>
	</h1>
        <h2>Update Password</h2>
        <input type="tel" name="phone" placeholder="Enter Phone number" required>
        <input type="email" name="mail" placeholder="Enter Email" required>
        <input type="password" name="password" id="" placeholder="Enter password" required>
        <input type="password" name="confirm" id="" placeholder="Confirm password" required>
        <input type="submit" value="Upade Pin" id="one">
       	
        <button><a href="login.jsp">Login</a></button>

    </form>
</body>
</html>