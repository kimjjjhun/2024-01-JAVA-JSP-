function userConfirm(userId){
	var con = confirm("삭제한 회원은 되돌릴 수 없습니다.");
	
	if(con == true){
		alert(userId+"삭제되었습니다.");
		
		location.href="OttServlet?command=admin_delete_member&userId="+userId;
	}else{
		alert("취소되었습니다.");
	}
	
}