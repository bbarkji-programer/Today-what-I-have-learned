<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
*{
text-align:center;
}
</style>
<script>
	function chk(){
		var su = document.getElementsByClass('su');
		if(su[0].value > su[1].value){
			alert("작은 수를 앞에, 큰 수를 뒤에 적어주세요.");
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<form action="07_su2ququdanout.jsp" method="get">
		<p> 단수 :
			<input type="text" name="su1" class="su" required="required">
			단 ~ 
			<input type="text" name="su2" class="su" required="required">
			단까지
		</p>
		<p>
			<input type="submit" value="구구단출력" onsubmit="return chk()">
		</p>
	</form> 
</body>
</html>