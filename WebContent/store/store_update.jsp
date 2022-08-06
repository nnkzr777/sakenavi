<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>
<%@include file="../attention.html" %>
<h4>今日はもう飲みすぎだよ、${admin.admin_name}さん</h4>
<%@include file="../menu/menu_logout.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>店舗更新情報入力ぺージ(2/3)</h1>

<font color="red">${message}</font>

<h4>店舗情報の更新部分を入力してください</h4>

<form action = "../store/StoreUpdateCheck.action" method = "post">
	<p>
	<label>店舗名：</label><br>
	<input type = "text" name = "store_name" size="42" value = "${store_update.store_name}">
	</p>

	<p>
	<label>店舗説明：</label><br>
	<textarea name ="store_description" cols="40" rows="4">${store_update.store_description}</textarea>
	</p>

	<p>
	<label>営業時間：</label><br>
	<textarea name = "business_hours" cols="40" rows="4">${store_update.business_hours}</textarea>
	</p>

	<p>
	<label>住所：</label><br>
	<textarea name = "store_address" cols="40" rows = "4">${store_update.store_address}</textarea>
	</p>

	<p>
	<select name="area_id"><br>
		<option disabled selected value>地域を選ぶ</option>
		<option value="1" ${selected1}>稲毛</option>
		<option value="2" ${selected2}>四街道</option>
	</select>
	</p>

	<p>
	<input type="radio" name="genre_id" value="1" ${checked1}>居酒屋
	<input type="radio" name="genre_id" value="2" ${checked2}>バー
	<input type="radio" name="genre_id" value="3" ${checked3}>立ち飲み
	</p>

	<input type = "submit" value = "確認">
	<button type="button"onclick="location.href='../upload/upload-update.jsp'">戻る</button>
</form>

<%@ include file = "../footer.html" %>