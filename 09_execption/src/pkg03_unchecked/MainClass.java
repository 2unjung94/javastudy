package pkg03_unchecked;

public class MainClass {

  public static void main(String[] args) {
    
    // unchecked exception : try - catch 문이 없어도 동작하는 예외 클래스로 RuntimeException 을 의미한다. (실행 해봐야 예외를 알 수 있는 것)
    
    int mok = 5 / 0;          // 0으로 나누면 ArithmeticException 예외처리 뜨고 종료됨
    System.out.println(mok);    
    
    
    
  }

}
