<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/template/header.jsp" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/question.css">
            
            <c:if test="${loginFlag && !companyFlag}">
            <div class= "qborder center area-60">
            <div class="empty-row"></div>
            <div class="empty-row"></div>
            <div class="center area-80">
               <h2>질문 하기</h2>
            </div>
            
            
            <div class="empty-row"></div>
            <form action="${pageContext.request.contextPath}/mini/ask" method="post">
            <input type="hidden" name="pension_no" value="${no}">
            <table class="qand center area-70">
               <tr>
                  <th>
                  <input type=text name="title" placeholder="제목">
                  </th>
               </tr>
               <tr>
                  <td>
                  <textarea name="detail">${comFlag}</textarea>
                  </td>
               </tr>
               <tr>
                  <th>
                  <input type="submit" value="작성">
                  </th>
               </tr>   
            </table>
                </form>  
                   </div>
                  </c:if>
                  
                  <c:if test="${companyFlag}">
                     <div class="empty-row"></div>
                    <div class="empty-row"></div>
                     <div>
                    <table class="qborder center area-50">
                       <tr>
                          <th>${qInfo.title}</th>
                       </tr>
                       <tr>
                          <th>${qInfo.id}(${qInfo.date})</th>
                       </tr>
                       <tr>
                            <td>${qInfo.detail}</td>
                        </tr>
                      </table>
                      
                      </div>
                      <div class="empty-row"></div>
                     <div class="empty-row"></div>
                     <div class="qand center area-50">
                      <h2>답변하기</h2>
                      </div>
                     <div class="empty-row"></div>
                   <div class="answer">
                        <form  action="${pageContext.request.contextPath}/mini/ask" method="post">
                        <input type="hidden" name="question_no" value="${qno}">
                        <input type="hidden" name="pension_no" value="${no}">
                        <table class="qborder center area-40">
                            <tr>
                               <th><textarea name="detail"></textarea></th>
                            </tr>
                            <tr>
                                <td><input type="submit" value="답변"></td>
                            </tr>
                    </table>
                    </form>
                   </div>
                   </c:if>


<%@ include file="/WEB-INF/view/template/footer.jsp" %> 