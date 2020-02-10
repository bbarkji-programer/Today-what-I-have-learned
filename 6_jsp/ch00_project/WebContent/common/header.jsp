<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath %>/css/style.css" rel="stylesheet">
</head>
<body>
<div id="header">
	<div id="userMenu">
		<ul class="list_menu">
			<li class="menu none_sub menu_join">
				<a href="join.jsp" class="link_menu">회원가입</a>
				::after
			</li>
			<li class="menu none_sub">
				<a href="login.jsp" class="link_menu">로그인</a>
				::after
			</li>
			<li class="menu">
				::before
				<a href="고객페이지주소" class="link_menu">고객센터</a>
				<ul class="sub">
					<li>
						<a href="공지사항페이지주소" class="link_menu">공지사항</a>
					</li>
					<li>
						<a href="자주하는질문페이지주소" class="link_menu">자주하는질문</a>
					</li>
				</ul>
				::after
			</li>
		</ul>
		::after
	</div>
	<div id="headerLogo" class="wrapper">
		<h1 class="logo">
			<a href="/">
				<span id="gnbLogoContainer"></span>
				<img src="로고이미지주소" alt="로고" style="display: block;">			
			</a>
		</h1>
	</div>
	<div id="gnb">
		<h2 class="screen_out">메뉴</h2>
		<div id="gnbMenu" class="gnb_wrap">
			<div class="inner_gnb">
				<div class="gnb_main">
					<ul class="gnb">
						<li class="menu1">
							<a href="#">
								<span class="ico"></span>
								<span class="txt">전체 카테고리</span>
							</a>
						</li>
						<li>
							<a href="신상품페이지주소">
								<span class="txt">신상품</span>
							</a>
						</li>
						<li>
							<a href="베스트페이지주소">
								<span class="txt">베스트</span>
							</a>
						</li>
						<li>
							<a href="알뜰쇼핑페이지주소">
								<span class="txt">알뜰쇼핑</span>
							</a>
						</li>
						<li>
							<a href="이벤트페이지주소">
								<span class="txt">이벤트</span>
							</a>
						</li>
					</ul>
					<div id="side_search" class="gnb_search">
						<form action="검색후화면주소" onsubmit="return chkForm(this)">
							<input type="text" name="sword" class="inp_search" required="required" label="검색어">
							<input type="image" src="https://res.kurly.com/pc/service/common/1908/ico_search_x2.png" class="btn_search">
						</form>
					</div>
					<!-- 카트에 물건을 넣으면 숫자가 나타나게 -->
					<div class="cart_count"> 
						<div class="inner_cartcount">
							<a href="장바구니주소" class="btn_cart">
								<img src="https://res.kurly.com/pc/ico/1908/ico_cart_x2_v2.png" alt="장바구니">
								<span id="cart_item_count" class="num realtime_cartcount" style="display:inline;">1</span>
							</a>
						</div>
						<div id="addMsgCart" class="msg_cart">
							<span class="point"></span>
							<div class="inner_msgcart">
								<p class="desc">
									<span class="tit"></span>
									<span class="txt">장바구니에 담겼습니다.</span>
								</p>
							</div>
						</div>
					</div>
				</div>
				<div class="gnb_sub" style="dispaly:none; width:219px;">
					<div class="inner_sub">
						<ul data-default="219" data-min="219" data-max="731" class="gnb_menu">
							<li>
								<a class="menu">
									<span class="tit">
										<span class="txt">팔것 대분류1</span>
									</span>
								</a>
								<ul class="sub_menu">
									<li>
										<a class="sub">
										 	팔것 대분류 1의 1
										</a>
									</li>
									<li>
										<a class="sub">
										 	팔것 대분류 1의 2
										</a>
									</li>
									<li>
										<a class="sub">
										 	팔것 대분류 1의 3
										</a>
									</li>
								</ul>
							</li>
							<li>
								<a class="menu">
									<span class="tit">
										<span class="txt">팔것 대분류2</span>
									</span>
								</a>
								<ul class="sub_menu">
									<li>
										<a class="sub">
										 	팔것 대분류 2의 1
										</a>
									</li>
									<li>
										<a class="sub">
										 	팔것 대분류 2의 2
										</a>
									</li>
									<li>
										<a class="sub">
										 	팔것 대분류 2의 3
										</a>
									</li>
								</ul>
							</li>
							<li>
								<a class="menu">
									<span class="tit">
										<span class="txt">팔것 대분류3</span>
									</span>
								</a>
								<ul class="sub_menu">
									<li>
										<a class="sub">
										 	팔것 대분류 3의 1
										</a>
									</li>
									<li>
										<a class="sub">
										 	팔것 대분류 3의 2
										</a>
									</li>
									<li>
										<a class="sub">
										 	팔것 대분류 3의 3
										</a>
									</li>
								</ul>
							</li>
							<li>
								<a class="menu">
									<span class="tit">
										<span class="txt">팔것 대분류4</span>
									</span>
								</a>
								<ul class="sub_menu">
									<li>
										<a class="sub">
										 	팔것 대분류 4의 1
										</a>
									</li>
									<li>
										<a class="sub">
										 	팔것 대분류 4의 2
										</a>
									</li>
									<li>
										<a class="sub">
										 	팔것 대분류 4의 3
										</a>
									</li>
								</ul>
							</li>
							<li>
								<a class="menu">
									<span class="tit">
										<span class="txt">팔것 대분류5</span>
									</span>
								</a>
								<ul class="sub_menu">
									<li>
										<a class="sub">
										 	팔것 대분류 5의 1
										</a>
									</li>
									<li>
										<a class="sub">
										 	팔것 대분류 5의 2
										</a>
									</li>
									<li>
										<a class="sub">
										 	팔것 대분류 5의 3
										</a>
									</li>
								</ul>
							</li>
						</ul>
					</div>
				</div>
			</div>
			::after
		</div>
	</div>
</div>
</body>
</html>