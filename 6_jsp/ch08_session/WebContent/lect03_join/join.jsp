<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath %>/css/style.css" rel="stylesheet">
</head>
<script>
	function chk(){
		if(frm.id.value.length<4){
			alert("아이디는 4글자 이상 입력하세요.");
			frm.id.value="";
			frm.id.focus();
			return false;
		}else if(!frm.pw.value){
			alert("비밀번호를 입력하세요.");
			frm.pw.focus();
			return false;
		}else if(!frm.pwChk.value){
			alert("비밀번호 확인을 해주세요.");
			frm.pwChk.focus();
			return false;
		}else if(frm.pw.value != frm.pwChk.value){			
			alert("비밀번호가 일치하지 않습니다.");
			frm.pw.value="";
			frm.pwChk.value="";
			frm.pw.focus();
			return false;
		}else if(!frm.name.value){
			alert("이름을 입력하세요.");
			frm.name.focus();
			return false;
		}		
	}
</script>
<body>
<jsp:include page="header.jsp"/>
	<form action="agree.jsp" method="post" name="frm" onsubmit="return chk()">
		<table>
			<caption>회원가입</caption>
			<tr>
				<th>
					아이디
				</th>
				<td>
					<input type="text" name="id" autofocus="autofocus">
				</td>
			</tr>
			<tr>
				<th>
					비밀번호
				</th>
				<td>
					<input type="password" name="pw">
				</td>
			</tr>
			<tr>
				<th>
					비밀번호 확인
				</th>
				<td>
					<input type="password" name="pwChk">
				</td>
			</tr>
			<tr>
				<th>
					이름
				</th>
				<td>
					<input type="text" name="name">
				</td>
			</tr>
			<tr>
				<td> </td>
			</tr>	
			<tr>
				<td colspan="2">
					<input type="submit" value="가입">
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>