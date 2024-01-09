package pkg03_return;

public class Calculator {

  // 반환값(return value) : 메소드 실행 결과값
  // void                 : 반환값이 없음
  // 반환값은 무조건 하나여야함. 따라서 배열이나 객체로 반환.
  
  
  // int 반환 메소드
  int method1() {
   return 10;        // return 다음에 값은 반환 타입과 일치 시킬 것
  }
  
  // 배열 반환 메소드 - 값을 2개 이상 반환하기
  int[] method2() {
    // int[] arr = {10, 20}; return arr;
    
    return new int[] {10, 20};
  }
  
  //Adder 타입 객체 반환 메소드
  Adder method3() {
    //Adder adder = new Adder(); return adder;
    return new Adder();
  }
  
  
  
}
