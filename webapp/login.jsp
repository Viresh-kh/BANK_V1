<!DOCTYPE html>
<%@page import="com.Bank.Dto.Customer"%>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<style type="text/css">
form {
	width: "400px";
	height: 200px;
	margin-top: 100px;
	margin-left: 500px;
	padding: 30px;
	border: 1px solid black;
	display: inline-block;
	background-color: pink;
	box-shadow: 0 0 10px black;
	border-radius: 10px;
}

#one {
	width: 100px;
	height: 25px;
	border: none;
	border-radius: 3px;
	background-color: orange;
}

button {
	background-color: purple;
	border: none;
	border-radius: 3px;
	width: 100px;
	height: 25px;
}

button:hover {
	background-color: red;
}

a {
	text-decoration: none;
	color: white;
}

a:hover {
	color: white;
}

form h1 {
	text-align: center;
}

h1 {
	text-align: center;
}
</style>
</head>
<body bgcolor="skyblue">
	<%
	Customer c = (Customer) request.getAttribute("customer");
	%>
	<%
	String success = (String) request.getAttribute("success");
	%>
	<%
	String fail = (String) request.getAttribute("fail");
	%>

	<h1>
		<%
		if (success != null) {
		%>
		<%=success%>
		<%
		}
		%>
	</h1>
	<h1>
		<%
		if (fail != null) {
		%>
		<%=fail%>
		<%
		}
		%>
	</h1>
	<form action="login" method="post">
		<h1>Login</h1>
		Enter Account Number: <input type="number" name="accno"
			required="required"><br>
		<br> Enter Password : <input type="password" name="pin"
			required="required"> <br>
		<br> <input type="submit" value="login" id="one">
		<button>
			<a href="forgot.jsp">Forgot Pin</a>
		</button>
		<button>
			<a href="signup.jsp">SignUp</a>
		</button>
	</form>

</body>
</html>