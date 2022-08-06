<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>
<%@include file="../attention.html" %>
<h4>${admin.admin_name}、このあと飲み行く？</h4>
<%@include file="../menu/menu_logout.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action = "StoreDelete.action" method = "post">

<h4>下記の店舗登録情報を削除してよろしいですか？</h4>

<table>
	<tbody>
		<tr>
			<td align="right">店舗ID：</td>
			<td>${check.store_id}</td>
		</tr>
		<tr>
			<td align="right">店舗名：</td>
			<td>${check.store_name}</td>
		</tr>
		<tr>
			<td align="right">店舗画像：</td>
			<td rowspan="4"><img src="../images/${check.filename}" height="auto" width="100"></td>
		</tr>
	</tbody>
</table>

<p>
<input type = "submit" value = "削除">
<button type = "button" onclick=history.back()>戻る</button>
</p>
</form>
<%@include file="../footer.html" %>
