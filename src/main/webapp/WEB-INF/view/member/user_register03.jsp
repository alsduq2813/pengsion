<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/template/header.jsp" %>   
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/member.css"> 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/button.css"> 
<div class="area-90 center">
	<div class="text-center">
		<div class="empty-row"></div>
		<div class="empty-row"></div>
		<div class="empty-row"></div>
	    <h1>회원가입 성공</h1>
	    <button onclick="location.href='login'" class="button mybutton">로그인 하러가기</button>
	</div>
</div>
<%@ include file="/WEB-INF/view/template/footer.jsp" %>    

