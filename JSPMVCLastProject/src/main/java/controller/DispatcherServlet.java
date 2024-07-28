package controller;

import java.io.IOException;
import java.lang.reflect.Method;
import java.io.*;
import java.net.URL;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 *  JSP 	DispatcherServlet	Model(여러개)
 *     ==== =================   ==========
 *      주문			서빙				주방
 *       			| Controller
 *       			  ==========
 *       			   주문을 받는다 
 *       			  ==== request
 *       			   주문 => 주방에 전달
 *       				음식
 *       				=> JSP로 전송
 *   MVC
 *   	= M(Model) => 요청을 처리해주는 모든 클래스의 집합
 *   					~VO, ~DAO, ~Manager, ~Service
 *   				=> 사용자로부터 요청을 받는다
 *   				   ============== request
 *   				=> 요청처리 => 결과값을 request에 담아주는 역할
 *   				=> 일반 자바
 *   	= V (View) => JSP => 전송받는 request를 출력하는 역할
 *   				  ==== 요청 전송, 데이터 출력 
 *   					   ====== <a> <form>, 자바 스크립트
 *   	= C (Controller) => 사용자 요청 => Model (요청처리) => 처리 결과를 가지고 온다
 *   					=> JSP 로 전송 (프레임 워크 : 기본 틀이 만들어져 있다)
 *   								  ======= Spring, 마이플레폼 (이미 라이브러리로 제작)
 *   									=> Controller를 직접 제작(포털사이트)
 *   **** 1. Controller
 *   		=========== 서빙 역할 (메뉴를 알고 있어야 한다)
 *   							=== Model
 *   							=== 누가 요청했는지 여부 => View
 *   **** 2. 클래스가 많으면 관리하기 어렵다 (검색 시간이 오래 걸린다)
 *   		===================== 클래스를 퇴대한 줄여서 사용
 *   						=> 관련된 내용을 메소드화 시켜야 한다 => 응집성↑
 *   **** 3. 메소드를 호출하려면
 *   		============= Controller 가 알고 있어야 한다
 *   **** 스프링 구조 : 라이브러리 (자바 파일)
 *   				=> 설정 파일 : XML, 구분자 : 어노테이션을 사용
 *   					=========== Spring-Boot
 *  
 */
import java.net.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<String>clsList=new ArrayList<String>();
	// ↑ application.xml => 클래스 등록 
	
	public void init(ServletConfig config) throws ServletException{
		try {
			URL url=this.getClass().getClassLoader().getResource("."); // .을 찍게되면 현재 경로 명을 가져온다
			// 경로명 읽기 => AWS => 리눅스 / 맥 (운영체제와 관련 없이 사용 가능하게 만드는 코드)
			File file=new File(url.toURI());
			System.out.println(file.getPath());
			String path=file.getPath();
			path=path.replace("\\", File.separator);
//										 ==========  리눅스, 맥 => /  윈도우 \\  시스템에 따라서 자동으로 /가 아니면 \\ 로 만들어주는 역할
			path=path.substring(0,path.lastIndexOf(File.separator));
			path=path+File.separator+"application.xml";
			
//			xml파싱
			DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
//			MyBatis 
			DocumentBuilder db=dbf.newDocumentBuilder(); // 파서기 => XML의 데이터 추출
//			파서된 데이터 저장
			Document doc=db.parse(new File(path));
			Element beans=doc.getDocumentElement(); // 루트 (테이블)
//			xml => 문서형 데이터 베이스
			NodeList list=beans.getElementsByTagName("bean");
			for(int i=0; i<list.getLength(); i++) {
				Element bean=(Element)list.item(i);
				String id=bean.getAttribute("id");
				String cls=bean.getAttribute("class");
				System.out.println(id+":"+cls);
				clsList.add(cls);
			}
			
			
		}catch(Exception ex) {}
		
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd=request.getRequestURI();
//		http://localhost:8080/      JSPMVCLastProject/*.do
//									이거시 URI
		cmd=cmd.substring(request.getContextPath().length()+1);
		try {
			for(String cls:clsList) {
				Class clsName=Class.forName(cls);
				Object obj=clsName.getDeclaredConstructor().newInstance();
				Method[] methods=clsName.getDeclaredMethods();
				for(Method m:methods) {
//					System.out.println(m.getName());
					RequestMapping rm=m.getAnnotation(RequestMapping.class);
					if(rm.value().equals(cmd)) { // rm.value =>
						String jsp=(String)m.invoke(obj, request,response);
//						찾은 메소드를 호출하라 => invoke 라는 함수
//						invoke => 메소드 명을 몰라도 호출이 가능하다
						if(jsp==null) { //void 일때 처리 => ajax(자바 스크립트 연동)
							return;
						}else if(jsp.startsWith("redirect")){
							//sendRedirect
							jsp=jsp.substring(jsp.indexOf(":")+1);
							response.sendRedirect(jsp);
						}else {
							//forward
							RequestDispatcher rd=request.getRequestDispatcher(jsp);
							rd.forward(request, response);
							
						}
						return;
					}
				}
			}
		}catch(Exception ex) {}
	}

}









