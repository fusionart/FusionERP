<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
				<td><input type="text" name="username" id="username"
					class="field" /></td>
				<td><input type="password" name="password" id="password"
					class="field" /></td>
			</tr>
			<td colspan="2" width="100%"><input type="submit" value="Вход" /></td>
			<td></td>
		</table>
	</form>
	<form method="post">
		<td colspan="2" width="100%"><input type="submit" value="Регистрация" /></td>
	</form>

	<%
		String login_msg = (String) request.getAttribute("message");
		if (login_msg != null)
			out.println(login_msg);
	%>

</body>
</html>