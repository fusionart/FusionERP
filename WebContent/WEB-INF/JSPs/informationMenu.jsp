<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Информационно меню</title>
<script src="js/jquery-3.2.1.min.js" type="text/javascript"></script>
<script>
	$(document).ready(function() {
		$.get('dropdownprojects', {
			project : projects
		}, function(response) {
			var select = $('#project');
			select.find('option').remove();
			$.each(response, function(index, value) {
				$('<option>').val(index).text(value).appendTo(select);
			});
		});
	});
</script>
</head>
<body>

	<form name="getCables" id="getCables">
		<select name="project" id="project">
			<option value="-1">Изберете проект</option>
			<c:forEach items="${dropMenu}" var="dropMenuProjects">
				<option value="${dropMenuProjects.key}">${dropMenuProjects.value}</option>
			</c:forEach>
		</select>
		<input type="submit" value="Давай">
	</form>
	<table>
		<tr>
			<th>Сериен номер</th>
			<th>Проект</th>
			<th>Група</th>
			<th>Сечение</th>
			<th>Цвят</th>
			<th>Дължина</th>
		</tr>
	</table>
</body>
</html>