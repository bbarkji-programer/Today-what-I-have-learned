<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/style.css" rel="stylesheet">
</head>
<body>
<header>
	<div id="header_wrap">
		<a href="<%=conPath %>/main/main.jsp" class="header_logo">
			BBARKJI
		</a>		
		<div class="header_right">
			<ul>
				<li>
					<form action="#" method="get" class="header_search">
						<input type="text" name="header_search" size="15" placeholder="금주 베스트">
						<input type="button" name="search" value="Search">
						<div class="line"> </div>
					</form>
				</li>
				<li>
					<form action="../customer/signin.jsp" method="get">
						<input type="submit" name="singin" value="Sign in">
					</form>
				</li>
				<li>
					/
				</li>
				<li>
					<form action="../customer/register.jsp" method="get">
						<input type="submit" name="register" value="Register">
					</form>
				</li>
				<li>
					<form action="order.jsp" method="get">
						<input type="submit" name="order" value="Order">
					</form>
				</li>
				<li>
					<form action="cart.jsp" method="get">
						<input type="submit" name="cart" value="Cart">
					</form>
				</li>
			</ul>
		</div>
		<div class="gnb">
			<ul>
				<li>
					<a href="세일페이지">
						SALE
					</a>
				</li>
				<li>
					<a href="베스트페이지">
						BEST
					</a>
				</li>
				<li>
					<a href="세일페이지">
						NEW
					</a>
				</li>
				<li>
					<a href="세일페이지">
						REVIEW
					</a>
				</li>
				<li>
					<a href="세일페이지">
						FAQ
					</a>
				</li>
			</ul>
		</div>
	</div>
</header>
</body>
</html>