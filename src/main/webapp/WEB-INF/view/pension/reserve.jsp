<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/template/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/reserve.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/table.css">
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/question.css">

<script src="https://code.jquery.com/jquery-latest.js">
	
</script>
<script>
	$(document)
			.ready(
					function() {
						$(".row").on(
								"click",
								function() {
									$(".submenu button").css("color", "white")
											.css("background-color", "gray");
									$(".row").css("background-color", "white")
											.css("color", "#222");
									$(".rowc").css("display", "block");
									$(".checkedc").css("display", "none");
									$(".askc").css("display", "none");
									$(".reviewc").css("display", "none");

								});

						$(".checked").on(
								"click",
								function() {
									$(".submenu button").css("color", "white")
											.css("background-color", "gray");
									$(".checked").css("background-color",
											"white").css("color", "#222");
									$(".rowc").css("display", "none");
									$(".checkedc").css("display", "block");
									$(".askc").css("display", "none");
									$(".reviewc").css("display", "none");

								});

						$(".ask").on(
								"click",
								function() {
									$(".submenu button").css("color", "white")
											.css("background-color", "gray");
									$(".ask").css("background-color", "white")
											.css("color", "#222");
									$(".rowc").css("display", "none");
									$(".checkedc").css("display", "none");
									$(".askc").css("display", "block");
									$(".reviewc").css("display", "none");

								});

						$(".review").on(
								"click",
								function() {
									$(".submenu button").css("color", "white")
											.css("background-color", "gray");
									$(".review").css("background-color",
											"white").css("color", "#222");
									$(".rowc").css("display", "none");
									$(".checkedc").css("display", "none");
									$(".askc").css("display", "none");
									$(".reviewc").css("display", "block");
								});

						$("input[type=checkbox]")
								.change(
										function(total) {
											var total = 0;

											if ($(this).is(":checked")) {
												$("#paybox").css("display",
														"block");

												var id = $(this).val();
												console.log(id);
												var room_no = $(this).siblings(
														"#" + id + "room_no")
														.val();
												var room_name = $(this)
														.siblings(
																"#"
																		+ id
																		+ "room_name")
														.val();
												var date = $(this).siblings(
														"#" + id + "date")
														.val();
												var guest = $(this).siblings(
														"#" + id + "guest")
														.val();
												var max_guest = $(this)
														.siblings(
																"#"
																		+ id
																		+ "max_guest")
														.val();
												var price = $(this).siblings(
														"#" + id + "price")
														.val();
												var add_adult = $(this)
														.siblings(
																"#"
																		+ id
																		+ "add_adult")
														.val();
												var add_child = $(this)
														.siblings(
																"#"
																		+ id
																		+ "add_child")
														.val();
												var add_baby = $(this)
														.siblings(
																"#"
																		+ id
																		+ "add_baby")
														.val();
												var row = appendData(id,
														room_name, date, guest,
														max_guest, price,
														add_adult, add_child,
														add_baby);

												$("#reservation")
														.append(
																"<input type='hidden' class='"+id+"' name='id' value='"+id+"'>");
												$("#reservation")
														.append(
																"<input type='hidden' class='"+id+"' name='"+id+"room_no' value='"+room_no+"'>");
												$("#reservation")
														.append(
																"<input type='hidden' class='"+id+"' name='"+id+"room_name' value='"+room_name+"'>");
												$("#reservation")
														.append(
																"<input type='hidden' class='"+id+"' name='"+id+"date' value='"+date+"'>");
												$("#reservation")
														.append(
																"<input type='hidden' class='"+id+"' name='"+id+"guest' value='"+guest+"'>");
												$("#reservation")
														.append(
																"<input type='hidden' class='"+id+"' name='"+id+"max_guest' value='"+max_guest+"'>");
												$("#reservation")
														.append(
																"<input type='hidden' class='"+id+"' name='"+id+"price' value='"+price+"'>");
												$("#reservation")
														.append(
																"<input type='hidden' class='"+id+"' name='"+id+"add_adult' value='"+add_adult+"'>");
												$("#reservation")
														.append(
																"<input type='hidden' class='"+id+"' name='"+id+"add_child' value='"+add_child+"'>");
												$("#reservation")
														.append(
																"<input type='hidden' class='"+id+"' name='"+id+"add_baby' value='"+add_baby+"'>");
												$("#reservation")
														.append(
																"<input type='hidden' class='"+id+"' name='"+id+"adult' value='"+guest+"'>");
												$("#reservation")
														.append(
																"<input type='hidden' class='"+id+"' name='"+id+"child' value='0'>");
												$("#reservation")
														.append(
																"<input type='hidden' class='"+id+"' name='"+id+"baby' value='0'>");
												$("#reservation")
														.append(
																"<input type='hidden' class='"+id+"' name='"+id+"tot' value='"+price+"'>");
												$("#paybox_body").append(row);

											} else if ($("input[type=checkbox]")
													.is(":checked") == false) {
												$("#paybox").css("display",
														"none");
												var id = $(this).val();
												$("#" + id).remove();
												$("." + id).remove();
											} else {
												var id = $(this).val();
												$("#" + id).remove();
												$("." + id).remove();
												$("#hidden_total").remove();
											}

											$(".total").each(
													function() {
														total += parseInt($(
																this).text());
														console.log("토탈더함");
													});
											$("#total").text(
													"총 결재금액 : " + total);
											$("#hidden_total").remove();
											$("#reservation")
													.append(
															"<input type='hidden' id='hidden_total' name='total' value="+total+">");
										});

						function appendData(id, room_name, date, guest,
								max_guest, price, add_adult, add_child,
								add_baby) {
							var row = createRow(id);
							row.append(createCell(room_name));
							row.append(createCell(date));
							row.append(createCell(guest + " / " + max_guest));
							var cell = createCell(createSelect1(id, guest,
									max_guest, add_adult, add_child, add_baby,
									price));
							row.append(cell);
							var cell = createCell(createSelect2(id, guest,
									max_guest, add_adult, add_child, add_baby,
									price));
							row.append(cell);
							var cell = createCell(createSelect3(id, guest,
									max_guest, add_adult, add_child, add_baby,
									price));
							row.append(cell);
							row.append(createTotal(id, price));

							return row;
						}

						function createRow(id) {
							//return $("<tr id='$(this).val();'/>");
							return $("<tr/>").attr("id", id);
						}

						function createCell(obj) {
							var cell = $("<td/>");
							if (typeof obj === "string")
								cell.text(obj);
							else if (typeof obj === "object")
								cell.append(obj);
							return cell;
						}

						function createTotal(id, obj) {
							var cell = $("<td/>");
							cell.text(obj);
							cell.attr("id", id + "_total");
							cell.attr("class", "total");
							return cell;
						}

						function createSelect1(id, guest, max_guest, add_adult,
								add_child, add_baby, price) {
							var select = $("<select/>");
							for (var i = 0; i <= max_guest; i++) {
								select.append("<option value="+i+">" + i
										+ "</option>");
							}
							$(select).children("option").each(function() {
								if ($(this).val() == guest) {
									$(this).attr("selected", true);
								}
							});
							$(select).attr("id", "adult" + id);
							$(select).on(
									"change",
									function() {
										total = changeSelect1(id, guest,
												max_guest, add_adult,
												add_child, add_baby, price);
										//changeSelect2(id, max_guest);
										//changeSelect3(id, max_guest);
									});
							//$(select).val(guest).attr("selected", "selected");
							/* $("#add_adult"+id+" option[value="+guest+"]").attr("selected", true); */
							return select;
						}

						function createSelect2(id, guest, max_guest, add_adult,
								add_child, add_baby, price) {
							var select = $("<select/>");
							for (var i = 0; i <= max_guest - guest; i++) {
								select.append("<option value="+i+">" + i
										+ "</option>");
							}
							$(select).attr("id", "child" + id);
							$(select).on(
									"change",
									function() {
										total = changeSelect2(id, guest,
												max_guest, add_adult,
												add_child, add_baby, price);

										//changeSelect1(id, max_guest);
										//changeSelect3(id, max_guest);
									});
							return select;
						}

						function createSelect3(id, guest, max_guest, add_adult,
								add_child, add_baby, price) {
							var select = $("<select/>");
							for (var i = 0; i <= max_guest - guest; i++) {
								select.append("<option value="+i+">" + i
										+ "</option>");
							}
							$(select).attr("id", "baby" + id);
							$(select).on(
									"change",
									function() {
										total = changeSelect3(id, guest,
												max_guest, add_adult,
												add_child, add_baby, price);
										//changeSelect1(id, max_guest);
										//changeSelect2(id, max_guest);
									});
							return select;
						}

						function changeSelect1(id, guest, max_guest, add_adult,
								add_child, add_baby, price) {
							selectedOption1 = Number($(
									"#adult" + id + " option:selected").val());
							selectedOption2 = Number($(
									"#child" + id + " option:selected").val());
							selectedOption3 = Number($(
									"#baby" + id + " option:selected").val());

							$("." + id + "[name=" + id + "adult]").remove();
							$("#reservation")
									.append(
											"<input type='hidden' class='"+id+"' name='"+id+"adult' value='"+selectedOption1+"'>");
							if (selectedOption1 == 0) {
								alert("보호자 동반없는 미성년자는 예약 및 입실 불가합니다.");
							}
							$("#child" + id + " option").remove();
							$("#baby" + id + " option").remove();

							for (var i = 0; i <= max_guest - selectedOption1
									- selectedOption3; i++) {
								if (i == selectedOption2) {
									$("#child" + id).append(
											"<option value="+i+" selected>" + i
													+ "</option>");
								} else {
									$("#child" + id).append(
											"<option value="+i+">" + i
													+ "</option>");
								}
							}
							for (var i = 0; i <= max_guest - selectedOption1
									- selectedOption2; i++) {
								if (i == selectedOption3) {
									$("#baby" + id).append(
											"<option value="+i+" selected>" + i
													+ "</option>");
								} else {
									$("#baby" + id).append(
											"<option value="+i+">" + i
													+ "</option>");
								}
							}
							if (selectedOption1 + selectedOption2
									+ selectedOption3 > guest) {
								if (selectedOption1 < guest
										&& selectedOption2 < guest
												- selectedOption1) {
									total = Number(price)
											+ (add_baby * (selectedOption1
													+ selectedOption2
													+ selectedOption3 - guest));
									$("#" + id + "_total").text(total);
									$("." + id + "[name=" + id + "tot]")
											.remove();
									$("#reservation")
											.append(
													"<input type='hidden' class="+id+" name='"+id+"tot' value="+total+">");
								} else if (selectedOption1<guest && selectedOption2>guest
										- selectedOption1) {
									total = Number(price)
											+ (add_baby * selectedOption3)
											+ (add_child * (selectedOption1
													+ selectedOption2 - guest));
									$("#" + id + "_total").text(total);
									$("." + id + "[name=" + id + "tot]")
											.remove();
									$("#reservation")
											.append(
													"<input type='hidden' class="+id+" name='"+id+"tot' value="+total+">");
								} else {
									total = Number(price)
											+ (add_adult
													* (selectedOption1 - guest)
													+ (add_child * selectedOption2) + (add_baby * selectedOption3));
									$("#" + id + "_total").text(total);
									$("." + id + "[name=" + id + "tot]")
											.remove();
									$("#reservation")
											.append(
													"<input type='hidden' class="+id+" name='"+id+"tot' value="+total+">");
								}
							} else {
								total = Number(price);
								$("#" + id + "_total").text(total);
								$("." + id + "[name=" + id + "tot]").remove();
								$("#reservation")
										.append(
												"<input type='hidden' class="+id+" name='"+id+"tot' value="+total+">");
							}

							total = 0;
							$(".total").each(function() {
								total += parseInt($(this).text());
							});
							$("#total").text("총 결재금액 : " + total);
							$("#hidden_total").remove();
							$("#reservation")
									.append(
											"<input type='hidden' id='hidden_total' name='total' value="+total+">");
							return total;
						}

						function changeSelect2(id, guest, max_guest, add_adult,
								add_child, add_baby, price) {
							selectedOption1 = Number($(
									"#adult" + id + " option:selected").val());
							selectedOption2 = Number($(
									"#child" + id + " option:selected").val());
							selectedOption3 = Number($(
									"#baby" + id + " option:selected").val());

							$("." + id + "[name=" + id + "child]").remove();
							$("#reservation")
									.append(
											"<input type='hidden' class='"+id+"' name='"+id+"child' value='"+selectedOption2+"'>");

							$("#adult" + id + " option").remove();
							$("#baby" + id + " option").remove();
							for (var i = 0; i <= max_guest - selectedOption2
									- selectedOption1; i++) {
								if (i == selectedOption3) {
									$("#baby" + id).append(
											"<option value="+i+" selected>" + i
													+ "</option>");
								} else {
									$("#baby" + id).append(
											"<option value="+i+">" + i
													+ "</option>");
								}
							}
							for (var i = 0; i <= max_guest - selectedOption2
									- selectedOption3; i++) {
								if (i == selectedOption1) {
									$("#adult" + id).append(
											"<option value="+i+" selected>" + i
													+ "</option>");
								} else {
									$("#adult" + id).append(
											"<option value="+i+">" + i
													+ "</option>");
								}
							}
							if (selectedOption1 + selectedOption2
									+ selectedOption3 > guest) {
								if (selectedOption1 < guest
										&& selectedOption2 < guest
												- selectedOption1) {
									total = Number(price)
											+ (add_baby * (selectedOption1
													+ selectedOption2
													+ selectedOption3 - guest));
									$("#" + id + "_total").text(total);
									$("." + id + "[name=" + id + "tot]")
											.remove();
									$("#reservation")
											.append(
													"<input type='hidden' class="+id+" name='"+id+"tot' value="+total+">");
								} else if (selectedOption1<guest && selectedOption2>guest
										- selectedOption1) {
									total = Number(price)
											+ (add_baby * selectedOption3)
											+ (add_child * (selectedOption1
													+ selectedOption2 - guest));
									$("#" + id + "_total").text(total);
									$("." + id + "[name=" + id + "tot]")
											.remove();
									$("#reservation")
											.append(
													"<input type='hidden' class="+id+" name='"+id+"tot' value="+total+">");
								} else {
									total = Number(price)
											+ (add_adult
													* (selectedOption1 - guest)
													+ (add_child * selectedOption2) + (add_baby * selectedOption3));
									$("#" + id + "_total").text(total);
									$("." + id + "[name=" + id + "tot]")
											.remove();
									$("#reservation")
											.append(
													"<input type='hidden' class="+id+" name='"+id+"tot' value="+total+">");
								}
							} else {
								total = Number(price);
								$("#" + id + "_total").text(total);
								$("." + id + "[name=" + id + "tot]").remove();
								$("#reservation")
										.append(
												"<input type='hidden' class="+id+" name='"+id+"tot' value="+total+">");
							}

							total = 0;
							$(".total").each(function() {
								total += parseInt($(this).text());
							});
							$("#total").text("총 결재금액 : " + total);
							$("#hidden_total").remove();
							$("#reservation")
									.append(
											"<input type='hidden' id='hidden_total' name='total' value="+total+">");
							return total;
						}

						function changeSelect3(id, guest, max_guest, add_adult,
								add_child, add_baby, price) {
							selectedOption1 = Number($(
									"#adult" + id + " option:selected").val());
							selectedOption2 = Number($(
									"#child" + id + " option:selected").val());
							selectedOption3 = Number($(
									"#baby" + id + " option:selected").val());
							$("." + id + "[name=" + id + "baby]").remove();
							$("#reservation")
									.append(
											"<input type='hidden' class='"+id+"' name='"+id+"baby' value='"+selectedOption3+"'>");
							$("#adult" + id + " option").remove();
							$("#child" + id + " option").remove();

							for (var i = 0; i <= max_guest - selectedOption3
									- selectedOption1; i++) {
								if (i == selectedOption2) {
									$("#child" + id).append(
											"<option value="+i+" selected>" + i
													+ "</option>");
								} else {
									$("#child" + id).append(
											"<option value="+i+">" + i
													+ "</option>");
								}
							}
							for (var i = 0; i <= max_guest - selectedOption3
									- selectedOption2; i++) {
								if (i == selectedOption1) {
									$("#adult" + id).append(
											"<option value="+i+" selected>" + i
													+ "</option>");
								} else {
									$("#adult" + id).append(
											"<option value="+i+">" + i
													+ "</option>");
								}
							}
							if (selectedOption1 + selectedOption2
									+ selectedOption3 > guest) {
								if (selectedOption1 < guest
										&& selectedOption2 < guest
												- selectedOption1) {
									total = Number(price)
											+ (add_baby * (selectedOption1
													+ selectedOption2
													+ selectedOption3 - guest));
									$("#" + id + "_total").text(total);
									$("." + id + "[name=" + id + "tot]")
											.remove();
									$("#reservation")
											.append(
													"<input type='hidden' class="+id+" name='"+id+"tot' value="+total+">");
								} else if (selectedOption1<guest && selectedOption2>guest
										- selectedOption1) {
									total = Number(price)
											+ (add_baby * selectedOption3)
											+ (add_child * (selectedOption1
													+ selectedOption2 - guest));
									$("#" + id + "_total").text(total);
									$("." + id + "[name=" + id + "tot]")
											.remove();
									$("#reservation")
											.append(
													"<input type='hidden' class="+id+" name='"+id+"tot' value="+total+">");
								} else {
									total = Number(price)
											+ (add_adult
													* (selectedOption1 - guest)
													+ (add_child * selectedOption2) + (add_baby * selectedOption3));
									$("#" + id + "_total").text(total);
									$("." + id + "[name=" + id + "tot]")
											.remove();
									$("#reservation")
											.append(
													"<input type='hidden' class="+id+" name='"+id+"tot' value="+total+">");
								}
							} else {
								total = Number(price);
								$("#" + id + "_total").text(total);
								$("." + id + "[name=" + id + "tot]").remove();
								$("#reservation")
										.append(
												"<input type='hidden' class="+id+" name='"+id+"tot' value="+total+">");
							}

							total = 0;
							$(".total").each(function() {
								total += parseInt($(this).text());
							});
							$("#total").text("총 결재금액 : " + total);
							$("#hidden_total").remove();
							$("#reservation")
									.append(
											"<input type='hidden' id='hidden_total' name='total' value="+total+">");
						}

						$("#reservation").on("click", function() {

						});

					});
