<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="CSS/style.css" rel="stylesheet" type="text/css" media="screen" />
<link href="css/mainStyle.css" rel="stylesheet" type="text/css" media="screen" />
<script src="js/jquery-3.2.1.min.js" type="text/javascript"></script>
<script>
	$(document)
			.ready(
					function() {
						var $submitBtn = $("#form input[type='submit']");
						var $passwordBox = $("#password");
						var $confirmBox = $("#confirm_password");
						var $rePas = $('#rePass')
						var $errorMsg = $('<span id="error_msg">Двете пароли не съвпадат.</span>');

						$submitBtn.removeAttr("disabled");

						function checkMatchingPasswords() {
							if ($confirmBox.val() != ""
									&& $passwordBox.val != "") {
								if ($confirmBox.val() != $passwordBox.val()) {
									$submitBtn.attr("disabled", "disabled");
									$errorMsg.insertAfter($rePas);
								}
							}
						}

						function resetPasswordError() {
							$submitBtn.removeAttr("disabled");
							var $errorCont = $("#error_msg");
							if ($errorCont.length > 0) {
								$errorCont.remove();
							}
						}

						$("#confirm_password, #password").on("keydown",
								function(e) {
									if (e.keyCode == 13 || e.keyCode == 9) {
										checkMatchingPasswords();
									}
								}).on("blur", function() {
							checkMatchingPasswords();
						}).on("focus", function() {
							resetPasswordError();
						})

					});
</script>
<title>Регистрация</title>
</head>
<body>
	<div id="content">
		<h2>Регистрация на нов потребител</h2>
		<div class="log-form">
			<form class="form" name="form" id="form" method="post" action="createnewuser">
				<table class="log-table">
					<tr>
						<td><p>Потребителско име</p></td>
						<td><input type="text" name="username" id="username" required></td>
					</tr>
					<tr>
						<td colspan="2" class="small-font">Може да съдържа букви и цифри, без интервали</td>
					</tr>
					<tr>
						<td><p>Парола</p></td>
						<td><input type="password" name="password" id="password" pattern=".{4,}" required title="4 characters minimum"></td>
					</tr>
					<tr>
						<td colspan="2" class="small-font">Минимална дължина 4 символа</td>
					</tr>
					<tr>
						<td><p>Парола (потвърждение)</p></td>
						<td><input type="password" name="confirm_password" id="confirm_password" required> <span id="indicator"></span></td>
					</tr>
					<tr>
						<td colspan="2" class="small-font">Въведете отново Вашата парола</td>
					</tr>
					<tr id="rePass">
					</tr>
					<tr>
						<td colspan="2" width="100%"><input type="submit" name="submit" class="logBtn" value="Регистрация" /></td>
					</tr>
				</table>
			</form>
			<div class="user-exists">
			<%
				String login_msg = (String) request.getAttribute("message");
				if (login_msg != null)
					out.println(login_msg);
			%>
			</div>
		</div>
	</div>


</body>
</html>