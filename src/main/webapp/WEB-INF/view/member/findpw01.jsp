<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<%@ include file="/WEB-INF/view/template/header.jsp" %>   
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/member_findid.css">
	<div class="roll center">
		<div class="titleArea">
			<h2>비밀번호 찾기</h2>
		</div>
		<form id="findIdForm" name="findPwForm" action="/exec/front/Member/findId/" method="post">
			<input id="returnUrl" name="returnUrl" value="/member/id/find_id_result.html" type="hidden">
			<div class="xans-member xans-member-findid">
				<div class="findId">
					<h3><img src="http://img.echosting.cafe24.com/skin/base_ko_KR/member/h3_find_pw.gif" alt="비밀번호 찾기"></h3>
				</div>
				<div class="text-center">
					<p>임시 비밀번호가 이메일(alsduq2813@naver.com)로 발송되었습니다.</p>
				</div>
			</div>
		</form>
	</div>
<%@ include file="/WEB-INF/view/template/footer.jsp" %>   
        