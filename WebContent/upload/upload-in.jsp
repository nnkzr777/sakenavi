<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>
<%@include file="../attention.html" %>
<h4>${admin.admin_name}さんとはいいお酒が飲めそうです</h4>
<%@include file="../menu/menu_logout.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>店舗登録情報入力ぺージ(1/3)</h1>

<font color = "red">${message}</font>

<p>アップロードする店舗イメージ画像を選択しアップロードしてください。</p>
<form action="Upload.action" method="post" enctype="multipart/form-data">
<input type="file" name="uploadfile"><br>
<br>
<input type="submit" value="アップロードして次へ">
<button type="button"onclick="location.href='../admin/admin-menu.jsp'">戻る</button></form>

<hr>
<h4>※アップロードの取り消し※</h4>
<p>店舗情報がまだ入力されていない画像があれば、下記にリンクが表示されます。</p>
<c:choose>
	<c:when test = "${filename!= null}">
	<img src="../images/${filename}" height="auto" width="100" border="1"> <a href = "UploadDelete.action">削除</a>
	</c:when>
	<c:otherwise>画像なし</c:otherwise>
</c:choose>


<%@include file="../footer.html" %>