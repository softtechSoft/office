<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>

<html>
<head>
<title>社員ログイン</title>

</head>
<body>
	<form:form name="theForm1" id="theForm1" modelAttribute="loginbeanNew" method="get"
	 >
		<h1>ソフトテク株式会社222222</h1>
		<h2>社内管理システム22222</h2>
		<br>
		<div>
			<label>社員ID：</label>
			<input id="employeeID" name="employeeID" type="text" Value="" >
			<form:errors path="employeeID" cssStyle="color:red" />
		</div>
		<br>
		<div>
			<label>パスワード：</label>
			<input id="password" name="password" type="text" Value="" >
		</div>
		<div>
			<input type="submit" id="login_btn" Value="ログイン" >
			 <input type="reset" id="reset_btn" value="パスワード変更" >
		</div>
	</form:form>
</body>

</html>