function open_win(url, name) {
	window.open(url, name, "width=500, height=230");
}

function com_check() {
	if(document.check.commentContent.value.length == 0){
		alert("댓글 내용을 입력해주세요")
		return false
	}
}

function check1(bulletinNum) {
	console.log('asdsaed')
	if(confirm("삭제하시겠습니까?")) {
		location.href="OttServlet?command=bulletin_delete&bulletinNum="+bulletinNum
	}
}
