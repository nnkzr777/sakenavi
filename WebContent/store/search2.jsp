<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file = "../header.html"%>

<c:choose>
	<c:when test = "${admin != null && admin != ''}">
		<h4>いらっしゃい、${admin.admin_name}さん！いつもの？</h4>
		<%@include file="../menu/menu_logout.jsp" %>
	</c:when>
	<c:otherwise>
		<%@include file="../menu/menu.jsp" %>
	</c:otherwise>
</c:choose>

<font color="red">${message}</font>

<h1>さけなび</h1>
<p>検索キーワードを入力してね！</p>

<form action = "StoreSearch.action" method = "post">
<input type = "text" name = "keyword">
<p>
	<select name="area_id">
		<option disabled selected value>どこで飲む？</option>
		<option value="1">稲毛</option>
		<option value="2">四街道</option>
	</select>
</p>
<p>
	<input type="radio" name="genre_id" value="1">居酒屋<br>
	<input type="radio" name="genre_id" value="2">バー<br>
	<input type="radio" name="genre_id" value="3">立ち飲み<br>
</p>

<input type = "submit" value = "検索">
<input type = "reset" value = "リセット">
</form>

<%@include file = "../footer.html"%>