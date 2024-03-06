function loginCheck(){
	if(document.frm.userid.value ==""){
		alert("아이디를 입력하세요.");
		frm.userid.focus();
		return false;
	}
	
	if(document.frm.pwd.value == ""){
		alert("암호를 입력하세요.");
		frm.pwd.focus();
		return false;
	}
	
	return true;
}
function idCheck(){
	if(document.frm.userid.value == ""){
		alert("아이디를 입력하세요.");
		document.frm.userid.focus();
		return false;
	}
			  //idCheck.do?userid=user찾아감
	let url = "idCheck.do?userid=" + document.frm.userid.value;
	window.open(url, "_blank_1", "width=450, height=200");
}