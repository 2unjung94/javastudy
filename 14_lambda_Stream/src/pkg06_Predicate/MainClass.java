package pkg06_Predicate;

import java.util.function.Predicate;

public class MainClass {

  /*
   * java.util.function.Predicate
   * 
   * ** 조건식에서 사용된다
   * 1. 형식 (return type 은 boolean 지정되어 있다)
   *  public Interface Predicate<T> { 
   *    boolean test(T t);
   *  }
   *  
   * 2. 파라미터 O, 반환 boolean 형식으로 test() 메소드 지원하는 함수형 인터페이스이다.
   */
  
  public static void method1() {
    
    Predicate<Integer> isEvenNumber = (number) -> number % 2 == 0;
    if(isEvenNumber.test(10)) {
      System.out.println("짝수");
    }else {
      System.out.println("홀수");
    }
    
  }
  
  public static void method2(Predicate<Integer> predicate, int number) {
    
    if(predicate.test(number)) {
      System.out.println("짝수");
    } else {
      System.out.println("홀수");
    }
    
  }
  
  public static void main(String[] args) {
    method1();
    method2((number) -> number % 2 == 0, 5);

  }

}
