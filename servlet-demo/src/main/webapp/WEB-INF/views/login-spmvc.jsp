<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp title</title>
</head>

<body>

	<!-- 
		action goes to spring-mvc/login which is mapped to LoginController
		no need to prefix with "spring-mvc/"
	 -->
	<form action="login" method="POST">
		name: <input type="text" name="name"/>
		pass: <input type="password" name="pass"/>
		<input type="submit" />
	</form>
	
</body>
</html>