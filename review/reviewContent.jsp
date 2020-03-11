<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href='${conPath }/css/reviewContent.css' rel='stylesheet'>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
$(document).ready(function(){
	
});
</script>
</head>
<body>
<jsp:include page="../main/header.jsp"/>
	<div id="reviewContent_wrap">
		<div id="reviewContent">
			<div id="product">
				<table>
					<tr>
						<th id="productImg">
							<div class="productImg">
								<c:set var="dto" value="${reviewContent }"></c:set>
								<a href="${conPath }/productContent.do?pId=${dto.pId}">										
									<img src="${conPath }/productImg/${dto.pImage1}" alt="상품사진">							
								</a>
							</div>
						</th>
						<td id="productInfo">
							${dto.pName }
							<button class="btn" onclick="location.href='${conPath }/productContent.do?pId=${dto.pId}'">상품 상세보기</button>
						</td>
					</tr>							
				</table>
			</div>
			<div id="review">
				<table>
					<tr>
						<td class="rId">
							no.
						</td>
						<td class="rTitle">
							Title
						</td>
						<td class="mId">
							Writer
						</td>
						<td class="rIp">
							Ip
						</td>
						<td class="rDate">
							Date
						</td>
						<td class="rHit">
							hit
						</td>
					</tr>
					<tr>
						<td class="rId">
							${dto.rId }
						</td>
						<td class="rTitle">
							${dto.rTitle }
						</td>
						<td class="mId">
							${dto.mId }
						</td>
						<td class="rIp">
							${dto.rIp }
						</td>
						<td class="rDate">
							<fmt:formatDate value="${dto.rDate }" pattern="YY-MM-dd(E)"/>
						</td>
						<td class="rHit">
							${dto.rHit }
						</td>
					</tr>
					<tr>
						<td class="rContent" colspan="6">
							${dto.rContent }
						</td>
					</tr>
				</table>
			</div>
		</div>
		<div id="file">
			<table id="fileTable">
				<tr>
					<td	class="rFileName">
						첨부파일(1)
					</td>
					<td	class="rFile">
						<p>${dto.rFile1 }</p>
					</td>
				</tr>
				<tr>
					<c:if test="${not empty dto.rFile2 }">						
						<td	class="rFileName">
							첨부파일(2)
						</td>
						<td	class="rFile">
							<p>${dto.rFile2 }</p>
						</td>
					</c:if>
				</tr>
			</table>
		</div>
	</div>
<jsp:include page="../main/footer.jsp"/>
</body>
</html>