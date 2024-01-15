package pkg02_interface;

// interface는 abstract class 와 유사하다
/*
 * 인터페이스(interface)
 * 1. public final static 상수만 선언할 수 있다.
 *    -> public final static 은 생략할 수 있다.
 * 2. public abstract 추상 메소드만 선언할 수 있다.
 *    -> public abstract 는 생략할 수 있다.
 * 3. jdk 1.8 이후로 추가된 메소드
 *    1) 디폴트 메소드 
 *      public default 반환타입 메소드이름(매개변수) { 본문 };
 *    2) 클래스 메소드
 *      public static 반환타입 메소드이름(매개변수) { 본문 };
 * ** 생성자가 없다. -> 객체로 만들 이유가 없기 때문.
 * ** 실무에서 인터페이스는 작업 지시서 같은 역할을 한다.
 */

public interface Shape {
  
  // 상수
  /* public final static */ double PI = 3.141592;
  
  // 추상 메소드
  /* public abstract */ double getArea();
  /* public abstract */ double getCircum();
  
  // 디폴트 메소드
  public default void whoami(String name) {
    System.out.println("디폴트 메소드로 호출 : " + name);
  }
  
  // 클래스 메소드
  public static void whoami2(String name) {
    System.out.println("클래스 메소드로 호출 : " + name);
  }

}
