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
<div id="all">
<jsp:include page="header.jsp"/>
<section>
	<div id = "container">
		<ul>
			<li>
				<div class="sale">
					<a href="sale페이지">	
						SALE
					</a>
				</div>		
			</li>
			<li>
				<div class="best">
					<a href="best페이지">
						BEST
					</a>
				</div>
			</li>
			<li>
				<div class="new">
					<a href="new페이지">
						NEW
					</a>
				</div>
			</li>
		</ul>
	</div>
</section>
<jsp:include page="footer.jsp"/>
</div>
</body>
</html>