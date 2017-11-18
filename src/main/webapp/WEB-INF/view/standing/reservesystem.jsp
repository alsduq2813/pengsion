<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<%@ include file="/WEB-INF/view/template/header.jsp"%>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/standing.css">

<div class="empty-row"></div>
<div class="empty-row"></div>

<div class="submenu">
	<div class="menu">

		<ul>
			<li><a
				href="${pageContext.request.contextPath}/standing/standing2">입점
					안내</a></li>
			<li><a
				href="${pageContext.request.contextPath}/standing/reservesystem">예약시스템안내</a></li>
			<li><a
				href="${pageContext.request.contextPath}/standing/questionboardlist">Q
					& A</a></li>
		</ul>
	</div>

	<div class="submenucontext">
		<table border="1" width="80%" height="70%" align="center">

			<tr>
				<th><font size="4.5em" color="red"><u>실시간예약시스템의 장점</u></font><br>
				<br> - 숙박업소 ( 펜션, 리조트, 캠핑장 등) 를 운영하시는 분이라면 누구나 사용이 가능합니다.<br>
					- 늦은 밤시간이나 전화를 받을수 없는 시간에도 실시간 예약으로 예약을 받을수 있습니다.<br> - 업소
					홈페이지에 자유자재로 설치가 가능합니다.<br> - 카드결제, 실시간 계좌이체 서비스가 가능하므로 불필요한 입금
					확인 절차를 거치지 않아도 됩니다.</th>
			</tr>
			<tr>
				<th><font size="4.5em" color="red"><u>이런점이 다릅니다.</u></font><br>
				<br> - 어떤 검색엔진, 어떤키워드로 예약이 이루어졌는지. 예약건건이 기록되어 광고비를 더욱 효율적으로 관리
					할수 있습니다.<br> - 쉬운 판매가,할인가,성수기,공휴일 관리<br> - 예약시스템내 할인 및
					이벤트에대한 다양한 팝업창 지원<br> - 이용일 근접하여 예약이 완료되지 않은 잔여객실에 할인율 자동 삽입
					기능,<br> - 2박이상 예약만 받기 기능<br> - 2박이상인 숙박에 한하여 연박할인기능<br>
					- 배치도 연동기능 (캠핑장인경우 최적)<br> - 현금영수증 연동, 자동 발행 기능<br> -
					필요에따라 객실상태를 예약가능,예약진행중,예약완료의 상태로 변경이 가능합니다.<br> - 인터넷이 안되는
					상황에서 휴대폰으로도 입금확인이 가능합니다.<br> - 방막기가 어려우셨다구요? 한번 클릭만으로 방막기가
					가능합니다.<br> - 장시간 입금대기중인 예약건에 대해 원하시는 설정시간이 지나면 시스템이 예약을 자동으로
					취소해주며 예약자에게 문자도 발송됩니다.<br> - SMS 예약알림 지원
					(입금대기중,자동예약취소,환불신청,예약(입금)완료시 예약자와 펜션관리인 휴대폰으로 문자전송됩니다.)<br> -
					객실요금외 기타이용요금인 바베큐이용요금,와인,케익,이벤트 비용을 직접 설정하여 예약시 함께 신청(결제)받을수 있습니다.<br>
					- 카드결제/실시간계좌이체/무통장결제 3가지의 결제 방식을 지원합니다. (원하는 결제방식만 선택 가능)<br>
					- 카드결제의 경우 할부 결제가 가능하여 예약비 부담이 덜수 있어. 예약율이 상승합니다.<br> - 복잡한
					카드사와의 계약없이 신청만으로 10분만에 카드결제, 실시간계좌이체 기능이 가능합니다.</th>
			</tr>
			<tr>
				<th><font size="4.5em" color="red"><u>실시간 예약시스템 연동
							지원 (API)</u></font><br>
				<br> - 펭션의 예약시스템은 외부 프로그램과 연동할수 있는 기능을 제공합니다.<br> - 사용중인
					홈페이지에서 객실안내 및 요금/예약현황을 쉽게 연동할 수 있습니다.<br> - 많은 홈페이지 제작사들이
					떠나요닷컴의 예약시스템을 사용하여 펜션 홈페이지를 만들고 있습니다.<br> - 객실정보 및 요금정보를
					예약시스템에서 수정하면 펜션 홈페이지도 반영되도록 연동이 가능합니다.</th>
			</tr>
		</table>

		<div class="empty-row"></div>
		<div class="empty-row"></div>


		<table class="maintable" border="0" align="center" width="100%"
			height="20%" bordercolor="white" bgcolor="white" cellpadding="5"
			cellspacing="30">
			<!-- cellpadding : 테두리와 텍스트 사이의 여백
    cellspacing :  셀과 셀 사이의 간격-->


			<tr height=50px>
				<td class="midth" rowspan="2"><img
					src="${pageContext.request.contextPath}/img/center2.jpg"
					" width=350 height=100></td>
				<td class="midth" rowspan="2" border="1">평일/AM 09:00 ~ PM 05:00<br>
					점심 / PM12:30 ~ PM 01:30<br> 상담업무시간외엔 질분답변<br> 이나 이용하시기
					바랍니다.
				</td>
				<td class="bottombtn" rowspan="2"><input type="button"
					value="문의하기" align="center" style="width: 200; height: 50;"
					onclick="location.href='${pageContext.request.contextPath}/standing/questionboard' ">
				<td class="bottombtn" rowspan="2"><input type="button"
					value="입점 신청 바로가기" align="center" style="width: 200; height: 50;"
					onclick="location.href='${pageContext.request.contextPath}/pension/pension_register' ">
			</tr>
		</table>


	</div>

</div>
</main>

<%@ include file="/WEB-INF/view/template/footer.jsp"%>