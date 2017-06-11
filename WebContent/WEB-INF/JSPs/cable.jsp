<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>fusionERP Създаване на нов кабел</title>
</head>
<body>

	<form method="get" action="dropdowndependent">
		<select name="project" id="project" onchange="this.form.submit();">
			<option value="-1">Изберете проект</option>
			<c:forEach items="${dropMenu}" var="dropMenuProjects">
				<option value="${dropMenuProjects.key}">${dropMenuProjects.value}</option>
			</c:forEach>
		</select>
	</form>
	<select name="projectGroup">
		<option value="-1">Изберете група</option>
		<c:forEach items="${groups}" var="group">
			<option value="${group.key}">${group.value}</option>
		</c:forEach>
	</select>

</body>
</html>