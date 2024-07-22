package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import com.sist.dao.*;
import java.util.*;

public class EmpModel {
	public void empListData(HttpServletRequest request) {
		EmpDAO dao=EmpDAO.newInstance();
		List<EmpVO> list=dao.empListData();
		request.setAttribute("list", list);
	}
}
