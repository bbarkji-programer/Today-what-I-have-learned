<%@page import="com.tj.dto.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tj.dao.BoardDao"%>
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
<h1>
	0. 에러페이지 테스트 : 
	<a href="xx.jsp">XX</a>
</h1>
<%
	BoardDao bDao = BoardDao.getInstance();

	out.print("<hr><h1>1. DB 글 개수 : "+bDao.getBoardTotalCnt()+"</h1>");
	out.print("<hr><h1>2. DB 글 목록 :</h1>");
	ArrayList<BoardDto> dtos = bDao.listBoard();
	for(int idx = 0; idx<dtos.size() ; idx++){ // 확장 구문 쓰면 더 편함!
		out.println(dtos.get(idx).toString()+"<br>");
	}
	out.print("<hr><h1>3. DB 글 쓰기 :</h1>");
	BoardDto dto = new BoardDto(2, "글쓴이", "제목", "내용", "이메일", 0, "111", 0, 0, 0,"111.11.11.1", null);
	int result = bDao.insertBoard(dto);
	out.println(result==BoardDao.SUCCESS? "글쓰기 성공 " : "글쓰기 실패");
	out.print("<hr><h1>4. 글 번호로 글 가져오기 : </h1>"+bDao.getBoardOneLine("3"));
	out.print("<hr><h1>5. Hit 수 하나  올리기 : </h1>");
	bDao.hitUp(1);
	out.println("<hr><h1>5. 글 수정</h1>");
	dto = bDao.getBoardOneLine("5"); // 글을 하나 가져와서
	dto.setWriter("XXXXXXX");
	dto.setSubject("XXXXXX");
	dto.setContent("XXXXXXX");
	dto.setIp("0.0.0.0");
	result = bDao.updateBoard(dto);
	out.println(result==BoardDao.SUCCESS? dto.getNum()+"번 글 수정 성공":"수정실패");
	out.println("<hr><h1>6. 글 삭제</h1>");
	result = bDao.deleteBoard(2, "111");
	out.println(result==BoardDao.SUCCESS? "삭제성공" : "삭제실패");
%>


</body>
</html>