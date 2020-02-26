<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
	<form action="${conPath }/Ex11_empList">
		이름 <input type="text" name="sth1" value="${fn:toUpperCase(param.sth1) }">
		직책 <input type="text" name="sth2" value="${fn:toUpperCase(param.sth2) }">
		<input type="submit" value="검색">
	</form>
	<br>
	<table>
		<caption>
			EMP
		</caption>
		<tr>
			<th>
				사번
			</th>
			<th>
				이름
			</th>
			<th>
				직책
			</th>
			<th>
				상사
			</th>
			<th>
				입사
			</th>
			<th>
				급여
			</th>
			<th>
				상여
			</th>
			<th>
				부서
			</th>
		</tr>
		<c:if test="${emps.size() eq 0 }">
		<!-- 어레이리스트에 담긴게 없는 경우 -->
		<tr>
			<td colspan="8">
				사원이 없습니다.
			</td>
		</tr>
		</c:if>
		<c:if test="${emps.size() != 0 }">
			<c:forEach var="emp" items="${emps }">
			<tr>
				<td>
					${emp.empno }
				</td>
				<td>
					${emp.ename }
				</td>
				<td>
					${emp.job }
				</td>
				<td>
					${emp.mgr }
				</td>
				<td>
					<fmt:formatDate value="${emp.hiredate }" type="date" dateStyle="full"/>
					
				</td>
				<td>
					<fmt:formatNumber value="${emp.sal }" groupingUsed="true"/>					
				</td>
				<td>
					${emp.comm }
				</td>
				<td>
					${emp.deptno }
				</td>
			</tr>
			</c:forEach>
		</c:if>
	</table>
</body>
</html>