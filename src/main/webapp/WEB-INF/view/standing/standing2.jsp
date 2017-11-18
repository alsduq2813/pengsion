<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/template/header.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/standing.css">

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
				href="${pageContext.request.contextPath}/standing/reservesystem">예약시스템
					안내</a></li>
			<li><a
				href="${pageContext.request.contextPath}/standing/questionboardlist">Q
					& A</a></li>
		</ul>
	</div>

	<div class="submenucontext">
		<table border="1" width="80%" height="70%" align="center">

			<tr>
				<th><font size="5em" color="red"><u>입점안내</u></font><br>
				<br> 펭션은 약 1700 여개의 펜션의 예약관리를 하고 있습니다.(2016년 6월기준)<br> 입점시
					고정 광고비가 지출되지 않고 예약 성사된 건에 대해서만 대행수수료 발생</th>
			</tr>
			<tr>
				<th><font size="5em" color="red"><u>입점조건</u></font><br>
				<br> 당사에서 정하는 일정수준 이상의 시설을 갖춘 업소만 등록 가능합니다.</th>
			</tr>
			<tr>
				<th><font size="5em" color="red"><u>등록비</u></font><br>
				<br> 유료 등록 30만원 (빠른 등록)<br> 무료 등록 (대기순서에 의해 등록시간이 많이 소요 될수
					있습니다.)</th>
			</tr>

			<tr>
				<th><font size="5em" color="red"><u>입점시 예약시스템 지원</u></font><br>
				<br> 펭션 객실관리는 쉽고 편리합니다. 초보자도 쉽게 직관적으로 사용이 가능합니다.</th>
			</tr>

		</table>
		<div class="empty-row"></div>
		<div class="empty-row"></div>
		<div class="requestbtn"></div>

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