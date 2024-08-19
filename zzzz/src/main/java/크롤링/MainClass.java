package 크롤링;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sist.dao.AlbumDAO;
import com.sist.vo.AlbumVO;

public class MainClass {

    public static void main(String[] args) {
        MainClass mc = new MainClass();
        mc.albumData();
    }

    public void albumData() {
        AlbumDAO dao = AlbumDAO.newInstance();

        try {
            int k = 1;
            for (int i = 0; i <= 10; i++) {
                String url = "https://www.yes24.com/24/Category/More/003001001?ElemNo=89&ElemSeq=" + i;
                Document doc = Jsoup.connect(url).get();
                Elements links = doc.select("ul > li > div > p > span > span > a");

                for (int j = 0; j < links.size(); j++) {
                    try {
                        System.out.println("상품 번호 :" + k);
                        k++;
                        String detailUrl = "https://www.yes24.com" + links.get(j).attr("href");
                        Document doc2 = Jsoup.connect(detailUrl).get();

                        // 데이터 추출
                        Element APHOTO = doc2.selectFirst("div.topColLft > div > span > em.imgBdr > img");
                        if (APHOTO != null) {
                            System.out.println("APHOTO: " + APHOTO.attr("src"));
                        } else {
                            System.out.println(" ");
                        }

                        Element ANAME = doc2.selectFirst("div.topColRgt > div.gd_infoTop > div.gd_titArea > h2");
                        if (ANAME != null) {
                            System.out.println("ANAME: " + ANAME.text());
                        } else {
                            System.out.println(" ");
                        }

                        Element AARTIST = doc2.selectFirst("div.topColRgt > div.gd_infoTop > span.gd_pubArea > span.gd_auth > a");
                        if (AARTIST != null) {
                            System.out.println("AARTIST: " + AARTIST.text());
                        } else {
                            System.out.println(" ");
                        }

                        Element ARDATE = doc2.selectFirst("div.topColRgt > div.gd_infoTop > span.gd_pubArea > span.gd_date");
                        if (ARDATE != null) {
                            System.out.println("ARDATE: " + ARDATE.text());
                        } else {
                            System.out.println(" ");
                        }

                        Element APRICE = doc2.selectFirst("div.topColRgt > div.gd_infoBot > div.gd_infoTbArea > div:nth-child(3) > table > tbody > tr:nth-child(1) > td > span > em");
                        if (APRICE != null) {
                            System.out.println("APPRICE: " + APRICE.text());
                        } else {
                            System.out.println(" ");
                        }

                        Element ADISPRICE = doc2.selectFirst("div.topColRgt > div.gd_infoBot > div.gd_infoTbArea > div:nth-child(3) > table > tbody > tr.accentRow > td > span.nor_price > em");
                        if (ADISPRICE != null) {
                            System.out.println("ADISPRICE: " + ADISPRICE.text());
                        } else {
                            System.out.println(" ");
                        }

                        Element ADETAIL = doc2.selectFirst("div.infoSetCont_wrap > div.infoWrap_txt > textarea.txtContentText");
                        if (ADETAIL != null) {
                            System.out.println("ADETAIL: " + ADETAIL.text());
                        } else {
                            System.out.println(" ");
                        }

                        Element AIMG = doc2.selectFirst("div.infoSetCont_wrap > div.infoWrap_txt > img");
                        if (AIMG != null) {
                            System.out.println("AIMG: " + AIMG.attr("src"));
                        } else {
                            System.out.println(" ");
                        }

                        System.out.println("===================================================================");

                        AlbumVO vo = new AlbumVO();

                        vo.setAphoto(APHOTO != null ? APHOTO.attr("src") : "");
                        vo.setAname(ANAME != null ? ANAME.text() : "");
                        vo.setAartist(AARTIST != null ? AARTIST.text() : "");
                        vo.setArdate(ARDATE != null ? ARDATE.text() : "");
                        vo.setAprice(APRICE != null ? APRICE.text() : "");
                        vo.setAdisprice(ADISPRICE != null ? ADISPRICE.text() : "");
                        vo.setAdetail(ADETAIL != null ? ADETAIL.text() : "");
                        vo.setAimg(AIMG != null ? AIMG.attr("src") : "");

                        dao.albumInsert(vo);
                        Thread.sleep(3000);

                    } catch (Exception ex) {
                        System.out.println("Error while processing detail page for product " + k);
                        ex.printStackTrace();
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println("error");
            ex.printStackTrace();
        }
    }
}
