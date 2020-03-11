<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Product Content</title>
  <link href='${conPath }/css/productContent.css' rel='stylesheet'>
</head>
<body>
<jsp:include page="../main/header.jsp"/>
	<div id="productContent_wrap">
		<div id="productImage">
			<div class="pImage">
				<img src="${conPath}/productImg/${dto.pImage1 }" alt="상품사진1">		
			</div>
			<div class="pImage">
				<c:if test="${ not empty dto.pImage2 }">
					<img src="${conPath}/productImg/${dto.pImage2 }" alt="상품사진2">
				</c:if>
				<c:if test="${empty dto.pImage2  }">					
				</c:if>
			</div>
		</div>
  		<div id="product_info">
			<div id="accordion">
				<h3>${dto.pName }</h3>
				<div>
					<p>
						${dto.pContent }
					</p>
				</div>
				<h3>Exchange / Return</h3>
				<div>
					<p>
						${dto.pPolicy1 }
					</p>
				</div>
				<h3>Delivery</h3>
				<div>
					<p>
						${dto.pPolicy2 }
					</p>
				</div>
			</div>
			<div id="productPrice">
				<form action="${conPath }/cartInsert.do">
				<input type="hidden" value="${dto.pId }">
				<input type="hidden" value="${mId }"> <!-- 세션 값 받아옴 -->
				<table>
					<tr>
						<th>
							판매가격
						</th>
						<td>
							<fmt:formatNumber value="${dto.pPrice }" pattern="#,###,###"/>
						</td>
					</tr>
					<c:if test="${dto.pDiscount != 0 }">
						<tr>
							<th>
								할인가격
							</th>
							<td>
								<c:set var="discountedPrice" value="${dto.pPrice*(1-(dto.pDiscount/100)) }"/>
								<fmt:formatNumber value="${discountedPrice }" pattern="#,###,###"/> 
								<span>
									(${dto.pDiscount }%할인)
								</span>
							</td>
						</tr>
					</c:if>
					<tr>
						<th>
							수량
						</th>
						<td>
							<select name="cAmount">
								<option value='1'>1</option>
								<option value='2'>2</option>
								<option value='3'>3</option>
								<option value='4'>4</option>
								<option value='5'>5</option>
							</select>
						</td>
					</tr>
					<tr>
						
						<th colspan="2">
							<c:if test="${not empty member }">
								<%-- <input type="button" value="BUY NOW" onclick="location.href='${conPath }/ordersView.do'"> --%>
								<input type="submit" value="Add to Cart" class="btn">
								<input type="button" value="Back to List" class="btn" onclick="location.href='${conPath}/productList.do?pageNum=${param.pageNum }'">
							</c:if>
							<c:if test="${empty member }">
								<input type="button" value="상품 구매는 로그인 후 가능합니다." class="guestBtn"
									onclick="location.href='${conPath}/memberLoginView.do'">
							</c:if>
						</th>
					</tr>
				</table>
				</form>
			</div>
		</div>
	</div>
<jsp:include page="../main/footer.jsp"/>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
  $( function() {
    $( "#accordion" ).accordion({
      	collapsible: true
    });  
    $("h3").click(function(){
    	$(this).css("background-color","white").css("color","black");
    });
  });
  </script>
</body>
</html>