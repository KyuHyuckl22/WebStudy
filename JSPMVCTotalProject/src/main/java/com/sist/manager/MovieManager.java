package com.sist.manager;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.*;
import org.jsoup.nodes.Document;
public class MovieManager {
	public static void main(String[] args) {
		MovieManager m=new MovieManager();
		m.movieListData(1);
	}
	public List<MovieVO> movieListData(int type){
		String[] strUrl= {
			"",
			"https://www.kobis.or.kr/kobis/business/main/searchMainDailyBoxOffice.do",
			"https://www.kobis.or.kr/kobis/business/main/searchMainRealTicket.do",
			"https://www.kobis.or.kr/kobis/business/main/searchMainDailySeatTicket.do"
		};
		List<MovieVO>list=new ArrayList<MovieVO>();
		try {
			Document doc=Jsoup.connect(strUrl[type]).get();
			String json=doc.toString();
			json=json.substring(json.indexOf("["),json.lastIndexOf("]")+1);
			JSONParser jp=new JSONParser();
//			[] 로 시작 Array  {} 로 시작 List
			JSONArray arr=(JSONArray)jp.parse(json);
//			System.out.println(arr);
			for(int i=0;i<arr.size();i++) {
				JSONObject obj=(JSONObject)arr.get(i);
//				System.out.println(obj);
//				System.out.println("=====================");
				MovieVO vo=new MovieVO();
				vo.setRank(i+1);
				String poster=(String)obj.get("thumbUrl");
				vo.setPoster("https://www.kobis.or.kr"+poster);
				String title=(String)obj.get("movieNm");
				System.out.println((i+1)+"."+title);
				vo.setTitle(title);
				String genre=(String)obj.get("genre");
				vo.setGenre(genre);
				String director=(String)obj.get("director");
				vo.setDirector(director);
				String grade=(String)obj.get("watchGradeNm");
				vo.setGrade(grade);
				
				list.add(vo);
			}
			
		}catch(Exception ex) {}
		return list;
	}
}









