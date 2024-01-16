package pkg04_checked;

import java.net.MalformedURLException;
import java.net.URL;

public class MainClass {

  public static void main(String[] args) {
 
    // checked exception : try - catch 와 같은 예외 처리 코드가 없으면 동작하지 않는 예외이다.
    // ppt 08에서 패키지와 import 부분 볼 것
    
    try {
      URL url = new URL("https://www.google.com/");   // 클래스 이름은 ctrl + space 사용해서 입력하는 걸 습관 들여라
      
    } catch (MalformedURLException e) {
      System.out.println("잘못된 URL입니다.");
    }
    
    
  }

}
