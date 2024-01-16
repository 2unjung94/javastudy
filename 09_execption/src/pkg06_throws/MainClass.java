package pkg06_throws;

// 메소드를 호출한 곳으로 예외를 던짐
public class MainClass {

  public static void main(String[] args) {
    
    int a = 5;
    int b = 0;
    
    try {
      Calculator calculator = new Calculator();
      calculator.addition(a, b);
      calculator.subtraction(a, b);
      calculator.multiplication(a, b);
      calculator.division(a, b);      // 여기서 예외 발생(throws 로 던진걸 받았기 때문).  
    } catch (ArithmeticException e) { // catch 가 위 예외를 받음
      System.out.println("산술 연산 예외가 발생했습니다.");
    }

  }

}
