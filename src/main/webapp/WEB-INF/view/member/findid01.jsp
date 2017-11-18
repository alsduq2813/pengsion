<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<%@ include file="/WEB-INF/view/template/header.jsp" %>   

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/member_findid.css">
			<div class="roll center">
				<div class="titleArea">
					<h2>아이디 찾기</h2>
				</div>

				<form id="findIdForm" name="findIdForm" action="findpw" method="post" enctype="multipart/form-data">
					<input id="returnUrl" name="returnUrl" value="/member/id/find_id_result.html" type="hidden">
					<div class="xans-member xans-member-findid">
						<div class="findId">
							<h3><img src="http://img.echosting.cafe24.com/skin/base_ko_KR/member/h3_find_id.gif" alt="아이디 찾기"></h3>
						</div>
						<div class="text-center">
							<p>아이디 : ${findedId}</p>
						</div>
						<div class="empty-row"></div>
						<div class="text-center"><a href="login"><img src="img/btn_login01.png"/></a></div>
					</div>
				</form>
			</div>
<%@ include file="/WEB-INF/view/template/footer.jsp" %>   
        