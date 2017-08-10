<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Profile Page</title>
</head>
<body>
	<h1><c:out value="${foundPerson.firstName}" /> <c:out value="${foundPerson.lastName}" /> </h1>
	
	<h3>License: <c:out value="${foundLicense.number}" /></h3>
	<h3>State: <c:out value="${foundLicense.state}" /></h3>
</body>
</html>