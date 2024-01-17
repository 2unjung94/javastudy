package pkg05_HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*
 * HashMap
 * 1. 객체(인스턴스)를 대신할 수 있는 자료구조이다.
 * 2. 구성
 *    1) Key    : 데이터 식별자(identifier)(변수이름으로 이해해라), Set 으로 구성되어 있다. (순서 없고 중복 없다) 
 *    2) Value  : 데이터 자체(변수값으로 이해해라)
 *    3) Entry  : Key 와 Value 를 합쳐서 부르는 말이다. 
 *    4)   key  - value 
 *         age    10
 *        name    kim
 *        addr    seoul
 * 
 * Map = object 또는 Vo. 만능저장소. 실무에서 많이 쓰임(List<Map<K, V>> 형태로). 객체 대신 쓰임
 * 
 */
public class MainClass {
  
  // method 4 하나는 꼭 외워라
  
  public static void method1() {
    
    // Mutable 객체(Collection) (값이 변할 수 있는 객체) (new로 생성)
    
    // HashMap 선언
    Map<String, Object> book;   // Key 는 String, Value 는 Object 를 제일 많이 쓰인다.
    
    // HashMap 생성
    book = new HashMap<String, Object>(); 
    
    // Key, Value 추가 (Entry 추가) value 는 object 라 모든것이 다 저장 가능하다.
    book.put("title", "어린왕자");
    book.put("author", "생텍쥐베리");
    book.put("isBestseller", true);
    book.put("price", 10000);
    
    // Key 를 이용해 Value 확인하기
    System.out.println(book.get("title"));
    System.out.println(book.get("author"));
    
    // book.get("isBestseller") 여기를 boolean 이 아니라 Object 로 알고 있기 때문에 boolean 으로 캐스팅 해야함
    System.out.println((boolean)book.get("isBestseller") ?  "베스트셀러" : "일반서적"); 
    
    System.out.println(book.get("price"));
    
    
  }

  public static void method2() {
    
    // Immutable 객체(Collection) (값을 바꿀 수 없는 객체) (of()사용) (반환할 때 사용)
    
    Map<String, Object> map = Map.of("name", "홍길동");
    
    // 값을 바꾸려는 시도(추가, 삭제 둘다 안된다)
    // map.put("age", 10); 예외 발생
    
    System.out.println(map.get("name"));
    
  }
  
  public static void method3() {
    
    // Key 는 Set 으로 되어 있다.
    // Iterable<> : 반복문 돌릴 수 있는 -> Map<> 은 해당되지 않는다
   
    
    Map<String, Object> map = Map.of("name", "홍길동"
                                    , "age", 10
                                    , "isMarried", false);
    
    Set<String> keys = map.keySet(); // map 의 "name", "age", "isMarried" : 각 key 에 따른 value 출력
    for(String key : keys) {
      System.out.println(key + " : " + map.get(key));
    }
  }

  public static void method4() {
    
    // Entry 전체를 Set 으로 만들 수 있다.
    
    Map<String, Object> map = Map.of("name", "홍길동"
                                   , "age", 10
                                   , "isMarried", false);
    Set<Entry<String, Object>> entrySet = map.entrySet();
    for(Entry<String, Object> entry : entrySet) {
      System.out.println(entry.getKey() + " : " + entry.getValue());
    }
    
    
  }

  public static void method5() {
    
    // mutable (객체 또는 Collection) 생성
    Map<String, Object> map = new HashMap<String, Object>();
    
    // 처음 입력되는 Key 는 추가된다.
    map.put("name", "홍길동");
    map.put("age", 10);
    map.put("isMarried", false);
    
    // 다시 입력되는 Key 는 수정을 의미한다.
    map.put("age", 20);
    
    // 삭제
    map.remove("isMarried");
    
    System.out.println(map);
    
    
    
  }
  
  public static void main(String[] args) {
    method5();

  }

}
