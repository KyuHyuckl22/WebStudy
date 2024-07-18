<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*,java.io.*"%>
<%--
	사용자가 보내준 데이터를 받아서 처리후 다시 목록으로 이동
	// JSP : 입력값을 받아서 처리 ( 데이터베이스 처리 ) 이동
	// JSP : 브라우저에 화면을 출력 
 --%>    
 <%
 	request.setCharacterEncoding("UTF-8");
 	String path="c:\\upload";
 	// 폴더가 없는 경우에는 생성해라 ↓
 	try{
 		File dir=new File(path);
 		if (!dir.exists()){
 			dir.mkdir();
 		}
 	}catch(Exception ex){}
 	String euctype="UTF-8"; //한글 파일명일 경우 처리
 	int max=1024*1024*100; //파일의 최대 크기는 100MB
 	MultipartRequest mr=new MultipartRequest(request,path,max,euctype,
 						new DefaultFileRenamePolicy()); // 업로드시 사용
 	// 
 	String name=mr.getParameter("name");
 	String subject=mr.getParameter("subject");
 	String content=mr.getParameter("content");
 	String pwd=mr.getParameter("pwd");
 	String filename=mr.getFilesystemName("upload"); //첨부파일 name 과 일치해야 사용이 가능
 	DataBoardVO vo=new DataBoardVO();
 	vo.setName(name);
 	vo.setSubject(subject);
 	vo.setContent(content);
 	vo.setPwd(pwd);
 	if(filename==null){
 		vo.setFilename("");
 		vo.setFilesize(0);
 	}else{
 		File f=new File(path+"\\"+filename);
 		vo.setFilename(filename); //실제 저장된 파일 명
 		vo.setFilesize((int)f.length()); // 실제 크기
 		
 	}
 	
 	DataBoardDAO dao=DataBoardDAO.newInstanct();
 	dao.databoardInsert(vo);//데이터 베이스에 추가
 	
 	//dlehd
 	response.sendRedirect("list.jsp");
 	
 %>
 
 
 
 
 
 
