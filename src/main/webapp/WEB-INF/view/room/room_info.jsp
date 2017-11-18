<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/template/header.jsp" %>    


<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/member_myinfo.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/button.css">
   <script>
    var img="주소?  ";
    function move(a){
        window.open(a);
    }
</script>
<div class="center" id="info">
	<div class="empty-row"></div>
		<h2>${room.room_name}</h2>
		<div class="text-right">	
		    <a href="${pageContext.request.contextPath}/room/room_edit?room_no=${room.room_no}"><button class="button mybutton">정보수정</button></a>
			<a href="${pageContext.request.contextPath}/pension/pension_info?pension_no=${pension.pension_no}"><button class="button lightGrey">뒤로</button></a>
		 </div>
	    
	    <div class="empty-row"></div>
	<div class="center">
	
	    <table id="profile">
	        <tr>
	            <th>객실명</th>
	            <td>${room.room_name}</td>
	        </tr>
	        <tr>
	            <th>구조/넓이</th>
	            <td>${room.structure}</td>
	        </tr>
	        <tr>
	            <th>구비시설</th>
	            <td>${room.facilities}</td>
	            
	        </tr>
	        <tr>
	            <th>특이사항</th>
	            <td>${room.specialnote}</td>
	            
	        </tr>
	        <tr>
	            <th>기준인원/최대인원</th>
	            <td>${room.guest} / ${room.max_guest}</td>
	            
	        </tr>
	        <tr>
	            <th>사진1</th>
	            <td><img src="${pageContext.request.contextPath}/pension/[${pension.pension_no}]${pension.pension_name}/${room.room_name}/${room.photo1}"></td>
	        </tr>
	        <tr>
	            <th>사진2</th>
	            <td><img src="${pageContext.request.contextPath}/pension/[${pension.pension_no}]${pension.pension_name}/${room.room_name}/${room.photo2}"></td>
	        </tr>
	        <tr>
	            <th>사진3</th>
	            <td><img src="${pageContext.request.contextPath}/pension/[${pension.pension_no}]${pension.pension_name}/${room.room_name}/${room.photo3}"></td>
	        </tr>
	        <tr>
	            <th>사진4</th>
	            <td><img src="${pageContext.request.contextPath}/pension/[${pension.pension_no}]${pension.pension_name}/${room.room_name}/${room.photo4}"></td>
	        </tr>
	        <tr>
	            <th>사진5</th>
	            <td><img src="${pageContext.request.contextPath}/pension/[${pension.pension_no}]${pension.pension_name}/${room.room_name}/${room.photo5}"></td>
	        </tr>
	    </table>
	    <div class="empty-row"></div>
	    <div class="empty-row"></div>
	    <table id="reservation_info">   
	        <tr>
	            <th>비수기주중</th>
	            <th>비수기주말</th>
	            <th>성수기주중</th>
	            <th>성수기주말</th>
	        </tr>
	        <tr>
	            <td>${room.off_weekday}</td>
	            <td>${room.off_weekend}</td>
	            <td>${room.peak_weekday}</td>
	            <td>${room.peak_weekend}</td>
	        </tr>
	    </table>
	    </div>
	    <div class="empty-row"></div>
	    <div class="empty-row"></div>
	    
	    <div class="center">
	    <table id="reservation_info">   
	        <tr>
	            <th>성인 추가요금</th>
	            <th>아동 추가요금</th>
	            <th>유아 추가요금</th>
	            
	        </tr>
	        <tr>
	            <td>${room.add_adult}</td>
	            <td>${room.add_child}</td>
	            <td>${room.add_baby}</td>
	        </tr>
	    </table>
	    </div>
	    <div class="empty-row"></div> 
</div>


   
    

    
<%@ include file="/WEB-INF/view/template/footer.jsp" %>    