</script>
<style>
#paybox {
	display: none;
}
</style>


<div id="info">
	<table class="outtable center">
		<tr>
			<td><img
				src="${pageContext.request.contextPath}/pension/[${pension.pension_no}]${pension.pension_name}/${pension.photo1}">
			</td>
			<td class="pinfo">

				<h3>${pension.pension_name}</h3>
				<hr>
				<table class="intable">

					<tr>
						<th>주소</th>
						<td>${pension.location01}${pension.location02}
							${pension.location03}</td>
					</tr>
					<tr>
						<th>예약문의</th>
						<td>${pension.phone}</td>
					</tr>
					<tr>
						<th>픽업여부</th>
						<td>${pension.pickup}</td>
					</tr>
					<tr>
						<th>시설</th>
						<td>시설</td>
					</tr>
					<tr>
						<th>정보</th>
						<td>정보</td>
					</tr>

				</table>

			</td>
		</tr>
	</table>
</div>

<div class="empty-row"></div>
<div class="empty-row"></div>

<div class="area-80 center">
	<table border="1" align="center" class="type07">
		<thead>
			<tr>
				<th rowspan="2" class="cols" width="100px">객실</th>
				<c:forEach var="map" begin="0" end="0" step="1"
					items="${reserve_state_list}">
					<c:forEach var="value" items="${map.value}">
						<th class="cols">${value.season}</th>
					</c:forEach>
				</c:forEach>
			</tr>
			<tr>
				<c:forEach var="map" begin="0" end="0" step="1"
					items="${reserve_state_list}">
					<c:forEach var="value" items="${map.value}">
						<th class="cols">${value.date}<br>${value.day}</th>
					</c:forEach>
				</c:forEach>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="map" items="${reserve_state_list}">
				<c:forEach var="key" items="${map.key}">
					<tr>
						<th rowspan="2">${key}</th>
						<c:forEach var="value" items="${map.value}">
							<td>${value.price}</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="value" items="${map.value}">
							<c:choose>
								<c:when test="${value.reservation eq '가능'}">
									<td><input type="checkbox" name="${value.room_id}"
										value="${value.room_id}"> <input type="hidden"
										id="${value.room_id}room_no" name="${value.room_id}room_no"
										value="${value.room_no}"> <input type="hidden"
										id="${value.room_id}room_name"
										name="${value.room_id}room_name" value="${key}"> <input
										type="hidden" id="${value.room_id}date"
										name="${value.room_id}date" value="${value.date}"> <input
										type="hidden" id="${value.room_id}guest"
										name="${value.room_id}guest" value="${value.guest}"> <input
										type="hidden" id="${value.room_id}max_guest"
										name="${value.room_id}max_guest" value="${value.max_guest}">
										<input type="hidden" id="${value.room_id}price"
										name="${value.room_id}price" value="${value.price}"> <input
										type="hidden" id="${value.room_id}add_adult"
										name="${value.room_id}add_adult" value="${value.add_adult}">
										<input type="hidden" id="${value.room_id}add_child"
										name="${value.room_id}add_child" value="${value.add_child}">
										<input type="hidden" id="${value.room_id}add_baby"
										name="${value.room_id}add_baby" value="${value.add_baby}">
									</td>
								</c:when>
								<c:otherwise>
									<td>완료</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
				</c:forEach>
			</c:forEach>
		</tbody>
	</table>


	<div class="area-80 center">
		<form
			action="${pageContext.request.contextPath}/reservation/reserving?pension_no=${pension.pension_no}"
			id="reservation" method="post">
			<table border="1" align="center" width="100%" id="paybox"
				class="type08">
				<thead>
					<tr>
						<th class="cols">객실명</th>
						<th class="cols">이용일</th>
						<th class="cols">기준인원 / 최대인원</th>
						<th class="cols">성인</th>
						<th class="cols">아동</th>
						<th class="cols">유아</th>
						<th class="cols">결제액</th>
					</tr>

				</thead>
				<tbody id="paybox_body">

				</tbody>
				<tfoot>
					<tr>
						<td colspan="7">
							<div class="text-right" id="total"></div>
							<div class="text-right">
								<button class="bt2">예약하기</button>
							</div>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
