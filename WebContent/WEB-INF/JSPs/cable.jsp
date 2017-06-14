<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>fusionERP Създаване на нов кабел</title>

<script src="js/jquery-3.2.1.min.js" type="text/javascript"></script>

<script>
	$(document).ready(function() {

		$('#project').change(function(event) {
			var projects = $("select#project").val();
			$.get('dropdowndependent', {
				project : projects
			}, function(response) {

				var select = $('#projectGroup');
				select.find('option').remove();
				$.each(response, function(index, value) {
					$('<option>').val(index).text(value).appendTo(select);
				});
			});
		});
	});
</script>

</head>
<body>

	<select name="project" id="project">
		<option value="-1">Изберете проект</option>
		<c:forEach items="${dropMenu}" var="dropMenuProjects">
			<option value="${dropMenuProjects.key}">${dropMenuProjects.value}</option>
		</c:forEach>
	</select>

	<select name="projectGroup" id="projectGroup">
		<option value="-1">Изберете група</option>

	</select>

</body>
</html>