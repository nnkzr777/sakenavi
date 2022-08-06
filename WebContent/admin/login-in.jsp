<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>
<%@include file="../menu/menu.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<font color="red">${message}</font>

<h4>ログインIDとパスワードを入力してください</h4>
<form action="AdminLogin.action" method="post">
<p>ログイン名<input type="text" name="login_id"></p>
<p>パスワード<input type="password" name="password"></p>
<p><input type="submit" value="ログイン"></p>
<br>
</form>

<%@include file="../footer.html" %>
