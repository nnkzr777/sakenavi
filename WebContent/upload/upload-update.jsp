<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>
<%@include file="../attention.html" %>
<h4>${admin.admin_name}、もう一軒いこう！！</h4>
<%@include file="../menu/menu_logout.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>店舗更新情報入力ぺージ(1/3)</h1>
<font color = "red">${message}</font>

<h4>店舗画像を差し替える場合は、ファイルを再アップロードしてください。</h4>

<p>現在の店舗画像<br>
	<img src="../images/${store_update.filename}" height="auto" width="300">
</p>

<form action="../upload/UploadUpdate.action" method="post" enctype="multipart/form-data">
	<input type="file" name="uploadfile"><br>
	<input type="submit" value="再アップロードして次へ">
</form>

<p>
<button type="button"onclick="location.href='../store/store_update.jsp'">差し替えずに次へ</button></form>

<button type="button"onclick="location.href='../store/store_update_delete_list.jsp'">戻る</button>
</p>

<%@include file="../footer.html" %>