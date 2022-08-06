<%@page contentType="text/html; charset=UTF-8" %>
<%@ include file="../header.html" %>
<%@include file="../attention.html" %>
<h4>${admin.admin_name}さん、もう帰るんですか？</h4>
<%@include file="../menu/menu_logout.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h4>ログアウトしますか？</h4>
<p><a href="AdminLogout.action">ログアウト</a></p>

<%@include file="../footer.html" %>
