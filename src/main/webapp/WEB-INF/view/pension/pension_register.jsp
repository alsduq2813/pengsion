<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/template/header.jsp" %>    


			<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/member.css">
			<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/member_register.css">
			<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jquery-te-1.4.0.css">
			<script src="${pageContext.request.contextPath}/js/pension_register.js"></script>
			<script src="https://code.jquery.com/jquery-latest.js"></script>
			<script src="${pageContext.request.contextPath}/js/jquery-te-1.4.0.js"></script>
			<script>
				$(document).ready(function() {
					$(".editor").jqte();
				});
			</script>

			<form action="pension_register" method="post" id="next02"  enctype="multipart/form-data">
				<div class="xans-member-join area-50 center">
					<h3>펜션 등록</h3>
					<p class="required"><img src="${pageContext.request.contextPath}/img/ico_required.gif" /> 필수입력사항</p>
					<div class="boardWrite">
						<table>
							<caption>회원 기본정보</caption>
							<tbody>
								<tr>
									<th>펜션이름 <img src="${pageContext.request.contextPath}/img/ico_required.gif" /></th>
									<td><input id="pension_name" name="pension_name" class="inputTypeText" type="text" required="required"></td>
								</tr>
								<tr>
									<th>펜션 주소 <img src="${pageContext.request.contextPath}/img/ico_required.gif" /></th>
									<td><input type="text" id="sample6_postcode" placeholder="우편번호" name="loc01">
										<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
										<input type="text" id="sample6_address" placeholder="주소" name="loc02">
										<input type="text" id="sample6_address2" placeholder="상세주소" name="loc03" required>

										<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
										<script>
											function sample6_execDaumPostcode() {
												new daum.Postcode({
													oncomplete: function(data) {
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
																extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
															}
															// 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
															fullAddr += (extraAddr !== '' ? ' (' + extraAddr + ')' : '');
														}

														// 우편번호와 주소 정보를 해당 필드에 넣는다.
														document.getElementById('sample6_postcode').value = data.zonecode; //5자리 새우편번호 사용
														document.getElementById('sample6_address').value = fullAddr;

														// 커서를 상세주소 필드로 이동한다.
														document.getElementById('sample6_address2').focus();
													}
												}).open();
											}
										</script>
									</td>
								</tr>
								<tr>
									<th>펜션 연락처 <img src="${pageContext.request.contextPath}/img/ico_required.gif" /></th>
									<td>
										<input id="mobile1" name="mobile1" maxlength="4" value="" type="text"> -
										<input id="mobile2" name="mobile2" maxlength="4" value="" type="text"> -
										<input id="mobile3" name="mobile3" maxlength="4" value="" type="text">
									</td>
								</tr>
								<tr>
									<th id="{$name_title}">픽업여부 <img src="img/ico_required.gif" /></th>
									<td>
										<select id="pickup" name="pickup">
                                            <option value="가능">가능</option>
                                            <option value="불가">불가능</option>
                                        </select>
									</td>
								</tr>
								<tr>
									<th>이용/시설 안내 <img src="${pageContext.request.contextPath}/img/ico_required.gif" /></th>
									<td>
										<textarea class="editor" name="guide"></textarea>
									</td>
								</tr>
								<tr>
									<th>주의사항/취소안내 <img src="${pageContext.request.contextPath}/img/ico_required.gif" /></th>
									<td>
										<textarea class="editor" name="caution"></textarea>
									</td>
								</tr>
								<tr>
									<th>은행명 <img src="${pageContext.request.contextPath}/img/ico_required.gif" /></th>
									<td>
										<input type="text" name="bank" id="name" maxlength="20">
									</td>
								</tr>
								<tr>
									<th>계좌번호 <img src="${pageContext.request.contextPath}/img/ico_required.gif" /></th>
									<td>
										<input type="text" name="account" id="name" maxlength="20">
									</td>
								</tr>
								<tr>
									<th>예금주 <img src="${pageContext.request.contextPath}/img/ico_required.gif" /></th>
									<td>
										<input type="text" name="depositor" id="name" maxlength="20">
									</td>
								</tr>
								<tr>
									<th>성수기 시작 <img src="${pageContext.request.contextPath}/img/ico_required.gif" /></th>
									<td>
										<input type="date" name="peak_start" id="name">
									</td>
								</tr>
								<tr>
									<th>성수기 마침 <img src="${pageContext.request.contextPath}/img/ico_required.gif" /></th>
									<td>
										<input type="date" name="peak_end" id="name">
									</td>
								</tr>
								<tr>
									<th>펜션사진1<img src="${pageContext.request.contextPath}/img/ico_required.gif" /></th>
									<td>
										<input type="file" id="file" name="photo1" class="user-input fill" required>
									</td>
								</tr>
								<tr>
									<th>펜션사진2</th>
									<td>
										<input type="file" id="file" name="photo2" class="user-input fill">
									</td>
								</tr>
								<tr>
									<th>펜션사진3</th>
									<td>
										<input type="file" id="file" name="photo3" class="user-input fill">
									</td>
								</tr>
								<tr>
									<th>펜션사진4</th>
									<td>
										<input type="file" id="file" name="photo4" class="user-input fill">
									</td>
								</tr>
								<tr>
									<th>펜션사진5</th>
									<td>
										<input type="file" id="file" name="photo5" class="user-input fill">
									</td>
								</tr>

							</tbody>
						</table>
					</div>
				</div>
				<div class="empty-row"></div>
				<div class="btnArea text-center">
					<a id="register_btn" type="submit" onclick="sendCheck();"><img src="http://img.echosting.cafe24.com/skin/base_ko_KR/member/btn_member_join1.gif"/></a>
					<a href="${pageContext.request.contextPath}"><img src="http://img.echosting.cafe24.com/skin/base_ko_KR/member/btn_member_join_cancel.gif" alt="회원가입취소" /></a>
				</div>
			</form>
			
<%@ include file="/WEB-INF/view/template/footer.jsp" %>    
			