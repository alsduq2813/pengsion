<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/template/header.jsp" %>   
    
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reservation.css">
                
                <div class="area-60 center">
              	  <div class="empty-row"></div>
                    
                	<h3>객실정보 확인</h3>
                  	  	<table>
	                    	<thead>
	                    		<tr>
	                    			<th>객실명</th>
	                    			<th>기준 / 최대</th>
	                    			<th>이용일</th>
	                    			<th>성인</th>
	                    			<th>아동</th>
	                    			<th>유아</th>
	                    			<th>이용요금</th>
	                    		</tr>
	                    	</thead>
	                    	
	                    	<tbody>
	                    		<c:forEach var="map" items="${state_map}">
	                    			<c:forEach var="key" items="${map.key}">
	                    				<c:forEach var="state" items="${map.value}">
				                    		<tr>
				                    			<td>${state.room_name}</td>
				                    			<td>${state.guest} / ${state.max_guest}</td>
				                    			<td>${state.date}</td>
				                    			<td>${state.adult}</td>
				                    			<td>${state.child}</td>
				                    			<td>${state.baby}</td>
				                    			<td>${state.tot}원</td>
				                    		</tr>
		                    			</c:forEach>
	                    			</c:forEach>
	                    		</c:forEach>
	                    	</tbody>
	                    </table>
                
                <div class="empty-row"></div>
                
               <script>
               function mileageCheck() {
            		var input = document.querySelector("#useMileage");
            		var result = document.querySelector("#total2");
            		console.log(result.innerText);
            		var useMileage = input.value;
            		var myMileage = ${member.mileage};
            		var total = ${total};
            		var total2 = total-useMileage;
            		console.log(useMileage);
            		if(useMileage>myMileage){
            			alert("마일리지가 부족합니다.");
            			input.value=0;
            			return ;
            		}else if (useMileage>total) {
            			input.value = total;
            		}else if(input.value<0){
            			input.value=0;
            		}else{
            			result.innerText=total2+"원";
            		}
            	}
               </script>
                <div class="info2">
                        <h3>예약</h3>
                           <form action="reserving02" method="post">
                           <input type="hidden" name="pension_no" value="${pension_no}">
                           <input type="hidden" name="total" value="${total}">
                           <c:forEach var="map" items="${state_map}">
                           		<c:forEach var="key" items="${map.key}">
                           			<input type="hidden" name="id" value="${key}">
                           			<c:forEach var="value" items="${map.value}">
                           				  <input type="hidden" name="${map.key}room_no" value="${value.room_no}">
                           				  <input type="hidden" name="${map.key}room_name" value="${value.room_name}">
                           				  <input type="hidden" name="${map.key}checkin" value="${value.date}">
                           				  <input type="hidden" name="${map.key}guest" value="${value.guest}">
                           				  <input type="hidden" name="${map.key}max_guest" value="${value.max_guest}">
                           				  <input type="hidden" name="${map.key}price" value="${value.price}">
                           				  <input type="hidden" name="${map.key}add_adult" value="${value.add_adult}">
                           				  <input type="hidden" name="${map.key}add_child" value="${value.add_child}">
                           				  <input type="hidden" name="${map.key}add_baby" value="${value.add_baby}">
                           				  <input type="hidden" name="${map.key}adult" value="${value.adult}">
                           				  <input type="hidden" name="${map.key}child" value="${value.child}">
                           				  <input type="hidden" name="${map.key}baby" value="${value.baby}">
                           				  <input type="hidden" name="${map.key}tot" value="${value.tot}">
                           			</c:forEach>
                           		</c:forEach>
                	       </c:forEach>
                       
                               <table>
                               		<tr>
                               			<th>총 금액</th>
                               			<td><p id="total">${total}원</p></td>
                               		</tr>
                      				<tr>
                                        <th>마일리지 사용</th>
                                        <td><input type="number"  name="useMileage" id="useMileage" min="0"  max="${member.mileage}"onkeyup="mileageCheck();">원   <span>*보유적립금은 ${member.mileage}원입니다</span></td>
                            		</tr>
									<tr>
									     <th>총 결제금액</th>
									     <td><p id="total2">${total}원</p></td>
									</tr>
                               </table>
                               
                               <div class="empty-row"></div>
								<h3>예약자 정보</h3>
                               <table>
	                               	<tr>
	                               		<th>예약자명</th>
	                               		<td><input type="text" name="user_name" value="${member.name}" readonly></td>
	                               	</tr>
	                               	<tr>
	                               		<th>연락처</th>
	                               		<td><input type="text" name="mobile01" value="${member.mobile}" readonly></td>
	                               	</tr>
	                               	<tr>
	                               		<th>비상연락처</th>
	                               		<td><input type="text" name="mobile02"></td>
	                               	</tr>
                               </table>
                               <div class="empty-row"></div>
                               <div class="text-center" >
									<input id="account" name="payment_method" value="account" type="radio" checked="checked">
									<label for="card">무통장입금</label>
									<input id="card" name="payment_method" value="card" type="radio">
									<label for="account">카드결제</label>
								</div>
                           	   <div class="text-center"><p>예약시 개인정보취급방침 및 예약이용문의에 동의하게 됩니다<p></div>
                                  
                           	    <div class="reservebtn text-center">
                            	    <input type="button" value="취소">
                            	    <input type=submit value="확인">
                            	</div>
                                  
                            </form>
                </div>
                    
                    
                <div class="empty-row"></div>
			</div>
<%@ include file="/WEB-INF/view/template/footer.jsp" %>   
			