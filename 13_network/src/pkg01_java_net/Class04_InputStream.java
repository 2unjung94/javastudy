package pkg01_java_net;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Class04_InputStream {

  public static void method1() {
    
    String spec = "https://www.google.com/";
    URL url = null;
    HttpURLConnection con = null;
    
    BufferedReader in = null;
    
    try {
      url = new URL(spec);
      con = (HttpURLConnection) url.openConnection();
      
      if(con.getResponseCode() != HttpURLConnection.HTTP_OK) {
        throw new RuntimeException(spec + " 접속 불가");
      }
      
      in = new BufferedReader(new InputStreamReader(con.getInputStream()));
      
      String line = null;
      StringBuilder builder = new StringBuilder();
      
      while((line = in.readLine()) != null) {
        builder.append(line).append("\n");
      }
          
      System.out.println(builder.toString());
    
      in.close();
    
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if(con != null) {
        con.disconnect();
      }
    }

  }

  public static void method2() {
    
   String src = "https://s.pstatic.net/static/www/mobile/edit/20240110_1095/upload_17048514254674MZPF.png";
   
   // URL, Connection 선언
   URL url = null;
   HttpURLConnection con = null;
   
   // byte단위 bufferedInput, Output 선언
   BufferedInputStream in = null;
   BufferedOutputStream out = null;
   
   try {
     
     // url, con 생성
     url = new URL(src);
     con = (HttpURLConnection) url.openConnection();
     
     // 예외 처리
     if(con.getResponseCode() != HttpURLConnection.HTTP_OK) {
       throw new RuntimeException("접속 불가");
     }
     
     // file 생성
     File dir = new File("\\storage");
     if(!dir.exists()) {
       dir.mkdirs();
     }
     File png = new File(dir, "sample.png");
     
     // buffered 생성
     in = new BufferedInputStream(con.getInputStream());
     out = new BufferedOutputStream(new FileOutputStream(png));
     
     // 읽는 단위
     byte[] bytes = new byte[10];
     int readByte = 0;
     
     // 읽기
     while((readByte = in.read(bytes)) != -1) {
       out.write(bytes, 0, readByte);
     }
     out.close();
     in.close();
     
    
  } catch (Exception e) {
    e.printStackTrace();
  } finally {
    con.disconnect();
  }
  }
    
  
  public static void main(String[] args) {
    method2();
    
  }
}
