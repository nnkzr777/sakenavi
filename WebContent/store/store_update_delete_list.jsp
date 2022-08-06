<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file = "../header.html"%>
<%@include file="../attention.html" %>
<h4>${admin.admin_name}さん、こちら店長からのサービスです！</h4>
<%@include file="../menu/menu_logout.jsp" %>

<style type="text/css">
table, td, th {
    border-bottom: 1px solid gray;
    padding: 3px 10px;
}
table {
    border-collapse: collapse;
}
</style>

<font color="red" >${message}</font>

<h1>登録店舗一覧</h1>

<table>
	<tbody>
		<tr>
			<td>店舗ID</td>
			<td>店舗名</td>
			<td></td>
			<td></td>
		</tr>
		<c:forEach var = "s" items = "${store_list}">
		<tr>
			<td>${s.store_id}</td>
			<td>${s.store_name}</td>
			<td><a href = "StoreSearch.action?store_id=${s.store_id}">更新</a></td>
			<td><a href = "StoreDeleteCheck.action?store_id=${s.store_id}">削除</a></td>
		</tr>
		</c:forEach>
	</tbody>
</table>

<%@include file="../footer.html" %>
