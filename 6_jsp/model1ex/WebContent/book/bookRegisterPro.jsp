<%@page import="com.tj.model1ex.dao.BookDao"%>
<%@page import="com.tj.model1ex.dto.BookDto"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.io.IOException"%>
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
	// 파일 받기
	request.setCharacterEncoding("utf-8"); // 파라미터 값 한글 입력을 고려
	// 1. path 설정
	String path = request.getRealPath("bookImg"); // 파일을 받을 path 설정 
	int maxSize = 1024*1024*5; // 최대 업로드 사이즈 설정
	String[] image = {"",""}; // 이미지가 최대 2개 예정이니까 2개 방을 만듦.
	MultipartRequest mRequest = null; // 밑에서 써야 하니까 여기에 초기화
	
	try{
		// (이미지)파일 서버에 올리고 파일 이름 받기(multipartRequest 객체이용)
		mRequest = new MultipartRequest(request,path,maxSize,"utf-8",new DefaultFileRenamePolicy()); // try catch를 해줘야 하는 애다.
		
		Enumeration<String> paramNames = mRequest.getFileNames(); // 파라미터 이름들(book_image1, book_image2)
		int idx = 0;
		while(paramNames.hasMoreElements()){
			String param = paramNames.nextElement(); // 첫 번째 파라미터 이름값
			image[idx] = mRequest.getFilesystemName(param);
			//out.println(idx+"번 째 처리한 파라미터 이름 : "+param+" / 파일이름 : "+image[idx]+"<br>");
			idx ++;
		}
	}catch(IOException e){
		System.out.println("첫번째 예외 "+e.getMessage());
	}
	// 서버에 올린 (이미지)파일을 소스 폴더에 복사
	for(String imgfile : image){
		if(imgfile!=null){
			InputStream is = null;
			OutputStream os = null;
			File serverFile = new File(path+"/"+imgfile); // 서버에 있는 파일을 담을 serverFile
			if(serverFile.exists()){
				try{
					is = new FileInputStream(serverFile); 
					os = new FileOutputStream("D:/mega_IT/source/6_jsp/model1ex/WebContent/bookImg/"+imgfile);
					byte[] bs = new byte[(int)serverFile.length()]; // 배열로 serverFile을 끝까지(length만큼 ex:500byte)읽어서 한 번에 받아온다. 
					while(true){
						int nReadbyte = is.read(bs);
						if(nReadbyte==-1) break; // 파일을 읽어온 값이 -1이 되면  = 끝까지 읽어와서 더 읽어올 값이 없으면 -> break;
						os.write(bs, 0, nReadbyte); // os 객체에 쓴다. 
					}
				}catch(Exception e){
					System.out.println("두번째 예외 "+e.getMessage());
				}finally{
					if(os!=null) os.close();
					if(is!=null) is.close();
				}
			}
		}
	}
	// 책 제목, 책 설명, 가격, 할인율 등을 getParameter("")로 파라미터 값 받아 BookDto 객체 만든당
	String book_title = mRequest.getParameter("book_title");
	int book_price = Integer.parseInt(mRequest.getParameter("book_price"));
	String book_image1 = image[1]!=null? image[1]:"NOTHING.JPG";
	String book_image2 = image[0]!=null? image[0]:"NOTHING.JPG";
	String book_content = mRequest.getParameter("book_content");
	int book_discount = Integer.parseInt(mRequest.getParameter("book_discount"));
	String ip = request.getRemoteAddr(); // ip는 파라미터로 받는게 아니니까 구냥 request 가능	
	BookDto book = new BookDto(0,book_title, book_price, book_image1, book_image2, book_content, book_discount, null);
	// DB에 insertBook
	BookDao bDao = BookDao.getInstance();
	int result = bDao.insertBook(book);
	if(result==BookDao.SUCCESS){
		out.print("<h2>책 등록 성공</h2>");		
	}else{
		out.println("<h2>책 등록 실패</h2>");
	}
	response.sendRedirect("../book/bookList.jsp");
%>
</body>
</html>