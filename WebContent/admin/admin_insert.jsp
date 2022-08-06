<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>
<%@include file="../attention.html" %>
<h4>${admin.admin_name}は、20歳になってから。</h4>
<%@include file="../menu/menu_logout.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<font color="red">${message}</font>

<h1>管理者情報登録画面</h1>
<h4>管理者情報の更新部分を入力してください。(※全て入力必須項目です)</h4>

<form action = "AdminInsertCheck.action" method = "post">
	<p>
	<label>ログインID：</label><br>
	(半角英数5～16文字、記号はアンダーバーのみ)<br>
	<input type = "text" name = "login_id" size = "30">
	</p>

	<p>
	<label>パスワード：</label><br>
	(半角英数字5～16文字、記号はアンダーバーのみ)<br>

	<input type = password name = "password" size = "30">
	</p>

	<p>
	<label>パスワード確認：</label><br>
	<input type = password name = "password_check" size = "30">
	</p>

	<p>
	<label>ニックネーム：</label><br>
	(全角＆半角英数1～12文字)<br>
	<input type = text name = "admin_name" size = "30">
	</p>

	<input type = "submit" value = "確認画面へ">
	<button type="button"onclick="location.href='admin-menu.jsp'">戻る</button>
</form>

<%@include file = "../footer.html"%>