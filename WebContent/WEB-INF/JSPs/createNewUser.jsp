<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Регистрация</title>
</head>
<body>
	<h3>Регистрация на нов потребител</h3>
	<form method="post" action="createnewuser">
		<table>
			<tr>
				<td><p>Потребителско име</p></td>
				<td><p>Парола</p></td>
			</tr>
			<tr>
				<td><input type="text" name="username" id="username" class="field" /></td>
				<td><input type="password" name="password" id="password" class="field" /></td>
			</tr>
			<td colspan="2" width="100%"><input type="submit" value="Регистрация" /></td>
		</table>
	</form>

	<%
		String login_msg = (String) request.getAttribute("message");
		if (login_msg != null)
			out.println(login_msg);
	%>
</body>
</html>