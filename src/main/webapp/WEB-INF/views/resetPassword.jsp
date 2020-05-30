<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>パスワード変更</title>
</head>

<body>
	<form:form name="newPwdBean" id="newPwdBean" modelAttribute="resetPasswordBean"
		method="post" action="resetPassword">
		<table bgcolor="lightskyblue" width="680" height="600">
			<tr>
				<td colspan="2" rowspan="1">ソフトテク株式会社</td>
			</tr>
			<tr style="color: red;" align="center">
				<td colspan="2" rowspan="1" height="60">
				   <c:forEach items="${errors}" var="error">
						<spring:message message="${error}" />
					</c:forEach></td>
			</tr>
			<tr align="center">
				<td colspan="2" rowspan="1" height="60">社内管理システム</td>
			</tr>
			<tr>
				<td align="right">メールアカウント：</td>
				<td><form:input path="employeeID" type="text"/></td>
			</tr>
			<tr>
				<td align="right">旧パスワード：</td>
				<td><form:input path="oldPassword" type="password"
					Value=""/></td>
			</tr>
			<tr>
				<td align="right">新パスワード：</td>
				<td><input id="newPassword" name="newPassword" type="password"
					Value=""></td>
			</tr>
			<tr>
				<td align="right">新パスワード：</td>
				<td><input id="newPasswordConfirm" name="newPasswordConfirm" type="password"
					Value=""></td>
			</tr>
			<tr>
				<td colspan="2" rowspan="1" align="center" width="200"><input
					style="border-radius: 3px" type="submit" id="reset_btn" name="reset"
					Value="更新"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>