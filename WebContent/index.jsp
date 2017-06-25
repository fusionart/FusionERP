<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="checkuserandpass">
		<table>
			<tr>
				<td><p>Потребителско име</p></td>
				<td><p>Парола</p></td>
			</tr>
			<tr>
				<td><input type="text" name="username" id="username" class="field" /></td>
				<td><input type="password" name="password" id="password" class="field" /></td>
			</tr>
			<tr>
				<td colspan="2" width="100%"><input type="submit" value="Вход" /></td>
			</tr>
		</table>
	</form>
	<form method="get" action="redirect">
		<button name="registration" id="registration" type="submit">Регистрация</button>
	</form>

	<%
		String login_msg = (String) request.getAttribute("message");
		if (login_msg != null)
			out.println(login_msg);
	%>

</body>
</html>