<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/template/header.jsp" %> 

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/member_myinfo.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/button.css">
<script src="https://code.jquery.com/jquery-latest.js"></script>
<script>
$(document).ready(function() {
	$("#question").on("click", function() {
		$(".answer").toggle();
	});
});
</script>
<div class="area-60 center">
	<div class="empty-row"></div>
	<div class="text-right">	
		<a href="mileage"><button class="button mybutton">적립내역</button></a>
		<a href="edit"><button class="button mybutton">회원 정보 수정</button></a>
		<a href="unregister"><button class="button mybutton">회원탈퇴</button></a>
	</div>
	<div class="table-users">
		<div class="header">
			<p class="left">${member.name} 님의 회원정보 </p>
			<p class="right">회원가입일 : ${member.date}</p>
		</div>
		<table id="profile">
			<tr>
				<th>적립금</th>
				<th>아이디</th>
				<td>${member.id}</td>
			</tr>
			<tr>
				<td rowspan="3" id="mileage">${member.mileage} 원</td>
				<th>이름</th>
				<td>${member.name}</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>${member.email}</td>
			</tr>
			<tr>
				<th>핸드폰 번호</th>
				<td>${member.mobile}</td>
			</tr>
		</table>
	</div>
	<div class="empty-row"></div>
	<div class="row">
		<h3>나의 예약내역</h3>
		<p>비회원 예약을 하신 경우에는 예약확인/취소을 이용하세요.<br>예약번호를 클릭하시면 보다 상세한 예약정보를 확인 할 수 있습니다.<br>비회원 예약건은 조회가 안될수 있습니다. 고객센터로 연락주시면 조회 가능하도록 처리 해드립니다.</p>
		<table id="reservation_info">
			<tr>
				<th>결재번호</th>
				<th>예약일</th>
				<th>펜션명</th>
				<th>예약자명</th>
				<th>예약상태</th>
				<th>후기작성</th>
			</tr>
			<c:forEach var="myPaymentList" items="${myPaymentList}">
				<tr>
					<td><a id="rv_info" onClick="window.open('${pageContext.request.contextPath}/reservation/reservation_info?payment_no=${myPaymentList.payment_no}','예약정보','fullscreen','fullscreen')">${myPaymentList.payment_no}</a></td>
					<td>${myPaymentList.reserve_reg}</td>
					<td><a href="${pageContext.request.contextPath}/reservation/reserve?pension_no=${myPaymentList.pension_no}">${myPaymentList.pension_name}</a></td>
					<td>${myPaymentList.guest_name}</td>
					<c:choose>
						<c:when test="${myPaymentList.payment_condition eq 'waiting'}">
							<td>입금대기</td>
						</c:when>
						<c:otherwise>
							<td>완료</td>
						</c:otherwise>
					</c:choose>
					<td><a href="#">후기작성</a></td>
				</tr>
			</c:forEach>
		</table>

		<h3>찜 목록</h3>
		<table id="interest">
			<tr>
				<td rowspan="2" width="10%"><img src="${pageContext.request.contextPath}/img/180556.jpg" ></td>
				<th>펜션명</th>
				<th>등록일</th>
			</tr>
			<tr>
				<td>밤도펜션</td>
				<td>2015.12.02</td>
			</tr>
		</table>
		<h3>나의 문의</h3>
		<table id="qna">
			<tr>
				<th>상태</th>
				<th width="50%">제목</th>
				<th>펜션명</th>
				<th>등록일</th>
			</tr>
			<tr>
				<td>답변완료</td>
				<td id="question">안녕핫에ㅛ</td>
				<td><a href="#">콩나물펜션</a></td>
				<td>2017.10.11</td>
			</tr>
			<tr>
				<td colspan="4" class="answer">
					<div class="row">
						<p class="reply">Q).사랑더 희망더 두개 예약하고 싶은데요 바베큐는 어디서 먹게되는건가요??</p>
					</div>
					<div class="row">
						<p class="reply">A). 안녕하세요 고객님.^^ 사랑더, 희망더 객실은 공동바베큐장을 이용하셔야 합니다. 기쁨더(1층) 객실을 제외한 전 객실 모두 공동 실내바베큐장을 이용하셔야 하니 참고하시기 바랍니다. 감사합니다!
						</p>
					</div>
				</td>
			</tr>
		</table>
	</div>
	<div class="empty-row"></div>
	<div class="empty-row"></div>
	<div class="empty-row"></div>
</div>
<%@ include file="/WEB-INF/view/template/footer.jsp" %>    

