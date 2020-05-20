<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<title>パスワード変更</title>
<link rel="stylesheet" href="css/resetPassword.css">
</head>
<body>
<div class="box">
		<form:form name="theForm1" id="theForm1"
		modelAttribute="resetPasswordBean" method="post"
		action="doRest">
<div class="label1">
				<label>ソフトテク株式会社</label>
			</div>
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
				<label class="label2">メール：</label>
				<input id="employeeID" name="employeeID" type="text" >
			</div>
			<div class="label3">
				<label>現在のパスワード:</label>
				<input id="oldPassword" name="oldPassword" type="password" >
			</div>
			<br>

			<div>
				<label class="label4">新しいパスワード：</label>
				<input id="password1" name="password1" type="password" >
			</div>
			<div>
				<label class="label5">もう一度新しいパスワード：</label>
				<input id="password2"name="password2" type="password" >
			</div>
			<br>
			<div>
				<input type="submit" id="reset_btn1" name="resetpswd1" value="パスワード変更">
			</div>
		</form:form>
</div>
</body>
</html>