<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/mainStyle.css" rel="stylesheet" type="text/css" media="screen" />
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
	<div id="content">
		<h2>Основно меню в FusionERP</h2>
		<div class="main-menu">
			<button name="createNew" id="createNew" class="createNew" type="submit">Създаване на нов полуфабрикат</button>

			<form method="get" action="redirect" id="subproducts" class="subproducts" style='display: none'>
				<div class="subproducts">
					<button name="cable" id="cable" type="submit">Кабел</button>
					<button name="twisted" id="twisted" type="submit">Усукан</button>
					<button name="splice" id="splice" type="submit">Спойка</button>
				</div>
			</form>

			<form method="get" action="redirect">
				<button name="buyPart" id="buyPart" class="buyPart" type="submit">Покупен материал</button>
			</form>

			<form method="get" action="redirect">
				<button name="infoMenu" id="infoMenu" class="infoMenu" type="submit">Информационно меню</button>
			</form>

		</div>
	</div>
</body>
</html>