</div>
<div class="empty-row"></div>
<div class="empty-row"></div>
<div class="content">
	<table class="subtable">
		<tr>
			<th>객실명</th>
			<th>객실구조</th>
			<th>기준인원 / 최대인원</th>
			<th>비성수기 평일</th>
			<th>비성수기 주말</th>
			<th>성수기 평일</th>
			<th>성수기 주말</th>
			<th>추가요금<br>(성인/아동/유아)
			</th>
			<th>상세보기</th>
		</tr>
		<c:forEach var="room" items="${room_list}">
			<tr>
				<td>${room.room_name}</td>
				<td>${room.structure}</td>
				<td>${room.guest}/ ${room.max_guest}</td>
				<td>${room.off_weekday}</td>
				<td>${room.off_weekend}</td>
				<td>${room.peak_weekday}</td>
				<td>${room.peak_weekend}</td>
				<td>${room.add_adult}/${room.add_child}/${room.add_baby}</td>
				<td><a
					href="${pageContext.request.contextPath}/room/room_info?room_no=${room.room_no}">클릭</a></td>
			</tr>
		</c:forEach>
	</table>
</div>


<div class="submenu center">
	<hr>
	<ul>
		<li>
			<button class="checked">예약안내</button>
		</li>

		<li>
			<button class="row">규정 및 주의사항</button>
		</li>
		<li>
			<button class="ask">질문/답변</button>
		</li>
		<li>
			<button class="review">이용후기</button>
		</li>
	</ul>
