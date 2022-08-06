<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>
<%@include file="../attention.html" %>
<p>も～来るの遅いよ～、${admin.admin_name}さん！</p>
<%@include file="../menu/menu_logout.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action = "AdminInsert.action" method = "post">

<h4>下記の内容で登録してよろしいですか？</h4>

<table>
	<tbody>
		<tr>
			<td align="right">ログインID：</td>
			<td>${check.login_id}</td>
		</tr>
		<tr>
			<td align="right">パスワード：</td>
			<td>${check.password}</td>
		</tr>
		<tr>
			<td align="right">ニックネーム：</td>
			<td>${check.admin_name}</td>
		</tr>

	</tbody>
</table>

<p>
<button onclick="AdminInsert.action">登録</button>
<button type="button" onclick=history.back()>戻る</button>
</p>
</form>
<%@include file="../footer.html" %>
