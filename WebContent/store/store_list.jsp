<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@include file = "../header.html"%>

<c:choose>
	<c:when test = "${admin != null && admin != ''}">
		<h4>${admin.admin_name}さん、道端で寝たらだめですよ</h4>
		<%@include file="../menu/menu_logout.jsp" %>
	</c:when>
	<c:otherwise>
		<%@include file="../menu/menu.jsp" %>
	</c:otherwise>
</c:choose>

<style type="text/css">
table {
    border-collapse: collapse;
    padding: 3px 10px;
}
</style>

<font color="red" >${message}</font>

<h1>店舗検索結果</h1>
<p>${amount}件中 ${fn:length(store_list)}件 ヒットしました</p>
<table style = "border-collapse:separate;border-spacing:10px;">
	<c:forEach var = "s" items = "${store_list}">
		<hr>
		<table>
		<tbody>
			<tr>
				<td rowspan="4"><img src="../images/${s.filename}" height="auto" width="300"></td>
				<td><font size="5">${s.store_name}</font></td>
			</tr>
			<tr>
				<td>【店舗説明】<br>${s.store_description}</td>
			</tr>
			<tr>
				<td>【営業時間】${s.business_hours}</td>
			</tr>
			<tr>
				<td>【住所】${s.store_address}</td>
			</tr>
		</tbody>
		</table>
	</c:forEach>
</table>

<%@include file="../footer.html" %>
