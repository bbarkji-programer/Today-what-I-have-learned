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
	<table>
		<caption>
			회원정보
		</caption>
		<tr>
			<th>
				ID
			</th>
			<th>
				PW
			</th>
			<th>
				NAME
			</th>
			<th>
				E-MAIL
			</th>
			<th>
				BIRTH
			</th>
			<th>
				REGISTER DAY
			</th>
			<th>
				ADDRESS
			</th>
		</tr>
		<c:if test="${members.size() eq 0 }">
		<tr>
			<td colspan="7">
				가입한 회원이 없습니다.
			</td>
		</tr>
		</c:if>
		<c:if test="${members.size()!=0 }">
			<c:forEach var="member" items="${members }">
				<tr>
					<td>
						${member.id }
					</td>
					<td>
						<c:forEach begin="1" end="${member.pw.length() }">
							*
						</c:forEach>
					</td>
					<td>
						${member.name }
					</td>
					<td>
						${member.email }
					</td>
					<td>
						<fmt:formatDate value="${member.birth }" type="date" pattern="MM월 dd일"/>						
					</td>
					<td>
						<fmt:formatDate value="${member.rdate }" type="date" pattern="yy년 MM월 dd일 (E)"/>
						
					</td>
					<td>
						${member.address }
					</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
</body>
</html>