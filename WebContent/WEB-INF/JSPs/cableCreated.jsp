<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/mainStyle.css" rel="stylesheet" type="text/css" media="screen" />
<title>Новосъздаден кабел</title>
</head>
<body>
	<div id="content">
		<div class="log-form">
			<h3>Успешно създадохте кабел</h3>
			<h3><%=request.getAttribute("cableNumber")%></h3>

			<form method="get" action="redirect">
				<input name="backBtn" id="backBtn" type="submit" value="Назад">
			</form>
		</div>
	</div>
</body>
</html>