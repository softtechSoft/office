<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<title>社員ログイン</title>
<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" href="css/common.css">
</head>
<body>
	<div class="box">
		<form:form name="theForm" id="theForm" modelAttribute="loginBean" method="post" action="login">

			<div class="label1">
				<label>ソフトテク株式会社</label>
			</div>
			<br>
			<div>
				<label>社内管理システム</label>
			</div>

			<div style="color: red">
				<h5>
					<c:forEach items="${errors}" var="error">
						<spring:message message="${error}" />
					</c:forEach>
				</h5>
			</div>

			<div>
				<label class="label2">メール：</label> <input id="employeeID"
					name="employeeID" type="text" Value="">
			</div>
			<br>
			<div>
				<label class="label2">パスワード：</label> <input id="password"
					name="password" type="password" Value="">
			</div>
			<br>
			<div>
				<input type="submit" id="login_btn" name="login" Value="ログイン">
				<input type="submit" id="reset_btn" name="resetpswd"  value="パスワード変更">
			</div>
		</form:form>
	</div>
</body>
</html>