<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/template/header.jsp" %>   


<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/member.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/member_register.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jquery-te-1.4.0.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/button.css">

			<script src="https://code.jquery.com/jquery-latest.js"></script>
			<script src="${pageContext.request.contextPath}/js/jquery-te-1.4.0.js"></script>
			<script src="${pageContext.request.contextPath}/js/pension_register.js"></script>
			
			<script>
				$(document).ready(function() {
					$(".editor").jqte();
				});
			</script>
			<div class="center" id="edit">
				<div class="empty-row"></div>
				<div class="text-right">	
					<a href="javascript:history.back()"><button class="button mybutton">뒤로</button></a>
				</div>
				<form action="room_edit" method="post" id="next02" enctype="multipart/form-data">
					<input type="hidden" name="pension_no" value="${pension.pension_no}">
					<input type="hidden" name="room_no" value="${room.room_no}">
					
					<div class="xans-member-join center">
						<h2>객실 수정</h2>
						<p class="required"><img src="${pageContext.request.contextPath}/img/ico_required.gif" /> 필수입력사항</p>
						<div class="boardWrite">
							<table>
								<caption>객실 정보</caption>
								<tbody>
									<tr>
										<th>객실명 <img src="${pageContext.request.contextPath}/img/ico_required.gif" /></th>
										<td><input value="${room.room_name}" id="pension_name" name="room_name" class="inputTypeText" placeholder="" type="text"></td>
									</tr>
									<tr>
										<th>구조/넓이<img src="${pageContext.request.contextPath}/img/ico_required.gif" /></th>
										<td>
											<textarea name="structure" class="textarea">${room.structure}</textarea>
										</td>
									</tr>
									<tr>
										<th>성인 추가비용 </th>
										<td><input id="pension_name" name="add_adult" class="inputTypeText" placeholder="" value="${room.add_adult}" type="text"></td>
									</tr>
									<tr>
										<th>아동 추가비용 </th>
										<td><input id="pension_name" name="add_child" class="inputTypeText" placeholder=""  value="${room.add_child}" type="text"></td>
									</tr>
									<tr>
										<th>유아 추가비용 </th>
										<td><input id="pension_name" name="add_baby" class="inputTypeText" placeholder="" value="${room.add_baby}" type="text"></td>
									</tr>
									<tr>
										<th>비수기 주중가격 <img src="${pageContext.request.contextPath}/img/ico_required.gif" /></th>
										<td><input id="pension_name" name="off_weekday" class="inputTypeText" placeholder="" value="${room.off_weekday}" type="text"></td>
									</tr>
									<tr>
										<th>비수기 주말가격 <img src="${pageContext.request.contextPath}/img/ico_required.gif" /></th>
										<td><input id="pension_name" name="off_weekend" class="inputTypeText" placeholder="" value="${room.off_weekend}" type="text"></td>
									</tr>
									<tr>
										<th>성수기 주중가격<img src="${pageContext.request.contextPath}/img/ico_required.gif" /></th>
										<td><input id="pension_name" name="peak_weekday" class="inputTypeText" placeholder="" value="${room.peak_weekday}" type="text"></td>
									</tr>
									<tr>
										<th>성수기 주말가격 <img src="${pageContext.request.contextPath}/img/ico_required.gif" /></th>
										<td><input id="pension_name" name="peak_weekend" class="inputTypeText" placeholder="" value="${room.peak_weekend}" type="text"></td>
									</tr>
									<tr>
										<th>구비시설 <img src="${pageContext.request.contextPath}/img/ico_required.gif" /></th>
										<td>
											<textarea name="facilities" class="textarea">${room.facilities}</textarea>
										</td>
									</tr>
									<tr>
										<th>특이사항 <img src="${pageContext.request.contextPath}/img/ico_required.gif" /></th>
										<td>
											<textarea name="specialnote" class="textarea">${room.specialnote}</textarea>
										</td>
									</tr>
									<tr>
										<th>기준인원 <img src="${pageContext.request.contextPath}/img/ico_required.gif" /></th>
										<td>
											<select name="guest">
												<option value="1">1</option>
												<option value="2">2</option>
												<option value="3">3</option>
												<option value="4">4</option>
												<option value="5">5</option>
												<option value="6">6</option>
												<option value="7">7</option>
												<option value="8">8</option>
												<option value="9">9</option>
												<option value="10">10</option>
												<option value="11">11</option>
												<option value="12">12</option>
												<option value="13">13</option>
												<option value="14">14</option>
												<option value="15">15</option>
												<option value="16">16</option>
												<option value="17">17</option>
												<option value="18">18</option>
												<option value="19">19</option>
												<option value="20">20</option>
												<option value="21">21</option>
												<option value="22">22</option>
												<option value="23">23</option>
												<option value="24">24</option>
												<option value="25">25</option>
												<option value="26">26</option>
												<option value="27">27</option>
												<option value="28">28</option>
												<option value="29">29</option>
												<option value="30">30</option>
											</select>명
										</td>
									</tr>
									<tr>
										<th>최대인원 <img src="${pageContext.request.contextPath}/img/ico_required.gif" /></th>
										<td>
											<select name="max_guest">
												<option value="1">1</option>
												<option value="2">2</option>
												<option value="3">3</option>
												<option value="4">4</option>
												<option value="5">5</option>
												<option value="6">6</option>
												<option value="7">7</option>
												<option value="8">8</option>
												<option value="9">9</option>
												<option value="10">10</option>
												<option value="11">11</option>
												<option value="12">12</option>
												<option value="13">13</option>
												<option value="14">14</option>
												<option value="15">15</option>
												<option value="16">16</option>
												<option value="17">17</option>
												<option value="18">18</option>
												<option value="19">19</option>
												<option value="20">20</option>
												<option value="21">21</option>
												<option value="22">22</option>
												<option value="23">23</option>
												<option value="24">24</option>
												<option value="25">25</option>
												<option value="26">26</option>
												<option value="27">27</option>
												<option value="28">28</option>
												<option value="29">29</option>
												<option value="30">30</option>
												<option value="31">31</option>
												<option value="32">32</option>
												<option value="33">33</option>
												<option value="34">34</option>
												<option value="35">35</option>
												<option value="36">36</option>
												<option value="37">37</option>
												<option value="38">38</option>
												<option value="39">39</option>
												<option value="40">40</option>
												<option value="40">40</option>
												<option value="41">41</option>
												<option value="42">42</option>
												<option value="43">43</option>
												<option value="44">44</option>
												<option value="45">45</option>
												<option value="46">46</option>
												<option value="47">47</option>
												<option value="48">48</option>
												<option value="49">49</option>
												<option value="50">50</option>
											</select>명
										</td>
									</tr>
									<tr>
										<th>객실사진1</th>
										<td>
											<input type="hidden" name="origin_p1" value="${room.photo1}">
											<input type="image" src="${pageContext.request.contextPath}/pension/[${pension.pension_no}]${pension.pension_name}/${room.room_name}/${room.photo1}">
											사진변경 : <input type="file" id="file" name="photo1" required class="user-input fill">
										</td>
									</tr>
									<tr>
										<th>객실사진2</th>
										<td>
											<input type="hidden" name="origin_p2" value="${room.photo2}">	
											<input type="image" src="${pageContext.request.contextPath}/pension/[${pension.pension_no}]${pension.pension_name}/${room.room_name}/${room.photo2}">	
											사진변경 : <input type="file" id="file" name="photo2" required class="user-input fill">
										</td>
									</tr>
									<tr>
										<th>객실사진3</th>
										<td>
											<input type="hidden" name="origin_p3" value="${room.photo3}">
											<input type="image" src="${pageContext.request.contextPath}/pension/[${pension.pension_no}]${pension.pension_name}/${room.room_name}/${room.photo3}">
											사진변경 : <input type="file" id="file" name="photo3" required class="user-input fill">
										</td>
									</tr>
									<tr>
										<th>객실사진4</th>
										<td>
											<input type="hidden" name="origin_p4" value="${room.photo4}">
											<input type="image" src="${pageContext.request.contextPath}/pension/[${pension.pension_no}]${pension.pension_name}/${room.room_name}/${room.photo4}">
											사진변경 : <input type="file" id="file" name="photo4" required class="user-input fill">
										</td>
									</tr>
									<tr>
										<th>객실사진5</th>
										<td>
											<input type="hidden" name="origin_p5" value="${room.photo5}">
											<input type="image" src="${pageContext.request.contextPath}/pension/[${pension.pension_no}]${pension.pension_name}/${room.room_name}/${room.photo5}">
											사진변경 : <input type="file" id="file" name="photo5" required class="user-input fill">
										</td>
									</tr>
	
								</tbody>
							</table>
						</div>
					</div>
					<div class="empty-row"></div>
					<div class="btnArea text-center">
						<input type="submit" value="수정" onclick="sendCheck();" class="button mybutton">
						<input type="button" value="취소" onclick="location.href='javascript:history.back()' " class="button lightGrey">
					</div>
				</form>
			</div>
			
			
<%@ include file="/WEB-INF/view/template/footer.jsp" %>   
			