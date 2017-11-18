function agreeCheck() {
	//체크박스 확인뒤 합격이면 다음 페이지로
	//기본 이벤트를 중지시키는 명령
	event.preventDefault();

	var cb1 = document.querySelector("#cb1");
	var cb2 = document.querySelector("#cb2");

	if (!cb1.checked) {
		alert("이용약관에 동의하셔야만 가입이 됩니다.")
	} else if (!cb2.checked) {
		alert("개인정보 수집 및 이용에 동의하셔야만 가입이 됩니다.")
	} else {
		var form = document.querySelector("#next01");
		form.submit();
	}
}




function idCheck() {
	var input = document.querySelector("#member_id");
	var regex = /^[\w]{6,15}$/g;
	console.log("s");
	if (regex.test(input.value)) {
		input.style = "border:2px solid blue";
		return true;
	} else {
		input.style = "border:2px solid red";
		return false;
	}
}

function pw1Check() {
	console.log("s");
	var input = document.querySelector("#pw1");
	var regex = /^[\w]{6,15}$/g;
	if (regex.test(input.value)) {
		input.style = "border:2px solid blue";
		return true;
	} else {
		input.style = "border:2px solid red";
		return false;
	}
}

function pw2Check() {
	var pw = document.querySelector("#pw1");
	var pw2 = document.querySelector("#pw2");

	if (pw.value === pw2.value) {
		pw2.style = "border:2px solid blue";
		return true;
	} else {
		pw2.style = "border:2px solid red";
		return false;
	}
}

function nameCheck() {
	var input = document.querySelector("input[name=name]");
	var regex = /^[가-힣]{2,7}$/g;
	if (regex.test(input.value)) {
		input.style = "border:2px solid blue";
		return true;
	} else {
		input.style = "border:2px solid red";
		return false;
	}
}


function sendCheck() {
	//폼의 전송을 중지하고 검사한 뒤에 합격이면 전송한다
	//전송
	var form = document.querySelector("#next02");
	form.submit();
}
