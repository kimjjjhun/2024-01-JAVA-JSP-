
function check(){
	   if (document.frm.contentName.value.length == 0) {
      alert("제목을 작성해주세요.");
      frm.contentName.focus();
      return false;
   }
   if (document.frm.genre.value.length == 0) {
      alert("장르를 입력해주세요");
      frm.genre.focus();
      return false;
   }if (document.frm.director.value.length == 0) {
      alert("감독을 입력해주세요");
      frm.director.focus();
      return false;
   }
   if (document.frm.actor.value.length == 0) {
      alert("출연 배우를 입력해주세요");
      frm.actor.focus();
      return false;
   }
   if (document.frm.year.value.length == 0) {
      alert("개봉 연도를 입력해주세요");
      frm.year.focus();
      return false;
   }
   if (isNaN(document.frm.year.value)) {
      alert("개봉 연도는 숫자입력만 가능합니다.");
      frm.year.focus();
      return false;
   }
   if (document.frm.story.value.length == 0) {
      alert("내용을 입력해주세요");
      frm.story.focus();
      return false;
   }
   return true;
}


function updateCheck(contentNum){
	if(confirm("수정하시겠습니까?")){
		alert("수정되었습니다");
		location.href="OttServlet?command=admin_content_detail&contentNum="+contentNum;
	}else{
		alert("수정이 취소되었습니다");
	}
	
}

function deleteCheck(){
	alert("삭제되었습니다.")
}
