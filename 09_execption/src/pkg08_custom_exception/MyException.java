package pkg08_custom_exception;

/*
 * 사용자 예외 클래스
 * 1. java.lang.Exception 클래스를 상속한다.
 * 2. 클래스명은 Exception 으로 끝나는 것이 좋다.
 * 3. 예외 타입을 만든다 라는 뜻으로 생각해라.
 * 4. 예외 코드까지 저장하고 관리하고 싶을 때
 */

public class MyException extends Exception {
  
  // field
  private int errorCode;
  
  // constructor
  public MyException(String message, int errorCode) {
    super(message);   // public Exception(String message) { } 생성자 호출. 부모클래스인 Exception 생성자에 message 전달
    this.errorCode = errorCode;
    
  }

  // method
  public int getErrorCode() {
    return errorCode;
  }
  public void setErrorCode(int errorCode) {
    this.errorCode = errorCode;
  }
  
}
