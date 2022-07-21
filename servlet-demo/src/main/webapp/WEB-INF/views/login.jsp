<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp title</title>
</head>
<!-- 
	scriplets: we can write java inside <% %> 
	can do imports also.
	
	if date is a scriptlet variable, we can show it in the html with scriptlet expression.
	using: =varName inside <%%>
	
 -->
<div>
<%Date date = new java.util.Date();%>
</div>

<body>
	date=<%=date%>
	login jsp passed attribute: ${attrName}
	
	<!-- 
		action is the route the form submit redirects to.
	 -->
	<form action="login.do" method="POST">
		name: <input type="text" name="inp-name"/>
		pass: <input type="password" name="inp-pass"/>
		<input type="submit" />
	</form>
	
</body>
</html>