<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<%@ include file="/WEB-INF/view/template/header.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/button.css">

<div class="empty-row"></div>
<div class="empty-row"></div>

<table class="maintable" border="5" align="center" width="60%"
	height="80%" bordercolor="#D9E5FF" bgcolor="white" cellpadding="5"
	cellspacing="30" border-radius="8">
	<!-- cellpadding : 테두리와 텍스트 사이의 여백
    cellspacing :  셀과 셀 사이의 간격-->
	<tr height=50px>
		<th class="topth"><h2>
				<font color="red">@요즘 제일 잘나가@</font>
			</h2></th>
	</tr>
	<tr valign="top" bgcolor="silver">
		<c:forEach var="pension" begin="0" step="1" end="2"
			items="${list_latest}">
			<td width="20%" class="img"
				background="${pageContext.request.contextPath}/pension/[${pension.pension_no}]${pension.pension_name}/${pension.photo1}"
				onclick="location.href='${pageContext.request.contextPath}/pension/reserve?pension_no=${pension.pension_no}'"></td>
		</c:forEach>
	</tr>
	<tr height=50px>
		<c:forEach var="pension" begin="0" step="1" end="2"
			items="${list_latest}">
			<th class="midth">${pension.pension_name}</th>
		</c:forEach>
	</tr>

	<tr valign="top" bgcolor="silver">
		<c:forEach var="pension" begin="3" step="1" end="5"
			items="${list_latest}">
			<td width="20%" class="img"
				background="${pageContext.request.contextPath}/pension/[${pension.pension_no}]${pension.pension_name}/${pension.photo1}"
				onclick="location.href='${pageContext.request.contextPath}/pension/reserve?pension_no=${pension.pension_no}'"></td>
		</c:forEach>
	</tr>
	<tr height=50px>
		<c:forEach var="pension" begin="3" step="1" end="5"
			items="${list_latest}">
			<th class="midth">${pension.pension_name}</th>
		</c:forEach>
	</tr>
</table>

<br>
<br>



<br>
<br>

<!--            고객센터-->

<table border="0" align="center" width="60%" height="5"
	bordercolor="black" bgcolor="white" class="table" cellpadding="5"
	cellspacing="30">
	<!-- cellpadding : 테두리와 텍스트 사이의 여백
    cellspacing :  셀과 셀 사이의 간격-->


	<tr height=50px>
		<td class="midth" rowspan="2"><img
			src="${pageContext.request.contextPath}/img/center2.jpg"  width=350
			height=100></td>
		<td class="midth" rowspan="2" border="1">평일/AM 09:00 ~ PM 05:00<br>
			점심 / PM12:30 ~ PM 01:30<br> 상담업무시간외엔 질분답변<br> 이나 이용하시기
			바랍니다.
		</td>
		<td class="bottombtn" rowspan="2">
			<button type="button" onclick="location.href='${pageContext.request.contextPath}/standing/questionboard'"
				class="button mybutton">질문답변 바로가기</button>
		<td class="bottombtn" rowspan="2">
			<button type="button" onclick="location.href='${pageContext.request.contextPath}/pension/pension_register'"
				class="button mybutton">펜션 등록하기</button>
	</tr>
	
</table>
</main>

<%@ include file="/WEB-INF/view/template/footer.jsp"%>