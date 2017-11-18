<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/error.css">

<div class="errorpage">
    <div height="60"></div>
    <img src="${pageContext.request.contextPath}/img/error.png" width="400" height="300">
        <span>현재 찾을 수 없는 페이지를 요청하였습니다</span>
    <div class="errorcontent">
        <p>존재하지 않는 주소를 입력하셨거나</p>
        <p>요청하신 페이지의 주소 변경, 삭제되어 찾을 수 없습니다</p>
        <p>궁금한 점이 있으시면 언제든 고객센터를 통해 문의해 주시길 바랍니다</p>
        
        <p>감사합니다</p>
    </div>
    
    <div class="errorbtn">
    <a href="${pageContext.request.contextPath}"><button>메인으로</button></a>
    <a href="#" onClick="history.back()"><button>이전페이지</button></a>
    </div>
</div>