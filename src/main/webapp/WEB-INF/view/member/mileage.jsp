<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/template/header.jsp" %>  

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/member_myinfo.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/button.css">
			<div class="area-60 center">
				<div class="empty-row"></div>
				<div class="text-right">	
					<a href="myinfo"><button class="button mybutton">뒤로</button></a>
				</div>
				<div class="row">
					<h3>적립금 상세 내역</h3>
				</div>
				<div class="row">
					<ul>
						<li>적립금은 사이트내에서 현금처럼 사용이 가능합니다.</li>
						<li>적립금은 3년간 유효합니다.</li>
						<li>적립금은 숙박이용일이 지나면 자동 적립됩니다.</li>
						<li>베스트 이용후기 등의 각종이벤트의 추첨에 의해 적립금을 드리고 있습니다.</li>
					</ul>
				</div>
				<div>
					<table id="mileage_info">
						<tr>
							<th>날짜</th>
							<th>적립액</th>
							<th>예약번호</th>
							<th>내역</th>
						</tr>
						<tr>
							<td>2017.01.02</td>
							<td>2000</td>
							<td><a href="#"></a>1012038</td>
							<td>적립금 사용</td>
						</tr>
						<tr>
							<td>2017.01.02</td>
							<td>2000</td>
							<td>1012038</td>
							<td>적립금 사용</td>
						</tr>
						<tr>
							<td>2017.01.02</td>
							<td>2000</td>
							<td>1012038</td>
							<td>적립금 사용</td>
						</tr>
					</table>
				</div>
			</div>
			
<%@ include file="/WEB-INF/view/template/footer.jsp" %>  
			