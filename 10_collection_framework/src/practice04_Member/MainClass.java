package practice04_Member;

import java.util.HashMap;
import java.util.Map;

public class MainClass {

  public static void main(String[] args) {

    // 임의의 정보를 가지는 Member 1명을 만들고, 정보 출력하기
    Map<String, Object> person1 = new HashMap<String, Object>();
    person1.put("주소", new Address("aaa", "bbb", "ccc", "ddd", "eee", true));
    person1.put("연락처", new Contact("01012345678", "01098765432"));
    
   
    System.out.println((Address)person1.get("주소"));
   
  }

}