</div>
<div class="checkedc">
	<h1>${pension.guide}</h1>
</div>
<div class="rowc">
	<h1>${pension.caution}</h1>
</div>
<div class="askc">
	<div class="area-80 center">
		<div class="area-80 center">
			<h3>질문게시판입니다</h3>
			<a href="${pageContext.request.contextPath}/mini/ask?pension_no=${pension.pension_no}&no=0">질문올리기!!(클릭)</a>
		</div>
		<div class="empty-row"></div>
		<c:forEach var="qq" items="${Qlist}">
			<div>
				<table class="qborder center area-80">
					<tr>
						<th>${qq.title}</th>
					</tr>
					<tr>
						<td>${qq.id}(${qq.date})<a
							href="${pageContext.request.contextPath}/mini/ask?pension_no=${pension.pension_no}&no=${qq.question_no}">답글달기</a></td>
					</tr>
					<tr>
						<td>${qq.detail}</td>
					</tr>
				</table>
			</div>
			<div class="empty-row"></div>
			<c:forEach var="aa" items="${Alist}">
				<c:if test="${qq.question_no eq aa.question_no}">
					<div>
						<table class="qborder center area-70">
							<tr>
								<th>${pension.pension_name}님에게보내는 댓글 (${aa.date})</th>
							</tr>
							<tr>
								<td>${aa.detail}</td>
							</tr>
						</table>
					</div>

					<div class="empty-row"></div>
				</c:if>
			</c:forEach>
			<div class="empty-row"></div>
			<div class="empty-row"></div>
		</c:forEach>

	</div>
	<div class="empty-row"></div>
	<c:forEach var="qq" items="${Qlist}">
		<div>
			<table class="qborder center area-80">
				<tr>
					<th>${qq.title}</th>
				</tr>
				<tr>
					<td>${qq.id}(${qq.date})<a
						href="${pageContext.request.contextPath}/mini/ask?pension_no=${pension.pension_no}&no=${qq.question_no}">답글달기</a></td>
				</tr>
				<tr>
					<td>${qq.detail}</td>
				</tr>
			</table>
		</div>
		<div class="empty-row"></div>
	</c:forEach>
</div>
<div class="reviewc">
	<h1>이용후기 게시판입니다</h1>
</div>
<div class="empty-row"></div>
<div class="empty-row"></div>
<hr>
<div class="empty-row"></div>
<div class="empty-row"></div>
<div class="imglist">
	<h3>이미지</h3>
	<img
		src="${pageContext.request.contextPath}/pension/[${pension.pension_no}]${pension.pension_name}/${pension.photo1}"
		width="290px" height="232px"> <img
		src="${pageContext.request.contextPath}/pension/[${pension.pension_no}]${pension.pension_name}/${pension.photo2}"
		width="290px" height="232px"> <img
		src="${pageContext.request.contextPath}/pension/[${pension.pension_no}]${pension.pension_name}/${pension.photo3}"
		width="290px" height="232px"> <img
		src="${pageContext.request.contextPath}/pension/[${pension.pension_no}]${pension.pension_name}/${pension.photo4}"
		width="290px" height="232px"> <img
		src="${pageContext.request.contextPath}/pension/[${pension.pension_no}]${pension.pension_name}/${pension.photo5}"
		width="290px" height="232px">
</div>

<div class="empty-row"></div>
<div class="empty-row"></div>

<%@ include file="/WEB-INF/view/template/footer.jsp"%>
