<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/mainStyle.css" rel="stylesheet" type="text/css" media="screen" />
<title>fusionERP Създаване на нов кабел</title>

<script src="js/jquery-3.2.1.min.js" type="text/javascript"></script>
<script src="js/cablejs.js" type="text/javascript"></script>

<script>
	$(document).ready(function() {
		$.get('populatedropdowns', {
			project : "response"
		}, function(response) {
			var select = $('#project');
			select.find('option').remove();
			$('<option>').val("-1").text('Изберете проект').appendTo(select);
			$.each(response, function(index, value) {
				$('<option>').val(index).text(value).appendTo(select);
			});
		});

		$.get('populatedropdowns', {
			section : "response"
		}, function(response) {
			var select = $('#csection');
			select.find('option').remove();
			$('<option>').val("-1").text('Изберете сечение').appendTo(select);
			$.each(response, function(index, value) {
				$('<option>').val(index).text(value).appendTo(select);
			});
		});

		$.get('populatedropdowns', {
			terminal : "response"
		}, function(response) {
			var lSide = $('#lsideterminal');
			var rSide = $('#rsideterminal');
			lSide.find('option').remove();
			rSide.find('option').remove();
			$('<option>').val("-1").text('Изберете контакт').appendTo(lSide);
			$('<option>').val("-1").text('Изберете контакт').appendTo(rSide);
			$.each(response, function(index, value) {
				$('<option>').val(index).text(value).appendTo(lSide);
				$('<option>').val(index).text(value).appendTo(rSide);
			});
		});

		$.get('populatedropdowns', {
			seal : "response"
		}, function(response) {
			var lSide = $('#lsideseal');
			var rSide = $('#rsideseal');
			lSide.find('option').remove();
			rSide.find('option').remove();
			$('<option>').val("-1").text('Изберете сеал').appendTo(lSide);
			$('<option>').val("-1").text('Изберете сеал').appendTo(rSide);
			$.each(response, function(index, value) {
				$('<option>').val(index).text(value).appendTo(lSide);
				$('<option>').val(index).text(value).appendTo(rSide);
			});
		});
	});
</script>

</head>
<body>
	<div id="content">
		<h2>Създаване на нов кабел</h2>
		<div class="new-cable">
			<form method="post" action="generatecablenumber">
				<input type="hidden" name="category" value="C">
				<select name="project" id="project">
					<%-- 			<option value="-1">Изберете проект</option>
			<c:forEach items="${dropMenu}" var="dropMenuProjects">
				<option value="${dropMenuProjects.key}">${dropMenuProjects.value}</option>
			</c:forEach> --%>
				</select>
				<select name="projectGroup" id="projectGroup">
					<option value="-1">Изберете група</option>
				</select>
				<div class="line-style"></div>

				<div class="next-operation">
					<p>Последваща операция</p>
					<label for="form" class="radio-label">Формиране</label>
					<input type="radio" name="nextoperation" value="form" id="form" checked>
					<label for="twisting" class="radio-label">Усукване</label>
					<input type="radio" name="nextoperation" value="twisting" id="twisting">
					<label for="splice" class="radio-label">Спойка</label>
					<input type="radio" name="nextoperation" value="splice" id="splice">
				</div>

				<div class="stripping-div" id="strip" style='display: none'>
					<p>Изберете оголване</p>
					<label for="strip12" class="radio-label">12</label>
					<input type="radio" name="stripping" value="12" id="strip12">
					<label for="strip15" class="radio-label">15</label>
					<input type="radio" name="stripping" value="15" id="strip15">
				</div>

				<div class="line-style"></div>

				<div class="moq-tag">
					<select name="moq" id="moq">
						<option value="0">Изберете партида</option>
						<option value="50">50</option>
						<option value="100">100</option>
						<option value="250">250</option>
						<option value="500">500</option>
						<option value="1000">1000</option>
					</select>
				</div>

				<div class="line-style"></div>

				<div class="production-location">
					<p>Производствена локация</p>
					<label for="loc1" class="radio-label">Локация 1</label>
					<input type="radio" name="prlocation" value="loc1">
					<label for="loc1" class="radio-label">Локация 2</label>
					<input type="radio" name="prlocation" value="loc2">
				</div>
				<div class="for-location">
					<p>Дестинационна локация</p>
					<label for="loc1" class="radio-label">Локация 1</label>
					<input type="radio" name="forlocation" value="loc1" id="loc1">
					<label for="loc1" class="radio-label">Локация 2</label>
					<input type="radio" name="forlocation" value="loc2" id="loc2">
				</div>

				<div class="line-style"></div>

				<div class="bom">
					<p>Материална спецификация</p>
					<div class="cables">
						<div class="cable-section">
							<select name="csection" id="csection">
								<%-- 						<option value="-1">Изберете сечение</option>
						<c:forEach items="${dropMenuCables}" var="dmc">
							<option value="${dmc.key}">${dmc.value}</option>
						</c:forEach> --%>
							</select>
						</div>

						<div class="cable-color">
							<select name="cable-c" id="cable-c">
								<option value="-1">Изберете цвят</option>
							</select>
						</div>

						<label for="clength">Дължина</label>
						<input type="text" name="clength" id="clenght" required>

						<div class="line-style"></div>
					</div>
					<div class="bom-side1">
						<p>Лява страна</p>
						<select name="lsideterminal" id="lsideterminal">
							<%-- 					<option value="-1">Изберете контракт</option>
					<c:forEach items="${dropMenuTerminals}" var="dmt">
						<option value="${dmt.key}">${dmt.value}</option>
					</c:forEach> --%>
						</select>
						<select name="lsideseal" id="lsideseal">
							<%-- 					<option value="-1">Изберете сеал</option>
					<c:forEach items="${dropMenuSeals}" var="dms">
						<option value="${dms.key}">${dms.value}</option>
					</c:forEach> --%>
						</select>
					</div>
					<div class="bom-side2">
						<p>Дясна страна</p>
						<select name="rsideterminal" id="rsideterminal">
							<%-- 					<option value="-1">Изберете контракт</option>
					<c:forEach items="${dropMenuTerminals}" var="dmt">
						<option value="${dmt.key}">${dmt.value}</option>
					</c:forEach> --%>
						</select>
						<select name="rsideseal" id="rsideseal">
							<%-- 					<option value="-1">Изберете сеал</option>
					<c:forEach items="${dropMenuSeals}" var="dms">
						<option value="${dms.key}">${dms.value}</option>
					</c:forEach> --%>
						</select>
					</div>
				</div>
				<input type="submit" value="Запази" class="logBtn">
			</form>
			<div class="line-style"></div>
			<form method="get" action="redirect">
				<input name="backBtn" id="backBtn" type="submit" value="Назад">
			</form>
		</div>
	</div>
</body>
</html>