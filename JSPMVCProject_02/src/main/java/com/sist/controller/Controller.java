package com.sist.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sist.model.*;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;

@WebServlet("*.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Map clsMap=new HashMap();

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
//		clsMap.put("list.do", new ListModel());
//		clsMap.put("insert.do", new InsertModel());
//		clsMap.put("update.do", new UpdateModel());
//		clsMap.put("delete.do", new DeleteModel());
		try {
			DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
			DocumentBuilder db=dbf.newDocumentBuilder();
			// 파서기 => 파서 (XML,HTML,JSON) => 데이터를 추출
			Document doc=db.parse(new File("C:\\webDev\\wedStudy\\JSPMVCProject_2\\src\\main\\webapp\\WEB-INF\\application.xml"));
			// 루트 읽기
			Element root=doc.getDocumentElement();
			System.out.println("root:"+root.getTagName());
			// 같은 태그를 묶어서 제어
			NodeList list=root.getElementsByTagName("bean"); // bean 태그를 다 묶어서 List 로 만듦
			for(int i=0; i<list.getLength();i++) {
				Element bean=(Element)list.item(i);
				String id=bean.getAttribute("id");
				String cls=bean.getAttribute("class");
				System.out.println(id+":"+cls);
				Class clsName=Class.forName(cls);
//				Object obj=clsName
			}
		}catch(Exception ex) {
			
		}
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cmd=request.getRequestURI();
//		http://localhost:8080/JSPMVCProject_2/*.do  <= 실행시 주소
//		JSPMVCProject_2/*.do   <= uri
		cmd=cmd.substring(request.getContextPath().length()+1);
		
		Model model=(Model)clsMap.get(cmd);
		String jsp=model.execute(request);
		
		RequestDispatcher rd=request.getRequestDispatcher(jsp);
		rd.forward(request, response);
	}

}




