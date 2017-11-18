<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/template/header.jsp" %> 
<script src="https://code.jquery.com/jquery-latest.js"></script>
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
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/member.css">   
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/member_login.css">   
<form action="#" method="post">
	<div class="xans-member-login">
		<div class="login">
			<div class="area-100 center" id="login_type">
				<input id="member_type0" name="member_type" value="user" type="radio" checked="checked">
				<label for="member_type0">개인회원</label>
				<input id="member_type1" name="member_type" value="company" type="radio">
				<label for="member_type1">사업자회원</label>
			</div>
			<div class="empty-row"></div>
	                    <h3><img src="http://img.echosting.cafe24.com/skin/base_ko_KR/member/h3_login.gif" alt="회원로그인" /></h3>
	                    <fieldset>
	                        <legend>회원로그인</legend>
	                        
	                       	<c:choose>
	                       		<c:when test="${empty cookie.save.value}">
	                         	<label class="id"><span>아이디</span><input id="member_id" name="id" class="inputTypeText" placeholder="" value="" type="text"></label>
	                          <label class="password"><span>비번</span><input id="member_passwd" name="" value="" type="password"></label>
	                          <input type="hidden" name="pw">
	                          <button id="login_btn" type="submit"><img class="btn-img" src="http://img.echosting.cafe24.com/skin/base_ko_KR/member/btn_login.gif"></button>
						<ul>
							<li>
								<input id="save" type="checkbox" name="save" value="remember">
								<label for="save">아이디 저장</label>
							</li>
							<li>
								<a href="findid">아이디찾기</a>
							</li>
							<li>
								<a href="findpw">비밀번호찾기</a>
							</li>
						</ul>	
	                        	</c:when>
	                        	<c:otherwise>
	                         	<label class="id"><span>아이디</span><input id="member_id" name="id" class="inputTypeText" placeholder="" value="${cookie.save.value}" type="text"></label>
	                          <label class="password"><span>비번</span><input id="member_passwd" name="pw" value="" type="password"></label>
	                          <button id="login_btn" type=""><img class="btn-img" src="http://img.echosting.cafe24.com/skin/base_ko_KR/member/btn_login.gif"></button>
						<ul>
							<li>
								<input id="save" type="checkbox" name="save" value="remember" checked="checked">
								<label for="save">아이디 저장</label>
							</li>
							<li>
								<a href="findid">아이디찾기</a>
							</li>
							<li>
								<a href="findpw">비밀번호찾기</a>
							</li>
						</ul>	
	                        	</c:otherwise>
	                       	</c:choose>
	                       	
	                        <p class="link">
	                            회원가입을 하시면 다양하고<br>특별한 혜택이 준비되어 있습니다.
	                            <a href="${pageContext.request.contextPath}/member/user_register01"><img src="http://img.echosting.cafe24.com/skin/base_ko_KR/member/btn_join.gif" alt="회원가입"></a>
	                        </p>
	                    </fieldset>
	                </div>
	            </div>
	        </form>
<%@ include file="/WEB-INF/view/template/footer.jsp" %>    

