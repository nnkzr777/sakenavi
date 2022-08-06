<%@page contentType="text/html; charset=UTF-8" %>
<%@ include file="../header.html" %>
<%@include file="../attention.html" %>
<h4>酒と${admin.admin_name}と男と女</h4>
<%@include file="../menu/menu_logout.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style type="text/css">
table, td, th {
    border-bottom: 1px solid gray;
    padding: 3px 10px;
}
table {
    border-collapse: collapse;
}
</style>

<font color="red">${message}</font>

<h1>管理者更新･削除選択ページ</h1>

<table>
	<tr>
		<td>No.</td>
		<td>ログインID</td>
		<td>ニックネーム</td>
		<td>登録日時</td>
		<td></td>
		<td></td>
	</tr>
<c:forEach var = "a" items = "${admin_list}">
	<tr>
		<td>${a.admin_id}</td>
		<td>${a.login_id}</td>
		<td>${a.admin_name}</td>
		<td>${a.time}</td>
		<td><a href = AdminSearch.action?admin_id=${a.admin_id}>更新</a></td>
		<td><a href = AdminDeleteCheck.action?admin_id=${a.admin_id}>削除</a></td>
	</tr>
</c:forEach>
</table>

<%@include file="../footer.html" %>