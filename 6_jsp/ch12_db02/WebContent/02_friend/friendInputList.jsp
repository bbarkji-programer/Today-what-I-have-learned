<%@page import="com.tj.dto.FriendDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tj.dao.FriendDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/style.css" rel="stylesheet">
</head>
	<%  String result = request.getParameter("result");
		if(result!=null && result.equals("success")){%>
		<script>
			alert('친구 추가 성공');
		</script>
		<%}else if(result!=null && result.equals("fail")){%>
		<script>
		    alert('친구 추가 실패');
	    </script>
	<%}%>
	<script>
		function search(){
			var name = frm.name.value;
			var phone = frm.phone.value;
			location.href = 'friendInputList.jsp?msg=search&name='+name+'&phone='+phone;
		}
	</script>
<body>
<form action="friendInputListPro.jsp" method="get" name="frm">
	<p>
		친구이름 <input type="text" name="name" required="required" size="4"
				value="<%
					String name = request.getParameter("name");
					out.print(name!=null ? name : "");
				%>">
		전화<input type="text" name="phone" required="required" size="10"
				value="<%
					String phone = request.getParameter("phone");
					out.print(phone!=null ? phone : "");
				%>"> <!-- dto의 속성면수와 name 값이 같아야함  -->
		<input type="submit" value="추가">
		<input type="button" value="검색" onclick="search()">
	</p>
</form>
<table>
	<tr>
		<th>
			NO
		</th>
		<th>
			NAME
		</th>
		<th>
			PHONE
		</th>
	</tr>
<%
	FriendDao friendDao = FriendDao.getInstance();
	ArrayList<FriendDto> dtos;
	String msg = request.getParameter("msg");
	if(msg!=null){
		dtos = friendDao.selectNamePhone(name,phone);
		for(int idx=0; idx<dtos.size();idx++){%>
			<tr>
				<td>
					<%=dtos.get(idx).getNo() %>
				</td>
				<td>
					<%=dtos.get(idx).getName() %>
				</td>
				<td>
					<%=dtos.get(idx).getPhone() %>
				</td>		
			</tr>
		<%}
	}else{
		dtos = friendDao.selectAll();
		for(FriendDto dto : dtos){%>
			<tr>
				<td>
					<%=dto.getNo() %>
				</td>
				<td>
					<%=dto.getName() %>
				</td>
				<td>
					<%=dto.getPhone() %>
				</td>		
			</tr>
			<%}
	}%>
</table>
</body>
</html>