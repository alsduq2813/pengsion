<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<%@ include file="/WEB-INF/view/template/header.jsp" %>   
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/member_findid.css">
			<div class="roll center">
				<div class="titleArea">
					<h2>아이디 찾기</h2>
					<ul>
						<li>가입하신 방법에 따라 아이디 찾기가 가능합니다.</li>
						<li>법인사업자 회원 또는 외국인 회원의 경우 법인명과 법인번호 또는 이름과 등록번호를 입력해 주세요.</li>
					</ul>
				</div>

				<form id="findIdForm" name="findIdForm" action="findid" method="post">
					<input id="returnUrl" name="returnUrl" value="/member/id/find_id_result.html" type="hidden">
					<div class="xans-member xans-member-findid">
						<div class="findId">
							<h3><img src="http://img.echosting.cafe24.com/skin/base_ko_KR/member/h3_find_id.gif" alt="아이디 찾기"></h3>
							<fieldset>
								<legend>아이디 찾기</legend>
								<p class="member"><strong>회원유형</strong> 
									<select id="searchType" name="type" >
										<option value="user" selected="selected">개인회원</option>
										<option value="company">사업자회원</option>
									</select>
								</p>
								<p id="name_view" class="name" style=""><strong id="name_lable">이름</strong> <input id="name" name="name" class="lostInput" placeholder="" value="" type="text"></p>
								<p id="email_view" class="email" style=""><strong>이메일</strong> <input id="email" name="email" class="lostInput" placeholder="" value="" type="text"></p>
								<p class="button">
									<button id="btn_form" type="submit"><img src="http://img.echosting.cafe24.com/skin/base_ko_KR/member/btn_submit.gif" alt="확인"></button>
								</p>
							</fieldset>
						</div>
					</div>
				</form>
			</div>
<%@ include file="/WEB-INF/view/template/footer.jsp" %>   
        