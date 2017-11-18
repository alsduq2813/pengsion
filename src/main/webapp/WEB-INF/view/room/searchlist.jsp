<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/template/header.jsp" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/roomlist.css">
 <c:forEach var="p" items="${pensionInfo}">

<div class="empty-row"></div>
<div class="empty-row"></div>
 <div id="info">
 <h3>${p.pension_name}</h3>
                <table>
                    <tr>
                        <td  class="roomimg">
           				 <img src="${pageContext.request.contextPath}/pension/[${p.pension_no}]${p.pension_name}/${p.photo1}">
                            <div class="roomname">
                                <span>${p.location02}</span>
                            </div>
                        </td>
                     
                        <td class="roominfo">
                     <div class="roomtable">       
                <table>
                    <tr id="room">
                        <th>객실명</th>
                        <th>인원(기준/최대)</th>
                        <th>주중요금</th>
                        <th>주말요금</th>
                        <th>상태</th>
                    </tr>
                    
                    <c:forEach var="rlist" items="${roomInfo}">
                     <c:if test="${p.pension_no eq rlist.pension_no}">

                    <tr id="list">
                   
                        <td>${rlist.room_name}</td>
                        <td>${rlist.guest}/${rlist.max_guest}명</td>
                        <td>${rlist.off_weekday}(원)</td>
                        <td>${rlist.off_weekend}(원)</td>
                        <td><a href="${pageContext.request.contextPath}/pension/reserve?pension_no=${rlist.pension_no}">예약가능</a></td>
                    
                    </tr>
                    </c:if>  
                    </c:forEach> 
                         
                         </table>
                            </div>
                        </td>
                        
                    </tr>
                    </table>
                </div>
              </c:forEach>
                
<%@ include file="/WEB-INF/view/template/footer.jsp" %>  