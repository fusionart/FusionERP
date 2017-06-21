<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FusionERP Основно меню</title>
<script src="js/jquery-3.2.1.min.js" type="text/javascript"></script>
<script>
	$(document).ready(function() {
		$('#createNew').click(function() {
			$('#subproducts').toggle(350);
		});
	});
</script>
</head>
<body>

	<button name="createNew" id="createNew" type="submit">Създаване
		на нов полуфабрикат</button>


	<form method="get" action="redirect" id="subproducts"
		style='display: none'>
		<button name="cable" id="cable" type="submit">Кабел</button>
		<button name="twisted" id="twisted" type="submit">Усукан</button>
		<button name="splice" id="splice" type="submit">Спойка</button>
	</form>

	<form method="get" action="redirect">
		<button name="buyPart" id="buyPart" type="submit">Покупен
			материал</button>
	</form>
	<form method="get" action="redirect">
		<button name="infoMenu" id="infoMenu" type="submit">Информационно
			меню</button>
	</form>
</body>
</html>