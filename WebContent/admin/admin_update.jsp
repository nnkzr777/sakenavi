<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>
<%@include file="../attention.html" %>
<h4>領収書の宛名は${admin.admin_name}様でよろしいですか？</h4>
<%@include file="../menu/menu_logout.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<font color="red">${message}</font>

<h1>管理者情報更新画面</h1>
<h4>管理者情報の更新部分を入力してください。(※全て入力必須項目です)</h4>

<form action = "AdminUpdateCheck.action" method = "post">
	<p>
	<label>ログインID：</label><br>
		(半角英数5～16文字、記号はアンダーバーのみ)<br>
	<input type = "text" name = "login_id" size = "30" value = "${admin_update.login_id}">
	</p>

	<p>
	<label>現在のパスワード：</label><br>
	<input type = password name = "password_check" size = "30">
	</p>

	<p>
	<label>新パスワード：</label><br>
	(半角英数5～16文字、記号はアンダーバーのみ)<br>
	<input type = password name = "new_password" size = "30">
	</p>

	<p>
	<label>新パスワード確認：</label><br>
	<input type = password name = "new_password_check" size = "30">
	</p>

	<p>
	<label>ニックネーム：</label><br>
	(全角＆半角英数1～12文字)<br>
	<input type = text name = "admin_name" size = "30" value = "${admin_update.admin_name}">
	</p>

	<input type = "submit" value = "確認画面へ">
	<button type="button"onclick="location.href='admin-list.jsp'">戻る</button>
</form>

<%@include file = "../footer.html"%>