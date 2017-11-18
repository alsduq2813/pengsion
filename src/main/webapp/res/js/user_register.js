function agreeCheck() {
	// 체크박스 확인뒤 합격이면 다음 페이지로
	// 기본 이벤트를 중지시키는 명령
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
	var regex = /^[0-9a-z]{6,20}$/g;
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
	var regex = /^(?=.*[a-zA-Z])((?=.*\d)|(?=.*\W)).{6,20}$/g;
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

function ph01Check() {
	var input = document.querySelector("input[name=phone01]");
	var regex = /^[0-9]{3,5}$/g;
	if (regex.test(input.value)) {
		input.style = "border:2px solid blue";
		return true;
	} else {
		input.style = "border:2px solid red";
		return false;
	}
}

function ph02Check() {
	var input = document.querySelector("input[name=phone02]");
	var regex = /^[0-9]{3,5}$/g;
	if (regex.test(input.value)) {
		input.style = "border:2px solid blue";
		return true;
	} else {
		input.style = "border:2px solid red";
		return false;
	}
}

function ph03Check() {
	var input = document.querySelector("input[name=phone03]");
	var regex = /^[0-9]{3,5}$/g;
	if (regex.test(input.value)) {
		input.style = "border:2px solid blue";
		return true;
	} else {
		input.style = "border:2px solid red";
		return false;
	}
}

function mb02Check() {
	var input = document.querySelector("input[name=mobile02]");
	var regex = /^[0-9]{3,4}$/g;
	if (regex.test(input.value)) {
		input.style = "border:2px solid blue";
		return true;
	} else {
		input.style = "border:2px solid red";
		return false;
	}
}

function mb03Check() {
	var input = document.querySelector("input[name=mobile03]");
	var regex = /^[0-9]{4}$/g;
	if (regex.test(input.value)) {
		input.style = "border:2px solid blue";
		return true;
	} else {
		input.style = "border:2px solid red";
		return false;
	}
}

function emailCheck() {
	var input01 = document.querySelector("input[name=email01]");
	var input02 = document.querySelector("input[name=email02]");
	var email01 = input01.value;
	var email02 = input02.value;
	var regex = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/g;
	if (regex.test(email01+"@"+email02)) {
		input01.style = "border:2px solid blue";
		input02.style = "border:2px solid blue";
		return true;
	} else {
		input01.style = "border:2px solid red";
		input02.style = "border:2px solid red";
		return false;
	}
}

// function phoneCheck() {
// var input = document.querySelector("input[name=phone]");
// var regex = /^[0-9]{10,12}$/g;
// if (regex.test(input.value)) {
// input.style = "border:2px solid blue";
// return true;
// } else {
// input.style = "border:2px solid red";
// return false;
// }
// }

function sendCheck() {
	// 폼의 전송을 중지하고 검사한 뒤에 합격이면 전송한다

	// 기본 이벤트를 중지시키는 명령
	event.preventDefault();
	console.log("sendCheck!");
	// 검사
	var idCheckFlag = document.querySelector("#idCheckFlag");
	if (idCheckFlag.value == 'false') {
		alert("아이디 중복체크를 해주세요");
		return;
	}
	var result = pw1Check() && pw2Check() && nameCheck() && ph01Check()
			&& ph02Check() && mb02Check() && mb03Check() && emailCheck();
	if (!result) {
		alert("형식에 맞게 작성해 주세요");
		return;
	}
	// 전송
	var form = document.querySelector("#next02");
	form.submit();
}
