<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Product</title>
</head>
<body>
	<div align="center">
		<form:form action="${pageContext.request.contextPath}/product/save"
			method="post" modelAttribute="productForm">
			<table>
				<tr>
					<td><form:label path="name">Name</form:label></td>
					<td><form:input path="name" /></td>
					<td><form:errors path="name" /></td>
				</tr>
				<tr>
					<td><form:label path="quantity">Quantity</form:label></td>
					<td><form:input path="quantity" /></td>
					<td><form:errors path="quantity" /></td>
				</tr>
				<tr>
					<td><form:label path="category.id">category</form:label></td>
					<td><form:select path="category.id" items="${categories}"
							itemValue="id" itemLabel="name" /></td>
					<td><form:errors path="category.id" /></td>
				</tr>
				<tr>
					<td></td>
					<td><form:button value="Add">Add</form:button></td>
				</tr>
				<form:hidden path="id" />
			</table>
		</form:form>
	</div>
</body>
</html>