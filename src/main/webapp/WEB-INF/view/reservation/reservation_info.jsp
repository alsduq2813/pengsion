<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/customer.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/each.css">
<h1>고객님의 예약 정보는 아래와 같습니다</h1>
<table class="edge">
    <tr>
        <td>
    <table>
        <tr>
            <th>펜션명</th>
            <td>${payment.pension_name}</td>
        </tr>
        <tr>
            <th>결제번호</th>
            <td>${payment.payment_no}</td>
        </tr>
        <tr>
            <th>예약자명</th>
            <td>${payment.guest_name}<span>(핸드폰: ${payment.mobile01}, 비상연락처: ${payment.mobile02})</span></td>
        </tr>
        <tr>
            <th>예약일</th>
            <td>${payment.reserve_reg}</td>
        </tr>
        <tr>
            <th>결제일</th>
            <td>${payment.payment_reg}</td>
        </tr>
    </table>
    
    <table class="roomcost">
        <tr>
            <th>객실명</th>
            <th>이용일</th>
            <th>성인/아동/유아</th>
            <th>결제요금</th>
        </tr>
        <c:forEach var="reservation" items="${reservation_list}">
	        <tr>
	            <td>${reservation.room_name}</td>
	            <td>${reservation.date}</td>
	            <td>${reservation.adult}/${reservation.child}/${reservation.baby}</td>
	            <td>${reservation.room_price}원</td>
	        </tr>
        </c:forEach>
    </table>
    
    <table>
        <tr>
            <th>결제방법</th>
           	<c:choose>
           		<c:when test="${payment.payment_method eq 'account'}">
           			<td>무통장 입금</td>
           		</c:when>
           		<c:otherwise>
           			<td>카드결재</td>
           		</c:otherwise>
           	</c:choose>
            <th>예약상태</th>
           	<c:choose>
           		<c:when test="${payment.payment_condition eq 'waiting'}">
           			<td>입금대기</td>
           		</c:when>
           		<c:otherwise>
           			<td>완료</td>
           		</c:otherwise>
           	</c:choose>
            
        </tr>
    </table>
     <div class="empty-row"></div>
        <div class="row">
            <span><img src="${pageContext.request.contextPath}/img/ico_required.gif"> 주의사항</span>
        </div>
        <div class="row">
            <span>입금 완료 시간까지 입금하지 않으면 자동취소 됩니다.</span>
        </div>
    <table>
        <tr>
            <th>예약 신청 기간</th>
            <th>입금 완료 시간</th>
        </tr>
        <tr>
            <td>당일 0시부터 오전 9시 이전</td>
            <td>오전 10시 이전까지</td>
        </tr>
        <tr>
            <td>오전 8시부터 낮 12시 이전</td>
            <td>오후 2시 이전까지</td>
        </tr>
         <tr>
            <td>오후 12시부터 오후 4시 이전</td>
            <td>오후 6시 이전까지</td>
        </tr>
         <tr>
            <td>오후 4시부터 오후 8시 이전</td>
            <td>오후 9시 이전까지</td>
        </tr>
         <tr>
            <td>오후 8시부터 밤 12시 이전</td>
            <td>다음날 오전 10시 이전까지</td>
        </tr>
    </table>
        
 
</table>