<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>
<%@include file="../attention.html" %>
<h4>こちらオリジナルカクテル、『${admin.admin_name}スペシャル』になります</h4>
<%@include file="../menu/menu_logout.jsp" %>

<h1>管理者メニュー</h1>
<p><a href = "../upload/upload-in.jsp">店舗登録</a></p>
<p><a href = "../store/StoreUpdateDeleteList.action">店舗更新･削除</a></p>
<p><a href = "admin_insert.jsp">管理者登録</a></p>
<p><a href = "AdminList.action">管理者更新･削除</a></p>

<%@include file="../footer.html" %>