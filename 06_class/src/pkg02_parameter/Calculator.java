package pkg02_parameter;
// 메소드(method) : 클래스 내부에 작성한 함수(function)

public class Calculator {
  
  /*
   * 메소드의 구성
   * 1. 반환타입 : 메소드의 실행 결과 값의 타입
   * 2. 메소드명
   * 3. 매개변수 : parameter 라고 함. 메소드로 전달되는 값(인수, 인자, argument)
   */
  
  /**
   *  @param  파라미터
   *  @return 반환값
   *  annotation
   */
  
  // 파라미터가 없는 메소드
  void method1() {
    System.out.println("method1");
  }
  
  // 파라미터는 형변환 규칙에 어긋나지 않으면 받을 수 있다
  // 파라미터의 이름은 인자값과 같은것이 권장된다.
  void method2(int a) {
   System.out.println("method2 : " + a);
  }
  
  void method3(String s) {
    System.out.println("method3 : " + s);
  }
  
  void method4(double a, double b) {
    System.out.println("method4 : " + a + ", " + b);
  }
  
  void method5(int a) {
    method5_2(a);
  }
  
  // 기능별로 나눠서 메소드 구현. 메소드에서 메소드에게 주는걸 많이 쓸 예정
  void method5_2(int a) {
    System.out.println("method5 : " + a);
    
  }
  
  // 가변 매개변수로 구현은 거의 안하지만, 뜻은 알고 있을 것. 해석이 필요할 때가 있음
  void method6(int... params) {  // params 는 사실 배열임
    System.out.println("method6");
    for(int i = 0; i < params.length; i++) {
      System.out.println(params[i]);
    }
  }
  
  void method7(int[] arr) {
    System.out.println("method7");
    for(int a : arr) {
      System.out.println(a);
    }  
  }
  
  // 객체 매개변수
  void method8(Adder adder) {
    System.out.println("method8");
    adder.add(1, 2, 3);
  }  
}
