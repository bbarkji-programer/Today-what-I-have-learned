<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.io.IOException"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
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
	String path = request.getRealPath("fileUpFolder");  // 실제 파일이 저장되는 서버경로
	int maxSize = 1024*1024*10; // 업로드 최대 용량은 10MB
	String filename = ""; // 올릴 파일 이름 초기화
	String originalFilename = ""; 
	try{
		//▼ (서버에)파일저장
		MultipartRequest mRequest = new MultipartRequest(request, path, maxSize,"utf-8", new DefaultFileRenamePolicy()); // 같은 이름이 있는 경우 바꿔준다. 1.jpg -> 11.jpg
		//▼ 파라미터 이름 가져오기
		Enumeration<String> paramNames = mRequest.getFileNames(); // 파라미터 이름은 여러개일 수 있으니까
		while(paramNames.hasMoreElements()){
			String param = paramNames.nextElement(); // param = "file"
			filename = mRequest.getFilesystemName(param); // param(여기서는 "file")이라는 파라미터로 올라온 파일이름
			originalFilename = mRequest.getOriginalFileName(param); // 오리지널 파일이름
			System.out.println("파라미터 이름 : "+param+", 서버에 저장된 파일이름: "+filename+", 사용자가 첨부한 오리지널 이름: "+originalFilename);
		}
	}catch(IOException e){
		System.out.println(e.getMessage());
	}
	// 서버에 업로드 하자마자 소스폴더로 file copy - 사용자에게 간 이후에는 필요없음(소스가 바뀔 일이 없으니)
	InputStream is = null;
	OutputStream os = null;
	try{
		File serverFile = new File(path+"/"+filename); // path/filename 경로에 대한 파일 객체 생성
		if(serverFile.exists()){ // 파일 객체가 존재하면,
			is = new FileInputStream(serverFile); // serverFile 경로의 파일을 연다
			os = new FileOutputStream("D:/mega_IT/source/6_jsp/ch14_fileUp/WebContent/fileUpFolder/"+filename); // 다운로드할 파일의 경로를 연다.(만약에 없으면 만들음)
			byte[] bs = new byte[(int)serverFile.length()]; // 읽어올 파일의 길이(크기)
			while(true){
				int nReadCnt = is.read(bs); // bs(읽어올 파일의 길이)만큼 읽어온다. nReadCnt : 읽어온 바이트 수
				if(nReadCnt==-1){ // 더이상 읽어올 파일이 없으면
					break; 
				}
				os.write(bs,0, nReadCnt); // 0번방부터 nReadCnt 방까지 써라
			}
		}
	}catch(IOException e){
		System.out.println(e.getMessage());
	}finally{
		try{
			if(os!=null) os.close();
			if(is!=null) is.close();
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
%>
<h1>사용자가 첨부한 오리지널 파일이름 : <%=originalFilename %></h1>
<h1>서버에 저장된 파일이름: <%=path %>/<%=filename %></h1>
<img src="fileUpFolder/<%=filename %>" alt="첨부안됨">
</body>
</html>