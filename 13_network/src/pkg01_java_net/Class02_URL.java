package pkg01_java_net;

import java.net.MalformedURLException;
import java.net.URL;

public class Class02_URL {

  public static void main(String[] args) {
    
    try {
      
      URL url = new URL("https://www.example.com:9090/webtoon/list?page=1&id=100#memo");    // 주소는 공백 없이 작성할 것
      
      System.out.println(url.getProtocol());
      System.out.println(url.getHost());
      System.out.println(url.getPort());
      System.out.println(url.getPath());
      System.out.println(url.getQuery());
      System.out.println(url.getFile()); // File = path + query
      System.out.println(url.getRef());
      
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }

  }

}
