package pkg02_open_api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;

public class MainClass {

  public static void main(String[] args) {
    
   StringBuilder builder = new StringBuilder();
   
   // api 요청주소
   builder.append("http://apis.data.go.kr/B552061/AccidentDeath/getRestTrafficAccidentDeath");
   // ? 로 시작
   builder.append("?serviceKey=").append("D9%2BEupTMLVNVGCAVyrIODMgBtnnBNGT%2BUP6J6JHCfeKQeVjX%2Fm%2B29Uicpg%2Fn2j7rLSAfSEAKU5htKfxtLuBwNw%3D%3D");
   // & 로 연결
   builder.append("&searchYear=").append(2022);
   builder.append("&siDo=").append(2300);
   builder.append("&guGun=").append(2304);
   builder.append("&type=").append("json");
   builder.append("&numOfRows=").append(20);
   builder.append("&pageNo=").append(1);
   
   String src = builder.toString();
   
   // url, con 선언
   URL url = null;
   HttpURLConnection con = null;
   
   // 입력스트림 선언
   BufferedReader in = null;
   
   try {
     
     url = new URL(src);
     con = (HttpURLConnection) url.openConnection();
    
     if(con.getResponseCode() != HttpURLConnection.HTTP_OK) {
       throw new RuntimeException("api 접속 실패");
     }
     
     in = new BufferedReader(new InputStreamReader(con.getInputStream()));
     
     StringBuilder builder2 = new StringBuilder();
     String readJson = null;
     
     while((readJson = in.readLine()) != null) {
       builder2.append(readJson);
     }
     
     System.out.println(builder2.toString());
     
     in.close();
     
  } catch (Exception e) {
    e.printStackTrace();
  } finally {
    if(con != null) {
      con.disconnect();
    }
  }
  
   
    
  }

}
