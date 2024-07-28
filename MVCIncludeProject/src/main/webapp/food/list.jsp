<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
.row{
   margin: 0px auto;
   width: 960px;
}
</style> -->
</head>
<body>
    <div class="row">
        <h3 class="text-center">맛집 리스트</h3>
        <table class="table">
            <tr>
                <th class="text-center">순위</th>
                <th class="text-center">이름</th>
                <th class="text-center"></th>
                <th class="text-center">업종</th>
                <th class="text-center">조회수</th>
            </tr>
            <c:forEach var="vo" items="${list}">
                <tr>
                    <td class="text-center">${vo.fno }</td>
                    <td class="text-center">${vo.name }</td>
                    <td class="text-center"><img src="${vo.poster }" style="width:30px; height:50px;"></td>
                    <td class="text-center">${vo.type }</td>
                    <td class="text-center">${vo.hit }</td>
                </tr>
            </c:forEach>
        </table>
        <table class="table">
            <tr>
                <td class="text-center">
                    <a href="../food/list.do?page=${curpage>1 ? curpage-1 : curpage}" class="btn btn-sm btn-success">이전</a>
                    ${curpage} page / ${totalpage} pages
                    <a href="../food/list.do?page=${curpage<totalpage ? curpage+1 : curpage}" class="btn btn-sm btn-success">다음</a>
                </td>
            </tr>
        </table>
    </div>
</body>
</html>
