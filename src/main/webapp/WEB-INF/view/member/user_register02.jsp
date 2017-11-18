<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/template/header.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/member.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/member_register.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/button.css">
<script src="${pageContext.request.contextPath}/js/user_register.js"></script>
<script src="https://code.jquery.com/jquery-latest.js"></script>

<script>
$(document).ready(function() {
	$(".company").css("display", "none");
	$("#member_type1").on("change", function() {
		$(".company").css("display", "");
	});
	$("#member_type0").on("change", function() {
		$(".company").css("display", "none");
	});
	$('#idCheck').on('click', function() {

		var input = document.querySelector("#member_id");
		var regex = /^[0-9a-z]{6,20}$/g;
		if (!regex.test(input.value)) {
			alert("아이디는 영문소문자/숫자, 6~20자로 만들어 주세요.");
			input.style = "border:2px solid red";
			return;
		}

		$.ajax({
			type : 'POST',
			url : 'checkId',
			data : {
				"id" : $('#member_id').val(),
				"member_type" : $("input[name=member_type]:checked").val()
			},
			success : function(data) {
				if (data == 0) {
					alert("사용이 가능한 아이디 입니다.");
					$("#idCheckFlag").val("true");
					input.style = "border:2px solid blue";
				} else {
					alert("이미 등록된 아이디 입니다.");
				}
			}
		}); //end ajax    
	}); //end on   
	
	$("#member_id").on("keypress", function(){
		$("#idCheckFlag").val("false");
	});

});
</script>

