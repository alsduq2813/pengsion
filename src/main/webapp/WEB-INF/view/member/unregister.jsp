<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/template/header.jsp" %>    
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/button.css">
<script src="https://code.jquery.com/jquery-latest.js"></script>

			<form action="${pageContext.request.contextPath}/member/unregister" method="post">
				<div class="area-20 center">
					<div class="empty-row" id="test"></div>
					<div class="empty-row" id="test1"></div>
					<div class="row text-center">
						<h1>회원 탈퇴</h1>
					</div>
					<div class="row text-center">
						비밀번호 : <input type="password" name="" id="member_passwd">
					</div>
					<script src="${pageContext.request.contextPath}/js/sha256.js"></script>
					<script>
					$(document).ready(function(){
						$("#member_passwd").keyup(function(){
							var input = $("#member_passwd").val();
							var encrypt = SHA256(input);
							$("input[name=pw]").val(encrypt);
						});
					});
					</script>
				    <input type="hidden" name="pw" value="">
					<div class="text-center">
						<input type="submit" value="확인" class="button mybutton">
						<input type="button" value="취소" class="button lightGrey" onclick="location.href='javascript:history.back()'">
					</div>
				</div>
			</form>
            
<%@ include file="/WEB-INF/view/template/footer.jsp" %>    
            