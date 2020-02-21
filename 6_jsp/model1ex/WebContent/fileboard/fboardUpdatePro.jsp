<%@page import="com.tj.model1ex.dao.FileboardDao"%>
<%@page import="com.tj.model1ex.dto.FileboardDto"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="com.tj.model1ex.dto.CustomerDto"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
<%
	//파일 첨부용
	String path = request.getRealPath("fileboardUpload"); // 톰캣 저장 서버경로
	int maxSize = 1024*1024*10;
	MultipartRequest mRequest=null;
	String ffilename = "";
	String originalFilename = "";
		try{
			//서버에 파일 저장
			mRequest = new MultipartRequest(request,path, maxSize, "utf-8", new DefaultFileRenamePolicy());
			//파라미터 이름 가져오기
			Enumeration<String> params = mRequest.getFileNames();
			String param = params.nextElement();
			ffilename = mRequest.getFilesystemName(param);
			originalFilename = mRequest.getOriginalFileName(param);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		// 서버 업로드 후 소스 폴더로 파일 카피하기
		if(ffilename!=null){
			InputStream is = null;
			OutputStream os = null;
			try{
				File serverFile = new File(path+"/"+ffilename);
				if(serverFile.exists()){
					is = new FileInputStream(serverFile);
					os = new FileOutputStream("D:/mega_IT/source/6_jsp/model1ex/WebContent/fileboardUpload/"+ffilename);
					byte[] bs = new byte[(int)serverFile.length()];
					while(true){
						int nReadCnt = is.read(bs);
						if(nReadCnt == -1) break;
						os.write(bs, 0, nReadCnt);
					}
				}
			}catch(Exception e){
				System.out.println(e.getMessage());
			}finally{
				if(os!=null) os.close();
				if(is!=null) is.close();
			}
		}
	// 글 제목, 글 내용, 파일이름, 비밀번호 가져오기
	String pageNum = mRequest.getParameter("pageNum"); // 페이징처리용
	int fnum = Integer.parseInt(mRequest.getParameter("fnum"));
	String cId = null, cname=null, cemail=null;
	CustomerDto customer = (CustomerDto)session.getAttribute("customer");
	if(customer!=null) {
		cId = customer.getCid();
		cname = customer.getCname();
		cemail = customer.getCemail();
	}	
	String fsubject = mRequest.getParameter("fsubject");
	String fcontent = mRequest.getParameter("fcontent");
	String dbfilename = mRequest.getParameter("dbfilename");
	if(ffilename==null) ffilename = dbfilename;
	String fpw = mRequest.getParameter("fpw");
	String fip = request.getRemoteAddr();
	FileboardDto dto = new FileboardDto(fnum, null, fsubject, fcontent, ffilename, fpw, 0, 0, 0, 0, fip, null, null, null);
	FileboardDao dao = FileboardDao.getInstance();
	int result = dao.modify(dto);
	if(result==FileboardDao.SUCCESS){%>
	<script>
		alert('글 수정 완료');
		location.href='fboardList.jsp?pageNum=<%=pageNum%>';
	</script>
	<%}else{ %>
	<script>
		alert('글수정 실패');
		history.back();
	</script>		
	<%} %>
</body>
</html>