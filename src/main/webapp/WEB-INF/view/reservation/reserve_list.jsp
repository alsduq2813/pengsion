<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/template/header.jsp" %> 

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/member_myinfo.css">   
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/button.css">   
<div class="area-60 center">
	<div class="empty-row"></div>
		<div class="text-right">	
			<a href="javascript:history.back()"><button class="button mybutton">뒤로</button></a>
		</div>
		<h2>펜션예약 상태</h2>
	    <div class="row">
	        <p>펜션예약 현황을 확인할 수 있습니다<br>
	        예약상태를 변경할 수 있습니다</p>
	    </div>
		<table id="qna">
			<tr>
                <th>객실명</th>
				<th>예약자명</th>
                <th>숙박일</th>
                <th>결제금액</th>
				<th>예약상태</th>
			</tr>
			<c:forEach var="reservation" items="${reservation_list}">
					<tr>
						<td>${reservation.room_name}</td>
		                <td>${reservation.user_name}</td>
		                <td>${reservation.date}</td>
		                <td>${reservation.payment_price}</td>
						<td>
		                    <form action="reserve_list" method="post" class="deposit">
		                    	<input type="hidden" name="pension_no" value="${reservation.pension_no}">
		                    	<input type="hidden" name="reservation_no" value="${reservation.reservation_no}">
		                    	<select name="payment_condition">
			                    	<c:choose>
			                    		<c:when test="${reservation.payment_condition eq 'waiting'}">
					                        <option value="waiting" selected>입금대기중</option>
					                        <option value="complete">결제완료</option>
			                    		</c:when>
			                    		<c:otherwise>
			                    			 <option value="waiting" >입금대기중</option>
					                        <option value="complete" selected>결제완료</option>
			                    		</c:otherwise>
			                    	</c:choose>
			                    </select>
		                    <input type="submit" value="확인">
		                    </form>
		                </td>
					</tr>
			</c:forEach>
		</table>
</div>

<%@ include file="/WEB-INF/view/template/footer.jsp" %>    