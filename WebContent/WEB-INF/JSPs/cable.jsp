<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>fusionERP Създаване на нов кабел</title>

<script src="js/jquery-3.2.1.min.js" type="text/javascript"></script>
<script src="js/cablejs.js" type="text/javascript"></script>


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
	<form class="group-form">
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
			<select name="rsideterminal" id="rsideterminal">
				<option value="-1">Изберете контракт</option>
			</select>
			<select name="rsideseal" id="rsideseal">
				<option value="-1">Изберете сеал</option>
			</select>
		</div>
	</div>
	
	<input type="button" value="Запази">

</body>
</html>