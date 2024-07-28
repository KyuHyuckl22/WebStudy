package model;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.RequestMapping;
import service.*;
public class FoodModel {
	@RequestMapping("food/food_list.do") // 이 주소를 호출하면 이 메서드를 보여줘라 
	public String foodListData(HttpServletRequest request, HttpServletResponse response) {
		String msg="맛집 목록";
		request.setAttribute("msg", msg);
		return "food_list.jsp";
	}
	
	@RequestMapping("food/food_detail.do")
	public String foodDetailData(HttpServletRequest request, HttpServletResponse response) {
		String msg="맛집 상세보기";
		request.setAttribute("msg", msg);
		return "food_detail.jsp";
	}
	
	
	
}
