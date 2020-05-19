<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>

<html>
<head>
<title>パスワード変更</title>
<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" href="css/common.css">

</head>
<body>
	<div class="box">
		<form:form name="theForm" id="theForm" modelAttribute="loginBean"
			method="post">
			<div class="label1">
				<label>現在のパスワード</label>
				<input id="password"
					name="password" type="password" Value="">
			</div>
			<br>

			<div>
				<label class="label2">新しいパスワード：</label> <input id="newpassword"
					name="newpassword" type="password" Value="">
			</div>
			<div>
				<label class="label2">もう一度新しいパスワード：</label> <input id="newpassword"
					name="newpassword" type="password" Value="">
			</div>
			<br>
			<div>
				<input type="reset" id="reset_btn" value="パスワード変更">

			</div>
		</form:form>
	</div>
</body>

</html>