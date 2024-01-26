package pkg03_Supplier;

import java.util.function.Supplier;

public class MainClass {

  /*
   * java.util.function.Supplier
   * 1. 형식
   *    public interface Supplier<T> {
   *      T get();
   *    }
   * 2. 파라미터 X, 반환타입 O 형식으로 get() 메소드 지원하는 함수형 인터페이스이다.
   */
  
  
  public static void method1() {
    
    Supplier<String> supplier = () -> "hello world";
    System.out.println(supplier.get());
    
  }
  
  public static void method2(Supplier<String> supplier) {   // 매개변수 Supplier 로 지정
    System.out.println(supplier.get());
  }
  
  public static void method3(Supplier<Integer> supplier) {  // 람다형 매개변수 사용하는 연습 많이 할 것!
    System.out.println(supplier.get());
  }
  
  public static void main(String[] args) {
    
    //method1();
    
    method2( () -> "hello world" );     // 람다 형식으로 매개변수 전달
    
    // 호출할때마다 1 ~ 10 사이 난수를 출력하는 method3
    method3( () -> (int)(Math.random() * 10 + 1) );
    
  }

}
