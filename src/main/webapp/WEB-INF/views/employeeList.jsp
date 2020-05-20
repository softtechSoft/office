<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<%--HTML 5対応--%>

<html>
<head>
<title>給料リスト</title>
<link rel="stylesheet" href="css/tabulator.css">
<link href="css/tabulator_midnight.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="js/jquery.json.js"></script>

<script type="text/javascript" src="js/jquery-ui.js"></script>
<script type="text/javascript" src="js/jquery-ui.min.js"></script>

<script type="text/javascript" src="js/tabulator.min.js"></script>
<script type="text/javascript" src="js/tabulator.js"></script>
</head>

<body>

	<form:form name="employeeListForm" id="employeeListForm" modelAttribute="employeeBean" method="get">
	  どうやって、コントールクラスと結びつくの？
	<c:out value="${aVar}" />
	  <!--  
		<h1>人物設定</h1>
		<br>
		<div>
			<input id="s_ID" name="s_ID" type="text" Value="">(隐藏项目=s_ID，调试用)
		</div>
		<br>
		<div>
			<label>社員ID</label> <form:input path="employeeNo"  />
		</div>
		<br>
		<div>
			<label>姓名</label> <input id="employeeName" name="employeeName" type="text" Value="${employeeName}">
		</div>
		<br>
		<div>
			<label>電話番号</label> <input id="phoneNumber" name="phoneNumber" type="text" Value="${phoneNumber}">
		</div>
		<br>
		<div>
			<label>性別</label> <select id="sex" name="sex" style="width: 60px">
				<option value="" selected="selected"></option>
				<option value="女">女</option>
				<option value="男">男</option>
			</select>
		</div>
		<br>
		<div>
			<label>生年月日</label> <input id="birthDate" name="birthDate" type="text" Value="${birthDate}">
		</div>
		<br>
		<div>
			<label>入社年月日</label> <input
				id="nyushaDate" name="nyushaDate" type="text" Value="${nyushaDate}">
		</div>

		<br>
		
		
		<br>
		<div>
			<table id="emlist" style="width: 70%">
				<thead>
					<tr>
						<th>社員一覧</th>
					</tr>
				</thead>
				<tbody></tbody>
			</table>
		</div>
		<br>
		<div>
			<div id="example-table"></div>
		</div>
		-->
	</form:form>
</body>

</html>
