<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>
<%@include file="../attention.html" %>
<h4>${admin.admin_name}の！ちょっといいとこ見てみたい！</h4>
<%@include file="../menu/menu_logout.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action = "AdminUpdate.action" method = "post">

<h4>下記の内容で更新してよろしいですか？</h4>

<table>
	<tbody>
		<tr>
			<td align="right">管理者ID：</td>
			<td>${check.admin_id}</td>
		</tr>
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
<input type = "submit" value = "更新">
<button type="button" onclick=history.back()>戻る</button>
</p>
</form>
<%@include file="../footer.html" %>
