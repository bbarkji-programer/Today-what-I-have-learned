<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath%>/css/join.css" rel="stylesheet">
</head>
<script>
	window.onload = function(){
		document.getElementById("chk").onsubmit = function(){
			// 아이디는 4글자 이상
			var id = document.getElementsByClassName("id")[0].value;
			if(id.length<3){
				alert("아이디는 3글자 이상 입력하세요.");
				chk.id.value="";
				chk.id.focus();
				return false;
			}
			// 비밀번호 일치해야
			var pw = document.getElementsByClassName("pw")[0].value;
			var pwChk = document.getElementsByClassName("pwChk")[0].value;
			if(pw!=pwChk){
				alert("비밀번호가 일치하지 않습니다.");
				chk.pw.value="";
				chk.pwChk.value="";
				chk.pw.focus();
				return false;
			}
			// 생년월일 선택해야
			var birth = document.getElementsByClassName("birth")[0].value;
			if(!birth){
				alert("생년월일을 선택해주세요.");
				return false;
			}
			// 취미 1개 이상 선택해야
			var hobby = document.getElementsByClassName("hobby");
			if(!hobby.length()){
				alert("취미를 1개 이상 선택해주세요. 없으면 '없음'을 선택하세요.");
				return false;
			}
			// 이메일 양식에 맞아야(.)
			var email = document.getElementsByClassName("email")[0].value;
			if(email.indexOf('.')!=1){
				alert("잘못된 이메일 형식입니다.");
				frm.email.value="";
				frm.email.focus();
				return false;
			}
		};
	};
</script>
<body>
<jsp:include page="header.jsp"/>
<div id="joinForm_wrap">
<form action="joinPro.jsp" method="post" id="chk">
<div id="join_title">회원가입</div>
<input type="hidden" name="hiddenParam" value="xx">
	<table>	
		<tr>
			<th>이름</th>
			<td><input type="text" name="name" class="name" required="required"></td>
		</tr>
		<tr>
			<th>아이디</th>
			<td colspan="2"><input type="text" name="id" class="id"></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="pw" class="pw"></td>
		</tr>
		<tr>
			<th>비밀번호 확인</th>
			<td><input type="password" name="pwChk" class="pwChk"></td>
		</tr>
		<tr>
			<th>생년월일</th>
			<td><input type="date" name="birth" class="birth"></td>
		</tr>
		<tr>
			<th>취미</th>
			<td>
				<input type="checkbox" name="hobby" value="독서" multiple="multiple">독서
				<input type="checkbox" name="hobby" value="요리" multiple="multiple">요리
				<input type="checkbox" name="hobby" value="운동" multiple="multiple">운동
				<input type="checkbox" name="hobby" value="취침" multiple="multiple">취침
				<input type="checkbox" name="hobby" value="없음" multiple="multiple">없음
			</td>
		</tr>
		<tr>
			<th>성별</th>
			<td>
				<input type="radio" name="gender" value="w" checked="checked">여자
				<input type="radio" name="gender" value="m">남자
			</td>
		</tr>
		<tr>
			<th>이메일</th>			
			<td><input type="email" name="email" class="email"></td>
		</tr>
		<tr>
			<th>메일수신</th>
			<td>
				<select name=mailSend class="mailSend" multiple="multiple" size="3">
					<option value="광고">광고</option>
					<option value="배송">배송</option>
					<option value="공지">공지</option>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="2"> </td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" class="joinBtn_style" value="가입하기">
				<input type="reset" class="joinBtn_style" value="다시하기">
				<input type="button" class="joinBtn_style" value="로그인" onclick="location.href='login.jsp'">
			</td>
		</tr>
	</table>
</form>
</div>
<%@include file="footer.jsp" %>
</body>
</html>