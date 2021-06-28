package org.zerock.test;

import org.jsoup.Jsoup;
import org.jsoup.helper.HttpConnection;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.ElementType;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;


public class SimpleTest {

    @Test //테스트 실행
    public void test1()throws Exception{
        System.out.println("Test1................");
        //jsoup로 크롤링할 링크 붙이기
        Document doc = Jsoup.connect("https://comic.naver.com/bestChallenge/list.nhn?titleId=701701").get();
        //출력해보기
        System.out.println(doc);

        //원하는 속성들 적어서 엘리멘트 잡기
        Elements tds= doc.select(".viewList td img");

        //잡은 엘리먼트마다 원하는 속성을 출력해보기
        tds.forEach(element ->{
          String imgURL = element.attr("src");
          System.out.println(imgURL);
          String title = element.attr("title");
          System.out.println(title);
        });
    }

    @Test
    //bad code
    public void testSave() throws Exception{
        //실제 이미지 경로
        String path= "https://postfiles.pstatic.net/MjAyMTA2MDFfMSAg/MDAxNjIyNTUxNTQwMDE2.Ki_nnS84jMjSJ9GJLWMj5thZ6xR3j0LnyT2bpJeNEMAg.Ul3E2xXhmfbQHYq0wG0ifhWimHE0ga4GyvzxFxCbgAwg.JPEG.gtwoney/SE-b1f367a6-ada2-4385-899c-c74a01528f02.jpg?type=w966";

        URL url = new URL(path);

        //read 이미지 읽기
        InputStream in = url.openStream();

        //이미지 출력(기존 OutputStream으로 작성함)
        File fos = new File("C:\\Users\\AIA\\Desktop\\downloadhae\\34532ds.jpg");

        Files.copy(in, fos.toPath());
    }

    @Test
    public void test2() throws Exception{
        String path="https://postfiles.pstatic.net/MjAyMTA2MDFfMSAg/MDAxNjIyNTUxNTQwMDE2.Ki_nnS84jMjSJ9GJLWMj5thZ6xR3j0LnyT2bpJeNEMAg.Ul3E2xXhmfbQHYq0wG0ifhWimHE0ga4GyvzxFxCbgAwg.JPEG.gtwoney/SE-b1f367a6-ada2-4385-899c-c74a01528f02.jpg?type=w966";

        URL url = new URL(path);

        InputStream in = url.openStream();

        File file = new File("C:\\Users\\AIA\\Desktop\\downloadhae\\sample.jpg");

        Files.copy(in, file.toPath());

    }

    @Test
    public void test3()throws Exception{
        String path="https://vsl.play.kakao.com/vod/rv6vphvgs2l2vl4og2ffspwi6/mp4/mp4/seeking.mp4";
        URL url = new URL(path);
        InputStream in = url.openStream();
        File fos = new File("C:\\Users\\AIA\\Desktop\\downloadhae\\cc.mp4");
        Files.copy(in, fos.toPath());
    }
    
    //권한 403으로 막힌 웹툰 이미지 카피하기
    @Test
    public void testSave2() throws Exception{
        String path = "https://image-comic.pstatic.net/nas/user_contents_data/challenge_comic/2021/06/28/fa3030/upload_3473738102062789987.jpeg";

        URL url = new URL(path);

        //경로 url커넥션
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        System.out.println(urlConnection);
        
        //스택오버플로우 복붙
        urlConnection.setDoOutput(true);
        urlConnection.setDoInput(true);
        urlConnection.setUseCaches(false);

        //유저 에이전트를 복사해서 붙여넣기
        urlConnection.setRequestProperty("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.272 Whale/2.9.118.16 Safari/537.36");

        urlConnection.getInputStream();

        InputStream in = urlConnection.getInputStream();

        File fos = new File("C:\\Users\\AIA\\Desktop\\downloadhae\\copy.jpg");
        Files.copy(in, fos.toPath());

    }


    //권한 403으로 막힌 웹툰 이미지 카피하기(연습함)
    @Test
    public void testSave3() throws Exception{
        String path = "https://image-comic.pstatic.net/webtoon/736989/84/20210511122033_f0cab2a87e85f67c02548a507970573c_IMAG01_1.jpg";

        URL url = new URL(path);

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        System.out.println(urlConnection);

        //스택오버플로우 복붙
        urlConnection.setDoOutput(true);
        urlConnection.setDoInput(true);
        urlConnection.setUseCaches(false);

        urlConnection.setRequestProperty("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.272 Whale/2.9.118.16 Safari/537.36");

        urlConnection.getInputStream();

        InputStream in = urlConnection.getInputStream();

        File fos = new File("C:\\Users\\AIA\\Desktop\\downloadhae\\copy2.jpg");
        Files.copy(in, fos.toPath());

    }

}
