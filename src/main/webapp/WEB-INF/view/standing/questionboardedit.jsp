<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/template/header.jsp" %> 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/standing.css">      

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/standing.css">

            <div class="empty-row"></div>
            <div class="empty-row"></div>
<div class="submenu">            
                     
            <div class="submenucontext">
            <form action="questionboardedit" method="post">
              <table border="1" width="50%" align="center" height="50%">
                  
            <tbody>
        <tr>
        <td height=50 align=center bgcolor=#999999>
        <font color=white><B>문의하기</B></font>
        </td>
       </tr>
                  <br>
      <tr><td>
         <input type="text" name="writer" placeholder="작성자" required value="${questionboard.writer}" readonly}>
      </td></tr>
      <tr><td>
         <input type="text" name="title" placeholder="제목" required size="138.5" value="${questionboard.title}">
      </td></tr>
      <tr><td>
         <textarea name="detail" placeholder="내용" required 
            rows="22" cols="140"  
         >${questionboard.detail}</textarea>
      </td></tr>
      <tr><td>
         <input type="password" name="pw" placeholder="비밀번호" required maxlength="20">
      </td></tr>
          </tbody>
            </table>
                <br>
                <div align="center">
               <input type="submit" value="수정하기">&nbsp;&nbsp; <button type="button" onclick="history.go(-1)">뒤로가기</button>
               </div>
                </form>
                
           
                
            </div>
        </div>
       
            
            
          
        </main>

        <%@ include file="/WEB-INF/view/template/footer.jsp" %>

 