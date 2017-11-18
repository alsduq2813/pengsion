<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/template/header.jsp" %>    
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/button.css">

<div class="text-center">
	<h1>객실 등록 완료</h1>
	<a href="${pageContext.request.contextPath}/room/room_info?room_no=${room_no}"><button class="button mybutton">확인</button></a>
</div>
			
<%@ include file="/WEB-INF/view/template/footer.jsp" %>    
			