<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/template/header.jsp" %> 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/standing.css">      

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/standing.css">

           
<div class="empty-row"></div>
<div class="area-90 center">
       <div class="row text-right" align="right" >${questionboard.reg}</div>
    
    </div>
    <b>${questionboard.title}&nbsp;</b>  &#124; &nbsp;게시판
    <hr>
    
    <b>&nbsp;${questionboard.writer}</b>
    <div class="row">
        <form action="#" method="post">
                <table class="table" border="0" width="100%" border="">
                <tbody>
                    <tr>
                        <td height="300" valign="top">
                            ${questionboard.detail}
                        </td>
                    </tr>
                    
                </tbody>
                <tfoot>
                    <tr>
                        <th colspan="2" align="right">
                            <input class="form-btn" type="button" value="새글쓰기" onclick="location.href='questionboard';">
                            <input class="form-btn" type="button" value="답글쓰기" onclick="location.href='write.it?title=${bdto.title}&gno=${bdto.gno}&depth=${bdto.depth}&parent=${bdto.parent}'">
                            <input class="form-btn" type="button" value="수정하기" onclick="location.href='questionboardeditpw?next=questionboardedit&boardno=${questionboard.boardno}'">
                            <input class="form-btn" type="button" value="삭제하기" onclick="location.href='${pageContext.request.contextPath }/standing/questionboarddeletepw/${questionboard.boardno}'">
                            <input class="form-btn" type="button" value="목록으로" onclick="location.href='questionboardlist';">
                        </th>
                    </tr>
                </tfoot>
            </table>
        </form>
    </div>
    <form action="replyinsert.it" method="post">
       <input type="hidden" name="writer" value="${userId}">
      <input type="hidden" name="parent" value="${bdto.no}">
        <div class="row">
           <c:choose>
            <c:when test="${loginFlag}">
                  <textarea class="form-input" width="80%" rows="3" placeholder="댓글 내용 입력" name="detail" required></textarea>
            </c:when>
            <c:otherwise>
                  <textarea class="form-input" rows="3" placeholder="작성하시려면 로그인 해 주세요" name="detail" required disabled></textarea>
            </c:otherwise>
         </c:choose>
        </div>
        <div class="row inner-align-right">
           <c:choose>
            <c:when test="${loginFlag}">
                  <input class="form-btn" type="submit" value="댓글 등록">
            </c:when>
            <c:otherwise>
                  <input class="form-btn" type="submit" value="댓글 등록" disabled>
            </c:otherwise>
         </c:choose>
        </div>
    </form>
    <c:choose>
    <c:when test="${empty list || list.size() == 0}">
       <div class="row font-medium">
          댓글이 존재하지 않습니다. 첫 번째 댓글의 주인공이 되어주세요.
       </div>
    </c:when>
    <c:otherwise>
       <div class="row">
           <table class="table">
               <tbody>
                   <c:forEach var="rdto" items="${list}">
                      <tr>
                          <th width="20%">${rdto.writer}</th>
                          <td>
                              <p>${rdto.detail}</p>
                              <hr>
                              <small>${rdto.reg}</small>
                              <c:if test="${loginFlag && userId eq rdto.writer}">
                        <a href="#">수정</a>
                        <a href="replydelete.it?no=${rdto.no}&parent=${rdto.parent}">삭제</a>
                        </c:if>
                          </td>
                      </tr>
                   </c:forEach>
               </tbody>
               <tfoot>
                   <tr>
                       <td colspan="2" align="right">
                           [이전] 1 2 3 4 5 6 7 8 9 10 [다음]
                       </td>
                   </tr>
               </tfoot>
           </table>
       </div>
    </c:otherwise>
    </c:choose>
</div>
<div class="empty-row"></div>
<div class="empty-row"></div> --%>

<%@ include file="/WEB-INF/view/template/footer.jsp"%>