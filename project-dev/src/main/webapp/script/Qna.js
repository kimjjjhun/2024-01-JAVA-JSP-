function updateCheck(qnaNum){
	if(confirm("수정하시겠습니까?")){
		alert("수정되었습니다.")
		location.href="OttServlet?command=update_qna&qnaNum="+qnaNum
	}else{
		alert("수정 취소되었습니다.")
	}
}

function check(){
	if(document.frm.qnaTitle.value == 0){
		alert("제목을 입력해주세요.");
		frm.qnaTitle.focus();
		return false;
	}
	if(document.frm.qnaCategory.value == 0){
		alert("카테고리를 입력해주세요.");
		frm.qnaTitle.focus();
		return false;
	}
	if(document.frm.qnaContent.value == 0){
		alert("내용을 입력해주세요.");
		frm.qnaContent.focus();
		return false;
	}
	if(document.frm.qnaPwd.value == 0){
		alert("비밀번호를 입력해주세요.");
		frm.qnaPwd.focus();
		return false;
	}
	alert("등록되었습니다.")
	return true;
}