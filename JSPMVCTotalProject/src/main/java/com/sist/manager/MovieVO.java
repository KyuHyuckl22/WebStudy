package com.sist.manager;

import lombok.Data;

/*
 * "thumbUrl":"/common/mast/movie/2024/07/thumb/thn_8b6e20a95bc6477e88dc0d42f255539b.jpg",
 * "movieNm":"데드풀과 울버린",
 * "synop":null,"prdtYear":"2024",
 * "indieYn":null,"artmovieYn":null,
 * "multmovieYn":null,"showTm":"127",
 * "showTs":"45","director":"숀 레비",
 * "prNm":null,"dtNm":"월트디즈니컴퍼니코리아 유한책임회사",
 * "repNationCd":"미국","movieType":"장편",
 * "moviePrdtStat":"개봉","genre":"액션,코미디,SF",
 * "watchGradeNm":"청소년관람불가",
 * "openDt":"20240724",
 * "salesAmt":1344260878,
 * "audiCnt":131638,
 * "totalSalesAmt":3729057175,
 * "totalAudiCnt":363408,
 * "scrCnt":1908,
 * "showCnt":8053,
 * "rank":1,
 */
@Data
public class MovieVO {
	private String poster,title,director,genre,grade,story;
	private int rank;
}







