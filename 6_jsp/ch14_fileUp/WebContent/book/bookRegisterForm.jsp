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
<form action="bookRegisterPro.jsp" method="post" enctype="multipart/form-data"> <!-- enctype="데이터인코딩타입" 서버로 제출될 때 데이터가 인코딩 되는 방식 -->
	<table>
		<caption>
			책 등록
		</caption>
		<tr>
			<th>
				책 제목
			</th>
			<td>
				<input type="text" name="book_title" maxlength="30" required="required">
			</td>
		</tr>
		<tr>
			<th>
				책 가격
			</th>
			<td>
				<input type="number" name="book_price" min="0" max="9999999" required="required">
			</td>
		</tr>
		<tr>
			<th>
				책 이미지1
			</th>
			<td>
				<input type="file" name="book_image1">
			</td>
		</tr>
				<tr>
			<th>
				책 이미지2
			</th>
			<td>
				<input type="file" name="book_image2">
			</td>
		</tr>
		<tr>
			<th>
				책 소개
			</th>
			<td>
				<textarea rows="5" cols="20" name="book_content"></textarea>
			</td>
		</tr>
		<tr>
			<th>
				할인율
			</th>
			<td>
				<input type="number" name="book_discount" min="0" max="100" value="0" required="required">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="책 등록" class="btn">
			</td>
		</tr>
	</table>
</form>
</body>
</html>