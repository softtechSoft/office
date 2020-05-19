<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>

<% Map<String,String> map=new LinkedHashMap<>();
   map.put("社員名","employeeName");
   map.put("住所","address");
   map.put("支払日","paymentDate");
   map.put("基本給","base");
   map.put("残業代","overTimePlus");
   map.put("稼働不足減","shortageReduce");
   map.put("交通費","transportExpense");
   map.put("手当加算","allowancePlus");
   map.put("手当減算","allowanceReduce");
   map.put("手当理由","allowanceReason");
   map.put("厚生控除個人","welfareSelf");
   map.put("厚生控除会社","welfareComp");
   map.put("厚生控除子育(会社)","welfareBaby");
   map.put("雇用保険個人","eplyInsSelf");
   map.put("雇用保険会社","eplyInsComp");
   map.put("雇用保拠出金(会社)","eplyInsWithdraw");
   map.put("社宅家賃控除","rental");
   map.put("社宅管理費控除","rentalMgmtFee");
   map.put("源泉控除","withholdingTax");
   map.put("住民税控除","municipalTax");
   map.put("総額","sum");
   request.setAttribute("list",map);
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>給料明細</title>
</head>
<body>
  <form:form id="fbean" name="fbean" modelAttribute="salaryinfo" method="post" action="doSalary">
    <div style="color: red;">
	   <c:forEach items="${errors}" var="error">
		 <spring:message message="${error}" />
	   </c:forEach>
	</div>
    <table bgcolor="lightskyblue" width="780" height="600">
    <caption caption align="center"><h1>給料明細</h1></caption>
    <tr height="50">
    <td align="left">
    <c:choose>
    <c:when test="${preflg}">
       <input type="submit" id="lastmth_btn" name="lastmth_btn" value=" 前月 ">
       </c:when>
        <c:otherwise>
       <input type="submit" id="lastmth_btn" name="lastmth_btn" value=" 前月 " disabled>
     </c:otherwise>
       </c:choose>
    </td>
    <td align="center">
      <form:input type="text" path="month" readonly="readonly" style="background-color:transparent;border:none;" />
    </td>
    <td align="right">
    <c:choose>
     <c:when test="${nextflg}">
       <input type="submit" id="nextmth_btn" name="nextmth_btn" value=" 次月 ">
     </c:when>
     <c:otherwise>
       <input type="submit" id="nextmth_btn" name="nextmth_btn" value=" 次月 " disabled>
     </c:otherwise>
    </c:choose>
	</td>
    </tr>
    <c:forEach var="entry" items="${list}" varStatus="status">
        <c:if test="${status.count%2==0}">
             <tr style="background-color: #ffffff;">
                 <td style="width:165px;padding-left:50px;font-weight:600 "><c:out value="${entry.getKey()}"/></td>
                 <td colspan="2" rowspan="1"><form:input type="text" readonly="readonly" path="${entry.getValue()}" style="font-size:18px;height:34px;background:none;outline:none;border:none;" /></td>
             </tr>
        </c:if>
         <c:if test="${status.count%2!=0}">
             <tr style="background-color: #dddddd;">
                 <td style="width:165px;padding-left:50px;font-weight:600 "><c:out value="${entry.getKey()}"/></td>
                 <td colspan="2" rowspan="1"><form:input type="text" readonly="readonly" path="${entry.getValue()}" style="font-size:18px;height:34px;background:none;outline:none;border:none;" /></td>
             </tr>
        </c:if>
     </c:forEach>
		<tr align="center">
			<td colspan="3" rowspan="1" height="60">
			<input style="border-radius: 3px" type="submit" name="logout" id="logout_btn" Value="ログアウト" onclick="return logout()">
			</td>
		</tr>
	</table>
	</form:form>
</body>
</html>