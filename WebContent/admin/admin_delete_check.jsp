<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>
<%@include file="../attention.html" %>
<h4>${admin.admin_name}さん、勝手に唐揚げにレモンかけないでよ</h4>
<%@include file="../menu/menu_logout.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action = "AdminDelete.action" method = "post">

<h4>下記のアカウント、本当に削除して大丈夫かな？</h4>

<table>
	<tbody>
		<tr>
			<td align="right">管理者ID：</td>
			<td>${check.admin_id}</td>
		</tr>
		<tr>
			<td align="right">ニックネーム：</td>
			<td>${check.admin_name}</td>
		</tr>
	</tbody>
</table>

<p>
<button onclick="AdminDelete.action">削除</button>
<button type="button" onclick=history.back()>戻る</button>
</p>
</form>
<%@include file="../footer.html" %>
