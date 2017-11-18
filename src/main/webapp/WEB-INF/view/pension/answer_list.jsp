<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/template/header.jsp" %>    
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/member_myinfo.css">
<div class="area-70 center">
<h2>펜션에 올라온 질문현황</h2>

    <div>
        <p>해당 펜션 이름을 클릭하면
        질문이 올라온 펜션페이지로 이동합니다</p>
    </div>
    <div class="empty-row"></div>
		<table id="qna">
			<tr>
				<th>상태</th>
                <th>펜션명</th>
				<th width="50%">제목</th>
				<th>등록일</th>
			</tr>
			<tr>
                <td>답변완료</td>
				<td><a href="${pageContext.request.contextPath}/reserve">콩나물펜션</a></td>
                <td id="question">안녕핫에ㅛ</td>
				<td>2017.10.11</td>
			</tr>
		</table>
</div>

<%@ include file="/WEB-INF/view/template/footer.jsp" %>    