<div class="center" id="edit">
	<div class="empty-row"></div>
	<form action="user_register02" method="post" id="next02">
		<input type="hidden" value="${agree}" name="agree">

		<div class="xans-member-join center area-90">
			<h1>회원가입</h1>

			<div class="boardWrite type">
				<table border="1" summary="">
					<caption>회원가입</caption>
					<tbody>
						<tr>
							<th>회원구분</th>
							<td><input id="member_type0" name="member_type" value="user"
								type="radio" checked="checked"> <label
								for="member_type0">개인회원</label> <input id="member_type1"
								name="member_type" value="company" type="radio"> <label
								for="member_type1">사업자회원</label></td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="empty-row"></div>
			<h3>정보입력</h3>
			<p class="required">
				<img src="${pageContext.request.contextPath}/img/ico_required.gif" />
				필수입력사항
			</p>
			<div class="boardWrite">
				<table>
					<caption>회원 기본정보</caption>
					<tbody>
						<tr>
							<th>아이디 <img
								src="${pageContext.request.contextPath}/img/ico_required.gif" /></th>
							<td><input id="member_id" name="id" class="inputTypeText"
								placeholder="" value="" type="text" required> <input
								type="button" id="idCheck" value="중복확인"> <input
								type="hidden" id="idCheckFlag" value="false"> (영문소문자/숫자,
								6~20자)</td>
						</tr>
						<tr>
							<th>비밀번호 <img
								src="${pageContext.request.contextPath}/img/ico_required.gif" /></th>
							<td><input id="pw1" name="pw1" maxlength="16"
								0="disabled" value="" type="password" onblur="pw1Check();"
								required> (최소 1개의 숫자 혹은 특수 문자를 포함하는 6~20 영문 대소문자) <script
									src="${pageContext.request.contextPath}/js/sha256.js"></script>
								<script>
									$(document)
											.ready(
													function() {
														$("input[name=pw2]")
																.blur(
																		function() {
																			var input = $(
																					"input[name=pw1]")
																					.val();
																			var encrypt = SHA256(input);
																			$(
																					"input[name=pw3]")
																					.val(
																							encrypt);
																		});
													});
								</script> <input type="hidden" name="pw3"></td>

						</tr>
						<tr>
							<th>비밀번호 확인 <img
								src="${pageContext.request.contextPath}/img/ico_required.gif" /></th>
							<td><input id="pw2" name="pw2" maxlength="20" value=""
								type="password" onblur="pw2Check();" required></td>
						</tr>


						<tr>
							<th id="{$name_title}">이름 <img
								src="${pageContext.request.contextPath}/img/ico_required.gif" /></th>
							<td><span id="{$name_contents}"><input type="text"
									name="name" id="name" maxlength="20" onblur="nameCheck();"
									required></span></td>
						</tr>


						<tr class="company">
							<th>상호명 <img
								src="${pageContext.request.contextPath}/img/ico_required.gif" /></th>
							<td id="companyName"><input name="company_name"
								class="inputTypeText" id="cname" type="text" maxlength="20"
								value="" required></td>
						</tr>
						<tr class="company">
							<th>사업자번호 <img
								src="${pageContext.request.contextPath}/img/ico_required.gif" /></th>
							<td id="companySsn"><input id="crn" name="crn"
								class="inputTypeText" placeholder="" maxlength="20" value=""
								type="text" required></td>
						</tr>
						<tr class="company">
							<th>일반전화 <img
								src="${pageContext.request.contextPath}/img/ico_required.gif"
								class="{$display_required_phone|display}" /></th>
							<td><input id="phone1" name="phone01" maxlength="4" value=""
								type="text" required onblur="ph01Check();">- <input id="phone2" name="phone02"
								maxlength="4" value="" type="text" required onblur="ph02Check();">- <input
								id="phone3" name="phone03" maxlength="4" value="" type="text"
								required onblur="ph03Check();"></td>
						</tr>
						<tr>
							<th>휴대전화 <img
								src="${pageContext.request.contextPath}/img/ico_required.gif"
								class="{$display_required_cell|display}" /></th>
							<td><select id="mobile1" name="mobile01">
									<option value="010">010</option>
									<option value="011">011</option>
									<option value="016">016</option>
									<option value="017">017</option>
									<option value="018">018</option>
									<option value="019">019</option>
							</select> - <input id="mobile2" name="mobile02" maxlength="4" type="text"
								required onblur="mb02Check();"> - <input id="mobile3" name="mobile03"
								maxlength="4" type="text" required onblur="mb03Check();"></td>
						</tr>
						<tr>
							<th>이메일 <img
								src="${pageContext.request.contextPath}/img/ico_required.gif"
								class="{$display_required_cell|display}" /></th>
							<td><input id="email1" name="email01" value="" type="text"
								required> @ <input id="email2" name="email02" value=""
								type="text" required onblur="emailCheck();"></td>
						</tr>
						<tr class="company">
							<th>주소 <img
								src="${pageContext.request.contextPath}/img/ico_required.gif"
								class="{$display_required_address|display}" /></th>
							<td><input type="text" id="sample6_postcode"
								placeholder="우편번호" name="loc01" required> <input
								type="button" onclick="sample6_execDaumPostcode()"
								value="우편번호 찾기" required><br> <input type="text"
								id="sample6_address" placeholder="주소" name="loc02" required>
								<input type="text" id="sample6_address2" placeholder="상세주소"
								name="loc03" required> <script
									src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
								<script>
									function sample6_execDaumPostcode() {
										new daum.Postcode(
												{
													oncomplete : function(data) {
														// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

														// 각 주소의 노출 규칙에 따라 주소를 조합한다.
														// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
														var fullAddr = ''; // 최종 주소 변수
														var extraAddr = ''; // 조합형 주소 변수

														// 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
														if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
															fullAddr = data.roadAddress;

														} else { // 사용자가 지번 주소를 선택했을 경우(J)
															fullAddr = data.jibunAddress;
														}

														// 사용자가 선택한 주소가 도로명 타입일때 조합한다.
														if (data.userSelectedType === 'R') {
															//법정동명이 있을 경우 추가한다.
															if (data.bname !== '') {
																extraAddr += data.bname;
															}
															// 건물명이 있을 경우 추가한다.
															if (data.buildingName !== '') {
																extraAddr += (extraAddr !== '' ? ', '
																		+ data.buildingName
																		: data.buildingName);
															}
															// 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
															fullAddr += (extraAddr !== '' ? ' ('
																	+ extraAddr
																	+ ')'
																	: '');
														}

														// 우편번호와 주소 정보를 해당 필드에 넣는다.
														document
																.getElementById('sample6_postcode').value = data.zonecode; //5자리 새우편번호 사용
														document
																.getElementById('sample6_address').value = fullAddr;

														// 커서를 상세주소 필드로 이동한다.
														document
																.getElementById(
																		'sample6_address2')
																.focus();
													}
												}).open();
									}
								</script>
						</tr>
						<tr class="company">
							<th>홈페이지 도메인 <img
								src="${pageContext.request.contextPath}/img/ico_required.gif"
								class="{$display_required_cell|display}" /></th>
							<td><input type="text" name="domain"></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="empty-row"></div>

		<div class="btnArea text-center">
			<input type="submit" value="가입" onclick="sendCheck();"
				class="button mybutton"> <input type="button" value="취소"
				onclick="location.href='${pageContext.request.contextPath}' "
				class="button lightGrey">
		</div>
	</form>
</div>
<div class="empty-row"></div>
<div class="empty-row"></div>

<%@ include file="/WEB-INF/view/template/footer.jsp"%>

