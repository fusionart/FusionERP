<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/mainStyle.css" rel="stylesheet" type="text/css" media="screen" />
<title>FusionERP Добре дошли</title>
</head>
<body>
	<div id="content">
		<h2>Добре дошли в FusionERP</h2>
		<div class="log-form">
			<form method="post" action="checkuserandpass">
				<table class="log-table">
					<tr>
						<td><p>Потребителско име</p></td>
					</tr>
					<tr>
						<td><input type="text" name="username" id="username" placeholder="Потребителско име" class="field" required/></td>
					</tr>
					<tr>
						<td><p>Парола</p></td>
					</tr>
					<tr>
						<td><input type="password" name="password" id="password" placeholder="Парола" class="field" required/></td>
					</tr>
					<tr>
						<td><input type="submit" class="logBtn" value="Вход" /></td>
					</tr>
				</table>
			</form>
			<div class="line-style">
			</div>
			<form method="get" action="redirect">
				<input type="submit" name="registration" id="registration"  value="Регистрация">
			</form>
		</div>
	</div>
	<%
		String login_msg = (String) request.getAttribute("message");
		if (login_msg != null)
			out.println(login_msg);
	%>

</body>
</html>