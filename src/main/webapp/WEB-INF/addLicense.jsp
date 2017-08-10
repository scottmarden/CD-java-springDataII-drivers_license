<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New License</title>
</head>
<body>
	<div class="header">
		<h1>New Person</h1>
		<a href="/">Home</a>
	</div>
	<div class="content">
		<form:form action="/licenses/new" method="POST" modelAttribute="license">
			<form:label path="person">Person: 
			<form:errors path="person" />
			<form:select path="person" >
				<c:forEach items="${people}" var="person">
					<form:option value="${person}" label="${person.firstName}  ${person.lastName}" />
				</c:forEach>
			</form:select></form:label>
			
			<form:label path="state">State: 
			<form:errors path="state" />
			<form:input path="state" /></form:label>
			
			<form:label path="expiration_date">Expiration Date:
			<form:errors path="expiration_date" />
			<form:input type="date" path="expiration_date" /></form:label>
			
			<input type="submit" value="Add License"/>
		</form:form> 
	</div>
</body>
</html>