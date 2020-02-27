<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${conPath}/css/style.css" rel="stylesheet">
</head>
<body>
	<form action="${conPath }/modify.do" method="post"> <!-- 본문 내용이 250자 추가 할 수 있으므로. 파일 첨부인경우 multipart 추가 -->
		<input type="hidden" name="bid" value="${modify_view.bid }">
		<input type="hidden" name="pageNum" value="${param.pageNum }">
		<table>
			<caption>
				${param.bid } 글 수정
			</caption>
			<tr>
				<th>
					작성자
				</th>
				<td>
					<input type="text" name="bname" required="required"
						value="${modify_view.bname }">
				</td>
			</tr>
			<tr>
				<th>
					글 제목	
				</th>
				<td>
					<input type="text" name="btitle" required="required"
						value="${modify_view.btitle }">
 				</td>
			</tr>
			<tr>
				<th>
					본문 내용
				</th>
				<td>
					<textarea rows="5" cols="20" name="bcontent">${modify_view.bcontent }</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="글 수정" class="btn">
					<input type="reset" value="취소" class="btn">
					<input type="button" value="목록으로" class="btn" onclick="history.back()">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>