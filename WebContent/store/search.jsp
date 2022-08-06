<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file = "../header2.html"%>
<header>
	<a href = "../store/search.jsp">トップページ</a>
	<c:choose>
	<c:when test = "${admin != null && admin != ''}">
	<a href = "../admin/admin-menu.jsp">管理者メニュー</a>
	<a href = "../admin/logout-in.jsp">ログアウト</a>
	</c:when>
	<c:when test = "${admin == null}">
	<a href = "../admin/login-in.jsp">ログイン</a>
	</c:when>
	</c:choose>

</header>

   <div class="context">
   <div class="greeting">
   <c:choose>
	<c:when test = "${admin != null && admin != ''}">
		<h2>いらっしゃい、${admin.admin_name}さん！いつもの？</h2>
	</c:when>
	<c:otherwise>
<%-- 		<%@include file="../menu/menu2.jsp" %>
 --%>	</c:otherwise>
</c:choose>

<font color="red">${message}</font>
</div>


   <div class="divtop">
        <p class="top">さけなび</p>
        </div>
        <br><br><br><br><br><br>
        <p><font size="4">検索キーワードを入力してください</font></p>
        <br>
<form action = "StoreSearch.action" method = "post">
 <div class="cp_iptxt">
	<label class="ef">
	<input type="text" name="keyword" placeholder="お店の名前など">
	</label>
</div>
<br>
<br>

<p><font size="4">地域をお選びください</font></p>
<div class="cp_ipselect cp_sl03">
<select name="area_id">
<!-- 	<option value="" hidden>どこで飲む？</option>
 -->
 	<option disabled selected value>どこで飲む？</option>
    <option value="1">稲毛</option>
	<option value="2">四街道</option>
</select>
</div>
<br>

<p>
<font size="4">以下からジャンルをお選びください</font>
</p>
<div class="cp_ipradio">
	<input type="radio" name="genre_id" value="1" id="a_rb1" />
	<label for="a_rb1"><font size ="5">居酒屋</font></label>
	<input type="radio" name="genre_id" value="2" id="a_rb2" />
	<label for="a_rb2"><font size ="5">バー</font></label>
	<input type="radio" name="genre_id" value="3" id="a_rb3" />
	<label for="a_rb3"><font size ="5">立ち飲み</font></label>
</div>
<br>
<br>
 <p align="center" style="margin: 0px auto;">
<input type="image"  class="ball" name="submit" width="150" height="150" src="../images/beer.png" alt=" 検索">
</p>
</form>


    </div>


<div class="area" >

            <ul class="circles">
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li><input type="image" width="100" height="100" src="../images/chi-bakun4.png"></li>
                    <li></li>
                    <li></li>
                    <li><input type="image" width="100" height="100" src="../images/chi-bakun2.png"></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li><input type="image" width="100" height="100" src="../images/chi-bakun3.png"></li>
                    <li><input type="image" width="100" height="100" src="../images/chi-bakun5.png"></li>
                    <li><input type="image" width="100" height="100" src="../images/chi-bakun5.png"></li>
                    <li></li>


            </ul>
    </div >
<%@include file = "../footer.html"%>