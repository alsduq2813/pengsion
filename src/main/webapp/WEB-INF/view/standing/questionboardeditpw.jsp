<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/template/header.jsp"%>
<link rel="stylesheet" type="text/css"
   href="${pageContext.request.contextPath}/css/standing.css">

<link rel="stylesheet" type="text/css"
   href="${pageContext.request.contextPath}/css/standing.css">

<div class="empty-row"></div>
<div class="empty-row"></div>
<div class="area-40 center">
   <div class="row text-center font-big">비밀번호 입력</div>
   <form action="questionboardeditpw" method="post">
      <input type="hidden" name="boardno" value="${boardno}">
      <input type="hidden" name="next" value="${next}">
      <div class="row inner-align-left">
         <div class="fill">
            <input class="form-input" type="password" name="pw"
               placeholder="비밀번호" required maxlength="20">
         </div>
         <div>
            <input class="form-btn" type="submit" value="확인">
         </div>
      </div>
   </form>
</div>
<div class="empty-row"></div>
<div class="empty-row"></div>



</main>

<%@ include file="/WEB-INF/view/template/footer.jsp"%>
