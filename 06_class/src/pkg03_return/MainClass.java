package pkg03_return;

public class MainClass {

  public static void main(String[] args) {
    
    // Calculator 타입의 calculator 객체 선언 및 생성
    Calculator calculator = new Calculator();
   
    // 반환값의 잘못된 호출이라고 볼 수 있음.
    calculator.method1();   // 이걸 실행하고 나면 호출 코드는 없어지고 10;이 온다 생각해라.
                            
    // 반환값의 호출 예시
    // 반환값이 있는 경우 이 반환값을 사용할 수 있는 코드가 필요하다.
    System.out.println(calculator.method1()); 
    System.out.println(calculator.method1() == 10 ? "10이다" : "10이아니다");
    int a = calculator.method1();
    System.out.println(a);
    
    // int[] 반환 받기
    int[] arr = calculator.method2();
    for(int n : arr) {
      System.out.println(n);
    }
    
    
    for(int n : calculator.method2()) {
      System.out.println(n);      
    } // 위 for문과 동일함.
    
    //Adder 객체 반환 받기
    System.out.println(calculator.method3().add(1, 2, 3)); // 1. calculator.method3() -> new Adder
                                                           // 2. (new Adder).add(1, 2, 3) 로 바뀐다 생각.
                                                           // 3. 결과 6 반환
                                                           // 앞에서부터 볼 것.
  }
  
}
