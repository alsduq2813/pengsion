<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/WEB-INF/view/template/header.jsp" %>
<style>
	.pbtn{
        width: 120px;
        height: 40px;
        background-color: #CAC5C5;
        display: inline;
        font-size: 1em; 
        border: 0.2px solid white;
        background-size: 30px;      
        color: #515050;
    }
</style>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/member_myinfo.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/button.css">
<div class="empty-row"></div>
<div class="area-70 center">
    <h2>펜션정보</h2>
    <div class="row text-right">
	    <a href="${pageContext.request.contextPath}/pension/pension_edit?pension_no=${pension.pension_no}"><button class="button mybutton">정보수정</button></a>
	    <a href="${pageContext.request.contextPath}/room/room_register?pension_no=${pension.pension_no}"><button class="button mybutton" >객실등록</button></a>
	    <a href="${pageContext.request.contextPath}/reservation/reserve_list?pension_no=${pension.pension_no}"><button class="button mybutton">예약현황</button></a>
    </div>
    <table id="profile">
        <tr>
            <th>펜션명</th>
            <td>${pension.pension_name}</td>
        </tr>
        <tr>
            <th>펜션주소</th>
            <td>${pension.location01} ${pension.location02} ${pension.location03}</td>
        </tr>
        <tr>
            <th>연락처</th>
            <td>${pension.phone}</td>
            
        </tr>
        <tr>
            <th>픽업여부</th>
            <td>${pension.pickup}</td>
            
        </tr>
        <tr>
            <th>이용/시설</th>
            <td>${pension.guide}</td>
            
        </tr>
        <tr>
            <th>주의사항</th>
            <td>${pension.caution}</td>
        </tr>
        <tr>
            <th>성수기기간</th>
            <td>${pension.peak_start} - ${pension.peak_end}</td>
        </tr>
        <tr>
            <th>사진1</th>
            <td><img src="${pageContext.request.contextPath}/pension/[${pension.pension_no}]${pension.pension_name}/${pension.photo1}"></td>
        </tr>
        <tr>
            <th>사진2</th>
            <td><img src="${pageContext.request.contextPath}/pension/[${pension.pension_no}]${pension.pension_name}/${pension.photo2}"></td>
        </tr>
        <tr>
            <th>사진3</th>
            <td><img src="${pageContext.request.contextPath}/pension/[${pension.pension_no}]${pension.pension_name}/${pension.photo3}"></td>
        </tr>
        <tr>
            <th>사진4</th>
            <td><img src="${pageContext.request.contextPath}/pension/[${pension.pension_no}]${pension.pension_name}/${pension.photo4}"></td>
        </tr>
        <tr>
            <th>사진5</th>
            <td><img src="${pageContext.request.contextPath}/pension/[${pension.pension_no}]${pension.pension_name}/${pension.photo5}"></td>
        </tr>
    </table>
    <div class="empty-row"></div>
    <div class="empty-row"></div>
    <table id="reservation_info">   
        <tr>
            <th>은행명</th>
            <th>계좌번호</th>
            <th>예금주</th>
        </tr>
        <tr>
            <td>${pension.bank}</td>
            <td>${pension.account}</td>
            <td>${pension.depositor}</td>
        </tr>
    </table>
    </div>
    <div class="empty-row"></div>
    

        <div class="empty-row"></div>
        
        <hr>
		<div class="empty-row"></div>
<div class="area-70 center">
    <h2>객실정보 리스트</h2>
		<table id="interest">
			<tr>
                <th>객실번호</th>
				<th>객실명</th>
				<th>구조/넓이</th>
				<th>기준/최대인원</th>
				<th>상세보기</th>
                <th>수정</th>
			</tr>
			<c:forEach var="room_list" items="${room_list}">
				<tr>
	                <td>${room_list.room_no}</td>
	                <td>${room_list.room_name}</td>
	                <td>${room_list.structure}</td>
	                <td>${room_list.guest} / ${room_list.max_guest}</td>
	                <td><a href="${pageContext.request.contextPath}/room/room_info?room_no=${room_list.room_no}">상세보기</a></td>
	                <td><a href="${pageContext.request.contextPath}/room/room_edit?room_no=${room_list.room_no}">수정</a></td>
				</tr>
			</c:forEach>
		</table>
</div>
<div class="empty-row"></div>
<div class="empty-row"></div>

<%@ include file ="/WEB-INF/view/template/footer.jsp" %>