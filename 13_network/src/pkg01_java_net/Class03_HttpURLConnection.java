package pkg01_java_net;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Class03_HttpURLConnection {
  
  public static void main(String[] args) {
  
    String spec = "https://www.naver.com/";
    
    // try, finally 블록 안에서 사용해야 하므로 메인에서 선언
    URL url = null;
    HttpURLConnection con = null;   // connection 만들때 IOException 예외 발생
    
    try {
      
      /* 용어 위주로 공부할 것 코드가 중요한게 아님!*/
      
      url = new URL(spec);
      con = (HttpURLConnection)url.openConnection(); // 부모 -> 자식이므로 다운캐스팅. 강제캐스팅 필요함
      
      /*
       * 접속 상태 확인 (HTTP Response Code : 응답 코드)
       * 1. 200( = HttpURLConnection.HTTP_OK) : 정상 
       * 2. 4xx : 요청 문제 (클라이언트 문제)
       * 3. 5xx : 서버 문제
       * 
       * 응답 : 서버가 클라이언트에게 보냄 (서버 -> 클라이언트)
       * 요청 : 클라이언트가 서버에게 보냄 (서버 <- 클라이언트)
       */
      
      int responseCode = con.getResponseCode();
      if(responseCode == HttpURLConnection.HTTP_OK) {
        System.out.println("정상 접속");
      }else {
        System.out.println("접속 불가");
      }
      
      /*
       * Content-Type
       * 1. 컨텐트 타입
       * 2. 종류
       *    1) 문서 타입 : text/xxx
       *    2) 이미지 타입 : image/xxx
       *    3) 데이터 타입 : application/xxx
       */
      String contentType = con.getContentType();
      System.out.println(contentType);
      
      /*
       * 요청 메소드(Request Method, 요청 방법)
       * 1. GET  : 주소창(URL)을 이용한 요청. 기본 요청 방식. (ex. 검색)
       * 2. POST : 본문(Body)을 이용한 요청                   (ex. 로그인(아이디 비밀번호는 주소창에 노출되면 안되니까))
       */
      
      String requestMetnod = con.getRequestMethod();
      System.out.println(requestMetnod);
      
      /*
       * 요청 헤더
       * 1. 요청 정보가 저장된다.
       * 2. 종류
       *    1) User-Agent     : 무엇으로 접속하였는지에 관한 정보 (ex. 자바로 접속했다면 자바, 크롬으로 접속했다면 크롬 등등)
       *    2) Referer        : 지급 접속 주소의 이전 접속 주소 정보
       *    3) Content-Type   : 컨텐트 타입
       *    4) Content-Length : 컨텐트 크기
       */
      // Map<String, List<String>> requestHeader = con.getRequestProperties();
      // for(Entry<String, List<String>> entry : requestHeader.entrySet()) {
      // System.out.println(entry.getKey() + " : " + entry.getValue());
      // }
      
      String userAgent = con.getRequestProperty("User-Agent");
      System.out.println(userAgent);
      String referer = con.getRequestProperty("Referer");
      System.out.println(referer);
      
      
    } catch (MalformedURLException e) {     // 자식
      e.printStackTrace();
    } catch (IOException e) {     // 부모
      e.printStackTrace();
    } finally {           // 접속 해제 (필수로 작성 할 것).
      if(con != null) {        
        con.disconnect();
      }
      
    }
    
  }
  
}
