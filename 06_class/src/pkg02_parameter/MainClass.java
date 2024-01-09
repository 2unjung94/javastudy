package pkg02_parameter;

public class MainClass {

  public static void main(String[] args) {
    
    // 객체 선언 및 생성
    Calculator calculator = new Calculator();
    
    // 메소드 호출
    // 호출과 정의는 같이 볼 것.
    
    // 인자값, 파라미터값이 없을 때
    calculator.method1();
    
    // 인자값(int, String, double)
    int a = 10;
    calculator.method2(a);    
    calculator.method3("hello world");    
    calculator.method4(1.5, 1.2);
    
    // 넘긴걸 또 넘기기
    calculator.method5(a);
    
    // 가변 인자. 동일 타입이지만 개수를 모를때. 받을 때 배열로 받음
    calculator.method6(1);
    calculator.method6(1, 2);
    calculator.method6(1, 2, 3);
    
    // 배열 인자
    // int[] arr = {10, 20, 30}; -> 
    // calculator.method7(arr);
    
    // 배열 선언이 없을 때 오류남. new를 붙여야 함
    // calculator.method7({10, 20, 30}); -> 오류. { }는 선언때만 사용되는 문법임
    calculator.method7(new int[] {10, 20, 30});
    
    // 객체 인자
    // 1. Adder 타입의 adder 객체를 전달
    // Adder adder = new Adder();
    // calculator.method8(adder);
    
    // 2. Adder 타입의 객체를 전달
    // 받는쪽 = 주는쪽이 말이 되면 ok. 즉, Adder adder = new Adder()
    calculator.method8(new Adder());
  }

}