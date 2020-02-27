package com.tj.ex.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.tj.ex.dao.MemberDao;
import com.tj.ex.dto.MemberDto;

public class JoinService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String path = request.getRealPath("memberPhoto");
		int maxSize = 1024*1024;
		String mPhoto = "";
		try {
			// mRequest 객체 생성 후 파일 이름 받아오기
			MultipartRequest mRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());			
			Enumeration<String> params = mRequest.getFileNames(); // 파일이름 가져옴. 여기서는 파일이 1개 뿐이라서 굳이 while 문을 돌리지는 않지만 그래도 배열로 받는다.
			//while(params.hasMoreElements()) {
				String param = params.nextElement(); // mPhoto
			//}
				mPhoto = mRequest.getFilesystemName(param);
				mPhoto = (mPhoto==null)? "NOIMG.JPG" : mPhoto; // 파일 이름 받아오기 끝
			
			// 파라미터 값 다 받아와서 DB에 넣기
			String mId = mRequest.getParameter("mId");
			String mPw = mRequest.getParameter("mPw");
			String mName = mRequest.getParameter("mName");
			String mEmail = mRequest.getParameter("mEmail");
			String mBirthStr = mRequest.getParameter("mBirth");
			Date mBirth = null;
			if(!mBirthStr.equals("")) {
				mBirth = Date.valueOf(mBirthStr);
			}
			String mAddress = mRequest.getParameter("mAddress");
			
			MemberDao dao = MemberDao.getInstance();
			// ID 중복 체크
			int result = dao.mIdChk(mId);
			if(result==MemberDao.NONEXIST) {
				// 회원가입 진행
				MemberDto dto = new MemberDto(mId, mPw, mName, mEmail, mPhoto, mBirth, mAddress, null);
				result = dao.join(dto);
				if(result==MemberDao.SUCCESS) {
					HttpSession session = request.getSession();
					session.setAttribute("mId", mId); // 회원가입 성공하면, mId 정보를 세션에 담아두자. (담은채로 login 페이지 넘어가기 위함)
 					request.setAttribute("joinResult", "회원가입이 완료되었습니다.");
				}else {
					request.setAttribute("errorMsg", "회원가입이 실패되었습니다.");
				}
			}else {
				request.setAttribute("errorMsg", "중복된 ID로 회원가입 불가합니다.");
			}
			// 회원가입 (dto로)
			
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} 
		// 업로드된 파일을 소스 폴더로 복사
		File serverFile = new File(path+"/"+mPhoto);
		if(!mPhoto.contentEquals("NOIMG.JPG") && serverFile.exists()) { // 노이미지면 굳이 소스폴더에 또 복사할 필요가 음슴.
			InputStream is = null;
			OutputStream os = null;
			try {
				is = new FileInputStream(serverFile);
				os = new FileOutputStream("D:/mega_IT/source/6_jsp/ch19_mvc03member/WebContent/memberPhoto/"+mPhoto);
				byte[] bs = new byte[(int)serverFile.length()];
				while(true) {
					int readByteCnt = is.read(bs);
					if(readByteCnt == -1) break;
					os.write(bs, 0, readByteCnt);
				}
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}finally {
				try {
					if(os!=null) os.close();
					if(is!=null) is.close();
				}catch(Exception e) {
					
				}
			}
		}

	}

}
