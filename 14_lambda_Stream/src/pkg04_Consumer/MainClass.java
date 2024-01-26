package pkg04_Consumer;

import java.util.function.Consumer;

public class MainClass {

  /*
   * java.util.function.Consumer
   * 
   * 1. 형식
   *  public Interface Consumer<T> {
   *    void accept(T t);
   *  }
   * 2. 파라미터 O, 반환타입 X 형식으로 accept() 메소드 지원하는 함수형 인터페이스이다.
   */
  
  public static void method1() {
    Consumer<String> consumer = (name) -> System.out.println(name + "님");   // () 안에는 변수 이름이라 내가 쓰고싶은 이름 쓴다.
    consumer.accept("tom");
  }
  
  public static void method2(Consumer<String> consumer) {     
    consumer.accept("john");
    
  }
  
  public static void main(String[] args) {
    method1();
    method2( (name) -> System.out.println(name + "님") );

  }

}
