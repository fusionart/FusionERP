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

		$('#csection').change(function(event) {
			var cables = $("select#csection").val();
			$.get('dropdowndependent', {
				colors : cables
			}, function(response) {
				var select = $('#cable-c');
				select.find('option').remove();
				$.each(response, function(index, value) {
					$('<option>').val(index).text(value).appendTo(select);
				});
			});
		});

		$('input[type="radio"]').click(function() {
			if ($(this).attr('id') == 'splice') {
				$('#strip').show('slow');
			}
			else if ($(this).attr('id') == 'form'||$(this).attr('id') == 'twisting'){
				$('#strip').hide('slow');
				} 
		});
	});
</script>

</head>
<body>
	<form class="project-form">
		<select name="project" id="project">
			<option value="-1">Изберете проект</option>
			<c:forEach items="${dropMenu}" var="dropMenuProjects">
				<option value="${dropMenuProjects.key}">${dropMenuProjects.value}</option>
			</c:forEach>
		</select>
	</form>
	<form class="group-form"></form>
	<select name="projectGroup" id="projectGroup">
		<option value="-1">Изберете група</option>
	</select>
	</form>
	<div class="next-operation">
		<p>Последваща операция</p>
		<input type="radio" name="nextoperation" value="form" id="form" checked="uncheked"> Формиране 
		<input type="radio" name="nextoperation" value="twisting" id="twisting"> Усукване 
		<input type="radio" name="nextoperation" value="splice" id="splice"> Спойка
	</div>
	
	<div class="stripping-div" id="strip" style='display:none'>
		<p>Изберете оголване</p>
		<input type="radio" name="stripping" value="12"> 12 
		<input type="radio" name="stripping" value="15"> 15 
	</div>


	<div class="moq-tag">
		<select name="moq" id="moq">
			<option value="0">Изберете партида</option>
			<option value="1">50</option>
			<option value="2">100</option>
			<option value="3">250</option>
			<option value="4">500</option>
			<option value="5">1000</option>
		</select>
	</div>
	<div class="production-location">
		<p>Производствена локация</p>
		<input type="radio" name="prlocation" value="loc1"> Локация 1
		<input type="radio" name="prlocation" value="loc2"> Локация 2
	</div>
	<div class="for-location">
		<p>Дестинация локация</p>
		<input type="radio" name="forlocation" value="loc1"> Локация 1
		<input type="radio" name="forlocation" value="loc2"> Локация 2
	</div>
	
	<div class="bom">
		<p>Материална спецификация</p>
		<div class="cables">
			<div class="cable-section">
			<select name="csection" id="csection">
				<option value="-1">Изберете сечение</option>
				<c:forEach items="${dropMenuCables}" var="dmc">
					<option value="${dmc.key}">${dmc.value}</option>
				</c:forEach>
			</select>			
			</div>
			
			<div class="cable-color">
			<select name="cable-c" id="cable-c">
				<option value="-1">Изберете цвят</option>
			</select>			
			</div>

		</div>
		<div class="bom-side1">
			<p>Лява страна</p>
			<select>
				<option value="-1">Изберете контракт</option>
			</select>
			<select>
				<option value="-1">Изберете сеал</option>
			</select>
		</div>
		<div class="bom-side2">
			<p>Дясна страна</p>
			<select>
				<option value="-1">Изберете контракт</option>
			</select>
			<select>
				<option value="-1">Изберете сеал</option>
			</select>
		</div>
	</div>
	
	<input type="button" value="Запази">

</body>
</html>