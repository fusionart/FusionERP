<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Новосъздаден кабел</title>
</head>
<body>

	<h2>
		Успешно създадохте кабел
		<%=request.getAttribute("cableNumber")%></h2>

	<form method="get" action="redirect">
		<input name="backBtn" id="backBtn" type="submit" value="Назад">
	</form>

</body>
</html>