<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>
<%@include file="../attention.html" %>
<h4>${admin.admin_name}、飲みすぎて吐きそう...</h4>
<%@include file="../menu/menu_logout.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>店舗登録情報入力ぺージ(3/3)</h1>

<h4><font color = "red">※登録はまだ完了していません</font>
<br>下記の内容で登録してよろしいですか？</h4>

<form action = "StoreInsert.action" method = "post">
<table>
	<tbody>
		<tr>
			<td align="right">店舗名：</td>
			<td>${check.store_name}</td>
		</tr>
		<tr>
			<td align="right">店舗説明：</td>
			<td>${check.store_description}</td>
		</tr>
		<tr>
			<td align="right">営業時間：</td>
			<td>${check.business_hours}</td>
		</tr>
		<tr>
			<td align="right">住所：</td>
			<td>${check.store_address}</td>
		</tr>
		<tr>
			<td align="right">地域：</td>
			<td>
			<c:choose>
			<c:when test = "${check.area_id==1}">稲毛</c:when>
			<c:when test = "${check.area_id==2}">四街道</c:when>
			</c:choose>
			</td>
		</tr>
		<tr>
			<td align="right">ジャンル：</td>
			<td>
			<c:choose>
			<c:when test = "${check.genre_id==1}">居酒屋</c:when>
			<c:when test = "${check.genre_id==2}">バー</c:when>
			<c:when test = "${check.genre_id==3}">立ち飲み</c:when>
			</c:choose>
			</td>
		</tr>
		<tr>
			<td align="right">店舗画像：</td>
			<td rowspan="4"><img src="../images/${check.filename}" height="auto" width="300"></td>
		</tr>
	</tbody>
</table>

<p>
<input type="submit" value = "確定">
<button type="button" onclick=history.back()>戻る</button>

</p>
</form>
<%@include file="../footer.html" %>
