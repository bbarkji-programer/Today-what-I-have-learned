/**
* join_frm.id.value 는 3글자 이상
* join_firm.pw==join_frm
* 이름, 메일
*/
function infoConfirm(){
	if(join_frm.id.value.length<3){
		alert('ID는 3글자 이상');
		join_frm.id.focus();
		return;
	}
	if(!join_frm.pw.value){
		alert('비밀번호는 필수입력 사항');
		join_frm.pw.focus();
		return;
	}
	if(join_frm.pw.value!=join_frm.pwChk.value){
		alert('비밀번호 불일치');
		join_frm.pw.value='';
		join_frm.pw.focus();
		return;
	}
	if(!join_frm.name.value){
		alert('이름은 필수입력 사항');
		join_frm.name.focus();
		return;
	}
	if(join_frm.email.value.length!=0 &&
			(join_frm.email.value.indexOf('@')<=0 ||
			 join_frm.email.value.lastIndexOf('@')==join_frm.email.value.length-1 ||
			 join_frm.email.value.lastIndexOf('@')>join_frm.email.value.lastIndexOf('.'))){
		alert('유효하지 않은 이메일 형식');
		join_frm.email.focus();
		return;
	}
	if(!join_frm.tempBirth.value){
		alert('생일은 필수입력 사항');
		join_frm.tempBirth.focus();
		return;
	}
	join_frm.submit(); // 강제로 submit 이벤트 발생
}
