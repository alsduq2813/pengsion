<%-- <%@page import="spring.model.questionboardDao"%>
<%@page import="spring.bean.questionboard"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/view/template/header.jsp"%>

<%
	//[1] 게시글이 검색인지 전체목록인지 구별(type, key)
	//[2] 1번의 판정 결과에 따라 해당하는 목록을 가져옴(dao)
	//[3] 출력
	
	String type = request.getParameter("type");
	String key = request.getParameter("key");
	boolean searchFlag = type != null && key != null;
	
	//페이지 계산 코드를 작성
	//1페이지당 게시글 10개씩 출력
	int boardsize = 10;
	//page 이름의 파라미터를 이용하여 페이지를 구분
	String pageStr = request.getParameter("page");
	int pageNo;
	try{
		pageNo = Integer.parseInt(pageStr);
		if(pageNo <= 0) throw new Exception();
	}catch(Exception e){
		pageNo = 1;
	}
	
	
	int count;
	
	
	int start = pageNo * boardsize - boardsize + 1;
	int end = start + boardsize - 1;
	
	//네비게이터 계산
	//[1] 한 페이지당 10개의 블럭을 표시하기로 한다
	int blocksize = 10;
	//[2] 정해진 블럭사이즈를 이용하여 전체 블럭의 개수를 구한다(전체 페이지 수)
	//총 블럭수=(게시글수-1)/페이지크기+1
	int blocktotal = (count - 1) / boardsize + 1;
	int blockstart = (pageNo - 1) / blocksize * blocksize + 1;
	int blockend = blockstart + blocksize - 1;
	//blockend는 blocktotal을 넘어갈 수 없다
	if(blockend > blocktotal) blockend = blocktotal;
	
	List<questionboard> list;
	if(searchFlag){
		list = bdao.search(type, key, start, end); 
	}else{
		list = bdao.list(start, end); 
	}
	
%>

제목
<h1>자유 게시판</h1>
<h5>타인에 대한 비방/욕설은 제재를 받을 수 있습니다.</h5>

표(테이블)
<table border="1" width="80%" align="center">
	<thead>
		<tr>
			<th>번호</th>
			<th width="40%">제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
			<th>gno</th>
			<th>parent</th>
			<th>depth</th>
		</tr>
	</thead>
	<tbody>
		<%for(BoardDTO bdto : list){ %>
		<tr align="center">
			<td><%=bdto.getNo()%></td>
			<td align="left">
				depth 만큼의 띄어쓰기를 시도.. 띄어쓰기는 &nbsp;
				<%for(int i=0; i<bdto.getDepth(); i++){ %>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<%} %>
			
				<%if(bdto.getDepth() > 0){ %>
					<img src="../img/reply.png" width="25" height="15">
				<%} %>
				
				<a href="detail.jsp?no=<%=bdto.getNo()%>">
					<%=bdto.getTitle()%>
				</a>
				
				댓글 개수를 표시 (예) : 어서와[3]
				<%if(bdto.getReply() > 0){ %>
					[<%=bdto.getReply()%>]
				<%} %>
			</td>
			<td><%=bdto.getWriter()%></td>
			<td><%=bdto.getAuto()%></td>
			<td><%=bdto.getRead()%></td>
			<td><%=bdto.getGno()%></td>
			<td><%=bdto.getParent()%></td>
			<td><%=bdto.getDepth()%></td>
		</tr>
		<%} %>
	</tbody>
</table>

글쓰기 버튼
<table border="0" width="80%" align="center">
	<tbody><tr><td align="right">
		<a href="write.jsp">글쓰기</a>
	</td></tr></tbody>
</table>

페이지 이동 번호
<%
	String searchParam;
	if(searchFlag) searchParam = "&type="+type+"&key="+key;
	else searchParam = "";
%>
<table border="0" align="center" height="40"> 
<tbody><tr>
<th width="50">
	<%if(blockstart > 1){ %>
		<a href="list.jsp?page=<%=blockstart-1%><%=searchParam%>">이전</a>
	<%} %>
</th>
<%for(int i=blockstart; i<=blockend; i++){ %>
	<%if(i == pageNo){ %>현재 페이지일 경우 배경추가 + 링크제거
		<th width="40" bgcolor="yellow">
			<%=i%>
		</th>
	<%}else{ %>
		<th width="40">
			<a href="list.jsp?page=<%=i%><%=searchParam%>"><%=i%></a>
		</th>
	<%} %>
<%} %>

<th width="50">
	<%if(blockend < blocktotal){ %>
		<a href="list.jsp?page=<%=blockend+1%><%=searchParam%>">다음</a>
	<%} %>
</th>
</tr></tbody>
</table>
<br><br>
검색창
<form action="list.jsp" method="get">
	<select name="type">
		<%if(type != null && type.equals("writer")){ %>
			<option value="title">제목</option>
			<option value="writer" selected>작성자</option>
		<%}else{ %>
			<option value="title">제목</option>
			<option value="writer">작성자</option>
		<%} %>
	</select>
	
	<input type="search" name="key" placeholder="검색어" required
				value="<%=key==null?"":key%>">
	
	<input type="submit" value="검색">
</form>


<%@ include file="/WEB-INF/view/template/footer.jsp"%> --%>