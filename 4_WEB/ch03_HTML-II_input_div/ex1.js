// JavaScript source code
function chk() {
    if (frm.name.value.length < 2) {
        alert("이름은 2글자 이상 반드시 입력하시오.")
        frm.name.focus();
        return false;
    } else if (frm.id.value.length < 4) {
        alert("ID는 4글자 이상 반드시 입력하시오.")
        frm.id.focus();
        return false;
    } else if (frm.pw.value.length < 1) {
        alert("비밀번호를 1글자 이상 반드시 입력하시오.")
        frm.pw.focus();
        return false;
    } else if (frm.pwchk.vlaue.length < 1) {
        alert("비밀번호 일치여부를 확인하시오.")
        frm.pwchk.focus();
        return false;
    } else if (frm.pw.value != fr.pwchk.value) {
        alert("비밀번호가 일치하지 않습니다.")
        frm.pw.value = "";
        frm.pwchk.value = "";
        frm.pw.focus();
        return false;
    } else if (frm.email.value.lastIndexOf('@') > frm.email.value.lastIndexOf('.')) {
        alert("이메일 형식이 아닙니다.(id@domain)")
        frm.email.focus();
        return false;
    }
    return true;
}