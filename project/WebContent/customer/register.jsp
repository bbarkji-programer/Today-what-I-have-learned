<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/style.css" rel="stylesheet">
</head>
<body>
<div id="all">
<jsp:include page="../main/header.jsp"/>
	<div id=register_wrap>
		<div class="title">
			REGISTER
		</div>
		<form action="registerResult.jsp" method="post" id="register">
			<div class="register_left">
				<div class="terms_wrap">
					<p class="title">
						Terms & Conditions
					</p>
					<div class="terms">
						<textarea name="" id="">
제1조(목적)

이 약관은 빡지 회사(전자상거래 사업자)가 운영하는 빡지 사이버 몰(이하 "몰"이라 한다)에서 제공하는 인터넷 관련 서비스(이하 "서비스"라 한다)를 이용함에 있어 사이버 몰과 이용자의 권리.의무 및 책임사항을 규정함을 목적으로 합니다.

제2조(정의)

이 약관은 빡지 회사(전자상거래 사업자)가 운영하는 빡지 사이버 몰(이하 "몰"이라 한다)에서 제공하는 인터넷 관련 서비스(이하 "서비스"라 한다)를 이용함에 있어 사이버 몰과 이용자의 권리.의무 및 책임사항을 규정함을 목적으로 합니다.

제3조(정의)

이 약관은 빡지 회사(전자상거래 사업자)가 운영하는 빡지 사이버 몰(이하 "몰"이라 한다)에서 제공하는 인터넷 관련 서비스(이하 "서비스"라 한다)를 이용함에 있어 사이버 몰과 이용자의 권리.의무 및 책임사항을 규정함을 목적으로 합니다.

제4조(정의)

이 약관은 빡지 회사(전자상거래 사업자)가 운영하는 빡지 사이버 몰(이하 "몰"이라 한다)에서 제공하는 인터넷 관련 서비스(이하 "서비스"라 한다)를 이용함에 있어 사이버 몰과 이용자의 권리.의무 및 책임사항을 규정함을 목적으로 합니다.

제5조(정의)

이 약관은 빡지 회사(전자상거래 사업자)가 운영하는 빡지 사이버 몰(이하 "몰"이라 한다)에서 제공하는 인터넷 관련 서비스(이하 "서비스"라 한다)를 이용함에 있어 사이버 몰과 이용자의 권리.의무 및 책임사항을 규정함을 목적으로 합니다.
						</textarea>
					</div>
					<div class="agree">
						<span>Do you agree?</span>
						<input type="radio" name="agree" value="y"> 
						<span>agree</span>
					</div>
				</div>
			</div>
			<div class="register_right">
					<table>
						<tr>
							<td>
								ID
							</td>
							<td>
								<input type="text" name="id" required="required" placeholder="4글자 이상">
							</td>
						</tr>
						<tr>
							<td>
								Password
							</td>
							<td>
								<input type="password" name="pw" required="required" placeholder="영문+특수문자 7자 이상">
							</td>
						</tr>
						<tr>	
							<td>
								Confirm Password
							</td>
							<td>
								<input type="password" name="pwChk" required="required">
							</td>
						</tr>
						<tr>
							<td>
								Name
							</td>
							<td>
								<input type="text" name="name" required="required">
							</td>
						</tr>
						<tr>
							<td>
								Email Address
							</td>
							<td>
								<input type="email" name="email" required="required">
							</td>
						</tr>
						<tr>
							<td>
								Mobile
							</td>
							<td>
								<select name="mobile1" class="mobile">
									<option> </option>
									<option>010</option>
									<option>011</option>
									<option>016</option>
									<option>017</option>
									<option>018</option>
									<option>019</option>
								</select>
								<span>-</span>
								<input type="text" name="mobile2" class="mobile" required="required">
								<span>-</span>
								<input type="text" name="mobile3" class="mobile" required="required">
							</td>
						</tr>
						<tr>
							<td>
								Address
							</td>
							<td>
								<input type="text" name="address" required="required" placeholder="우편번호, 도로명주소">
							</td>
						</tr>
						<tr>
							<td>
								Anniversary
							</td>
							<td>
								<input type="date" name="anniversary">
							</td>
						</tr>
					</table>
			</div>
			<div class="create">
				<input type="submit" value="CREATE">
			</div>
		</form>			
	</div>
<jsp:include page="../main/footer.jsp"/>
</div> 
</body>
</html>